package com.xunlei.downloadprovider.shortvideo.a;

import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: LiveReporter */
public final class a {
    public static void a(StatEvent statEvent) {
        new StringBuilder("[STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
