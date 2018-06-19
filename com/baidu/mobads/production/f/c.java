package com.baidu.mobads.production.f;

import android.view.ViewGroup;

class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        this.a.x.d("remote Interstitial.removeAd");
        this.a.B = false;
        try {
            this.a.e.removeAllViews();
            ViewGroup a = this.a.b(this.a.e.getContext());
            this.a.D.removeAllViews();
            a.removeView(this.a.D);
        } catch (Throwable e) {
            this.a.x.d("Interstitial.removeAd", e);
        }
    }
}
