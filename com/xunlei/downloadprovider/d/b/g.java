package com.xunlei.downloadprovider.d.b;

import com.xunlei.downloadprovider.d.a;

/* compiled from: HomePageConfig */
public final class g extends a {
    public final int a() {
        return a("short_movie_type", 0);
    }

    public final boolean b() {
        return a("show_follow_page", false);
    }

    public final boolean c() {
        return a("show_follow_page_after_guide", false);
    }

    public final String d() {
        return a("guide_follow_begin_time", "00:00");
    }

    public final String e() {
        return a("guide_follow_end_time", "23:59");
    }

    public final boolean f() {
        return a("is_guide_interest_tag_show", false);
    }

    public final double g() {
        double a = a("red_point_interval");
        return a < 0.0d ? 1.0d : a;
    }

    public final boolean h() {
        return a("player_fix_on_top", true);
    }

    public final boolean i() {
        return a("is_preload_opened", false);
    }

    public final int j() {
        return a("auto_refresh_interval", 30);
    }

    public final boolean k() {
        return a("is_quick_comment_opened", false);
    }

    public final boolean l() {
        return a("is_app_praise_dlg_show", true);
    }

    public final boolean m() {
        return a("is_home_activity_dlg_show", false);
    }

    public final boolean n() {
        return a("is_play_over_praise_guide_show", false);
    }

    public final boolean o() {
        return a("is_game_info_show", true);
    }

    public final int p() {
        return a("photo_article_poster_num", 1);
    }

    public final boolean q() {
        return a("is_clear_data_on_refresh", false);
    }

    public final int r() {
        return a("website_display_type", 2);
    }

    public final boolean s() {
        return a("should_clear_local_cache", false);
    }

    public final boolean t() {
        return a("show_publish_time_ten_days_ago", false);
    }

    public final boolean u() {
        return a("short_movie_detail_recommend_site_switch", false);
    }

    public final boolean v() {
        return c("home_dynamic_recommend_switch");
    }

    public final int w() {
        return b("home_dynamic_recommend_played_videos_count_before_next_round", 3);
    }

    public final boolean x() {
        return a("app_exit_to_background", false);
    }

    public final int y() {
        return a("short_movie_recommend_collapse_size", 8);
    }

    public final int z() {
        return a("short_movie_recommend_total_size", 20);
    }
}
