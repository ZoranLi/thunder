package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.database.greendao.BTSubTaskVisitRecordDao;

/* compiled from: PlayRecordDataManager */
final class ad implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ v b;

    ad(v vVar, a aVar) {
        this.b = vVar;
        this.a = aVar;
    }

    public final void run() {
        a aVar = this.a;
        BTSubTaskVisitRecordDao c = af.c();
        if (c != null) {
            c.insertOrReplace(aVar);
        }
    }
}
