package com.xunlei.downloadprovider.launch.c;

/* compiled from: LaunchPermissionsManager */
final class b implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ a b;

    b(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    public final void run() {
        if (a.a(this.b, this.a) == 0 && a.a(this.b) != null) {
            a.a(this.b).a();
        }
    }
}
