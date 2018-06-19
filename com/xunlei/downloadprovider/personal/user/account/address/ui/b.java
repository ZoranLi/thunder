package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: RecyclerItemClickListener */
final class b extends SimpleOnGestureListener {
    final /* synthetic */ RecyclerView a;
    final /* synthetic */ a b;

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }

    b(a aVar, RecyclerView recyclerView) {
        this.b = aVar;
        this.a = recyclerView;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        motionEvent = this.a.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (motionEvent != null && this.b.a != null) {
            this.a.getChildAdapterPosition(motionEvent);
        }
    }
}
