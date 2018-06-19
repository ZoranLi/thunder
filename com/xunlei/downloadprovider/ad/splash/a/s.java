package com.xunlei.downloadprovider.ad.splash.a;

import android.support.annotation.NonNull;
import android.view.ViewGroup;
import com.alipay.sdk.app.statistic.c;
import com.xunlei.downloadprovider.ad.common.adget.c.g;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.app.BaseActivity;

/* compiled from: SplashRenderAd */
public abstract class s extends a {
    protected g o = 0;

    protected final String i() {
        return "fullscreen";
    }

    public s(int i, @NonNull BaseActivity baseActivity, @NonNull ViewGroup viewGroup, g gVar, @NonNull h hVar, i iVar) {
        super(i, baseActivity, viewGroup, hVar, iVar);
        this.o = gVar;
        this.c = this.o.y();
        this.b = c.e;
    }
}
