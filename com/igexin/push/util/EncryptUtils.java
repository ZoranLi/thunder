package com.igexin.push.util;

import android.text.TextUtils;
import com.igexin.b.a.b.f;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import com.igexin.push.d.c.b;
import com.igexin.push.extension.mod.SecurityUtils;

public class EncryptUtils {
    private static final String a = "com.igexin.push.util.EncryptUtils";
    private static boolean b = false;
    private static int c = 0;
    private static byte[] d = null;
    private static byte[] e = null;
    public static String errorMsg = "";

    static {
        try {
            if (SecurityUtils.b) {
                d = initSocketAESKey();
                e = initHttpAESKey();
                boolean z = (d == null || e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
                b = z;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load so error = ");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
            b = false;
            errorMsg = th.getMessage();
        }
        if (TextUtils.isEmpty(errorMsg)) {
            errorMsg = SecurityUtils.c;
        }
        StringBuilder stringBuilder2;
        if (b) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|load so success ~~~~~~~");
            a.b(stringBuilder2.toString());
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|load so error ++++++++");
            a.b(stringBuilder2.toString());
            if (TextUtils.isEmpty(errorMsg)) {
                errorMsg = "value = null, normal error";
            }
        }
    }

    public static byte[] aesDecHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.c(e, bArr, bArr2);
    }

    public static byte[] aesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.g(d, bArr, bArr2);
    }

    public static byte[] aesEncHttp(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.b(e, bArr, bArr2);
    }

    public static byte[] aesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.f(d, bArr, bArr2);
    }

    public static byte[] altAesDecSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.m(bArr, bArr2);
    }

    public static byte[] altAesEncSocket(byte[] bArr, byte[] bArr2) {
        return SecurityUtils.l(bArr, bArr2);
    }

    public static byte[] getBytesEncrypted(byte[] bArr) {
        return com.igexin.b.a.a.a.d(bArr, g.C);
    }

    public static byte[] getHttpAESKey() {
        return SecurityUtils.d(e);
    }

    public static String getHttpGTCV() {
        byte[] httpAESKey = getHttpAESKey();
        byte[] bytes = q.a(16).getBytes();
        byte[] bArr = new byte[(bytes.length + httpAESKey.length)];
        f.a(httpAESKey, 0, bArr, f.a(bytes, 0, bArr, 0, bytes.length), httpAESKey.length);
        return h.b(bArr, 2);
    }

    public static String getHttpSignature(String str, byte[] bArr) {
        byte[] bytes = str.getBytes();
        byte[] bArr2 = new byte[(bytes.length + bArr.length)];
        int a = f.a(bytes, 0, bArr2, 0, bytes.length);
        if (bArr.length > 0) {
            f.a(bArr, 0, bArr2, a, bArr.length);
        }
        return h.b(sha1(bArr2), 2);
    }

    public static byte[] getIV(byte[] bArr) {
        return md5(bArr);
    }

    public static int getPacketId() {
        int i = c;
        c = i + 1;
        return i;
    }

    public static byte[] getRSAKeyId() {
        return SecurityUtils.j();
    }

    public static byte[] getSocketAESKey() {
        return SecurityUtils.h(d);
    }

    public static byte[] getSocketSignature(b bVar, int i, int i2) {
        byte[] bArr = new byte[(11 + bVar.a)];
        i = f.a(i, bArr, 0);
        i += f.a(i2, bArr, i);
        i += f.b((short) bVar.a, bArr, i);
        f.a(bVar.e, 0, bArr, i + f.c(bVar.b, bArr, i), bVar.a);
        return sha1(bArr);
    }

    public static String getVersion() {
        byte[] k = SecurityUtils.k();
        return k != null ? new String(k) : null;
    }

    public static byte[] initHttpAESKey() {
        return SecurityUtils.a();
    }

    public static byte[] initSocketAESKey() {
        return SecurityUtils.e();
    }

    public static boolean isLoadSuccess() {
        return b;
    }

    public static byte[] md5(byte[] r1) {
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
        r0 = "MD5";	 Catch:{ Exception -> 0x000e }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x000e }
        r0.update(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.digest();	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.EncryptUtils.md5(byte[]):byte[]");
    }

    public static boolean reset() {
        StringBuilder stringBuilder;
        String str;
        try {
            if (SecurityUtils.b) {
                d = initSocketAESKey();
                e = initHttpAESKey();
                boolean z = (d == null || e == null || getSocketAESKey() == null || getHttpAESKey() == null || getRSAKeyId() == null || getVersion() == null) ? false : true;
                b = z;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|load so error = ");
            stringBuilder2.append(th.toString());
            a.b(stringBuilder2.toString());
            b = false;
        }
        if (b) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            str = "|load so success ~~~~~~~";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            str = "|load so error ++++++++";
        }
        stringBuilder.append(str);
        a.b(stringBuilder.toString());
        return b;
    }

    public static byte[] rsaEnc(byte[] bArr) {
        int length = bArr.length;
        if (length <= 214) {
            return SecurityUtils.i(bArr);
        }
        int i = length % 200 == 0 ? length / 200 : (length / 200) + 1;
        byte[] bArr2 = new byte[(i * 256)];
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            int i4 = i2 < i + -1 ? 200 : length - (i2 * 200);
            byte[] bArr3 = new byte[i4];
            f.a(bArr, i2 * 200, bArr3, 0, i4);
            byte[] i5 = SecurityUtils.i(bArr3);
            i3 += f.a(i5, 0, bArr2, i3, i5.length);
            i2++;
        }
        return bArr2;
    }

    public static byte[] sha1(byte[] r1) {
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
        r0 = "SHA-1";	 Catch:{ Exception -> 0x000b }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Exception -> 0x000b }
        r1 = r0.digest(r1);	 Catch:{ Exception -> 0x000b }
        return r1;
    L_0x000b:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.EncryptUtils.sha1(byte[]):byte[]");
    }
}
