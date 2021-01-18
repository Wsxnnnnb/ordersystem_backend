package com.hulianpai.ordersys.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 1:47 下午.
 *
 */
@Getter
@Setter
public class OrderItemDataDto {
    private String productSn;
    private String productName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
