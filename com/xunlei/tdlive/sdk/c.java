package com.xunlei.tdlive.sdk;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLLivePlugin */
public class c {
    private static c a;
    private BasePlugin b;

    public static c a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    void a(BasePlugin basePlugin) {
        this.b = basePlugin;
    }

    public View a(Context context, OnClickListener onClickListener) {
        return this.b != null ? this.b.newErrorView(context, onClickListener) : null;
    }

    public void a(Context context, View view, int i) {
        if (this.b != null) {
            this.b.setErrorViewType(context, view, i);
        }
    }
}
