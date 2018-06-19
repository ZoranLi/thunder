package com.xunlei.downloadprovider.download.giftdispatch.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: GetGiftAlertDialog */
final class e implements OnClickListener {
    final /* synthetic */ GetGiftAlertDialog a;

    e(GetGiftAlertDialog getGiftAlertDialog) {
        this.a = getGiftAlertDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.a != 0) {
            this.a.a.b();
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
