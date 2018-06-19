package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.support.annotation.DrawableRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class CircleIndicator extends LinearLayout {
    private ViewPager a;
    private PagerAdapter b = null;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = 0;
    private int g = 0;
    private int h = R.drawable.white_radius;
    private int i = R.drawable.white_radius;
    private Animator j;
    private Animator k;
    private Animator l;
    private Animator m;
    private int n = -1;
    private final OnPageChangeListener o = new a(this);
    private DataSetObserver p = new b(this);

    private class a implements Interpolator {
        final /* synthetic */ CircleIndicator a;

        private a(CircleIndicator circleIndicator) {
            this.a = circleIndicator;
        }

        public final float getInterpolation(float f) {
            return Math.abs(1.0f - f);
        }
    }

    public CircleIndicator(Context context) {
        super(context);
        a(context, null);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    private Animator a(Context context) {
        if (this.f == 0) {
            return new AnimatorSet();
        }
        return AnimatorInflater.loadAnimator(context, this.f);
    }

    private Animator b(Context context) {
        if (this.g != 0) {
            return AnimatorInflater.loadAnimator(context, this.g);
        }
        if (this.f == 0) {
            context = new AnimatorSet();
        } else {
            context = AnimatorInflater.loadAnimator(context, this.f);
        }
        context.setInterpolator(new a());
        return context;
    }

    public void setViewPager(ViewPager viewPager) {
        this.a = viewPager;
        this.b = this.a != null ? this.a.getAdapter() : null;
        if (this.a != null && this.b != null) {
            this.n = -1;
            a();
            this.a.removeOnPageChangeListener(this.o);
            this.a.addOnPageChangeListener(this.o);
            this.o.onPageSelected(this.a.getCurrentItem());
        }
    }

    public DataSetObserver getDataSetObserver() {
        return this.p;
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.a == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        this.a.removeOnPageChangeListener(onPageChangeListener);
        this.a.addOnPageChangeListener(onPageChangeListener);
    }

    private void a() {
        removeAllViews();
        int pagerAdapterCount = getPagerAdapterCount();
        if (pagerAdapterCount > 0) {
            int currentItem = this.a.getCurrentItem();
            int orientation = getOrientation();
            for (int i = 0; i < pagerAdapterCount; i++) {
                if (currentItem == i) {
                    a(orientation, this.h, this.l);
                } else {
                    a(orientation, this.i, this.m);
                }
            }
        }
    }

    private void a(int i, @DrawableRes int i2, Animator animator) {
        if (animator.isRunning()) {
            animator.end();
            animator.cancel();
        }
        View view = new View(getContext());
        view.setBackgroundResource(i2);
        addView(view, this.d, this.e);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (i == 0) {
            layoutParams.leftMargin = this.c;
            layoutParams.rightMargin = this.c;
        } else {
            layoutParams.topMargin = this.c;
            layoutParams.bottomMargin = this.c;
        }
        view.setLayoutParams(layoutParams);
        animator.setTarget(view);
        animator.start();
    }

    private int b() {
        return (int) ((5.0f * getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int i = R.drawable.white_radius;
        if (attributeSet != null) {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CircleIndicator);
            int i2 = 0;
            this.d = attributeSet.getDimensionPixelSize(0, -1);
            this.e = attributeSet.getDimensionPixelSize(1, -1);
            this.c = attributeSet.getDimensionPixelSize(2, -1);
            this.f = attributeSet.getResourceId(3, 0);
            this.g = attributeSet.getResourceId(4, 0);
            this.h = attributeSet.getResourceId(5, R.drawable.white_radius);
            this.i = attributeSet.getResourceId(6, this.h);
            if (attributeSet.getInt(7, -1) == 1) {
                i2 = 1;
            }
            setOrientation(i2);
            i2 = attributeSet.getInt(8, -1);
            if (i2 < 0) {
                i2 = 17;
            }
            setGravity(i2);
            attributeSet.recycle();
        }
        this.d = this.d < null ? b() : this.d;
        this.e = this.e < null ? b() : this.e;
        this.c = this.c < null ? b() : this.c;
        this.j = a(context);
        this.l = a(context);
        this.l.setDuration(0);
        this.k = b(context);
        this.m = b(context);
        this.m.setDuration(0);
        if (this.h != null) {
            i = this.h;
        }
        this.h = i;
        this.i = this.i == null ? this.h : this.i;
    }

    private int getPagerAdapterCount() {
        return this.b instanceof c ? ((c) this.b).b() : this.b.getCount();
    }
}
