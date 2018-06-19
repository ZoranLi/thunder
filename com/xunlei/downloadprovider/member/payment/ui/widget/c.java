package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CancelPayTipsDialog */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.onClick(this.a, -1);
        }
        this.a.dismiss();
    }
}
