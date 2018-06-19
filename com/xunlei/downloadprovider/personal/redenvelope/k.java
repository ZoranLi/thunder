package com.xunlei.downloadprovider.personal.redenvelope;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: RedSpHelper */
public final class k {
    public static SharedPreferences a;
    private static k b;

    private k() {
        a = BrothersApplication.getApplicationInstance().getSharedPreferences("red_packet", 0);
    }

    public static k a() {
        if (b == null) {
            b = new k();
        }
        return b;
    }

    public static void a(String str) {
        Editor edit = a.edit();
        edit.putBoolean(str, true);
        edit.apply();
    }
}
