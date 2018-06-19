package com.xunlei.downloadprovider.ad.taskdetail;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.b.b;

/* compiled from: AbstractTaskDetailAdController */
public abstract class a {
    public static boolean a = false;
    protected final Context b;
    protected a c = null;
    protected boolean d = false;

    public abstract void a(com.xunlei.downloadprovider.ad.taskdetail.view.a aVar);

    public abstract void a(@NonNull com.xunlei.downloadprovider.ad.taskdetail.view.a aVar, @NonNull l lVar);

    public abstract void b(@NonNull com.xunlei.downloadprovider.ad.taskdetail.view.a aVar, @NonNull l lVar);

    public a(Context context) {
        this.b = context;
    }

    public final void a(a aVar) {
        this.c = aVar;
    }

    public final boolean a() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public static boolean b() {
        return (b.e() || !d.a().p.i() || a) ? false : true;
    }
}
