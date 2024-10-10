package com.feng.markdownserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestResult {
    private int code;
    private String message;
    private Object data;

    public static RestResult ok() {
        return new RestResult(200, "OK", null);
    }
    public static RestResult ok(Object data) {
        return new RestResult(200, "OK", data);
    }
}
