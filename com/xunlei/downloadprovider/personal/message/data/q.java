package com.xunlei.downloadprovider.personal.message.data;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.homepage.recommend.a.w;
import com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.publiser.per.bp;
import com.xunlei.downloadprovider.publiser.per.model.d;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: MessageReport */
public class q {
    private static final String a = "q";
    private static List<bp> b = new ArrayList();
    private static List<bp> c = new ArrayList();
    private static Set<bp> d = new HashSet();

    public static void a(boolean z, bp bpVar) {
        if (bpVar != null) {
            if (!(bpVar.b instanceof Long)) {
                if (!z || !d.contains(bpVar)) {
                    if (bpVar.b instanceof w) {
                        b.add(bpVar);
                    } else {
                        c.add(bpVar);
                    }
                    d.add(bpVar);
                    if (b.size() >= true) {
                        a();
                        return;
                    }
                    if (c.size() >= true) {
                        b();
                    }
                }
            }
        }
    }

    public static void a() {
        if (!b.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (bp bpVar : b) {
                if (bpVar.b != null) {
                    String str = ((w) bpVar.b).b;
                    stringBuilder.append("id=");
                    stringBuilder.append(str);
                    stringBuilder.append(",type=video;");
                }
            }
            if (stringBuilder.length() <= 0) {
                b.clear();
                return;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_zanlist_show");
            build.add("tabid", "video");
            build.add("contentlist", k.a(stringBuilder.toString(), "UTF-8"));
            a(build);
            b.clear();
        }
    }

    public static void b() {
        if (!c.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (bp bpVar : c) {
                if (bpVar.b != null) {
                    String str = ((d) bpVar.b).b.a;
                    stringBuilder.append("id=");
                    stringBuilder.append(str);
                    stringBuilder.append(",type=cinecism;");
                }
            }
            if (stringBuilder.length() <= 0) {
                c.clear();
                return;
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_zanlist_show");
            build.add("tabid", "cinecism");
            build.add("contentlist", k.a(stringBuilder.toString(), "UTF-8"));
            a(build);
            c.clear();
        }
    }

    public static void c() {
        d.clear();
    }

    public static void a(String str) {
        a(str, 0);
    }

    private static String a(int i) {
        String str = "shortvideo";
        if (i != 7) {
            if (i != 6) {
                return MessageInfo.isWebSiteType(i) != 0 ? "link" : str;
            }
        }
        return "gcid";
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_show");
        build.add("from", str);
        build.add("mess_num", i);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_click");
        build.add("clickid", str);
        a(build);
    }

    public static void a(MessageType messageType, long j) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_page_show");
        switch (r.a[messageType.ordinal()]) {
            case 1:
                build.add("from", "zan_list");
                break;
            case 2:
                build.add("from", "visit_list");
                break;
            case 3:
                build.add("from", "discuss_list");
                break;
            case 4:
                build.add("from", "follow_list");
                break;
            case 5:
                build.add("from", "stranger_list");
                break;
            default:
                break;
        }
        build.add("mess_num", j);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_page_click");
        build.add("type", a(i));
        build.add("clickid", str);
        build.add("discussid", str2);
        build.add("movieid", str3);
        build.add("from", str4);
        a(build);
    }

    public static void a(String str, String str2, String str3, MessageType messageType, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_alert_click");
        build.add("type", a(i));
        build.add("clickid", str);
        build.add("discussid", str2);
        build.add("movieid", str3);
        switch (r.a[messageType.ordinal()]) {
            case 1:
                build.add("from", "zan_list");
                break;
            case 2:
                build.add("from", "visit_list");
                break;
            case 3:
                build.add("from", "discuss_list");
                break;
            case 4:
                build.add("from", "follow_list");
                break;
            default:
                break;
        }
        a(build);
    }

    public static void d() {
        a(HubbleEventBuilder.build("android_personal_click", "meassage_discuss_show"));
    }

    public static void a(String str, String str2, int i, int i2) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "meassage_discuss_submit");
        build.add("level", 1);
        build.add("movieid", str);
        build.add("discussid", str2);
        build.add("is_vip", i);
        build.add("is_login", 1);
        build.add("type", a(i2));
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "meassage_replay_result");
        build.add("result", str2);
        build.add("errorcode", str);
        build.add("movieid", str3);
        build.add("discussid", str4);
        build.add("new_discussid", str5);
        build.add("level", 1);
        build.add("type", a(i));
        a(build);
    }

    public static void e() {
        a(HubbleEventBuilder.build("android_personal_click", "per_zanbutton_click"));
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_zanlist_click");
        build.add("tabid", str);
        build.add("movieid", str2);
        build.add("content_type", str3);
        a(build);
    }

    public static void b(String str, int i) {
        StatEvent build = HubbleEventBuilder.build("android_personal_click", "messcenter_alert_show");
        build.add("type", a(i));
        build.add("from", str);
        a(build);
    }
}
