package com.xunlei.downloadprovider.personal.lixianspace.b;

import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;

/* compiled from: LXSpaceDataHelper */
final class e implements Runnable {
    final /* synthetic */ LXTaskInfo a;
    final /* synthetic */ int b;
    final /* synthetic */ String c;
    final /* synthetic */ c d;

    e(c cVar, LXTaskInfo lXTaskInfo, int i, String str) {
        this.d = cVar;
        this.a = lXTaskInfo;
        this.b = i;
        this.c = str;
    }

    public final void run() {
        for (a a : this.d.b) {
            a.a(this.a, this.b, this.c);
        }
    }
}
