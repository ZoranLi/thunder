package com.xunlei.downloadprovider.personal.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sina.weibo.sdk.utils.NetworkHelper;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.aj;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;

/* compiled from: CacheUserInfoManager */
public class a {
    private static a z;
    private final String a = "user_member_type";
    private final String b = "user_member_date";
    private final String c = "user_member_level";
    private final String d = "user_member_score";
    private final String e = "key_user_follow_count";
    private final String f = "key_user_fans_count";
    private final String g = "key_user_visitor_count";
    private final String h = "key_user_score";
    private final String i = "key_user_signed_time_stamp";
    private final String j = "key_unread_comment_count";
    private final String k = "key_unread_follow_count";
    private final String l = "key_unread_start_count";
    private final String m = "key_unread_chat_count";
    private final String n = "key_unread_visitor_count";
    private final String o = "key_new_unread_comment_count";
    private final String p = "key_new_unread_follow_count";
    private final String q = "key_new_unread_star_count";
    private final String r = "key_new_unread_chat_count";
    private final String s = "key_new_unread_visitor_count";
    private final String t = "key_grid_red_point_clicked";
    private final String u = "key_grid_red_point_start_time";
    private final String v = "key_grid_red_point_end_time";
    private final String w = "key_user_total_not_receive_score";
    private final String x = "key_grid_red_point_score";
    private SharedPreferences y = BrothersApplication.getApplicationInstance().getSharedPreferences("user_center_sp_name", 0);

    private a() {
    }

    public static a a() {
        if (z == null) {
            synchronized (a.class) {
                if (z == null) {
                    z = new a();
                }
            }
        }
        return z;
    }

    public static Context b() {
        return BrothersApplication.getApplicationInstance();
    }

    public final void a(String str, long j) {
        this.y.edit().putLong(str, j).apply();
    }

    public final long b(String str, long j) {
        return this.y.getLong(str, j);
    }

    public final void a(String str, String str2) {
        this.y.edit().putString(str, str2).apply();
    }

    public final String b(String str, String str2) {
        return this.y.getString(str, str2);
    }

    public final void a(String str, int i) {
        this.y.edit().putInt(str, i).apply();
    }

    public final int a(String str) {
        return this.y.getInt(str, 0);
    }

    public final void d() {
        StringBuilder stringBuilder = new StringBuilder("key_user_signed_time_stamp");
        stringBuilder.append(LoginHelper.a().g.c());
        a(stringBuilder.toString(), System.currentTimeMillis());
    }

    public final boolean e() {
        StringBuilder stringBuilder = new StringBuilder("key_user_signed_time_stamp");
        stringBuilder.append(LoginHelper.a().g.c());
        return DateUtil.isTheSameDay(b(stringBuilder.toString(), -1), System.currentTimeMillis());
    }

    public final int f() {
        StringBuilder stringBuilder = new StringBuilder("key_user_total_not_receive_score");
        stringBuilder.append(LoginHelper.a().g.c());
        return a(stringBuilder.toString());
    }

    public final boolean a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder("key_grid_red_point_start_time");
        stringBuilder.append(str);
        String b = b(stringBuilder.toString(), "");
        StringBuilder stringBuilder2 = new StringBuilder("key_grid_red_point_end_time");
        stringBuilder2.append(str);
        String b2 = b(stringBuilder2.toString(), "");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        if (str2.equals(b) && str3.equals(b2)) {
            stringBuilder = new StringBuilder("key_grid_red_point_clicked");
            stringBuilder.append(str);
            if (a(stringBuilder.toString()) == 1) {
                return false;
            }
        }
        str = Long.valueOf(str2).longValue();
        long longValue = Long.valueOf(str3).longValue();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis <= str || currentTimeMillis >= longValue) {
            return false;
        }
        return true;
    }

    public final void b(String str) {
        StringBuilder stringBuilder = new StringBuilder("key_grid_red_point_clicked");
        stringBuilder.append(str);
        a(stringBuilder.toString(), 1);
    }

    public final void c() {
        int f;
        if (NetworkHelper.isNetworkAvailable(BrothersApplication.getApplicationInstance())) {
            String str = "";
            boolean l = LoginHelper.a().l();
            f = LoginHelper.a().g.f();
            if (l) {
                switch (f) {
                    case 1:
                        str = BrothersApplication.getApplicationInstance().getResources().getString(R.string.user_member_type_mini);
                        break;
                    case 2:
                        str = BrothersApplication.getApplicationInstance().getResources().getString(R.string.user_member_type_vip);
                        break;
                    case 3:
                        str = BrothersApplication.getApplicationInstance().getResources().getString(R.string.user_member_type_platinum);
                        break;
                    case 4:
                        str = BrothersApplication.getApplicationInstance().getResources().getString(R.string.user_member_type_diamond);
                        break;
                    case 5:
                        str = BrothersApplication.getApplicationInstance().getResources().getString(R.string.user_member_type_super_vip);
                        break;
                    default:
                        break;
                }
            }
            a("user_member_type", str);
        }
        if (NetworkHelper.isNetworkAvailable(BrothersApplication.getApplicationInstance())) {
            a("user_member_date", PayUtil.a(LoginHelper.a().o()));
        }
        if (NetworkHelper.isNetworkAvailable(BrothersApplication.getApplicationInstance())) {
            int p = LoginHelper.a().p();
            int a = aj.a(p);
            f = aj.b(a);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(p);
            stringBuilder.append("/");
            stringBuilder.append(f);
            a("user_member_score", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("LV");
            stringBuilder2.append(a);
            a("user_member_level", stringBuilder2.toString());
        }
    }
}
