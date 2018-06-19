package com.xunlei.downloadprovider.download.engine.task.a;

import android.database.Cursor;
import android.util.LruCache;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.download.engine.kernel.e;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.info.TaskBasicInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import java.util.ArrayList;

/* compiled from: DownloadListCursorWrapper */
public final class o {
    protected static final LruCache<Long, TaskBasicInfo> a = new LruCache(1000);
    public Cursor b;
    final e c = new e();
    final ArrayList<TaskBasicInfo> d = new ArrayList();

    public static boolean a() {
        return true;
    }

    public o(Cursor cursor) {
        this.b = cursor;
        if (cursor != null) {
            this.c.a(cursor);
        }
        b();
    }

    private void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r6.b;	 Catch:{ Exception -> 0x0041 }
    L_0x000c:
        r2 = r1.moveToNext();	 Catch:{ Exception -> 0x0041 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x0041 }
    L_0x0012:
        r2 = r6.c;	 Catch:{ Exception -> 0x0041 }
        r2 = a(r1, r2);	 Catch:{ Exception -> 0x0041 }
        r4 = a;	 Catch:{ Exception -> 0x0041 }
        r5 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0041 }
        r4 = r4.get(r5);	 Catch:{ Exception -> 0x0041 }
        r4 = (com.xunlei.downloadprovider.download.engine.task.info.TaskBasicInfo) r4;	 Catch:{ Exception -> 0x0041 }
        if (r4 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x0041 }
    L_0x0026:
        r4 = new com.xunlei.downloadprovider.download.engine.task.info.TaskBasicInfo;	 Catch:{ Exception -> 0x0041 }
        r4.<init>();	 Catch:{ Exception -> 0x0041 }
        r5 = a;	 Catch:{ Exception -> 0x0041 }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0041 }
        r5.put(r2, r4);	 Catch:{ Exception -> 0x0041 }
    L_0x0034:
        r2 = r6.c;	 Catch:{ Exception -> 0x0041 }
        a(r4, r1, r2);	 Catch:{ Exception -> 0x0041 }
        r0.add(r4);	 Catch:{ Exception -> 0x0041 }
        goto L_0x000c;	 Catch:{ Exception -> 0x0041 }
    L_0x003d:
        r2 = -1;	 Catch:{ Exception -> 0x0041 }
        r1.moveToPosition(r2);	 Catch:{ Exception -> 0x0041 }
    L_0x0041:
        r1 = r6.d;
        r1.clear();
        r1 = r6.d;
        r1.addAll(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.o.b():void");
    }

    static void a(TaskInfo taskInfo, Cursor cursor, e eVar) {
        a((TaskBasicInfo) taskInfo, cursor, eVar);
        TaskInfo.calculateTaskRunningData(taskInfo);
    }

    private static long a(android.database.Cursor r0, com.xunlei.downloadprovider.download.engine.kernel.e r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r1.a;	 Catch:{ Exception -> 0x0007 }
        r0 = r0.getLong(r1);	 Catch:{ Exception -> 0x0007 }
        goto L_0x0009;
    L_0x0007:
        r0 = -1;
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.o.a(android.database.Cursor, com.xunlei.downloadprovider.download.engine.kernel.e):long");
    }

    private static void a(TaskBasicInfo taskBasicInfo, Cursor cursor, e eVar) {
        taskBasicInfo.setTaskId(cursor.getLong(eVar.a));
        taskBasicInfo.mTitle = cursor.getString(eVar.d);
        taskBasicInfo.mLocalFileName = cursor.getString(eVar.i);
        taskBasicInfo.mFileSize = cursor.getLong(eVar.f);
        taskBasicInfo.mCID = cursor.getString(eVar.b);
        taskBasicInfo.mGCID = cursor.getString(eVar.c);
        taskBasicInfo.mUrl = cursor.getString(eVar.e);
        taskBasicInfo.mCreateTime = cursor.getLong(eVar.j);
        taskBasicInfo.mLastModifiedTime = cursor.getLong(eVar.k);
        taskBasicInfo.mDownloadDurationTime = cursor.getLong(eVar.l);
        taskBasicInfo.mTaskType = TaskType.values()[cursor.getInt(eVar.h)];
        if (taskBasicInfo.mTaskType == TaskType.BT) {
            taskBasicInfo.mInfoHash = cursor.getString(eVar.H);
        }
        int i = cursor.getInt(eVar.g);
        taskBasicInfo.mOriginalStatusCode = i;
        taskBasicInfo.setTaskStatus(DownloadManager.translateStatus(i));
        taskBasicInfo.mFailureReason = DownloadManager.getReason(i);
        taskBasicInfo.mErrorMsg = cursor.getString(eVar.m);
        taskBasicInfo.mResLinkTotal = (long) cursor.getInt(eVar.F);
        taskBasicInfo.mResLinkUsed = (long) cursor.getInt(eVar.G);
        taskBasicInfo.mDownloadedSize = cursor.getLong(eVar.q);
        taskBasicInfo.mDownloadSpeed = cursor.getLong(eVar.r);
        taskBasicInfo.mOriginSpeed = cursor.getLong(eVar.t);
        taskBasicInfo.mOriginReceivedSize = cursor.getLong(eVar.s);
        taskBasicInfo.mP2spSpeed = cursor.getLong(eVar.w);
        taskBasicInfo.mP2spSpeed += cursor.getLong(eVar.u);
        taskBasicInfo.mP2spReceivedSize = cursor.getLong(eVar.x);
        taskBasicInfo.mP2spReceivedSize += cursor.getLong(eVar.v);
        boolean z = false;
        taskBasicInfo.mHasVipChannelSpeedup = cursor.getInt(eVar.y) == 1;
        String str = g.a;
        new StringBuilder("  vipChannelSpeedUp:  ").append(taskBasicInfo.mHasVipChannelSpeedup);
        taskBasicInfo.mVipChannelSpeed = cursor.getLong(eVar.B);
        taskBasicInfo.mVipChannelStatusCode = cursor.getInt(eVar.A);
        taskBasicInfo.mVipChannelStatus = DownloadManager.translateStatus(cursor.getInt(eVar.z));
        taskBasicInfo.mVipChannelReceivedSize = cursor.getLong(eVar.C);
        if (eVar.D != -1) {
            taskBasicInfo.mDcdnSpeed = cursor.getLong(eVar.D);
            taskBasicInfo.mDcdnReceivedSize = cursor.getLong(eVar.E);
        }
        if (eVar.o != -1) {
            if (cursor.getInt(eVar.o) == 0) {
                z = true;
            }
            taskBasicInfo.setTaskInvisible(z);
        }
        if (eVar.p != -1) {
            taskBasicInfo.setCustomFlags(cursor.getLong(eVar.p));
        }
        taskBasicInfo.setRangeInfoStr(cursor.getString(eVar.I));
    }
}
