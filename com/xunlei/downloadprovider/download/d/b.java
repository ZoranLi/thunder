package com.xunlei.downloadprovider.download.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.xllib.b.d;

/* compiled from: AppSelectAdapter */
final class b implements OnClickListener {
    final /* synthetic */ com.xunlei.downloadprovider.download.d.a.b a;
    final /* synthetic */ a b;

    b(a aVar, com.xunlei.downloadprovider.download.d.a.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final void onClick(View view) {
        this.b.a.a(d.a(this.b.c) ? null : (f) this.b.c.get(this.a.getLayoutPosition()));
    }
}
