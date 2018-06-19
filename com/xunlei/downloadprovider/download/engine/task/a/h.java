package com.xunlei.downloadprovider.download.engine.task.a;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.downloadvod.a;
import com.xunlei.downloadprovider.download.downloadvod.a.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.c;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: CoreTaskManagerImpl */
public class h {
    private List<z> a;
    public final ConcurrentHashMap<Long, a> k = new ConcurrentHashMap();
    final ConcurrentHashMap<Long, a> l = new ConcurrentHashMap();
    protected ac m = new ac();
    protected ac n = new ac();
    protected long o = 0;
    final AtomicBoolean p = new AtomicBoolean(false);
    final List<TaskInfo> q = new ArrayList();
    public final List<TaskInfo> r = new ArrayList();
    final HashSet<TaskInfo> s = new HashSet();
    final HashSet<TaskInfo> t = new HashSet();
    int u = 0;
    public final y v = new y();
    final ExecutorService w = Executors.newSingleThreadScheduledExecutor();

    h() {
    }

    @NonNull
    private static ac a(Collection<a> collection, ac acVar) {
        if (acVar == null) {
            acVar = new ac();
        } else {
            acVar.a.reset();
            a aVar = acVar.b;
            aVar.a.reset();
            aVar.b.reset();
            aVar.d.a();
            aVar.e.a();
        }
        acVar.a.mTotalCount = collection.size();
        if (collection.size() > 0) {
            for (a aVar2 : collection) {
                if (aVar2 != null) {
                    TaskCountsStatistics taskCountsStatistics = acVar.a;
                    taskCountsStatistics.mTotalCount++;
                    int b = aVar2.b();
                    int d = aVar2.d() ^ 1;
                    int i = 0;
                    int i2 = aVar2.f() == 300 ? 1 : 0;
                    if (d != 0) {
                        TaskCountsStatistics taskCountsStatistics2 = acVar.b.a;
                        taskCountsStatistics2.mTotalCount++;
                    }
                    TaskInfo taskInfo = aVar2.c;
                    if (taskInfo != null && taskInfo.mOriginalStatusCode == 111154) {
                        i = 1;
                    }
                    boolean c = DownloadError.c(aVar2.c);
                    TaskCountsStatistics taskCountsStatistics3;
                    if (b == 16) {
                        taskCountsStatistics3 = acVar.a;
                        taskCountsStatistics3.mFailedCount++;
                        if (d != 0) {
                            taskCountsStatistics3 = acVar.b.a;
                            taskCountsStatistics3.mFailedCount++;
                            if (i2 != 0) {
                                taskCountsStatistics3 = acVar.b.b;
                                taskCountsStatistics3.mFailedCount++;
                            }
                            if (!c && i2 == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedUnIllegalCount++;
                            }
                            if (i == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedNoCopyRightProblemCount++;
                            }
                        }
                    } else if (b == 4) {
                        taskCountsStatistics3 = acVar.a;
                        taskCountsStatistics3.mPausedCount++;
                        if (d != 0) {
                            taskCountsStatistics3 = acVar.b.a;
                            taskCountsStatistics3.mPausedCount++;
                            if (i2 != 0) {
                                taskCountsStatistics3 = acVar.b.b;
                                taskCountsStatistics3.mPausedCount++;
                            }
                            if (!c && i2 == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedUnIllegalCount++;
                            }
                            if (i == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedNoCopyRightProblemCount++;
                            }
                        }
                    } else if (b == 8) {
                        taskCountsStatistics3 = acVar.a;
                        taskCountsStatistics3.mSuccessCount++;
                        if (d != 0) {
                            taskCountsStatistics3 = acVar.b.a;
                            taskCountsStatistics3.mSuccessCount++;
                            if (i2 != 0) {
                                taskCountsStatistics3 = acVar.b.b;
                                taskCountsStatistics3.mSuccessCount++;
                            }
                        }
                    } else if (b == 2 || b == 1) {
                        TaskCountsStatistics taskCountsStatistics4 = acVar.a;
                        taskCountsStatistics4.mRunningCount++;
                        if (d != 0) {
                            TaskCountsStatistics taskCountsStatistics5 = acVar.b.a;
                            taskCountsStatistics5.mRunningCount++;
                            if (i2 != 0) {
                                taskCountsStatistics5 = acVar.b.b;
                                taskCountsStatistics5.mRunningCount++;
                            }
                            if (b == 2 && i2 == 0) {
                                long j = aVar2.c().mDownloadSpeed;
                                long j2 = aVar2.c().mVipAcceleratedSpeed;
                                aVar = acVar.b;
                                c cVar = aVar.d;
                                cVar.a += j;
                                cVar = aVar.d;
                                cVar.b += j2;
                                if (i2 == 0) {
                                    cVar = aVar.e;
                                    cVar.a += j;
                                    c cVar2 = aVar.e;
                                    cVar2.b += j2;
                                }
                            }
                            if (!c && i2 == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedUnIllegalCount++;
                            }
                            if (i == 0) {
                                taskCountsStatistics3 = acVar.b.a;
                                taskCountsStatistics3.mUnfinishedNoCopyRightProblemCount++;
                            }
                        }
                    }
                }
            }
        }
        return acVar;
    }

