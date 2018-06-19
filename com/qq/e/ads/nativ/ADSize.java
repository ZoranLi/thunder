package com.qq.e.ads.nativ;

public class ADSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private int a;
    private int b;

    public ADSize(int i, int i2) {
        this.b = i2;
        this.a = i;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.a;
    }
}
