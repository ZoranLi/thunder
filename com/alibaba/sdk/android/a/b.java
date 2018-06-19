package com.alibaba.sdk.android.a;

final class b implements Runnable {
    final /* synthetic */ d a;

    b(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        if (a.c) {
            a.e.c("Unable to execute remain task in queue, return.");
            return;
        }
        g b = a.e;
        StringBuilder stringBuilder = new StringBuilder("Get [");
        stringBuilder.append(this.a.toString());
        stringBuilder.append("] from report queue.");
        b.b(stringBuilder.toString());
        a.b(this.a);
    }
}
