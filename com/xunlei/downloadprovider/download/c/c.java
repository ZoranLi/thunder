package com.xunlei.downloadprovider.download.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;

/* compiled from: DownloadFreeTrialHelper */
public final class c implements OnClickListener {
    final /* synthetic */ XLAlertDialog a;
    final /* synthetic */ OnClickListener b;
    final /* synthetic */ a c;

    public c(a aVar, XLAlertDialog xLAlertDialog, OnClickListener onClickListener) {
        this.c = aVar;
        this.a = xLAlertDialog;
        this.b = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            this.a.dismiss();
        }
        this.b.onClick(dialogInterface, i);
    }
}
