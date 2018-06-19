package com.alibaba.fastjson;

public class JSONPathException extends JSONException {
    private static final long serialVersionUID = 1;

    public JSONPathException(String str) {
        super(str);
    }

    public JSONPathException(String str, Throwable th) {
        super(str, th);
    }
}
