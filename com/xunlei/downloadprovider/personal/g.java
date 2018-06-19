package com.xunlei.downloadprovider.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.payment.external.PayAction;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.member.payment.f;

/* compiled from: UserCenterFragment */
final class g implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ UserCenterFragment b;

    g(UserCenterFragment userCenterFragment, String str) {
        this.b = userCenterFragment;
        this.a = str;
    }

    public final void onClick(View view) {
        this.b.q.dismiss();
        q.a("personal_center_tip", "renew", this.a, UserCenterFragment.d(this.b), f.a(PayFrom.PERSONAL_CENTER_RENEW_TIP));
        view = this.b.getActivity();
        PayFrom payFrom = PayFrom.PERSONAL_CENTER_RENEW_TIP;
        String str = this.a;
        PayEntryParam payEntryParam = new PayEntryParam(payFrom);
        payEntryParam.d = str;
        payEntryParam.e = new PayAction(PayUtil$OrderType.OPEN);
        PaymentEntryActivity.a(view, payEntryParam.a(""));
    }
}
