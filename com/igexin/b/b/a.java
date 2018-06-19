package com.igexin.b.b;

import com.igexin.b.a.b.f;
import java.util.Random;

public class a {
    private static final char[] a = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static String a(int i) {
        if (i < 0) {
            i = 100;
        }
        if (i > 100) {
            i = 10;
        }
        Random random = new Random();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = a[random.nextInt(a.length)];
        }
        return new String(cArr);
    }

    public static java.lang.String a(android.content.Context r6, java.lang.String r7) {
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
        r6 = "0";
        r0 = new java.io.File;
        r0.<init>(r7);
        r7 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x003b, NoSuchAlgorithmException -> 0x003b }
        r7 = java.security.MessageDigest.getInstance(r7);	 Catch:{ NoSuchAlgorithmException -> 0x003b, NoSuchAlgorithmException -> 0x003b }
        if (r7 == 0) goto L_0x003b;
    L_0x000f:
        r1 = new java.io.FileInputStream;	 Catch:{  }
        r1.<init>(r0);	 Catch:{  }
        r0 = 10240; // 0x2800 float:1.4349E-41 double:5.059E-320;	 Catch:{  }
        r2 = new byte[r0];	 Catch:{  }
    L_0x0018:
        r3 = r1.read(r2);	 Catch:{  }
        r4 = 0;	 Catch:{  }
        if (r3 <= 0) goto L_0x002e;	 Catch:{  }
    L_0x001f:
        if (r3 >= r0) goto L_0x002a;	 Catch:{  }
    L_0x0021:
        r5 = new byte[r3];	 Catch:{  }
        java.lang.System.arraycopy(r2, r4, r5, r4, r3);	 Catch:{  }
        r7.update(r5);	 Catch:{  }
        goto L_0x0018;	 Catch:{  }
    L_0x002a:
        r7.update(r2);	 Catch:{  }
        goto L_0x0018;	 Catch:{  }
    L_0x002e:
        r7 = r7.digest();	 Catch:{  }
        r0 = r7.length;	 Catch:{  }
        r7 = a(r7, r4, r0);	 Catch:{  }
        r1.close();	 Catch:{ IOException -> 0x003a }
    L_0x003a:
        r6 = r7;
    L_0x003b:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.b.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static java.lang.String a(java.lang.String r8) {
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
        r8 = r8.getBytes();
        r0 = 16;
        r1 = new char[r0];
        r1 = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
        r2 = 0;
        r3 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0013 }
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ NoSuchAlgorithmException -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r3 = r2;
    L_0x0014:
        if (r3 != 0) goto L_0x0017;
    L_0x0016:
        return r2;
    L_0x0017:
        r3.update(r8);
        r8 = r3.digest();
        r2 = 32;
        r2 = new char[r2];
        r3 = 0;
        r4 = r3;
    L_0x0024:
        if (r3 >= r0) goto L_0x003d;
    L_0x0026:
        r5 = r8[r3];
        r6 = r4 + 1;
        r7 = r5 >>> 4;
        r7 = r7 & 15;
        r7 = r1[r7];
        r2[r4] = r7;
        r4 = r6 + 1;
        r5 = r5 & 15;
        r5 = r1[r5];
        r2[r6] = r5;
        r3 = r3 + 1;
        goto L_0x0024;
    L_0x003d:
        r8 = new java.lang.String;
        r8.<init>(r2);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.b.a.a(java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i3])}));
        }
        return stringBuilder.toString();
    }

    public static boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    public static byte[] a(byte[] r2) {
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
        r0 = 0;
        r1 = "MD5";	 Catch:{ NoSuchAlgorithmException -> 0x0008 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x0008 }
        goto L_0x0009;
    L_0x0008:
        r1 = r0;
    L_0x0009:
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1.update(r2);
        r2 = r1.digest();
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.b.a.a(byte[]):byte[]");
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        Object c = f.c(bArr);
        if (c != null) {
            String a = a(String.valueOf(System.currentTimeMillis()));
            int length = c.length;
            Object obj = new byte[(length + 16)];
            Object bytes = a.substring(0, 8).getBytes();
            Object bytes2 = a.substring(24, 32).getBytes();
            System.arraycopy(bytes, 0, obj, 0, 8);
            System.arraycopy(c, 0, obj, 8, length);
            System.arraycopy(bytes2, 0, obj, length + 8, 8);
            bArr2 = obj;
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length >= 16) {
                Object obj = new byte[(bArr.length - 16)];
                System.arraycopy(bArr, 8, obj, 0, bArr.length - 16);
                return f.d(obj);
            }
        }
        return null;
    }
}
