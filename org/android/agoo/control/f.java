package org.android.agoo.control;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class f implements Runnable {
    final /* synthetic */ AgooFactory$a a;

    f(AgooFactory$a agooFactory$a) {
        this.a = agooFactory$a;
    }

    public void run() {
        try {
            StringBuilder stringBuilder = new StringBuilder("onConnected running tid:");
            stringBuilder.append(Thread.currentThread().getId());
            ALog.d("AgooFactory", stringBuilder.toString(), new Object[0]);
            this.a.d.doSend(this.a.b);
        } catch (Throwable e) {
            ALog.e("AgooFactory", "send error", e, new Object[0]);
        } catch (Throwable th) {
            ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
            this.a.d = null;
            AgooFactory.access$000().unbindService(this.a.e);
        }
        ALog.d("AgooFactory", "send finish. close this connection", new Object[0]);
        this.a.d = null;
        AgooFactory.access$000().unbindService(this.a.e);
    }
}
