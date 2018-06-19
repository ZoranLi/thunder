package com.xunlei.downloadprovider.player;

import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: AndroidPlayerReporter */
public final class a {

    /* compiled from: AndroidPlayerReporter */
    public static class a {
        public int A;
        public int B;
        public String C;
        public String D;
        public String E;
        public String a;
        public String b;
        public String c;
        public String d;
        public long e;
        public long f;
        public long g;
        public long h;
        public String i;
        public String j;
        public String k;
        public long l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public long r;
        public long s;
        public long t;
        public long u;
        public String v = "";
        public boolean w;
        public boolean x;
        public String y;
        public long z;
    }

    /* compiled from: AndroidPlayerReporter */
    public static class b {
        public String A;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public long f;
        public String g;
        public String h;
        public String i;
        public String j;
        public long k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public String s;
        public long t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_player", "player_screen_click");
        build.add("movieid", str);
        build.add("type", str2);
        build.add("clickid", str3);
        ThunderReport.reportEvent(build);
        new StringBuilder("[STAT_EVENT]").append(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_player", "player_share_float_show");
        build.add("sense", str);
        ThunderReport.reportEvent(build);
    }

    public static void b(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_player", "player_share_to");
        build.add("from", str);
        str = "to";
        if (str2 == null) {
            str2 = "";
        }
        build.add(str, str2);
        build.add("sense", str3);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_player", "player_pause");
        build.add("from", str);
        build.add("button_model", str2);
        build.add("play_type", str3);
        build.add("task_type", str4);
        ThunderReport.reportEvent(build);
    }

    public static void a(String str, String str2, boolean z) {
        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_kadun_show");
        build.add("product_type", str2);
        build.add("userid", str);
        build.add("vipspeedup_try", z);
        ThunderReport.reportEvent(build);
    }

    public static void a(int i, int i2) {
        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_vipspeedup_try_state");
        build.add(XiaomiOAuthConstants.EXTRA_STATE_2, i);
        build.add("scene", i2);
        ThunderReport.reportEvent(build);
    }

    public static void c(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_play", "subtitle_pannel_action");
        build.add("action", str3);
        build.add("gcid", str);
        build.add("cid", str2);
        ThunderReport.reportEvent(build);
    }

    public static void a() {
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_play", "play_setting_show"));
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_play", "play_setting_click");
        build.add("action", str);
        ThunderReport.reportEvent(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build("android_player", "player_float_window_click");
        build.add("clickid", str);
        ThunderReport.reportEvent(build);
    }
}
