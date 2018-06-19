package com.xunlei.downloadprovider.personal.playrecord;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE;
import com.xunlei.xllib.b.d;
import java.util.Collections;
import java.util.List;

/* compiled from: PlayRecordActivity */
final class l implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ k b;

    l(k kVar, List list) {
        this.b = kVar;
        this.a = list;
    }

    public final void run() {
        if (!d.a(this.a)) {
            for (VideoPlayRecord videoPlayRecord : this.a) {
                PlayRecordActivity.a;
                StringBuilder stringBuilder = new StringBuilder("before sort --> ");
                stringBuilder.append(videoPlayRecord.d);
                stringBuilder.append("：lastPlayTime --> ");
                stringBuilder.append(videoPlayRecord.j);
                if (videoPlayRecord.g() != RECORD_TYPE.TAG_LONG_VIDEO || !PrivateSpaceMgr.a().a(videoPlayRecord)) {
                    PlayRecordActivity.a(this.b.a, videoPlayRecord);
                }
            }
            if (!d.a(this.b.a.x)) {
                Collections.sort(this.b.a.x, new m(this));
            }
        }
        a.a().getPlayRecord(new n(this));
        this.b.a.v.hide();
        this.b.a.u.onRefreshComplete();
        this.b.a.a(Mode.PULL_FROM_START);
        this.b.a.l();
        this.b.a.b();
        PlayRecordActivity.c(this.b.a);
    }
}
