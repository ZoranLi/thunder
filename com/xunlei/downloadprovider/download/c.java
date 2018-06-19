package com.xunlei.downloadprovider.download;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import com.xunlei.downloadprovider.download.create.DownData;
import com.xunlei.downloadprovider.download.create.af;
import com.xunlei.downloadprovider.download.create.at;
import com.xunlei.downloadprovider.download.create.au;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.report.a;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.m;
import com.xunlei.downloadprovider.download.engine.task.n;

/* compiled from: DownloadCreateTaskUtil */
public final class c {
    public static void a(String str, String str2, String str3, @NonNull TaskStatInfo taskStatInfo) {
        DownData downData = new DownData(null);
        downData.b = str;
        downData.a = str2;
        downData.c = null;
        downData.a(str3);
        at.a(downData, taskStatInfo);
        com.xunlei.downloadprovider.download.util.c.a();
    }

    public static void a(Context context, String str, String str2, long j, String str3, @NonNull TaskStatInfo taskStatInfo, @Nullable DownloadAdditionInfo downloadAdditionInfo, @Nullable com.xunlei.downloadprovider.download.engine.task.c cVar) {
        DownData downData = new DownData(downloadAdditionInfo);
        downData.b = str;
        downData.a = str2;
        downData.c = j;
        downData.a(str3);
        at.a(context, downData, taskStatInfo, cVar);
        com.xunlei.downloadprovider.download.util.c.a();
    }

    public static void a(Context context, @NonNull DownData downData, @NonNull TaskStatInfo taskStatInfo, @Nullable com.xunlei.downloadprovider.download.engine.task.c cVar) {
        at.a(context, downData, taskStatInfo, cVar);
        com.xunlei.downloadprovider.download.util.c.a();
    }

    public static void a(String str, String str2, long j, String str3, @NonNull TaskStatInfo taskStatInfo, @Nullable DownloadAdditionInfo downloadAdditionInfo, @Nullable com.xunlei.downloadprovider.download.engine.task.c cVar) {
        TaskStatInfo taskStatInfo2 = taskStatInfo;
        com.xunlei.downloadprovider.download.engine.task.c cVar2 = cVar;
        at.a();
        m mVar = new m();
        mVar.a(str, str2, j, str3, taskStatInfo2.a, downloadAdditionInfo);
        mVar.b = taskStatInfo2;
        mVar.d = cVar2;
        if (cVar2 == null) {
            mVar.d = af.a().a;
        }
        a.a(taskStatInfo2.a);
        n.a().a(mVar);
        com.xunlei.downloadprovider.download.util.c.a();
    }

    public static void a(FragmentActivity fragmentActivity, int i, long j) {
        fragmentActivity = at.a(fragmentActivity);
        if (fragmentActivity != null) {
            fragmentActivity.a(i, j);
        }
    }

    public static void a(FragmentActivity fragmentActivity, au auVar) {
        fragmentActivity = at.a(fragmentActivity);
        if (fragmentActivity != null) {
            fragmentActivity.a = auVar;
        }
    }
}
