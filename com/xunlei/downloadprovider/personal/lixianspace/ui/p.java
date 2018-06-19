package com.xunlei.downloadprovider.personal.lixianspace.ui;

import com.xunlei.downloadprovider.personal.lixianspace.b.l;
import com.xunlei.downloadprovider.personal.lixianspace.d.h.a;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class p implements Runnable {
    final /* synthetic */ LXSpaceCreateTaskByMagnetUrlActivity a;

    p(LXSpaceCreateTaskByMagnetUrlActivity lXSpaceCreateTaskByMagnetUrlActivity) {
        this.a = lXSpaceCreateTaskByMagnetUrlActivity;
    }

    public final void run() {
        List arrayList = new ArrayList();
        for (int i = 0; i < this.a.e.getAdapter().getCount(); i++) {
            c cVar = (c) this.a.i.get(i);
            if (this.a.j.contains(cVar)) {
                arrayList.add(Long.valueOf((long) cVar.mFileIndex));
            }
        }
        long[] jArr = new long[arrayList.size()];
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            jArr[i2] = ((Long) arrayList.get(i2)).longValue();
        }
        a aVar = new a(l.a(this.a.c));
        aVar.b = this.a.a();
        aVar.c = jArr;
        l.a("lx_tag:default", aVar);
    }
}
