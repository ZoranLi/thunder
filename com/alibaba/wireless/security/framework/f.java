package com.alibaba.wireless.security.framework;

import android.app.Service;
import android.content.Context;
import android.content.ServiceConnection;

class f implements a {
    final /* synthetic */ Context a;
    final /* synthetic */ ServiceConnection b;
    final /* synthetic */ b c;

    f(b bVar, Context context, ServiceConnection serviceConnection) {
        this.c = bVar;
        this.a = context;
        this.b = serviceConnection;
    }

    public void a(int i, Class<? extends Service> cls) {
        if (i == 0) {
            this.a.unbindService(this.b);
        }
        this.c.i = i;
    }
}
