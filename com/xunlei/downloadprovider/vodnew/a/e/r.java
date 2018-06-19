package com.xunlei.downloadprovider.vodnew.a.e;

import java.io.FileDescriptor;

/* compiled from: XLMediaPlayer */
final class r implements Runnable {
    final /* synthetic */ FileDescriptor a;
    final /* synthetic */ o b;

    r(o oVar, FileDescriptor fileDescriptor) {
        this.b = oVar;
        this.a = fileDescriptor;
    }

    public final void run() {
        this.b.a.a(this.a);
    }
}
