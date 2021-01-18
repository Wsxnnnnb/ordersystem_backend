package com.hulianpai.ordersys.controller.protocol.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;

/**
 * Created with ordersys.
 * Date: 2020/12/27.
 * Time: 7:20 下午.
 *
 */
@Getter
@Setter
public class OrderQueryReq {
    private String createBy;
    private Integer page = 0;
    @Max(message = "最多只能查20条", value = 20)
    private Integer pageSize = 20;
}
