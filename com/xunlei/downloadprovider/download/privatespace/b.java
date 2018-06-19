package com.xunlei.downloadprovider.download.privatespace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: ClosePrivateSpaceTipDialog */
final class b implements OnCancelListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        an.a("quit", "close");
        dialogInterface.dismiss();
    }
}
