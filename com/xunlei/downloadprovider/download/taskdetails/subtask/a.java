package com.xunlei.downloadprovider.download.taskdetails.subtask;

import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v.b;

/* compiled from: BTSubTaskItem */
final class a implements b {
    final /* synthetic */ BTSubTaskItem a;

    a(BTSubTaskItem bTSubTaskItem) {
        this.a = bTSubTaskItem;
    }

    public final void a(VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null) {
            this.a.mVideoDuration = (int) videoPlayRecord.g;
            this.a.mVideoPlayedTime = (int) videoPlayRecord.h;
            if (this.a.mViewModel != null && this.a.mViewModel.b(this.a) != null) {
                videoPlayRecord = this.a.mViewModel;
                BTSubTaskItem bTSubTaskItem = this.a;
                if (videoPlayRecord.b(bTSubTaskItem)) {
                    g.b.post(new i(videoPlayRecord, bTSubTaskItem));
                }
            }
        }
    }
}
