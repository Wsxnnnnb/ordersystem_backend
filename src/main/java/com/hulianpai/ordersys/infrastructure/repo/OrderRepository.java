package com.hulianpai.ordersys.infrastructure.repo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hulianpai.ordersys.infrastructure.dto.OrderDataDto;

/**
 * Created with ordersys.
 * Date: 2020/12/16.
 * Time: 9:28 下午.
 *
 */
public interface OrderRepository {
    /**
     * 创建订单
     *
     * @param orderData
     * @return
     */
    boolean createOrder(OrderDataDto orderData);

    /**
     * 分页获取订单List
     *
     * @param createByLike
     * @param page
     * @param size
     * @return
     */
    IPage<OrderDataDto> getOrderDataPage(String createByLike, int page, int size);
}
