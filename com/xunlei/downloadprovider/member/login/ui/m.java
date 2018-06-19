package com.xunlei.downloadprovider.member.login.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.register.b;
import com.xunlei.downloadprovider.member.register.ui.MobileSetupActivity;

/* compiled from: LoginActivity */
final class m implements OnClickListener {
    final /* synthetic */ LoginActivity a;

    m(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void onClick(View view) {
        MobileSetupActivity.a(this.a, 1, LoginActivity.a(this.a));
        b.a("login_home");
    }
}
