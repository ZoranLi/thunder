package com.xunlei.downloadprovider.ad.splash.a;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.adget.k;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.splash.view.n;
import com.xunlei.downloadprovider.app.BaseActivity;

/* compiled from: SplashBaiDuRenderAd */
public class j extends s {
    private static final String p = "j";

    public j(int i, @NonNull BaseActivity baseActivity, @NonNull ViewGroup viewGroup, g gVar, @NonNull h hVar, i iVar) {
        super(i, baseActivity, viewGroup, gVar, hVar, iVar);
    }

    public final void e() {
        super.e();
        a(this.b);
        SplashAdListener kVar = new k(this, new Boolean[]{Boolean.valueOf(false)});
        ViewGroup thirdAdContainer = this.l instanceof n ? ((n) this.l).getThirdAdContainer() : null;
        if (thirdAdContainer != null) {
            SplashAd splashAd = new SplashAd(this.a, thirdAdContainer, kVar, "2360643", true);
            k.b("adv_request", k.a(THUNDER_AD_INFO.SPLASH, STYLES_INFO.SPLASH_FULL, "baidu"));
        }
    }

    protected final void b(@NonNull l lVar) {
        this.l.setOnAdDismissListener(new l(this));
        this.l.setOnSkipBtnClickListener(new m(this, lVar));
        this.l.setOnAdShowListener(new n(this, lVar));
        this.l.a(lVar);
    }
}
