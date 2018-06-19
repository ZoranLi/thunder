package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BasePayPageFragment */
final class s implements OnClickListener {
    final /* synthetic */ BasePayPageFragment a;

    s(BasePayPageFragment basePayPageFragment) {
        this.a = basePayPageFragment;
    }

    public final void onClick(View view) {
        view = this.a;
        view.a.setVisibility(4);
        view.b.setVisibility(0);
        view.c.setVisibility(8);
        view.l.setVisibility(8);
        this.a.i();
    }
}
