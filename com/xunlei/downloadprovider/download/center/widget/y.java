package com.xunlei.downloadprovider.download.center.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: DownloadMenuPopWindow */
final class y implements OnTouchListener {
    final /* synthetic */ w a;

    y(w wVar) {
        this.a = wVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == null || motionEvent.getAction() == 4) {
            this.a.dismiss();
        }
        return true;
    }
}
