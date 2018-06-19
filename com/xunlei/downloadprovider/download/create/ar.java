package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ThunderTaskInteractionFragment */
final class ar implements OnClickListener {
    final /* synthetic */ ThunderTaskInteractionFragment a;

    ar(ThunderTaskInteractionFragment thunderTaskInteractionFragment) {
        this.a = thunderTaskInteractionFragment;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.d.dismiss();
    }
}
