package com.xunlei.downloadprovider.personal.settings;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: SettingsIndexActivity */
final class ab implements OnClickListener {
    final /* synthetic */ Context a;
    final /* synthetic */ SettingsIndexActivity b;

    ab(SettingsIndexActivity settingsIndexActivity, Context context) {
        this.b = settingsIndexActivity;
        this.a = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.q != null) {
            this.b.q.dismiss();
            this.b.q = null;
        }
        if (d.a().e.a() != null) {
            LoginHelper.a().a(LoginPageType.LOGIN_PAGE, this.b, null, LoginFrom.FORCE_LOGIN, -1, null);
        }
        PrivateSpaceMgr.a().e();
        LoginHelper.a().a(0);
        SettingsIndexActivity.c();
        ((Activity) this.a).finish();
    }
}
