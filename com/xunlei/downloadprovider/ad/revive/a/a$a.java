package com.xunlei.downloadprovider.ad.revive.a;

import android.content.Context;
import com.xunlei.common.androidutil.PreferenceHelper;

/* compiled from: AdvertisementUtil */
public class a$a {
    public static long a;
    private static a$a c;
    Context b;

    private a$a(Context context) {
        this.b = context;
    }

    public static a$a a(Context context) {
        if (c == null) {
            c = new a$a(context.getApplicationContext());
        }
        return c;
    }

    public final void a(long j, long j2, String str) {
        PreferenceHelper preferenceHelper = new PreferenceHelper(this.b, "preference_revive_ad");
        preferenceHelper.setLong("backgroud_moment", j);
        preferenceHelper.setLong("backgroud_session", j2);
        preferenceHelper.setString("last_context_name", str);
    }
}
