package com.hulianpai.ordersys.controller.protocol;

import lombok.Builder;
import lombok.Getter;

/**
 * Create with project ordersys
 *
 * @date 2020/12/16 15:10
 */
@Getter
@Builder
public class ResponseData<T> {
    private Integer code;
    private String msg;
    private T data;

    public static <T> ResponseData<T> ok() {
        return ok("成功", null);
    }

    public static <T> ResponseData<T> ok(T data) {
        return ok("成功", data);
    }

    public static <T> ResponseData<T> ok(String msg, T data) {
        return ResponseData.<T>builder()
                .code(0)
                .msg(msg)
                .data(data)
                .build();
    }
}
