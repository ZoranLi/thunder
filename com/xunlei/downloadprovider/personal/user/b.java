package com.xunlei.downloadprovider.personal.user;

import android.content.SharedPreferences;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: CacheUserInfoManager */
public class b {
    private static b q;
    private final String a = "flow_total";
    private final String b = "flow_used";
    private final String c = "max_space";
    private final String d = "available_space";
    private final String e = "user_member_type";
    private final String f = "user_member_date";
    private final String g = "user_member_level";
    private final String h = "user_member_score";
    private final String i = "key_user_score";
    private final String j = "key_user_live_tip_status";
    private final String k = "key_user_live_tip_text";
    private final String l = "key_user_live_tip_icon_url";
    private final String m = "key_user_live_item_status";
    private final String n = "key_user_id";
    private final String o = "key_user_signed_time_stamp";
    private SharedPreferences p = BrothersApplication.getApplicationInstance().getSharedPreferences("user_center_sp_name", 0);

    private b() {
    }

    public static b a() {
        if (q == null) {
            synchronized (b.class) {
                if (q == null) {
                    q = new b();
                }
            }
        }
        return q;
    }

    public final void a(String str, long j) {
        this.p.edit().putLong(str, j).apply();
    }

    public final long a(String str) {
        return this.p.getLong(str, 0);
    }

    public final String a(String str, String str2) {
        return this.p.getString(str, str2);
    }

    public final void b() {
        StringBuilder stringBuilder = new StringBuilder("key_user_signed_time_stamp");
        stringBuilder.append(LoginHelper.a().g.c());
        a(stringBuilder.toString(), System.currentTimeMillis());
    }
}
