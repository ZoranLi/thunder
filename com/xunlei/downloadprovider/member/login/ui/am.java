package com.xunlei.downloadprovider.member.login.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: XLLoginOfflineDlgActivity */
final class am implements OnClickListener {
    final /* synthetic */ XLLoginOfflineDlgActivity a;

    am(XLLoginOfflineDlgActivity xLLoginOfflineDlgActivity) {
        this.a = xLLoginOfflineDlgActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        XLLoginOfflineDlgActivity.a(this.a).a(1);
        this.a.finish();
        XLLoginOfflineDlgActivity.a("2");
    }
}
