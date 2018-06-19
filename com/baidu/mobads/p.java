package com.baidu.mobads;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import com.baidu.mobads.component.XAdView.Listener;

class p implements Listener {
    final /* synthetic */ InterstitialAd a;

    public void onAttachedToWindow() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onDetachedFromWindow() {
    }

    public void onLayoutComplete(int i, int i2) {
    }

    public void onWindowFocusChanged(boolean z) {
    }

    public void onWindowVisibilityChanged(int i) {
    }

    p(InterstitialAd interstitialAd) {
        this.a = interstitialAd;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.a.c.a(i, keyEvent);
    }
}
