package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;

/* compiled from: BasicCardViewStubBanner */
public class c implements OnInflateListener {
    protected final ViewStub h;
    protected int i;

    public void onInflate(ViewStub viewStub, View view) {
    }

    public c(ViewStub viewStub) {
        this.h = viewStub;
        this.h.setOnInflateListener(this);
    }

    public final int g() {
        return this.i;
    }

    public final void c(int i) {
        this.i = i;
    }

    public final int h() {
        return this.h.getVisibility();
    }

    public final void d(int i) {
        this.h.setVisibility(i);
    }

    public static void a(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof MarginLayoutParams) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                if (VERSION.SDK_INT >= 17) {
                    marginLayoutParams.setMarginStart(i);
                } else {
                    marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }
}
