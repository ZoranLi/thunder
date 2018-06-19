package com.xunlei.downloadprovider.launch.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: LaunchPermissionsManager */
final class d implements OnClickListener {
    final /* synthetic */ String[] a;
    final /* synthetic */ a b;

    d(a aVar, String[] strArr) {
        this.b = aVar;
        this.a = strArr;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.b(this.b);
        a.a(this.b, this.a);
    }
}
