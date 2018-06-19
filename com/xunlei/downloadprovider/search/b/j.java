package com.xunlei.downloadprovider.search.b;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: SearchSpHelper */
public final class j {
    private static j a = new j();
    private SharedPreferences b = BrothersApplication.getApplicationInstance().getSharedPreferences("search", 0);

    private j() {
    }

    public static j a() {
        return a;
    }
}
