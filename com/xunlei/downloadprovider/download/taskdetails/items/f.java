package com.xunlei.downloadprovider.download.taskdetails.items;

import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v.b;

/* compiled from: DetailBtTaskSubFileViewHolder */
final class f implements b {
    final /* synthetic */ BTSubTaskItem a;
    final /* synthetic */ b b;

    f(b bVar, BTSubTaskItem bTSubTaskItem) {
        this.b = bVar;
        this.a = bTSubTaskItem;
    }

    public final void a(VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null && this.b.c() != null) {
            this.b.c().runOnUiThread(new g(this, videoPlayRecord));
        }
    }
}
