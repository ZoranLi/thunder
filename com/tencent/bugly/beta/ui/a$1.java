package com.tencent.bugly.beta.ui;

import android.view.View.OnClickListener;

/* compiled from: BUGLY */
class a$1 implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ OnClickListener b;
    final /* synthetic */ String c;
    final /* synthetic */ OnClickListener d;
    final /* synthetic */ a e;

    a$1(a aVar, String str, OnClickListener onClickListener, String str2, OnClickListener onClickListener2) {
        this.e = aVar;
        this.a = str;
        this.b = onClickListener;
        this.c = str2;
        this.d = onClickListener2;
    }

    public void run() {
        if (this.e.g != null) {
            if (this.e.h != null) {
                if (this.a != null) {
                    this.e.g.setVisibility(0);
                    if (this.e.k != 2) {
                        this.e.g.setText(this.a);
                        if (this.e.l == 0) {
                            this.e.g.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(this.e.k), this.e.g, Integer.valueOf(1)));
                        }
                    }
                    this.e.g.setOnClickListener(this.b);
                }
                if (this.c != null) {
                    this.e.h.setVisibility(0);
                    this.e.h.setText(this.c);
                    this.e.h.setOnClickListener(this.d);
                    if (this.e.l == 0) {
                        this.e.h.getViewTreeObserver().addOnPreDrawListener(new d(2, Integer.valueOf(this.e.k), this.e.h, Integer.valueOf(1)));
                    }
                    this.e.h.requestFocus();
                }
            }
        }
    }
}
