package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.c.a;

/* compiled from: WebsiteHelper */
final class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ b$b d;
    final /* synthetic */ b e;

    e(b bVar, String str, String str2, String str3, b$b com_xunlei_downloadprovider_web_website_g_b_b) {
        this.e = bVar;
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = com_xunlei_downloadprovider_web_website_g_b_b;
    }

    public final void run() {
        c b = a.b(this.a);
        if (b != null && a.a(this.a)) {
            this.e.a(this.a, false);
            String str = this.b;
            String str2 = this.a;
            String str3 = this.c;
            StatEvent build = HubbleEventBuilder.build("android_url_action", "url_uncollect");
            String str4 = "position";
            if (str == null) {
                str = "";
            }
            StatEvent addString = build.addString(str4, str);
            String str5 = "url";
            if (str2 == null) {
                str2 = "";
            }
            addString = addString.addString(str5, str2);
            str2 = "type";
            if (str3 == null) {
                str3 = "";
            }
            ThunderReport.reportEvent(addString.addString(str2, str3));
            this.d.a();
            j a = j.a();
            LoginHelper.a();
            if (l.c()) {
                XLThreadPool.execute(new t(a, b));
            }
        }
    }
}
