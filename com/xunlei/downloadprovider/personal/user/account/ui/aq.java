package com.xunlei.downloadprovider.personal.user.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.android.b;

/* compiled from: UserAccountSecurityActivity */
final class aq implements OnClickListener {
    final /* synthetic */ UserAccountSecurityActivity a;

    aq(UserAccountSecurityActivity userAccountSecurityActivity) {
        this.a = userAccountSecurityActivity;
    }

    public final void onClick(View view) {
        if (b.a(this.a)) {
            int id = view.getId();
            if (id != R.id.iv_wechat_toggle_btn) {
                if (id != R.id.iv_qq_toggle_btn) {
                    if (id == R.id.iv_weibo_toggle_btn) {
                        UserAccountSecurityActivity.a(this.a, view, 1, this.a.o);
                    }
                    return;
                } else if (ApkHelper.isApkPackageInstalled(this.a.getApplicationContext(), "com.tencent.mobileqq")) {
                    UserAccountSecurityActivity.a(this.a, view, 15, this.a.n);
                    return;
                } else {
                    XLToast.showToast(this.a, this.a.getString(R.string.user_account_security_qq_not_install));
                    return;
                }
            } else if (ApkHelper.isApkPackageInstalled(this.a.getApplicationContext(), "com.tencent.mm")) {
                UserAccountSecurityActivity.a(this.a, view, 21, this.a.m);
                return;
            } else {
                XLToast.showToast(this.a, this.a.getString(R.string.user_account_security_wechat_not_install));
                return;
            }
        }
        XLToast.showToast(this.a.getApplicationContext(), "无网络连接");
    }
}
