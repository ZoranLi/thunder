package com.tencent.smtt.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.a.d;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.ApkHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class s {
    private static s a;
    private Handler b;

    private s() {
        this.b = null;
        this.b = new t(this, Looper.getMainLooper());
    }

    private int a(Context context) {
        return a(TbsConfig.APP_QB, context, 128) != null ? 2 : !TextUtils.isEmpty(e(context)) ? 1 : 0;
    }

    public static s a() {
        if (a == null) {
            a = new s();
        }
        return a;
    }

    private Map<String, String> a(String str) {
        Throwable th;
        if (str == null || str.length() <= 0) {
            return null;
        }
        Map<String, String> hashMap;
        try {
            hashMap = new HashMap();
            try {
                for (String str2 : str.split("\n")) {
                    if (str2 != null && str2.length() > 0) {
                        String[] split = str2.trim().split("=", 2);
                        if (split != null && split.length >= 2) {
                            String str3 = split[0];
                            Object obj = split[1];
                            if (str3 != null && str3.length() > 0) {
                                hashMap.put(str3, obj);
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th3) {
            th = th3;
            hashMap = null;
            th.printStackTrace();
            return hashMap;
        }
        return hashMap;
    }

    private void b(Context context) {
        Object obj = new Object[]{context};
        Message message = new Message();
        message.what = 1;
        message.obj = obj;
        this.b.sendMessage(message);
    }

    public static void b(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            d.a(context, str, null, null);
        }
    }

    private void c(Context context) {
        try {
            Object e = e(context);
            if (!TextUtils.isEmpty(e)) {
                File file = new File(e);
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    intent.setDataAndType(Uri.fromFile(file), ApkHelper.MIME_TYPE_APK);
                    context.startActivity(intent);
                    u.a(context).a(context.getApplicationInfo().processName);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void c(Context context, String str) {
        Object obj = new Object[]{context, str};
        Message message = new Message();
        message.what = 0;
        message.obj = obj;
        this.b.sendMessage(message);
    }

    private Map<String, String> d(Context context) {
        Throwable th;
        Throwable th2;
        String str = "";
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2;
            String str2 = "/data/data/com.tencent.mobileqq/app_tbs/share/QQBrowserDownloadInfo.ini";
            String str3 = "/data/data/com.qzone/app_tbs/share/QQBrowserDownloadInfo.ini";
            File file = new File("/data/data/com.tencent.mm/app_tbs/share/QQBrowserDownloadInfo.ini");
            if (!file.exists()) {
                file = new File(str2);
            }
            if (!file.exists()) {
                file = new File(str3);
            }
            if (file.exists()) {
                fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] b = k.b((InputStream) fileInputStream2);
                    if (b != null) {
                        str = new String(b, "utf-8");
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th2;
                }
            }
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th4) {
            th = th4;
            th.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return a(str);
        }
        return a(str);
    }

    private void d(Context context, String str) {
        Object obj = new Object[]{context, str};
        Message message = new Message();
        message.what = 2;
        message.obj = obj;
        this.b.sendMessage(message);
    }

    private String e(Context context) {
        Map d = d(context);
        if (d != null && d.size() > 0) {
            String str = (String) d.get("FileDownloadPath");
            String str2 = (String) d.get("FileDownloadVerifyInfo");
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(file.lastModified());
            if (TextUtils.equals(o.a(stringBuilder.toString()), str2)) {
                return str;
            }
        }
        return "";
    }

    private void e(Context context, String str) {
        if (context != null && str != null && str.length() > 0) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    public android.content.pm.PackageInfo a(java.lang.String r3, android.content.Context r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r4 == 0) goto L_0x0015;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r4 = r4.getPackageManager();	 Catch:{ Throwable -> 0x0013 }
        r3 = r4.getPackageInfo(r3, r5);	 Catch:{ Throwable -> 0x0013 }
        return r3;
    L_0x0013:
        r3 = r0;
        return r3;
    L_0x0015:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.s.a(java.lang.String, android.content.Context, int):android.content.pm.PackageInfo");
    }

    public boolean a(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("tbsqbdownload://")) {
                    String substring;
                    String[] split = str.substring(16).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    String str2 = null;
                    if (split.length > 1) {
                        String[] split2 = split[0].split("=");
                        substring = (split2.length <= 1 || !"url".equalsIgnoreCase(split2[0])) ? null : split[0].substring(4);
                        String[] split3 = split[1].split("=");
                        if (split3.length > 1 && "downloadurl".equalsIgnoreCase(split3[0])) {
                            str2 = split[1].substring(12);
                        }
                    } else {
                        substring = null;
                    }
                    if (substring == null || str2 == null) {
                        return false;
                    }
                    int a = a(context);
                    if (a == 2) {
                        c(context, substring);
                        return true;
                    } else if (a == 1) {
                        b(context);
                        return true;
                    } else {
                        if (a == 0) {
                            d(context, str2);
                        }
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
