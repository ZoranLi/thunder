package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.b;

/* compiled from: FindTaskResultImpl */
final class q extends b {
    BTSubTaskInfo a;
    private a b;

    q(a aVar) {
        this.b = aVar;
    }

    public final long a() {
        return this.b != null ? this.b.a() : -1;
    }

    public final int b() {
        return this.a != null ? this.a.mBTSubIndex : -1;
    }

    public final TaskInfo c() {
        return this.b != null ? this.b.c() : null;
    }

    public final BTSubTaskInfo d() {
        return this.a;
    }
}
