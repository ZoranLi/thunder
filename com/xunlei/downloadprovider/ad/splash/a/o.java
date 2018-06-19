package com.xunlei.downloadprovider.ad.splash.a;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.qq.e.ads.cfg.MultiProcessFlag;
import com.qq.e.ads.splash.SplashAD;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.app.BaseActivity;

/* compiled from: SplashGDTRenderAd */
public class o extends s {
    private static final String p = "o";

    public o(int i, @NonNull BaseActivity baseActivity, @NonNull ViewGroup viewGroup, g gVar, @NonNull h hVar, i iVar) {
        super(i, baseActivity, viewGroup, gVar, hVar, iVar);
    }

    public final void e() {
        super.e();
        MultiProcessFlag.setMultiProcess(true);
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_advertise", this.c));
        SplashAD splashAD = new SplashAD(this.a, this.d, "1104872693", "8040408676314549", new p(this));
        k.b("adv_request", k.a(THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL, SocializeProtocolConstants.PROTOCOL_KEY_TENCENT));
    }

    public final void b(@NonNull l lVar) {
        f(this.o);
    }
}
