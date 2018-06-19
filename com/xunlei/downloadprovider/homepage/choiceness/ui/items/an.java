package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.b;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: ChoicenessVipRenewalRemindItemView */
final class an implements OnClickListener {
    final /* synthetic */ ChoicenessVipRenewalRemindItemView a;

    an(ChoicenessVipRenewalRemindItemView choicenessVipRenewalRemindItemView) {
        this.a = choicenessVipRenewalRemindItemView;
    }

    public final void onClick(View view) {
        q.a("home_collect", "bar", this.a.getBubbleid(), this.a.b.g().a, this.a.f);
        b.a(this.a.d, PayFrom.HOME_CHOICE_RENEW, this.a.f, this.a.getBubbleid());
    }
}
