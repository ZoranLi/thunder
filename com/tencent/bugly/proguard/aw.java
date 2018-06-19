package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public class aw {
    public static ax a(int i) {
        if (i == 1) {
            return a();
        }
        return i == 3 ? b() : 0;
    }

    private static av a() {
        return new av();
    }

    private static au b() {
        return new au();
    }
}
