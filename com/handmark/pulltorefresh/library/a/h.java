package com.handmark.pulltorefresh.library.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.State;
import com.xunlei.common.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: RotateLoadingLayout */
public final class h extends f {
    private final Animation j;
    private final Matrix k = new Matrix();
    private float l;
    private float m;
    private final boolean n;

    public h(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        this.n = typedArray.getBoolean(R.styleable.PullToRefresh_ptrRotateDrawableWhilePulling, true);
        this.d.setVisibility(null);
        this.j = new RotateAnimation(0.0f, 720.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.j.setInterpolator(a);
        this.j.setDuration(1200);
        this.j.setRepeatCount(-1);
        this.j.setRepeatMode(1);
    }

    public final void a(Drawable drawable) {
        if (drawable != null) {
            this.l = (float) Math.round(((float) drawable.getIntrinsicWidth()) / 2.0f);
            this.m = (float) Math.round(((float) drawable.getIntrinsicHeight()) / 1073741824);
        }
    }

    protected final void a(float f) {
        if (this.n) {
            f *= 90.0f;
        } else {
            f = Math.max(0.0f, Math.min(180.0f, (f * 360.0f) - 180.0f));
        }
        this.k.setRotate(f, this.l, this.m);
    }

    protected final void a() {
        this.d.setVisibility(0);
        this.e.start();
        this.c.setVisibility(8);
        this.f.setVisibility(8);
    }

    protected final void b() {
        this.d.setVisibility(8);
        this.e.stop();
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    protected final int getDefaultDrawableResId() {
        return R.drawable.default_ptr_rotate;
    }

    public final void a(int i, State state, Mode mode) {
        i = Math.abs(i);
        int contentSize = getContentSize();
        this.g.setVisibility(0);
        if (this.h == Mode.PULL_FROM_START) {
            if (i >= contentSize) {
                scrollTo(0, (i - contentSize) / 2);
            } else {
                this.d.setVisibility(8);
                if (this.f.getVisibility() == 8 && state == State.PULL_TO_REFRESH) {
                    this.f.setVisibility(0);
                }
                this.f.setMovieTime((int) (((((double) i) * 1.0d) / ((double) contentSize)) * ((double) this.f.getDuration())));
                if (getScrollY() != 0) {
                    scrollTo(0, 0);
                }
            }
            if (state == State.REFRESHING || state == State.MANUAL_REFRESHING) {
                this.d.setVisibility(0);
                this.c.setVisibility(8);
            }
        }
        if (mode == Mode.PULL_FROM_END && state == State.PULL_TO_REFRESH) {
            this.d.setVisibility(8);
            this.c.setVisibility(0);
        }
    }
}
