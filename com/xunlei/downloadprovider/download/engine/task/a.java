package com.xunlei.downloadprovider.download.engine.task;

import com.umeng.message.proguard.k;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.h.e;
import java.util.Collection;
import java.util.HashSet;

/* compiled from: BackgroundTaskManager */
public final class a {
    private static final a b = new a();
    public final HashSet<Long> a = new BackgroundTaskManager$1(this);

    public static void b() {
    }

    public static a a() {
        return b;
    }

    private a() {
    }

    public final boolean a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (taskInfo.isTaskInvisible()) {
                return this.a.contains(Long.valueOf(taskInfo.getCustomFlags()));
            }
        }
        return null;
    }

    public static void a(TaskInfo taskInfo, int i) {
        StringBuilder stringBuilder = new StringBuilder("notifyInvisibleTaskStateChanged(");
        stringBuilder.append(i);
        stringBuilder.append("->");
        stringBuilder.append(taskInfo.getTaskStatus());
        stringBuilder.append("):");
        stringBuilder.append(taskInfo.mTitle);
    }

    public static void b(TaskInfo taskInfo) {
        if (taskInfo.getTaskStatus() == 8) {
            if (!e.c(taskInfo.mLocalFileName)) {
                n.a();
                n.a(false, new long[]{taskInfo.getTaskId()});
                new StringBuilder("开始下载: ").append(taskInfo.mTitle);
            }
        } else if (taskInfo.getTaskStatus() == 4 || taskInfo.getTaskStatus() == 16 || taskInfo.getTaskStatus() == 2) {
            n.a();
            n.b(false, new long[]{taskInfo.getTaskId()});
            new StringBuilder("正在努力下载，请耐心等待: ").append(taskInfo.mTitle);
        }
    }

    public static void a(Collection<z> collection) {
        new StringBuilder("onInvisibleTasksLoaded: ").append(collection.size());
        if (!collection.isEmpty()) {
            for (z zVar : collection) {
                StringBuilder stringBuilder;
                if (zVar.d()) {
                    int i = (!zVar.d() || System.currentTimeMillis() - zVar.c().mCreateTime < 604800000) ? false : 1;
                    if (i != 0) {
                        stringBuilder = new StringBuilder("onInvisibleTasksLoaded - ");
                        stringBuilder.append(zVar.a());
                        stringBuilder.append(" deleted : ");
                        stringBuilder.append(zVar.c().mTitle);
                        n.a().c(false, new long[]{zVar.a()});
                    }
                }
                stringBuilder = new StringBuilder("onInvisibleTasksLoaded - ");
                stringBuilder.append(zVar.a());
                stringBuilder.append(k.s);
                stringBuilder.append(zVar.b());
                stringBuilder.append(") loaded : ");
                stringBuilder.append(zVar.c().mTitle);
            }
        }
        c.a();
        c.b();
    }
}
