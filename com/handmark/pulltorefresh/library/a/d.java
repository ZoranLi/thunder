package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.common.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

@SuppressLint({"ViewConstructor"})
/* compiled from: IndicatorLayout */
public final class d extends FrameLayout implements AnimationListener {
    private Animation a;
    private Animation b;
    private ImageView c;
    private final Animation d;
    private final Animation e;

    public final void onAnimationRepeat(Animation animation) {
    }

    public d(Context context, Mode mode) {
        int i;
        super(context);
        this.c = new ImageView(context);
        Drawable drawable = getResources().getDrawable(R.drawable.indicator_arrow);
        this.c.setImageDrawable(drawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.indicator_internal_padding);
        this.c.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        addView(this.c);
        if (e.a[mode.ordinal()] != 1) {
            mode = R.anim.slide_in_from_top;
            i = R.anim.slide_out_to_top;
            setBackgroundResource(R.drawable.indicator_bg_top);
        } else {
            mode = R.anim.slide_in_from_bottom;
            int i2 = R.anim.slide_out_to_bottom;
            setBackgroundResource(R.drawable.indicator_bg_bottom);
            this.c.setScaleType(ScaleType.MATRIX);
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, ((float) drawable.getIntrinsicWidth()) / 2.0f, ((float) drawable.getIntrinsicHeight()) / 2.0f);
            this.c.setImageMatrix(matrix);
            i = i2;
        }
        this.a = AnimationUtils.loadAnimation(context, mode);
        this.a.setAnimationListener(this);
        this.b = AnimationUtils.loadAnimation(context, i);
        this.b.setAnimationListener(this);
        context = new LinearInterpolator();
        this.d = new RotateAnimation(0.0f, -180.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.d.setInterpolator(context);
        this.d.setDuration(150);
        this.d.setFillAfter(true);
        this.e = new RotateAnimation(-180.0f, 0.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.e.setInterpolator(context);
        this.e.setDuration(150);
        this.e.setFillAfter(true);
    }

    public final boolean a() {
        Animation animation = getAnimation();
        return animation != null ? this.a == animation : getVisibility() == 0;
    }

    public final void b() {
        startAnimation(this.b);
    }

    public final void c() {
        this.c.clearAnimation();
        startAnimation(this.a);
    }

    public final void onAnimationEnd(Animation animation) {
        if (animation == this.b) {
            this.c.clearAnimation();
            setVisibility(8);
        } else if (animation == this.a) {
            setVisibility(null);
        }
        clearAnimation();
    }

    public final void onAnimationStart(Animation animation) {
        setVisibility(null);
    }

    public final void d() {
        this.c.startAnimation(this.d);
    }

    public final void e() {
        this.c.startAnimation(this.e);
    }
}
