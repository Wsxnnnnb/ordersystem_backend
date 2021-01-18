package com.hulianpai.ordersys;

import com.hulianpai.ordersys.application.dto.TestDto;
import com.hulianpai.ordersys.application.service.TestService;
import com.hulianpai.ordersys.infrastructure.repo.TestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 8:44 下午.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestUintTest {
    @Mock
    private TestRepository testRepository;

    @InjectMocks
    private TestService testService;

    private TestService spySelf;

    @Before
    public void prepare() {
        spySelf = spy(testService);
    }

    @Test
    public void test1() {
        TestDto testDto = new TestDto();
        testDto.setTest("txt");
        testDto.setVal(BigDecimal.ONE);

        boolean ret = spySelf.exec(testDto);

        assertThat(ret).isTrue();
        verify(testRepository, times(1))
                .saveTestDto(testDto);
        verify(spySelf, times(1))
                .longExec();
    }

}
