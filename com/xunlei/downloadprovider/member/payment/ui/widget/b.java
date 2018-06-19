package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CancelPayTipsDialog */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.onClick(this.a, -2);
        }
        this.a.dismiss();
    }
}
