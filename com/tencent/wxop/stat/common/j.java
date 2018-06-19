package com.tencent.wxop.stat.common;

class j extends i {
    private static final int[] c = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private static final int[] d = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int e;
    private int f;
    private final int[] g;

    public j(int i, byte[] bArr) {
        this.a = bArr;
        this.g = (i & 8) == 0 ? c : d;
        this.e = 0;
        this.f = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(byte[] r12, int r13, int r14, boolean r15) {
        /*
        r11 = this;
        r0 = r11.e;
        r1 = 0;
        r2 = 6;
        if (r0 != r2) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r14 = r14 + r13;
        r0 = r11.e;
        r3 = r11.f;
        r4 = r11.a;
        r5 = r11.g;
        r6 = 4;
        r7 = r1;
    L_0x0012:
        if (r13 >= r14) goto L_0x00d6;
    L_0x0014:
        if (r0 != 0) goto L_0x0059;
    L_0x0016:
        r8 = r13 + 4;
        if (r8 > r14) goto L_0x0057;
    L_0x001a:
        r3 = r12[r13];
        r3 = r3 & 255;
        r3 = r5[r3];
        r3 = r3 << 18;
        r9 = r13 + 1;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r9 = r9 << 12;
        r3 = r3 | r9;
        r9 = r13 + 2;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r9 = r9 << r2;
        r3 = r3 | r9;
        r9 = r13 + 3;
        r9 = r12[r9];
        r9 = r9 & 255;
        r9 = r5[r9];
        r3 = r3 | r9;
        if (r3 < 0) goto L_0x0057;
    L_0x0042:
        r13 = r7 + 2;
        r9 = (byte) r3;
        r4[r13] = r9;
        r13 = r7 + 1;
        r9 = r3 >> 8;
        r9 = (byte) r9;
        r4[r13] = r9;
        r13 = r3 >> 16;
        r13 = (byte) r13;
        r4[r7] = r13;
        r7 = r7 + 3;
        r13 = r8;
        goto L_0x0016;
    L_0x0057:
        if (r13 >= r14) goto L_0x00d6;
    L_0x0059:
        r8 = r13 + 1;
        r13 = r12[r13];
        r13 = r13 & 255;
        r13 = r5[r13];
        r9 = -2;
        r10 = -1;
        switch(r0) {
            case 0: goto L_0x00c8;
            case 1: goto L_0x00bb;
            case 2: goto L_0x00a7;
            case 3: goto L_0x0075;
            case 4: goto L_0x006d;
            case 5: goto L_0x0068;
            default: goto L_0x0066;
        };
    L_0x0066:
        goto L_0x00d3;
    L_0x0068:
        if (r13 == r10) goto L_0x00d3;
    L_0x006a:
        r11.e = r2;
        return r1;
    L_0x006d:
        if (r13 != r9) goto L_0x0070;
    L_0x006f:
        goto L_0x00c0;
    L_0x0070:
        if (r13 == r10) goto L_0x00d3;
    L_0x0072:
        r11.e = r2;
        return r1;
    L_0x0075:
        if (r13 < 0) goto L_0x0090;
    L_0x0077:
        r0 = r3 << 6;
        r3 = r0 | r13;
        r13 = r7 + 2;
        r0 = (byte) r3;
        r4[r13] = r0;
        r13 = r7 + 1;
        r0 = r3 >> 8;
        r0 = (byte) r0;
        r4[r13] = r0;
        r13 = r3 >> 16;
        r13 = (byte) r13;
        r4[r7] = r13;
        r7 = r7 + 3;
        r0 = r1;
        goto L_0x00d3;
    L_0x0090:
        if (r13 != r9) goto L_0x00a2;
    L_0x0092:
        r13 = r7 + 1;
        r0 = r3 >> 2;
        r0 = (byte) r0;
        r4[r13] = r0;
        r13 = r3 >> 10;
        r13 = (byte) r13;
        r4[r7] = r13;
        r7 = r7 + 2;
        r0 = 5;
        goto L_0x00d3;
    L_0x00a2:
        if (r13 == r10) goto L_0x00d3;
    L_0x00a4:
        r11.e = r2;
        return r1;
    L_0x00a7:
        if (r13 < 0) goto L_0x00aa;
    L_0x00a9:
        goto L_0x00bd;
    L_0x00aa:
        if (r13 != r9) goto L_0x00b6;
    L_0x00ac:
        r13 = r7 + 1;
        r0 = r3 >> 4;
        r0 = (byte) r0;
        r4[r7] = r0;
        r7 = r13;
        r0 = r6;
        goto L_0x00d3;
    L_0x00b6:
        if (r13 == r10) goto L_0x00d3;
    L_0x00b8:
        r11.e = r2;
        return r1;
    L_0x00bb:
        if (r13 < 0) goto L_0x00c3;
    L_0x00bd:
        r3 = r3 << 6;
        r3 = r3 | r13;
    L_0x00c0:
        r0 = r0 + 1;
        goto L_0x00d3;
    L_0x00c3:
        if (r13 == r10) goto L_0x00d3;
    L_0x00c5:
        r11.e = r2;
        return r1;
    L_0x00c8:
        if (r13 < 0) goto L_0x00ce;
    L_0x00ca:
        r0 = r0 + 1;
        r3 = r13;
        goto L_0x00d3;
    L_0x00ce:
        if (r13 == r10) goto L_0x00d3;
    L_0x00d0:
        r11.e = r2;
        return r1;
    L_0x00d3:
        r13 = r8;
        goto L_0x0012;
    L_0x00d6:
        r12 = 1;
        if (r15 != 0) goto L_0x00e0;
    L_0x00d9:
        r11.e = r0;
        r11.f = r3;
    L_0x00dd:
        r11.b = r7;
        return r12;
    L_0x00e0:
        switch(r0) {
            case 0: goto L_0x0102;
            case 1: goto L_0x00ff;
            case 2: goto L_0x00f6;
            case 3: goto L_0x00e7;
            case 4: goto L_0x00e4;
            default: goto L_0x00e3;
        };
    L_0x00e3:
        goto L_0x0102;
    L_0x00e4:
        r11.e = r2;
        return r1;
    L_0x00e7:
        r13 = r7 + 1;
        r14 = r3 >> 10;
        r14 = (byte) r14;
        r4[r7] = r14;
        r7 = r13 + 1;
        r14 = r3 >> 2;
        r14 = (byte) r14;
        r4[r13] = r14;
        goto L_0x0102;
    L_0x00f6:
        r13 = r7 + 1;
        r14 = r3 >> 4;
        r14 = (byte) r14;
        r4[r7] = r14;
        r7 = r13;
        goto L_0x0102;
    L_0x00ff:
        r11.e = r2;
        return r1;
    L_0x0102:
        r11.e = r0;
        goto L_0x00dd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.j.a(byte[], int, int, boolean):boolean");
    }
}
