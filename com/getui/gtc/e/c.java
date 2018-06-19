package com.getui.gtc.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.getui.gtc.e.a.b;

final class c implements ServiceConnection {
    final /* synthetic */ b a;
    final /* synthetic */ Context b;

    c(b bVar, Context context) {
        this.a = bVar;
        this.b = context;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.getui.gtc.e.a.c cVar;
        try {
            a aVar = new a(iBinder);
            cVar = new com.getui.gtc.e.a.c(aVar.a(), aVar.b());
        } catch (Exception e) {
            new String[1][0] = e.toString();
            cVar = null;
        }
        if (cVar != null) {
            try {
                this.a.a(cVar);
            } catch (Exception e2) {
                new String[1][0] = e2.toString();
            }
        }
        try {
            this.b.unbindService(this);
        } catch (Exception e22) {
            new String[1][0] = e22.toString();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
