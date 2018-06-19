package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: CooperationDialogActivity */
final class d implements OnDismissListener {
    final /* synthetic */ CooperationDialogActivity a;

    d(CooperationDialogActivity cooperationDialogActivity) {
        this.a = cooperationDialogActivity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.finish();
    }
}
