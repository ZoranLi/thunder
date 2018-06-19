package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.download.player.views.right.PlayerRecordButtonView;

/* compiled from: RecordPublishController */
final class au implements Runnable {
    final /* synthetic */ aq a;

    au(aq aqVar) {
        this.a = aqVar;
    }

    public final void run() {
        aq.g(this.a);
        PlayerRecordButtonView h = this.a.g;
        float f = h.b.getScaleX() < 0.8f ? 1.0f : 0.6f;
        h.b.animate().scaleX(f).scaleY(f).setDuration(480).setInterpolator(h.a).start();
        this.a.i.removeCallbacks(this);
        this.a.i.postDelayed(this, 500);
    }
}
