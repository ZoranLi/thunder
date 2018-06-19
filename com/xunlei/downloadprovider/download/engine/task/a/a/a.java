package com.xunlei.downloadprovider.download.engine.task.a.a;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.download.engine.task.a.a.a.b;
import com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TaskExtraInfoController */
public class a {
    private static a b;
    public final HashMap<Long, TaskExtraInfo> a = new HashMap();
    private ExecutorService c = Executors.newSingleThreadExecutor();

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                b = new a();
            }
        }
        return b;
    }

    private a() {
    }

    @Nullable
    public final TaskExtraInfo a(long j) {
        if (j == -1) {
            return 0;
        }
        synchronized (this.a) {
            if (this.a.containsKey(Long.valueOf(j))) {
                TaskExtraInfo taskExtraInfo = (TaskExtraInfo) this.a.get(Long.valueOf(j));
                return taskExtraInfo;
            }
            TaskExtraInfo a = b.a().a(j);
            synchronized (this.a) {
                this.a.put(Long.valueOf(j), a);
            }
            return a;
        }
    }

    public final void a(@Nullable TaskExtraInfo taskExtraInfo) {
        if (taskExtraInfo != null) {
            synchronized (this.a) {
                if (this.a.containsKey(Long.valueOf(taskExtraInfo.mTaskId))) {
                    TaskExtraInfo taskExtraInfo2 = (TaskExtraInfo) this.a.get(Long.valueOf(taskExtraInfo.mTaskId));
                    if (taskExtraInfo2 == null) {
                        this.a.put(Long.valueOf(taskExtraInfo.mTaskId), taskExtraInfo);
                    } else {
                        taskExtraInfo2.deepCopyFrom(taskExtraInfo);
                    }
                } else {
                    this.a.put(Long.valueOf(taskExtraInfo.mTaskId), taskExtraInfo);
                }
            }
            b.a().a(taskExtraInfo);
        }
    }

    public static void a(long j, long j2) {
        b.a().a(j, j2, true);
    }

    public static boolean b(long j) {
        return b.a().c(j);
    }

    public final void c(long j) {
        this.c.execute(new b(this, j));
    }
}
