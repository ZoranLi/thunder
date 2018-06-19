package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.member.register.b;

/* compiled from: MobileSetupActivity */
final class aa implements OnClickListener {
    final /* synthetic */ MobileSetupActivity a;

    aa(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onClick(View view) {
        if (this.a.m() != null) {
            this.a.b();
        }
        if (this.a.q == 2) {
            b.a(HubbleEventBuilder.build("android_phone_register", "phone_reg_passcode_get"));
            return;
        }
        if (this.a.q == 1) {
            b.a(HubbleEventBuilder.build("android_phone_register", "phone_login_passcode_get"));
        }
    }
}
