package com.xunlei.downloadprovider.search.ui.search;

import android.os.Handler;
import java.util.TimerTask;

/* compiled from: LoadingUIStatus */
public final class c extends TimerTask {
    final /* synthetic */ String a;
    final /* synthetic */ Handler b;
    final /* synthetic */ b c;

    public c(b bVar, String str, Handler handler) {
        this.c = bVar;
        this.a = str;
        this.b = handler;
    }

    public final void run() {
        String str = ab.a;
        new StringBuilder("loading end key: ").append(this.a);
        this.b.post(new d(this));
    }
}
