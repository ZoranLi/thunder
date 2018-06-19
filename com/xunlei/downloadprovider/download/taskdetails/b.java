package com.xunlei.downloadprovider.download.taskdetails;

import android.util.LruCache;
import com.xunlei.downloadprovider.download.engine.kernel.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.Iterator;
import java.util.List;

/* compiled from: BtTaskDetailDataSource */
final class b extends com.xunlei.downloadprovider.download.taskdetails.a.b {
    final c a = new c();
    a b;
    a c;
    a d;
    a e;
    a f;
    a g;
    TaskSpeedCountInfo h;
    LruCache<String, BTSubTaskItem> i = new LruCache(100);

    b() {
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        if (this.b != null) {
            this.b.d = downloadTaskInfo;
        }
        if (this.c != null) {
            this.c.d = downloadTaskInfo;
        }
        if (this.d != null) {
            this.d.d = downloadTaskInfo;
        }
        if (!(this.l == null || this.l.isEmpty())) {
            Iterator it = this.l.iterator();
            while (it.hasNext()) {
                ((a) it.next()).d = downloadTaskInfo;
            }
        }
        if (this.e != null) {
            this.e.d = downloadTaskInfo;
        }
        if (this.f != null) {
            this.f.d = downloadTaskInfo;
        }
        if (this.g != null) {
            this.g.d = downloadTaskInfo;
        }
    }

    static boolean a(long j, List<BTSubTaskItem> list) {
        for (BTSubTaskItem bTSubTaskItem : list) {
            if (bTSubTaskItem.mTaskId == j) {
                return bTSubTaskItem.isSelected();
            }
        }
        return 0;
    }

    static String a(long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append("_");
        stringBuilder.append(j2);
        return stringBuilder.toString();
    }
}
