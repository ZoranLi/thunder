package com.umeng.message;

import java.io.File;

final class UmengDownloadResourceService$1 implements Runnable {
    final /* synthetic */ File a;
    final /* synthetic */ long b;

    UmengDownloadResourceService$1(File file, long j) {
        this.a = file;
        this.b = j;
    }

    public final void run() {
        UmengDownloadResourceService.a(this.a, this.b);
        UmengDownloadResourceService.a(null);
    }
}
