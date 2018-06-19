package com.xunlei.downloadprovider.launch.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.h.l;

/* compiled from: LaunchPermissionsManager */
final class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        a.b(this.a);
        a.c(this.a);
        l.a(this.a.b);
    }
}
