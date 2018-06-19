package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ThunderTaskInteractionFragment */
final class as implements OnDismissListener {
    final /* synthetic */ ThunderTaskInteractionFragment a;

    as(ThunderTaskInteractionFragment thunderTaskInteractionFragment) {
        this.a = thunderTaskInteractionFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.c();
    }
}
