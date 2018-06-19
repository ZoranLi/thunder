package com.xunlei.downloadprovider.member.payment.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BasePayPagerActivity */
final class ab implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ BasePayPagerActivity b;

    ab(BasePayPagerActivity basePayPagerActivity, int i) {
        this.b = basePayPagerActivity;
        this.a = i;
    }

    public final void onClick(View view) {
        this.b.n.setCurrentTab(this.a);
    }
}
