package com.hulianpai.ordersys.config;

import com.hulianpai.ordersys.util.SnowflakeIdWorker;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;

import java.util.Random;

/**
 * Created with ordersys.
 * Date: 2020/12/27.
 * Time: 5:33 下午.
 *
 */
@Configuration
public class UniqueIdGeneratorConfig {
    private static final SnowflakeIdWorker BASE_ROOT_ID_GENERATOR = new SnowflakeIdWorker(new Random().nextInt(32), 1);
    private static SnowflakeIdWorker ROOT_ID_GENERATOR;
    @Value("${spring.application.name:order-sys}")
    private String applicationName;
    @Value("${spring.redis.enable:true}")
    private boolean redisEnable;


    public static SnowflakeIdWorker rootIdGenerator() {
        return ObjectUtils.defaultIfNull(ROOT_ID_GENERATOR, BASE_ROOT_ID_GENERATOR);
    }

    @Bean
    public SnowflakeIdWorker rootUniqueIdGenerator(RedisConnectionFactory redisConnectionFactory) {
        long workerId;
        if (redisEnable) {
            RedisAtomicLong entityIdCounter = new RedisAtomicLong(
                    StringUtils.joinWith(":", applicationName, "unique_id_generator"),
                    redisConnectionFactory
            );
            workerId = entityIdCounter.addAndGet(1) % 32;
        } else {
            workerId = new Random().nextInt(32);
        }
        ROOT_ID_GENERATOR = new SnowflakeIdWorker(workerId, 1);
        return ROOT_ID_GENERATOR;
    }
}
