package com.xunlei.downloadprovider.cardslide.slide;

import android.animation.ObjectAnimator;
import android.database.DataSetObserver;
import android.view.View;

/* compiled from: CardSlidePanel */
final class e extends DataSetObserver {
    final /* synthetic */ a a;
    final /* synthetic */ CardSlidePanel b;

    e(CardSlidePanel cardSlidePanel, a aVar) {
        this.b = cardSlidePanel;
        this.a = aVar;
    }

    public final void onChanged() {
        this.b.n = 0;
        this.b.b();
        int i = 0;
        int i2 = i;
        while (i < 4) {
            CardItemView cardItemView = (CardItemView) this.b.a.get(i);
            if (i >= this.a.b()) {
                cardItemView.setVisibility(4);
            } else if (cardItemView.getVisibility() == 0) {
                this.a.a(cardItemView, this.b.n + i);
            } else {
                if (i == 0) {
                    if (this.b.n > 0) {
                        this.b.n = this.b.n + 1;
                    }
                    this.b.m.a(this.b.n, (View) this.b.a.get(0));
                }
                if (i == 3) {
                    cardItemView.setAlpha(0.0f);
                    cardItemView.setVisibility(0);
                } else {
                    int i3 = i2 + 1;
                    if (cardItemView.getVisibility() != 0) {
                        cardItemView.setAlpha(0.0f);
                        cardItemView.setVisibility(0);
                        if (cardItemView.f != null) {
                            cardItemView.f.cancel();
                        }
                        cardItemView.f = ObjectAnimator.ofFloat(cardItemView, "alpha", new float[]{0.0f, 1.0f});
                        cardItemView.f.setDuration(360);
                        cardItemView.f.setStartDelay((long) (i2 * 200));
                        cardItemView.f.start();
                    }
                    i2 = i3;
                }
                this.a.a(cardItemView, this.b.n + i);
            }
            i++;
        }
    }
}
