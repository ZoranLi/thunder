package com.xunlei.downloadprovidershare.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: SharePlatformsDialog */
final class e implements OnDismissListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.a.b != null) {
            this.a.b.a(this.a.f);
        }
    }
}
