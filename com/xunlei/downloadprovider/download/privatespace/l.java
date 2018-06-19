package com.xunlei.downloadprovider.download.privatespace;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: OpenPrivateSpaceTipDialog */
final class l implements OnCancelListener {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.a.dismiss();
    }
}
