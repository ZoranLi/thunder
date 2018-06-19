package com.xunlei.downloadprovider.download.engine.task;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.taobao.accs.utl.UTMini;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.downloadprovider.download.engine.kernel.d;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.a.b;
import com.xunlei.downloadprovider.download.engine.task.a.p;
import com.xunlei.downloadprovider.download.engine.task.a.w;
import com.xunlei.downloadprovider.download.engine.task.info.FindTaskKeyType;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.downloadprovider.service.DownloadService.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: DownloadTaskManager */
public class n extends b {
    private static final String f = "n";
    private static n g = new n();
    public ExecutorService a = Executors.newSingleThreadExecutor();
    private volatile a h = null;

    /* compiled from: DownloadTaskManager */
    private static class a {
        long a;
        String b;
        String c;
        boolean d;

        public a(long j, String str, String str2, boolean z) {
            this.a = j;
            this.b = str;
            this.c = str2;
            this.d = z;
        }
    }

    public static n a() {
        return g;
    }

    public static void a(Context context) {
        DownloadConfig.initDefaultDownloadPath(context);
        g.a().b(context);
        context = g.a();
        if (context.b != null) {
            if (context.c != null) {
                long[] a = g.a(new d(context.c, context.b).a());
                if (a.length > 0) {
                    context.a(a);
                }
            }
        }
    }

    public static boolean b() {
        return DownloadService.a() != null;
    }

    public static void a(c cVar) {
        DownloadService.a(cVar);
    }

