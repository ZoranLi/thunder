package com.xunlei.xllib.b;

import com.xunlei.xllib.b.a.a;

/* compiled from: Base16 */
class a$c extends a {
    private static final byte[] d = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};
    private static final byte[] e = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102};
    final byte[] c;

    public a$c(int i) {
        this.a = null;
        this.c = (i & 1) == 0 ? d : e;
        this.b = 0;
    }
}
