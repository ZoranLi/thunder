package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import com.xunlei.downloadprovider.download.engine.task.n;
import java.util.List;

/* compiled from: TaskListManager */
final class m extends a<List<s>> {
    final /* synthetic */ l a;

    m(l lVar, List list) {
        this.a = lVar;
        super(list);
    }

    public final /* synthetic */ void a(Object obj) {
        List<s> list = (List) obj;
        if (!list.isEmpty()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            for (s sVar : list) {
                DownloadTaskInfo downloadTaskInfo = sVar.b;
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (downloadTaskInfo.mFileCategoryType == null || downloadTaskInfo.mFileCategoryType == EFileCategoryType.E_OTHER_CATEGORY) {
                    if (TextUtils.isEmpty(downloadTaskInfo.mLocalFileName)) {
                        downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mTitle);
                    } else {
                        downloadTaskInfo.mFileCategoryType = XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mLocalFileName);
                    }
                }
                int i = s.a(downloadTaskInfo, elapsedRealtime2, false) ? 1 : 0;
                if (downloadTaskInfo.mFileCategoryType == EFileCategoryType.E_VIDEO_CATEGORY) {
                    if (!(downloadTaskInfo.mDownloadingPlayUrl != null || downloadTaskInfo.mLocalFileName == null || downloadTaskInfo.getTaskStatus() == 16 || downloadTaskInfo.mIsFileMissing || downloadTaskInfo.mDownloadedSize <= 0)) {
                        n.a();
                        downloadTaskInfo.mDownloadingPlayUrl = n.c(downloadTaskInfo.mLocalFileName);
                        if (downloadTaskInfo.mDownloadingPlayUrl == null) {
                            downloadTaskInfo.mDownloadingPlayUrl = "";
                        }
                    }
                    if (sVar.a(elapsedRealtime2, false)) {
                        i++;
                    }
                }
                if (downloadTaskInfo.mFreeTrialLMT == 0 || elapsedRealtime2 - downloadTaskInfo.mFreeTrialLMT >= 3000) {
                    downloadTaskInfo.mFreeTrialLMT = elapsedRealtime2;
                    n.a();
                    downloadTaskInfo.mIsEnteredHighSpeedTrial = n.j(downloadTaskInfo.getTaskId());
                    n.a();
                    downloadTaskInfo.mFreeTrialTimes = n.i(downloadTaskInfo.getTaskId());
                    i++;
                }
                if (i > 0) {
                    downloadTaskInfo.mRevision++;
                }
            }
            long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime;
            String str = h.a;
            StringBuilder stringBuilder = new StringBuilder("UpdateTaskInfoList: refreshTaskInfo - cost = ");
            stringBuilder.append(elapsedRealtime3);
            stringBuilder.append("ms, size =  ");
            stringBuilder.append(list.size());
        }
    }
}
