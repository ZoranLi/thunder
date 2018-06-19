package com.xunlei.downloadprovider.cooperation.ui;

import android.app.Activity;
import android.content.Context;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.plugin.q;

/* compiled from: CooperationController */
public final class g implements Runnable {
    final /* synthetic */ b a;

    public g(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        Context c = AppStatusChgObserver.b().c();
        if (q.a((Activity) c) && !c.isFinishing()) {
            this.a.a(c, 1002);
        }
    }
}
