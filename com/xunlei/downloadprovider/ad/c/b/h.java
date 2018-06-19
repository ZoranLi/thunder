package com.xunlei.downloadprovider.ad.c.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: PermissionManager */
final class h implements OnClickListener {
    final /* synthetic */ Object a;
    final /* synthetic */ String[] b;

    h(Object obj, String[] strArr) {
        this.a = obj;
        this.b = strArr;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        g.a(this.a, this.b);
    }
}
