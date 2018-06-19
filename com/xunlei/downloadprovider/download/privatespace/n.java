package com.xunlei.downloadprovider.download.privatespace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: OpenPrivateSpaceTipDialog */
final class n implements OnCancelListener {
    final /* synthetic */ k a;

    n(k kVar) {
        this.a = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        an.a("quit", "open");
        dialogInterface.dismiss();
    }
}
