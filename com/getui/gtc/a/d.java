package com.getui.gtc.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;

public class d {
    private static d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public static void a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                if (!TextUtils.isEmpty(applicationInfo.metaData.getString("GTC_C"))) {
                    a.f = String.format("http://%s/api.php?format=json&t=1", new Object[]{applicationInfo.metaData.getString("GTC_C")});
                }
                if (!TextUtils.isEmpty(applicationInfo.metaData.getString("GTC_B"))) {
                    a.g = String.format("http://%s/api.php?format=json&t=1", new Object[]{applicationInfo.metaData.getString("GTC_B")});
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }
}
