package com.hulianpai.ordersys.controller;

import com.hulianpai.ordersys.controller.protocol.PageResponseData;
import com.hulianpai.ordersys.controller.protocol.ResponseData;
import com.hulianpai.ordersys.controller.protocol.req.OrderCreateReq;
import com.hulianpai.ordersys.controller.protocol.req.OrderQueryReq;
import com.hulianpai.ordersys.controller.protocol.resp.OrderDataResp;
import com.hulianpai.ordersys.controller.service.OrderControlerService;
import com.hulianpai.ordersys.infrastructure.dto.OrderDataDto;
import com.hulianpai.ordersys.infrastructure.dto.OrderItemDataDto;
import com.hulianpai.ordersys.infrastructure.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * Created with ordersys.
 * Date: 2020/12/20.
 * Time: 2:55 下午.
 *
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderControlerService orderControlerService;
    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/create")
    public ResponseData<Object> createOrder(@RequestBody @Valid OrderCreateReq req) {
      /* if (CollectionUtils.isEmpty(req.getOrderItems())) {
            return ResponseData.builder().code(600).msg("订单创建失败，商品不能为空").build();
        }*/
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LocalDateTime now = LocalDateTime.now();
        OrderDataDto orderDataDto = new OrderDataDto();
        orderDataDto.setCreateBy(userDetails.getUsername());
        orderDataDto.setRemark(req.getRemark());
        orderDataDto.setItemDataList(
                req.getOrderItems().stream().map(orderItemCreateReq -> {
                    OrderItemDataDto dto = new OrderItemDataDto();
                    dto.setProductSn(orderItemCreateReq.getProductSn());
                    dto.setProductName(orderItemCreateReq.getProductName());
                    dto.setCreateAt(now);
                    dto.setUpdateAt(now);
                    return dto;
                }).collect(Collectors.toList())
        );
        orderDataDto.setCreateAt(now);
        orderDataDto.setUpdateAt(now);
        orderControlerService.doCreate(orderDataDto);
        return ResponseData.ok("订单创建成功", null);
    }

    @GetMapping("/query")
    public PageResponseData<OrderDataResp> queryOrders(@Valid OrderQueryReq orderQueryReq) {
        orderRepository.getOrderDataPage(orderQueryReq.getCreateBy(), orderQueryReq.getPage(),orderQueryReq.getPageSize());
        return PageResponseData.ok();
    }

}
