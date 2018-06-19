package com.xunlei.downloadprovider.member.login.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* compiled from: XLLoginOfflineDlgActivity */
final class ao implements OnCancelListener {
    final /* synthetic */ XLLoginOfflineDlgActivity a;

    ao(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        this.a = xLLoginOfflineDlgActivity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        XLLoginOfflineDlgActivity.b(this.a);
    }
}
