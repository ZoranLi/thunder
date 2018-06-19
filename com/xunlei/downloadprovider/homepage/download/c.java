package com.xunlei.downloadprovider.homepage.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: DownloadBriefInfoView */
final class c implements OnDismissListener {
    final /* synthetic */ DownloadBriefInfoView a;

    c(DownloadBriefInfoView downloadBriefInfoView) {
        this.a = downloadBriefInfoView;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.d = null;
    }
}
