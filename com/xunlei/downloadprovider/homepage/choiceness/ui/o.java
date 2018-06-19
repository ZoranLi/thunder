package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: HomeChoicenessFragment */
final class o implements OnTouchListener {
    final /* synthetic */ HomeChoicenessFragment a;

    o(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.i.post(new p(this, motionEvent));
        }
        this.a.g.a(motionEvent);
        return null;
    }
}
