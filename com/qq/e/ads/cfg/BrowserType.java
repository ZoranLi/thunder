package com.qq.e.ads.cfg;

public enum BrowserType {
    Default(0),
    Inner(1),
    Sys(2);
    
    private final int a;

    private BrowserType(int i) {
        this.a = i;
    }

    public final int value() {
        return this.a;
    }
}
