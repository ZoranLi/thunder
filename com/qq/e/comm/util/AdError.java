package com.qq.e.comm.util;

public class AdError {
    private int a;
    private String b;

    public AdError(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public int getErrorCode() {
        return this.a;
    }

    public String getErrorMsg() {
        return this.b;
    }
}
