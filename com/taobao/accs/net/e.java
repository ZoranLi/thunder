package com.taobao.accs.net;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class e implements Runnable {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (this.a.e.c()) {
            String d = this.a.d();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.c);
            stringBuilder.append("receive ping time out! ");
            ALog.e(d, stringBuilder.toString(), new Object[0]);
            g.a(this.a.d).c();
            this.a.a("", "receive ping timeout");
            this.a.e.a(-12);
        }
    }
}
