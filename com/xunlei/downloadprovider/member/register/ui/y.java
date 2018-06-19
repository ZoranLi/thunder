package com.xunlei.downloadprovider.member.register.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.member.register.b;

/* compiled from: MobileSetupActivity */
final class y implements OnClickListener {
    final /* synthetic */ MobileSetupActivity a;

    y(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        MobileSetupActivity.a(this.a, 1, "phone_register", this.a.r);
        b.a("register_altert");
        dialogInterface.dismiss();
    }
}
