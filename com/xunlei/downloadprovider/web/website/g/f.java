package com.xunlei.downloadprovider.web.website.g;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.c.a;

/* compiled from: WebsiteHelper */
final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b$a b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ b f;

    f(b bVar, String str, b$a com_xunlei_downloadprovider_web_website_g_b_a, String str2, String str3, String str4) {
        this.f = bVar;
        this.a = str;
        this.b = com_xunlei_downloadprovider_web_website_g_b_a;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public final void run() {
        c b = a.b(this.a);
        if (b == null || TextUtils.isEmpty(b.b) || !b.b.endsWith(this.a)) {
            String str = HttpConstant.SCHEME_SPLIT;
            String str2 = this.c;
            if (TextUtils.isEmpty(this.c) && !TextUtils.isEmpty(this.a) && this.a.contains(str)) {
                str2 = this.a.substring(this.a.indexOf(str) + str.length());
            }
            b = new c();
            b.c = str2;
            b.b = this.a;
            b.d = this.d;
            b.a(System.currentTimeMillis());
            if (a.a(b) > 0) {
                if (this.b != null) {
                    this.b.a();
                }
                str2 = this.e;
                String str3 = this.a;
                StatEvent build = HubbleEventBuilder.build("android_url_action", "url_collect");
                String str4 = "position";
                if (str2 == null) {
                    str2 = "";
                }
                StatEvent addString = build.addString(str4, str2);
                String str5 = "url";
                if (str3 == null) {
                    str3 = "";
                }
                ThunderReport.reportEvent(addString.addString(str5, str3));
                this.f.a(this.a, true);
                j a = j.a();
                LoginHelper.a();
                if (l.c()) {
                    XLThreadPool.execute(new s(a, b));
                }
            }
        } else if (this.b != null) {
            this.b.b();
        }
    }
}
