package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.b;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: ChoicenessVipRenewalRemindItemView */
final class aq implements OnClickListener {
    final /* synthetic */ ChoicenessVipRenewalRemindItemView a;

    aq(ChoicenessVipRenewalRemindItemView choicenessVipRenewalRemindItemView) {
        this.a = choicenessVipRenewalRemindItemView;
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view == R.id.item_delete_icon) {
            q.a("home_collect", "close", this.a.getBubbleid(), this.a.b.g().a, this.a.f);
            ChoicenessVipRenewalRemindItemView.e(this.a);
            this.a.a.c();
        } else if (view == R.id.item_btn_renew) {
            q.a("home_collect", "renew", this.a.getBubbleid(), this.a.b.g().a, this.a.f);
            b.a(this.a.d, PayFrom.HOME_CHOICE_RENEW, this.a.f, this.a.getBubbleid());
        }
    }
}
