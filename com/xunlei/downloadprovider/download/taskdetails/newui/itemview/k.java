package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DetailBtSubTaskViewHolder */
final class k implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ g b;

    k(g gVar, OnClickListener onClickListener) {
        this.b = gVar;
        this.a = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.z != null) {
            this.b.z.dismiss();
            this.b.z = null;
        }
        this.a.onClick(dialogInterface, i);
    }
}
