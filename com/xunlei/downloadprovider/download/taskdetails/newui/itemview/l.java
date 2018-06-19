package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DetailBtSubTaskViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ g a;

    l(g gVar) {
        this.a = gVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.z != null) {
            this.a.z.dismiss();
            this.a.z = null;
        }
    }
}
