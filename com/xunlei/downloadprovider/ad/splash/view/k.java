package com.xunlei.downloadprovider.ad.splash.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.c;
import com.xunlei.downloadprovider.ad.splash.a.i;

/* compiled from: SplashFullAdView */
public final class k extends b {
    private ImageView q;
    private ImageView r;
    private View s;

    public k(Context context) {
        super(context);
        this.q = null;
        this.r = null;
        this.s = null;
        this.s = LayoutInflater.from(this.a).inflate(R.layout.layout_splash_full_ad, this);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.q = (ImageView) this.s.findViewById(R.id.loading_img_ad);
        this.r = (ImageView) this.s.findViewById(R.id.iv_ad_source_icon);
        a();
        setAdStyle("fullscreen");
    }

    protected final void c() {
        super.c();
        this.i.setOnClickListener(new l(this));
        setOnClickListener(new m(this));
    }

    protected final void d() {
        this.h = (CountDownCircleProgressBar) this.s.findViewById(R.id.splash_ad_skip_count_down_pb);
        this.i = this.s.findViewById(R.id.splash_ad_skip_count_down_btn);
    }

    public final void a(@NonNull l lVar) {
        this.o = lVar;
        a();
        this.g = Math.max(3000, i.a());
        setCountDown$2566ab5(this.g);
        setImageBitmap(this.o.t);
        setAdSourceIconIv(getAdSourceIconResId());
        o();
        e();
    }

    public final void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.q.setImageBitmap(bitmap);
        } else {
            this.q.setImageResource(R.drawable.bg_splash_poster_default);
        }
    }

    public final void setImageRes(int i) {
        this.q.setImageResource(i);
    }

    public final void setAdSourceIconIv(Object obj) {
        c.a(getContext(), obj, this.r);
        this.r.setVisibility(0);
    }

    private void a() {
        this.h.setProgress(0);
        setImageRes(R.drawable.bg_splash_poster_default);
        this.r.setVisibility(8);
    }
}
