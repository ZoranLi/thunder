package com.xunlei.downloadprovider.personal.playrecord;

/* compiled from: PlayRecordDataManager */
final class x implements Runnable {
    final /* synthetic */ VideoPlayRecord a;
    final /* synthetic */ v b;

    x(v vVar, VideoPlayRecord videoPlayRecord) {
        this.b = vVar;
        this.a = videoPlayRecord;
    }

    public final void run() {
        af.a(this.a);
    }
}
