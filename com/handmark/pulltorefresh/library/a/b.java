package com.handmark.pulltorefresh.library.a;

import android.annotation.SuppressLint;
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

@SuppressLint({"ViewConstructor"})
/* compiled from: FlipLoadingLayout */
public final class b extends f {
    private final Animation j;
    private final Animation k;

    protected final void a() {
    }

    protected final void a(float f) {
    }

    public final void a(int i, State state, Mode mode) {
    }

    protected final void b() {
    }

    public b(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
        context = (float) (mode == Mode.PULL_FROM_START ? -180 : 180);
        this.j = new RotateAnimation(0.0f, context, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.j.setInterpolator(a);
        this.j.setDuration(150);
        this.j.setFillAfter(true);
        this.k = new RotateAnimation(context, 0.0f, 1, PayBaseConstants.HALF_OF_FLOAT, 1, PayBaseConstants.HALF_OF_FLOAT);
        this.k.setInterpolator(a);
        this.k.setDuration(150);
        this.k.setFillAfter(true);
    }

    protected final void a(Drawable drawable) {
        if (drawable != null) {
            drawable.getIntrinsicHeight();
            drawable.getIntrinsicWidth();
            drawable = new Matrix();
        }
    }

    protected final int getDefaultDrawableResId() {
        return R.drawable.default_ptr_flip;
    }

    private float getDrawableRotationAngle() {
        switch (c.a[this.h.ordinal()]) {
            case 1:
                return this.i == Orientation.HORIZONTAL ? 90.0f : 180.0f;
            case 2:
                if (this.i == Orientation.HORIZONTAL) {
                    return 270.0f;
                }
                break;
            default:
                break;
        }
        return 0.0f;
    }
}
