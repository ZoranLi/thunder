package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.downloadvod.a;

/* compiled from: DownloadDetailsActivityFragment */
final class ar implements OnClickListener {
    final /* synthetic */ long a;
    final /* synthetic */ DownloadDetailsActivityFragment b;

    ar(DownloadDetailsActivityFragment downloadDetailsActivityFragment, long j) {
        this.b = downloadDetailsActivityFragment;
        this.a = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.b();
        a.setDownloadVodAllowMobileNetwork(this.a);
        this.b.c(true);
        this.b.i.b(1);
    }
}
