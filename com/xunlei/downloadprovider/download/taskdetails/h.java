package com.xunlei.downloadprovider.download.taskdetails;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class h implements OnClickListener {
    final /* synthetic */ z a;
    final /* synthetic */ g b;

    h(g gVar, z zVar) {
        this.b = gVar;
        this.a = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.a.h != null) {
            a.d("cancel", this.b.a.h.mCreateOrigin);
        }
        this.a.dismiss();
    }
}
