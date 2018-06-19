package com.xunlei.downloadprovider.download.privatespace;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VerifyPrivateSpaceDialog */
final class aq implements OnClickListener {
    final /* synthetic */ ao a;

    aq(ao aoVar) {
        this.a = aoVar;
    }

    public final void onClick(View view) {
        an.c("quit");
        this.a.dismiss();
    }
}
