package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: SplashThirdAdView */
public final class n extends b {
    private Context q = null;
    private ViewGroup r = null;
    private View s = null;

    public n(Context context) {
        super(context);
        this.q = context;
        this.s = LayoutInflater.from(this.q).inflate(R.layout.layout_splash_third_ad, this);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.r = (ViewGroup) this.s.findViewById(R.id.third_ad_container_ll);
        setAdStyle("fullscreen");
        a();
    }

    protected final void c() {
        super.c();
        this.i.setOnClickListener(new o(this));
    }

    protected final void d() {
        this.h = (CountDownCircleProgressBar) this.s.findViewById(R.id.splash_ad_skip_count_down_pb);
        this.i = this.s.findViewById(R.id.splash_ad_skip_count_down_btn);
    }

    public final ViewGroup getThirdAdContainer() {
        return this.r;
    }

    private void a() {
        this.h.setProgress(0);
    }

    public final void a(@NonNull l lVar) {
        this.o = lVar;
        a();
        setCountDown$2566ab5(5000);
        o();
        e();
    }
}
