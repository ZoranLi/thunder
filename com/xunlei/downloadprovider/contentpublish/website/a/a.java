package com.xunlei.downloadprovider.contentpublish.website.a;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import org.android.agoo.common.AgooConstants;

/* compiled from: WebsiteDetailReporter */
public final class a {
    private static String a = "android_linkdetail";
    private static String b = "link_detail_show";
    private static String c = "link_detail_content_click";
    private static String d = "link_detail_zan";
    private static String e = "link_detail_discuss_zan";
    private static String f = "link_detail_discuss_show";
    private static String g = "link_detail_discuss_click";
    private static String h = "link_detail_discuss_result";
    private static String i = "link_detail_share_click";
    private static String j = "link_detail_share_to";
    private static String k = "link_detail_share_result";
    private static String l = "link_detail_discuss_alter";
    private static String m = "link_detail_discuss_area_show";
    private static String n = "link_detail_defaultdiscuss_show";
    private static String o = "link_detail_discuss_submit";
    private static String p = "link_detail_discuss_error";
    private static String q = "link_detail_defaultdiscuss_submit";
    private static String r = "link_detail_common_click";
    private static String s = "link_detail_follow_click";
    private static String t = "link_detail_follow_click_result";
    private static String u = "link_detail_head_click";
    private static String v = "link_detail_zan_animation";

    public static void a(String str, String str2, String str3, String str4, boolean z) {
        StatEvent build = HubbleEventBuilder.build(a, b);
        build.add("from", str2);
        build.add("url", str3);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_id", str4);
        build.add("isexists", z ? "yes" : "no");
        a(build);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, c);
        build.add("url", str);
        build.add("from", str2);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, d);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("url", str2);
        build.add("authoer_id", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, long j, boolean z) {
        StatEvent build = HubbleEventBuilder.build(a, e);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("url", str2);
        build.add("author_id", str3);
        build.add("discussid", String.valueOf(j));
        build.add("is_login", z ? "1" : "0");
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build(a, l);
        build.add("to", str);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, f);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("position", str2);
        build.add("author_id", str4);
        build.add("url", str3);
        a(build);
    }

    public static void a() {
        a(HubbleEventBuilder.build(a, m));
    }

    public static void a(String str, String str2, String str3, boolean z) {
        StatEvent build = HubbleEventBuilder.build(a, n);
        build.add("is_login", z);
        build.add("position", str);
        build.add("author_type", str2);
        build.add("wordid", str3);
        a(build);
    }

    public static void a(String str, String str2, long j, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, g);
        build.add("discussid", String.valueOf(j));
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_id", str2);
        build.add("clickid", str3);
        a(build);
    }

    public static void a(String str, long j, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, o);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("discussid", String.valueOf(j));
        build.add("level", j == -1 ? "0" : "1");
        build.add("is_login", z ? "1" : "0");
        build.add("author_type", str2);
        build.add("position", str3);
        a(build);
    }

    public static void a(String str, boolean z, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build(a, q);
        build.add("wordid", str);
        build.add("is_login", z ? "1" : "0");
        build.add("author_type", str2);
        build.add("position", str3);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, p);
        build.add("discuss_type", str);
        str = "errorcode";
        if ("-1001".contentEquals(str2)) {
            str2 = "network_err";
        }
        build.add(str, str2);
        a(build);
    }

    public static void a(String str, boolean z, String str2, long j, long j2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, h);
        build.add("result", z ? "success" : "fail");
        z = "errorcode";
        if ("-1001".contentEquals(str2)) {
            str2 = "network_err";
        }
        build.add(z, str2);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("discussid", String.valueOf(j));
        build.add("new_discussid", String.valueOf(j2));
        build.add("level", j == true ? "0" : "1");
        build.add("url", str3);
        build.add("author_id", str4);
        a(build);
    }

    public static void b(String str, String str2, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build(a, i);
        build.add("from", str);
        build.add(AgooConstants.MESSAGE_ID, str2);
        build.add("url", str3);
        build.add("author_id", str4);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build(a, j);
        build.add("from", str5);
        build.add("to", str4);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("url", str2);
        build.add("author_id", str3);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, String str5, int i, String str6) {
        StatEvent build = HubbleEventBuilder.build(a, k);
        build.add("from", str6);
        build.add("to", str4);
        build.add("result", str5);
        build.add("errorcode", i);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("url", str2);
        build.add("author_id", str3);
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build(a, r);
        build.add("clickid", str);
        a(build);
    }

    public static void c(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build(a, u);
        build.add("zan_userid", str2);
        build.add(AgooConstants.MESSAGE_ID, str);
        a(build);
    }

    public static void c(String str) {
        StatEvent build = HubbleEventBuilder.build(a, v);
        build.add(AgooConstants.MESSAGE_ID, str);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, boolean z2) {
        StatEvent build = HubbleEventBuilder.build(a, s);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("position", str4);
        build.add("login_type", z);
        build.add("is_guide_bar", z2);
        a(build);
    }

    public static void a(String str, String str2, String str3, String str4, boolean z, String str5, String str6) {
        StatEvent build = HubbleEventBuilder.build(a, t);
        build.add(AgooConstants.MESSAGE_ID, str);
        build.add("author_id", str2);
        build.add("author_type", str3);
        build.add("login_type", z);
        build.add("position", str4);
        build.add("result", str5);
        build.add("error", str6);
        a(build);
    }
}
