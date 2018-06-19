package com.xunlei.downloadprovider.member.login.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: XLLoginOfflineDlgActivity */
final class al implements OnClickListener {
    final /* synthetic */ XLLoginOfflineDlgActivity a;

    al(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        this.a = xLLoginOfflineDlgActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (XLLoginOfflineDlgActivity.b() != null) {
            XLLoginOfflineDlgActivity.a(this.a).a(this.a, null, LoginFrom.FORCE_LOGIN, null);
        } else {
            XLLoginOfflineDlgActivity.a(this.a).a(this.a, null, LoginFrom.TWO_BUTTON_DIALOG, null);
            this.a.finish();
        }
        XLLoginOfflineDlgActivity.a("1");
    }
}
