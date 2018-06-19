package com.huawei.hms.update.a;

import java.io.File;

/* compiled from: ThreadWrapper */
class n implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ File d;
    final /* synthetic */ l e;

    n(l lVar, int i, int i2, int i3, File file) {
        this.e = lVar;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = file;
    }

    public void run() {
        this.e.a.a(this.a, this.b, this.c, this.d);
    }
}
