package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

public class GiftDispatchingReporter {
    private static final String a = "GiftDispatchingReporter";

    public enum ClickIdType {
        VIEW("view"),
        CLOSE("close");
        
        private final String mClickId;

        private ClickIdType(String str) {
            this.mClickId = str;
        }

        public final String getClickId() {
            return this.mClickId;
        }
    }

    public static void a(int i, int i2) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_show");
        build.add("packet_type", i);
        build.add("gift_type", i2);
        a(build);
    }

    public static void a(int i, int i2, ClickIdType clickIdType) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_click");
        if (i > 0) {
            build.add("packet_type", i);
        }
        if (i2 > 0) {
            build.add("gift_type", i2);
        }
        if (clickIdType != null) {
            build.add("clickid", clickIdType.getClickId());
        }
        a(build);
    }

    private static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
