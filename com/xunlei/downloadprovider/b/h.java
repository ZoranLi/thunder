package com.xunlei.downloadprovider.b;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AppPraiseSharedPreferenceHelper */
public final class h {
    private static h f;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("app_praise", 0);
    int b = -1;
    int c = -1;
    public int d = -1;
    long e = -1;

    private h() {
    }

    public static h a() {
        if (f == null) {
            f = new h();
        }
        return f;
    }
}
