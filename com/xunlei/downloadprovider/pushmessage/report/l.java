package com.xunlei.downloadprovider.pushmessage.report;

import com.umeng.message.MsgConstant;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;

/* compiled from: PushReport */
public final class l {
    public static void a(int i, String str, String str2, String str3, String str4, String str5) {
        a(i, str, str2, true, str3, str4, str5);
    }

    public static void b(int i, String str, String str2, String str3, String str4, String str5) {
        a(i, str, str2, false, str3, str4, str5);
    }

    static void a(BasePushMessageInfo basePushMessageInfo, boolean z) {
        a(basePushMessageInfo.getDisplayType(), basePushMessageInfo.getResTypeReport(), basePushMessageInfo.getMessageId(), z, basePushMessageInfo.getDeviceToken(), basePushMessageInfo.getServerTypeReport(), basePushMessageInfo.getTarget());
    }

    static void a(int i, String str, String str2, String str3, String str4, String str5, StatEvent statEvent) {
        statEvent.add("taskid", i);
        statEvent.add("type", str);
        statEvent.add("messageid", str2);
        statEvent.add(MsgConstant.KEY_DEVICE_TOKEN, str3);
        statEvent.add("push_server", str4);
        statEvent.add("message_info", str5);
    }

    static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }

    private static void a(int i, String str, String str2, boolean z, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_push", "push_pop");
        a(i, str, str2, str3, str4, str5, build);
        build.add("if_pop", z);
        a(build);
    }

    public static void c(int i, String str, String str2, String str3, String str4, String str5) {
        StatEvent build = HubbleEventBuilder.build("android_push", "push_click");
        a(i, str, str2, str3, str4, str5, build);
        a(build);
    }
}
