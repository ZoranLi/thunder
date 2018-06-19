package com.qihoo360.replugin.utils.a;

/* compiled from: ContainerHelpers */
final class f {
    static final int[] a = new int[0];
    static final long[] b = new long[0];
    static final Object[] c = new Object[0];

    public static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    static int a(int[] iArr, int i, int i2) {
        i--;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = (i3 + i) >>> 1;
            int i5 = iArr[i4];
            if (i5 < i2) {
                i3 = i4 + 1;
            } else if (i5 <= i2) {
                return i4;
            } else {
                i = i4 - 1;
            }
        }
        return i3 ^ -1;
    }
}
