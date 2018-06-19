package com.xunlei.downloadprovider.homepage.choiceness.a;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: ChoicenessSpHelper */
public final class t {
    private static t b = new t();
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("choiceness", 0);

    private t() {
    }

    public static t a() {
        return b;
    }

    public final void a(long j) {
        this.a.edit().putLong("ChoicenessLastRefreshTime", j).apply();
    }
}
