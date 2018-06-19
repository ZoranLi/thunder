package com.xunlei.downloadprovider.homepage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.b.b;

/* compiled from: HomeFragmentAnimatorHelper */
public final class m {
    Activity a;
    boolean b = false;
    boolean c = false;
    float d = 0.0f;
    float e = 0.0f;
    protected int f;
    boolean g;
    boolean h;
    View i;
    View j;
    View k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private View q;
    private View r;
    private AnimatorSet s;

    /* compiled from: HomeFragmentAnimatorHelper */
    private class a implements AnimatorUpdateListener {
        final /* synthetic */ m a;
        private IntEvaluator b = new IntEvaluator();
        private int c;
        private int d;

        public a(m mVar, int i, int i2) {
            this.a = mVar;
            this.c = i;
            this.d = i2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            valueAnimator = ((float) ((Integer) valueAnimator.getAnimatedValue()).intValue()) / 100.0f;
            this.a.j.getLayoutParams().width = this.b.evaluate(valueAnimator, Integer.valueOf(this.c), Integer.valueOf(this.d)).intValue();
            this.a.j.requestLayout();
        }
    }

    public final void a(Activity activity, View view, View view2, View view3, View view4, View view5) {
        this.a = activity;
        this.i = view;
        this.q = view2;
        this.j = view3;
        this.k = view4;
        this.r = view5;
        this.f = b(R.dimen.main_home_top_bar_height);
        this.o = b(R.dimen.common_tab_layout_height);
        this.l = this.f + this.o;
        if (b.c() == null) {
            this.m = b(R.dimen.home_top_tab_download_entrance_width);
            this.n = b(R.dimen.home_top_tab_download_entrance_margin_top) - DipPixelUtil.dip2px(2.0f);
        }
        if (b.c() != null) {
            ((LayoutParams) this.r.getLayoutParams()).rightMargin = 0;
            this.q.setVisibility(8);
            this.r.requestLayout();
        } else {
            this.q.setVisibility(0);
            ((LayoutParams) this.r.getLayoutParams()).rightMargin = this.m;
            this.r.requestLayout();
        }
        a(this.l);
        this.h = true;
    }

    private int b(int i) {
        return (int) this.a.getResources().getDimension(i);
    }

    public final void a() {
        if (this.h) {
            this.g = false;
            this.i.setVisibility(8);
            a(this.l);
            if (this.c) {
                this.k.setTranslationY((float) (this.p - this.f));
            } else {
                this.k.setTranslationY((float) this.p);
            }
        }
    }

    public final void a(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.topMargin = i;
            this.k.requestLayout();
        }
    }

    public final void a(boolean z) {
        Animator ofFloat;
        Animator ofFloat2;
        Animator ofFloat3;
        Animator ofInt;
        if (this.s != null && this.s.isRunning()) {
            this.s.cancel();
            this.s = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        if (z) {
            ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", new float[]{0.0f});
            ofFloat2 = ObjectAnimator.ofFloat(this.q, "translationY", new float[]{0.0f});
            ofFloat3 = ObjectAnimator.ofFloat(this.k, "translationY", new float[]{(float) this.p});
            ofInt = ValueAnimator.ofInt(new int[]{1, 100});
            ofInt.addUpdateListener(new a(this, this.j.getWidth(), 0));
        } else {
            ofFloat = ObjectAnimator.ofFloat(this.i, "translationY", new float[]{(float) (-this.f)});
            ofFloat2 = ObjectAnimator.ofFloat(this.q, "translationY", new float[]{(float) (this.f - this.n)});
            ofFloat3 = ObjectAnimator.ofFloat(this.k, "translationY", new float[]{(float) (this.p - this.f)});
            ofInt = ValueAnimator.ofInt(new int[]{1, 100});
            ofInt.addUpdateListener(new a(this, this.j.getWidth(), this.m));
        }
        animatorSet.addListener(new n(this, z));
        animatorSet.setDuration(200);
        animatorSet.play(ofFloat).with(ofInt).with(ofFloat2).with(ofFloat3);
        animatorSet.start();
        this.s = animatorSet;
    }
}
