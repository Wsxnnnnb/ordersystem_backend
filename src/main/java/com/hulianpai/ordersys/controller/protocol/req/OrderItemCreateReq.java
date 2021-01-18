package com.hulianpai.ordersys.controller.protocol.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 2:53 下午.
 *
 * Feign
 *
 */
@Getter
@Setter
public class OrderItemCreateReq {
    @NotNull(message = "商品sn缺失")
    private String productSn;
    private String productName;
}
