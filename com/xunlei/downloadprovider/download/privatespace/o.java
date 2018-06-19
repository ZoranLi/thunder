package com.xunlei.downloadprovider.download.privatespace;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: OpenPrivateSpaceTipDialog */
final class o implements OnClickListener {
    final /* synthetic */ k a;

    o(k kVar) {
        this.a = kVar;
    }

    public final void onClick(View view) {
        an.a("quit", "open");
        this.a.b.dismiss();
    }
}
