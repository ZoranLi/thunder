package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao;
import java.util.Set;

/* compiled from: PlayRecordDataManager */
final class aa implements Runnable {
    final /* synthetic */ Set a;
    final /* synthetic */ v b;

    aa(v vVar, Set set) {
        this.b = vVar;
        this.a = set;
    }

    public final void run() {
        Iterable iterable = this.a;
        VideoPlayRecordDao b = af.b();
        if (b != null) {
            b.deleteByKeyInTx(iterable);
        }
    }
}
