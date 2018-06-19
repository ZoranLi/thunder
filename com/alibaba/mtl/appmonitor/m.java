package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;

    m(String str, String str2, String str3, String str4, String str5) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a, this.b, this.c, this.d, this.e);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
