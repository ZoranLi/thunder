package com.xunlei.downloadprovider.personal.playrecord;

import java.util.Comparator;

/* compiled from: PlayRecordActivity */
final class m implements Comparator<VideoPlayRecord> {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return new Long(((VideoPlayRecord) obj2).j).compareTo(new Long(((VideoPlayRecord) obj).j));
    }
}
