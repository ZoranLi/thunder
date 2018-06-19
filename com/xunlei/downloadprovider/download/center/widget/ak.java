package com.xunlei.downloadprovider.download.center.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTaskMoreOperationDialog */
final class ak implements OnClickListener {
    final /* synthetic */ aj a;

    ak(aj ajVar) {
        this.a = ajVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.a.g != 0) {
            a.d("cancel", this.a.a.g.mCreateOrigin);
        }
        dialogInterface.dismiss();
        this.a.a.dismiss();
    }
}
