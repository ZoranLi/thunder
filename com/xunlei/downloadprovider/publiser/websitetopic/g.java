package com.xunlei.downloadprovider.publiser.websitetopic;

import android.support.annotation.NonNull;
import com.alipay.sdk.util.h;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.websitetopic.c.c;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WebsiteTopicReport */
public class g {
    private static final String a = "g";
    private static List<c> b = new ArrayList();

    public static void a(c cVar) {
        if (b.size() >= 8) {
            a(b);
            b.clear();
            return;
        }
        b.add(cVar);
    }

    public static void a() {
        int size = b.size();
        if (size > 0 && size <= 8) {
            a(b);
        }
    }

    public static void b(c cVar) {
        if (cVar != null && cVar.a != 2 && !b.contains(cVar)) {
            b.add(cVar);
        }
    }

    @NonNull
    private static String b(List<c> list) {
        String str = "";
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                c cVar = (c) list.get(i);
                if (cVar.a != 2) {
                    String str2 = cVar.b.a;
                    String uid = cVar.c.getUid();
                    String encode = URLEncoder.encode(cVar.b.f);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append("id=");
                    stringBuilder.append(str2);
                    stringBuilder.append(",author_id=");
                    stringBuilder.append(uid);
                    stringBuilder.append(",url=");
                    stringBuilder.append(URLEncoder.encode(encode));
                    stringBuilder.append(h.b);
                    str = stringBuilder.toString();
                }
            }
        }
        return str;
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_show");
        build.add("from", str);
        build.add("tag", URLEncoder.encode(str2));
        a(build);
    }

    private static void a(List<c> list) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_content_show");
        build.add("contentlist", URLEncoder.encode(b((List) list)));
        a(build);
        b((List) list);
    }

    public static void c(c cVar) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_content_click");
        build.add("linkid", cVar.b.a);
        build.add("url", URLEncoder.encode(cVar.b.f));
        build.add("author_id", cVar.c.getUid());
        a(build);
    }

    public static void d(c cVar) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_zan");
        build.add("linkid", cVar.b.a);
        build.add("url", URLEncoder.encode(cVar.b.f));
        build.add("author_id", cVar.c.getUid());
        a(build);
    }

    public static void a(c cVar, String str) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_share_to");
        build.add("linkid", cVar.b.a);
        build.add("author_id", cVar.c.getUid());
        build.add("to", str);
        a(build);
    }

    public static void a(c cVar, String str, String str2, int i) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_share_result");
        build.add("linkid", cVar.b.a);
        build.add("author_id", cVar.c.getUid());
        build.add("to", str);
        build.add("result", str2);
        build.add("errorcode", i);
        cVar = "if_login";
        LoginHelper.a();
        build.add(cVar, l.c() != null ? "1" : "0");
        a(build);
    }

    public static void e(c cVar) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_discuss_click");
        build.add("linkid", cVar.b.a);
        build.add("author_id", cVar.c.getUid());
        a(build);
    }

    public static void f(c cVar) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_follow_click");
        build.add("linkid", cVar.b.a);
        build.add("author_id", cVar.c.getUid());
        build.add("author_type", cVar.c.getKind());
        cVar = "login_type";
        LoginHelper.a();
        build.add(cVar, l.c() ? "1" : "0");
        a(build);
    }

    public static void a(c cVar, String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("android_linkCollect", "linkCollect_follow_click_result");
        build.add("linkid", cVar.b.a);
        build.add("author_id", cVar.c.getUid());
        build.add("author_type", cVar.c.getKind());
        cVar = "login_type";
        LoginHelper.a();
        build.add(cVar, l.c() ? "1" : "0");
        build.add("result", str);
        build.add("error", str2);
        a(build);
    }
}
