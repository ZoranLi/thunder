package com.xunlei.downloadprovider.homepage.category;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ShortVideoCategoryActivity */
final class e implements OnTouchListener {
    final /* synthetic */ ShortVideoCategoryActivity a;

    e(ShortVideoCategoryActivity shortVideoCategoryActivity) {
        this.a = shortVideoCategoryActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.a.l.post(new f(this, motionEvent));
        }
        this.a.j.a(motionEvent);
        return null;
    }
}
