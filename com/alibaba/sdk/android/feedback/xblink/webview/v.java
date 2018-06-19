package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.alibaba.sdk.android.feedback.xblink.view.WebErrorView;
import com.alibaba.sdk.android.feedback.xblink.view.WebWaitingView;

public class v {
    private View a;
    private View b;
    private View c;
    private Context d;
    private boolean e = false;

    public v(Context context, View view) {
        this.d = context;
        this.c = view;
    }

    public void a() {
        this.e = true;
    }

    public void a(View view) {
        if (view != null) {
            this.a = view;
            this.a.setVisibility(8);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent = this.c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.a, layoutParams);
            }
        }
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        if (view != null) {
            this.a = view;
            this.a.setVisibility(8);
            ViewParent parent = this.c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.a, layoutParams);
            }
        }
    }

    public void b() {
        if (this.e) {
            if (this.a == null) {
                this.a = new WebWaitingView(this.d);
                a(this.a);
            }
            this.a.bringToFront();
            if (this.a.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
        }
    }

    public void b(View view) {
        if (view != null) {
            this.b = view;
            this.b.setVisibility(8);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(14, 1);
            ViewParent parent = this.c.getParent();
            if (parent != null) {
                ((ViewGroup) parent).addView(this.b, layoutParams);
            }
        }
    }

    public void c() {
        if (this.e && this.a != null && this.a.getVisibility() != 8) {
            this.a.setVisibility(8);
        }
    }

    public void d() {
        if (this.b == null) {
            this.b = new WebErrorView(this.d);
            b(this.b);
        }
        this.b.bringToFront();
        if (this.b.getVisibility() != 0) {
            this.b.setVisibility(0);
        }
    }

    public void e() {
        if (this.b != null && this.b.getVisibility() != 8) {
            this.b.setVisibility(8);
        }
    }
}
