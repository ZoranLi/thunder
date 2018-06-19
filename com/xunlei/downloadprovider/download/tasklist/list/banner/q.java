package com.xunlei.downloadprovider.download.tasklist.list.banner;

import android.content.Context;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: IBannerView */
public interface q {
    DownloadTaskInfo a();

    void a(int i);

    void a(DownloadTaskInfo downloadTaskInfo, long j, long j2, long j3);

    void a(DownloadTaskInfo downloadTaskInfo, Object obj, boolean z);

    void a(Object obj);

    Context b();

    void c();

    void d();

    RedPacketConditionsInfo e();
}
