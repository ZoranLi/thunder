package com.xunlei.downloadprovider.download.tasklist.task;

import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: TaskOperateHelper */
public final class r {
    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        if (a.a().a(downloadTaskInfo.getTaskId())) {
            return (!k.a(downloadTaskInfo, k.i(downloadTaskInfo)) || downloadTaskInfo.mVipAcceleratedSpeed >= 1) && downloadTaskInfo.mVipAcceleratedSpeed >= 1;
        } else {
            if (!downloadTaskInfo.mHasVipChannelSpeedup) {
                return downloadTaskInfo.mVipAcceleratedSpeed >= 1;
            } else {
                return (!(downloadTaskInfo.mVipChannelStatus == 16) || downloadTaskInfo.mVipAcceleratedSpeed >= 1) && downloadTaskInfo.mVipAcceleratedSpeed >= 1;
            }
        }
    }
}
