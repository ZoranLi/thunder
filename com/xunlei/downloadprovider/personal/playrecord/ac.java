package com.xunlei.downloadprovider.personal.playrecord;

/* compiled from: PlayRecordDataManager */
final class ac implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ v c;

    ac(v vVar, String str, String str2) {
        this.c = vVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        VideoPlayRecord a = af.a(v.b(this.a));
        if (a != null) {
            a.e = this.b;
            af.a(a);
        }
    }
}
