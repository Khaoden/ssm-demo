package com.example.demo.common;

import lombok.Data;

@Data
public class R<T> {
    private String message;
    private int code;
    private T data;

    public R() {
    }

    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.setMessage("success");
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.setMessage("success");
        r.setCode(200);
        return r;
    }

    public static <T> R<T> error(String message) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setCode(400);
        return r;
    }

    public static <T> R<T> error(String message, T data) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setCode(400);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(Integer code, String message) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setCode(code);
        return r;
    }

    public static <T> R<T> error(Integer code, String message, T data) {
        R<T> r = new R<>();
        r.setMessage(message);
        r.setCode(code);
        r.setData(data);
        return r;
    }
}
