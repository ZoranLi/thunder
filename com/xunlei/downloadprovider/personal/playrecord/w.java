package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.common.concurrent.XLThreadPool$ForDatabase;
import com.xunlei.downloadprovider.plugin.videoplayervod.VodPlayerParams;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PlayRecordDataManager */
public final class w implements Runnable {
    final /* synthetic */ VodPlayerParams a;
    final /* synthetic */ v b;

    public w(v vVar, VodPlayerParams vodPlayerParams) {
        this.b = vVar;
        this.a = vodPlayerParams;
    }

    public final void run() {
        VideoPlayRecord b = af.b(this.a.mMovieId);
        if (!(b == null || b.e.equals(this.a.mUrl))) {
            Set hashSet = new HashSet();
            hashSet.add(b.b);
            this.b.a(hashSet);
        }
        v vVar = this.b;
        VodPlayerParams vodPlayerParams = this.a;
        if (vodPlayerParams != null) {
            VideoPlayRecord videoPlayRecord = (VideoPlayRecord) vVar.a.get(v.a(vodPlayerParams.mUrl));
            if (videoPlayRecord != null) {
                videoPlayRecord.h = (long) vodPlayerParams.mCurPlayPos;
                videoPlayRecord.i = (long) vodPlayerParams.mMaxPlayPos;
                videoPlayRecord.g = (long) vodPlayerParams.mDuration;
            }
            XLThreadPool$ForDatabase.executeWrite(new y(vVar, vodPlayerParams, videoPlayRecord));
        }
    }
}
