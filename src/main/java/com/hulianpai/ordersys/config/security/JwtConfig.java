package com.hulianpai.ordersys.config.security;

import com.hulianpai.ordersys.config.AudienceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created with ordersys.
 * Date: 2020/12/19.
 * Time: 10:33 下午.
 *
 */
@Configuration
public class JwtConfig {

    @Bean
    public JwtTokenUtil jwtTokenUtil(AudienceConfig audienceConfig){
        return new JwtTokenUtil(audienceConfig);
    }

    @Bean
    public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
        return new JwtAuthenticationEntryPoint();
    }

    @Bean
    public JwtRequestFilter jwtRequestFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil){
        return new JwtRequestFilter(userDetailsService, jwtTokenUtil);
    }
}
