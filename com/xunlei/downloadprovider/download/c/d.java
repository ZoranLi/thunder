package com.xunlei.downloadprovider.download.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.dialog.XLAlertDialog;

/* compiled from: DownloadFreeTrialHelper */
public final class d implements OnClickListener {
    final /* synthetic */ XLAlertDialog a;
    final /* synthetic */ a b;

    public d(a aVar, XLAlertDialog xLAlertDialog) {
        this.b = aVar;
        this.a = xLAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a != null) {
            this.a.dismiss();
        }
    }
}
