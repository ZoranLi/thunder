package com.xunlei.downloadprovider.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: XLPluginDownloadManager */
final class d implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ a b;

    d(a aVar, OnClickListener onClickListener) {
        this.b = aVar;
        this.a = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (a.j(this.b) != null) {
            a.j(this.b).dismiss();
            a.k(this.b);
        }
        if (this.a != null) {
            this.a.onClick(dialogInterface, i);
        }
    }
}
