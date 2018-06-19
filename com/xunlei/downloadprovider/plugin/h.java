package com.xunlei.downloadprovider.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: XLPluginDownloadManager */
final class h implements OnClickListener {
    final /* synthetic */ p a;
    final /* synthetic */ a b;

    h(a aVar, p pVar) {
        this.b = aVar;
        this.a = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.a(this.b, this.a);
    }
}
