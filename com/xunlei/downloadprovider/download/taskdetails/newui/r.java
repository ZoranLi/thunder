package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadDetailsActivityFragment */
final class r implements OnClickListener {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    r(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onClick(View view) {
        this.a.a("dl_bt_fold");
        this.a.d.c(false);
        this.a.d.g();
    }
}
