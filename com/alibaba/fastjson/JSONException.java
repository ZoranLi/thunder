package com.alibaba.fastjson;

public class JSONException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public JSONException(String str) {
        super(str);
    }

    public JSONException(String str, Throwable th) {
        super(str, th);
    }
}
