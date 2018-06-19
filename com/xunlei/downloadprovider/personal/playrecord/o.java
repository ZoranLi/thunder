package com.xunlei.downloadprovider.personal.playrecord;

import java.util.Comparator;

/* compiled from: PlayRecordActivity */
final class o implements Comparator<VideoPlayRecord> {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return new Long(((VideoPlayRecord) obj2).j).compareTo(new Long(((VideoPlayRecord) obj).j));
    }
}
