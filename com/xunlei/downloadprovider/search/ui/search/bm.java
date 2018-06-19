package com.xunlei.downloadprovider.search.ui.search;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: SearchOperateActivity */
final class bm implements OnTouchListener {
    final /* synthetic */ SearchOperateActivity a;

    bm(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == null) {
            SearchOperateActivity.k(this.a);
        }
        return null;
    }
}
