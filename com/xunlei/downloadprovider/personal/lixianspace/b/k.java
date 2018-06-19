package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;

/* compiled from: LXSpaceDataHelper */
final class k implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ LXTaskInfo d;
    final /* synthetic */ c e;

    k(c cVar, String str, int i, String str2, LXTaskInfo lXTaskInfo) {
        this.e = cVar;
        this.a = str;
        this.b = i;
        this.c = str2;
        this.d = lXTaskInfo;
    }

    public final void run() {
        for (a a : this.e.b) {
            a.a(this.a, this.b, this.d);
        }
    }
}
