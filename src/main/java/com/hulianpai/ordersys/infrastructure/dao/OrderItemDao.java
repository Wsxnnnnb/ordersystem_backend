package com.hulianpai.ordersys.infrastructure.dao;

import com.hulianpai.ordersys.infrastructure.po.OrderItemPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 8:19 下午.
 *
 */
@Mapper
public interface OrderItemDao {

    /**
     * 写入订单商品
     *
     * @param itemPoList
     * @return
     */
    Integer insertOrderItemList(@Param("itemPoList") List<OrderItemPo> itemPoList);

    /**
     *
     * @param orderSnList
     * @return
     */
    List<OrderItemPo> getItemListByOrderSnList(@Param("orderSnList") List<String> orderSnList);
}
