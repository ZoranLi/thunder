package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.Comparator;

/* compiled from: TaskDataSource */
final class c implements Comparator<e> {
    c() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        e eVar = (e) obj;
        e eVar2 = (e) obj2;
        if (eVar == eVar2) {
            return null;
        }
        if (eVar.b() == null) {
            return 1;
        }
        if (eVar2.b() == null) {
            return -1;
        }
        return b.a(eVar.b(), eVar2.b());
    }
}
