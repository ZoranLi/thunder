package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import anet.channel.util.ALog;
import anetwork.channel.aidl.d.a;

/* compiled from: Taobao */
public class NetworkService extends Service {
    a a = new f(this);
    private Context b;
    private n.a[] c = new n.a[2];

    public void onDestroy() {
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }

    public IBinder onBind(Intent intent) {
        this.b = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            StringBuilder stringBuilder = new StringBuilder("onBind:");
            stringBuilder.append(intent.getAction());
            ALog.i("anet.NetworkService", stringBuilder.toString(), null, new Object[0]);
        }
        if (d.class.getName().equals(intent.getAction()) != null) {
            return this.a;
        }
        return null;
    }
}
