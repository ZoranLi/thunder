package com.xunlei.downloadprovider.download.create;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.a;

/* compiled from: ThunderTaskInteractionFragment */
final class aq implements OnClickListener {
    final /* synthetic */ long a;
    final /* synthetic */ ThunderTaskInteractionFragment b;

    aq(ThunderTaskInteractionFragment thunderTaskInteractionFragment, long j) {
        this.b = thunderTaskInteractionFragment;
        this.a = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.b.c();
        a.a(this.b.b(), this.a, "alarmDialog");
    }
}
