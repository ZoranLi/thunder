package com.xunlei.downloadprovider.download.privatespace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: NoVipUsePrivateSpaceTipDialog */
final class h implements OnCancelListener {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        an.a("quit");
        this.a.dismiss();
    }
}
