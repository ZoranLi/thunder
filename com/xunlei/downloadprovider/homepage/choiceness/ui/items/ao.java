package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.g;

/* compiled from: ChoicenessVipRenewalRemindItemView */
final class ao implements g {
    final /* synthetic */ ChoicenessVipRenewalRemindItemView a;

    ao(ChoicenessVipRenewalRemindItemView choicenessVipRenewalRemindItemView) {
        this.a = choicenessVipRenewalRemindItemView;
    }

    public final void onLogout() {
        LoginHelper.a().b(this);
        this.a.a.c();
    }
}
