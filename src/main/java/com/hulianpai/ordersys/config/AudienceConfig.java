package com.hulianpai.ordersys.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Create with project ordersys
 *
 * @date 2020/12/16 15:50
 */
@Data
@ConfigurationProperties(prefix = "audience-config")
@Component
public class AudienceConfig {
    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}
