package com.taobao.accs.net;

/* compiled from: Taobao */
class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ r b;

    t(r rVar, String str) {
        this.b = rVar;
        this.a = str;
    }

    public void run() {
        if (this.a != null && this.a.equals(this.b.N) && this.b.s == 2) {
            this.b.J = false;
            this.b.L = true;
            this.b.l();
            this.b.H.setCloseReason("conn timeout");
        }
    }
}
