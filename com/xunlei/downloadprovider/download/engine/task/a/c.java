package com.xunlei.downloadprovider.download.engine.task.a;

import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.k;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager$Query;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.kernel.e;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.shub.GcidInfo;
import com.xunlei.downloadprovider.download.engine.task.a.a.a;
import com.xunlei.downloadprovider.download.engine.task.a.a.a.b;
import com.xunlei.downloadprovider.download.engine.task.h;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.FindTaskKeyType;
import com.xunlei.downloadprovider.download.engine.task.info.TaskBasicInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: CoreTaskManager */
public final class c extends h implements s {
    public final v a = new v();
    public final t b = new t("CoreTaskManager", this.x);
    public final x c = new x();
    protected boolean d = false;
    protected int e = 0;
    public aa f = new aa();
    ab g = new ab();
    public final a h = a.a();
    Set<Long> i = new HashSet();
    public boolean j = false;
    private final Callback x = new d(this);
    private l y;
    private long z = 0;

    @Nullable
    public final /* bridge */ /* synthetic */ z e(long j) {
        return super.e(j);
    }

    public final /* bridge */ /* synthetic */ List f(long j) {
        return super.f(j);
    }

    public final /* bridge */ /* synthetic */ List g(long j) {
        return super.g(j);
    }

    public c(l lVar) {
        this.y = lVar;
        this.b.start();
    }

    public final long a() {
        return this.z;
    }

