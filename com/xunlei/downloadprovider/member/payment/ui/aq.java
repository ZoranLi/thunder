package com.xunlei.downloadprovider.member.payment.ui;

import com.xunlei.downloadprovider.member.payment.bean.UpgradePriceParam;
import com.xunlei.downloadprovider.member.payment.ui.widget.RangSeekBar.a;

/* compiled from: PayUpgradeFragment */
final class aq implements a {
    final /* synthetic */ UpgradePriceParam a;
    final /* synthetic */ PayUpgradeFragment b;

    aq(PayUpgradeFragment payUpgradeFragment, UpgradePriceParam upgradePriceParam) {
        this.b = payUpgradeFragment;
        this.a = upgradePriceParam;
    }

    public final void a() {
        this.b.a(this.a, this.b.v.getCurrentCoordValue());
    }
}
