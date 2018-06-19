package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.member.payment.bean.PayResultBean;
import com.xunlei.downloadprovider.member.payment.external.i;
import java.util.Observable;

/* compiled from: ChoicenessVipRenewalRemindItemView */
final class ap extends i {
    final /* synthetic */ ChoicenessVipRenewalRemindItemView a;

    ap(ChoicenessVipRenewalRemindItemView choicenessVipRenewalRemindItemView) {
        this.a = choicenessVipRenewalRemindItemView;
    }

    public final void update(Observable observable, Object obj) {
        if (((PayResultBean) obj).isSuccess() != null) {
            this.a.a.c();
        }
    }
}
