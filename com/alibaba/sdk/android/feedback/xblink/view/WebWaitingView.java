package com.alibaba.sdk.android.feedback.xblink.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.sdk.widget.a;

public class WebWaitingView extends RelativeLayout {
    private static final int LOADING_BG_ID = 101;
    private static final int LOADING_PGBAR_ID = 102;

    public WebWaitingView(Context context) {
        super(context);
        init(context);
    }

    public WebWaitingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public WebWaitingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(16)
    private void init(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = 20.0f * f;
        View view = new View(context);
        view.setId(101);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setAlpha(150);
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(gradientDrawable);
        } else {
            view.setBackgroundDrawable(gradientDrawable);
        }
        int i = (int) (120.0f * f);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13);
        addView(view, layoutParams);
        View progressBar = new ProgressBar(context);
        progressBar.setId(102);
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(6, 101);
        layoutParams.topMargin = 10 + ((int) f2);
        addView(progressBar, layoutParams);
        progressBar = new TextView(context);
        progressBar.setText(a.a);
        progressBar.setTextColor(-1);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, 102);
        addView(progressBar, layoutParams2);
    }
}
