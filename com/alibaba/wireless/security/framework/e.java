package com.alibaba.wireless.security.framework;

import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;

class e implements a {
    final /* synthetic */ a a;
    final /* synthetic */ Context b;
    final /* synthetic */ ServiceConnection c;
    final /* synthetic */ int d;
    final /* synthetic */ b e;

    e(b bVar, a aVar, Context context, ServiceConnection serviceConnection, int i) {
        this.e = bVar;
        this.a = aVar;
        this.b = context;
        this.c = serviceConnection;
        this.d = i;
    }

    public void a(int i, Class<? extends Service> cls) {
        if (i == 0) {
            this.a.setClass(this.b, cls);
            this.b.bindService(this.a, this.c, this.d);
        }
        this.e.i = i;
    }
}
