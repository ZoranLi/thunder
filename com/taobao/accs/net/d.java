package com.taobao.accs.net;

import com.taobao.accs.data.Message;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    d(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    public void run() {
        Message b = this.b.e.b(this.a);
        if (b != null) {
            this.b.e.a(b, -9);
            this.b.a(this.a, "receive data time out");
            String d = this.b.d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b.c);
            stringBuilder.append("receive data time out! ");
            ALog.e(d, stringBuilder.toString(), new Object[0]);
        }
    }
}
