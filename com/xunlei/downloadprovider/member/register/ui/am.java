package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.personal.user.account.k;

/* compiled from: RegisterSuccessActivity */
final class am implements OnClickListener {
    final /* synthetic */ RegisterSuccessActivity a;

    am(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onClick(View view) {
        this.a.u.a("phone_register_login");
        k.a(HubbleEventBuilder.build("android_personal_account", "register_head_click"));
    }
}
