package com.xunlei.downloadprovider.ad.c.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.ad.c.b.g.a;

/* compiled from: PermissionManager */
final class i implements OnClickListener {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.a.c();
    }
}
