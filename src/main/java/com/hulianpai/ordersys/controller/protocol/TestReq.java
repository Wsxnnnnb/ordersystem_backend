package com.hulianpai.ordersys.controller.protocol;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * Created with ordersys.
 * Date: 2020/12/11.
 * Time: 10:28 下午.
 *
 */
@Getter
@Setter
public class TestReq {
    @NotBlank(message = "not blank")
    private String val;
    private String test;
}
