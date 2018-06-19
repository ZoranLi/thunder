package com.xunlei.downloadprovider.personal;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.b;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: UserCenterFragment */
final class f implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ UserCenterFragment b;

    f(UserCenterFragment userCenterFragment, String str) {
        this.b = userCenterFragment;
        this.a = str;
    }

    public final void onClick(View view) {
        this.b.q.dismiss();
        q.a("personal_center_tip", "renew", this.a, UserCenterFragment.d(this.b), com.xunlei.downloadprovider.member.payment.f.a(PayFrom.PERSONAL_CENTER_RENEW_TIP));
        b.a(this.b.getActivity(), PayFrom.PERSONAL_CENTER_RENEW_TIP, "", this.a);
    }
}
