package com.xunlei.downloadprovider.download.center;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: DownloadCenterActivityFragment */
final class m implements OnDismissListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    m(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.i = null;
    }
}
