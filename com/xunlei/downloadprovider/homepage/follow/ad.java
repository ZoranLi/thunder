package com.xunlei.downloadprovider.homepage.follow;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.android.agoo.common.AgooConstants;

/* compiled from: FollowTabReporter */
public final class ad {
    private static List<d> a = new ArrayList();
    private static Set<d> b = new HashSet();

    public static void a(boolean z, String str, boolean z2, int i) {
        StringBuilder stringBuilder = new StringBuilder("reportFollowTabShow() hasRedPoint=");
        stringBuilder.append(z);
        stringBuilder.append(" from=");
        stringBuilder.append(str);
        stringBuilder.append(" isLogin=");
        stringBuilder.append(z2);
        stringBuilder.append(" followStatus=");
        stringBuilder.append(i);
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_show");
        build.add("is_point", z);
        build.add("from", str);
        build.add("login_type", z2);
        build.add("follow_status", i);
        a(build);
    }

    public static void a(String str, long j, String str2, boolean z) {
        StringBuilder stringBuilder = new StringBuilder("reportFollowTabContentClick() clickPosition=");
        stringBuilder.append(str);
        stringBuilder.append(" kind=");
        stringBuilder.append(str2);
        stringBuilder.append(" isLiving=");
        stringBuilder.append(z);
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_content_click");
        build.add("click_position", str);
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("author_type", b(str2));
        build.add("link_to", z ? "live" : "channelflow_space");
        a(build);
    }

    public static void a(boolean z, d dVar) {
        if (dVar != null) {
            if (!z || !b.contains(dVar)) {
                a.add(dVar);
                b.add(dVar);
                if (a.size() >= true) {
                    b();
                }
            }
        }
    }

    public static void a() {
        b.clear();
    }

    public static void b() {
        if (!a.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (d dVar : a) {
                if (!TextUtils.isEmpty(dVar.b.getVideoId())) {
                    stringBuilder.append(dVar.b.getVideoId());
                    stringBuilder.append('_');
                    if (dVar.b.isFromYouLiaoShot()) {
                        stringBuilder2.append(dVar.b.getVideoId());
                        stringBuilder2.append('_');
                    }
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            }
            StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_video_show");
            build.add("movie_list", stringBuilder.toString());
            build.add("format_type", "followtab_auto_list");
            build.add("transform_list", stringBuilder2.toString());
            a(build);
            a.clear();
        }
    }

    private static String b(String str) {
        if ("rad".equals(str)) {
            return "host";
        }
        if ("pub".equals(str)) {
            return "channel";
        }
        if ("per".equals(str)) {
            return "personal";
        }
        if (!("yl_nanshen".equals(str) || "yl_nvshen".equals(str))) {
            if ("yl_daren".equals(str) == null) {
                return "";
            }
        }
        return "youliao_talent";
    }

    private static String a(List<Long> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Long append : list) {
                    stringBuilder.append(append);
                    stringBuilder.append('_');
                }
                if (stringBuilder.length() > null) {
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                return stringBuilder.toString();
            }
        }
        return "";
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_common_click");
        build.add("clickid", str);
        a(build);
    }

    public static void a(String str, long j, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_video_click");
        build.add("movieid", str);
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("author_type", b(str2));
        build.add("format_type", str3);
        a(build);
    }

    public static void a(List<Long> list, boolean z, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_followAll_result");
        build.add("id_list", a((List) list));
        build.add("result", str);
        build.add("login_type", z);
        build.add("errorcode", str2);
        a(build);
    }

    public static void a(long j, String str, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_follow_click_result");
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("author_type", b(str));
        build.add("login_type", z);
        build.add("result", str2);
        build.add("error", str3);
        a(build);
    }

    public static void a(String str, long j, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_zan");
        build.add("movieid", str);
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("action", str2);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_discuss_click");
        build.add("movieid", str);
        build.add(AgooConstants.MESSAGE_ID, str2);
        a(build);
    }

    public static void a(String str, long j, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followtab_share_result");
        build.add("movieid", str);
        build.add(AgooConstants.MESSAGE_ID, j);
        build.add("to", str2);
        build.add("result", str3);
        build.add("errorCode", str4);
        a(build);
    }

    public static void c() {
        a(HubbleEventBuilder.build("android_followtab", "followSub_show"));
    }

    public static void b(long j, String str, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followSub_follow_click_result");
        build.add("author_id", j);
        build.add("author_type", b(str));
        build.add("login_type", z);
        build.add("result", str2);
        build.add("error", str3);
        a(build);
    }

    public static void b(List<Long> list, boolean z, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_followtab", "followSub_followAll_click_result");
        build.add("id_list", a((List) list));
        build.add("login_type", z);
        build.add("result", str);
        build.add("error", str2);
        a(build);
    }
}
