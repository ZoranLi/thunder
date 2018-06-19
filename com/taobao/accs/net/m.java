package com.taobao.accs.net;

import android.support.v4.app.NotificationCompat;
import anet.channel.session.TnetSpdySession;
import com.taobao.accs.ut.statistics.d;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
class m implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ byte[] b;
    final /* synthetic */ TnetSpdySession c;
    final /* synthetic */ k d;

    m(k kVar, int i, byte[] bArr, TnetSpdySession tnetSpdySession) {
        this.d = kVar;
        this.a = i;
        this.b = bArr;
        this.c = tnetSpdySession;
    }

    public void run() {
        if (this.a == 200) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.d.e.a(this.b, this.c.getHost());
                d f = this.d.e.f();
                if (f != null) {
                    f.c = String.valueOf(currentTimeMillis);
                    f.g = this.d.c == 0 ? NotificationCompat.CATEGORY_SERVICE : "inapp";
                    f.commitUT();
                }
            } catch (Throwable th) {
                ALog.e(this.d.d(), "onDataReceive ", th, new Object[0]);
                th.printStackTrace();
                UTMini.getInstance().commitEvent(66001, "DATA_RECEIVE", UtilityImpl.getStackMsg(th));
            }
            ALog.d(this.d.d(), "try handle msg", new Object[0]);
            return;
        }
        String d = this.d.d();
        StringBuilder stringBuilder = new StringBuilder("drop frame len:");
        stringBuilder.append(this.b.length);
        stringBuilder.append(" frameType");
        stringBuilder.append(this.a);
        ALog.e(d, stringBuilder.toString(), new Object[0]);
    }
}
