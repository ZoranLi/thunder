package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.info.FindTaskKeyType;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.b;
import com.xunlei.downloadprovider.download.engine.task.info.c;
import com.xunlei.downloadprovider.download.engine.task.z;
import java.util.List;

/* compiled from: ITaskListManager */
public interface s {
    long a();

    long a(String str);

    TaskCountsStatistics a(boolean z);

    b a(String str, FindTaskKeyType findTaskKeyType);

    List<z> a(long j);

    long b(String str);

    TaskInfo b(long j);

    c b(boolean z);

    long c(String str);

    z c(long j);

    void d(long j);

    boolean d();

    int e();

    TaskCountsStatistics f();

    List<TaskInfo> h();
}
