package com.hulianpai.ordersys.controller.protocol.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 2:53 下午.
 *
 */
@Getter
@Setter
public class OrderCreateReq {
    /**
     * 备注
     */
    @NotBlank(message = "备注不能为空")
    private String remark;
    /**
     * 订单商品列表
     */
    private List<OrderItemCreateReq> orderItems;
}
