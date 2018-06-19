package com.xunlei.downloadprovider.homepage.follow;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: FollowSharedPreferenceHelper */
public final class ac {
    private static ac b;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("follow_config", 0);

    public static ac a() {
        if (b == null) {
            b = new ac();
        }
        return b;
    }

    private ac() {
    }

    public final void a(long j) {
        this.a.edit().putLong("latest_p_time", j).apply();
    }

    public final void a(String str) {
        this.a.edit().putString("latest_feed_id", str).apply();
    }

    public final void a(boolean z) {
        this.a.edit().putBoolean("is_follow_tab_red_point_show", z).apply();
    }

    public final void b(boolean z) {
        this.a.edit().putBoolean("is_live_tag_show", z).apply();
    }

    public final boolean b() {
        return this.a.getBoolean("is_live_tag_show", false);
    }

    public final void c(boolean z) {
        this.a.edit().putBoolean("is_live_tab_red_point_show", z).apply();
    }
}
