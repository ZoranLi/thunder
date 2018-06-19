package com.qq.e.comm.util;

import android.support.v4.view.InputDeviceCompat;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.downloadlist.d;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import com.xunlei.downloadprovider.pushmessage.e;
import java.security.MessageDigest;

public class Md5Util {
    private static final String[] a = new String[]{"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", "a", b.a, c.a, d.a, e.a, f.a};

    public static String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i : bArr) {
            int i2;
            if (i2 < 0) {
                i2 += 256;
            }
            int i3 = i2 / 16;
            i2 %= 16;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a[i3]);
            stringBuilder.append(a[i2]);
            stringBuffer.append(stringBuilder.toString());
        }
        return stringBuffer.toString();
    }

    public static java.lang.String encode(java.io.File r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0005;
    L_0x0002:
        r4 = "";
        return r4;
    L_0x0005:
        r0 = 0;
        r1 = "MD5";	 Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r2.<init>(r4);	 Catch:{ Exception -> 0x0038, all -> 0x0030 }
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4 = new byte[r4];	 Catch:{ Exception -> 0x002e, all -> 0x002c }
    L_0x0015:
        r0 = r2.read(r4);	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        if (r0 <= 0) goto L_0x0020;	 Catch:{ Exception -> 0x002e, all -> 0x002c }
    L_0x001b:
        r3 = 0;	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        r1.update(r4, r3, r0);	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        goto L_0x0015;	 Catch:{ Exception -> 0x002e, all -> 0x002c }
    L_0x0020:
        r4 = r1.digest();	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        r4 = byteArrayToHexString(r4);	 Catch:{ Exception -> 0x002e, all -> 0x002c }
        r2.close();	 Catch:{ Exception -> 0x002b }
    L_0x002b:
        return r4;
    L_0x002c:
        r4 = move-exception;
        goto L_0x0032;
    L_0x002e:
        r0 = r2;
        goto L_0x0038;
    L_0x0030:
        r4 = move-exception;
        r2 = r0;
    L_0x0032:
        if (r2 == 0) goto L_0x0037;
    L_0x0034:
        r2.close();	 Catch:{ Exception -> 0x0037 }
    L_0x0037:
        throw r4;
    L_0x0038:
        if (r0 == 0) goto L_0x003d;
    L_0x003a:
        r0.close();	 Catch:{ Exception -> 0x003d }
    L_0x003d:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.Md5Util.encode(java.io.File):java.lang.String");
    }

    public static java.lang.String encode(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0018 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0018 }
        r2 = "MD5";	 Catch:{ Exception -> 0x0019 }
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ Exception -> 0x0019 }
        r1 = r0.getBytes();	 Catch:{ Exception -> 0x0019 }
        r2 = r2.digest(r1);	 Catch:{ Exception -> 0x0019 }
        r2 = byteArrayToHexString(r2);	 Catch:{ Exception -> 0x0019 }
        return r2;
    L_0x0018:
        r0 = 0;
    L_0x0019:
        r2 = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.Md5Util.encode(java.lang.String):java.lang.String");
    }

    public static String encodeBase64String(String str) {
        try {
            return byteArrayToHexString(MessageDigest.getInstance("MD5").digest(Base64.decode(str, 0)));
        } catch (Throwable e) {
            GDTLogger.e("Exception while md5 base64String", e);
            return null;
        }
    }

    public static byte[] hexStringtoByteArray(String str) {
        if (str.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() - 1; i += 2) {
            char charAt = str.charAt(i);
            char charAt2 = str.charAt(i + 1);
            charAt = Character.toLowerCase(charAt);
            charAt2 = Character.toLowerCase(charAt2);
            int i2 = ((charAt <= '9' ? charAt - 48 : (charAt - 97) + 10) << 4) + (charAt2 <= '9' ? charAt2 - 48 : (charAt2 - 97) + 10);
            if (i2 > Opcodes.NEG_FLOAT) {
                i2 += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i / 2] = (byte) i2;
        }
        return bArr;
    }
}
