package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class DownloadCenterTabLayout extends TabLayout {
    private boolean a = true;

    public DownloadCenterTabLayout(Context context) {
        super(context);
    }

    public DownloadCenterTabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public DownloadCenterTabLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setTabLayoutEnable(boolean z) {
        this.a = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a ? super.onTouchEvent(motionEvent) : null;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.a ? super.onInterceptTouchEvent(motionEvent) : true;
    }
}
