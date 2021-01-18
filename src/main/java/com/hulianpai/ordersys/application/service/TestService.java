package com.hulianpai.ordersys.application.service;

import com.hulianpai.ordersys.application.dto.TestDto;
import com.hulianpai.ordersys.infrastructure.repo.TestRepository;
import org.springframework.stereotype.Service;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 8:02 下午.
 *
 */
@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public boolean exec(TestDto testDto) {
        if (testDto == null) {
            return false;
        }
        testRepository.saveTestDto(testDto);
        longExec();
        return true;
    }

    public void longExec() {

    }
}
