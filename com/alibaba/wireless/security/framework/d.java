package com.alibaba.wireless.security.framework;

import android.app.Service;
import android.content.Context;

class d implements a {
    final /* synthetic */ a a;
    final /* synthetic */ Context b;
    final /* synthetic */ b c;

    d(b bVar, a aVar, Context context) {
        this.c = bVar;
        this.a = aVar;
        this.b = context;
    }

    public void a(int i, Class<? extends Service> cls) {
        if (i == 0) {
            this.a.setClass(this.b, cls);
            this.b.stopService(this.a);
        }
        this.c.i = i;
    }
}
