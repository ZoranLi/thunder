package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.R;

/* compiled from: ShortMovieDetailActivity */
final class z implements AnimatorUpdateListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ MarginLayoutParams e;
    final /* synthetic */ int f;
    final /* synthetic */ int g;
    final /* synthetic */ ShortMovieDetailActivity h;

    z(ShortMovieDetailActivity shortMovieDetailActivity, int i, int i2, int i3, int i4, MarginLayoutParams marginLayoutParams, int i5, int i6) {
        this.h = shortMovieDetailActivity;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = marginLayoutParams;
        this.f = i5;
        this.g = i6;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (!this.h.isFinishing()) {
            int floatValue = (int) (((float) this.c) + (((float) (this.d - this.c)) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            this.e.height = (int) (((float) this.a) + (((float) (this.b - this.a)) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            this.e.topMargin = floatValue;
            this.h.i.requestLayout();
            if (this.h.I) {
                this.h.r.setBackgroundColor(this.h.getResources().getColor(R.color.transparent));
                return;
            }
            this.h.r.setBackgroundColor(ShortMovieDetailActivity.a(this.f, this.g, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }
}
