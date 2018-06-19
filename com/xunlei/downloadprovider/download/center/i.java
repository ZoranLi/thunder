package com.xunlei.downloadprovider.download.center;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterActivityFragment */
final class i implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ z b;
    final /* synthetic */ h c;

    i(h hVar, String str, z zVar) {
        this.c = hVar;
        this.a = str;
        this.b = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.d("cancel", this.a);
        this.b.dismiss();
    }
}
