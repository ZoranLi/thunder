package com.igexin.push.util;

import java.io.UnsupportedEncodingException;

public class h {
    static final /* synthetic */ boolean a = true;

    private h() {
    }

    public static byte[] a(String str, int i) {
        return a(str.getBytes(), i);
    }

    public static byte[] a(byte[] bArr, int i) {
        return a(bArr, 0, bArr.length, i);
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        j jVar = new j(i3, new byte[((i2 * 3) / 4)]);
        if (!jVar.a(bArr, i, i2, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (jVar.b == jVar.a.length) {
            return jVar.a;
        } else {
            Object obj = new byte[jVar.b];
            System.arraycopy(jVar.a, 0, obj, 0, jVar.b);
            return obj;
        }
    }

    public static String b(byte[] bArr, int i) {
        try {
            return new String(c(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] b(byte[] bArr, int i, int i2, int i3) {
        k kVar = new k(i3, null);
        i3 = (i2 / 3) * 4;
        if (!kVar.d) {
            switch (i2 % 3) {
                case 0:
                    break;
                case 1:
                    i3 += 2;
                    break;
                case 2:
                    i3 += 3;
                    break;
                default:
                    break;
            }
        } else if (i2 % 3 > 0) {
            i3 += 4;
        }
        if (kVar.e && i2 > 0) {
            i3 += (((i2 - 1) / 57) + 1) * (kVar.f ? 2 : 1);
        }
        kVar.a = new byte[i3];
        kVar.a(bArr, i, i2, true);
        if (a || kVar.b == i3) {
            return kVar.a;
        }
        throw new AssertionError();
    }

    public static byte[] c(byte[] bArr, int i) {
        return b(bArr, 0, bArr.length, i);
    }
}
