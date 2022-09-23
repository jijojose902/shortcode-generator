package com.jijojose902.generator;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;
import cn.ipokerface.snowflake.SnowflakeIdGenerator;

public class ShortCodeGenerator {
    private long workerId;
    private long datacenterId;

    public ShortCodeGenerator(long workerId, long datacenterId) {
        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    public String generate() {
        SnowflakeIdGenerator generator = new SnowflakeIdGenerator(this.workerId, this.datacenterId);
        return Hashing.murmur3_32().hashString(String.valueOf(generator.nextId()), StandardCharsets.UTF_8).toString();
    }
}
