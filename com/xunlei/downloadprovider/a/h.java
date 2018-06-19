package com.xunlei.downloadprovider.a;

import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: ActivityReporter */
final class h {
    static void a(StatEvent statEvent) {
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
        ThunderReport.reportEvent(statEvent);
    }
}
