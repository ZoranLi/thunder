package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class l implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    l(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a, this.b, this.c);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
