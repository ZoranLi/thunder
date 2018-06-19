package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLManagedAlertDialog */
final class g implements OnClickListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            this.a.g.onClick(this.a, -2);
        } else {
            this.a.dismiss();
        }
    }
}