    public final List<z> a(long j) {
        List arrayList = new ArrayList(this.k.size());
        if (!this.k.isEmpty()) {
            for (a aVar : this.k.values()) {
                if (aVar.f() == j) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    private long l() {
        long j = 0;
        if (this.k.size() > 0) {
            for (a c : this.k.values()) {
                long j2;
                TaskInfo c2 = c.c();
                if (!(c2.getTaskStatus() == 1 || c2.getTaskStatus() == 2)) {
                    if (c2.getTaskStatus() != 4) {
                        if (!TextUtils.isEmpty(c2.mLocalFileName) && new File(c2.mLocalFileName).exists()) {
                            j2 = j + c2.mDownloadedSize;
                            j = j2;
                        }
                    }
                }
                j2 = j + c2.mDownloadedSize;
                j = j2;
            }
        }
        return j;
    }

    private void b(TaskInfo taskInfo) {
        if (!taskInfo.isTaskInvisible()) {
            synchronized (this.t) {
                if (this.t.contains(taskInfo)) {
                    this.t.remove(taskInfo);
                    i();
                }
            }
            this.s.add(taskInfo);
            i();
        }
    }

    public final void a(TaskInfo taskInfo) {
        if (!taskInfo.isTaskInvisible()) {
            if (taskInfo.getTaskStatus() == 8) {
                b(taskInfo);
                return;
            }
            if (this.s.contains(taskInfo)) {
                this.s.remove(taskInfo);
                i();
            }
            synchronized (this.t) {
                if (!this.t.contains(taskInfo)) {
                    this.t.add(taskInfo);
                    i();
                }
                j();
            }
        }
    }

    public final Collection<TaskInfo> a(Collection<Long> collection) {
        Collection<TaskInfo> hashSet = new HashSet();
        if (this.k != null) {
            for (Long l : collection) {
                a aVar = (a) this.k.remove(l);
                long longValue = l.longValue();
                this.p.set(false);
                this.l.remove(Long.valueOf(longValue));
                if (aVar != null) {
                    hashSet.add(aVar.c());
                    a aVar2 = this.h;
                    longValue = l.longValue();
                    synchronized (aVar2.a) {
                        if (aVar2.a.containsKey(Long.valueOf(longValue))) {
                            aVar2.a.remove(Long.valueOf(longValue));
                        }
                    }
                    b.a().a(longValue);
                    b.a().b(longValue);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            this.r.removeAll(hashSet);
            this.q.removeAll(hashSet);
            this.t.removeAll(hashSet);
            this.s.removeAll(hashSet);
            i();
        }
        this.f.a((Collection) collection);
        return hashSet;
    }

    public final void b() {
        Object obj = (VERSION.SDK_INT < 23 || BrothersApplication.getApplicationInstance().checkSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) == 0) ? 1 : null;
        if (obj != null) {
            this.c.a(this.y.f(), this.y.f, new e(this));
        }
    }

    final void a(ArrayList<TaskBasicInfo> arrayList) {
        new StringBuilder("onUpdateCoreTaskRunningInfo: size = ").append(arrayList.size());
        Collection hashSet = new HashSet();
        List arrayList2 = new ArrayList(arrayList.size());
        try {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                TaskInfo taskInfo;
                a aVar;
                int i;
                TaskBasicInfo taskBasicInfo = (TaskBasicInfo) arrayList.next();
                long taskId = taskBasicInfo.getTaskId();
                int taskStatus = taskBasicInfo.getTaskStatus();
                a h = h(taskId);
                if (h == null) {
                    taskInfo = new TaskInfo();
                    taskInfo.setTaskId(taskId);
                    taskInfo.setTaskStatus(taskStatus);
                    taskInfo.mRunningInfo.a = true;
                    taskInfo.mCreateTime = taskBasicInfo.mCreateTime == 0 ? System.currentTimeMillis() : taskBasicInfo.mCreateTime;
                    aVar = new a(taskId, taskInfo);
                    a(aVar);
                    taskInfo = aVar.c();
                    i = -1;
                } else {
                    TaskInfo c = h.c();
                    i = c.getTaskStatus();
                    a aVar2 = h;
                    taskInfo = c;
                    aVar = aVar2;
                }
                arrayList2.add(aVar);
                if ((!this.d || this.e <= 1) && r9 == -1) {
                    i = taskInfo.getTaskStatus();
                }
                taskInfo.mRunningInfo.b = i;
                TaskBasicInfo.copyTaskBasicInfoCoreFields(taskBasicInfo, aVar.c);
                TaskInfo.calculateTaskRunningData(aVar.c);
                if (aVar.d()) {
                    b(aVar);
                }
                hashSet.add(Long.valueOf(taskId));
            }
            if (this.k.isEmpty() == null) {
                Collection hashSet2 = new HashSet(this.k.keySet());
                hashSet2.removeAll(hashSet);
                if (!hashSet2.isEmpty()) {
                    a(hashSet2);
                }
            }
            if (this.b.isAlive() != null) {
                this.b.execute(new f(this, arrayList2));
            } else {
                c(arrayList2);
            }
        } catch (ArrayList<TaskBasicInfo> arrayList3) {
            arrayList3.printStackTrace();
            CrashReport.postCatchedException(arrayList3);
        }
    }

    private void c(List<a> list) {
        long j;
        Collection collection;
        Exception e;
        v vVar;
        a aVar;
        Exception exception;
        long nanoTime;
        StringBuilder stringBuilder;
        long nanoTime2 = System.nanoTime();
        a aVar2 = this.a.b;
        aVar2.a = 0;
        aVar2.b = 0;
        HashSet hashSet = new HashSet();
        try {
            ArrayList arrayList = new ArrayList();
            if (list.isEmpty()) {
                j = nanoTime2;
                collection = hashSet;
            } else {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Iterator it2;
                    long taskId;
                    TaskSpeedCountInfo taskSpeedCountInfo;
                    HashSet hashSet2;
                    ArrayList arrayList2;
                    a aVar3;
                    ArrayList arrayList3;
                    Collection collection2;
                    int i;
                    a aVar4 = (a) it.next();
                    long a = aVar4.a();
                    int b = aVar4.b();
                    TaskInfo c = aVar4.c();
                    int i2 = c.mRunningInfo.b;
                    if (TextUtils.isEmpty(c.mUrlEigenvalue)) {
                        c.mUrlEigenvalue = com.xunlei.downloadprovider.download.engine.util.b.e(c.mUrl);
                    }
                    c(c);
                    Object obj = (aVar4.c.mTaskType != TaskType.BT || aVar4.b) ? null : 1;
                    if (obj != null) {
                        aVar4.i();
                    } else {
                        if ((aVar4.c.mTaskType == TaskType.BT ? 1 : null) != null && aVar4.b() == 2) {
                            aVar4.h();
                        }
                    }
                    if (c.mRunningInfo.a) {
                        if (b == 8) {
                            b(c);
                        } else {
                            a(c);
                        }
                        j();
                    }
                    if (c.mShouldAutoSpeedup && !c.mHasVipChannelSpeedup && l.h()) {
                        if (r1.j) {
                            r1.j = false;
                            n.a().n();
                        }
                        g.a().b(new long[]{c.getTaskId()});
                    }
                    if (c.getTaskStatus() == 2) {
                        try {
                            if (r1.a.a(c.getTaskId()) == null) {
                                TaskExtraInfo a2 = a.a().a(c.getTaskId());
                                it2 = it;
                                r1.a.a(c.getTaskId(), false);
                                TaskSpeedCountInfo a3 = r1.a.a(c.getTaskId());
                                if (a2 == null || a3 == null) {
                                    j = nanoTime2;
                                    if (c.getTaskStatus() == 8) {
                                        try {
                                            b(c);
                                        } catch (Exception e2) {
                                            e = e2;
                                        }
                                    } else {
                                        try {
                                            a(c);
                                        } catch (Exception e3) {
                                            e = e3;
                                        }
                                    }
                                    vVar = r1.a;
                                    taskId = c.getTaskId();
                                    taskSpeedCountInfo = (TaskSpeedCountInfo) vVar.d.get(Long.valueOf(taskId));
                                    if (taskSpeedCountInfo != null) {
                                        hashSet2 = hashSet;
                                        arrayList2 = arrayList;
                                        try {
                                            if (c.mDownloadSpeed > taskSpeedCountInfo.mHighestSpeed) {
                                                taskSpeedCountInfo.mHighestSpeed = c.mDownloadSpeed;
                                                taskSpeedCountInfo.mTaskId = taskId;
                                                if (c.mExtraInfo == null) {
                                                    c.syncExtraInfo();
                                                }
                                                if (c.mExtraInfo != null) {
                                                    c.mExtraInfo.mMaxDownloadSpeed = taskSpeedCountInfo.mHighestSpeed;
                                                }
                                                a.a();
                                                a.a(taskId, taskSpeedCountInfo.mHighestSpeed);
                                            }
                                        } catch (Exception e4) {
                                            e = e4;
                                            collection = e;
                                            collection.printStackTrace();
                                            if (c.getTaskStatus() == 2) {
                                                try {
                                                    if (!c.isTaskInvisible()) {
                                                        aVar3 = vVar.b;
                                                        aVar3.a += c.mDownloadSpeed;
                                                        aVar = vVar.b;
                                                        aVar.b += c.mVipChannelSpeed + c.mDcdnSpeed;
                                                    }
                                                } catch (Exception e5) {
                                                    exception = e5;
                                                    collection = hashSet2;
                                                }
                                            }
                                            c.mRunningInfo.a = false;
                                            if (i2 != b) {
                                                if (i2 == 8) {
                                                    a(c);
                                                }
                                                j();
                                                if (b != 16) {
                                                    collection = hashSet2;
                                                    a(c, b, i2);
                                                    collection.add(Long.valueOf(a));
                                                    arrayList3 = arrayList2;
                                                    arrayList3.add(c);
                                                    arrayList = arrayList3;
                                                    collection2 = collection;
                                                    it = it2;
                                                    nanoTime2 = j;
                                                } else {
                                                    if (b != 2) {
                                                        i = 1;
                                                        if (b == 1) {
                                                        }
                                                    } else {
                                                        i = 1;
                                                    }
                                                    collection = hashSet2;
                                                    try {
                                                        collection.add(Long.valueOf(a));
                                                        arrayList3 = arrayList2;
                                                        arrayList3.add(c);
                                                        arrayList = arrayList3;
                                                        collection2 = collection;
                                                        it = it2;
                                                        nanoTime2 = j;
                                                    } catch (Exception e6) {
                                                        e5 = e6;
                                                    }
                                                }
                                            }
                                            collection = hashSet2;
                                            arrayList3 = arrayList2;
                                            arrayList3.add(c);
                                            arrayList = arrayList3;
                                            collection2 = collection;
                                            it = it2;
                                            nanoTime2 = j;
                                        }
                                    } else {
                                        hashSet2 = hashSet;
                                        arrayList2 = arrayList;
                                    }
                                    if (c.getTaskStatus() == 8) {
                                        vVar.d.remove(Long.valueOf(taskId));
                                    }
                                    if (c.getTaskStatus() == 2) {
                                        if (c.isTaskInvisible()) {
                                            aVar3 = vVar.b;
                                            aVar3.a += c.mDownloadSpeed;
                                            aVar = vVar.b;
                                            aVar.b += c.mVipChannelSpeed + c.mDcdnSpeed;
                                        }
                                    }
                                    c.mRunningInfo.a = false;
                                    if (i2 != b) {
                                        if (i2 == 8) {
                                            a(c);
                                        }
                                        j();
                                        if (!(b == 8 || b == 4)) {
                                            if (b != 16) {
                                                if (b != 2) {
                                                    i = 1;
                                                    if (b == 1) {
                                                    }
                                                } else {
                                                    i = 1;
                                                }
                                                if (!(i2 == 2 || i2 == r3)) {
                                                    collection = hashSet2;
                                                    collection.add(Long.valueOf(a));
                                                    arrayList3 = arrayList2;
                                                    arrayList3.add(c);
                                                    arrayList = arrayList3;
                                                    collection2 = collection;
                                                    it = it2;
                                                    nanoTime2 = j;
                                                }
                                            }
                                        }
                                        collection = hashSet2;
                                        a(c, b, i2);
                                        collection.add(Long.valueOf(a));
                                        arrayList3 = arrayList2;
                                        arrayList3.add(c);
                                        arrayList = arrayList3;
                                        collection2 = collection;
                                        it = it2;
                                        nanoTime2 = j;
                                    }
                                    collection = hashSet2;
                                    arrayList3 = arrayList2;
                                    arrayList3.add(c);
                                    arrayList = arrayList3;
                                    collection2 = collection;
                                    it = it2;
                                    nanoTime2 = j;
                                } else {
                                    j = nanoTime2;
                                    a3.mHighestSpeed = Math.max(a2.mMaxDownloadSpeed, a3.mHighestSpeed);
                                    if (c.getTaskStatus() == 8) {
                                        a(c);
                                    } else {
                                        b(c);
                                    }
                                    vVar = r1.a;
                                    taskId = c.getTaskId();
                                    taskSpeedCountInfo = (TaskSpeedCountInfo) vVar.d.get(Long.valueOf(taskId));
                                    if (taskSpeedCountInfo != null) {
                                        hashSet2 = hashSet;
                                        arrayList2 = arrayList;
                                    } else {
                                        hashSet2 = hashSet;
                                        arrayList2 = arrayList;
                                        if (c.mDownloadSpeed > taskSpeedCountInfo.mHighestSpeed) {
                                            taskSpeedCountInfo.mHighestSpeed = c.mDownloadSpeed;
                                            taskSpeedCountInfo.mTaskId = taskId;
                                            if (c.mExtraInfo == null) {
                                                c.syncExtraInfo();
                                            }
                                            if (c.mExtraInfo != null) {
                                                c.mExtraInfo.mMaxDownloadSpeed = taskSpeedCountInfo.mHighestSpeed;
                                            }
                                            a.a();
                                            a.a(taskId, taskSpeedCountInfo.mHighestSpeed);
                                        }
                                    }
                                    if (c.getTaskStatus() == 8) {
                                        vVar.d.remove(Long.valueOf(taskId));
                                    }
                                    if (c.getTaskStatus() == 2) {
                                        if (c.isTaskInvisible()) {
                                            aVar3 = vVar.b;
                                            aVar3.a += c.mDownloadSpeed;
                                            aVar = vVar.b;
                                            aVar.b += c.mVipChannelSpeed + c.mDcdnSpeed;
                                        }
                                    }
                                    c.mRunningInfo.a = false;
                                    if (i2 != b) {
                                        if (i2 == 8) {
                                            a(c);
                                        }
                                        j();
                                        if (b != 16) {
                                            if (b != 2) {
                                                i = 1;
                                            } else {
                                                i = 1;
                                                if (b == 1) {
                                                }
                                            }
                                            collection = hashSet2;
                                            collection.add(Long.valueOf(a));
                                            arrayList3 = arrayList2;
                                            arrayList3.add(c);
                                            arrayList = arrayList3;
                                            collection2 = collection;
                                            it = it2;
                                            nanoTime2 = j;
                                        } else {
                                            collection = hashSet2;
                                            a(c, b, i2);
                                            collection.add(Long.valueOf(a));
                                            arrayList3 = arrayList2;
                                            arrayList3.add(c);
                                            arrayList = arrayList3;
                                            collection2 = collection;
                                            it = it2;
                                            nanoTime2 = j;
                                        }
                                    }
                                    collection = hashSet2;
                                    arrayList3 = arrayList2;
                                    arrayList3.add(c);
                                    arrayList = arrayList3;
                                    collection2 = collection;
                                    it = it2;
                                    nanoTime2 = j;
                                }
                            }
                        } catch (Exception e7) {
                            e5 = e7;
                            j = nanoTime2;
                        }
                    }
                    j = nanoTime2;
                    it2 = it;
                    if (c.getTaskStatus() == 8) {
                        b(c);
                    } else {
                        a(c);
                    }
                    vVar = r1.a;
                    try {
                        taskId = c.getTaskId();
                        taskSpeedCountInfo = (TaskSpeedCountInfo) vVar.d.get(Long.valueOf(taskId));
                        if (taskSpeedCountInfo != null) {
                            hashSet2 = hashSet;
                            arrayList2 = arrayList;
                            if (c.mDownloadSpeed > taskSpeedCountInfo.mHighestSpeed) {
                                taskSpeedCountInfo.mHighestSpeed = c.mDownloadSpeed;
                                taskSpeedCountInfo.mTaskId = taskId;
                                if (c.mExtraInfo == null) {
                                    c.syncExtraInfo();
                                }
                                if (c.mExtraInfo != null) {
                                    c.mExtraInfo.mMaxDownloadSpeed = taskSpeedCountInfo.mHighestSpeed;
                                }
                                a.a();
                                a.a(taskId, taskSpeedCountInfo.mHighestSpeed);
                            }
                        } else {
                            hashSet2 = hashSet;
                            arrayList2 = arrayList;
                        }
                        if (c.getTaskStatus() == 8) {
                            vVar.d.remove(Long.valueOf(taskId));
                        }
                    } catch (Exception e8) {
                        e5 = e8;
                        hashSet2 = hashSet;
                        arrayList2 = arrayList;
                        collection = e5;
                        collection.printStackTrace();
                        if (c.getTaskStatus() == 2) {
                            if (c.isTaskInvisible()) {
                                aVar3 = vVar.b;
                                aVar3.a += c.mDownloadSpeed;
                                aVar = vVar.b;
                                aVar.b += c.mVipChannelSpeed + c.mDcdnSpeed;
                            }
                        }
                        c.mRunningInfo.a = false;
                        if (i2 != b) {
                            if (i2 == 8) {
                                a(c);
                            }
                            j();
                            if (b != 16) {
                                if (b != 2) {
                                    i = 1;
                                } else {
                                    i = 1;
                                    if (b == 1) {
                                    }
                                }
                                collection = hashSet2;
                                collection.add(Long.valueOf(a));
                                arrayList3 = arrayList2;
                                arrayList3.add(c);
                                arrayList = arrayList3;
                                collection2 = collection;
                                it = it2;
                                nanoTime2 = j;
                            } else {
                                collection = hashSet2;
                                a(c, b, i2);
                                collection.add(Long.valueOf(a));
                                arrayList3 = arrayList2;
                                arrayList3.add(c);
                                arrayList = arrayList3;
                                collection2 = collection;
                                it = it2;
                                nanoTime2 = j;
                            }
                        }
                        collection = hashSet2;
                        arrayList3 = arrayList2;
                        arrayList3.add(c);
                        arrayList = arrayList3;
                        collection2 = collection;
                        it = it2;
                        nanoTime2 = j;
                    }
                    if (c.getTaskStatus() == 2) {
                        if (c.isTaskInvisible()) {
                            aVar3 = vVar.b;
                            aVar3.a += c.mDownloadSpeed;
                            aVar = vVar.b;
                            aVar.b += c.mVipChannelSpeed + c.mDcdnSpeed;
                        }
                    }
                    try {
                        c.mRunningInfo.a = false;
                        if (i2 != b) {
                            if (i2 == 8) {
                                a(c);
                            }
                            j();
                            if (b != 16) {
                                collection = hashSet2;
                                a(c, b, i2);
                                collection.add(Long.valueOf(a));
                                arrayList3 = arrayList2;
                                arrayList3.add(c);
                                arrayList = arrayList3;
                                collection2 = collection;
                                it = it2;
                                nanoTime2 = j;
                            } else {
                                if (b != 2) {
                                    i = 1;
                                    if (b == 1) {
                                    }
                                } else {
                                    i = 1;
                                }
                                collection = hashSet2;
                                collection.add(Long.valueOf(a));
                                arrayList3 = arrayList2;
                                arrayList3.add(c);
                                arrayList = arrayList3;
                                collection2 = collection;
                                it = it2;
                                nanoTime2 = j;
                            }
                        }
                        collection = hashSet2;
                        arrayList3 = arrayList2;
                        arrayList3.add(c);
                        arrayList = arrayList3;
                        collection2 = collection;
                        it = it2;
                        nanoTime2 = j;
                    } catch (Exception e9) {
                        e5 = e9;
                        collection = hashSet2;
                    }
                }
                j = nanoTime2;
                collection = hashSet;
                List list2 = arrayList;
                com.xunlei.downloadprovider.download.c.a.a().b(list2);
                r1.y.a(list2);
            }
        } catch (Exception e10) {
            e5 = e10;
            j = nanoTime2;
            collection = hashSet;
            exception = e5;
            exception.printStackTrace();
            vVar = r1.a;
            vVar.c = SystemClock.elapsedRealtime();
            aVar2 = vVar.a;
            aVar = vVar.b;
            aVar2.a = aVar.a;
            aVar2.b = aVar.b;
            r1.z = l();
            a((List) list);
            h.b((List) list);
            if (!collection.isEmpty()) {
                r1.f.b(collection);
            }
            nanoTime = (System.nanoTime() - j) / 1000000;
            stringBuilder = new StringBuilder("processCoreTaskListUpdate: cost = ");
            stringBuilder.append(nanoTime);
            stringBuilder.append("ms, size =  ");
            stringBuilder.append(list.size());
            k();
        }
        vVar = r1.a;
        vVar.c = SystemClock.elapsedRealtime();
        aVar2 = vVar.a;
        aVar = vVar.b;
        aVar2.a = aVar.a;
        aVar2.b = aVar.b;
        r1.z = l();
        a((List) list);
        h.b((List) list);
        if (collection.isEmpty()) {
            r1.f.b(collection);
        }
        nanoTime = (System.nanoTime() - j) / 1000000;
        stringBuilder = new StringBuilder("processCoreTaskListUpdate: cost = ");
        stringBuilder.append(nanoTime);
        stringBuilder.append("ms, size =  ");
        stringBuilder.append(list.size());
        k();
        exception = e5;
        collection = hashSet;
        exception.printStackTrace();
        vVar = r1.a;
        vVar.c = SystemClock.elapsedRealtime();
        aVar2 = vVar.a;
        aVar = vVar.b;
        aVar2.a = aVar.a;
        aVar2.b = aVar.b;
        r1.z = l();
        a((List) list);
        h.b((List) list);
        if (collection.isEmpty()) {
            r1.f.b(collection);
        }
        nanoTime = (System.nanoTime() - j) / 1000000;
        stringBuilder = new StringBuilder("processCoreTaskListUpdate: cost = ");
        stringBuilder.append(nanoTime);
        stringBuilder.append("ms, size =  ");
        stringBuilder.append(list.size());
        k();
    }

    private void c(TaskInfo taskInfo) {
        try {
            if (taskInfo.mExtraInfo == null) {
                TaskExtraInfo a = this.h.a(taskInfo.getTaskId());
                if (a != null) {
                    taskInfo.setSeenFlag(a.mSeen);
                    taskInfo.mCreateOrigin = a.mCreateOrigin;
                    taskInfo.mSniffKeyword = a.mSniffKeyword;
                    if (TextUtils.isEmpty(taskInfo.mWebsiteName)) {
                        taskInfo.mWebsiteName = a.mWebsiteName;
                    }
                    taskInfo.mIconUrl = a.mIconUrl;
                    if (TextUtils.isEmpty(taskInfo.mDisplayName)) {
                        taskInfo.mDisplayName = a.mDisplayName;
                    }
                    if (TextUtils.isEmpty(taskInfo.mRefUrl)) {
                        taskInfo.mRefUrl = a.mRefUrl;
                    }
                    taskInfo.mExtraInfo = a;
                    taskInfo.syncExtraInfo();
                }
            }
        } catch (TaskInfo taskInfo2) {
            taskInfo2.printStackTrace();
        }
    }

    public final void c() {
        this.d = false;
        try {
            e eVar = new e();
            DownloadManager$Query downloadManager$Query = new DownloadManager$Query();
            downloadManager$Query.setFilterByStatus(31);
            downloadManager$Query.orderBy("_id", 2);
            String[] projection = downloadManager$Query.getProjection();
            String selection = downloadManager$Query.getSelection();
            String[] selectionArgs = downloadManager$Query.getSelectionArgs();
            String sortOrder = downloadManager$Query.getSortOrder();
            Cursor query = this.y.f().getContentResolver().query(this.y.f, projection, selection, selectionArgs, sortOrder);
            eVar.a(query);
            if (query != null) {
                while (query.moveToNext()) {
                    long j = query.getLong(eVar.a);
                    a h = h(j);
                    if (h != null) {
                        o.a(h.c, query, eVar);
                    } else {
                        TaskInfo taskInfo = new TaskInfo();
                        taskInfo.setTaskId(j);
                        a aVar = new a(j, taskInfo);
                        a(aVar);
                        o.a(taskInfo, query, eVar);
                        b(aVar);
                        aVar.i();
                        taskInfo.mRunningInfo.a = false;
                        j();
                        h = aVar;
                    }
                    c(h.c);
                    a(h.c);
                }
                query.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        c(true);
        this.d = true;
        k();
        com.xunlei.downloadprovider.download.engine.task.g a = com.xunlei.downloadprovider.download.engine.task.g.a();
        Collection<z> g = super.g(100);
        new StringBuilder("onInvisibleTasksLoaded: ").append(g.size());
        if (!g.isEmpty()) {
            for (z zVar : g) {
                StringBuilder stringBuilder;
                if (zVar.d()) {
                    boolean z;
                    long currentTimeMillis = System.currentTimeMillis() - zVar.c().mCreateTime;
                    if (zVar.d()) {
                        if (currentTimeMillis < 604800000) {
                            if (zVar.b() == 8 && currentTimeMillis >= 172800000) {
                            }
                        }
                        z = true;
                        if (z) {
                            stringBuilder = new StringBuilder("onInvisibleTasksLoaded - ");
                            stringBuilder.append(zVar.a());
                            stringBuilder.append(" deleted : ");
                            stringBuilder.append(zVar.c().mTitle);
                            a.a(zVar.a());
                            a.a.a((int) zVar.a());
                            n.a().c(false, new long[]{zVar.a()});
                        }
                    }
                    z = false;
                    if (z) {
                        stringBuilder = new StringBuilder("onInvisibleTasksLoaded - ");
                        stringBuilder.append(zVar.a());
                        stringBuilder.append(" deleted : ");
                        stringBuilder.append(zVar.c().mTitle);
                        a.a(zVar.a());
                        a.a.a((int) zVar.a());
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
        if (!g.isEmpty()) {
            for (z zVar2 : g) {
                if (zVar2.b() != 4) {
                    if (zVar2.b() != 16) {
                        if (zVar2.b() == 8) {
                            a.a(zVar2.a());
                            a.c(zVar2.c());
                        }
                    }
                }
                n.a();
                n.b(false, new long[]{zVar2.a()});
            }
            a.b(g);
        }
        com.xunlei.downloadprovider.download.engine.task.a.a();
        com.xunlei.downloadprovider.download.engine.task.a.a(a(Collections.unmodifiableSet(com.xunlei.downloadprovider.download.engine.task.a.a().a)));
        h.a();
        h.b();
    }

    public final TaskInfo b(long j) {
        if (j == -1) {
            return null;
        }
        a aVar = (a) this.k.get(Long.valueOf(j));
        if (aVar != null) {
            return aVar.c();
        }
        return null;
    }

    public final z c(long j) {
        return j == -1 ? 0 : (z) this.k.get(Long.valueOf(j));
    }

    public final long a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
            String e = com.xunlei.downloadprovider.download.engine.util.b.e(str);
            if (TextUtils.isEmpty(e)) {
                e = str;
            }
            for (a aVar : this.k.values()) {
                if (aVar != null && (str.equals(aVar.c.mUrl) || r0.equals(aVar.c.mUrlEigenvalue))) {
                    return aVar.a();
                }
            }
        }
        return -1;
    }

    public final long b(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (a aVar : this.k.values()) {
                if (aVar != null && (str.equals(aVar.c.mGCID) || (aVar.c.mTaskType == TaskType.BT && str.equals(aVar.c.mInfoHash)))) {
                    return aVar.a();
                }
            }
        }
        return -1;
    }

    public final long c(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
            String e = com.xunlei.downloadprovider.download.engine.util.b.e(str);
            if (TextUtils.isEmpty(e)) {
                e = str;
            }
            for (a aVar : this.k.values()) {
                if (aVar.c.mTaskType == TaskType.BT && (str.equals(aVar.c.mUrl) || r0.equals(aVar.c.mUrlEigenvalue))) {
                    return aVar.c.getTaskId();
                }
            }
        }
        return -1;
    }

    public final com.xunlei.downloadprovider.download.engine.task.info.b a(String str, FindTaskKeyType findTaskKeyType) {
        com.xunlei.downloadprovider.download.engine.task.info.b bVar = null;
        if (FindTaskKeyType.BY_URI == findTaskKeyType) {
            if (TextUtils.isEmpty(str) == null) {
                str = str.trim();
                findTaskKeyType = com.xunlei.downloadprovider.download.engine.util.b.e(str);
                if (TextUtils.isEmpty(findTaskKeyType)) {
                    findTaskKeyType = str;
                }
                for (a aVar : this.k.values()) {
                    if (aVar != null && (str.equals(aVar.c.mUrl) || r7.equals(aVar.c.mUrlEigenvalue))) {
                        bVar = new q(aVar);
                        break;
                    }
                }
            }
            return bVar;
        } else if (FindTaskKeyType.BY_PATH != findTaskKeyType) {
            return null;
        } else {
            if (TextUtils.isEmpty(str) == null) {
                str = str.trim();
                for (a aVar2 : this.k.values()) {
                    if (aVar2 != null) {
                        CharSequence charSequence = aVar2.c.mLocalFileName;
                        if (str.equals(charSequence)) {
                            bVar = new q(aVar2);
                            break;
                        }
                        if (aVar2.c.mTaskType == TaskType.BT && !TextUtils.isEmpty(charSequence) && str.contains(charSequence)) {
                            Object<BTSubTaskInfo> g = aVar2.g();
                            if (!d.a(g)) {
                                for (BTSubTaskInfo bTSubTaskInfo : g) {
                                    if (str.equals(bTSubTaskInfo.mLocalFileName)) {
                                        bVar = new q(aVar2);
                                        bVar.a = bTSubTaskInfo;
                                        break;
                                    }
                                }
                            }
                        }
                        if (bVar != null) {
                            break;
                        }
                    }
                }
            }
            return bVar;
        }
    }

    public final int e() {
        return f().mRunningCount;
    }

    public final TaskCountsStatistics f() {
        return c(false).b.a;
    }

    public final TaskCountsStatistics a(boolean z) {
        if (!z) {
            return f();
        }
        z = c(false).b;
        z.c.copyFrom(z.a);
        z.c.minus(z.b);
        return z.c;
    }

    public final TaskCountsStatistics g() {
        return c(false).a;
    }

    public final List<TaskInfo> h() {
        return Collections.unmodifiableList(this.r);
    }

    public final void a(boolean z, Collection<Long> collection) {
        this.i.removeAll(collection);
        g.a().a(z, com.xunlei.downloadprovider.download.engine.util.b.a((Collection) collection));
    }

    public final void a(Collection<Long> collection, boolean z) {
        if (!z) {
            this.i.addAll(collection);
        }
        g.a().a(com.xunlei.downloadprovider.download.engine.util.b.a((Collection) collection));
    }

    public final void d(long j) {
        j = h(j);
        if (!(j == null || com.xunlei.downloadprovider.download.engine.util.b.f(j.c().mGCID))) {
            com.xunlei.downloadprovider.download.engine.shub.b a = com.xunlei.downloadprovider.download.engine.shub.b.a();
            String taskDownloadUrl = j.c.getTaskDownloadUrl();
            GcidInfo gcidInfo = (GcidInfo) a.a.get(taskDownloadUrl);
            if (gcidInfo != null) {
                if (j != null) {
                    j.a(gcidInfo);
                }
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/file_info/cli_api/hfe_query_gcid?rd=");
            stringBuilder.append(taskDownloadUrl.hashCode());
            b bVar = new b(stringBuilder.toString());
            bVar.a = taskDownloadUrl;
            if (a.b.containsKey(com.xunlei.downloadprovider.download.engine.util.b.e(bVar.a))) {
                j = new StringBuilder("already requesting: ");
                j.append(bVar.d);
                j.append(" url = ");
                j.append(bVar.a);
                return;
            }
            XLThreadPool.execute(new com.xunlei.downloadprovider.download.engine.shub.c(a, bVar, taskDownloadUrl, j));
        }
    }

    public final void a(TaskInfo taskInfo, int i, int i2) {
        synchronized (this.r) {
            if (i != 1) {
                if (i != 2) {
                    this.r.remove(taskInfo);
                    this.q.remove(taskInfo);
                }
            }
            if (taskInfo.isTaskInvisible()) {
                if (!this.q.contains(taskInfo)) {
                    this.q.add(taskInfo);
                }
            } else if (!this.r.contains(taskInfo)) {
                this.r.add(taskInfo);
            }
        }
        taskInfo.setTaskStatus(i);
        if (8 == i) {
            b(taskInfo);
        } else if (16 == i || 4 == i) {
            a(taskInfo);
        }
        StringBuilder stringBuilder = new StringBuilder("taskId = ");
        stringBuilder.append(taskInfo.getTaskId());
        stringBuilder.append(",taskState = ");
        stringBuilder.append(i);
        if (i == 8) {
            this.y.a(taskInfo);
        } else if (i == 16) {
            String str = taskInfo.mCreateOrigin;
            int i3 = taskInfo.mOriginalStatusCode;
            String str2 = taskInfo.mErrorMsg;
            StringBuilder stringBuilder2 = new StringBuilder("report_dl_fail: ");
            stringBuilder2.append(i3);
            stringBuilder2.append(" errorMsg: ");
            stringBuilder2.append(str2);
            StatEvent build = HubbleEventBuilder.build("android_download", "dl_fail");
            String str3 = "from";
            if (str == null) {
                str = "";
            }
            build.add(str3, str);
            if (i3 == 0) {
                str = "fail_type";
                if (str2 == null) {
                    str2 = String.valueOf(i3);
                }
                build.add(str, str2);
            } else {
                build.add("fail_type", i3);
            }
            ThunderReport.reportEvent(build);
        }
        this.y.a(i, taskInfo, i2);
        if (this.g != 0) {
            this.g.a(super.e(taskInfo.getTaskId()));
        }
        taskInfo.mRunningInfo.b = i;
    }

    public final boolean d() {
        if (f().mRunningCount <= 0 && g().getRunningCount() <= 0) {
            if (this.q.size() <= 0) {
                return false;
            }
        }
        return true;
    }

    public final com.xunlei.downloadprovider.download.engine.task.info.c b(boolean z) {
        if (z) {
            return c(false).b.e;
        }
        return c(false).b.d;
    }
}
