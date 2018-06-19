package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTaskNameAndIconView */
final class j implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    j(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void onClick(View view) {
        this.a.d();
        if (this.a.ah != null) {
            this.a.ah.a(this.a.ac);
        }
    }
}
