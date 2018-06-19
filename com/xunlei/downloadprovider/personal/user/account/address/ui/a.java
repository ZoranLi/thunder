package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: RecyclerItemClickListener */
public final class a implements OnItemTouchListener {
    private a a;
    private GestureDetector b;

    /* compiled from: RecyclerItemClickListener */
    public interface a {
        void a(int i);
    }

    public final void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    public final void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
    }

    public a(RecyclerView recyclerView, a aVar) {
        this.a = aVar;
        this.b = new GestureDetector(recyclerView.getContext(), new b(this, recyclerView));
    }

    public final boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        View findChildViewUnder = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
        if (findChildViewUnder == null || this.a == null || this.b.onTouchEvent(motionEvent) == null) {
            return null;
        }
        this.a.a(recyclerView.getChildAdapterPosition(findChildViewUnder));
        return true;
    }
}
