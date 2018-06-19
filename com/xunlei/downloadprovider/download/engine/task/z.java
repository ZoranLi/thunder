package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import java.util.List;

/* compiled from: XLBasicTask */
public abstract class z {
    public abstract long a();

    public <T> T a(Class<T> cls) {
        return null;
    }

    public abstract long[] a(int i);

    public abstract int b();

    public abstract BTSubTaskInfo b(int i);

    public abstract TaskInfo c();

    public abstract boolean d();

    public abstract long f();

    public abstract List<BTSubTaskInfo> g();

    public abstract void h();

    public final boolean e() {
        return b() == 8;
    }
}
