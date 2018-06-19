package com.xunlei.downloadprovider.download.control;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DownloadCenterControl */
final class i implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ a b;

    i(a aVar, OnClickListener onClickListener) {
        this.b = aVar;
        this.a = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.d != null) {
            this.b.d.dismiss();
            this.b.d = null;
        }
        this.a.onClick(dialogInterface, i);
    }
}
