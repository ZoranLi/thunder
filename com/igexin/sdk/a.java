package com.igexin.sdk;

import android.app.Service;
import com.igexin.push.util.d;

class a implements d {
    final /* synthetic */ Service a;
    final /* synthetic */ GTServiceManager b;

    a(GTServiceManager gTServiceManager, Service service) {
        this.b = gTServiceManager;
        this.a = service;
    }

    public void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(GTServiceManager.TAG);
        stringBuilder.append("|load so error, report bi result = ");
        stringBuilder.append(z);
        stringBuilder.append(" ###########");
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        this.a.stopSelf();
    }
}
