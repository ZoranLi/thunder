package com.xunlei.downloadprovider.download.center.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: DownloadMenuPopWindow */
final class x implements OnKeyListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1) {
            return null;
        }
        if (this.a.isShowing() == 0) {
            return true;
        }
        this.a.dismiss();
        return true;
    }
}
