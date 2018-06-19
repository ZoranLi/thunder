package com.xunlei.downloadprovider.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

/* compiled from: XLManagedBaseDialog */
final class j implements OnShowListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onShow(DialogInterface dialogInterface) {
        a.a().a(this.a.b(), true);
        this.a.a();
        if (this.a.a != null) {
            this.a.a.onShow(dialogInterface);
        }
    }
}
