package com.xunlei.downloadprovider.download.privatespace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: VerifyPrivateSpaceDialog */
final class ap implements OnCancelListener {
    final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        an.c("quit");
        dialogInterface.dismiss();
    }
}
