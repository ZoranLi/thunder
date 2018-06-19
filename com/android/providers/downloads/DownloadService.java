package com.android.providers.downloads;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.download.proguard.ad;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.c;
import com.xunlei.download.proguard.d;
import com.xunlei.download.proguard.e;
import com.xunlei.download.proguard.f;
import com.xunlei.download.proguard.o;
import com.xunlei.download.proguard.q;
import com.xunlei.download.proguard.r;
import com.xunlei.downloadlib.XLDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

public class DownloadService extends Service {
    public static final String b = "com.xunlei.downloadlibsdk.action.LOCAL_BROADCAST";
    public static final String c = "statExternalInfoU64";
    private static final boolean d = true;
    private static boolean i = false;
    private static final int r = 0;
    private static final int s = 1;
    private static final int t = 2;
    private static final int u = 3;
    r a;
    private AlarmManager e;
    private q f;
    private a g;
    private e h;
    @SuppressLint({"UseSparseArrays"})
    private final Map<Long, d> j = new HashMap();
    private ExecutorService k;
    private f l;
    private HandlerThread m;
    private Handler n;
    private boolean o = false;
    private volatile int p;
    private volatile boolean q = false;
    private Callback v = new Callback(this) {
        final /* synthetic */ DownloadService a;

        {
            this.a = r1;
        }

        public boolean handleMessage(Message message) {
            Process.setThreadPriority(10);
            int i = message.arg1;
            StringBuilder stringBuilder = new StringBuilder("Updating for startId ");
            stringBuilder.append(i);
            an.e("DownloadManager", stringBuilder.toString());
            switch (message.what) {
                case 0:
                    this.a.c();
                    break;
                case 1:
                    message = this.a.d();
                    break;
                case 2:
                    message = this.a.d();
                    this.a.e();
                    StringBuilder stringBuilder2 = new StringBuilder("Final update pass triggered, isActive=");
                    stringBuilder2.append(message);
                    stringBuilder2.append("; someone didn't update correctly.");
                    an.d("DownloadManager", stringBuilder2.toString());
                    break;
                case 3:
                    this.a.a(message);
                    return true;
                default:
                    an.c("DownloadManager", "unknow command");
                    break;
            }
            message = null;
            if ((message | this.a.n.hasMessages(1)) != null) {
                this.a.b();
            } else {
                this.a.a(i);
            }
            return true;
        }
    };
    private b w = new b();

    class a extends ContentObserver {
        final /* synthetic */ DownloadService a;

        public a(DownloadService downloadService) {
            this.a = downloadService;
            super(new Handler());
        }

        public void onChange(boolean z) {
            this.a.a();
        }
    }

    class b extends BroadcastReceiver {
        final /* synthetic */ DownloadService a;

        private b(DownloadService downloadService) {
            this.a = downloadService;
        }

        public void onReceive(Context context, Intent intent) {
            context = intent.getExtras();
            if (context != null) {
                intent = context.getString("cmdtype");
                if (intent != null) {
                    Object obj = -1;
                    if (intent.hashCode() == -1909873882) {
                        if (intent.equals(DownloadService.c)) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        StringBuilder stringBuilder = new StringBuilder("LocalBroadcastReceiver recv unknow cmdtype: ");
                        stringBuilder.append(intent);
                        an.c("DownloadManager", stringBuilder.toString());
                        return;
                    }
                    intent = this.a.n.obtainMessage();
                    intent.what = 3;
                    intent.setData((Bundle) context.clone());
                    this.a.n.sendMessage(intent);
                    return;
                }
                an.c("DownloadManager", "LocalBroadcastReceiver cmdtype is null ");
                return;
            }
            an.c("DownloadManager", "LocalBroadcastReceiver recv Bundle is illegal");
        }
    }

