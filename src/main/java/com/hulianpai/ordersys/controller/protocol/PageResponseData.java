package com.hulianpai.ordersys.controller.protocol;

import lombok.Builder;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * Create with project ordersys
 *
 * @date 2020/12/16 15:10
 */
@Getter
@Builder
public class PageResponseData<T> {
    private Integer code;
    private String msg;
    private Integer total;
    private Collection<T> data;

    public static <T> PageResponseData<T> ok() {
        return ok("成功", 0, Collections.emptyList());
    }

    public static <T> PageResponseData<T> ok(String msg, Integer total, Collection<T> dataList) {
        return PageResponseData.<T>builder()
                .code(0)
                .msg(msg)
                .total(total)
                .data(dataList)
                .build();
    }

    public static <T> PageResponseData<T> ok(Integer totalCount, T... data) {
        return ok("成功", totalCount, data);
    }

    public static <T> PageResponseData<T> ok(String msg, Integer totalCount, T... data) {
        return ok(msg, totalCount, Arrays.asList(data));
    }


}
