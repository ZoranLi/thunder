package com.xunlei.downloadprovider.vod.speeduptrial;

import android.os.Handler;
import android.view.View;

/* compiled from: BubbleTipBarControl */
final class g extends l {
    final /* synthetic */ f a;

    g(f fVar, Handler handler) {
        this.a = fVar;
        super(handler);
    }

    protected final boolean a() {
        if (this.a.b()) {
            View view = this.a.a;
            BubbleBarView bubbleBarView = view.a;
            if (view != null) {
                if (view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
                view.startAnimation(bubbleBarView.f);
            }
        }
        return true;
    }
}
