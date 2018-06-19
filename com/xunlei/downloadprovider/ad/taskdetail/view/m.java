package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskDetailThemeAdView */
public final class m extends a {
    private ImageView c = null;
    private RequestListener<String, Bitmap> d = new o(this);

    public final String getAdUIStyle() {
        return "301";
    }

    public m(Context context) {
        super(context);
        a();
    }

    protected final void b() {
        super.b();
        LayoutInflater.from(this.a).inflate(R.layout.layout_task_detail_ad_style_theme, this).setLayoutParams(new LayoutParams(-1, -2));
        this.c = (ImageView) findViewById(R.id.iv_banner);
    }

    protected final void c() {
        super.c();
        setOnClickListener(new n(this));
    }

    public final void a(@NonNull l lVar) {
        this.b = lVar;
        Glide.with(getContext()).load(d(lVar)).asBitmap().listener(this.d).into(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private String d(@NonNull l lVar) {
        if (g()) {
            return lVar.l();
        }
        return lVar.r();
    }

    private boolean g() {
        return this.b != null && this.b.v == STYLES_INFO.TASK_DETAIL_THEME;
    }

    public final void d() {
        this.b = null;
        setVisibility(8);
    }
}
