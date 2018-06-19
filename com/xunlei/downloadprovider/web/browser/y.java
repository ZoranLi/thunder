package com.xunlei.downloadprovider.web.browser;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: BrowserCollectTipPPW */
public final class y extends PopupWindow {
    private Context a;

    public y(Context context) {
        super(context);
        this.a = context;
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a).inflate(R.layout.layout_popupwindow_browser_collect_tip, null);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.measure(0, 0);
        setWidth(-2);
        setHeight(-2);
        setContentView(linearLayout);
        update();
        linearLayout.setOnClickListener(new z(this));
    }

    public final void dismiss() {
        super.dismiss();
        f.a(BrothersApplication.getApplicationInstance(), "browser_collect_bottom_toast_dismiss", true);
    }

    public final void update() {
        try {
            super.update();
        } catch (Throwable e) {
            e.printStackTrace();
            CrashReport.postCatchedException(e);
        }
    }

    public final void update(int i, int i2) {
        try {
            super.update(i, i2);
        } catch (int i3) {
            i3.printStackTrace();
            CrashReport.postCatchedException(i3);
        }
    }

    public final void update(int i, int i2, int i3, int i4) {
        try {
            super.update(i, i2, i3, i4);
        } catch (int i5) {
            i5.printStackTrace();
            CrashReport.postCatchedException(i5);
        }
    }

    public final void update(int i, int i2, int i3, int i4, boolean z) {
        try {
            super.update(i, i2, i3, i4, z);
        } catch (int i5) {
            i5.printStackTrace();
            CrashReport.postCatchedException(i5);
        }
    }

    public final void update(View view, int i, int i2) {
        try {
            super.update(view, i, i2);
        } catch (View view2) {
            view2.printStackTrace();
            CrashReport.postCatchedException(view2);
        }
    }

    public final void update(View view, int i, int i2, int i3, int i4) {
        try {
            super.update(view, i, i2, i3, i4);
        } catch (View view2) {
            view2.printStackTrace();
            CrashReport.postCatchedException(view2);
        }
    }
}
