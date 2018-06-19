package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MIPushNotificationHelper4Hybrid;
import com.xiaomi.xmpush.thrift.af;
import java.util.Map;

public class bg {
    public static Runnable a;

    private static String a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("typed_shield_pref", 4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("_title");
        return sharedPreferences.getString(stringBuilder.toString(), str);
    }

    public static String a(af afVar) {
        Map s = afVar.m().s();
        return s == null ? null : (String) s.get("__typed_shield_type");
    }

    @TargetApi(19)
    static void a(Context context, af afVar, Notification notification) {
        if (VERSION.SDK_INT >= 19) {
            String a = a(afVar);
            if (!TextUtils.isEmpty(a) && "com.xiaomi.xmsf".equals(ah.a(afVar))) {
                Bundle bundle = notification.extras;
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(MIPushNotificationHelper4Hybrid.KEY_PKGNAME, a);
                bundle.putString(MIPushNotificationHelper4Hybrid.KEY_TITLE, a(context, a));
                notification.extras = bundle;
            }
        }
    }

    public static boolean a(Context context, af afVar) {
        if (!"com.xiaomi.xmsf".equals(ah.a(afVar))) {
            return false;
        }
        String a = a(afVar);
        if (TextUtils.isEmpty(a)) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("typed_shield_pref", 4);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("_shield");
        if (!(sharedPreferences.contains(stringBuilder.toString()) || a == null)) {
            a.run();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("_shield");
        return sharedPreferences.getBoolean(stringBuilder.toString(), true);
    }
}
