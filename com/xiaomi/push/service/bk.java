package com.xiaomi.push.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.channel.commonutils.logger.b;

class bk implements ServiceConnection {
    final /* synthetic */ XMPushService a;

    bk(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder stringBuilder = new StringBuilder("onServiceConnected ");
        stringBuilder.append(iBinder);
        b.b(stringBuilder.toString());
        Service a = XMJobService.a();
        if (a != null) {
            this.a.startForeground(XMPushService.i, XMPushService.a(this.a));
            a.startForeground(XMPushService.i, XMPushService.a(this.a));
            a.stopForeground(true);
            this.a.unbindService(this);
            return;
        }
        stringBuilder = new StringBuilder("XMService connected but innerService is null ");
        stringBuilder.append(iBinder);
        b.a(stringBuilder.toString());
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }
}
