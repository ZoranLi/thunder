package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
public class f {
    private static f a;
    private volatile WeakReference<SharedPreferences> b = null;

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (a == null) {
                a = new f();
            }
            fVar = a;
        }
        return fVar;
    }

    public String a(Context context, String str) {
        StringBuilder stringBuilder;
        if (this.b == null || this.b.get() == null) {
            this.b = new WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            context = new URL(str).getHost();
            StringBuilder stringBuilder2;
            if (context == null) {
                stringBuilder2 = new StringBuilder("Get host error. url=");
                stringBuilder2.append(str);
                com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", stringBuilder2.toString());
                return str;
            }
            Object string = ((SharedPreferences) this.b.get()).getString(context, null);
            if (string != null) {
                if (!context.equals(string)) {
                    context = str.replace(context, string);
                    try {
                        stringBuilder2 = new StringBuilder("return environment url : ");
                        stringBuilder2.append(context);
                        com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", stringBuilder2.toString());
                        return context;
                    } catch (String str2) {
                        String str3 = str2;
                        str2 = context;
                        context = str3;
                        stringBuilder = new StringBuilder("getEnvUrl url=");
                        stringBuilder.append(str2);
                        stringBuilder.append("error.: ");
                        stringBuilder.append(context.getMessage());
                        com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", stringBuilder.toString());
                        return str2;
                    }
                }
            }
            StringBuilder stringBuilder3 = new StringBuilder("host=");
            stringBuilder3.append(context);
            stringBuilder3.append(", envHost=");
            stringBuilder3.append(string);
            com.tencent.open.a.f.a("openSDK_LOG.ServerSetting", stringBuilder3.toString());
            return str2;
        } catch (Exception e) {
            context = e;
            stringBuilder = new StringBuilder("getEnvUrl url=");
            stringBuilder.append(str2);
            stringBuilder.append("error.: ");
            stringBuilder.append(context.getMessage());
            com.tencent.open.a.f.e("openSDK_LOG.ServerSetting", stringBuilder.toString());
            return str2;
        }
    }
}
