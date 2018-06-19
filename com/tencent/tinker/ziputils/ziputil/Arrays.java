package com.tencent.tinker.ziputils.ziputil;

/* compiled from: BUGLY */
public class Arrays {
    public static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) >= 0 && i2 <= i) {
            if (i - i2 >= i3) {
                return;
            }
        }
        throw new ArrayIndexOutOfBoundsException(i2);
    }
}
