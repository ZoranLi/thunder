package com.xunlei.downloadprovider.personal.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: MessageItemFragment */
final class p implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    p(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
