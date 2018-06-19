package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: DownloadDetailsActivityFragment */
final class n implements OnCancelListener {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    n(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.b();
    }
}
