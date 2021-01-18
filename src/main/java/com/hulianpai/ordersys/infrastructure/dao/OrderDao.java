package com.hulianpai.ordersys.infrastructure.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hulianpai.ordersys.infrastructure.po.OrderPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created with ordersys.
 * Date: 2020/12/13.
 * Time: 8:19 下午.
 *
 */
@Mapper
public interface  OrderDao extends BaseMapper<OrderPo> {

    @Insert("insert into testdata.t_order_data(sn, remark, create_by, create_at, update_at) values (#{abc.sn}, #{abc.remark}, #{abc.createBy},#{abc.createAt},#{abc.updateAt})")
    Integer insertOrderData(@Param("abc") OrderPo orderPo);
}
