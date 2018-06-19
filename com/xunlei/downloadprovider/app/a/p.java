package com.xunlei.downloadprovider.app.a;

import android.os.Handler;
import android.os.Looper;
import com.android.volley.Request;
import com.android.volley.l;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.thunderserver.request.NoSigJsonArrayRequest;
import com.xunlei.downloadprovider.ad.c.a.c;
import com.xunlei.downloadprovider.ad.cache.b;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.feedvideo.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.personal.a.d.d;
import com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper;
import java.util.concurrent.TimeUnit;

/* compiled from: MainTabInitialization */
final class p extends m implements c {
    private boolean a;

    p() {
    }

    public final void a(boolean z) {
        this.a = true;
        a.b();
        b.a().a(STYLES_INFO.FEED_IMG);
        new f$a().sendEmptyMessageDelayed(1, 20000);
        new a$a().sendEmptyMessageDelayed(1, StatisticConfig.MIN_UPLOAD_INTERVAL);
        z = new c();
        z.a(new com.xunlei.downloadprovider.download.tasklist.list.feed.c());
        z.a();
        z = e.a().e;
        if (z.a != null) {
            int optInt = z.a.optInt("front_ad_guangdiantong_timeout");
            int optInt2 = z.a.optInt("front_ad_baidu_timeout");
            f.a(BrothersApplication.getApplicationInstance(), "gdt_ad_expired_time", optInt);
            f.a(BrothersApplication.getApplicationInstance(), "baidu_ad_expired_time", optInt2);
        }
        z = d.a();
        com.xunlei.downloadprovider.personal.a.b.a a = com.xunlei.downloadprovider.personal.a.b.a.a();
        l lVar = z.c;
        d.b eVar = new com.xunlei.downloadprovider.personal.a.d.e(z);
        Request noSigJsonArrayRequest = new NoSigJsonArrayRequest(0, "http://api-shoulei-ssl.xunlei.com/configuration/android/display_setting", null, new com.xunlei.downloadprovider.personal.a.b.d(a, eVar), new com.xunlei.downloadprovider.personal.a.b.e(a, eVar));
        noSigJsonArrayRequest.setShouldCache(false);
        lVar.a(noSigJsonArrayRequest);
        z = d.a();
        com.xunlei.downloadprovider.personal.a.b.a a2 = com.xunlei.downloadprovider.personal.a.b.a.a();
        l lVar2 = z.c;
        d.a fVar = new com.xunlei.downloadprovider.personal.a.d.f(z);
        Request noSigJsonArrayRequest2 = new NoSigJsonArrayRequest(0, "http://static.m.sjzhushou.com/pss/static/sjxl_fn_entry/fix_tab_config.json?versioncode=11100", null, new com.xunlei.downloadprovider.personal.a.b.b(a2, fVar), new com.xunlei.downloadprovider.personal.a.b.c(a2, fVar));
        noSigJsonArrayRequest2.setShouldCache(false);
        lVar2.a(noSigJsonArrayRequest2);
        com.xunlei.downloadprovider.d.c.a();
        com.xunlei.downloadprovider.d.c.c();
        b.a().a(STYLES_INFO.DOWNLOAD_FEED_IMAGE);
        XLThreadPool.getScheduledExecutorService().schedule(new o(this), 4000, TimeUnit.MILLISECONDS);
    }

    protected final void e() {
        BannerManager.a();
        BannerManager.c();
        com.xunlei.downloadprovider.d.c.a();
        com.xunlei.downloadprovider.d.c.d();
        com.xunlei.downloadprovider.cooperation.c.a();
        com.xunlei.downloadprovider.cooperation.a a = com.xunlei.downloadprovider.cooperation.a.a();
        if (!com.xunlei.xllib.b.d.a(a.b)) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.cooperation.b(a));
        }
        BrowserTranscodeHelper.getInstance().prepare();
    }

    public final boolean b() {
        return this.a;
    }

    public final void a() {
        n.a();
        if (n.b(false).mTotalCount > 0) {
            com.xunlei.downloadprovider.download.util.c.a();
        }
        com.xunlei.downloadprovider.web.website.g.b.a();
        com.xunlei.downloadprovider.web.website.g.b.a(true);
        com.xunlei.downloadprovider.web.website.g.b.a(false);
        com.xunlei.downloadprovider.personal.user.account.address.b.d.a();
        if (!com.xunlei.downloadprovider.personal.user.account.address.b.d.b()) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.personal.user.account.address.d.b(BrothersApplication.getApplicationInstance()));
        }
        com.xunlei.downloadprovider.download.b.b.b();
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.d.a();
        com.xunlei.downloadprovider.pushmessage.d.a();
        com.xunlei.downloadprovider.ad.notification.a.a();
        com.xunlei.downloadprovider.discovery.a.a a = com.xunlei.downloadprovider.discovery.a.a.a(BrothersApplication.getApplicationInstance());
        if (com.xunlei.downloadprovider.d.d.a().c.b()) {
            a.g();
        }
        BannerManager.a();
        BannerManager.g();
    }

    protected final void d() {
        if (com.xunlei.downloadprovider.ad.taskdetail.a.b()) {
            if (com.xunlei.downloadprovider.ad.taskdetail.a.b()) {
                b.a().a(STYLES_INFO.TASK_DETAIL_IMG, STYLES_INFO.TASK_DETAIL_BANNER);
            }
            new Handler(Looper.getMainLooper()).postDelayed(new com.xunlei.downloadprovider.ad.taskdetail.e(), 2000);
        }
        com.xunlei.downloadprovider.ad.taskdetailnew.c.b();
    }
}
