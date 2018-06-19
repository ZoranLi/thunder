package com.xunlei.downloadprovidershare;

import android.app.Activity;
import com.xunlei.downloadprovidershare.a.a;
import com.xunlei.downloadprovidershare.a.f;

/* compiled from: InternalShareHelper */
public final class b implements a {
    final /* synthetic */ Activity a;
    final /* synthetic */ ShareOperationType b;
    final /* synthetic */ b c;

    public b(b bVar, Activity activity, ShareOperationType shareOperationType) {
        this.c = bVar;
        this.a = activity;
        this.b = shareOperationType;
    }

    public final void a(boolean z, f fVar) {
        b.a(this.c, new c(this, z, fVar));
    }
}
