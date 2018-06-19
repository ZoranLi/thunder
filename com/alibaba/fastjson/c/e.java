package com.alibaba.fastjson.c;

import com.alibaba.fastjson.JSONException;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.util.Arrays;

/* compiled from: IOUtils */
public final class e {
    public static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] b = new boolean[256];
    public static final boolean[] c = new boolean[256];
    public static final byte[] d = new byte[Opcodes.OR_LONG];
    public static final byte[] e = new byte[Opcodes.OR_LONG];
    public static final boolean[] f = new boolean[Opcodes.OR_LONG];
    public static final boolean[] g = new boolean[Opcodes.OR_LONG];
    public static final char[] h = new char[93];
    public static final char[] i = new char[]{'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    static final char[] j = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] k = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    static final char[] l = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static final int[] m = new int[]{9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    public static final char[] n = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int[] o;
    private static final ThreadLocal<SoftReference<char[]>> p = new ThreadLocal();
    private static final ThreadLocal<CharsetDecoder> q = new ThreadLocal();

    public static int a(long j) {
        long j2 = 10;
        for (int i = 1; i < 19; i++) {
            if (j < j2) {
                return i;
            }
            j2 *= 10;
        }
        return 19;
    }

    static {
        int i;
        int i2 = 0;
        while (i2 < b.length) {
            if (i2 >= 65 && i2 <= 90) {
                b[i2] = true;
            } else if (i2 >= 97 && i2 <= 122) {
                b[i2] = true;
            } else if (i2 == 95) {
                b[i2] = true;
            }
            i2 = (char) (i2 + 1);
        }
        i2 = 0;
        while (i2 < c.length) {
            if (i2 >= 65 && i2 <= 90) {
                c[i2] = true;
            } else if (i2 >= 97 && i2 <= 122) {
                c[i2] = true;
            } else if (i2 == 95) {
                c[i2] = true;
            } else if (i2 >= 48 && i2 <= 57) {
                c[i2] = true;
            }
            i2 = (char) (i2 + 1);
        }
        d[0] = (byte) 4;
        d[1] = (byte) 4;
        d[2] = (byte) 4;
        d[3] = (byte) 4;
        d[4] = (byte) 4;
        d[5] = (byte) 4;
        d[6] = (byte) 4;
        d[7] = (byte) 4;
        d[8] = (byte) 1;
        d[9] = (byte) 1;
        d[10] = (byte) 1;
        d[11] = (byte) 4;
        d[12] = (byte) 1;
        d[13] = (byte) 1;
        d[34] = (byte) 1;
        d[92] = (byte) 1;
        e[0] = (byte) 4;
        e[1] = (byte) 4;
        e[2] = (byte) 4;
        e[3] = (byte) 4;
        e[4] = (byte) 4;
        e[5] = (byte) 4;
        e[6] = (byte) 4;
        e[7] = (byte) 4;
        e[8] = (byte) 1;
        e[9] = (byte) 1;
        e[10] = (byte) 1;
        e[11] = (byte) 4;
        e[12] = (byte) 1;
        e[13] = (byte) 1;
        e[92] = (byte) 1;
        e[39] = (byte) 1;
        for (int i3 = 14; i3 <= 31; i3++) {
            d[i3] = (byte) 4;
            e[i3] = (byte) 4;
        }
        for (i = Opcodes.NEG_FLOAT; i <= Opcodes.AND_LONG; i++) {
            d[i] = (byte) 4;
            e[i] = (byte) 4;
        }
        for (i = 0; i < Opcodes.OR_LONG; i++) {
            f[i] = d[i] != (byte) 0;
            g[i] = e[i] != (byte) 0;
        }
        h[0] = '0';
        h[1] = '1';
        h[2] = '2';
        h[3] = '3';
        h[4] = '4';
        h[5] = '5';
        h[6] = '6';
        h[7] = '7';
        h[8] = 'b';
        h[9] = 't';
        h[10] = 'n';
        h[11] = 'v';
        h[12] = 'f';
        h[13] = 'r';
        h[34] = '\"';
        h[39] = '\'';
        h[47] = '/';
        h[92] = '\\';
        int[] iArr = new int[256];
        o = iArr;
        Arrays.fill(iArr, -1);
        i = n.length;
        for (i2 = 0; i2 < i; i2++) {
            o[n[i2]] = i2;
        }
        o[61] = 0;
    }

    public static void a(java.io.Closeable r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        if (r0 == 0) goto L_0x0006;
    L_0x0002:
        r0.close();	 Catch:{ Exception -> 0x0006 }
        return;
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.e.a(java.io.Closeable):void");
    }

    public static void a(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            c = '-';
            j = -j;
        } else {
            c = '\u0000';
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            j = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            i--;
            cArr[i] = l[j];
            i--;
            cArr[i] = k[j];
            j = j2;
        }
        j = (int) j;
        while (j >= 65536) {
            int i2 = j / 100;
            j -= ((i2 << 6) + (i2 << 5)) + (i2 << 2);
            i--;
            cArr[i] = l[j];
            i--;
            cArr[i] = k[j];
            j = i2;
        }
        while (true) {
            i2 = (52429 * j) >>> 19;
            i--;
            cArr[i] = j[j - ((i2 << 3) + (i2 << 1))];
            if (i2 == 0) {
                break;
            }
            j = i2;
        }
        if (c != '\u0000') {
            cArr[i - 1] = c;
        }
    }

    public static void a(int i, int i2, char[] cArr) {
        char c;
        if (i < 0) {
            c = '-';
            i = -i;
        } else {
            c = '\u0000';
        }
        while (i >= 65536) {
            int i3 = i / 100;
            i -= ((i3 << 6) + (i3 << 5)) + (i3 << 2);
            i2--;
            cArr[i2] = l[i];
            i2--;
            cArr[i2] = k[i];
            i = i3;
        }
        while (true) {
            i3 = (52429 * i) >>> 19;
            i2--;
            cArr[i2] = j[i - ((i3 << 3) + (i3 << 1))];
            if (i3 == 0) {
                break;
            }
            i = i3;
        }
        if (c != '\u0000') {
            cArr[i2 - 1] = c;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > m[i2]) {
            i2++;
        }
        return i2 + 1;
    }

    public static void a(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            byteBuffer = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!byteBuffer.isUnderflow()) {
                byteBuffer.throwException();
            }
            charsetDecoder = charsetDecoder.flush(charBuffer);
            if (charsetDecoder.isUnderflow() == null) {
                charsetDecoder.throwException();
            }
        } catch (CharsetDecoder charsetDecoder2) {
            charBuffer = new StringBuilder("utf8 decode error, ");
            charBuffer.append(charsetDecoder2.getMessage());
            throw new JSONException(charBuffer.toString(), charsetDecoder2);
        }
    }

    public static byte[] a(String str, int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i4 = (i + i2) - 1;
        while (i < i4 && o[str.charAt(i)] < 0) {
            i++;
        }
        while (i4 > 0 && o[str.charAt(i4)] < 0) {
            i4--;
        }
        int i5 = str.charAt(i4) == '=' ? str.charAt(i4 + -1) == '=' ? 2 : 1 : 0;
        int i6 = (i4 - i) + 1;
        if (i2 > 76) {
            i2 = (str.charAt(76) == 13 ? i6 / 78 : 0) << 1;
        } else {
            i2 = 0;
        }
        i6 = (((i6 - i2) * 6) >> 3) - i5;
        byte[] bArr = new byte[i6];
        int i7 = (i6 / 3) * 3;
        int i8 = i;
        i = 0;
        int i9 = i;
        while (i < i7) {
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            i10 = i11 + 1;
            i11 = i10 + 1;
            i8 = (((o[str.charAt(i8)] << 18) | (o[str.charAt(i10)] << 12)) | (o[str.charAt(i11)] << 6)) | o[str.charAt(i10)];
            int i12 = i + 1;
            bArr[i] = (byte) (i8 >> 16);
            i = i12 + 1;
            bArr[i12] = (byte) (i8 >> 8);
            i12 = i + 1;
            bArr[i] = (byte) i8;
            if (i2 > 0) {
                i9++;
                if (i9 == 19) {
                    i11 += 2;
                    i9 = 0;
                }
            }
            i8 = i11;
            i = i12;
        }
        if (i < i6) {
            i2 = 0;
            while (i8 <= i4 - i5) {
                i3 |= o[str.charAt(i8)] << (18 - (i2 * 6));
                i2++;
                i8++;
            }
            str = 16;
            while (i < i6) {
                i2 = i + 1;
                bArr[i] = (byte) (i3 >> str);
                str -= 8;
                i = i2;
            }
        }
        return bArr;
    }

    public static byte[] a(String str) {
        int length = str.length();
        int i = 0;
        if (length == 0) {
            return new byte[0];
        }
        int i2 = length - 1;
        int i3 = 0;
        while (i3 < i2 && o[str.charAt(i3) & 255] < 0) {
            i3++;
        }
        while (i2 > 0 && o[str.charAt(i2) & 255] < 0) {
            i2--;
        }
        int i4 = str.charAt(i2) == '=' ? str.charAt(i2 + -1) == '=' ? 2 : 1 : 0;
        int i5 = (i2 - i3) + 1;
        if (length > 76) {
            length = (str.charAt(76) == '\r' ? i5 / 78 : 0) << 1;
        } else {
            length = 0;
        }
        i5 = (((i5 - length) * 6) >> 3) - i4;
        byte[] bArr = new byte[i5];
        int i6 = (i5 / 3) * 3;
        int i7 = 0;
        int i8 = i3;
        i3 = i7;
        while (i3 < i6) {
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            i9 = i10 + 1;
            i10 = i9 + 1;
            i8 = (((o[str.charAt(i8)] << 18) | (o[str.charAt(i9)] << 12)) | (o[str.charAt(i10)] << 6)) | o[str.charAt(i9)];
            int i11 = i3 + 1;
            bArr[i3] = (byte) (i8 >> 16);
            i3 = i11 + 1;
            bArr[i11] = (byte) (i8 >> 8);
            i11 = i3 + 1;
            bArr[i3] = (byte) i8;
            if (length > 0) {
                i7++;
                if (i7 == 19) {
                    i10 += 2;
                    i7 = 0;
                }
            }
            i8 = i10;
            i3 = i11;
        }
        if (i3 < i5) {
            length = 0;
            while (i8 <= i2 - i4) {
                i |= o[str.charAt(i8)] << (18 - (length * 6));
                length++;
                i8++;
            }
            str = 16;
            while (i3 < i5) {
                length = i3 + 1;
                bArr[i3] = (byte) (i >> str);
                str -= 8;
                i3 = length;
            }
        }
        return bArr;
    }

    public static CharsetDecoder a() {
        CharsetDecoder charsetDecoder = (CharsetDecoder) q.get();
        if (charsetDecoder != null) {
            return charsetDecoder;
        }
        charsetDecoder = new k();
        q.set(charsetDecoder);
        return charsetDecoder;
    }

    public static char[] b(int i) {
        SoftReference softReference = (SoftReference) p.get();
        if (softReference == null) {
            return c(i);
        }
        char[] cArr = (char[]) softReference.get();
        if (cArr == null) {
            return c(i);
        }
        if (cArr.length < i) {
            cArr = c(i);
        }
        return cArr;
    }

    private static char[] c(int i) {
        if (i > 131072) {
            return new char[i];
        }
        if ((i >>> 10) <= 0) {
            i = 1024;
        } else {
            i = 1 << (32 - Integer.numberOfLeadingZeros(i - 1));
        }
        i = new char[i];
        p.set(new SoftReference(i));
        return i;
    }
}
