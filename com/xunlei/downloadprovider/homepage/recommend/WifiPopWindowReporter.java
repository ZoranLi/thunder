package com.xunlei.downloadprovider.homepage.recommend;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

public final class WifiPopWindowReporter {

    public enum EventType {
        android_feedflow,
        android_videodetail
    }

    public enum PageFrom {
        FEED_FLOW,
        VIDEO_DEITAIL
    }

    public static void a(PageFrom pageFrom, String str, String str2) {
        String str3 = null;
        if (pageFrom == PageFrom.FEED_FLOW) {
            str3 = EventType.android_feedflow.name();
            pageFrom = "feedflow_net_pop";
        } else if (pageFrom == PageFrom.VIDEO_DEITAIL) {
            str3 = EventType.android_videodetail.name();
            pageFrom = "videodetail_net_pop";
        } else {
            pageFrom = null;
        }
        pageFrom = HubbleEventBuilder.build(str3, pageFrom);
        pageFrom.addString("net_typ", str);
        pageFrom.addString("movieid", str2);
        a(pageFrom);
    }

    public static void a(PageFrom pageFrom, String str, String str2, int i) {
        String str3 = null;
        if (pageFrom == PageFrom.FEED_FLOW) {
            str3 = EventType.android_feedflow.name();
            pageFrom = "feedflow_net_click";
        } else if (pageFrom == PageFrom.VIDEO_DEITAIL) {
            str3 = EventType.android_videodetail.name();
            pageFrom = "videodetail_net_click";
        } else {
            pageFrom = null;
        }
        pageFrom = HubbleEventBuilder.build(str3, pageFrom);
        pageFrom.addString("net_typ", str);
        pageFrom.addString("movieid", str2);
        pageFrom.addInt("clickid", i);
        a(pageFrom);
    }

    private static void a(StatEvent statEvent) {
        String str;
        StringBuilder stringBuilder = new StringBuilder("[STAT_EVENT]");
        if (statEvent == null) {
            str = "hubbleData is null";
        } else {
            StringBuilder stringBuilder2 = new StringBuilder("StatFields =");
            stringBuilder2.append(statEvent.getExtraData());
            str = stringBuilder2.toString();
        }
        stringBuilder.append(str);
        ThunderReport.reportEvent(statEvent);
    }
}
