package com.hulianpai.ordersys.config.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with ordersys.
 * Date: 2020/12/19.
 * Time: 10:25 下午.
 *
 */
@Log4j2
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {
        log.info("JwtAuthenticationEntryPoint: {}", authException.getMessage());
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "没有凭证");
    }
}
