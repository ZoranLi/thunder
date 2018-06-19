package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTaskNameAndIconView_New */
final class v implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView_New a;

    v(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        this.a = downloadTaskNameAndIconView_New;
    }

    public final void onClick(View view) {
        if (this.a.ac != null) {
            this.a.c();
        } else {
            this.a.f();
        }
        if (this.a.ag != null) {
            this.a.ag.a(this.a.ac);
        }
    }
}
