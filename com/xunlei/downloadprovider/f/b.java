package com.xunlei.downloadprovider.f;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.xunlei.downloadprovidershare.l;

/* compiled from: ShareHelper */
public final class b implements OnDismissListener {
    final /* synthetic */ l a;
    final /* synthetic */ a b;

    public b(a aVar, l lVar) {
        this.b = aVar;
        this.a = lVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
        if (this.a != null) {
            this.a.a();
        }
    }
}
