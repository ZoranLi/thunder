package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;

/* compiled from: TaskDetailBannerAdView */
public abstract class d extends a {
    private static final String e = "d";
    protected ImageView c = null;
    protected TextView d = null;
    private View f = null;
    private ViewGroup g = null;
    private RequestListener<String, Bitmap> h = new f(this);

    protected abstract int getLayoutResourceId();

    protected void i() {
    }

    public d(Context context) {
        super(context);
    }

    protected void b() {
        super.b();
        this.f = LayoutInflater.from(this.a).inflate(getLayoutResourceId(), this);
        this.f.setLayoutParams(new LayoutParams(-1, -2));
        setBackgroundResource(R.color.common_content_bkg_color);
        this.g = (ViewGroup) this.f.findViewById(R.id.parent_view);
        this.c = (ImageView) this.f.findViewById(R.id.iv_banner);
        this.d = (TextView) this.f.findViewById(R.id.tv_title);
    }

    protected final void c() {
        super.c();
        setOnClickListener(new e(this));
    }

    public final void a(@NonNull l lVar) {
        this.b = lVar;
        g();
    }

    protected void g() {
        this.d.setText(this.b.m());
        Glide.with(getContext()).load(this.b.l()).asBitmap().listener(this.h).into(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    protected final void h() {
        a(getBottomMarginWhileShow());
        setLayoutVisibility(0);
        b(this.b);
    }

    public final void d() {
        this.b = null;
        a(getBottomMarginWhileHide());
        setLayoutVisibility(8);
    }

    protected void setLayoutVisibility(int i) {
        this.g.setVisibility(i);
    }

    private void a(int i) {
        ViewGroup.LayoutParams layoutParams = this.f.getLayoutParams();
        if (layoutParams instanceof MarginLayoutParams) {
            ((MarginLayoutParams) layoutParams).bottomMargin = i;
        }
    }
}
