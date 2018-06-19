package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.bugly.crashreport.CrashReport;

public class SafePopupWindow extends PopupWindow {
    public SafePopupWindow(Context context) {
        super(context);
    }

    public SafePopupWindow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SafePopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void update() {
        try {
            super.update();
        } catch (Throwable e) {
            e.printStackTrace();
            CrashReport.postCatchedException(e);
        }
    }

    public void update(int i, int i2) {
        try {
            super.update(i, i2);
        } catch (int i3) {
            i3.printStackTrace();
            CrashReport.postCatchedException(i3);
        }
    }

    public void update(int i, int i2, int i3, int i4) {
        try {
            super.update(i, i2, i3, i4);
        } catch (int i5) {
            i5.printStackTrace();
            CrashReport.postCatchedException(i5);
        }
    }

    public void update(int i, int i2, int i3, int i4, boolean z) {
        try {
            super.update(i, i2, i3, i4, z);
        } catch (int i5) {
            i5.printStackTrace();
            CrashReport.postCatchedException(i5);
        }
    }

    public void update(View view, int i, int i2) {
        try {
            super.update(view, i, i2);
        } catch (View view2) {
            view2.printStackTrace();
            CrashReport.postCatchedException(view2);
        }
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        try {
            super.update(view, i, i2, i3, i4);
        } catch (View view2) {
            view2.printStackTrace();
            CrashReport.postCatchedException(view2);
        }
    }
}
