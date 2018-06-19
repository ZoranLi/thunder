package com.xunlei.downloadprovider.contentpublish.website;

import android.net.Uri;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;

/* compiled from: WebsiteReporter */
public class bf {
    private static final String a = "bf";

    private bf() {
    }

    public static void a(String str, String str2) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_remind_pop_show").add("from", str).add("url", Uri.encode(str2)));
    }

    public static void a(String str, String str2, String str3) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_remind_pop_click").add("from", str).add("action", str2).add("url", Uri.encode(str3)));
    }

    public static void a(String str) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_pannel_show").add("from", str));
    }

    public static void b(String str, String str2, String str3) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_pannel_click").add("from", str).add("action", str2).add("url", Uri.encode(str3)));
    }

    public static void a(String str, String str2, String str3, String str4) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_pannel_send").add("from", str).add("url", Uri.encode(str2)).add("discribe", str3).add("result", str4));
    }

    public static void c(String str, String str2, String str3) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_decode_result").add("from", str).add("url", Uri.encode(str2)).add("result", str3));
    }

    public static void b(String str, String str2) {
        ThunderReport.reportEvent(HubbleEventBuilder.build("content_make", "content_make_link_publish_show").add("from", str).add("type", str2));
    }
}
