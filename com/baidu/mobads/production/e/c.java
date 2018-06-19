package com.baidu.mobads.production.e;

import android.graphics.Color;

class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (this.a.s()) {
            this.a.e.setBackgroundColor(Color.argb(51, 0, 0, 0));
        }
        if (this.a.h.getAdView() != null) {
            this.a.h.getAdView().setVisibility(0);
        }
        if (this.a.w()) {
            this.a.x.d("add countdown view");
            this.a.y();
            this.a.e.addView(this.a.x(), this.a.z());
        }
    }
}
