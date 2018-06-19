package com.qq.e.ads.cfg;

public enum BannerRollAnimation {
    Default(0),
    NoAnimation(-1);
    
    private final int a;

    private BannerRollAnimation(int i) {
        this.a = i;
    }

    public final int value() {
        return this.a;
    }
}
