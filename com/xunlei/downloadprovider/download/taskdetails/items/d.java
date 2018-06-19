package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: DetailBtTaskSubFileViewHolder */
final class d implements OnTouchListener {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == null) {
            this.a.x.postDelayed(this.a.y, 500);
        }
        if ((motionEvent.getAction() == 3 || motionEvent.getAction() == 8 || motionEvent.getAction() == 1) && motionEvent.getX() != null) {
            this.a.x.removeCallbacks(this.a.y);
        }
        return null;
    }
}
