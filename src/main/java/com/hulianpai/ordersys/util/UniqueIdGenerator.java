package com.hulianpai.ordersys.util;

import com.hulianpai.ordersys.config.UniqueIdGeneratorConfig;

import java.util.function.Supplier;

/**
 * Created with ordersys.
 * Date: 2020/12/27.
 * Time: 5:39 下午.
 *
 */
public interface UniqueIdGenerator {
    /** 订单sn生成器 */
    Supplier<String> ORDER_SN_GEN = () -> "O" + Long.toHexString(UniqueIdGeneratorConfig.rootIdGenerator().nextId());
}
