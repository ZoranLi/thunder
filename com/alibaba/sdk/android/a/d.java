package com.alibaba.sdk.android.a;

public enum d {
    AMS_MAN("MAN"),
    AMS_HTTPDNS("HTTPDNS"),
    AMS_MPUSH("MPUSH"),
    AMS_MAC("MAC"),
    AMS_API("API"),
    AMS_HOTFIX("HOTFIX"),
    AMS_FEEDBACK("FEEDBACK"),
    AMS_IM("IM");
    
    private String i;

    private d(String str) {
        this.i = str;
    }

    public static d[] a() {
        return (d[]) j.clone();
    }

    public final String toString() {
        return this.i;
    }
}
