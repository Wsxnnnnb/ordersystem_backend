package com.hulianpai.ordersys.infrastructure.repo.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hulianpai.ordersys.infrastructure.dao.OrderDao;
import com.hulianpai.ordersys.infrastructure.dao.OrderItemDao;
import com.hulianpai.ordersys.infrastructure.dto.OrderDataDto;
import com.hulianpai.ordersys.infrastructure.po.OrderItemPo;
import com.hulianpai.ordersys.infrastructure.po.OrderPo;
import com.hulianpai.ordersys.infrastructure.repo.OrderRepository;
import com.hulianpai.ordersys.util.UniqueIdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with ordersys.
 * Date: 2020/12/16.
 * Time: 9:31 下午.
 *
 */
@Service
public class OrderRepositoryMysql implements OrderRepository {

    private final OrderDao orderDao;
    private final OrderItemDao orderItemDao;

    public OrderRepositoryMysql(OrderDao orderDao, OrderItemDao orderItemDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
    }

    @Override
    public boolean createOrder(OrderDataDto orderData) {
        OrderPo orderDataPo = new OrderPo();
        orderDataPo.setCreateBy(orderData.getCreateBy());
        orderDataPo.setRemark(orderData.getRemark());
        orderDataPo.setCreateAt(orderData.getCreateAt());
        orderDataPo.setUpdateAt(orderData.getUpdateAt());
        orderDataPo.setSn(UniqueIdGenerator.ORDER_SN_GEN.get());
       List<OrderItemPo> orderItemList = orderData.getItemDataList().stream()
                .map(orderItemDataDto -> {
                    OrderItemPo orderItemPo = new OrderItemPo();
                    orderItemPo.setProductSn(orderItemDataDto.getProductSn());
                    orderItemPo.setProductName(orderItemDataDto.getProductName());
                    orderItemPo.setCreateAt(orderItemDataDto.getCreateAt());
                    orderItemPo.setUpdateAt(orderItemDataDto.getUpdateAt());
                    orderItemPo.setOrderSn(orderDataPo.getSn());
                    return orderItemPo;
                })
                .collect(Collectors.toList());
        orderDao.insertOrderData(orderDataPo);
        orderItemDao.insertOrderItemList(orderItemList);
        return true;
    }

    @Override
    public IPage<OrderDataDto> getOrderDataPage(String createByLike, int page, int size) {
        // TODO: 2020/9/27 订单信息
        IPage<OrderPo> pageParam = new Page<OrderPo>()
                .setPages(page).setSize(size);
        IPage<OrderPo> ret = orderDao.selectPage(
                pageParam,
                new LambdaQueryWrapper<OrderPo>()
                        .like(OrderPo::getCreateAt, createByLike)
        );
        // TODO: 2020/9/27 使用订单信息获取所有订单商品
        List<String> orderSnList = ret.getRecords().stream().map(OrderPo::getSn).collect(Collectors.toList());
        List<OrderItemPo> itemList = orderItemDao.getItemListByOrderSnList(orderSnList);
        // TODO: 2020/9/27 订单信息 ret 和订单商品 itemList 拼接
        // TODO: 2020/9/27 组装IPage
        return null;
    }
}
