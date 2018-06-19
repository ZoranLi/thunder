package com.xunlei.downloadprovider.download.downloadvod.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BxbbNotifySnackbar */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.onClick(this.a.a);
        }
        this.a.a();
    }
}
