package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.tencent.bugly.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
public class ak {
    private static ak c;
    public aj a;
    public boolean b = true;
    private final ae d;
    private final Context e;
    private Map<Integer, Long> f = new HashMap();
    private long g;
    private long h;
    private LinkedBlockingQueue<Runnable> i = new LinkedBlockingQueue();
    private LinkedBlockingQueue<Runnable> j = new LinkedBlockingQueue();
    private final Object k = new Object();
    private String l = null;
    private byte[] m = null;
    private long n = 0;
    private byte[] o = null;
    private long p = 0;
    private String q = null;
    private long r = 0;
    private final Object s = new Object();
    private boolean t = false;
    private final Object u = new Object();
    private int v = 0;

    /* compiled from: BUGLY */
    class a implements Runnable {
        final /* synthetic */ ak a;
        private final Context b;
        private final Runnable c;
        private final long d;

        public a(ak akVar, Context context) {
            this.a = akVar;
            this.b = context;
            this.c = null;
            this.d = null;
        }

        public a(ak akVar, Context context, Runnable runnable, long j) {
            this.a = akVar;
            this.b = context;
            this.c = runnable;
            this.d = j;
        }

        public void run() {
            if (ap.a(this.b, "security_info", (long) StatisticConfig.MIN_UPLOAD_INTERVAL)) {
                if (!this.a.e()) {
                    an.d("[UploadManager] Failed to load security info from database", new Object[0]);
                    this.a.b(false);
                }
                if (this.a.q != null) {
                    if (this.a.b()) {
                        an.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        if (this.c != null) {
                            this.a.a(this.c, this.d);
                        }
                        this.a.c(0);
                        ap.b(this.b, "security_info");
                        synchronized (this.a.u) {
                            this.a.t = false;
                        }
                        return;
                    }
                    an.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                    this.a.b(true);
                }
                byte[] a = ap.a(128);
                if (a == null || a.length * 8 != 128) {
                    an.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    this.a.b(false);
                    ap.b(this.b, "security_info");
                    synchronized (this.a.u) {
                        this.a.t = false;
                    }
                    return;
                }
                this.a.o = a;
                an.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (this.c != null) {
                    this.a.a(this.c, this.d);
                    return;
                } else {
                    this.a.c(1);
                    return;
                }
            }
            an.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", Integer.valueOf(ReaderCallback.GET_BAR_ANIMATING), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            ap.b(5000);
            if (ap.a((Runnable) this, "BUGLY_ASYNC_UPLOAD") == null) {
                an.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                am a2 = am.a();
                if (a2 != null) {
                    a2.a(this);
                } else {
                    an.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ int b(ak akVar) {
        int i = akVar.v - 1;
        akVar.v = i;
        return i;
    }

    protected ak(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = new java.util.HashMap;
        r0.<init>();
        r3.f = r0;
        r0 = new java.util.concurrent.LinkedBlockingQueue;
        r0.<init>();
        r3.i = r0;
        r0 = new java.util.concurrent.LinkedBlockingQueue;
        r0.<init>();
        r3.j = r0;
        r0 = new java.lang.Object;
        r0.<init>();
        r3.k = r0;
        r0 = 0;
        r3.l = r0;
        r3.m = r0;
        r1 = 0;
        r3.n = r1;
        r3.o = r0;
        r3.p = r1;
        r3.q = r0;
        r3.r = r1;
        r0 = new java.lang.Object;
        r0.<init>();
        r3.s = r0;
        r0 = 0;
        r3.t = r0;
        r1 = new java.lang.Object;
        r1.<init>();
        r3.u = r1;
        r1 = 1;
        r3.b = r1;
        r3.v = r0;
        r3.e = r4;
        r4 = com.tencent.bugly.proguard.ae.a();
        r3.d = r4;
        r4 = "android.util.Base64";	 Catch:{ ClassNotFoundException -> 0x0054 }
        java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0054 }
        goto L_0x005d;
    L_0x0054:
        r4 = "[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload";
        r1 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.a(r4, r1);
        r3.b = r0;
    L_0x005d:
        r4 = r3.b;
        if (r4 == 0) goto L_0x0071;
    L_0x0061:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        r4.append(r0);
        r4 = r4.toString();
        r3.l = r4;
    L_0x0071:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.<init>(android.content.Context):void");
    }

    public static synchronized ak a(Context context) {
        synchronized (ak.class) {
            if (c == null) {
                c = new ak(context);
            }
            context = c;
        }
        return context;
    }

    public static synchronized ak a() {
        ak akVar;
        synchronized (ak.class) {
            akVar = c;
        }
        return akVar;
    }

    public void a(int i, int i2, byte[] bArr, String str, String str2, aj ajVar, long j, boolean z) {
        try {
            b(new al(this.e, i, i2, bArr, str, str2, ajVar, r7.b, z), true, true, j);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!an.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public void a(int i, bd bdVar, String str, String str2, aj ajVar, long j, boolean z) {
        Object obj = bdVar;
        a(i, obj.g, ah.a(obj), str, str2, ajVar, j, z);
    }

    public void a(int i, int i2, byte[] bArr, String str, String str2, aj ajVar, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            b(new al(this.e, i, i2, bArr, str, str2, ajVar, r7.b, i3, i4, false, map), z, false, 0);
        } catch (Throwable th) {
            Throwable th2 = th;
            if (!an.a(th2)) {
                th2.printStackTrace();
            }
        }
    }

    public void a(int i, int i2, byte[] bArr, String str, String str2, aj ajVar, boolean z, Map<String, String> map) {
        a(i, i2, bArr, str, str2, ajVar, 0, 0, z, map);
    }

    public void a(int i, bd bdVar, String str, String str2, aj ajVar, boolean z) {
        Object obj = bdVar;
        a(i, obj.g, ah.a(obj), str, str2, ajVar, 0, 0, z, null);
    }

    public long a(boolean z) {
        long b = ap.b();
        int i = z ? 5 : 3;
        List a = this.d.a(i);
        if (a == null || a.size() <= 0) {
            b = z ? this.h : this.g;
        } else {
            try {
                ag agVar = (ag) a.get(0);
                if (agVar.e >= b) {
                    b = ap.c(agVar.g);
                    if (i == 3) {
                        try {
                            this.g = b;
                        } catch (Throwable th) {
                            z = th;
                            an.a(z);
                            if (a.size() <= false) {
                                this.d.a(a);
                            }
                            an.c("[UploadManager] Local network consume: %d KB", Long.valueOf(b / 1024));
                            return b;
                        }
                    }
                    this.h = b;
                    a.remove(agVar);
                } else {
                    b = 0;
                }
            } catch (Throwable th2) {
                z = th2;
                b = 0;
                an.a(z);
                if (a.size() <= false) {
                    this.d.a(a);
                }
                an.c("[UploadManager] Local network consume: %d KB", Long.valueOf(b / 1024));
                return b;
            }
            if (a.size() <= false) {
                this.d.a(a);
            }
        }
        an.c("[UploadManager] Local network consume: %d KB", Long.valueOf(b / 1024));
        return b;
    }

    protected synchronized void a(long j, boolean z) {
        int i = z ? 5 : 3;
        ag agVar = new ag();
        agVar.b = i;
        agVar.e = ap.b();
        agVar.c = "";
        agVar.d = "";
        agVar.g = ap.c(j);
        this.d.b(i);
        this.d.a(agVar);
        if (z) {
            this.h = j;
        } else {
            this.g = j;
        }
        an.c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    public synchronized void a(int i, long j) {
        if (i >= 0) {
            this.f.put(Integer.valueOf(i), Long.valueOf(j));
            ag agVar = new ag();
            agVar.b = i;
            agVar.e = j;
            agVar.c = "";
            agVar.d = "";
            agVar.g = new byte[0];
            this.d.b(i);
            this.d.a(agVar);
            an.c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), ap.a(j));
            return;
        }
        an.e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
    }

    public synchronized long a(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = (Long) this.f.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<ag> a = this.d.a(i);
            if (a != null && a.size() > 0) {
                if (a.size() > 1) {
                    for (ag agVar : a) {
                        if (agVar.e > j) {
                            j = agVar.e;
                        }
                    }
                    this.d.b(i);
                } else {
                    try {
                        j = ((ag) a.get(0)).e;
                    } catch (int i2) {
                        an.a(i2);
                    }
                }
            }
        } else {
            an.e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i2));
        }
        return j;
    }

