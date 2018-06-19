package com.xiaomi.metoknlp.geofencing;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.xiaomi.metoknlp.geofencing.c.a;

class b implements ServiceConnection {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        a.a(this.a, a.a(iBinder));
        if (a.e(this.a) != null) {
            a.e(this.a).sendEmptyMessage(3);
            a.e(this.a).sendEmptyMessageDelayed(2, 60000);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        a.a(this.a, null);
    }
}
