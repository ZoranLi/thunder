package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ClipboardHandlerActivity */
final class s implements OnDismissListener {
    final /* synthetic */ ClipboardHandlerActivity a;

    s(ClipboardHandlerActivity clipboardHandlerActivity) {
        this.a = clipboardHandlerActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
