package com.xunlei.downloadprovider.personal.playrecord;

import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE;
import com.xunlei.downloadprovider.plugin.videoplayervod.VodPlayerParams;

/* compiled from: PlayRecordDataManager */
final class y implements Runnable {
    final /* synthetic */ VodPlayerParams a;
    final /* synthetic */ VideoPlayRecord b;
    final /* synthetic */ boolean c = true;
    final /* synthetic */ v d;

    y(v vVar, VodPlayerParams vodPlayerParams, VideoPlayRecord videoPlayRecord) {
        this.d = vVar;
        this.a = vodPlayerParams;
        this.b = videoPlayRecord;
    }

    public final void run() {
        String b = v.b(this.a.mUrl);
        VideoPlayRecord videoPlayRecord = this.b;
        if (videoPlayRecord == null) {
            videoPlayRecord = af.a(b);
        }
        if (videoPlayRecord == null) {
            videoPlayRecord = new VideoPlayRecord();
        } else {
            synchronized (v.a(this.d)) {
                v.a(this.d).put(b, videoPlayRecord);
            }
        }
        String str = this.a.mTitle;
        if (str != null) {
            int lastIndexOf = str.lastIndexOf("/");
            if (lastIndexOf > 0) {
                str = str.substring(lastIndexOf + 1, str.length()).toLowerCase();
            }
        } else {
            str = null;
        }
        videoPlayRecord.d = str;
        videoPlayRecord.j = System.currentTimeMillis();
        videoPlayRecord.e = b;
        videoPlayRecord.f = this.a.mCoverUrl;
        videoPlayRecord.m = this.a.mCID;
        videoPlayRecord.n = this.a.mGCID;
        videoPlayRecord.k = this.a.mFileSize;
        videoPlayRecord.h = (long) this.a.mCurPlayPos;
        videoPlayRecord.i = (long) this.a.mMaxPlayPos;
        videoPlayRecord.g = (long) this.a.mDuration;
        videoPlayRecord.l = this.a.mUrl;
        if (this.c) {
            videoPlayRecord.o = this.a.mMovieId;
            videoPlayRecord.a(RECORD_TYPE.TAG_SHORT_VIDEO);
        } else {
            videoPlayRecord.a(RECORD_TYPE.TAG_LONG_VIDEO);
        }
        af.a(videoPlayRecord);
        synchronized (v.a(this.d)) {
            v.a(this.d).put(b, videoPlayRecord);
        }
    }
}
