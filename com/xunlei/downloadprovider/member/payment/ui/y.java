package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BasePayPageFragment */
final class y implements OnClickListener {
    final /* synthetic */ BasePayPageFragment a;

    y(BasePayPageFragment basePayPageFragment) {
        this.a = basePayPageFragment;
    }

    public final void onClick(View view) {
        if (this.a.f() != null) {
            BasePayPageFragment.a(this.a);
        }
    }
}
