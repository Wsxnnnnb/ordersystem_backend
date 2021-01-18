package com.hulianpai.ordersys.infrastructure.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.IdType.INPUT;

/**
 * Created with ordersys.
 * Date: 2020/12/16.
 * Time: 9:25 下午.
 *
 */
@Getter
@Setter
@TableName("t_order_data")
public class OrderPo {
    @TableId(type = INPUT)
    private String sn;
    private String createBy;
    private String remark;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