    public boolean b(int i) {
        if (b.c) {
            an.c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        an.c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf((System.currentTimeMillis() - a(i)) / 1000), Integer.valueOf(i));
        if (System.currentTimeMillis() - a(i) >= StatisticConfig.MIN_UPLOAD_INTERVAL) {
            return true;
        }
        an.a("[UploadManager] Data only be uploaded once in %d seconds.", Long.valueOf(30));
        return false;
    }

    private boolean c() {
        an.c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            ae a = ae.a();
            if (a != null) {
                return a.a(555, "security_info", null, true);
            }
            an.d("[UploadManager] Failed to get Database", new Object[0]);
            return false;
        } catch (Throwable th) {
            an.a(th);
            return false;
        }
    }

    private boolean d() {
        an.c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            ae a = ae.a();
            if (a == null) {
                an.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder stringBuilder = new StringBuilder();
            if (this.o != null) {
                stringBuilder.append(Base64.encodeToString(this.o, 0));
                stringBuilder.append("#");
                if (this.p != 0) {
                    stringBuilder.append(Long.toString(this.p));
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.q != null) {
                    stringBuilder.append(this.q);
                } else {
                    stringBuilder.append("null");
                }
                stringBuilder.append("#");
                if (this.r != 0) {
                    stringBuilder.append(Long.toString(this.r));
                } else {
                    stringBuilder.append("null");
                }
                a.a(555, "security_info", stringBuilder.toString().getBytes(), null, true);
                return true;
            }
            an.c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            an.a(th);
            c();
            return false;
        }
    }

    private boolean e() {
        an.c("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        boolean z;
        try {
            ae a = ae.a();
            if (a == null) {
                an.d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map a2 = a.a(555, null, true);
            if (a2 != null && a2.containsKey("security_info")) {
                String[] split = new String((byte[]) a2.get("security_info")).split("#");
                if (split.length == 4) {
                    if (!(split[0].isEmpty() || split[0].equals("null"))) {
                        this.o = Base64.decode(split[0], 0);
                    }
                    z = false;
                    if (!(z || split[1].isEmpty() || split[1].equals("null"))) {
                        try {
                            this.p = Long.parseLong(split[1]);
                        } catch (Throwable th) {
                            an.a(th);
                            z = true;
                        }
                    }
                    if (!(z || split[2].isEmpty() || split[2].equals("null"))) {
                        this.q = split[2];
                    }
                    if (!(z || split[3].isEmpty() || split[3].equals("null"))) {
                        try {
                            this.r = Long.parseLong(split[3]);
                        } catch (Throwable th2) {
                            an.a(th2);
                        }
                    }
                } else {
                    an.a("SecurityInfo = %s, Strings.length = %d", r2, Integer.valueOf(split.length));
                    z = true;
                }
                if (z) {
                    c();
                }
            }
            return true;
        } catch (Throwable th22) {
            an.a(th22);
            return false;
        }
    }

    protected boolean b() {
        if (this.q != null) {
            if (this.r != 0) {
                if (this.r >= System.currentTimeMillis() + this.n) {
                    return true;
                }
                an.c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(this.r), new Date(this.r).toString(), Long.valueOf(System.currentTimeMillis() + this.n), new Date(System.currentTimeMillis() + this.n).toString());
                return false;
            }
        }
        return false;
    }

    protected void b(boolean z) {
        synchronized (this.s) {
            an.c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.o = null;
            this.q = null;
            this.r = 0;
        }
        if (z) {
            c();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r14) {
        /*
        r13 = this;
        r0 = 0;
        if (r14 >= 0) goto L_0x000b;
    L_0x0003:
        r14 = "[UploadManager] Number of task to execute should >= 0";
        r0 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.a(r14, r0);
        return;
    L_0x000b:
        r1 = com.tencent.bugly.proguard.am.a();
        r2 = new java.util.concurrent.LinkedBlockingQueue;
        r2.<init>();
        r3 = new java.util.concurrent.LinkedBlockingQueue;
        r3.<init>();
        r4 = r13.k;
        monitor-enter(r4);
        r5 = "[UploadManager] Try to poll all upload task need and put them into temp queue (pid=%d | tid=%d)";
        r6 = 2;
        r7 = new java.lang.Object[r6];	 Catch:{ all -> 0x0159 }
        r8 = android.os.Process.myPid();	 Catch:{ all -> 0x0159 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0159 }
        r7[r0] = r8;	 Catch:{ all -> 0x0159 }
        r8 = android.os.Process.myTid();	 Catch:{ all -> 0x0159 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ all -> 0x0159 }
        r9 = 1;
        r7[r9] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.an.c(r5, r7);	 Catch:{ all -> 0x0159 }
        r5 = r13.i;	 Catch:{ all -> 0x0159 }
        r5 = r5.size();	 Catch:{ all -> 0x0159 }
        r7 = r13.j;	 Catch:{ all -> 0x0159 }
        r7 = r7.size();	 Catch:{ all -> 0x0159 }
        if (r5 != 0) goto L_0x0052;
    L_0x0047:
        if (r7 != 0) goto L_0x0052;
    L_0x0049:
        r14 = "[UploadManager] There is no upload task in queue.";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.an.c(r14, r0);	 Catch:{ all -> 0x0159 }
        monitor-exit(r4);	 Catch:{ all -> 0x0159 }
        return;
    L_0x0052:
        if (r14 == 0) goto L_0x005f;
    L_0x0054:
        if (r14 >= r5) goto L_0x0059;
    L_0x0056:
        r5 = r14;
        r14 = r0;
        goto L_0x0060;
    L_0x0059:
        r8 = r5 + r7;
        if (r14 >= r8) goto L_0x005f;
    L_0x005d:
        r14 = r14 - r5;
        goto L_0x0060;
    L_0x005f:
        r14 = r7;
    L_0x0060:
        if (r1 == 0) goto L_0x0068;
    L_0x0062:
        r7 = r1.c();	 Catch:{ all -> 0x0159 }
        if (r7 != 0) goto L_0x0069;
    L_0x0068:
        r14 = r0;
    L_0x0069:
        r7 = r0;
    L_0x006a:
        if (r7 >= r5) goto L_0x0090;
    L_0x006c:
        r8 = r13.i;	 Catch:{ all -> 0x0159 }
        r8 = r8.peek();	 Catch:{ all -> 0x0159 }
        r8 = (java.lang.Runnable) r8;	 Catch:{ all -> 0x0159 }
        if (r8 == 0) goto L_0x0090;
    L_0x0076:
        r2.put(r8);	 Catch:{ Throwable -> 0x007f }
        r8 = r13.i;	 Catch:{ Throwable -> 0x007f }
        r8.poll();	 Catch:{ Throwable -> 0x007f }
        goto L_0x008d;
    L_0x007f:
        r8 = move-exception;
        r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s";
        r11 = new java.lang.Object[r9];	 Catch:{ all -> 0x0159 }
        r8 = r8.getMessage();	 Catch:{ all -> 0x0159 }
        r11[r0] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.an.e(r10, r11);	 Catch:{ all -> 0x0159 }
    L_0x008d:
        r7 = r7 + 1;
        goto L_0x006a;
    L_0x0090:
        r7 = r0;
    L_0x0091:
        if (r7 >= r14) goto L_0x00b7;
    L_0x0093:
        r8 = r13.j;	 Catch:{ all -> 0x0159 }
        r8 = r8.peek();	 Catch:{ all -> 0x0159 }
        r8 = (java.lang.Runnable) r8;	 Catch:{ all -> 0x0159 }
        if (r8 == 0) goto L_0x00b7;
    L_0x009d:
        r3.put(r8);	 Catch:{ Throwable -> 0x00a6 }
        r8 = r13.j;	 Catch:{ Throwable -> 0x00a6 }
        r8.poll();	 Catch:{ Throwable -> 0x00a6 }
        goto L_0x00b4;
    L_0x00a6:
        r8 = move-exception;
        r10 = "[UploadManager] Failed to add upload task to temp urgent queue: %s";
        r11 = new java.lang.Object[r9];	 Catch:{ all -> 0x0159 }
        r8 = r8.getMessage();	 Catch:{ all -> 0x0159 }
        r11[r0] = r8;	 Catch:{ all -> 0x0159 }
        com.tencent.bugly.proguard.an.e(r10, r11);	 Catch:{ all -> 0x0159 }
    L_0x00b4:
        r7 = r7 + 1;
        goto L_0x0091;
    L_0x00b7:
        monitor-exit(r4);	 Catch:{ all -> 0x0159 }
        r4 = 3;
        if (r5 <= 0) goto L_0x00dc;
    L_0x00bb:
        r7 = "[UploadManager] Execute urgent upload tasks of queue which has %d tasks (pid=%d | tid=%d)";
        r8 = new java.lang.Object[r4];
        r10 = java.lang.Integer.valueOf(r5);
        r8[r0] = r10;
        r10 = android.os.Process.myPid();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r10 = android.os.Process.myTid();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r6] = r10;
        com.tencent.bugly.proguard.an.c(r7, r8);
    L_0x00dc:
        r7 = r0;
    L_0x00dd:
        if (r7 >= r5) goto L_0x012b;
    L_0x00df:
        r8 = r2.poll();
        r8 = (java.lang.Runnable) r8;
        if (r8 == 0) goto L_0x012b;
    L_0x00e7:
        r10 = r13.k;
        monitor-enter(r10);
        r11 = r13.v;	 Catch:{ all -> 0x0128 }
        if (r11 < r6) goto L_0x00f5;
    L_0x00ee:
        if (r1 == 0) goto L_0x00f5;
    L_0x00f0:
        r1.a(r8);	 Catch:{ all -> 0x0128 }
        monitor-exit(r10);	 Catch:{ all -> 0x0128 }
        goto L_0x0125;
    L_0x00f5:
        monitor-exit(r10);	 Catch:{ all -> 0x0128 }
        r10 = "[UploadManager] Create and start a new thread to execute a upload task: %s";
        r11 = new java.lang.Object[r9];
        r12 = "BUGLY_ASYNC_UPLOAD";
        r11[r0] = r12;
        com.tencent.bugly.proguard.an.a(r10, r11);
        r10 = new com.tencent.bugly.proguard.ak$1;
        r10.<init>(r13, r8);
        r11 = "BUGLY_ASYNC_UPLOAD";
        r10 = com.tencent.bugly.proguard.ap.a(r10, r11);
        if (r10 == 0) goto L_0x011b;
    L_0x010e:
        r10 = r13.k;
        monitor-enter(r10);
        r8 = r13.v;	 Catch:{ all -> 0x0118 }
        r8 = r8 + r9;
        r13.v = r8;	 Catch:{ all -> 0x0118 }
        monitor-exit(r10);	 Catch:{ all -> 0x0118 }
        goto L_0x0125;
    L_0x0118:
        r14 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0118 }
        throw r14;
    L_0x011b:
        r10 = "[UploadManager] Failed to start a thread to execute asynchronous upload task, will try again next time.";
        r11 = new java.lang.Object[r0];
        com.tencent.bugly.proguard.an.d(r10, r11);
        r13.a(r8, r9);
    L_0x0125:
        r7 = r7 + 1;
        goto L_0x00dd;
    L_0x0128:
        r14 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x0128 }
        throw r14;
    L_0x012b:
        if (r14 <= 0) goto L_0x014e;
    L_0x012d:
        r2 = "[UploadManager] Execute upload tasks of queue which has %d tasks (pid=%d | tid=%d)";
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r14);
        r4[r0] = r5;
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r4[r9] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r4[r6] = r0;
        com.tencent.bugly.proguard.an.c(r2, r4);
    L_0x014e:
        if (r1 == 0) goto L_0x0158;
    L_0x0150:
        r0 = new com.tencent.bugly.proguard.ak$2;
        r0.<init>(r13, r14, r3);
        r1.a(r0);
    L_0x0158:
        return;
    L_0x0159:
        r14 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0159 }
        throw r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.c(int):void");
    }

    private boolean a(Runnable runnable, boolean z) {
        if (runnable == null) {
            an.a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            an.c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.k) {
                if (z) {
                    this.i.put(runnable);
                } else {
                    this.j.put(runnable);
                }
            }
            return true;
        } catch (Runnable runnable2) {
            an.e("[UploadManager] Failed to add upload task to queue: %s", runnable2.getMessage());
            return false;
        }
    }

    private void a(Runnable runnable, long j) {
        if (runnable == null) {
            an.d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        an.c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread a = ap.a(runnable, "BUGLY_SYNC_UPLOAD");
        if (a == null) {
            an.e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            a(runnable, true);
            return;
        }
        try {
            a.join(j);
        } catch (long j2) {
            an.e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", j2.getMessage());
            a(runnable, true);
            c(0);
        }
    }

    private void a(Runnable runnable, boolean z, boolean z2, long j) {
        an.c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (z2) {
            a(new a(this, this.e, runnable, j), 0);
            return;
        }
        a(runnable, z);
        Runnable aVar = new a(this, this.e);
        an.a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
        if (ap.a(aVar, "BUGLY_ASYNC_UPLOAD") == null) {
            an.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
            am a = am.a();
            if (a != null) {
                a.a(aVar);
                return;
            }
            an.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
            synchronized (this.u) {
                try {
                    this.t = false;
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
        }
    }

    private void b(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            an.d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        an.c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.q != null) {
            if (b()) {
                an.c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    a(runnable, j);
                    return;
                }
                a(runnable, z);
                c(0);
                return;
            }
            an.a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            b(false);
        }
        synchronized (this.u) {
            if (this.t) {
                a(runnable, z);
                return;
            }
            this.t = true;
            a(runnable, z, z2, j);
        }
    }

    public void a(int r10, com.tencent.bugly.proguard.be r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        r0 = r9.b;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = 2;
        r1 = 1;
        r2 = 0;
        if (r10 != r0) goto L_0x002a;
    L_0x000a:
        r10 = "[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)";
        r11 = new java.lang.Object[r0];
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r2] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r1] = r0;
        com.tencent.bugly.proguard.an.c(r10, r11);
        r9.b(r1);
        goto L_0x0126;
    L_0x002a:
        r10 = r9.u;
        monitor-enter(r10);
        r3 = r9.t;	 Catch:{ all -> 0x013b }
        if (r3 != 0) goto L_0x0033;	 Catch:{ all -> 0x013b }
    L_0x0031:
        monitor-exit(r10);	 Catch:{ all -> 0x013b }
        return;	 Catch:{ all -> 0x013b }
    L_0x0033:
        monitor-exit(r10);	 Catch:{ all -> 0x013b }
        if (r11 == 0) goto L_0x0108;
    L_0x0036:
        r10 = "[UploadManager] Record security context (pid=%d | tid=%d)";
        r3 = new java.lang.Object[r0];
        r4 = android.os.Process.myPid();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r2] = r4;
        r4 = android.os.Process.myTid();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        com.tencent.bugly.proguard.an.c(r10, r3);
        r10 = r11.h;	 Catch:{ Throwable -> 0x00fe }
        if (r10 == 0) goto L_0x0102;	 Catch:{ Throwable -> 0x00fe }
    L_0x0055:
        r3 = "S1";	 Catch:{ Throwable -> 0x00fe }
        r3 = r10.containsKey(r3);	 Catch:{ Throwable -> 0x00fe }
        if (r3 == 0) goto L_0x0102;	 Catch:{ Throwable -> 0x00fe }
    L_0x005d:
        r3 = "S2";	 Catch:{ Throwable -> 0x00fe }
        r3 = r10.containsKey(r3);	 Catch:{ Throwable -> 0x00fe }
        if (r3 == 0) goto L_0x0102;	 Catch:{ Throwable -> 0x00fe }
    L_0x0065:
        r3 = r11.e;	 Catch:{ Throwable -> 0x00fe }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00fe }
        r7 = r3 - r5;	 Catch:{ Throwable -> 0x00fe }
        r9.n = r7;	 Catch:{ Throwable -> 0x00fe }
        r11 = "[UploadManager] Time lag of server is: %d";	 Catch:{ Throwable -> 0x00fe }
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fe }
        r4 = r9.n;	 Catch:{ Throwable -> 0x00fe }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x00fe }
        r3[r2] = r4;	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.an.c(r11, r3);	 Catch:{ Throwable -> 0x00fe }
        r11 = "S1";	 Catch:{ Throwable -> 0x00fe }
        r11 = r10.get(r11);	 Catch:{ Throwable -> 0x00fe }
        r11 = (java.lang.String) r11;	 Catch:{ Throwable -> 0x00fe }
        r9.q = r11;	 Catch:{ Throwable -> 0x00fe }
        r11 = "[UploadManager] Session ID from server is: %s";	 Catch:{ Throwable -> 0x00fe }
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00fe }
        r4 = r9.q;	 Catch:{ Throwable -> 0x00fe }
        r3[r2] = r4;	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.an.c(r11, r3);	 Catch:{ Throwable -> 0x00fe }
        r11 = r9.q;	 Catch:{ Throwable -> 0x00fe }
        r11 = r11.length();	 Catch:{ Throwable -> 0x00fe }
        if (r11 <= 0) goto L_0x00f6;
    L_0x009b:
        r3 = 259200000; // 0xf731400 float:1.1984677E-29 double:1.280618154E-315;
        r11 = "S2";	 Catch:{ NumberFormatException -> 0x00da }
        r10 = r10.get(r11);	 Catch:{ NumberFormatException -> 0x00da }
        r10 = (java.lang.String) r10;	 Catch:{ NumberFormatException -> 0x00da }
        r10 = java.lang.Long.parseLong(r10);	 Catch:{ NumberFormatException -> 0x00da }
        r9.r = r10;	 Catch:{ NumberFormatException -> 0x00da }
        r10 = "[UploadManager] Session expired time from server is: %d(%s)";	 Catch:{ NumberFormatException -> 0x00da }
        r11 = new java.lang.Object[r0];	 Catch:{ NumberFormatException -> 0x00da }
        r5 = r9.r;	 Catch:{ NumberFormatException -> 0x00da }
        r0 = java.lang.Long.valueOf(r5);	 Catch:{ NumberFormatException -> 0x00da }
        r11[r2] = r0;	 Catch:{ NumberFormatException -> 0x00da }
        r0 = new java.util.Date;	 Catch:{ NumberFormatException -> 0x00da }
        r5 = r9.r;	 Catch:{ NumberFormatException -> 0x00da }
        r0.<init>(r5);	 Catch:{ NumberFormatException -> 0x00da }
        r0 = r0.toString();	 Catch:{ NumberFormatException -> 0x00da }
        r11[r1] = r0;	 Catch:{ NumberFormatException -> 0x00da }
        com.tencent.bugly.proguard.an.c(r10, r11);	 Catch:{ NumberFormatException -> 0x00da }
        r10 = r9.r;	 Catch:{ NumberFormatException -> 0x00da }
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ NumberFormatException -> 0x00da }
        r0 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));	 Catch:{ NumberFormatException -> 0x00da }
        if (r0 >= 0) goto L_0x00e3;	 Catch:{ NumberFormatException -> 0x00da }
    L_0x00d0:
        r10 = "[UploadManager] Session expired time from server is less than 1 second, will set to default value";	 Catch:{ NumberFormatException -> 0x00da }
        r11 = new java.lang.Object[r2];	 Catch:{ NumberFormatException -> 0x00da }
        com.tencent.bugly.proguard.an.d(r10, r11);	 Catch:{ NumberFormatException -> 0x00da }
        r9.r = r3;	 Catch:{ NumberFormatException -> 0x00da }
        goto L_0x00e3;
    L_0x00da:
        r10 = "[UploadManager] Session expired time is invalid, will set to default value";	 Catch:{ Throwable -> 0x00fe }
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.an.d(r10, r11);	 Catch:{ Throwable -> 0x00fe }
        r9.r = r3;	 Catch:{ Throwable -> 0x00fe }
    L_0x00e3:
        r10 = r9.d();	 Catch:{ Throwable -> 0x00fe }
        if (r10 == 0) goto L_0x00eb;	 Catch:{ Throwable -> 0x00fe }
    L_0x00e9:
        r1 = r2;	 Catch:{ Throwable -> 0x00fe }
        goto L_0x00f2;	 Catch:{ Throwable -> 0x00fe }
    L_0x00eb:
        r10 = "[UploadManager] Failed to record database";	 Catch:{ Throwable -> 0x00fe }
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.an.c(r10, r11);	 Catch:{ Throwable -> 0x00fe }
    L_0x00f2:
        r9.c(r2);	 Catch:{ Throwable -> 0x00fe }
        goto L_0x0102;	 Catch:{ Throwable -> 0x00fe }
    L_0x00f6:
        r10 = "[UploadManager] Session ID from server is invalid, try next time";	 Catch:{ Throwable -> 0x00fe }
        r11 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00fe }
        com.tencent.bugly.proguard.an.c(r10, r11);	 Catch:{ Throwable -> 0x00fe }
        goto L_0x0102;
    L_0x00fe:
        r10 = move-exception;
        com.tencent.bugly.proguard.an.a(r10);
    L_0x0102:
        if (r1 == 0) goto L_0x0126;
    L_0x0104:
        r9.b(r2);
        goto L_0x0126;
    L_0x0108:
        r10 = "[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)";
        r11 = new java.lang.Object[r0];
        r0 = android.os.Process.myPid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r2] = r0;
        r0 = android.os.Process.myTid();
        r0 = java.lang.Integer.valueOf(r0);
        r11[r1] = r0;
        com.tencent.bugly.proguard.an.c(r10, r11);
        r9.b(r2);
    L_0x0126:
        r11 = r9.u;
        monitor-enter(r11);
        r10 = r9.t;	 Catch:{ all -> 0x0138 }
        if (r10 == 0) goto L_0x0136;	 Catch:{ all -> 0x0138 }
    L_0x012d:
        r9.t = r2;	 Catch:{ all -> 0x0138 }
        r10 = r9.e;	 Catch:{ all -> 0x0138 }
        r0 = "security_info";	 Catch:{ all -> 0x0138 }
        com.tencent.bugly.proguard.ap.b(r10, r0);	 Catch:{ all -> 0x0138 }
    L_0x0136:
        monitor-exit(r11);	 Catch:{ all -> 0x0138 }
        return;	 Catch:{ all -> 0x0138 }
    L_0x0138:
        r10 = move-exception;	 Catch:{ all -> 0x0138 }
        monitor-exit(r11);	 Catch:{ all -> 0x0138 }
        throw r10;
    L_0x013b:
        r11 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x013b }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.a(int, com.tencent.bugly.proguard.be):void");
    }

    public byte[] a(byte[] bArr) {
        if (this.o != null) {
            if (this.o.length * 8 == 128) {
                return ap.a(1, bArr, this.o);
            }
        }
        an.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    public byte[] b(byte[] bArr) {
        if (this.o != null) {
            if (this.o.length * 8 == 128) {
                return ap.a(2, bArr, this.o);
            }
        }
        an.d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        return null;
    }

    public boolean a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        an.c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.q != null) {
            map.put("secureSessionId", this.q);
            return true;
        }
        if (this.o != null) {
            if (this.o.length * 8 == 128) {
                if (this.m == null) {
                    this.m = Base64.decode(this.l, 0);
                    if (this.m == null) {
                        an.d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                        return false;
                    }
                }
                byte[] b = ap.b(1, this.o, this.m);
                if (b == null) {
                    an.d("[UploadManager] Failed to encrypt AES key", new Object[0]);
                    return false;
                }
                String encodeToString = Base64.encodeToString(b, 0);
                if (encodeToString == null) {
                    an.d("[UploadManager] Failed to encode AES key", new Object[0]);
                    return false;
                }
                map.put("raKey", encodeToString);
                return true;
            }
        }
        an.d("[UploadManager] AES key is invalid", new Object[0]);
        return false;
    }
}
