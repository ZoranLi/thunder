package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.os.Build.VERSION;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;

/* compiled from: TaskDetailNewImageAdView */
public final class i {
    static final int[] a = new int[]{R.drawable.ic_count_down_1, R.drawable.ic_count_down_2, R.drawable.ic_count_down_3, R.drawable.ic_count_down_4, R.drawable.ic_count_down_5, R.drawable.ic_count_down_6};
    private static final int g = ((AndroidConfig.getScreenWidth() * 9) / 16);
    View b = null;
    CustomDurationLongClickImageView c = null;
    View d = null;
    TextView e = null;
    ImageView f = null;
    private ConstraintLayout h;
    private ConstraintSet i = null;

    public i(ConstraintLayout constraintLayout) {
        this.h = constraintLayout;
        this.b = constraintLayout.findViewById(R.id.fl_ad);
        this.c = (CustomDurationLongClickImageView) constraintLayout.findViewById(R.id.iv_ad_image);
        this.d = constraintLayout.findViewById(R.id.btn_ad_closer);
        this.f = (ImageView) constraintLayout.findViewById(R.id.iv_ad_count_down);
        this.e = (TextView) constraintLayout.findViewById(R.id.tv_ad_closer);
        this.c.setLongClickDurationMillis(2000);
        this.c.setOnLongClickListener(new j(this));
    }

    protected final void a(boolean z) {
        if (this.i == null) {
            this.i = new ConstraintSet();
        }
        this.i.clone(this.h);
        if (z) {
            if (VERSION.SDK_INT >= true) {
                TransitionManager.beginDelayedTransition(this.h);
            }
            this.i.constrainWidth(R.id.fl_ad, DipPixelUtil.dip2px(180.0f));
            this.i.constrainHeight(R.id.fl_ad, DipPixelUtil.dip2px(104.0f));
            this.i.constrainWidth(R.id.iv_line_vertical, DipPixelUtil.dip2px(4.0f));
            this.i.connect(R.id.fl_ad, 3, R.id.fl_top_header, 4);
        } else {
            this.i.constrainWidth(R.id.fl_ad, 0);
            this.i.constrainHeight(R.id.fl_ad, g);
            this.i.constrainWidth(R.id.iv_line_vertical, DipPixelUtil.dip2px(8.0f));
            this.i.connect(R.id.fl_ad, 3, 0, 3);
        }
        this.i.applyTo(this.h);
        this.h.invalidate();
        this.h.requestLayout();
    }

    protected final void b(boolean z) {
        this.d.setEnabled(z);
        this.e.setEnabled(z);
    }
}
