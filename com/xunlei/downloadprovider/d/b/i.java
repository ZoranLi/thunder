package com.xunlei.downloadprovider.d.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.d.a;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.f;
import org.json.JSONArray;

/* compiled from: PaycenterConfig */
public final class i extends a {
    public static boolean f() {
        return true;
    }

    public final boolean a() {
        return a("detainment_popup", false);
    }

    public final boolean d(String str) {
        return a(str, false);
    }

    public final boolean b() {
        return a("task_list_limit_privilege", false);
    }

    public final int c() {
        JSONArray b = b("task_list_limit_max_count");
        if (b == null || b.length() <= 0) {
            return 10;
        }
        int optInt = b.optInt(0);
        if (optInt > 0) {
            return optInt;
        }
        return 10;
    }

    public final int d() {
        JSONArray b = b("task_list_limit_max_count");
        if (b == null || b.length() <= 1) {
            return 5;
        }
        int optInt = b.optInt(1);
        if (optInt > 0) {
            return optInt;
        }
        return 5;
    }

    public final boolean e() {
        return a("is_show_vip_continue_entrance_at_home_page", true);
    }

    public final boolean e(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ((TextUtils.equals(f.a(PayFrom.DOWNLOAD_TASK_FREE_TRIAL), str) || TextUtils.equals(f.a(PayFrom.DOWNLOAD_LIST_SPEEDUP), str)) && com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a().b()) {
                return false;
            }
            if (TextUtils.equals(f.a(PayFrom.DOWNLOAD_TASK_SUPER_SPEEDUP), str) != null) {
                return true;
            }
        }
        return a("downpage_payment_dialog_tab", 0) == 1;
    }

    public final boolean g() {
        return a("xunleivip_lixian_new", false);
    }

    public final boolean h() {
        return a("default_paytype", true);
    }

    public final boolean i() {
        return a("activity_vip_and_live_events", false);
    }

    public final boolean j() {
        return a("is_renew_new_style", false);
    }

    public final boolean k() {
        return a("xunleivip_play_accelerate_playing", false);
    }
}
