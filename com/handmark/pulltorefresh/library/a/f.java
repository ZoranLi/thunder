package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.handmark.pulltorefresh.library.a;
import com.xunlei.common.R;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.GifView;

@SuppressLint({"ViewConstructor"})
/* compiled from: LoadingLayout */
public abstract class f extends FrameLayout implements a {
    static final Interpolator a = new LinearInterpolator();
    protected View b;
    protected final ImageView c;
    protected final ImageView d;
    protected final AnimationDrawable e;
    protected final GifView f;
    protected final TextView g;
    protected final Mode h;
    protected final Orientation i;
    private boolean j;
    private CharSequence k = "下拉刷新";
    private CharSequence l = "正在刷新...";
    private CharSequence m;

    public static void d() {
    }

    public static void h() {
    }

    private void setTextColor(ColorStateList colorStateList) {
    }

    protected abstract void a();

    protected abstract void a(float f);

    public abstract void a(int i, State state, Mode mode);

    protected abstract void a(Drawable drawable);

    protected abstract void b();

    protected abstract int getDefaultDrawableResId();

    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    public f(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context);
        this.h = mode;
        this.i = orientation;
        if (g.a[orientation.ordinal()] != 1) {
            LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_vertical, this);
        } else {
            LayoutInflater.from(context).inflate(R.layout.pull_to_refresh_header_horizontal, this);
        }
        this.b = findViewById(R.id.fl_inner);
        this.g = (TextView) this.b.findViewById(R.id.pull_to_refresh_text);
        this.c = (ImageView) this.b.findViewById(R.id.pull_to_refresh_pulling_static);
        this.f = (GifView) this.b.findViewById(R.id.pull_to_refresh_pulling);
        this.f.setByUser(true);
        this.d = (ImageView) this.b.findViewById(R.id.pull_to_refresh_refreshing);
        String phoneBrand = AndroidConfig.getPhoneBrand();
        String phoneModel = AndroidConfig.getPhoneModel();
        if ("GiONEE".equals(phoneBrand) && "E7".equals(phoneModel)) {
            this.d.setImageResource(R.drawable.loading_animate2);
        }
        this.e = (AnimationDrawable) this.d.getDrawable();
        LayoutParams layoutParams = (LayoutParams) this.b.getLayoutParams();
        if (g.b[mode.ordinal()] != 1) {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 80 : 5;
            setClipChildren(null);
            this.k = "下拉刷新";
            this.l = "正在刷新...";
            this.m = "松开立即刷新";
        } else {
            layoutParams.gravity = orientation == Orientation.VERTICAL ? 48 : 3;
            this.k = "上拉加载";
            this.l = com.alipay.sdk.widget.a.a;
            this.m = "松开立即加载";
            this.b.setPadding(this.b.getPaddingLeft(), this.b.getPaddingBottom(), this.b.getPaddingRight(), this.b.getPaddingTop());
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderBackground) != null) {
            orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrHeaderBackground);
            if (orientation != null) {
                if (VERSION.SDK_INT >= 16) {
                    setBackground(orientation);
                } else {
                    setBackgroundDrawable(orientation);
                }
            }
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance) != null) {
            orientation = new TypedValue();
            typedArray.getValue(R.styleable.PullToRefresh_ptrHeaderTextAppearance, orientation);
            setTextAppearance(orientation.data);
        }
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrHeaderTextColor) != null) {
            orientation = typedArray.getColorStateList(R.styleable.PullToRefresh_ptrHeaderTextColor);
            if (orientation != null) {
                setTextColor(orientation);
            }
        }
        orientation = null;
        if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawable)) {
            orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawable);
        }
        if (g.b[mode.ordinal()] != 1) {
            if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableStart) != null) {
                orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableStart);
            } else if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableTop) != null) {
                orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableTop);
            }
        } else if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableEnd) != null) {
            orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableEnd);
        } else if (typedArray.hasValue(R.styleable.PullToRefresh_ptrDrawableBottom) != null) {
            orientation = typedArray.getDrawable(R.styleable.PullToRefresh_ptrDrawableBottom);
        }
        if (orientation == null) {
            orientation = context.getResources().getDrawable(getDefaultDrawableResId());
        }
        setLoadingDrawable(orientation);
        g();
    }

    public final void c() {
        this.f.setVisibility(8);
        this.d.setVisibility(8);
        this.g.setVisibility(8);
    }

    public final void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }

    public final void setWidth(int i) {
        getLayoutParams().width = i;
        requestLayout();
    }

    public final void setPaddingTop(int i) {
        this.b.setPadding(this.b.getPaddingLeft(), i, this.b.getPaddingRight(), this.b.getPaddingBottom());
    }

    public final int getContentSize() {
        if (g.a[this.i.ordinal()] != 1) {
            return this.b.getHeight();
        }
        return this.b.getWidth();
    }

    public final int getInnerTop() {
        return this.b.getTop();
    }

    public final void b(float f) {
        if (!this.j) {
            a(f);
        }
    }

    public final void e() {
        if (this.g != null) {
            this.g.setText(this.k);
        }
        invalidate();
    }

    public final void f() {
        if (this.g != null) {
            this.g.setText(this.l);
        }
        if (!this.j) {
            a();
        }
    }

    public final void g() {
        if (!this.j) {
            b();
        }
    }

    public final void setLoadingDrawable(Drawable drawable) {
        this.j = drawable instanceof AnimationDrawable;
        a(drawable);
    }

    public void setPullLabel(CharSequence charSequence) {
        this.k = charSequence;
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        this.l = charSequence;
    }

    public void setReleaseLabel(CharSequence charSequence) {
        this.m = charSequence;
    }

    public void setTextTypeface(Typeface typeface) {
        this.g.setTypeface(typeface);
    }

    private void setTextAppearance(int i) {
        if (this.g != null) {
            this.g.setTextAppearance(getContext(), i);
        }
    }

    public void setBgColorForRefreshingView(int i) {
        this.c.setBackgroundResource(i);
    }
}
