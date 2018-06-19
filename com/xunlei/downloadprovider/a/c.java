package com.xunlei.downloadprovider.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ActivityDlg */
final class c implements OnClickListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.cancel();
    }
}
