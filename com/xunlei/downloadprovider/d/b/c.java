package com.xunlei.downloadprovider.d.b;

import com.xunlei.downloadprovider.d.a;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: DownloadTaskConfig */
public final class c extends a {
    public static boolean b() {
        return true;
    }

    public final boolean a() {
        return a("is_show_accelerate_tip_for_player", true);
    }

    public final List c() {
        List arrayList = new ArrayList(2);
        JSONArray b = b("vip_array_for_stalling");
        if (b == null) {
            arrayList.add(Integer.valueOf(3));
            arrayList.add(Integer.valueOf(6));
            return arrayList;
        }
        int length = b.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(b.optInt(i)));
        }
        return arrayList;
    }

    public final int d() {
        return a("trade_amount_show_interval_days", 1);
    }

    public final boolean e() {
        return a("is_listen_clipboard_download_url", false);
    }

    public final int f() {
        return a("download_card_display_type", 0);
    }

    public final boolean g() {
        return a("is_show_poster_on_reported_resource", false);
    }

    public final boolean h() {
        return a("is_show_search_again_when_download_exception", true);
    }

    public final boolean i() {
        if (b.c()) {
            return a("home_recommend_feed_enable", false);
        }
        return a("download_recommend_feed_enable", false);
    }

    public final boolean j() {
        return a("home_recommend_feed_enable", false);
    }

    public final int k() {
        return a("home_recommond_feed_refresh_frequency", 5);
    }

    public final boolean l() {
        return a("download_recommend_feed_enable", false);
    }

    public final int m() {
        return a("free_try_total_count", 0);
    }

    public final int n() {
        return a("free_try_today_remain_time", 0);
    }

    public static boolean o() {
        c cVar = d.a().d;
        boolean l = LoginHelper.a().l();
        if (l && cVar.a("is_private_space_show_on_vip", true)) {
            return true;
        }
        if (l || !cVar.a("is_private_space_show", true)) {
            return false;
        }
        return true;
    }

    public final boolean p() {
        return a("is_listen_clipboard_open_url", false);
    }

    public final boolean q() {
        return a("is_show_new_download_details", false);
    }

    public final boolean r() {
        return a("is_show_global_bxbb_notify", false);
    }

    public final boolean s() {
        return a("download_center_play_btn_to_detail_page_switch", false);
    }

    public final boolean t() {
        return a("download_detail_aotuplay_next_task_switch", false);
    }

    public final boolean u() {
        return a("is_show_playing_progress_in_comment", false);
    }

    public final boolean v() {
        return a("is_show_thunder_command_in_share_dialog", false);
    }
}
