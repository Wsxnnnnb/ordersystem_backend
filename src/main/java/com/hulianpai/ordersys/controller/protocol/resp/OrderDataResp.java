package com.hulianpai.ordersys.controller.protocol.resp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with ordersys.
 * Date: 2020/12/27.
 * Time: 7:28 下午.
 *
 */
public class OrderDataResp {
    private String orderSn;
    /**
     * 备注
     */
    private String remark;
    /**
     * 订单商品列表
     */
    private List<OrderItemDataResp> orderItems;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
