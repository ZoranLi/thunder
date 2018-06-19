package com.xunlei.downloadprovider.homepage.recommend;

import android.net.Uri;
import com.alipay.sdk.app.statistic.c;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.recommend.feed.y;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public final class VideoFeedReporter {
    private static List<y> a = new ArrayList();
    private static Set<y> b = new HashSet();

    public enum RefreshType {
        single_click_bottom_rec,
        double_click_top_tab,
        single_click_top_tab,
        auto_pull,
        manul_pull
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_player_click");
        build.addString("clickid", str);
        build.addString("movieid", str2);
        build.addString("rec_params", str3);
        build.addString("platformModel", AndroidConfig.getPhoneModel());
        build.addString(c.a, b.c(BrothersApplication.getApplicationInstance()));
        build.addString("format_type", str4);
        a(build);
    }

    public static void a(String str, String str2, String str3, boolean z) {
        if (str3.equals("pub")) {
            str3 = "channel";
        } else if (str3.equals("per")) {
            str3 = "personal";
        }
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_follow_click");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("login_type", z);
        a(build);
    }

    public static void a(String str, String str2, String str3, boolean z, String str4, String str5) {
        if (str3.equals("pub")) {
            str3 = "channel";
        } else if (str3.equals("per")) {
            str3 = "personal";
        }
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_follow_click_result");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("login_type", z);
        build.add("result", str4);
        build.add("error", str5);
        a(build);
    }

    public static void a(boolean z, y yVar, int i) {
        if (yVar != null) {
            if (!z || !b.contains(yVar)) {
                z = new StringBuilder("tryReportVideoFeedExposure--feedflow_video_show--isComplete=");
                z.append(yVar.f);
                z.append("|id=");
                z.append(yVar.a.getVideoId());
                a.add(yVar);
                b.add(yVar);
                if (a.size() >= true) {
                    a(i);
                }
            }
        }
    }

    public static void b() {
        b.clear();
    }

    public static void a(int i) {
        if (!a.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (y yVar : a) {
                stringBuilder.append(yVar.a.getVideoId());
                stringBuilder.append('_');
                if (yVar.f) {
                    stringBuilder2.append(yVar.a.getVideoId());
                    stringBuilder2.append('_');
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            }
            String c = b.c(BrothersApplication.getApplicationInstance());
            String a = a(a);
            StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_video_show");
            switch (i) {
                case 1:
                    build.addString("video_autoplay_nosound", stringBuilder.toString());
                    break;
                case 2:
                    build.addString("video_autoplay_sound", stringBuilder.toString());
                    break;
                default:
                    build.addString("movielist", stringBuilder.toString()).addString("movielist_finish", stringBuilder2.toString());
                    break;
            }
            build.addString("platformModel", AndroidConfig.getPhoneModel());
            build.addString(c.a, c);
            build.addString("rec_params", a);
            a(build);
            a.clear();
        }
    }

    private static String a(Collection<y> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (y yVar : collection) {
                    Map hashMap = new HashMap();
                    hashMap.put("movieid", String.valueOf(yVar.a.getVideoId()));
                    hashMap.put("params", Uri.encode(yVar.d));
                    jSONArray.put(new JSONObject(hashMap));
                }
                return jSONArray.toString();
            }
        }
        return "";
    }

    public static String a(List<y> list) {
        if (list == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (y yVar : list) {
            if (yVar == null) {
                return null;
            }
            stringBuilder.append(yVar.a.getVideoId());
            stringBuilder.append('_');
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(RefreshType refreshType, String str) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_refresh");
        build.add("type", refreshType.name());
        build.add("movielist", str);
        a(build);
    }

    public static void a(RefreshType refreshType, int i) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_refresh_fail");
        build.add("type", refreshType.name());
        build.add("nettype", b.c(BrothersApplication.getApplicationInstance()));
        build.add("errorcode", i);
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_zan");
        build.add("movieid", str);
        build.add("action", str2);
        a(build);
    }

    public static void a() {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_common_click");
        build.add("clickid", "jubao");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_discuss_click");
        build.add("movieid", str);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_share_show");
        build.add("movieid", str);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_share_click");
        build.add("position", str2);
        build.add("movieid", str);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_share_to");
        build.add("position", str2);
        build.add("to", str3);
        build.add("movieid", str);
        LoginHelper.a();
        build.add("if_login", l.b());
        a(build);
    }

    public static void a(String str, String str2, String str3, int i, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_feedflow", "feedflow_share_result");
        build.add("to", str2);
        build.add("result", str3);
        build.add("errorcode", i);
        build.add("position", str4);
        build.add("movieid", str);
        LoginHelper.a();
        build.add("if_login", l.b());
        a(build);
    }
}
