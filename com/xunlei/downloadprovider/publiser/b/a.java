package com.xunlei.downloadprovider.publiser.b;

import android.text.TextUtils;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MusicReporter */
public final class a {
    private static List<n> a = new ArrayList();
    private static Set<n> b = new HashSet();

    public static void a(String str, String str2, String str3, String str4, boolean z) {
        if (str4.equals("pub")) {
            str4 = "channel";
        } else if (str4.equals("per")) {
            str4 = "personal";
        }
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_follow_click");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("author_type", str4);
        build.add("login_type", z);
        build.add("tabid", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, String str5, String str6, int i) {
        if (str4.equals("pub")) {
            str4 = "channel";
        } else if (str4.equals("per")) {
            str4 = "personal";
        }
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_follow_click_result");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("tabid", str3);
        build.add("author_type", str4);
        build.add("login_type", z);
        build.add("result", str5);
        build.add("error", str6);
        build.add("hasanim", i);
        a(build);
    }

    public static void a(boolean z, n nVar, String str) {
        if (nVar != null) {
            if (nVar.a == 0) {
                if (!z || !b.contains(nVar)) {
                    a.add(nVar);
                    b.add(nVar);
                    if (a.size() >= true) {
                        a(str);
                    }
                }
            }
        }
    }

    public static void a() {
        b.clear();
    }

    public static void a(String str) {
        if (!a.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (n nVar : a) {
                if (!TextUtils.isEmpty(nVar.b.getVideoId())) {
                    stringBuilder.append(nVar.b.getVideoId());
                    stringBuilder.append('_');
                }
            }
            if (stringBuilder.length() > 0) {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            if (stringBuilder2.length() > 0) {
                stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
            }
            StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_content_show");
            build.addString("music_video_auto_ugc", stringBuilder.toString());
            build.addString("tabid", str);
            a(build);
            a.clear();
        }
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.lang.String r3, java.lang.String r4) {
        /*
        r0 = "music_collect_show";
        r1 = "android_music_collect";
        r0 = com.xunlei.common.report.HubbleEventBuilder.build(r1, r0);
        r1 = "from";
        r2 = r4.hashCode();
        switch(r2) {
            case -1540660761: goto L_0x004e;
            case -427179481: goto L_0x0044;
            case 75165: goto L_0x003a;
            case 2223327: goto L_0x0030;
            case 73725445: goto L_0x0026;
            case 80008463: goto L_0x001c;
            case 2072392632: goto L_0x0012;
            default: goto L_0x0011;
        };
    L_0x0011:
        goto L_0x0058;
    L_0x0012:
        r2 = "SHORT_VIDEO_DETAIL";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x001a:
        r4 = 0;
        goto L_0x0059;
    L_0x001c:
        r2 = "TOPIC";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x0024:
        r4 = 6;
        goto L_0x0059;
    L_0x0026:
        r2 = "MUSIC";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x002e:
        r4 = 5;
        goto L_0x0059;
    L_0x0030:
        r2 = "HOME";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x0038:
        r4 = 3;
        goto L_0x0059;
    L_0x003a:
        r2 = "LBS";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x0042:
        r4 = 4;
        goto L_0x0059;
    L_0x0044:
        r2 = "PERSONAL_SPACE";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x004c:
        r4 = 1;
        goto L_0x0059;
    L_0x004e:
        r2 = "FOLLOW_TAB";
        r4 = r4.equals(r2);
        if (r4 == 0) goto L_0x0058;
    L_0x0056:
        r4 = 2;
        goto L_0x0059;
    L_0x0058:
        r4 = -1;
    L_0x0059:
        switch(r4) {
            case 0: goto L_0x006e;
            case 1: goto L_0x006b;
            case 2: goto L_0x0068;
            case 3: goto L_0x0065;
            case 4: goto L_0x0062;
            case 5: goto L_0x005f;
            default: goto L_0x005c;
        };
    L_0x005c:
        r4 = "shortvideo_topic_music";
        goto L_0x0070;
    L_0x005f:
        r4 = "shortvideo_music_music";
        goto L_0x0070;
    L_0x0062:
        r4 = "shortvideo_LBS_music";
        goto L_0x0070;
    L_0x0065:
        r4 = "home_collect_music";
        goto L_0x0070;
    L_0x0068:
        r4 = "home_followtab_music";
        goto L_0x0070;
    L_0x006b:
        r4 = "shortvideo_usercenter_music";
        goto L_0x0070;
    L_0x006e:
        r4 = "videoDetail";
    L_0x0070:
        r0.add(r1, r4);
        r4 = "id";
        r0.add(r4, r3);
        a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.b.a.a(java.lang.String, java.lang.String):void");
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_content_click");
        build.add("movieid", str);
        build.add("format_type", "music_video_auto_ugc");
        build.add("tabid", str2);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_zan");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("tabid", str3);
        build.add("action", str4);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_discuss_click");
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("tabid", str3);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_share_to");
        build.add("to", str4);
        build.add("movieid", str);
        build.add("author_id", str2);
        build.add("tabid", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, int i, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_music_collect", "music_collect_share_result");
        build.add("to", str2);
        build.add("result", str3);
        build.add("errorcode", i);
        build.add("movieid", str);
        build.add("author_id", str4);
        build.add("tabid", str5);
        LoginHelper.a();
        build.add("if_login", l.b());
        a(build);
    }
}
