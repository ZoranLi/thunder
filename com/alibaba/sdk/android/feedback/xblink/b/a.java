package com.alibaba.sdk.android.feedback.xblink.b;

public enum a {
    ONLINE(0, "m"),
    PRE(1, "wapa"),
    DAILY(2, "waptest");
    
    private int d;
    private String e;

    private a(int i, String str) {
        this.d = i;
        this.e = str;
    }

    public final String a() {
        StringBuilder stringBuilder = new StringBuilder("http://api.");
        stringBuilder.append(this.e);
        stringBuilder.append(".taobao.com/rest/api3.do");
        return stringBuilder.toString();
    }

    public final String b() {
        StringBuilder stringBuilder = new StringBuilder("http://h5.");
        stringBuilder.append(this.e);
        stringBuilder.append(".taobao.com/bizcache/2/windvane/config/");
        return stringBuilder.toString();
    }
}
