package com.xunlei.downloadprovider.download.engine.task;

import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.download.downloadvod.a;
import com.xunlei.downloadprovider.download.downloadvod.a.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.personal.lixianspace.business.LXSpaceTaskQueryMgr;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* compiled from: DownloadBusinessHelper */
public class h {
    private static h a;

    public static h a() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h();
                }
            }
        }
        return a;
    }

    private h() {
    }

    public static void b() {
        d notifyManager = a.getNotifyManager();
        n.a();
        int i = n.j().mTotalCount;
        notifyManager.c = true;
        if (TextUtils.isEmpty(f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_create_task_flag")) && i > 0) {
            f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_create_task_flag", RePlugin.PROCESS_UI);
        }
    }

    public static void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
            long taskId = taskInfo.getTaskId();
            if (taskId >= 0) {
                PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "successTask");
                String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                if (com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.d(taskId) == 0) {
                    long j = preferenceHelper.getLong(format, 0) + 1;
                    preferenceHelper.putLong(format, j);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(format);
                    stringBuilder.append("&");
                    stringBuilder.append(taskId);
                    preferenceHelper.putLong(stringBuilder.toString(), j);
                }
            }
            com.xunlei.downloadprovider.download.tasklist.list.banner.f.f a = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
            long taskId2 = taskInfo.getTaskId();
            if (com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.e() && a.g <= 0) {
                a.g = taskId2;
            }
            if (PrivateSpaceMgr.a().a(taskInfo)) {
                PrivateSpaceMgr.a().a(taskInfo.getTaskId(), taskInfo.mLocalFileName);
            }
        }
    }

    public static void b(TaskInfo taskInfo) {
        if (!taskInfo.isTaskInvisible()) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f(taskInfo.getTaskId());
            a.a;
            LXSpaceTaskQueryMgr.a(taskInfo);
            a.getNotifyManager();
            d.b();
        }
    }

    public static void c(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (!taskInfo.isTaskInvisible()) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f(taskInfo.getTaskId());
                a.a;
                LXSpaceTaskQueryMgr.a(taskInfo);
            }
        }
    }

    public static void a(List<TaskInfo> list) {
        if (list != null) {
            if (list.size() > 0) {
                for (TaskInfo taskInfo : list) {
                    if (!taskInfo.isTaskInvisible()) {
                        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f(taskInfo.getTaskId());
                        a.a;
                        LXSpaceTaskQueryMgr.a(taskInfo);
                    }
                }
            }
        }
    }

    public static void d(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (!taskInfo.isTaskInvisible()) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f(taskInfo.getTaskId());
                a.a;
                LXSpaceTaskQueryMgr.a(taskInfo);
            }
        }
    }

    public static void b(List<Long> list) {
        if (list.size() > 0) {
            for (Long l : list) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f(l.longValue());
                a.a;
                long longValue = l.longValue();
                if (com.xunlei.downloadprovider.personal.lixianspace.a.d()) {
                    n.a();
                    z e = n.e(longValue);
                    if (e != null) {
                        LXSpaceTaskQueryMgr.a(e.c());
                    }
                }
            }
        }
    }

    static void c() {
        b a = b.a();
        try {
            if (!a.d) {
                CooperationScene b = c.a().b(1001);
                if (!(b == null || TextUtils.isEmpty(b.getAttachment()) || (Long.parseLong(b.getAttachment()) * 1024) * 1024 <= DownloadConfig.getStorageAvailableSize(BrothersApplication.getApplicationInstance()))) {
                    a.a.post(new com.xunlei.downloadprovider.cooperation.ui.f(a));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
