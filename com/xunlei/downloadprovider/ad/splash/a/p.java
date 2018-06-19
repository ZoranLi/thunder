package com.xunlei.downloadprovider.ad.splash.a;

import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.report.e;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.recommend.a.a.a;

/* compiled from: SplashGDTRenderAd */
final class p implements SplashADListener {
    final /* synthetic */ o a;

    public final void onADTick(long j) {
    }

    p(o oVar) {
        this.a = oVar;
    }

    public final void onADPresent() {
        if (this.a.g.c) {
            o.p;
            return;
        }
        o.p;
        k.b("adv_request_success", k.a(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL));
        j.a(this.a.o);
        this.a.a(this.a.o);
    }

    public final void onADClicked() {
        this.a.e(this.a.o);
    }

    public final void onADDismissed() {
        if (this.a.g.c) {
            o.p;
            return;
        }
        o.p;
        this.a.j();
    }

    public final void onNoAD(AdError adError) {
        if (this.a.g.c) {
            o.p;
            return;
        }
        o.p;
        new StringBuilder("get tencent ad fail, errCode --> ").append(adError.getErrorCode());
        adError = e.a(adError.getErrorCode(), adError.getErrorMsg());
        k.b("adv_request_fail", k.a(THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT, adError));
        j.a(THUNDER_AD_INFO.SPLASH.getPositionId(), adError.a, adError.b);
        this.a.a(new a(adError.a, adError.b));
    }
}
