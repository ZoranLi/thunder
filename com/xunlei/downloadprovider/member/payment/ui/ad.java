package com.xunlei.downloadprovider.member.payment.ui;

import android.widget.TabHost.OnTabChangeListener;

/* compiled from: BasePayPagerActivity */
final class ad implements OnTabChangeListener {
    final /* synthetic */ BasePayPagerActivity a;

    ad(BasePayPagerActivity basePayPagerActivity) {
        this.a = basePayPagerActivity;
    }

    public final void onTabChanged(String str) {
        if (this.a.j != null) {
            this.a.j.setCurrentItem(this.a.n.getCurrentTab());
        }
        this.a.n.getCurrentTabView().setSelected(true);
        this.a.r();
        this.a.n();
    }
}
