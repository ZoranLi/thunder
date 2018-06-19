package com.xunlei.downloadprovider.b;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AppPraiseDlg */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        g.a(this.a.a, "close", false, "");
        this.a.cancel();
    }
}
