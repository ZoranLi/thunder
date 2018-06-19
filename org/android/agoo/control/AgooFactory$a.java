package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.taobao.accs.utl.ALog;
import org.android.agoo.service.SendMessage;
import org.android.agoo.service.SendMessage.Stub;

/* compiled from: Taobao */
class AgooFactory$a implements ServiceConnection {
    final /* synthetic */ AgooFactory a;
    private Intent b;
    private String c;
    private SendMessage d;
    private ServiceConnection e = this;

    public AgooFactory$a(AgooFactory agooFactory, String str, Intent intent) {
        this.a = agooFactory;
        this.c = str;
        this.b = intent;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        ALog.d("AgooFactory", "MessageConnection disConnected", new Object[0]);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder stringBuilder = new StringBuilder("MessageConnection conneted:");
        stringBuilder.append(componentName);
        ALog.d("AgooFactory", stringBuilder.toString(), new Object[0]);
        this.d = Stub.asInterface(iBinder);
        iBinder = new StringBuilder("onConnected current tid:");
        iBinder.append(Thread.currentThread().getId());
        ALog.d("AgooFactory", iBinder.toString(), new Object[0]);
        iBinder = new StringBuilder("MessageConnection sent:");
        iBinder.append(this.b);
        ALog.d("AgooFactory", iBinder.toString(), new Object[0]);
        if (this.d != null) {
            AgooFactory.access$500(this.a).execute(new f(this));
        }
    }
}
