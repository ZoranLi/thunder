package com.xunlei.downloadprovider.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLManagedAlertDialog */
final class h implements OnClickListener {
    final /* synthetic */ f a;

    h(f fVar) {
        this.a = fVar;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            this.a.h.onClick(this.a, -1);
        } else {
            this.a.dismiss();
        }
    }
}
