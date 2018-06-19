package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.download.taskdetails.widget.FloatDragView.a;

/* compiled from: DownloadCenterDetailFragment */
final class e implements a {
    final /* synthetic */ DownloadCenterDetailFragment a;

    e(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void a(float f) {
        if (!(this.a.n || this.a.b)) {
            if (((double) f) == -1.0d) {
                this.a.h();
                return;
            }
            this.a.i();
        }
    }

    public final void a(int i) {
        if (i == 10 && this.a.b == 0) {
            this.a.a(true);
        }
    }
}
