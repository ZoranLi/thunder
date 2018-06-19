package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.cooperation.a.a;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;

/* compiled from: CooperationDialogActivity */
final class b implements OnClickListener {
    final /* synthetic */ CooperationItem a;
    final /* synthetic */ CooperationDialogActivity b;

    b(CooperationDialogActivity cooperationDialogActivity, CooperationItem cooperationItem) {
        this.b = cooperationDialogActivity;
        this.a = cooperationItem;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            this.b.b = null;
        }
        a.a(this.a.getDisplayLocationName(), this.a.getAppPackageName(), "0");
    }
}
