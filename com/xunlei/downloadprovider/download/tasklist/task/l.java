package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.SystemClock;
import com.xunlei.downloadprovider.download.engine.task.a.t.a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: TaskListManager */
final class l extends a<List<s>> {
    final /* synthetic */ boolean a;
    final /* synthetic */ h c;

    l(h hVar, List list, boolean z) {
        this.c = hVar;
        this.a = z;
        super(list);
    }

    public final /* synthetic */ void a(Object obj) {
        long j;
        List<s> list = (List) obj;
        this.c.o.removeMessages(0);
        this.c.o.sendEmptyMessageDelayed(0, 2000);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.c.m.c == 0) {
            r1.c.m.c = elapsedRealtime;
        }
        HashSet hashSet = new HashSet(r1.c.b.keySet());
        if (list.isEmpty()) {
            j = elapsedRealtime;
        } else {
            boolean z = false;
            boolean z2 = z;
            long j2 = 0;
            long j3 = j2;
            for (s sVar : list) {
                boolean z3;
                long j4;
                j = elapsedRealtime;
                hashSet.remove(Long.valueOf(sVar.a()));
                sVar.k();
                DownloadTaskInfo downloadTaskInfo = sVar.b;
                int i = downloadTaskInfo.mRunningInfo.c;
                if (i != -1 && downloadTaskInfo.mRunningInfo.a()) {
                    downloadTaskInfo.mRunningInfo.a(-1);
                    downloadTaskInfo.mRevision++;
                    i = -1;
                }
                int taskStatus = downloadTaskInfo.getTaskStatus();
                if (taskStatus != 4) {
                    switch (taskStatus) {
                        case 1:
                        case 2:
                            if (i != 2) {
                                z3 = true;
                                if (i == 1) {
                                }
                            } else {
                                z3 = true;
                            }
                            downloadTaskInfo.mRunningInfo.c = -1;
                            downloadTaskInfo.mRevision += z3;
                            break;
                        default:
                            z3 = true;
                            break;
                    }
                }
                z3 = true;
                if (i == 4) {
                    downloadTaskInfo.mRunningInfo.c = -1;
                    downloadTaskInfo.mRevision++;
                }
                if (sVar.b() == 2) {
                    int i2;
                    if (sVar.b.mHasVipChannelSpeedup) {
                        i2 = z3;
                        j4 = 0;
                    } else {
                        j4 = 0;
                        i2 = sVar.b.mDcdnSpeed > 0 ? z3 : 0;
                    }
                    if (i2 != 0) {
                        z2 = z3;
                    }
                    j3 += sVar.b.mVipAcceleratedSpeed;
                    z = z3;
                    j2 += sVar.b.mDownloadSpeed;
                } else {
                    j4 = 0;
                }
                elapsedRealtime = j;
                long j5 = j4;
            }
            j = elapsedRealtime;
            h.a(r1.c, j, z, z2, j2, j3);
            r1.c.l.execute(new m(r1, list));
        }
        List arrayList = new ArrayList();
        if (!hashSet.isEmpty()) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                s sVar2 = (s) r1.c.b.remove((Long) it.next());
                if (sVar2 != null) {
                    arrayList.add(sVar2.b);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            r1.c.d(arrayList);
        }
        try {
            r1.c.c.a((List) list, r1.a);
            r1.c.d.a((List) list, r1.a);
            r1.c.e.a((List) list, r1.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        elapsedRealtime = SystemClock.elapsedRealtime() - j;
        String str = h.a;
        StringBuilder stringBuilder = new StringBuilder("UpdateTaskInfoList: cost = ");
        stringBuilder.append(elapsedRealtime);
        stringBuilder.append("ms, size =  ");
        stringBuilder.append(list.size());
        if (r1.c.j != null) {
            r1.c.j.a();
        }
    }
}
