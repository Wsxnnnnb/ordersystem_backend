package com.hulianpai.ordersys.infrastructure.po;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created with ordersys.
 * Date: 2020/12/16.
 * Time: 9:25 下午.
 *
 */
@Setter
@Getter
public class OrderItemPo {
    private Long id;
    private String orderSn;
    private String productSn;
    private String productName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
