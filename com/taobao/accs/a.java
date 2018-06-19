package com.taobao.accs;

import android.app.Notification.Builder;
import com.taobao.accs.ChannelService.KernelService;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class a implements Runnable {
    final /* synthetic */ KernelService a;

    a(KernelService kernelService) {
        this.a = kernelService;
    }

    public void run() {
        try {
            ChannelService instance = ChannelService.getInstance();
            int i = this.a.b.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).applicationInfo.icon;
            if (i != 0) {
                Builder builder = new Builder(this.a.b);
                builder.setSmallIcon(i);
                instance.startForeground(9371, builder.build());
                Builder builder2 = new Builder(this.a.b);
                builder2.setSmallIcon(i);
                KernelService.a.startForeground(9371, builder2.build());
                KernelService.a.stopForeground(true);
            }
            KernelService.a.stopSelf();
        } catch (Throwable th) {
            ALog.e("ChannelService", " onStartCommand run", th, new Object[0]);
        }
    }
}
