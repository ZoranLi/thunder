package com.xunlei.downloadprovider.download.taskdetails.subtask;

/* compiled from: BTSubTaskViewModel */
final class i implements Runnable {
    final /* synthetic */ BTSubTaskItem a;
    final /* synthetic */ g b;

    i(g gVar, BTSubTaskItem bTSubTaskItem) {
        this.b = gVar;
        this.a = bTSubTaskItem;
    }

    public final void run() {
        if (this.b.b(this.a)) {
            this.b.a(this.b.c);
        }
    }
}
