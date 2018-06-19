package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import java.util.Hashtable;

/* compiled from: SpeedCounter */
public final class v {
    public a a = new a();
    a b = new a();
    public long c = 0;
    Hashtable<Long, TaskSpeedCountInfo> d = new Hashtable();

    /* compiled from: SpeedCounter */
    static class a {
        public long a = 0;
        public long b = 0;

        a() {
        }
    }

    public final TaskSpeedCountInfo a(long j) {
        return (TaskSpeedCountInfo) this.d.get(Long.valueOf(j));
    }

    final void a(long j, boolean z) {
        if (j != -1) {
            if (z || !this.d.containsKey(Long.valueOf(j))) {
                z = new TaskSpeedCountInfo();
                z.mTaskId = j;
                this.d.put(Long.valueOf(z.mTaskId), z);
            }
        }
    }
}
