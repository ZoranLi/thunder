package com.xunlei.downloadprovider.d;

import com.xunlei.downloadprovider.d.b.o;
import java.util.Comparator;

/* compiled from: RedPointCloudConfigure */
public final class k implements Comparator<o> {
    final /* synthetic */ i a;

    public k(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return new Integer(((o) obj).A).compareTo(new Integer(((o) obj2).A));
    }
}
