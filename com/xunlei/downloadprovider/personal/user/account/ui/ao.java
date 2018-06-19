package com.xunlei.downloadprovider.personal.user.account.ui;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.a;

/* compiled from: UserAccountSecurityActivity */
final class ao implements OnClickListener {
    final /* synthetic */ UserAccountSecurityActivity a;

    ao(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void onClick(View view) {
        a.a();
        a.a(this.a, String.format("https://jump.xunlei.com/jump/?jump_key=%s&u1=%s", new Object[]{this.a.l.a(115), Uri.encode("http://aq.xunlei.com/wap/account_check.html")}), "绑定手机号", "");
    }
}
