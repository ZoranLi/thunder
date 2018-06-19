package com.xunlei.downloadprovider.g.a;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: XLVideoReport */
public class b {
    private static final String a = "b";

    private static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    public static void a(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "play_record_start_click");
        build.add("filename", str);
        build.add("play_type", str2);
        a(build);
    }

    public static void a(String str, String str2, long j, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "play_record_save_result");
        build.add("filename", str);
        build.add("play_type", str2);
        build.add(SocializeProtocolConstants.DURATION, j);
        build.add("record", str3);
        build.add("result", str4);
        a(build);
    }

    public static void a(String str, String str2, long j, String str3, boolean z) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "play_record_pop_show");
        build.add("filename", str);
        build.add("record", str3);
        build.add(SocializeProtocolConstants.DURATION, j);
        build.add("play_type", str2);
        build.add("ispublish", z);
        a(build);
    }

    public static void a(String str, String str2, long j, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "play_record_pop_click");
        build.add("filename", str);
        build.add("play_type", str2);
        build.add(SocializeProtocolConstants.DURATION, j);
        build.add("record", str3);
        build.add("action", str4);
        build.add("isupload", str5);
        a(build);
    }

    public static void b(String str, String str2, long j, String str3, String str4) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "play_record_upload");
        build.add("filename", str);
        build.add("play_type", str2);
        build.add(SocializeProtocolConstants.DURATION, j);
        build.add("record", str3);
        build.add("result", str4);
        a(build);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_show");
        build.add("from", str);
        a(build);
    }

    public static void a() {
        a(HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_tag_page"));
    }

    public static void a(String str, String str2, int i) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_tag_search");
        build.add("word", str);
        build.add("result", str2);
        build.add("num", i);
        a(build);
    }

    public static void b(String str, String str2) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_tag_choose");
        build.add("type", str);
        build.add("tag", str2);
        a(build);
    }

    public static void a(String str, String str2, String str3) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_click");
        build.add("from", str);
        build.add("action", str2);
        build.add("info", str3);
        a(build);
    }

    public static void a(String str, long j, String str2, int i, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("shortvideo_make", "shortvideo_make_publish_result");
        build.add("from", str);
        build.add("fileSize", j);
        build.add("gcid", str2);
        build.add(SocializeProtocolConstants.DURATION, i);
        build.add("title", str3);
        build.add("tag", str4);
        build.add("result", str5);
        a(build);
    }
}
