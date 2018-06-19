package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.b;

/* compiled from: UserAccountSecurityActivity */
final class at implements OnClickListener {
    final /* synthetic */ UserAccountSecurityActivity a;

    at(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a) == null) {
            XLToast.showToast(this.a, "无网络连接");
        } else {
            XLToast.showToast(this.a, this.a.getString(R.string.user_account_security_cannot_unbind));
        }
    }
}
