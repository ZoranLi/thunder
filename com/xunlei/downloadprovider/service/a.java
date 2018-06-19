package com.xunlei.downloadprovider.service;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: DownloadService */
final class a implements ServiceConnection {
    public final void onServiceDisconnected(ComponentName componentName) {
    }

    a() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (!(iBinder == null || (iBinder instanceof DownloadService$a) == null)) {
            DownloadService.a(((DownloadService$a) iBinder).a.a);
            if (DownloadService.d().b() != null) {
                componentName = DownloadService.d().b();
                iBinder = new b(this);
                synchronized (componentName) {
                    componentName.d = iBinder;
                    if (componentName.f == null) {
                        componentName.f = new StaticHandler(Looper.getMainLooper(), componentName.e);
                    }
                    if (componentName.b == null) {
                        componentName.b = true;
                        componentName.a.a(componentName.f);
                        LoginHelper.a();
                        if (l.b() == null) {
                            n.a().a(new com.xunlei.downloadprovider.download.engine.task.n.a(0, null, null, false), false);
                        }
                    }
                }
            }
        }
    }
}