    final void a(List<a> list) {
        this.n = a(list, this.n);
        if (this.m == null) {
            this.m = new ac(this.n);
        } else {
            this.m.a(this.n);
        }
        this.o = SystemClock.elapsedRealtime();
        this.u = null;
    }

    static void b(List<a> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                for (a aVar : list) {
                    if (k.a(aVar.c())) {
                        d notifyManager = a.getNotifyManager();
                        if (com.xunlei.downloadprovider.d.d.a().d.r()) {
                            boolean z = false;
                            if (!f.b(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_checked", false) && notifyManager.c) {
                                CharSequence a = f.a(BrothersApplication.getApplicationInstance(), "task_bxbb_notify_create_task_flag");
                                String str = "5.60.2.5510";
                                if (TextUtils.isEmpty(a) || str.equals(a)) {
                                    z = true;
                                }
                                if (z && !notifyManager.b) {
                                    TaskInfo c = aVar.c();
                                    if (c.getVodStatus() != 0) {
                                        if (c.getVodStatus() == 3) {
                                            if (SystemClock.elapsedRealtime() - c.mRunningInfo.e <= 5000) {
                                            }
                                        }
                                    }
                                    c.setVodStatus(1);
                                    notifyManager.a.add(c);
                                    notifyManager.d();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(@NonNull a aVar) {
        this.k.put(Long.valueOf(aVar.a()), aVar);
        aVar.a = true;
        if (aVar.d()) {
            b(aVar);
        }
        i();
    }

    final void b(@NonNull a aVar) {
        if (aVar.d()) {
            this.l.put(Long.valueOf(aVar.a()), aVar);
            StringBuilder stringBuilder = new StringBuilder("PutTaskId = ");
            stringBuilder.append(aVar.a());
            stringBuilder.append(" ");
            stringBuilder.append(aVar.d());
            this.p.set(false);
        }
    }

    public List<z> g(long j) {
        if (j != 100) {
            return f(j);
        }
        if (!this.p.get()) {
            this.a = f(j);
            this.p.set(true);
        }
        return Collections.unmodifiableList(this.a);
    }

    public List<z> a(Set<Long> set) {
        List<z> arrayList = new ArrayList(this.l.size());
        if (!this.l.isEmpty()) {
            for (a aVar : this.l.values()) {
                if (set.contains(Long.valueOf(aVar.f()))) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public List<z> f(long j) {
        List<z> arrayList = new ArrayList(this.l.size());
        if (!this.l.isEmpty()) {
            for (a aVar : this.l.values()) {
                if (j == aVar.f()) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public final a h(long j) {
        return (a) this.k.get(Long.valueOf(j));
    }

    @Nullable
    public z e(long j) {
        return h(j);
    }

    final void i() {
        this.u |= 1;
    }

    final void j() {
        this.u |= 2;
    }

    final void k() {
        List arrayList = new ArrayList();
        if (!this.k.isEmpty()) {
            for (a add : this.k.values()) {
                arrayList.add(add);
            }
        }
        new StringBuilder("notifyTaskListUpdate - size = ").append(arrayList.size());
        this.v.a(Collections.unmodifiableList(arrayList));
    }

    @NonNull
    final ac c(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.o;
        if (z || this.u || !this.m || this.o == 0 || elapsedRealtime >= 10000) {
            z = a(this.k.values(), null);
            this.o = SystemClock.elapsedRealtime();
            this.m = z;
            this.u = false;
        }
        return this.m;
    }
}
