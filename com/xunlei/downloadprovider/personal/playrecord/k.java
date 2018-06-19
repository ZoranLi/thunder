package com.xunlei.downloadprovider.personal.playrecord;

import java.util.List;

/* compiled from: PlayRecordActivity */
final class k implements v$c {
    final /* synthetic */ PlayRecordActivity a;

    k(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void a(List<VideoPlayRecord> list) {
        this.a.runOnUiThread(new l(this, list));
    }
}
