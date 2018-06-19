package com.xunlei.downloadprovider.vodnew.a.e;

import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v.b;
import com.xunlei.downloadprovider.vodnew.a.a.a;

/* compiled from: PlayerStateInitialized */
final class i implements b {
    final /* synthetic */ a a;
    final /* synthetic */ h b;

    i(h hVar, a aVar) {
        this.b = hVar;
        this.a = aVar;
    }

    public final void a(VideoPlayRecord videoPlayRecord) {
        String str = a.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e.c);
        stringBuilder.append("onGetPlayRecordInfo回调 : ");
        stringBuilder.append(videoPlayRecord);
        if (videoPlayRecord != null) {
            this.b.a.b.d = videoPlayRecord;
            str = a.a;
            new StringBuilder("播放记录 positon : ").append(videoPlayRecord.h);
        }
        this.b.a.b.a.a(this.b.a.d);
        videoPlayRecord = a.a;
        videoPlayRecord = new StringBuilder();
        videoPlayRecord.append(e.c);
        videoPlayRecord.append("开始open， 后面一定要有OnOpenComplete回调");
        if (this.a.k() != null) {
            this.b.a.b.a(this.a.k());
        } else {
            this.b.a.b.b(this.a.d());
        }
    }
}
