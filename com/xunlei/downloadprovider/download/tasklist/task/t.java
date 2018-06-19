package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v.b;

/* compiled from: TaskWrapper */
final class t implements b {
    final /* synthetic */ DownloadTaskInfo a;
    final /* synthetic */ s b;

    t(s sVar, DownloadTaskInfo downloadTaskInfo) {
        this.b = sVar;
        this.a = downloadTaskInfo;
    }

    public final void a(VideoPlayRecord videoPlayRecord) {
        if (videoPlayRecord != null) {
            this.a.mVideoDuration = (int) videoPlayRecord.g;
            this.a.mVideoPlayedTime = (int) videoPlayRecord.h;
        }
    }
}
