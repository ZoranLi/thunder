package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: CooperationDialogActivity */
final class a implements OnDismissListener {
    final /* synthetic */ CooperationDialogActivity a;

    a(CooperationDialogActivity cooperationDialogActivity) {
        this.a = cooperationDialogActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        CooperationDialogActivity.f = null;
        this.a.finish();
    }
}
