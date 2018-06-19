package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

/* compiled from: DownloadTaskNameAndIconView */
public final class o implements OnGlobalLayoutListener {
    final /* synthetic */ ZHTextView a;
    final /* synthetic */ DownloadTaskNameAndIconView b;

    public o(DownloadTaskNameAndIconView downloadTaskNameAndIconView, ZHTextView zHTextView) {
        this.b = downloadTaskNameAndIconView;
        this.a = zHTextView;
    }

    public final void onGlobalLayout() {
        if (this.a.getCurrentLineNum() <= 4 || !this.b.ac) {
            this.b.c.setVisibility(8);
        } else {
            this.b.c.setVisibility(0);
        }
        this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
}
