package com.baidu.mobads.production;

import com.baidu.mobads.interfaces.error.XAdErrorCode;

class j implements Runnable {
    final /* synthetic */ b a;

    j(b bVar) {
        this.a = bVar;
    }

    public void run() {
        try {
            this.a.b();
            this.a.l();
            this.a.k();
            this.a.a(XAdErrorCode.REQUEST_TIMEOUT, "");
        } catch (Throwable e) {
            this.a.s.e(e);
        }
    }
}
