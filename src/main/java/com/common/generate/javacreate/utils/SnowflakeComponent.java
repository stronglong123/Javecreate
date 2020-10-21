package com.common.generate.javacreate.utils;

/**
 * @author Date: 2018/10/26
 * Time: 17:00:35
 */
public class SnowflakeComponent {

    private static long datacenterId = 0;

    private static long workId = 0;

    private SnowflakeComponent() {
    }

    private static class SnowflakeIdWorkerHandle {
        private static final SnowflakeIdWorker INSTANCE = new SnowflakeIdWorker(workId, datacenterId);
    }

    public static SnowflakeIdWorker getInstance() {
        return SnowflakeIdWorkerHandle.INSTANCE;
    }

}