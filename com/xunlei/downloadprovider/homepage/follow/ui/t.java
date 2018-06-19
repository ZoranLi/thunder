package com.xunlei.downloadprovider.homepage.follow.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: FollowTabFragment */
final class t implements OnTouchListener {
    final /* synthetic */ FollowTabFragment a;

    t(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.f.a(motionEvent);
        return null;
    }
}
