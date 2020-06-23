package com.microvideo.springboot_resource_analysis.constants;

/**
 * @Description: TODO
 * @Author: Hujm
 * @Date: Created in 15:22 2020/6/2
 * @Version: 1.0
 */
public class Const {

    public interface REDIS_LOCK{
        /**
         * 关闭订单的分布式锁
         */
        String CLOSE_ORDER_TASK_LOCK = "CLOSE_ORDER_TASK_LOCK";
    }
}
