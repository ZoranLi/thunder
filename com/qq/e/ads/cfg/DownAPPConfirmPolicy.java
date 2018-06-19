package com.qq.e.ads.cfg;

public enum DownAPPConfirmPolicy {
    Default(0),
    NOConfirm(2);
    
    private final int a;

    private DownAPPConfirmPolicy(int i) {
        this.a = i;
    }

    public final int value() {
        return this.a;
    }
}
