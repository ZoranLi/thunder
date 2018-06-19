package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: BaseRecyViewFragment */
final class d implements OnTouchListener {
    final /* synthetic */ BaseRecyViewFragment a;

    d(BaseRecyViewFragment baseRecyViewFragment) {
        this.a = baseRecyViewFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.a.e != null) {
            this.a.e.a(motionEvent);
        }
        return null;
    }
}
