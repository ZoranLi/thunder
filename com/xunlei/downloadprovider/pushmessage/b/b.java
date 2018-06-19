package com.xunlei.downloadprovider.pushmessage.b;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: PushSpHelper */
public final class b {
    private static b b = new b();
    public SharedPreferences a = null;

    private b() {
        if (BrothersApplication.getApplicationInstance() != null) {
            this.a = BrothersApplication.getApplicationInstance().getSharedPreferences("push", 0);
        }
    }

    public static b a() {
        return b;
    }

    public final void a(String str, String str2) {
        if (this.a != null) {
            this.a.edit().putString(str, str2).apply();
        }
    }

    public final String a(String str) {
        if (this.a == null) {
            return null;
        }
        return this.a.getString(str, null);
    }

    public final void a(long j) {
        if (this.a != null) {
            this.a.edit().putLong("update_last_time", j).apply();
        }
    }

    public final void a(String str, int i) {
        if (this.a != null) {
            this.a.edit().putInt(str, i).apply();
        }
    }

    public final int b(String str, int i) {
        if (this.a == null) {
            return i;
        }
        return this.a.getInt(str, i);
    }

    public final void a(boolean z) {
        String str = "user_login_status";
        if (this.a != null) {
            this.a.edit().putBoolean(str, z).apply();
        }
    }
}
