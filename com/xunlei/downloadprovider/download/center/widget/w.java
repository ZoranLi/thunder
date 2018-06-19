package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.widget.KeyLinearLayout;

/* compiled from: DownloadMenuPopWindow */
public class w extends SafePopupWindow {
    private View a;
    private int b;
    private int c;

    public final void a(View view, int i, int i2) {
        this.a = view;
        this.b = i;
        this.c = i2;
    }

    public w(Context context) {
        super(context);
        setFocusable(true);
        setAnimationStyle(R.style.PopupTopAnim);
        setBackgroundDrawable(new BitmapDrawable());
    }

    public void a() {
        if (!isShowing()) {
            if (this.a != null) {
                showAsDropDown(this.a, this.b, this.c);
            }
        }
    }

    public void setContentView(View view) {
        super.setContentView(view);
        if (view instanceof KeyLinearLayout) {
            ((KeyLinearLayout) view).setKeyInterceptor(new x(this));
            view.setOnTouchListener(new y(this));
        }
    }
}
