package com.alipay.sdk.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import anet.channel.util.HttpConstant;
import com.alipay.mobilesecuritysdk.face.SecurityClientMobile;
import com.alipay.sdk.cons.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.h;
import com.alipay.sdk.util.j;
import com.alipay.sdk.util.k;
import com.qihoo360.replugin.RePlugin;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public final class c {
    private static final String d = "virtualImeiAndImsi";
    private static final String e = "virtual_imei";
    private static final String f = "virtual_imsi";
    private static c g;
    public String a;
    public String b = "sdk-and-lite";
    public String c;

    private static String d() {
        return "1";
    }

    private static String e() {
        return "-1;-1";
    }

    private String c() {
        return this.c;
    }

    private c() {
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (g == null) {
                g = new c();
            }
            cVar = g;
        }
        return cVar;
    }

    public final synchronized void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            PreferenceManager.getDefaultSharedPreferences(b.a().a).edit().putString(com.alipay.sdk.cons.b.i, str).commit();
            a.b = str;
        }
    }

    private static String a(Context context) {
        return Float.toString(new TextView(context).getTextSize());
    }

    private String a(com.alipay.sdk.tid.b bVar) {
        String a;
        String b;
        String e;
        String a2;
        String f;
        String f2;
        com.alipay.sdk.tid.b bVar2 = bVar;
        Context context = b.a().a;
        com.alipay.sdk.util.a a3 = com.alipay.sdk.util.a.a(context);
        if (TextUtils.isEmpty(this.a)) {
            a = k.a();
            b = k.b();
            e = k.e(context);
            a2 = j.a(context);
            a2 = a2.substring(0, a2.indexOf(HttpConstant.SCHEME_SPLIT));
            f = k.f(context);
            f2 = Float.toString(new TextView(context).getTextSize());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Msp/15.2.0");
            stringBuilder.append(" (");
            stringBuilder.append(a);
            stringBuilder.append(h.b);
            stringBuilder.append(b);
            stringBuilder.append(h.b);
            stringBuilder.append(e);
            stringBuilder.append(h.b);
            stringBuilder.append(a2);
            stringBuilder.append(h.b);
            stringBuilder.append(f);
            stringBuilder.append(h.b);
            stringBuilder.append(f2);
            r0.a = stringBuilder.toString();
        }
        String str = com.alipay.sdk.util.a.b(context).p;
        a = "-1;-1";
        b = "1";
        e = a3.a();
        a2 = a3.b();
        Context context2 = b.a().a;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
                Object c = b.a().c();
                f = TextUtils.isEmpty(c) ? b() : c.substring(3, 18);
            } else {
                f = com.alipay.sdk.util.a.a(context2).a();
            }
            string = f;
            sharedPreferences.edit().putString(f, string).commit();
        }
        context2 = b.a().a;
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences(d, 0);
        f2 = sharedPreferences2.getString(e, null);
        if (TextUtils.isEmpty(f2)) {
            f2 = TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a) ? b() : com.alipay.sdk.util.a.a(context2).b();
            sharedPreferences2.edit().putString(e, f2).commit();
        }
        if (bVar2 != null) {
            r0.c = bVar2.b;
        }
        String replace = Build.MANUFACTURER.replace(h.b, " ");
        f = Build.MODEL.replace(h.b, " ");
        boolean b2 = b.b();
        String str2 = a3.a;
        WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        String ssid = connectionInfo != null ? connectionInfo.getSSID() : RePlugin.PROCESS_UI;
        WifiInfo connectionInfo2 = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        String bssid = connectionInfo2 != null ? connectionInfo2.getBSSID() : "00";
        Context context3 = context;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(r0.a);
        stringBuilder2.append(h.b);
        stringBuilder2.append(str);
        stringBuilder2.append(h.b);
        stringBuilder2.append(a);
        stringBuilder2.append(h.b);
        stringBuilder2.append(b);
        stringBuilder2.append(h.b);
        stringBuilder2.append(e);
        stringBuilder2.append(h.b);
        stringBuilder2.append(a2);
        stringBuilder2.append(h.b);
        stringBuilder2.append(r0.c);
        stringBuilder2.append(h.b);
        stringBuilder2.append(replace);
        stringBuilder2.append(h.b);
        stringBuilder2.append(f);
        stringBuilder2.append(h.b);
        stringBuilder2.append(b2);
        stringBuilder2.append(h.b);
        stringBuilder2.append(str2);
        stringBuilder2.append(";-1;-1;");
        stringBuilder2.append(r0.b);
        stringBuilder2.append(h.b);
        stringBuilder2.append(string);
        stringBuilder2.append(h.b);
        stringBuilder2.append(f2);
        stringBuilder2.append(h.b);
        stringBuilder2.append(ssid);
        stringBuilder2.append(h.b);
        stringBuilder2.append(bssid);
        bVar2 = bVar;
        if (bVar2 != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(com.alipay.sdk.cons.b.c, bVar2.a);
            hashMap.put("utdid", b.a().c());
            Object b3 = b(context3, hashMap);
            if (!TextUtils.isEmpty(b3)) {
                stringBuilder2.append(h.b);
                stringBuilder2.append(b3);
            }
        }
        stringBuilder2.append(com.umeng.message.proguard.k.t);
        return stringBuilder2.toString();
    }

    private static String f() {
        Context context = b.a().a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(e, null);
        if (TextUtils.isEmpty(string)) {
            String b;
            if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
                b = b();
            } else {
                b = com.alipay.sdk.util.a.a(context).b();
            }
            string = b;
            sharedPreferences.edit().putString(e, string).commit();
        }
        return string;
    }

    private static String g() {
        Context context = b.a().a;
        SharedPreferences sharedPreferences = context.getSharedPreferences(d, 0);
        String string = sharedPreferences.getString(f, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String b;
        if (TextUtils.isEmpty(com.alipay.sdk.tid.b.a().a)) {
            Object c = b.a().c();
            if (TextUtils.isEmpty(c)) {
                b = b();
            } else {
                b = c.substring(3, 18);
            }
        } else {
            b = com.alipay.sdk.util.a.a(context).a();
        }
        string = b;
        sharedPreferences.edit().putString(f, string).commit();
        return string;
    }

    public static String b() {
        String toHexString = Long.toHexString(System.currentTimeMillis());
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toHexString);
        stringBuilder.append(1000 + random.nextInt(9000));
        return stringBuilder.toString();
    }

    private static String b(Context context) {
        context = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return context != null ? context.getSSID() : RePlugin.PROCESS_UI;
    }

    private static String c(Context context) {
        context = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        return context != null ? context.getBSSID() : "00";
    }

    static String a(Context context, HashMap<String, String> hashMap) {
        String str = "";
        try {
            context = SecurityClientMobile.GetApdid(context, hashMap);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.f, th);
            context = str;
        }
        if (TextUtils.isEmpty(context) != null) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.g, "apdid == null");
        }
        return context;
    }

    public final String b(Context context, HashMap<String, String> hashMap) {
        context = Executors.newFixedThreadPool(2).submit(new d(this, context, hashMap));
        hashMap = "";
        try {
            return (String) context.get(3000, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.e, com.alipay.sdk.app.statistic.c.h, th);
            return hashMap;
        }
    }
}
