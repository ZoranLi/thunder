package com.xunlei.downloadprovider.ad.home.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ADImageItemviewBase */
final class j implements OnClickListener {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ADImageItemviewBase.a(this.a.a);
        if (this.a.a.f != null) {
            this.a.a.f.dismiss();
        }
    }
}
