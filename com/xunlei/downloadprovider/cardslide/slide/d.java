package com.xunlei.downloadprovider.cardslide.slide;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: CardSlidePanel */
final class d implements OnGlobalLayoutListener {
    final /* synthetic */ CardSlidePanel a;

    d(CardSlidePanel cardSlidePanel) {
        this.a = cardSlidePanel;
    }

    public final void onGlobalLayout() {
        if (this.a.getChildCount() != 4) {
            this.a.a();
        }
    }
}
