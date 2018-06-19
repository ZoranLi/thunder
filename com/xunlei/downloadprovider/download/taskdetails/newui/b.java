package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.s;

/* compiled from: DetailsDataManager */
public class b {
    private static final String g = "b";
    final b a = new b();
    final a b = new a();
    DownloadTaskInfo c;
    @Nullable
    s d;
    boolean e = false;
    com.xunlei.downloadprovider.download.taskdetails.a.a f;

    /* compiled from: DetailsDataManager */
    static class b extends com.xunlei.downloadprovider.download.taskdetails.a.a {
        com.xunlei.downloadprovider.download.taskdetails.items.a.a a;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a b;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a c;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a d;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a e;
        TaskSpeedCountInfo f;

        b() {
        }
    }

    /* compiled from: DetailsDataManager */
    static class a extends com.xunlei.downloadprovider.download.taskdetails.a.b {
        com.xunlei.downloadprovider.download.taskdetails.items.a.a a;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a b;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a c;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a d;
        com.xunlei.downloadprovider.download.taskdetails.items.a.a e;
        TaskSpeedCountInfo f;

        a() {
        }
    }

    static boolean a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (!TextUtils.isEmpty(taskInfo.mWebsiteName)) {
                String str = "";
                if (!TextUtils.isEmpty(taskInfo.mRefUrl)) {
                    str = taskInfo.mRefUrl;
                } else if (!(taskInfo.mExtraInfo == null || TextUtils.isEmpty(taskInfo.mExtraInfo.mRefUrl))) {
                    str = taskInfo.mExtraInfo.mRefUrl;
                }
                if (m.a().d(str) != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
