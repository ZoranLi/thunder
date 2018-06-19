package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;

public class a {
    public static int a(Context context, File file) {
        if (file != null && file.exists()) {
            try {
                PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
                if (packageArchiveInfo != null) {
                    return packageArchiveInfo.versionCode;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    public static String a(File file) {
        FileInputStream fileInputStream;
        Exception e;
        Throwable th;
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            try {
                int i;
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    i = 0;
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                bArr = instance.digest();
                int i2 = 0;
                while (i < 16) {
                    byte b = bArr[i];
                    int i3 = i2 + 1;
                    cArr2[i2] = cArr[(b >>> 4) & 15];
                    i2 = i3 + 1;
                    cArr2[i3] = cArr[b & 15];
                    i++;
                }
                String str = new String(cArr2);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return str;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            e.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
                return null;
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean a(android.content.Context r4, java.io.File r5, long r6, int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r5 == 0) goto L_0x002f;
    L_0x0003:
        r1 = r5.exists();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = 0;
        r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r3 <= 0) goto L_0x0019;
    L_0x0010:
        r1 = r5.length();
        r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1));
        if (r3 == 0) goto L_0x0019;
    L_0x0018:
        return r0;
    L_0x0019:
        r6 = a(r4, r5);	 Catch:{ Exception -> 0x002f }
        if (r8 == r6) goto L_0x0020;	 Catch:{ Exception -> 0x002f }
    L_0x001f:
        return r0;	 Catch:{ Exception -> 0x002f }
    L_0x0020:
        r4 = com.tencent.smtt.utils.b.a(r4, r5);	 Catch:{ Exception -> 0x002f }
        r5 = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a";	 Catch:{ Exception -> 0x002f }
        r4 = r5.equals(r4);	 Catch:{ Exception -> 0x002f }
        if (r4 != 0) goto L_0x002d;
    L_0x002c:
        return r0;
    L_0x002d:
        r4 = 1;
        return r4;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.a.a(android.content.Context, java.io.File, long, int):boolean");
    }
}
