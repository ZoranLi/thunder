package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ClipboardHandlerActivity */
final class q implements OnClickListener {
    final /* synthetic */ ClipboardHandlerActivity a;

    q(ClipboardHandlerActivity clipboardHandlerActivity) {
        this.a = clipboardHandlerActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.c.dismiss();
    }
}
