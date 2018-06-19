package com.xunlei.downloadprovider.download.control;

import android.database.Observable;
import com.xunlei.downloadprovider.download.engine.task.h;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: DownloadControl */
public final class p {
    private static p b;
    a a = new a();

    /* compiled from: DownloadControl */
    private static class a extends Observable<q> implements q {
        private a() {
        }

        public final void a(TaskInfo taskInfo) {
            List arrayList = new ArrayList();
            arrayList.add(taskInfo);
            a(arrayList);
        }

        public final void a(List<TaskInfo> list) {
            if (!this.mObservers.isEmpty()) {
                Iterator it = new ArrayList(this.mObservers).iterator();
                while (it.hasNext()) {
                    ((q) it.next()).a(list);
                }
            }
        }

        public final void b(List<TaskInfo> list) {
            if (!this.mObservers.isEmpty()) {
                Iterator it = new ArrayList(this.mObservers).iterator();
                while (it.hasNext()) {
                    ((q) it.next()).b(list);
                }
            }
        }

        public final void c(List<TaskInfo> list) {
            if (!this.mObservers.isEmpty()) {
                Iterator it = new ArrayList(this.mObservers).iterator();
                while (it.hasNext()) {
                    ((q) it.next()).c(list);
                }
            }
        }
    }

    public static p a() {
        if (b == null) {
            b = new p();
        }
        return b;
    }

    public final void a(TaskInfo taskInfo, boolean z) {
        if (taskInfo.getTaskStatus() == 4 || taskInfo.getTaskStatus() == 16) {
            taskInfo.mRunningInfo.a(2);
            taskInfo.mRevision++;
        }
        n.a();
        n.b(z, new long[]{taskInfo.getTaskId()});
        this.a.a(taskInfo);
        h.a();
        h.c(taskInfo);
    }

    public final void b(TaskInfo taskInfo, boolean z) {
        if (taskInfo.getTaskStatus() != 2) {
            taskInfo.mRunningInfo.a(2);
            taskInfo.mRevision++;
        }
        n.a();
        n.a(z, new long[]{taskInfo.getTaskId()});
        this.a.a(taskInfo);
        h.a();
        h.d(taskInfo);
    }

    public final void c(TaskInfo taskInfo, boolean z) {
        n.a().c(z, new long[]{taskInfo.getTaskId()});
        BannerManager.a().a(taskInfo);
        taskInfo.mRunningInfo.a(17);
        taskInfo.mRevision += true;
        z = this.a;
        List arrayList = new ArrayList();
        arrayList.add(taskInfo);
        z.c(arrayList);
        PrivateSpaceMgr.a().a(taskInfo.getTaskId());
        if (!PrivateSpaceMgr.a().f()) {
            PrivateSpaceMgr.a().a(taskInfo.getTaskId(), true);
            PrivateSpaceMgr.a().g();
        }
    }

    public final void a(List<TaskInfo> list, boolean z) {
        if (list != null && !list.isEmpty()) {
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                TaskInfo taskInfo = (TaskInfo) list.get(i);
                jArr[i] = taskInfo.getTaskId();
                if (taskInfo.getTaskStatus() == 4 || taskInfo.getTaskStatus() == 16) {
                    taskInfo.mRunningInfo.a(2);
                    taskInfo.mRevision++;
                }
            }
            n.a();
            n.b(z, jArr);
            this.a.a((List) list);
            h.a();
            h.a((List) list);
        }
    }

    public final void a(List<TaskInfo> list) {
        if (!list.isEmpty()) {
            long[] jArr = new long[list.size()];
            for (int i = 0; i < list.size(); i++) {
                TaskInfo taskInfo = (TaskInfo) list.get(i);
                jArr[i] = taskInfo.getTaskId();
                if (taskInfo.getTaskStatus() == 1 || taskInfo.getTaskStatus() == 2) {
                    taskInfo.mRunningInfo.a(4);
                    taskInfo.mRevision++;
                }
            }
            n.a();
            n.a(jArr);
            this.a.b(list);
        }
    }

    public static void a(boolean z) {
        n.a();
        n.a(z);
    }
}
