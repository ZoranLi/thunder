package com.xunlei.downloadprovidershare;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;

/* compiled from: InternalShareHelper */
final class i implements OnClickListener {
    final /* synthetic */ XLAlertDialog a;
    final /* synthetic */ b b;

    i(b bVar, XLAlertDialog xLAlertDialog) {
        this.b = bVar;
        this.a = xLAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.dismiss();
    }
}
