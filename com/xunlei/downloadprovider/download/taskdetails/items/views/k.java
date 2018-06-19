package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTaskNameAndIconView */
final class k implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    k(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void onClick(View view) {
        if (this.a.ac != null) {
            this.a.c();
        } else {
            this.a.d();
        }
        if (this.a.ah != null) {
            this.a.ah.a(this.a.ac);
        }
    }
}
