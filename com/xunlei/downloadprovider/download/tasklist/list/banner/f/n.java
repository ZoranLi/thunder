package com.xunlei.downloadprovider.download.tasklist.list.banner.f;

import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import java.util.Comparator;

/* compiled from: VoucherPacketHelper */
final class n implements Comparator<e> {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        e eVar = (e) obj;
        e eVar2 = (e) obj2;
        if (eVar != eVar2) {
            if (eVar == null) {
                return -1;
            }
            if (eVar2 == null) {
                return 1;
            }
            long j = eVar.i;
            obj = eVar2.i;
            if (j > obj) {
                return 1;
            }
            if (j < obj) {
                return -1;
            }
        }
        return null;
    }
}
