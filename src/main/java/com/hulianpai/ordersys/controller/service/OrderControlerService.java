package com.hulianpai.ordersys.controller.service;

import com.hulianpai.ordersys.infrastructure.dto.OrderDataDto;
import com.hulianpai.ordersys.infrastructure.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.FileNotFoundException;
import java.util.Collections;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 3:13 下午.
 *
 */
@Service
public class OrderControlerService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public void doCreate(OrderDataDto orderDataDto) {
        orderRepository.createOrder(orderDataDto);
    }
}
