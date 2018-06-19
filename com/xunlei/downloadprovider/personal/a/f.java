package com.xunlei.downloadprovider.personal.a;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RenewalDialog */
final class f implements OnClickListener {
    final /* synthetic */ c a;

    f(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        ((DialogInterface.OnClickListener) view.getTag()).onClick(this.a, 0);
    }
}
