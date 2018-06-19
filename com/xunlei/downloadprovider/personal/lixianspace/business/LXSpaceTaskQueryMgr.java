package com.xunlei.downloadprovider.personal.lixianspace.business;

import android.text.TextUtils;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.lixianspace.b.t;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.d.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class LXSpaceTaskQueryMgr {
    public Map<String, LXTaskInfo> a;
    Map<Long, String> b;

    public enum LXTaskState {
        success,
        downloading,
        fail,
        unKnown
    }

    private static class a {
        private static final LXSpaceTaskQueryMgr a = new LXSpaceTaskQueryMgr();
    }

    private LXSpaceTaskQueryMgr() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        a.a.a(new a(this));
        LoginHelper.a().a(new b(this));
    }

    public static void a(TaskInfo taskInfo) {
        if (com.xunlei.downloadprovider.personal.lixianspace.a.d() && taskInfo != null) {
            int taskStatus = taskInfo.getTaskStatus();
            if (!(taskStatus == 16 || taskStatus == 17)) {
                if (taskStatus != 8) {
                    String taskDownloadUrl = taskInfo.getTaskDownloadUrl();
                    int[] iArr = null;
                    if (taskInfo.mTaskType == TaskType.BT) {
                        n.a();
                        taskInfo = n.e(taskInfo.getTaskId());
                        if (taskInfo != null) {
                            taskInfo = taskInfo.g();
                            iArr = new int[taskInfo.size()];
                            int size = taskInfo.size();
                            for (int i = 0; i < size; i++) {
                                iArr[i] = ((BTSubTaskInfo) taskInfo.get(i)).mBTSubIndex;
                            }
                        }
                    }
                    if (TextUtils.isEmpty(taskDownloadUrl) == null) {
                        new l(taskDownloadUrl).a(new t(taskDownloadUrl), taskDownloadUrl, iArr);
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(LXSpaceTaskQueryMgr lXSpaceTaskQueryMgr, String str, LXTaskInfo lXTaskInfo) {
        if (!TextUtils.isEmpty(str)) {
            if (lXTaskInfo != null) {
                lXSpaceTaskQueryMgr.a.put(str, lXTaskInfo);
            }
        }
    }
}
