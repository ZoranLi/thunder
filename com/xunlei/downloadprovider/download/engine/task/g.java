package com.xunlei.downloadprovider.download.engine.task;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.umeng.message.proguard.k;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ApkHelper.ApkInfo;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.create.af;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.report.a;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.notification.DownloadADNotification;
import com.xunlei.xllib.b.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* compiled from: DownloadAdTaskManager */
public final class g {
    private static g e;
    public DownloadADNotification a = new DownloadADNotification(BrothersApplication.getApplicationInstance());
    public final HashSet<Long> b = new HashSet();
    private final Map<Long, String> c = new HashMap();
    private long d = 0;

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (e == null) {
                e = new g();
            }
            gVar = e;
        }
        return gVar;
    }

    public static boolean a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (taskInfo.isTaskInvisible()) {
                if (taskInfo.getCustomFlags() == 100) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public final void a(long j) {
        this.b.add(Long.valueOf(j));
    }

    public final void b(long j) {
        this.b.remove(Long.valueOf(j));
    }

    final void b(TaskInfo taskInfo) {
        StringBuilder stringBuilder = new StringBuilder("postAdTaskNotification - ");
        stringBuilder.append(taskInfo.getTaskId());
        stringBuilder.append(k.s);
        stringBuilder.append(taskInfo.getTaskStatus());
        stringBuilder.append(") title : ");
        stringBuilder.append(taskInfo.mTitle);
        this.a.a(taskInfo);
    }

    public final void c(TaskInfo taskInfo) {
        ApkInfo apkInfo = ApkHelper.getApkInfo(BrothersApplication.getApplicationInstance(), taskInfo.mLocalFileName);
        if (apkInfo != null) {
            this.c.put(Long.valueOf(taskInfo.getTaskId()), apkInfo.getPackageName());
        }
    }

    public final void a(Collection<z> collection) {
        if (!d.a(collection)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.d >= 1000) {
                b((Collection) collection);
                this.d = currentTimeMillis;
            }
        }
    }

    public final void b(Collection<z> collection) {
        if (!d.a(collection)) {
            new StringBuilder("updateAdTaskRunningStateNotification - ").append(collection.size());
            for (z zVar : collection) {
                StringBuilder stringBuilder = new StringBuilder("updateAdTaskRunningStateNotification: mFileName  --> ");
                stringBuilder.append(zVar.c().mTitle);
                stringBuilder.append(", mFileSize  --> ");
                stringBuilder.append(zVar.c().mFileSize);
                stringBuilder.append(", mDownloadedSize  --> ");
                stringBuilder.append(zVar.c().mDownloadedSize);
                if (!(this.b.contains(Long.valueOf(zVar.a())) || zVar.b() == 17)) {
                    b(zVar.c());
                }
            }
        }
    }

    public static boolean a(android.content.Context r3, com.xunlei.downloadprovider.download.engine.task.info.TaskInfo r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r4 = r4.mLocalFileName;
        r1 = ".apk";
        r2 = com.xunlei.common.businessutil.XLFileTypeUtil.extractFileExt(r4);
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0013;
    L_0x0012:
        return r0;
    L_0x0013:
        r1 = new java.io.File;	 Catch:{ Exception -> 0x0024 }
        r1.<init>(r4);	 Catch:{ Exception -> 0x0024 }
        r4 = r1.exists();	 Catch:{ Exception -> 0x0024 }
        if (r4 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x0024 }
    L_0x001e:
        return r0;	 Catch:{ Exception -> 0x0024 }
    L_0x001f:
        com.xunlei.common.androidutil.ApkHelper.installApk(r3, r1);	 Catch:{ Exception -> 0x0024 }
        r3 = 1;
        return r3;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.g.a(android.content.Context, com.xunlei.downloadprovider.download.engine.task.info.TaskInfo):boolean");
    }

    public final void a(String str) {
        int i;
        for (Long longValue : this.c.keySet()) {
            String str2 = (String) this.c.get(Long.valueOf(longValue.longValue()));
            if (str2 != null && str2.equals(str)) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i != 0) {
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            ResolveInfo resolveInfo = null;
            try {
                str = applicationInstance.getPackageManager().getPackageInfo(str, 0);
            } catch (String str3) {
                str3.printStackTrace();
                str3 = null;
            }
            if (str3 != null) {
                Intent intent = new Intent("android.intent.action.MAIN", null);
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setPackage(str3.packageName);
                str3 = applicationInstance.getPackageManager().queryIntentActivities(intent, 0);
                if (str3 != null && str3.iterator().hasNext()) {
                    resolveInfo = (ResolveInfo) str3.iterator().next();
                }
                if (resolveInfo != null) {
                    ComponentName componentName = new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
                    str3 = new Intent("android.intent.action.MAIN");
                    str3.addCategory("android.intent.category.LAUNCHER");
                    str3.setFlags(268435456);
                    str3.setComponent(componentName);
                    applicationInstance.startActivity(str3);
                }
            }
        }
    }

    public static void a(String str, String str2, @NonNull TaskStatInfo taskStatInfo, @Nullable DownloadAdditionInfo downloadAdditionInfo) {
        c cVar;
        String str3 = taskStatInfo.a;
        a.a(str3);
        m mVar = new m();
        mVar.a(str, str2, 0, null, str3, downloadAdditionInfo);
        if (com.xunlei.downloadprovider.d.d.a().p.a() != null) {
            mVar.a(100);
            mVar.a(true);
            cVar = null;
        } else {
            mVar.a(null);
            cVar = af.a().a;
        }
        mVar.b = taskStatInfo;
        n.a().a(mVar, cVar);
    }
}
