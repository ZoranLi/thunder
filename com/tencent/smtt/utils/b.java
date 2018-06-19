package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    private static PackageInfo a(String str, int i) {
        try {
            Class cls = Class.forName("android.content.pm.PackageParser");
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
            }
            Class cls22 = null;
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
            Method declaredMethod2 = cls.getDeclaredMethod("collectCertificates", new Class[]{cls22, Integer.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("generatePackageInfo", new Class[]{cls22, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE});
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[]{str});
            new DisplayMetrics().setToDefaults();
            if (declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}) == null) {
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, new Object[]{r14, Integer.valueOf(0)});
            }
            return (PackageInfo) declaredMethod3.invoke(null, new Object[]{r14, null, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x000b;
    L_0x0008:
        r0 = c;
        return r0;
    L_0x000b:
        r0 = 0;
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r2 = "getprop ro.product.cpu.abi";	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r1 = r1.exec(r2);	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r1 = r1.getInputStream();	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x005a, all -> 0x0055 }
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x0050, all -> 0x004b }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0050, all -> 0x004b }
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x0049 }
        r3 = "x86";	 Catch:{ Throwable -> 0x0049 }
        r0 = r0.contains(r3);	 Catch:{ Throwable -> 0x0049 }
        if (r0 == 0) goto L_0x0037;	 Catch:{ Throwable -> 0x0049 }
    L_0x0030:
        r0 = "i686";	 Catch:{ Throwable -> 0x0049 }
    L_0x0032:
        r0 = a(r0);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x003e;	 Catch:{ Throwable -> 0x0049 }
    L_0x0037:
        r0 = "os.arch";	 Catch:{ Throwable -> 0x0049 }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ Throwable -> 0x0049 }
        goto L_0x0032;
    L_0x003e:
        if (r1 == 0) goto L_0x0043;
    L_0x0040:
        r1.close();	 Catch:{ IOException -> 0x0043 }
    L_0x0043:
        if (r2 == 0) goto L_0x0076;
    L_0x0045:
        r2.close();	 Catch:{ IOException -> 0x0076 }
        return r0;
    L_0x0049:
        r0 = move-exception;
        goto L_0x005e;
    L_0x004b:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0078;
    L_0x0050:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x005e;
    L_0x0055:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
        goto L_0x0078;
    L_0x005a:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
    L_0x005e:
        r3 = "os.arch";	 Catch:{ all -> 0x0077 }
        r3 = java.lang.System.getProperty(r3);	 Catch:{ all -> 0x0077 }
        r3 = a(r3);	 Catch:{ all -> 0x0077 }
        r0.printStackTrace();	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0070;
    L_0x006d:
        r1.close();	 Catch:{ IOException -> 0x0070 }
    L_0x0070:
        if (r2 == 0) goto L_0x0075;
    L_0x0072:
        r2.close();	 Catch:{ IOException -> 0x0075 }
    L_0x0075:
        r0 = r3;
    L_0x0076:
        return r0;
    L_0x0077:
        r0 = move-exception;
    L_0x0078:
        if (r1 == 0) goto L_0x007d;
    L_0x007a:
        r1.close();	 Catch:{ IOException -> 0x007d }
    L_0x007d:
        if (r2 == 0) goto L_0x0082;
    L_0x007f:
        r2.close();	 Catch:{ IOException -> 0x0082 }
    L_0x0082:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a():java.lang.String");
    }

    public static java.lang.String a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageName();	 Catch:{ Exception -> 0x0010 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0010 }
        r1 = 0;	 Catch:{ Exception -> 0x0010 }
        r2 = r2.getPackageInfo(r0, r1);	 Catch:{ Exception -> 0x0010 }
        r2 = r2.versionName;	 Catch:{ Exception -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context):java.lang.String");
    }

    public static String a(Context context, File file) {
        String a = a(context, file, false);
        if (a == null) {
            a = a(file);
        }
        return a == null ? a(context, file, true) : a;
    }

    private static String a(Context context, File file, boolean z) {
        Signature signature;
        PackageInfo a = z ? a(file.getAbsolutePath(), 65) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        if (a != null) {
            if (a.signatures == null || a.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = a.signatures[0];
                return signature == null ? signature.toCharsString() : null;
            }
        }
        signature = null;
        if (signature == null) {
        }
    }

    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageName();	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0026 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getApplicationInfo(r0, r1);	 Catch:{ Exception -> 0x0026 }
        r2 = r2.metaData;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.get(r3);	 Catch:{ Exception -> 0x0026 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0026 }
        r3 = java.lang.Integer.parseInt(r2);	 Catch:{ Exception -> 0x0027 }
        r3 = java.lang.Integer.toHexString(r3);	 Catch:{ Exception -> 0x0027 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0027 }
        r2 = r3;
        return r2;
    L_0x0026:
        r2 = 0;
    L_0x0027:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private static String a(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[8192];
            String a = a(a(jarFile, jarFile.getJarEntry(ShareConstants.RES_MANIFEST), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a2 = a(jarFile, jarEntry, bArr);
                    String a3 = a2 != null ? a(a2[0].getEncoded()) : null;
                    if (a3 == null) {
                        if (!name.startsWith("META-INF/")) {
                            return null;
                        }
                    } else if (!a3.equals(a)) {
                        return null;
                    }
                }
            }
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static String a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (97 + i4) - 10 : 48 + i4);
        }
        return new String(cArr);
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        return jarEntry != null ? jarEntry.getCertificates() : null;
    }

    public static int b(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r2.getPackageName();	 Catch:{ Exception -> 0x0010 }
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0010 }
        r2 = r2.getPackageInfo(r1, r0);	 Catch:{ Exception -> 0x0010 }
        r2 = r2.versionCode;	 Catch:{ Exception -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.b.b(android.content.Context):int");
    }

    public static String c(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String d(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String e(Context context) {
        String str = "";
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
            return connectionInfo == null ? "" : connectionInfo.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        try {
            e = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return e;
    }
}
