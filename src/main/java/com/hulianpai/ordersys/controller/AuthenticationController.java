package com.hulianpai.ordersys.controller;

import com.hulianpai.ordersys.config.security.JwtTokenUtil;
import com.hulianpai.ordersys.controller.protocol.ResponseData;
import com.hulianpai.ordersys.controller.protocol.req.LoginReq;
import com.hulianpai.ordersys.controller.protocol.resp.LoginResp;
import com.hulianpai.ordersys.util.UniqueIdGenerator;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * Create with project ordersys
 *
 * @date 2020/12/16 15:07
 */
@RestController
@RequestMapping("/v1/auth")
public class AuthenticationController {
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthenticationController(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseData<LoginResp> login(@RequestBody LoginReq req) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(req.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        LoginResp resp = new LoginResp();
        resp.setToken(token);
        return ResponseData.ok(resp);
    }

    @GetMapping("/test-login")
    public ResponseData<Object> testLogin() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseData.ok("登录的信息：" + userDetails.getUsername() + "-" + UniqueIdGenerator.ORDER_SN_GEN.get());
    }
}
