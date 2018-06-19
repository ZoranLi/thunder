package com.alipay.b.a.a.a.a;

public final class a {
    private static char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] b = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(java.lang.String r8) {
        /*
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = "US-ASCII";
        r8 = r8.getBytes(r1);
        r1 = 0;
        r2 = r8.length;
    L_0x000d:
        if (r1 >= r2) goto L_0x0045;
    L_0x000f:
        r3 = b;
        r4 = r1 + 1;
        r1 = r8[r1];
        r1 = r3[r1];
        r3 = -1;
        if (r4 >= r2) goto L_0x001f;
    L_0x001a:
        if (r1 == r3) goto L_0x001d;
    L_0x001c:
        goto L_0x001f;
    L_0x001d:
        r1 = r4;
        goto L_0x000f;
    L_0x001f:
        if (r1 == r3) goto L_0x0045;
    L_0x0021:
        r5 = b;
        r6 = r4 + 1;
        r4 = r8[r4];
        r4 = r5[r4];
        if (r6 >= r2) goto L_0x0030;
    L_0x002b:
        if (r4 == r3) goto L_0x002e;
    L_0x002d:
        goto L_0x0030;
    L_0x002e:
        r4 = r6;
        goto L_0x0021;
    L_0x0030:
        if (r4 == r3) goto L_0x0045;
    L_0x0032:
        r1 = r1 << 2;
        r5 = r4 & 48;
        r5 = r5 >>> 4;
        r1 = r1 | r5;
        r1 = (char) r1;
        r0.append(r1);
    L_0x003d:
        r1 = r6 + 1;
        r5 = r8[r6];
        r6 = 61;
        if (r5 != r6) goto L_0x0050;
    L_0x0045:
        r8 = r0.toString();
        r0 = "iso8859-1";
        r8 = r8.getBytes(r0);
        return r8;
    L_0x0050:
        r7 = b;
        r5 = r7[r5];
        if (r1 >= r2) goto L_0x005b;
    L_0x0056:
        if (r5 == r3) goto L_0x0059;
    L_0x0058:
        goto L_0x005b;
    L_0x0059:
        r6 = r1;
        goto L_0x003d;
    L_0x005b:
        if (r5 == r3) goto L_0x0045;
    L_0x005d:
        r4 = r4 & 15;
        r4 = r4 << 4;
        r7 = r5 & 60;
        r7 = r7 >>> 2;
        r4 = r4 | r7;
        r4 = (char) r4;
        r0.append(r4);
    L_0x006a:
        r4 = r1 + 1;
        r1 = r8[r1];
        if (r1 != r6) goto L_0x0071;
    L_0x0070:
        goto L_0x0045;
    L_0x0071:
        r7 = b;
        r1 = r7[r1];
        if (r4 >= r2) goto L_0x007c;
    L_0x0077:
        if (r1 == r3) goto L_0x007a;
    L_0x0079:
        goto L_0x007c;
    L_0x007a:
        r1 = r4;
        goto L_0x006a;
    L_0x007c:
        if (r1 == r3) goto L_0x0045;
    L_0x007e:
        r3 = r5 & 3;
        r3 = r3 << 6;
        r1 = r1 | r3;
        r1 = (char) r1;
        r0.append(r1);
        r1 = r4;
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.a.a(java.lang.String):byte[]");
    }
}
