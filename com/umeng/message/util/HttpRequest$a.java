package com.umeng.message.util;

public class HttpRequest$a {
    private static final byte a = (byte) 61;
    private static final String b = "US-ASCII";
    private static final byte[] c = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    private HttpRequest$a() {
    }

    private static byte[] a(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = c;
        int i4 = 0;
        int i5 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0);
        if (i2 > 2) {
            i4 = (bArr[i + 2] << 24) >>> 24;
        }
        bArr = i5 | i4;
        switch (i2) {
            case 1:
                bArr2[i3] = bArr3[bArr >>> 18];
                bArr2[i3 + 1] = bArr3[(bArr >>> 12) & 63];
                bArr2[i3 + 2] = a;
                bArr2[i3 + 3] = a;
                return bArr2;
            case 2:
                bArr2[i3] = bArr3[bArr >>> 18];
                bArr2[i3 + 1] = bArr3[(bArr >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(bArr >>> 6) & 63];
                bArr2[i3 + 3] = a;
                return bArr2;
            case 3:
                bArr2[i3] = bArr3[bArr >>> 18];
                bArr2[i3 + 1] = bArr3[(bArr >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(bArr >>> 6) & 63];
                bArr2[i3 + 3] = bArr3[bArr & 63];
                return bArr2;
            default:
                return bArr2;
        }
    }

    public static java.lang.String a(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "US-ASCII";	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        r0 = r1.getBytes(r0);	 Catch:{ UnsupportedEncodingException -> 0x0007 }
        goto L_0x000b;
    L_0x0007:
        r0 = r1.getBytes();
    L_0x000b:
        r1 = a(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest$a.a(java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static java.lang.String a(byte[] r0, int r1, int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b(r0, r1, r2);
        r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000c }
        r2 = "US-ASCII";	 Catch:{ UnsupportedEncodingException -> 0x000c }
        r1.<init>(r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x000c }
        return r1;
    L_0x000c:
        r1 = new java.lang.String;
        r1.<init>(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest$a.a(byte[], int, int):java.lang.String");
    }

    public static byte[] b(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("Cannot serialize a null array.");
        } else if (i < 0) {
            i2 = new StringBuilder("Cannot have negative offset: ");
            i2.append(i);
            throw new IllegalArgumentException(i2.toString());
        } else if (i2 < 0) {
            i = new StringBuilder("Cannot have length offset: ");
            i.append(i2);
            throw new IllegalArgumentException(i.toString());
        } else if (i + i2 > bArr.length) {
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)}));
        } else {
            int i3 = 4;
            int i4 = (i2 / 3) * 4;
            if (i2 % 3 <= 0) {
                i3 = 0;
            }
            Object obj = new byte[(i4 + i3)];
            i3 = i2 - 2;
            int i5 = 0;
            int i6 = i5;
            while (i5 < i3) {
                a(bArr, i5 + i, 3, obj, i6);
                i5 += 3;
                i6 += 4;
            }
            if (i5 < i2) {
                a(bArr, i + i5, i2 - i5, obj, i6);
                i6 += 4;
            }
            if (i6 > obj.length - 1) {
                return obj;
            }
            bArr = new byte[i6];
            System.arraycopy(obj, 0, bArr, 0, i6);
            return bArr;
        }
    }
}
