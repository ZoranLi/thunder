package com.huawei.hms.c;

/* compiled from: HEX */
public final class b {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static char[] a(byte[] bArr, boolean z) {
        return a(bArr, z ? b : a);
    }

    private static char[] a(byte[] bArr, char[] cArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(240 & bArr[i]) >>> 4];
            i2 = i3 + 1;
            cArr2[i3] = cArr[15 & bArr[i]];
            i++;
        }
        return cArr2;
    }

    public static String b(byte[] bArr, boolean z) {
        return new String(a(bArr, z));
    }
}
