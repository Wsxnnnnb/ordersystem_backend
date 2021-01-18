package com.hulianpai.ordersys.infrastructure.repo;

import com.hulianpai.ordersys.application.dto.TestDto;
import com.hulianpai.ordersys.infrastructure.dao.OrderDao;
import com.hulianpai.ordersys.infrastructure.dao.OrderItemDao;
import com.hulianpai.ordersys.infrastructure.dao.TestDataDao;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 8:16 下午.
 *
 */
@Log4j2
@Service
public class TestRepository {
    private final OrderDao orderDao;
    private final OrderItemDao orderItemDao;
    private final TestDataDao testDataDao;
    public TestRepository(OrderDao orderDao, OrderItemDao orderItemDao, TestDataDao testDataDao) {
        this.orderDao = orderDao;
        this.orderItemDao = orderItemDao;
        this.testDataDao = testDataDao;
    }

    public void saveTestDto(TestDto testDto) {
        // TODO: 2020/9/13 order
        // TODO: 2020/9/13 item
        log.info("saveTestDto, {}", testDto);
        testDataDao.insertTestData(testDto);
    }
}
