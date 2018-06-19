package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class n implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ double d;

    n(String str, String str2, String str3, double d) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = d;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a, this.b, this.c, this.d);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
