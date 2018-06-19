package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.database.greendao.VideoPlayRecordDao;
import java.util.Collections;
import java.util.List;

/* compiled from: PlayRecordDataManager */
final class ab implements Runnable {
    final /* synthetic */ v$c a;
    final /* synthetic */ v b;

    ab(v vVar, v$c com_xunlei_downloadprovider_personal_playrecord_v_c) {
        this.b = vVar;
        this.a = com_xunlei_downloadprovider_personal_playrecord_v_c;
    }

    public final void run() {
        List emptyList;
        VideoPlayRecordDao b = af.b();
        if (b == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = b.loadAll();
        }
        if (this.a != null) {
            this.a.a(emptyList);
        }
    }
}
