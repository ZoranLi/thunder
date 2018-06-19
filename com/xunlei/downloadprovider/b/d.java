package com.xunlei.downloadprovider.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.a.b.a;
import com.xunlei.downloadprovider.personal.a.i;

/* compiled from: AppPraiseDlg */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        i.a(this.a.getContext(), a.b, "AppPraiseDlg");
        g.a(this.a.a, "tucao", false, "");
        this.a.cancel();
    }
}
