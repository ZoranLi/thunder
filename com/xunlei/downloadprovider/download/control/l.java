package com.xunlei.downloadprovider.download.control;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DownloadCenterControl */
final class l implements OnClickListener {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.c != null) {
            this.a.c.dismiss();
            this.a.c = 0;
        }
    }
}
