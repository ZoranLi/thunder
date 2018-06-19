package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: TenDayGiftFrequentChecker */
public final class g {
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("tendaygift", 0);

    g() {
    }

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("frequent");
        return stringBuilder.toString();
    }

    public static String b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("pay");
        return stringBuilder.toString();
    }

    public final void a(int i) {
        this.a.edit().putInt(b(), i).commit();
    }

    public final boolean c() {
        long j = this.a.getLong(a(), 0);
        if (j != 0 && System.currentTimeMillis() - j <= 86400000) {
            return false;
        }
        return true;
    }
}
