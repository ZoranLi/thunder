package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.support.v7.widget.RecyclerView;

/* compiled from: DownloadDetailsActivityFragment */
final class ah implements Runnable {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    ah(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void run() {
        if (this.a.d != null) {
            a e = this.a.d;
            RecyclerView H = this.a.s;
            if (e.o != -1) {
                if (e.n != null) {
                    e.s = e.o;
                    int i = e.o;
                    int findFirstVisibleItemPosition = e.n.findFirstVisibleItemPosition();
                    int findLastVisibleItemPosition = e.n.findLastVisibleItemPosition();
                    if (i <= findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
                        e.n.scrollToPosition(i);
                    } else if (H != null) {
                        H.scrollBy(0, e.n.getChildAt(i - findFirstVisibleItemPosition).getTop());
                    }
                    e.o = -1;
                }
            }
        }
    }
}
