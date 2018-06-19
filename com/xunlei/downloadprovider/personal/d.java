package com.xunlei.downloadprovider.personal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.homepage.q;
import com.xunlei.downloadprovider.member.b.b;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.f;

/* compiled from: UserCenterFragment */
final class d implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ UserCenterFragment b;

    d(UserCenterFragment userCenterFragment, String str) {
        this.b = userCenterFragment;
        this.a = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.b.o.dismiss();
        q.a("personal_center_tip", "renew", this.a, UserCenterFragment.d(this.b), f.a(PayFrom.PERSONAL_CENTER_RENEW_TIP));
        b.a(this.b.getActivity(), PayFrom.PERSONAL_CENTER_RENEW_TIP, "", this.a);
    }
}
