package com.xunlei.downloadprovider.personal.redenvelope;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;

/* compiled from: RedEnvelopeReport */
public final class f {

    /* compiled from: RedEnvelopeReport */
    private static class a {
        private int a;
        private int b;
        private int c;

        private a() {
            this.a = 0;
            this.b = 0;
            this.c = 0;
        }

        public final String a(e eVar) {
            if (eVar.i <= eVar.h) {
                this.a++;
            } else if (eVar.e == 2) {
                this.b++;
            } else {
                this.c++;
            }
            eVar = new StringBuilder();
            eVar.append(this.a);
            eVar.append("_");
            eVar.append(this.b);
            eVar.append("_");
            eVar.append(this.c);
            return eVar.toString();
        }
    }

    public static void a(StatEvent statEvent) {
        ThunderReport.reportEvent(statEvent);
        new StringBuilder("[NEW_STAT_EVENT]").append(statEvent);
    }

    public static void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_click_invite_new");
        build.add("action", str);
        a(build);
    }

    public static void b(String str) {
        StatEvent build = HubbleEventBuilder.build("android_packet", "packet_detail_invite_new");
        build.add("from", str);
        a(build);
    }
}
