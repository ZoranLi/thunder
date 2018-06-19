package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public class aq {
    private static as a;
    private static at b;

    public static ar a(int i) {
        if (i == 1) {
            return b();
        }
        return i == 2 ? a() : 0;
    }

    public static ar a() {
        return new as();
    }

    public static ar b() {
        return new at();
    }
}
