package com.xunlei.downloadprovider.launch.c.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RequiredPermissionDialog */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            this.a.g.onClick(this.a, -2);
        } else {
            this.a.dismiss();
        }
    }
}
