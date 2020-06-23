package com.microvideo.springboot_resource_analysis.domain;

import redis.clients.jedis.Jedis;

import java.util.Collections;

public class RedisPool {
    private static final String LOCK_SUCCESS="OK";
    private static final String SET_IF_NOT_EXIST="NX";
    private static final String SET_WITH_EXPIRE_TIME="PX";
    private static final Long RELEASE_SUCCESS=1L;
    
    /**
     * 获取分布式锁
     * @param jedis
     * @param lockKey
     * @param expireTime
     * @return
     */
    public static boolean getDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        if(LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;
        
    }
    /**
     * 释放分布式锁
     * @param jedis
     * @param lockKey
     * @param requestId
     * @return
     */
    public static boolean releaseDistributedLock(Jedis jedis,String lockKey,String requestId) {
        String script = "if redis.call('get',KEYS[1])== ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey),Collections.singletonList(requestId));
        if(RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
}