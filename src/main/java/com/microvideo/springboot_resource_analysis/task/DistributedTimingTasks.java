package com.microvideo.springboot_resource_analysis.task;

import com.microvideo.springboot_resource_analysis.domain.RedisPool;
import com.microvideo.springboot_resource_analysis.domain.User;
import com.microvideo.springboot_resource_analysis.service.UserService;
import com.microvideo.springboot_resource_analysis.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*****
 * RedisConnection实现分布式锁
 */
@Component
@Slf4j
public class DistributedTimingTasks {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private UserService userService;

    String redisKey = "demo-RedisLockTest-isRun";

    //单位为秒  默认三分钟
    private long redis_default_expire_time = 30;


//    @Scheduled(cron = "0 */1 * * * ?")
    public void init() throws InterruptedException {


        //-------------上分布式锁开始-----------------

        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //获取本机ip
        String ip = addr.getHostAddress();
        //默认上锁时间为五小时
        //此key存放的值为任务执行的ip，
        // redis_default_expire_time 不能设置为永久，避免死锁
        boolean lock = redisUtils.tryLock(redisKey, ip, redis_default_expire_time);
        log.info("============本次聚类定时任务开始============");
        if (lock) {
            log.info("============获得分布式锁成功============");
            //TODO 开始执行任务 执行结束后需要释放锁
            run();
            //释放锁
            redisUtils.delete(redisKey);
            log.info("============释放分布式锁成功============");

        } else {
            log.info("============获得分布式锁失败============");
            ip = (String) redisUtils.get(redisKey);
            log.info("============{}机器上占用分布式锁，聚类任务正在执行============", ip);
            log.info("============本次聚类定时任务结束============");
            return;
        }
    }

    public void run() {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setAge(23);

        int rows = userService.addUser(user);
    }
}