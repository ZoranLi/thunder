package com.xunlei.downloadprovider.download.privatespace;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ClosePrivateSpaceTipDialog */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        an.a("quit", "close");
        this.a.dismiss();
    }
}
