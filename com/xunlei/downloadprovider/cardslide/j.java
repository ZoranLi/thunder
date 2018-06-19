package com.xunlei.downloadprovider.cardslide;

import android.os.CountDownTimer;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.c.b;
import com.xunlei.downloadprovider.cardslide.d.c;

/* compiled from: CardSlideActivity */
final class j extends CountDownTimer {
    final /* synthetic */ CardSlideActivity a;

    j(CardSlideActivity cardSlideActivity, long j) {
        this.a = cardSlideActivity;
        super(j, 1000);
    }

    public final void onTick(long j) {
        CardSlideActivity.c;
        j /= 1000;
        new StringBuilder("onTick  ").append(j);
        this.a.g.setText(c.a((int) j));
        if (j < 20 && this.a.y == null) {
            b.d = 1;
            b.a().a(new k(this));
        }
    }

    public final void onFinish() {
        CardSlideActivity.c;
        this.a.g.setText(R.string.card_slide_end_time);
        this.a.e.setVisibility(8);
        this.a.v.sendEmptyMessage(1001);
        cancel();
    }
}