    public static boolean c() {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? false : a.b().a().d();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d() {
        /*
        r0 = com.xunlei.downloadprovider.service.DownloadService.a();
        r1 = 0;
        if (r0 == 0) goto L_0x0022;
    L_0x0007:
        r2 = r0.b();
        r2 = r2.a();
        if (r2 == 0) goto L_0x0022;
    L_0x0011:
        r0 = r0.b();
        r0 = r0.a();
        r0 = r0.e();
        if (r0 <= 0) goto L_0x0021;
    L_0x001f:
        r0 = 1;
        return r0;
    L_0x0021:
        return r1;
    L_0x0022:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.n.d():boolean");
    }

    public static long e() {
        DownloadService a = DownloadService.a();
        return a != null ? a.b().a.j() : 0;
    }

    public static long[] a(long j, int i) {
        j = e(j);
        return j != null ? j.a(i) : 0;
    }

    public static void a(String str) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            a.b().a.a(str);
        }
    }

    public static boolean a(List<Long> list) {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        k b = a.b();
        w wVar = new w(1);
        wVar.b = list;
        b.a.a(wVar);
        return false;
    }

    public static boolean a(com.xunlei.downloadprovider.ipc.b bVar) {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        k b = a.b();
        if (b.a == null) {
            return false;
        }
        w wVar = new w(5);
        wVar.c = bVar;
        wVar.f = false;
        return b.a.a(wVar);
    }

    public static boolean f() {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        k b = a.b();
        if (b.a == null) {
            return false;
        }
        w wVar = new w(5);
        wVar.f = true;
        return b.a.a(wVar);
    }

    private static boolean a(Collection<Long> collection) {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return g.a().a(com.xunlei.downloadprovider.download.engine.util.b.a(collection)) > null;
        } else {
            k b = a.b();
            if (b.a == null) {
                return false;
            }
            w wVar = new w(4);
            wVar.b = collection;
            wVar.f = true;
            return b.a.a(wVar);
        }
    }

    public static boolean a(long... jArr) {
        Collection hashSet = new HashSet();
        if (jArr.length > 0) {
            for (long valueOf : jArr) {
                hashSet.add(Long.valueOf(valueOf));
            }
        }
        return a(hashSet);
    }

    public static boolean a(boolean z, long... jArr) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            Collection hashSet = new HashSet();
            for (int i = 0; i <= 0; i++) {
                hashSet.add(Long.valueOf(jArr[0]));
            }
            jArr = new w(3);
            jArr.b = hashSet;
            jArr.e = z;
            return a.b().a(jArr);
        } else if (g.a().c(z, jArr) <= false) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean b(boolean z, long... jArr) {
        DownloadService a = DownloadService.a();
        int i = 0;
        if (a == null) {
            return g.a().a(z, jArr) <= false;
        } else {
            Collection hashSet = new HashSet();
            if (jArr.length > 0) {
                int length = jArr.length;
                while (i < length) {
                    hashSet.add(Long.valueOf(jArr[i]));
                    i++;
                }
            }
            jArr = new w(1);
            jArr.b = hashSet;
            jArr.e = z;
            return a.b().a(jArr);
        }
    }

    public static boolean a(boolean z) {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        w wVar = new w(2);
        wVar.e = z;
        return a.b().a(wVar);
    }

    public final boolean b(long... jArr) {
        return c(false, jArr);
    }

    public final boolean c(boolean z, long... jArr) {
        DownloadService a = DownloadService.a();
        Collection hashSet = new HashSet();
        boolean z2 = false;
        if (jArr != null && jArr.length > 0) {
            for (long valueOf : jArr) {
                hashSet.add(Long.valueOf(valueOf));
            }
        }
        if (a != null) {
            jArr = new w(6);
            jArr.b = hashSet;
            jArr.d = z;
            return a.b().a(jArr);
        }
        if (g.a().b(z, jArr) <= false) {
            z2 = true;
        }
        this.c.a(hashSet);
        return z2;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        w wVar = new w(7);
        wVar.g = str;
        wVar.d = false;
        return a.b().a(wVar);
    }

    public static void a(long j, long[] jArr) {
        g.b().selectBtSubTask(j, jArr);
    }

    public static int c(long... jArr) {
        g a = g.a();
        if (a.b == null) {
            return null;
        }
        a.b.setProperty(DownloadManager$Property.PROP_PRODUCT_ID, "1");
        return a.b.openVIPSpeedUp(jArr);
    }

    public static void g() {
        DownloadService a = DownloadService.a();
        if (a != null) {
            k b = a.b();
            if (b.a != null) {
                b.a.a();
            }
        }
    }

    public static void a(long j) {
        g.a().b(j);
    }

    public static void b(long j) {
        if (j > 0) {
            j = f(j);
            if (j != null) {
                DownloadService a = DownloadService.a();
                if (a != null) {
                    k b = a.b();
                    if (b.a != null) {
                        b.a.d();
                    }
                }
                j.mShouldAutoSpeedup = true;
            }
        }
    }

    public static String c(String str) {
        return g.a().a(str);
    }

    public final void c(long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;	 Catch:{ RejectedExecutionException -> 0x000f }
        r1 = new com.xunlei.downloadprovider.download.engine.task.o;	 Catch:{ RejectedExecutionException -> 0x000f }
        r2 = java.lang.Long.valueOf(r4);	 Catch:{ RejectedExecutionException -> 0x000f }
        r1.<init>(r3, r2);	 Catch:{ RejectedExecutionException -> 0x000f }
        r0.execute(r1);	 Catch:{ RejectedExecutionException -> 0x000f }
        return;
    L_0x000f:
        r0 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r0.a(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.n.c(long):void");
    }

    public final void a(long r4, long r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "setPlayTask， taskId : ";
        r0.<init>(r1);
        r0.append(r4);
        r1 = " index : ";
        r0.append(r1);
        r0.append(r6);
        r0 = new com.xunlei.downloadprovider.download.engine.task.a.t$b;	 Catch:{ RejectedExecutionException -> 0x002a }
        r1 = java.lang.Long.valueOf(r4);	 Catch:{ RejectedExecutionException -> 0x002a }
        r2 = java.lang.Long.valueOf(r6);	 Catch:{ RejectedExecutionException -> 0x002a }
        r0.<init>(r1, r2);	 Catch:{ RejectedExecutionException -> 0x002a }
        r1 = r3.a;	 Catch:{ RejectedExecutionException -> 0x002a }
        r2 = new com.xunlei.downloadprovider.download.engine.task.p;	 Catch:{ RejectedExecutionException -> 0x002a }
        r2.<init>(r3, r0);	 Catch:{ RejectedExecutionException -> 0x002a }
        r1.execute(r2);	 Catch:{ RejectedExecutionException -> 0x002a }
        return;
    L_0x002a:
        r0 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r0.a(r4, r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.n.a(long, long):void");
    }

    public final void d(long j) {
        this.a.execute(new q(this, Long.valueOf(j)));
    }

    public static long h() {
        return g.a().c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(int r1) {
        /*
        if (r1 <= 0) goto L_0x000b;
    L_0x0002:
        com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e();
        if (r1 <= r0) goto L_0x000c;
    L_0x000b:
        r1 = 3;
    L_0x000c:
        r0 = com.xunlei.downloadprovider.download.engine.kernel.g.a();
        r0.a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.n.a(int):void");
    }

    private void a(long j, String str, String str2, boolean z) {
        a(new a(j, str, str2, z), (boolean) 0);
    }

    public final void a(a aVar, boolean z) {
        synchronized (this) {
            this.h = aVar;
        }
        Runnable rVar = new r(this, z);
        if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()) {
            this.a.execute(rVar);
        } else {
            rVar.run();
        }
        if (aVar.a == 0 || TextUtils.isEmpty(aVar.b) != null) {
            aVar = DownloadService.a();
            if (aVar != null) {
                aVar = aVar.b();
                if (aVar.a) {
                    aVar.a.c();
                }
            }
        }
    }

    public final void a(LoginHelper loginHelper) {
        if (loginHelper != null) {
            boolean l = loginHelper.l();
            if (!l) {
                l = loginHelper.g.g();
            }
            boolean z = l;
            Object obj = null;
            if (l.b() || l.c()) {
                obj = 1;
            }
            if (obj != null) {
                a(loginHelper.g.c(), loginHelper.a((int) UTMini.EVENTID_AGOO), loginHelper.c(), z);
            } else {
                a(0, null, null, false);
            }
        }
    }

    public final void b(long j, long j2) {
        this.a.execute(new s(this, j, j2));
    }

    public static z e(long j) {
        DownloadService a = DownloadService.a();
        return (a == null || j == -1) ? 0 : a.b().a().c(j);
    }

    public static TaskInfo f(long j) {
        DownloadService a = DownloadService.a();
        return (a == null || j == -1) ? 0 : a.b().a().b(j);
    }

    @Deprecated
    public static long d(String str) {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? -1 : a.b().a().c(str);
    }

    public static long e(String str) {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? -1 : a.b().a().a(str);
    }

    public static long f(String str) {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? -1 : a.b().a().b(str);
    }

    public static long g(String str) {
        str = i(str);
        if (str == null) {
            return -1;
        }
        return str.a();
    }

    @Nullable
    public static com.xunlei.downloadprovider.download.engine.task.info.b h(String str) {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? null : a.b().a().a(str, FindTaskKeyType.BY_URI);
    }

    @Nullable
    public static com.xunlei.downloadprovider.download.engine.task.info.b i(String str) {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? null : a.b().a().a(str, FindTaskKeyType.BY_PATH);
    }

    public static int i() {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? 0 : a.b().a().e();
    }

    public static TaskCountsStatistics j() {
        DownloadService a = DownloadService.a();
        if (a == null || a.b().a() == null) {
            return new TaskCountsStatistics();
        }
        return a.b().a().f();
    }

    public static TaskCountsStatistics b(boolean z) {
        DownloadService a = DownloadService.a();
        if (a == null || a.b().a() == null) {
            return new TaskCountsStatistics();
        }
        return a.b().a().a(z);
    }

    public static com.xunlei.downloadprovider.download.engine.task.info.c c(boolean z) {
        DownloadService a = DownloadService.a();
        if (a == null || a.b().a() == null) {
            return new com.xunlei.downloadprovider.download.engine.task.info.c();
        }
        return a.b().a().b(z);
    }

    public static long k() {
        DownloadService a = DownloadService.a();
        return (a == null || a.b().a() == null) ? 0 : a.b().a().a();
    }

    public static List<z> g(long j) {
        DownloadService a = DownloadService.a();
        if (a == null || a.b().a() == null) {
            return Collections.emptyList();
        }
        return a.b().a().a(j);
    }

    public static void h(long j) {
        g a = g.a();
        if (a.b != null) {
            if (j != -1) {
                a.b.setAllowedNetworkTypes(8, j);
            }
        }
    }

    public final boolean a(m mVar) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            return a.b().a(mVar);
        }
        DownloadService.a(new u(this, mVar));
        return true;
    }

    public static void l() {
        DownloadService a = DownloadService.a();
        if (a != null) {
            p pVar = a.b().a.b;
            pVar.e = pVar.d;
        }
    }

    public static void a(TaskInfo taskInfo) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            p pVar = a.b().a.b;
            com.xunlei.downloadprovider.download.engine.task.a.c cVar = pVar.a;
            TaskInfo b = cVar.b(taskInfo.getTaskId());
            if (b != null && b.getTaskId() == taskInfo.getTaskId()) {
                b.markToSeen();
                cVar.b.execute(new com.xunlei.downloadprovider.download.engine.task.a.g(cVar, b));
            }
            taskInfo = pVar.a();
            int unfinishedTaskCount = pVar.a.f().getUnfinishedTaskCount();
            int i = 0;
            if (pVar.e >= pVar.d || taskInfo <= null || unfinishedTaskCount != 0) {
                taskInfo = null;
            } else {
                pVar.e = pVar.d;
            }
            if (pVar.c != null) {
                while (i < pVar.c.size()) {
                    ((v) pVar.c.get(i)).a(taskInfo, unfinishedTaskCount);
                    i++;
                }
            }
        }
    }

    public static void a(v vVar) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            p pVar = a.b().a.b;
            if (pVar.c == null) {
                pVar.c = new ArrayList();
            }
            if (!pVar.c.contains(vVar)) {
                pVar.c.add(vVar);
            }
        }
    }

    public static void b(v vVar) {
        DownloadService a = DownloadService.a();
        if (a != null) {
            p pVar = a.b().a.b;
            if (pVar.c != null && pVar.c.contains(vVar)) {
                pVar.c.remove(vVar);
            }
        }
    }

    public static boolean m() {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return false;
        }
        p pVar = a.b().a.b;
        if (pVar.e >= pVar.d || pVar.a() == 0) {
            return false;
        }
        return true;
    }

    public static void a(boolean z, boolean z2) {
        LoginHelper.a();
        if (!l.b()) {
            return;
        }
        if (z || z2) {
            d(false);
        }
    }

    public final void n() {
        LoginHelper a = LoginHelper.a();
        a(a.l(), a.g.g());
        if (l.c() || l.b()) {
            a(a);
        }
    }

    public static int i(long j) {
        LoginHelper.a();
        if (l.b() && LoginHelper.a().l()) {
            return 0;
        }
        return g.a().b.getHighSpeedTrialTimes(j);
    }

    public static boolean j(long j) {
        return g.a().b.isEnteredHighSpeedTrial(j);
    }

    public static int k(long j) {
        LoginHelper.a();
        if (l.b() && LoginHelper.a().l()) {
            return 0;
        }
        return g.a().b.getHighSpeedDuration(j);
    }

    public static void l(long j) {
        g.a().b.stopHighSpeedTrial(j);
    }

    public static boolean o() {
        g a = g.a();
        if (a == null || a.b == null) {
            return false;
        }
        return a.b.getHighSpeedTrialEnable();
    }

    public static void d(boolean z) {
        g a = g.a();
        if (a != null) {
            a.a(z);
        }
    }

    public static TaskSpeedCountInfo m(long j) {
        DownloadService a = DownloadService.a();
        if (a == null) {
            return null;
        }
        k b = a.b();
        if (b.a != null) {
            return b.a.a(j);
        }
        return null;
    }

    public static void p() {
        DownloadService a = DownloadService.a();
        if (a != null) {
            k b = a.b();
            if (b.a != null) {
                b.a.e();
            }
        }
    }

    public static void n(long j) {
        DownloadService a = DownloadService.a();
        if (a != null && a.b().a() != null) {
            a.b().a().d(j);
        }
    }

    public static void a(long j, int i, String str, long j2, int i2) {
        g a = g.a();
        if (!(a == null || a.b == null)) {
            if (j != -1) {
                StringBuilder stringBuilder = new StringBuilder("statExternalInfoU64 taskId = ");
                stringBuilder.append(j);
                stringBuilder.append(" subIndex = ");
                stringBuilder.append(i);
                stringBuilder.append("key = ");
                stringBuilder.append(str);
                stringBuilder.append(" value = ");
                stringBuilder.append(j2);
                stringBuilder.append(" statType = ");
                stringBuilder.append(i2);
                a.b.statExternalInfoU64(j, i, str, j2, i2);
            }
        }
    }

    public final boolean a(m mVar, c cVar) {
        if (cVar != null) {
            mVar.d = cVar;
        }
        return a(mVar);
    }
}
