package com.xunlei.downloadprovider.personal.user.account.ui;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.a;

/* compiled from: UserAccountSecurityActivity */
final class ap implements OnClickListener {
    final /* synthetic */ UserAccountSecurityActivity a;

    ap(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void onClick(View view) {
        a.a();
        a.a(this.a, String.format("https://jump.xunlei.com/jump/?jump_key=%s&u1=%s", new Object[]{this.a.l.a(115), Uri.encode("http://aq.xunlei.com/wap/forgetPwd.html")}), this.a.getString(R.string.user_account_modify_password), "");
    }
}
