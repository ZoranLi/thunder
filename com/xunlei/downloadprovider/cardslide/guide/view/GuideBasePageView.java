package com.xunlei.downloadprovider.cardslide.guide.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

public abstract class GuideBasePageView extends RelativeLayout {
    public Context a;

    public abstract int getLayoutId();

    public GuideBasePageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        LayoutInflater.from(this.a).inflate(getLayoutId(), this);
    }
}
