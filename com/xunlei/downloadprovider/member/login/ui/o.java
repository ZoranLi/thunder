package com.xunlei.downloadprovider.member.login.ui;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.member.register.b;

/* compiled from: LoginActivity */
final class o implements OnClickListener {
    final /* synthetic */ Dialog a;
    final /* synthetic */ LoginActivity b;

    o(LoginActivity loginActivity, Dialog dialog) {
        this.b = loginActivity;
        this.a = dialog;
    }

    public final void onClick(View view) {
        LoginActivity.B(this.b);
        this.a.dismiss();
        b.a(HubbleEventBuilder.build("android_phone_register", "phone_register"));
    }
}
