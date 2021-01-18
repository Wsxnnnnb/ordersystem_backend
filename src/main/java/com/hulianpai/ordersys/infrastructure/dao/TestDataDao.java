package com.hulianpai.ordersys.infrastructure.dao;

import com.hulianpai.ordersys.application.dto.TestDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 9:24 下午.
 *
 */
@Mapper
public interface TestDataDao {

    @Insert("insert into testdata.t_test_data(val, test) values (#{testDto.val}, #{testDto.test})")
    Integer insertTestData(@Param("testDto") TestDto testDto);

}
