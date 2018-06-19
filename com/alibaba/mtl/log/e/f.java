package com.alibaba.mtl.log.e;

/* compiled from: IntUtils */
public final class f {
    public static byte[] a(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % 256);
        i >>= 8;
        bArr[2] = (byte) (i % 256);
        i >>= 8;
        bArr[1] = (byte) (i % 256);
        bArr[0] = (byte) ((i >> 8) % 256);
        return bArr;
    }
}
