package com.xunlei.downloadprovider.download.tasklist.list.banner;

import android.content.Context;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: IBannerPresenter */
public interface p {
    a a(long j);

    void a();

    void a(Context context);

    void a(RedPacketConditionsInfo redPacketConditionsInfo, DownloadTaskInfo downloadTaskInfo);

    void a(DownloadTaskInfo downloadTaskInfo);

    void b();
}
