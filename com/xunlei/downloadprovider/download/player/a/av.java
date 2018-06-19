package com.xunlei.downloadprovider.download.player.a;

import android.widget.RelativeLayout.LayoutParams;

/* compiled from: RecordPublishController */
final class av implements Runnable {
    final /* synthetic */ aq a;

    av(aq aqVar) {
        this.a = aqVar;
    }

    public final void run() {
        this.a.d.setVisibility(0);
        int measuredWidth = this.a.b.getMeasuredWidth();
        if (measuredWidth > 0) {
            measuredWidth = (int) (((((float) measuredWidth) * 1.0f) * ((float) aq.a)) / ((float) aq.q));
            LayoutParams layoutParams = (LayoutParams) this.a.d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = measuredWidth;
                this.a.d.requestLayout();
            }
        }
    }
}
