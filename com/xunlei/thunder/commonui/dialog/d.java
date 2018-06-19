package com.xunlei.thunder.commonui.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: XLBasicAlertDialog */
final class d implements OnClickListener {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.a.onClick(this.a, -1);
    }
}
