package com.xunlei.downloadprovider.ad.splash.a;

import com.baidu.mobads.SplashAdListener;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.recommend.a.a.a;

/* compiled from: SplashBaiDuRenderAd */
final class k implements SplashAdListener {
    final /* synthetic */ Boolean[] a;
    final /* synthetic */ j b;

    k(j jVar, Boolean[] boolArr) {
        this.b = jVar;
        this.a = boolArr;
    }

    public final void onAdDismissed() {
        if (this.b.g.c) {
            j.p;
            return;
        }
        j.p;
        this.b.j();
    }

    public final void onAdFailed(String str) {
        if (this.b.g.c) {
            j.p;
        } else if (this.a[0].booleanValue()) {
            j.p;
        } else {
            j.p;
            StringBuilder stringBuilder = new StringBuilder("baidu render errorCode-");
            stringBuilder.append(str);
            str = e.a(-8, stringBuilder.toString());
            this.b.a(new a(str.a, str.b));
            j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), str.a, str.b);
            com.xunlei.downloadprovider.ad.common.adget.k.b("adv_request_fail", com.xunlei.downloadprovider.ad.common.adget.k.a(THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL, "baidu", str));
        }
    }

    public final void onAdPresent() {
        if (this.b.g.c) {
            j.p;
            return;
        }
        j.p;
        this.a[0] = Boolean.valueOf(true);
        com.xunlei.downloadprovider.ad.common.adget.k.b("adv_request_success", com.xunlei.downloadprovider.ad.common.adget.k.a("baidu", THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL));
        j.a(this.b.o);
        this.b.a(this.b.o);
    }

    public final void onAdClick() {
        this.b.e(this.b.o);
    }
}
