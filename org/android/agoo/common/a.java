package org.android.agoo.common;

import com.tencent.tinker.android.dx.instruction.Opcodes;

/* compiled from: Taobao */
public class a {
    public static final int DECODE = 0;
    public static final int DONT_BREAK_LINES = 8;
    public static final int ENCODE = 1;
    public static final int GZIP = 2;
    public static final int NO_OPTIONS = 0;
    public static final int ORDERED = 32;
    public static final int URL_SAFE = 16;
    private static final byte[] a = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};
    private static final byte[] b = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    private static final byte[] c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 45, (byte) 95};
    private static final byte[] d = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 62, (byte) -9, (byte) -9, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 63, (byte) -9, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -9, (byte) -9, (byte) -9, (byte) -9};
    private static final byte[] e = new byte[]{(byte) 45, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 95, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122};
    private static final byte[] f = new byte[]{(byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -5, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -5, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 0, (byte) -9, (byte) -9, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) -9, (byte) -9, (byte) -9, (byte) -1, (byte) -9, (byte) -9, (byte) -9, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) -9, (byte) -9, (byte) -9, (byte) -9, (byte) 37, (byte) -9, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) 62, (byte) 63, (byte) -9, (byte) -9, (byte) -9, (byte) -9};

    private static final byte[] a(int i) {
        if ((i & 16) == 16) {
            return d;
        }
        if ((i & 32) == 32) {
            return f;
        }
        return b;
    }

    private static final int a(byte[] r6, int r7, byte[] r8, int r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = a(r10);
        r0 = r7 + 2;
        r1 = r6[r0];
        r2 = 61;
        r3 = 1;
        if (r1 != r2) goto L_0x0025;
    L_0x000d:
        r0 = r6[r7];
        r0 = r10[r0];
        r0 = r0 & 255;
        r0 = r0 << 18;
        r7 = r7 + r3;
        r6 = r6[r7];
        r6 = r10[r6];
        r6 = r6 & 255;
        r6 = r6 << 12;
        r6 = r6 | r0;
        r6 = r6 >>> 16;
        r6 = (byte) r6;
        r8[r9] = r6;
        return r3;
    L_0x0025:
        r1 = r7 + 3;
        r4 = r6[r1];
        r5 = 2;
        if (r4 != r2) goto L_0x0053;
    L_0x002c:
        r1 = r6[r7];
        r1 = r10[r1];
        r1 = r1 & 255;
        r1 = r1 << 18;
        r7 = r7 + r3;
        r7 = r6[r7];
        r7 = r10[r7];
        r7 = r7 & 255;
        r7 = r7 << 12;
        r7 = r7 | r1;
        r6 = r6[r0];
        r6 = r10[r6];
        r6 = r6 & 255;
        r6 = r6 << 6;
        r6 = r6 | r7;
        r7 = r6 >>> 16;
        r7 = (byte) r7;
        r8[r9] = r7;
        r9 = r9 + r3;
        r6 = r6 >>> 8;
        r6 = (byte) r6;
        r8[r9] = r6;
        return r5;
    L_0x0053:
        r2 = r6[r7];	 Catch:{ Throwable -> 0x0087 }
        r2 = r10[r2];	 Catch:{ Throwable -> 0x0087 }
        r2 = r2 & 255;	 Catch:{ Throwable -> 0x0087 }
        r2 = r2 << 18;	 Catch:{ Throwable -> 0x0087 }
        r7 = r7 + r3;	 Catch:{ Throwable -> 0x0087 }
        r7 = r6[r7];	 Catch:{ Throwable -> 0x0087 }
        r7 = r10[r7];	 Catch:{ Throwable -> 0x0087 }
        r7 = r7 & 255;	 Catch:{ Throwable -> 0x0087 }
        r7 = r7 << 12;	 Catch:{ Throwable -> 0x0087 }
        r7 = r7 | r2;	 Catch:{ Throwable -> 0x0087 }
        r0 = r6[r0];	 Catch:{ Throwable -> 0x0087 }
        r0 = r10[r0];	 Catch:{ Throwable -> 0x0087 }
        r0 = r0 & 255;	 Catch:{ Throwable -> 0x0087 }
        r0 = r0 << 6;	 Catch:{ Throwable -> 0x0087 }
        r7 = r7 | r0;	 Catch:{ Throwable -> 0x0087 }
        r6 = r6[r1];	 Catch:{ Throwable -> 0x0087 }
        r6 = r10[r6];	 Catch:{ Throwable -> 0x0087 }
        r6 = r6 & 255;	 Catch:{ Throwable -> 0x0087 }
        r6 = r6 | r7;	 Catch:{ Throwable -> 0x0087 }
        r7 = r6 >> 16;	 Catch:{ Throwable -> 0x0087 }
        r7 = (byte) r7;	 Catch:{ Throwable -> 0x0087 }
        r8[r9] = r7;	 Catch:{ Throwable -> 0x0087 }
        r7 = r9 + 1;	 Catch:{ Throwable -> 0x0087 }
        r10 = r6 >> 8;	 Catch:{ Throwable -> 0x0087 }
        r10 = (byte) r10;	 Catch:{ Throwable -> 0x0087 }
        r8[r7] = r10;	 Catch:{ Throwable -> 0x0087 }
        r9 = r9 + r5;	 Catch:{ Throwable -> 0x0087 }
        r6 = (byte) r6;	 Catch:{ Throwable -> 0x0087 }
        r8[r9] = r6;	 Catch:{ Throwable -> 0x0087 }
        r6 = 3;
        return r6;
    L_0x0087:
        r6 = -1;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.a.a(byte[], int, byte[], int, int):int");
    }

    public static final byte[] a(byte[] bArr, int i, int i2, int i3) {
        byte[] a = a(i3);
        Object obj = new byte[((i2 * 3) / 4)];
        byte[] bArr2 = new byte[4];
        int i4 = 0;
        int i5 = i4;
        for (int i6 = i; i6 < i + i2; i6++) {
            byte b = (byte) (bArr[i6] & Opcodes.NEG_FLOAT);
            byte b2 = a[b];
            if (b2 < (byte) -5) {
                return null;
            }
            if (b2 >= (byte) -1) {
                int i7 = i4 + 1;
                bArr2[i4] = b;
                if (i7 > 3) {
                    i5 += a(bArr2, 0, obj, i5, i3);
                    if (b == (byte) 61) {
                        break;
                    }
                    i4 = 0;
                } else {
                    i4 = i7;
                }
            }
        }
        bArr = new byte[i5];
        System.arraycopy(obj, 0, bArr, 0, i5);
        return bArr;
    }

    public static final byte[] a(java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r2 = 0;
        return r2;
    L_0x0008:
        r0 = "UTF-8";	 Catch:{ Throwable -> 0x000f }
        r0 = r2.getBytes(r0);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0013;
    L_0x000f:
        r0 = r2.getBytes();
    L_0x0013:
        r2 = 0;
        r1 = r0.length;
        r2 = a(r0, r2, r1, r3);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.a.a(java.lang.String, int):byte[]");
    }
}
