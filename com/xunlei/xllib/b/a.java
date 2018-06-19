package com.xunlei.xllib.b;

/* compiled from: Base16 */
public final class a {

    /* compiled from: Base16 */
    static abstract class a {
        public byte[] a;
        public int b;

        a() {
        }
    }

    /* compiled from: Base16 */
    static class b extends a {
        private static final int[] h = new int[]{-2, -2, -2, -2, -2, -2, -2, -2, -2, -1, -1, -2, -2, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -1, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -2, -2, -2, -2, -2, -2, -2, 10, 11, 12, 13, 14, 15, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, 10, 11, 12, 13, 14, 15, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2};
        final int[] c;
        int d;
        int e;
        public int f;
        boolean g;

        public b() {
            this.g = false;
            this.a = null;
            this.c = h;
            this.b = 0;
            this.d = 0;
            this.g = false;
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3);
        cVar.a = new byte[(i2 * 2)];
        i3 = cVar.c;
        byte[] bArr2 = cVar.a;
        int i4 = cVar.b;
        i2 += i;
        while (i < i2) {
            int i5 = i + 1;
            i = bArr[i];
            int i6 = i4 + 1;
            bArr2[i4] = i3[(i >> 4) & 15];
            i4 = i6 + 1;
            bArr2[i6] = i3[i & 15];
            i = i5;
        }
        cVar.b = i4;
        return cVar.a;
    }
}
