package com.tencent.bugly.crashreport.common.info;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.Principal;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class AppInfo {
    public static final String[] a = "@buglyAllChannel@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    public static final String[] b = "@buglyAllChannelPriority@".split(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static ActivityManager c;

    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
            return "fail";
        }
    }

    public static PackageInfo b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(a(context), 0);
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
            return null;
        }
    }

    public static boolean a(Context context, String str) {
        if (!(context == null || str == null)) {
            if (str.trim().length() > 0) {
                try {
                    context = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                    if (context != null) {
                        for (Object equals : context) {
                            if (str.equals(equals)) {
                                return true;
                            }
                        }
                    }
                } catch (Context context2) {
                    if (an.a(context2) == null) {
                        context2.printStackTrace();
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static java.lang.String a(android.content.Context r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = 0;
        r0 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0043 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0043 }
        r2 = "/proc/";	 Catch:{ Throwable -> 0x0043 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0043 }
        r1.append(r7);	 Catch:{ Throwable -> 0x0043 }
        r2 = "/cmdline";	 Catch:{ Throwable -> 0x0043 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0043 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x0043 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0043 }
        r6 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        r1 = new char[r6];	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r0.read(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r2 = 0;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r3 = r2;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
    L_0x0022:
        if (r3 >= r6) goto L_0x002b;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
    L_0x0024:
        r4 = r1[r3];	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        if (r4 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
    L_0x0028:
        r3 = r3 + 1;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        goto L_0x0022;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
    L_0x002b:
        r6 = new java.lang.String;	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r6 = r6.substring(r2, r3);	 Catch:{ Throwable -> 0x003c, all -> 0x0038 }
        r0.close();	 Catch:{ Throwable -> 0x0037 }
    L_0x0037:
        return r6;
    L_0x0038:
        r6 = move-exception;
        r7 = r6;
        r6 = r0;
        goto L_0x0057;
    L_0x003c:
        r6 = move-exception;
        r5 = r0;
        r0 = r6;
        r6 = r5;
        goto L_0x0044;
    L_0x0041:
        r7 = move-exception;
        goto L_0x0057;
    L_0x0043:
        r0 = move-exception;
    L_0x0044:
        r1 = com.tencent.bugly.proguard.an.a(r0);	 Catch:{ all -> 0x0041 }
        if (r1 != 0) goto L_0x004d;	 Catch:{ all -> 0x0041 }
    L_0x004a:
        r0.printStackTrace();	 Catch:{ all -> 0x0041 }
    L_0x004d:
        r7 = java.lang.String.valueOf(r7);	 Catch:{ all -> 0x0041 }
        if (r6 == 0) goto L_0x0056;
    L_0x0053:
        r6.close();	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        return r7;
    L_0x0057:
        if (r6 == 0) goto L_0x005c;
    L_0x0059:
        r6.close();	 Catch:{ Throwable -> 0x005c }
    L_0x005c:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.AppInfo.a(android.content.Context, int):java.lang.String");
    }

    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            context = context.getApplicationInfo();
            if (!(packageManager == null || context == null)) {
                context = packageManager.getApplicationLabel(context);
                if (context != null) {
                    return context.toString();
                }
            }
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
        }
        return null;
    }

    public static Map<String, String> d(Context context) {
        Map<String, String> map = null;
        if (context == null) {
            return null;
        }
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context.metaData != null) {
                HashMap hashMap = new HashMap();
                Object obj = context.metaData.get("BUGLY_DISABLE");
                if (obj != null) {
                    hashMap.put("BUGLY_DISABLE", obj.toString());
                }
                obj = context.metaData.get("BUGLY_APPID");
                if (obj != null) {
                    hashMap.put("BUGLY_APPID", obj.toString());
                }
                obj = context.metaData.get("BUGLY_APP_CHANNEL");
                if (obj != null) {
                    hashMap.put("BUGLY_APP_CHANNEL", obj.toString());
                }
                obj = context.metaData.get("BUGLY_APP_VERSION");
                if (obj != null) {
                    hashMap.put("BUGLY_APP_VERSION", obj.toString());
                }
                obj = context.metaData.get("BUGLY_ENABLE_DEBUG");
                if (obj != null) {
                    hashMap.put("BUGLY_ENABLE_DEBUG", obj.toString());
                }
                context = context.metaData.get("com.tencent.rdm.uuid");
                if (context != null) {
                    hashMap.put("com.tencent.rdm.uuid", context.toString());
                }
                map = hashMap;
            }
            return map;
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
            return null;
        }
    }

    public static List<String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            String str = (String) map.get("BUGLY_DISABLE");
            if (str != null) {
                if (str.length() != 0) {
                    map = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    for (int i = 0; i < map.length; i++) {
                        map[i] = map[i].trim();
                    }
                    return Arrays.asList(map);
                }
            }
            return null;
        } catch (Map<String, String> map2) {
            if (!an.a(map2)) {
                map2.printStackTrace();
            }
            return null;
        }
    }

    public static String a(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr != null && bArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                if (instance == null) {
                    return null;
                }
                X509Certificate x509Certificate = (X509Certificate) instance.generateCertificate(new ByteArrayInputStream(bArr));
                if (x509Certificate == null) {
                    return null;
                }
                stringBuilder.append("Issuer|");
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (issuerDN != null) {
                    stringBuilder.append(issuerDN.toString());
                } else {
                    stringBuilder.append("unknown");
                }
                stringBuilder.append("\n");
                stringBuilder.append("SerialNumber|");
                BigInteger serialNumber = x509Certificate.getSerialNumber();
                if (issuerDN != null) {
                    stringBuilder.append(serialNumber.toString(16));
                } else {
                    stringBuilder.append("unknown");
                }
                stringBuilder.append("\n");
                stringBuilder.append("NotBefore|");
                Date notBefore = x509Certificate.getNotBefore();
                if (issuerDN != null) {
                    stringBuilder.append(notBefore.toString());
                } else {
                    stringBuilder.append("unknown");
                }
                stringBuilder.append("\n");
                stringBuilder.append("NotAfter|");
                notBefore = x509Certificate.getNotAfter();
                if (issuerDN != null) {
                    stringBuilder.append(notBefore.toString());
                } else {
                    stringBuilder.append("unknown");
                }
                stringBuilder.append("\n");
                stringBuilder.append("SHA1|");
                String a = ap.a(MessageDigest.getInstance("SHA1").digest(x509Certificate.getEncoded()));
                if (a == null || a.length() <= 0) {
                    stringBuilder.append("unknown");
                } else {
                    stringBuilder.append(a.toString());
                }
                stringBuilder.append("\n");
                stringBuilder.append("MD5|");
                bArr = ap.a(MessageDigest.getInstance("MD5").digest(x509Certificate.getEncoded()));
                if (bArr == null || bArr.length() <= 0) {
                    stringBuilder.append("unknown");
                } else {
                    stringBuilder.append(bArr.toString());
                }
            } catch (byte[] bArr2) {
                if (!an.a(bArr2)) {
                    bArr2.printStackTrace();
                }
            } catch (byte[] bArr22) {
                if (!an.a(bArr22)) {
                    bArr22.printStackTrace();
                }
            }
        }
        if (stringBuilder.length() == null) {
            return "unknown";
        }
        return stringBuilder.toString();
    }

    public static java.lang.String e(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a(r3);
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x002c }
        r2 = 64;	 Catch:{ NameNotFoundException -> 0x002c }
        r3 = r3.getPackageInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x002c }
        if (r3 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r0 = r3.signatures;
        if (r0 == 0) goto L_0x002b;
    L_0x0019:
        r0 = r0.length;
        if (r0 != 0) goto L_0x001d;
    L_0x001c:
        goto L_0x002b;
    L_0x001d:
        r3 = r3.signatures;
        r0 = 0;
        r3 = r3[r0];
        r3 = r3.toByteArray();
        r3 = a(r3);
        return r3;
    L_0x002b:
        return r1;
    L_0x002c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.AppInfo.e(android.content.Context):java.lang.String");
    }

    public static boolean f(Context context) {
        if (context == null) {
            return false;
        }
        if (c == null) {
            c = (ActivityManager) context.getSystemService("activity");
        }
        try {
            context = new MemoryInfo();
            c.getMemoryInfo(context);
            if (context.lowMemory == null) {
                return false;
            }
            an.c("Memory is low.", new Object[0]);
            return true;
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
            return false;
        }
    }
}
