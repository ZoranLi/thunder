package com.xunlei.downloadprovidershare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.androidutil.ClipboardUtil;
import com.xunlei.common.commonview.dialog.XLAlertDialog;

/* compiled from: InternalShareHelper */
final class h implements OnClickListener {
    final /* synthetic */ XLAlertDialog a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    h(b bVar, XLAlertDialog xLAlertDialog, Context context, String str) {
        this.d = bVar;
        this.a = xLAlertDialog;
        this.b = context;
        this.c = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.a.dismiss();
        ClipboardUtil.copyToClipboardWithToast(this.b, this.c);
    }
}
