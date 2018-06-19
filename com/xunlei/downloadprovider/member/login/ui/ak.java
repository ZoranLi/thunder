package com.xunlei.downloadprovider.member.login.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;

/* compiled from: XLLoginOfflineDlgActivity */
final class ak implements OnCancelListener {
    final /* synthetic */ XLLoginOfflineDlgActivity a;

    ak(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        this.a = xLLoginOfflineDlgActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        XLLoginOfflineDlgActivity.a(this.a).a(LoginPageType.LOGIN_PAGE, this.a, null, LoginFrom.FORCE_LOGIN, -1, null);
    }
}
