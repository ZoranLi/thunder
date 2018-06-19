package com.xunlei.downloadprovider.ad.home.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ADImageItemviewBase */
final class k implements OnClickListener {
    final /* synthetic */ ADImageItemviewBase a;

    k(ADImageItemviewBase aDImageItemviewBase) {
        this.a = aDImageItemviewBase;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.f != null) {
            this.a.f.dismiss();
        }
    }
}
