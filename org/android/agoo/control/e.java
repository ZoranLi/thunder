package org.android.agoo.control;

/* compiled from: Taobao */
class e implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ AgooFactory c;

    e(AgooFactory agooFactory, String str, String str2) {
        this.c = agooFactory;
        this.a = str;
        this.b = str2;
    }

    public void run() {
        this.c.updateMsgStatus(this.a, this.b);
    }
}
