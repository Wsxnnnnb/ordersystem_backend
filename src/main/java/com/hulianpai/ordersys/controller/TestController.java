package com.hulianpai.ordersys.controller;

import com.hulianpai.ordersys.application.dto.TestDto;
import com.hulianpai.ordersys.application.service.TestService;
import com.hulianpai.ordersys.controller.protocol.TestReq;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * Created with ordersys.
 * Date: 2020/12/11.
 * Time: 10:03 下午.
 *
 */
@RestController
@RequestMapping("/v1")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get")
    public String sku(@RequestParam(name = "a", required = false) String aAttr) {
        return "test";
    }

    @PostMapping("/post")
    public String name(@Valid @RequestBody TestReq req) {
        TestDto dto = new TestDto();
        dto.setVal(new BigDecimal(req.getVal()));
        dto.setTest(req.getTest());
        testService.exec(dto);
        return req.getTest();
    }


}
