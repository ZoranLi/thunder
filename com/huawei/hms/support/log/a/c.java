package com.huawei.hms.support.log.a;

import com.huawei.hms.support.log.a.a.a;

/* compiled from: FileLogNode */
class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ a e;

    c(a aVar, String str, int i, String str2, String str3) {
        this.e = aVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = str3;
    }

    public void run() {
        this.e.a.a(this.a, this.b, this.c, this.d);
    }
}
