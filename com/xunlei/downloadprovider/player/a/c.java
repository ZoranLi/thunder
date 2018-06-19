package com.xunlei.downloadprovider.player.a;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: AutoPlaySpHelper */
public class c {
    public static String c = "auto_play_option";
    private static c d;
    public SharedPreferences a;
    public int b;

    private c() {
        this.b = 2;
        this.a = BrothersApplication.getApplicationInstance().getSharedPreferences("AutoPlay", 0);
        this.b = a(c);
    }

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    public final int a(String str) {
        return this.a != null ? this.a.getInt(str, 2) : -1;
    }
}
