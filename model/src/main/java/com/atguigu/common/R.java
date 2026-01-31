package com.atguigu.common;

import lombok.Data;

@Data
public class R {
    private String code;
    private String message;
    private Object data;

    public static R ok() {
        R r = new R();
        r.setCode("200");
        r.setMessage("操作成功");
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.setCode("200");
        r.setMessage("操作成功");
        r.setData(data);
        return r;
    }

    public static R error() {
        R r = new R();
        r.setCode("500");
        r.setMessage("操作失败");
        return r;
    }

    public static R error(String message) {
        R r = new R();
        r.setCode("500");
        r.setMessage(message);
        return r;
    }


}
