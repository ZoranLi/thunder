package com.igexin.b.a.b;

import anet.channel.util.HttpConstant;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xiaomi.mipush.sdk.Constants;
import java.io.InputStream;
import java.io.OutputStream;

public final class f {
    public static int a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
        return 4;
    }

    public static int a(long j, byte[] bArr, int i) {
        bArr[i] = (byte) ((int) (255 & (j >> 56)));
        bArr[i + 1] = (byte) ((int) (255 & (j >> 48)));
        bArr[i + 2] = (byte) ((int) (255 & (j >> 40)));
        bArr[i + 3] = (byte) ((int) (255 & (j >> 32)));
        bArr[i + 4] = (byte) ((int) (255 & (j >> 24)));
        bArr[i + 5] = (byte) ((int) (255 & (j >> 16)));
        bArr[i + 6] = (byte) ((int) (255 & (j >> 8)));
        bArr[i + 7] = (byte) ((int) (255 & j));
        return 8;
    }

    public static int a(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        System.arraycopy(bArr, i, bArr2, i2, i3);
        return i3;
    }

    public static String a(String[] strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!strArr[0].equals("")) {
            stringBuilder.append(strArr[0]);
            stringBuilder.append(HttpConstant.SCHEME_SPLIT);
        }
        if (!strArr[1].equals("")) {
            stringBuilder.append(strArr[1]);
        }
        if (!strArr[2].equals("")) {
            stringBuilder.append(':');
            stringBuilder.append(strArr[2]);
        }
        if (!strArr[3].equals("")) {
            stringBuilder.append(strArr[3]);
            if (!strArr[3].equals("/")) {
                stringBuilder.append('/');
            }
        }
        if (!strArr[4].equals("")) {
            stringBuilder.append(strArr[4]);
        }
        if (!strArr[5].equals("")) {
            stringBuilder.append('?');
            stringBuilder.append(strArr[5]);
        }
        return stringBuilder.toString();
    }

    private static void a(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, int i) {
        OutputStream aVar = new a(outputStream, i);
        a(inputStream, aVar);
        aVar.a();
    }

    public static byte[] a(int i) {
        int i2 = 0;
        int i3 = i;
        i = 0;
        int i4 = i;
        do {
            int i5 = 24;
            i |= (i3 & Opcodes.NEG_FLOAT) << 24;
            i3 >>>= 7;
            i4++;
            if (i3 > 0) {
                i = (i >>> 8) | Integer.MIN_VALUE;
                continue;
            }
        } while (i3 > 0);
        byte[] bArr = new byte[i4];
        while (i2 < i4) {
            bArr[i2] = (byte) (i >>> i5);
            i5 -= 8;
            i2++;
        }
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        return c(bArr);
    }

    public static String[] a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str.toLowerCase());
        String[] strArr = new String[6];
        for (int i = 0; i < 6; i++) {
            strArr[i] = "";
        }
        int indexOf = str.indexOf(Constants.COLON_SEPARATOR);
        if (indexOf > 0) {
            strArr[0] = str.substring(0, indexOf);
            stringBuilder.delete(0, indexOf + 1);
        } else if (indexOf == 0) {
            throw new IllegalArgumentException("url format error - protocol");
        }
        if (stringBuilder.length() >= 2 && stringBuilder.charAt(0) == '/' && stringBuilder.charAt(1) == '/') {
            stringBuilder.delete(0, 2);
            int indexOf2 = stringBuilder.toString().indexOf(47);
            if (indexOf2 < 0) {
                indexOf2 = stringBuilder.length();
            }
            if (indexOf2 != 0) {
                int indexOf3 = stringBuilder.toString().indexOf(58);
                if (indexOf3 < 0) {
                    indexOf3 = indexOf2;
                } else if (indexOf3 > indexOf2) {
                    throw new IllegalArgumentException("url format error - port");
                } else {
                    strArr[2] = stringBuilder.toString().substring(indexOf3 + 1, indexOf2);
                }
                strArr[1] = stringBuilder.toString().substring(0, indexOf3);
                stringBuilder.delete(0, indexOf2);
            }
        }
        if (stringBuilder.length() > 0) {
            str = stringBuilder.toString();
            int lastIndexOf = str.lastIndexOf(47);
            if (lastIndexOf > 0) {
                strArr[3] = str.substring(0, lastIndexOf);
            } else if (lastIndexOf == 0) {
                if (str.indexOf(63) > 0) {
                    throw new IllegalArgumentException("url format error - path");
                }
                strArr[3] = str;
                return strArr;
            }
            if (lastIndexOf < str.length() - 1) {
                str = str.substring(lastIndexOf + 1, str.length());
                lastIndexOf = str.indexOf(63);
                if (lastIndexOf >= 0) {
                    strArr[4] = str.substring(0, lastIndexOf);
                    strArr[5] = str.substring(lastIndexOf + 1);
                    return strArr;
                }
                strArr[4] = str;
                return strArr;
            }
        }
        strArr[3] = "/";
        return strArr;
    }

    public static int b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 1] = (byte) (i & 255);
        return 2;
    }

    public static short b(byte[] bArr, int i) {
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    public static byte[] b(byte[] bArr) {
        return d(bArr);
    }

    public static int c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        return 1;
    }

    public static int c(byte[] bArr, int i) {
        return (bArr[i + 1] & 255) | ((bArr[i] & 255) << 8);
    }

    public static byte[] c(byte[] r3) {
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
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = 0;
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Throwable -> 0x0029, all -> 0x001e }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0029, all -> 0x001e }
        r2.write(r3);	 Catch:{ Throwable -> 0x002a, all -> 0x001c }
        r2.finish();	 Catch:{ Throwable -> 0x002a, all -> 0x001c }
        r3 = r0.toByteArray();	 Catch:{ Throwable -> 0x002a, all -> 0x001c }
        r2.close();	 Catch:{ Exception -> 0x0018 }
    L_0x0018:
        r0.close();	 Catch:{ Exception -> 0x0033 }
        return r3;
    L_0x001c:
        r3 = move-exception;
        goto L_0x0020;
    L_0x001e:
        r3 = move-exception;
        r2 = r1;
    L_0x0020:
        if (r2 == 0) goto L_0x0025;
    L_0x0022:
        r2.close();	 Catch:{ Exception -> 0x0025 }
    L_0x0025:
        r0.close();	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        throw r3;
    L_0x0029:
        r2 = r1;
    L_0x002a:
        if (r2 == 0) goto L_0x002f;
    L_0x002c:
        r2.close();	 Catch:{ Exception -> 0x002f }
    L_0x002f:
        r0.close();	 Catch:{ Exception -> 0x0032 }
    L_0x0032:
        r3 = r1;
    L_0x0033:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.f.c(byte[]):byte[]");
    }

    public static int d(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8));
    }

    public static byte[] d(byte[] r6) {
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
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r6);
        r6 = 0;
        r1 = new java.util.zip.GZIPInputStream;	 Catch:{ Throwable -> 0x0045, all -> 0x0033 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0045, all -> 0x0033 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Throwable -> 0x0031, all -> 0x002c }
        r2.<init>();	 Catch:{ Throwable -> 0x0031, all -> 0x002c }
    L_0x0010:
        r3 = r1.read();	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
        r4 = -1;	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
        if (r3 == r4) goto L_0x001b;	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
    L_0x0017:
        r2.write(r3);	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
        goto L_0x0010;	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
    L_0x001b:
        r3 = r2.toByteArray();	 Catch:{ Throwable -> 0x0047, all -> 0x002a }
        r2.close();	 Catch:{ Exception -> 0x0022 }
    L_0x0022:
        r1.close();	 Catch:{ Exception -> 0x0025 }
    L_0x0025:
        r0.close();	 Catch:{ Exception -> 0x0028 }
    L_0x0028:
        r6 = r3;
        return r6;
    L_0x002a:
        r6 = move-exception;
        goto L_0x0037;
    L_0x002c:
        r2 = move-exception;
        r5 = r2;
        r2 = r6;
        r6 = r5;
        goto L_0x0037;
    L_0x0031:
        r2 = r6;
        goto L_0x0047;
    L_0x0033:
        r1 = move-exception;
        r2 = r6;
        r6 = r1;
        r1 = r2;
    L_0x0037:
        if (r2 == 0) goto L_0x003c;
    L_0x0039:
        r2.close();	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        if (r1 == 0) goto L_0x0041;
    L_0x003e:
        r1.close();	 Catch:{ Exception -> 0x0041 }
    L_0x0041:
        r0.close();	 Catch:{ Exception -> 0x0044 }
    L_0x0044:
        throw r6;
    L_0x0045:
        r1 = r6;
        r2 = r1;
    L_0x0047:
        if (r2 == 0) goto L_0x004c;
    L_0x0049:
        r2.close();	 Catch:{ Exception -> 0x004c }
    L_0x004c:
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();	 Catch:{ Exception -> 0x0051 }
    L_0x0051:
        r0.close();	 Catch:{ Exception -> 0x0054 }
    L_0x0054:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.f.d(byte[]):byte[]");
    }

    public static long e(byte[] bArr, int i) {
        return ((((((((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48)) | ((((long) bArr[i + 2]) & 255) << 40)) | ((((long) bArr[i + 3]) & 255) << 32)) | ((((long) bArr[i + 4]) & 255) << 24)) | ((((long) bArr[i + 5]) & 255) << 16)) | ((((long) bArr[i + 6]) & 255) << 8)) | (((long) bArr[i + 7]) & 255);
    }

    public static byte[] f(byte[] r3, int r4) {
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
        r0 = new java.io.ByteArrayInputStream;
        r0.<init>(r3);
        r3 = new java.io.ByteArrayOutputStream;
        r3.<init>();
        a(r0, r3, r4);	 Catch:{ Throwable -> 0x001a }
        r0.close();	 Catch:{ Throwable -> 0x0010 }
    L_0x0010:
        r3.close();	 Catch:{ Throwable -> 0x0013 }
    L_0x0013:
        r3 = r3.toByteArray();
        return r3;
    L_0x0018:
        r4 = move-exception;
        goto L_0x0023;
    L_0x001a:
        r4 = move-exception;
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0018 }
        r2 = "Unexpected I/O error";	 Catch:{ all -> 0x0018 }
        r1.<init>(r2, r4);	 Catch:{ all -> 0x0018 }
        throw r1;	 Catch:{ all -> 0x0018 }
    L_0x0023:
        r0.close();	 Catch:{ Throwable -> 0x0026 }
    L_0x0026:
        r3.close();	 Catch:{ Throwable -> 0x0029 }
    L_0x0029:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.f.f(byte[], int):byte[]");
    }
}
