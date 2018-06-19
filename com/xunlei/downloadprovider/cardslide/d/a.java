package com.xunlei.downloadprovider.cardslide.d;

import android.content.SharedPreferences;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: CardSlideSpHelper */
public class a {
    private static a d;
    private final String a = "next_dawn_time_stamp";
    private final String b = "slide_card_time_stamp";
    private SharedPreferences c = BrothersApplication.getApplicationInstance().getSharedPreferences("card_slide_sp_name", 0);

    private a() {
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public final void b() {
        XLThreadPool.execute(new b(this));
    }

    public final long c() {
        return this.c.getLong("next_dawn_time_stamp", 0);
    }
}
