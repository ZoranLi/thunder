package com.xunlei.downloadprovider.download.giftdispatch;

import android.os.Handler;
import android.view.animation.AnimationUtils;
import com.xunlei.downloadprovider.R;

/* compiled from: GiftDispatchingActivity */
final class g implements Runnable {
    final /* synthetic */ GiftDispatchingActivity a;

    g(GiftDispatchingActivity giftDispatchingActivity) {
        this.a = giftDispatchingActivity;
    }

    public final void run() {
        this.a.g = false;
        this.a.f.setVisibility(4);
        this.a.f.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.gift_bottom_position_hide));
        new Handler().postDelayed(new h(this), 200);
    }
}
