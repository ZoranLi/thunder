package com.taobao.accs.internal;

import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
class g implements Runnable {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public void run() {
        ALog.e("ElectionServiceImpl", "serverElection time out", new Object[0]);
        this.a.a(null, -9);
    }
}
