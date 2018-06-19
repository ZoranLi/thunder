package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.d;

/* compiled from: BasePayPageFragment */
final class u implements OnClickListener {
    final /* synthetic */ BasePayPageFragment a;

    u(BasePayPageFragment basePayPageFragment) {
        this.a = basePayPageFragment;
    }

    public final void onClick(View view) {
        PayProblemActivity.a(this.a, this.a.f);
        d.f();
    }
}
