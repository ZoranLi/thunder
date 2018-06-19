package com.xunlei.downloadprovider.discovery.kuainiao;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;

/* compiled from: KuainiaoReporter */
public final class j {

    /* compiled from: KuainiaoReporter */
    private static class a {
        private StatEvent a;

        private a() {
        }

        static /* synthetic */ void a(a aVar) {
            if (aVar.a != null) {
                ThunderReport.reportEvent(aVar.a);
            }
        }
    }

    public static void a(String str, String str2, int i) {
        a aVar = new a();
        aVar.a = HubbleEventBuilder.build("android_kuainiao", "try_speed_status");
        aVar.a.add("status", str);
        aVar.a.add("vip_from", str2);
        if ("exception".equals(str) != null) {
            aVar.a.add("err_code", String.valueOf(i));
        } else {
            a.a(aVar);
        }
    }
}