    private static ExecutorService a(Context context) {
        int a = ad.a(context, DownloadManager.KEY_MAX_CONCURRENT_DOWNLOADS, 10);
        return new ThreadPoolExecutor(a, a, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Cannot bind to Download Manager Service");
    }

    public void onCreate() {
        super.onCreate();
        if (i) {
            an.e("DownloadManager", "Service Has Created");
            return;
        }
        i = true;
        g();
        an.e("DownloadManager", "Service onCreate");
        if (this.a == null) {
            this.a = new o(this);
        }
        this.k = a((Context) this);
        this.e = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f = new q(this);
        this.m = new HandlerThread("DownloadManager-UpdateThread");
        this.m.start();
        this.n = new Handler(this.m.getLooper(), this.v);
        this.l = new f(this);
        this.h = new e(this);
        this.h.a();
        this.g = new a(this);
        try {
            getContentResolver().registerContentObserver(DownloadManager.getInstanceFor(this).getDownloadUri(), true, this.g);
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
        XlTaskHelper.a().a((Context) this);
        a(0);
        this.o = ad.a(this, "com.xunlei.download.SERVICE_IDLE_EXIT", this.o);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        intent = super.onStartCommand(intent, i, i2);
        if (this.n == 0) {
            return 2;
        }
        StringBuilder stringBuilder = new StringBuilder("Service onStart startId = ");
        stringBuilder.append(i2);
        an.e("DownloadManager", stringBuilder.toString());
        this.p = i2;
        a();
        return ad.a(this, "com.xunlei.download.SERVICE_START_COMMAND", intent);
    }

    public void onDestroy() {
        i = false;
        if (this.n == null) {
            super.onDestroy();
            return;
        }
        try {
            getContentResolver().unregisterContentObserver(this.g);
            h();
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
        this.l.b();
        this.m.quit();
        an.e("DownloadManager", "Service onDestroy");
        XlTaskHelper.a().c(this);
        XlTaskHelper.a().b((Context) this);
        super.onDestroy();
    }

    private void a() {
        this.n.removeMessages(1);
        this.n.obtainMessage(1, this.p, -1).sendToTarget();
    }

    private void b() {
        this.n.removeMessages(2);
        this.n.sendMessageDelayed(this.n.obtainMessage(2, this.p, -1), 300000);
    }

    private void a(long j) {
        if (!this.q) {
            this.n.sendMessageDelayed(this.n.obtainMessage(0), j);
        }
    }

    private void c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = "DownloadManager";
        r1 = "initXLEngine";
        com.xunlei.download.proguard.an.b(r0, r1);
        r0 = com.android.providers.downloads.XlTaskHelper.a();	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r1 = r4.n;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r0 = r0.a(r4, r1);	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r1 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        if (r1 != r0) goto L_0x001f;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
    L_0x0015:
        r4.a();	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r0 = 1;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r4.q = r0;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r4.a(r0);	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        return;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
    L_0x001f:
        r1 = "DownloadManager";	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r3 = "initXLEngine error,the errorcode:";	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r2.<init>(r3);	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r2.append(r0);	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        r0 = r2.toString();	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        com.xunlei.download.proguard.an.d(r1, r0);	 Catch:{ UnsatisfiedLinkError -> 0x003f, Exception -> 0x0033 }
        return;
    L_0x0033:
        r0 = move-exception;
        r1 = "DownloadManager";
        r2 = "initXLEngine error";
        com.xunlei.download.proguard.an.d(r1, r2);
        r0.printStackTrace();
        return;
    L_0x003f:
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4.a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.DownloadService.c():void");
    }

    private boolean d() {
        if (!this.q) {
            return false;
        }
        boolean f;
        synchronized (this.j) {
            f = f();
        }
        return f;
    }

    private void e() {
        if (this.q) {
            for (Entry entry : Thread.getAllStackTraces().entrySet()) {
                if (((Thread) entry.getKey()).getName().startsWith("pool")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(entry.getKey());
                    stringBuilder.append(": ");
                    stringBuilder.append(Arrays.toString((Object[]) entry.getValue()));
                    an.b("DownloadManager", stringBuilder.toString());
                }
            }
            this.h.b();
        }
    }

    private void a(Message message) {
        if (this.q) {
            b(message);
        }
    }

    private void a(int i) {
        if (!this.o || stopSelfResult(i) == 0) {
            if (this.o == 0) {
                synchronized (this.j) {
                    this.j.clear();
                }
                XlTaskHelper.a().b();
            }
            return;
        }
        an.e("DownloadManager", "Nothing left; stopped");
        try {
            getContentResolver().unregisterContentObserver(this.g);
        } catch (int i2) {
            i2.printStackTrace();
            an.a(i2);
        }
        this.l.b();
        this.m.quit();
    }

    private void a(boolean z) {
        an.b("DownloadManager", "setDownloadlibSDKInitFlg");
        DownloadManager.getInstanceFor(this).setDownloadlibSDKInit(z);
    }

    private boolean f() {
        Cursor query;
        Throwable th;
        Cursor cursor;
        long a = this.a.a();
        Set hashSet = new HashSet(this.j.keySet());
        ContentResolver contentResolver = getContentResolver();
        StringBuilder stringBuilder = new StringBuilder("content://");
        stringBuilder.append(DownloadProvider.e);
        stringBuilder.append("/all_downloads");
        String str = null;
        try {
            query = contentResolver.query(Uri.parse(stringBuilder.toString()), null, null, null, null);
            try {
                d.a();
                d.d dVar = new d.d(contentResolver, query);
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                long j = Long.MAX_VALUE;
                boolean z = false;
                while (query.moveToNext()) {
                    d.d dVar2;
                    Set set;
                    ContentResolver contentResolver2;
                    long j2 = query.getLong(columnIndexOrThrow);
                    hashSet.remove(Long.valueOf(j2));
                    d dVar3 = (d) r1.j.get(Long.valueOf(j2));
                    if (dVar3 != null) {
                        a(dVar, dVar3, a);
                    } else {
                        dVar3 = a(dVar, a);
                    }
                    StringBuilder stringBuilder2;
                    if (!dVar3.A) {
                        boolean a2;
                        dVar2 = dVar;
                        String str2 = str;
                        if (dVar3.ae == 0) {
                            a2 = dVar3.a(r1.k);
                        } else {
                            d dVar4 = (d) r1.j.get(Long.valueOf(dVar3.ae));
                            if (dVar4 != null) {
                                dVar3.D = dVar4.D;
                                if (dVar4.d() && dVar4.b(dVar3.c) && dVar3.a(r1.k)) {
                                    a2 = true;
                                }
                            }
                            a2 = false;
                        }
                        boolean a3 = dVar3.a(r1.l);
                        if (!a2) {
                            if (!a3) {
                                set = hashSet;
                                contentResolver2 = contentResolver;
                                z = (z | a2) | a3;
                            }
                        }
                        stringBuilder2 = new StringBuilder("Download ");
                        set = hashSet;
                        contentResolver2 = contentResolver;
                        stringBuilder2.append(dVar3.c);
                        stringBuilder2.append(": activeDownload=");
                        stringBuilder2.append(a2);
                        stringBuilder2.append(", activeScan=");
                        stringBuilder2.append(a3);
                        an.e("DownloadManager", stringBuilder2.toString());
                        z = (z | a2) | a3;
                    } else if (dVar3.f()) {
                        a();
                        set = hashSet;
                        contentResolver2 = contentResolver;
                        dVar2 = dVar;
                        z = true;
                    } else {
                        if (!TextUtils.isEmpty(dVar3.B)) {
                            contentResolver.delete(Uri.parse(dVar3.B), str, str);
                        }
                        a(dVar3.g);
                        dVar2 = dVar;
                        stringBuilder2 = new StringBuilder("delete id: ");
                        stringBuilder2.append(j2);
                        an.b("DownloadManager", stringBuilder2.toString());
                        contentResolver.delete(dVar3.j(), null, null);
                        set = hashSet;
                        contentResolver2 = contentResolver;
                    }
                    j = Math.min(dVar3.d(a), j);
                    dVar = dVar2;
                    hashSet = set;
                    contentResolver = contentResolver2;
                    str = null;
                }
                Set<Long> set2 = hashSet;
                if (query != null) {
                    query.close();
                }
                for (Long longValue : set2) {
                    b(longValue.longValue());
                }
                r1.h.a(r1.j.values());
                if (j > 0 && j < Long.MAX_VALUE) {
                    StringBuilder stringBuilder3 = new StringBuilder("scheduling start in ");
                    stringBuilder3.append(j);
                    stringBuilder3.append("ms");
                    an.e("DownloadManager", stringBuilder3.toString());
                    Intent intent = new Intent(c.h);
                    intent.setClass(r1, DownloadReceiver.class);
                    r1.e.set(0, a + j, PendingIntent.getBroadcast(r1, 0, intent, 1073741824));
                }
                return z;
            } catch (Throwable e) {
                th = e;
                cursor = query;
                try {
                    th.printStackTrace();
                    an.a(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return true;
                } catch (Throwable e2) {
                    th = e2;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable e22) {
                th = e22;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable e222) {
            th = e222;
            cursor = null;
            th.printStackTrace();
            an.a(th);
            if (cursor != null) {
                cursor.close();
            }
            return true;
        } catch (Throwable e2222) {
            th = e2222;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private d a(d.d dVar, long j) {
        dVar = dVar.a(this, this.a, this.f, this.h);
        this.j.put(Long.valueOf(dVar.c), dVar);
        return dVar;
    }

    private void a(d.d dVar, d dVar2, long j) {
        dVar.a(dVar2);
    }

    private void b(long j) {
        d dVar = (d) this.j.get(Long.valueOf(j));
        if (dVar.l == 192) {
            dVar.l = Impl.STATUS_CANCELED;
        }
        this.j.remove(Long.valueOf(dVar.c));
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder("deleteFileIfExists() deleting ");
            stringBuilder.append(str);
            an.b("DownloadManager", stringBuilder.toString());
            XLDownloadManager.getInstance(getApplicationContext()).clearTaskFile(str);
        }
    }

    private void a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    a(a);
                }
            }
            file.delete();
        }
    }

    private ArrayList<String> a(int i, long j) {
        String[] strArr = new String[]{Impl._DATA};
        Cursor cursor = null;
        try {
            if (i == TaskType.GROUP.ordinal()) {
                i = getContentResolver().query(DownloadManager.getInstanceFor(this).getDownloadUri(), strArr, "group_id = ?", new String[]{String.valueOf(j)}, null);
            } else if (i != TaskType.BT.ordinal()) {
                return null;
            } else {
                i = getContentResolver().query(DownloadProvider.c, strArr, "bt_parent_id = ?", new String[]{String.valueOf(j)}, null);
            }
            try {
                j = new ArrayList();
                i.moveToFirst();
                while (!i.isAfterLast()) {
                    CharSequence string = i.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        j.add(string);
                    }
                    i.moveToNext();
                }
                if (i != 0) {
                    i.close();
                }
                return j;
            } catch (long j2) {
                Object obj = j2;
                j2 = i;
                i = obj;
                try {
                    i.printStackTrace();
                    an.a(i);
                    if (j2 != null) {
                        j2.close();
                    }
                    return null;
                } catch (Throwable th) {
                    i = th;
                    cursor = j2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw i;
                }
            } catch (long j22) {
                cursor = i;
                i = j22;
                if (cursor != null) {
                    cursor.close();
                }
                throw i;
            }
        } catch (Exception e) {
            i = e;
            j22 = 0;
            i.printStackTrace();
            an.a(i);
            if (j22 != null) {
                j22.close();
            }
            return null;
        } catch (Throwable th2) {
            i = th2;
            if (cursor != null) {
                cursor.close();
            }
            throw i;
        }
    }

    protected void dump(java.io.FileDescriptor r3, java.io.PrintWriter r4, java.lang.String[] r5) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r3 = new com.xunlei.download.proguard.m;
        r5 = "  ";
        r3.<init>(r4, r5);
        r4 = r2.j;
        monitor-enter(r4);
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x0036 }
        r0 = r2.j;	 Catch:{ all -> 0x0036 }
        r0 = r0.keySet();	 Catch:{ all -> 0x0036 }
        r5.<init>(r0);	 Catch:{ all -> 0x0036 }
        java.util.Collections.sort(r5);	 Catch:{ all -> 0x0036 }
        r5 = r5.iterator();	 Catch:{ all -> 0x0036 }
    L_0x001c:
        r0 = r5.hasNext();	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ all -> 0x0036 }
    L_0x0022:
        r0 = r5.next();	 Catch:{ all -> 0x0036 }
        r0 = (java.lang.Long) r0;	 Catch:{ all -> 0x0036 }
        r1 = r2.j;	 Catch:{ all -> 0x0036 }
        r0 = r1.get(r0);	 Catch:{ all -> 0x0036 }
        r0 = (com.xunlei.download.proguard.d) r0;	 Catch:{ all -> 0x0036 }
        r0.a(r3);	 Catch:{ all -> 0x0036 }
        goto L_0x001c;	 Catch:{ all -> 0x0036 }
    L_0x0034:
        monitor-exit(r4);	 Catch:{ all -> 0x0036 }
        return;	 Catch:{ all -> 0x0036 }
    L_0x0036:
        r3 = move-exception;	 Catch:{ all -> 0x0036 }
        monitor-exit(r4);	 Catch:{ all -> 0x0036 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.DownloadService.dump(java.io.FileDescriptor, java.io.PrintWriter, java.lang.String[]):void");
    }

    private void g() {
        LocalBroadcastManager.getInstance(this).registerReceiver(this.w, new IntentFilter(b));
    }

    private void h() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.w);
    }

    private boolean b(Message message) {
        message = message.getData();
        if (message != null) {
            String string = message.getString("cmdtype");
            if (string != null) {
                boolean z = true;
                if (string.hashCode() == -1909873882) {
                    if (string.equals(c)) {
                        z = false;
                    }
                }
                if (z) {
                    return false;
                }
                a(message.getLong(AgooConstants.MESSAGE_ID), message.getInt("subIndex"), message.getString("key"), message.getLong(RequestHeaders.COLUMN_VALUE), message.getInt("statType"));
                return true;
            }
        }
        return false;
    }

    private void a(long j, int i, String str, long j2, int i2) {
        StringBuilder stringBuilder = new StringBuilder("statExternalInfoU64 id:");
        stringBuilder.append(j);
        stringBuilder.append(", subIndex:");
        stringBuilder.append(i);
        stringBuilder.append(", key:");
        stringBuilder.append(str);
        stringBuilder.append(", value:");
        stringBuilder.append(j2);
        stringBuilder.append(", statType:");
        stringBuilder.append(i2);
        an.b("DownloadManager", stringBuilder.toString());
        d dVar = (d) this.j.get(Long.valueOf(j));
        if (dVar != null && dVar.f()) {
            long m = dVar.m();
            StringBuilder stringBuilder2 = new StringBuilder("statExternalInfoU64 taskId:");
            stringBuilder2.append(m);
            an.b("DownloadManager", stringBuilder2.toString());
            if (-1 != m) {
                XLDownloadManager.getInstance().statExternalInfoU64(m, i, str, j2, i2);
            }
        }
    }
}
