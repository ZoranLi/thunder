package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.web.website.c.b;

/* compiled from: WebsiteHelper */
final class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b$a b;
    final /* synthetic */ b c;

    g(b bVar, String str, b$a com_xunlei_downloadprovider_web_website_g_b_a) {
        this.c = bVar;
        this.a = str;
        this.b = com_xunlei_downloadprovider_web_website_g_b_a;
    }

    public final void run() {
        if (b.a(this.a)) {
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_url_action", "url_mv"));
            this.b.a();
        }
    }
}
