package com.hulianpai.ordersys.infrastructure.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 1:46 下午.
 *
 */
@Getter
@Setter
public class OrderDataDto {
    private String orderSn;
    private String createBy;
    private String remark;
    private List<OrderItemDataDto> itemDataList;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
