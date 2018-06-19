package com.xunlei.downloadprovider.download.taskdetails;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

/* compiled from: DownloadCenterDetailFragment */
final class u implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ List b;
    final /* synthetic */ DownloadCenterDetailFragment c;

    u(DownloadCenterDetailFragment downloadCenterDetailFragment, int i, List list) {
        this.c = downloadCenterDetailFragment;
        this.a = i;
        this.b = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.c.e();
        if (this.c.d != null) {
            this.c.d.dismiss();
            this.c.d = null;
        }
        dialogInterface = this.c;
        i = this.a;
        this.b.size();
        DownloadCenterDetailFragment.a(dialogInterface, i, this.b);
    }
}
