package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: DetailBtSubTaskViewHolder */
final class h implements OnTouchListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
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
