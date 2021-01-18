package com.hulianpai.ordersys.controller.protocol.req;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with ordersys.
 * Date: 2020/12/19.
 * Time: 10:38 下午.
 *
 */
@Getter
@Setter
public class LoginReq {
    private String username;
    private String password;
}
