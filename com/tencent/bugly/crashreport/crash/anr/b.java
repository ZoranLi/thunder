package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import com.qihoo360.replugin.RePlugin;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.proguard.c;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* compiled from: BUGLY */
public class b {
    private AtomicInteger a = new AtomicInteger(0);
    private long b = -1;
    private final Context c;
    private final a d;
    private final am e;
    private final com.tencent.bugly.crashreport.common.strategy.a f;
    private final String g;
    private final com.tencent.bugly.crashreport.crash.b h;
    private FileObserver i;
    private boolean j = true;

    public b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, a aVar2, am amVar, ae aeVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        this.c = ap.a(context);
        this.g = context.getDir("bugly", 0).getAbsolutePath();
        this.d = aVar2;
        this.e = amVar;
        this.f = aVar;
        this.h = bVar;
    }

    protected ProcessErrorStateInfo a(Context context, long j) {
        if (j < 0) {
            j = 0;
        }
        an.c("to find!", new Object[0]);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        j /= 500;
        int i = 0;
        while (true) {
            an.c("waiting!", new Object[0]);
            List<ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2) {
                        an.c("found!", new Object[0]);
                        return processErrorStateInfo;
                    }
                }
            }
            ap.b(500);
            int i2 = i + 1;
            if (((long) i) >= j) {
                an.c("end!", new Object[0]);
                return null;
            }
            i = i2;
        }
    }

    protected a a(Context context, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        context = context.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder("bugly/bugly_trace_");
        stringBuilder.append(j);
        stringBuilder.append(c.n);
        File file = new File(context, stringBuilder.toString());
        context = new a();
        context.c = j;
        context.d = file.getAbsolutePath();
        context.a = processErrorStateInfo.processName;
        context.f = processErrorStateInfo.shortMsg;
        context.e = processErrorStateInfo.longMsg;
        context.b = map;
        if (map != null) {
            for (String str : map.keySet()) {
                if (str.startsWith("main(")) {
                    context.g = (String) map.get(str);
                }
            }
        }
        processErrorStateInfo = "anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d";
        j = new Object[6];
        map = null;
        j[0] = Long.valueOf(context.c);
        j[1] = context.d;
        j[2] = context.a;
        j[3] = context.f;
        j[4] = context.e;
        if (context.b != null) {
            map = context.b.size();
        }
        j[5] = Integer.valueOf(map);
        an.c(processErrorStateInfo, j);
        return context;
    }

    protected CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.k();
            crashDetailBean.E = this.d.p();
            crashDetailBean.F = this.d.o();
            crashDetailBean.G = this.d.q();
            crashDetailBean.w = ap.a(this.c, com.tencent.bugly.crashreport.crash.c.e, com.tencent.bugly.crashreport.crash.c.h);
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.o;
            crashDetailBean.g = this.d.w();
            crashDetailBean.m = this.d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.O = new HashMap();
            crashDetailBean.O.put("BUGLY_CR_01", aVar.e);
            int i = -1;
            if (crashDetailBean.q != null) {
                i = crashDetailBean.q.indexOf("\n");
            }
            crashDetailBean.p = i > 0 ? crashDetailBean.q.substring(0, i) : "GET_FAIL";
            crashDetailBean.r = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.u = ap.b(crashDetailBean.q.getBytes());
            }
            crashDetailBean.y = aVar.b;
            crashDetailBean.z = this.d.e;
            crashDetailBean.A = "main(1)";
            crashDetailBean.H = this.d.y();
            crashDetailBean.h = this.d.v();
            crashDetailBean.i = this.d.K();
            crashDetailBean.v = aVar.d;
            crashDetailBean.L = this.d.s;
            crashDetailBean.M = this.d.a;
            crashDetailBean.N = this.d.a();
            crashDetailBean.P = this.d.H();
            crashDetailBean.Q = this.d.I();
            crashDetailBean.R = this.d.B();
            crashDetailBean.S = this.d.G();
            this.h.c(crashDetailBean);
            crashDetailBean.x = ao.a();
        } catch (a aVar2) {
            if (!an.a(aVar2)) {
                aVar2.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    protected boolean a(String str, String str2, String str3) {
        Object[] objArr;
        StringBuilder stringBuilder;
        str = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (!(str == null || str.d == null)) {
            if (str.d.size() > 0) {
                str3 = new File(str2);
                try {
                    if (!str3.exists()) {
                        if (!str3.getParentFile().exists()) {
                            str3.getParentFile().mkdirs();
                        }
                        str3.createNewFile();
                    }
                    if (str3.exists()) {
                        if (str3.canWrite()) {
                            str2 = null;
                            try {
                                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str3, false));
                                try {
                                    String str4;
                                    String str5;
                                    String[] strArr = (String[]) str.d.get(RePlugin.PLUGIN_NAME_MAIN);
                                    if (strArr != null && strArr.length >= 3) {
                                        str4 = strArr[0];
                                        str5 = strArr[1];
                                        str2 = strArr[2];
                                        StringBuilder stringBuilder2 = new StringBuilder("\"main\" tid=");
                                        stringBuilder2.append(str2);
                                        stringBuilder2.append(" :\n");
                                        stringBuilder2.append(str4);
                                        stringBuilder2.append("\n");
                                        stringBuilder2.append(str5);
                                        stringBuilder2.append("\n\n");
                                        bufferedWriter.write(stringBuilder2.toString());
                                        bufferedWriter.flush();
                                    }
                                    for (Entry entry : str.d.entrySet()) {
                                        if (!(((String) entry.getKey()).equals(RePlugin.PLUGIN_NAME_MAIN) || entry.getValue() == null || ((String[]) entry.getValue()).length < 3)) {
                                            str4 = ((String[]) entry.getValue())[0];
                                            str5 = ((String[]) entry.getValue())[1];
                                            String str6 = ((String[]) entry.getValue())[2];
                                            StringBuilder stringBuilder3 = new StringBuilder("\"");
                                            stringBuilder3.append((String) entry.getKey());
                                            stringBuilder3.append("\" tid=");
                                            stringBuilder3.append(str6);
                                            stringBuilder3.append(" :\n");
                                            stringBuilder3.append(str4);
                                            stringBuilder3.append("\n");
                                            stringBuilder3.append(str5);
                                            stringBuilder3.append("\n\n");
                                            bufferedWriter.write(stringBuilder3.toString());
                                            bufferedWriter.flush();
                                        }
                                    }
                                    try {
                                        bufferedWriter.close();
                                    } catch (String str7) {
                                        if (an.a(str7) == null) {
                                            str7.printStackTrace();
                                        }
                                    }
                                    return true;
                                } catch (IOException e) {
                                    str7 = e;
                                    str2 = bufferedWriter;
                                    try {
                                        if (an.a(str7) == null) {
                                            str7.printStackTrace();
                                        }
                                        objArr = new Object[1];
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str7.getClass().getName());
                                        stringBuilder.append(Constants.COLON_SEPARATOR);
                                        stringBuilder.append(str7.getMessage());
                                        objArr[0] = stringBuilder.toString();
                                        an.e("dump trace fail %s", objArr);
                                        if (str2 != null) {
                                            try {
                                                str2.close();
                                            } catch (String str72) {
                                                if (an.a(str72) == null) {
                                                    str72.printStackTrace();
                                                }
                                            }
                                        }
                                        return false;
                                    } catch (Throwable th) {
                                        str72 = th;
                                        bufferedWriter = str2;
                                        if (bufferedWriter != null) {
                                            try {
                                                bufferedWriter.close();
                                            } catch (String str22) {
                                                if (an.a(str22) == null) {
                                                    str22.printStackTrace();
                                                }
                                            }
                                        }
                                        throw str72;
                                    }
                                } catch (Throwable th2) {
                                    str72 = th2;
                                    if (bufferedWriter != null) {
                                        bufferedWriter.close();
                                    }
                                    throw str72;
                                }
                            } catch (IOException e2) {
                                str72 = e2;
                                if (an.a(str72) == null) {
                                    str72.printStackTrace();
                                }
                                objArr = new Object[1];
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(str72.getClass().getName());
                                stringBuilder.append(Constants.COLON_SEPARATOR);
                                stringBuilder.append(str72.getMessage());
                                objArr[0] = stringBuilder.toString();
                                an.e("dump trace fail %s", objArr);
                                if (str22 != null) {
                                    str22.close();
                                }
                                return false;
                            }
                        }
                    }
                    an.e("backup file create fail %s", new Object[]{str22});
                    return false;
                } catch (String str722) {
                    if (an.a(str722) == null) {
                        str722.printStackTrace();
                    }
                    Object[] objArr2 = new Object[2];
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(str722.getClass().getName());
                    stringBuilder4.append(Constants.COLON_SEPARATOR);
                    stringBuilder4.append(str722.getMessage());
                    objArr2[0] = stringBuilder4.toString();
                    objArr2[1] = str22;
                    an.e("backup file create error! %s  %s", objArr2);
                    return false;
                }
            }
        }
        an.e("not found trace dump for %s", new Object[]{str3});
        return false;
    }

    public boolean a() {
        return this.a.get() != 0;
    }

    protected boolean a(Context context, String str, ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        this.f.c();
        if (!this.f.b()) {
            an.e("waiting for remote sync", new Object[0]);
            int i = 0;
            while (!this.f.b()) {
                ap.b(500);
                i += 500;
                if (i >= 3000) {
                    break;
                }
            }
        }
        a a = a(context, processErrorStateInfo, j, map);
        if (this.f.b() == null) {
            an.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
            com.tencent.bugly.crashreport.crash.b.a("ANR", ap.a(), a.a, null, a.e, null);
            return false;
        } else if (this.f.c().j == null) {
            an.d("ANR Report is closed!", new Object[0]);
            return false;
        } else {
            an.a("found visiable anr , start to upload!", new Object[0]);
            CrashDetailBean a2 = a(a);
            if (a2 == null) {
                an.e("pack anr fail!", new Object[0]);
                return false;
            }
            com.tencent.bugly.crashreport.crash.c.a().a(a2);
            if (a2.a >= 0) {
                an.a("backup anr record success!", new Object[0]);
            } else {
                an.d("backup anr record fail!", new Object[0]);
            }
            if (!(str == null || new File(str).exists() == null)) {
                this.a.set(3);
                if (a(str, a.d, a.a) != null) {
                    an.a("backup trace success", new Object[0]);
                }
            }
            com.tencent.bugly.crashreport.crash.b.a("ANR", ap.a(), a.a, null, a.e, a2);
            if (this.h.a(a2) == null) {
                this.h.a(a2, 3000, true);
            }
            this.h.b(a2);
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11) {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.a;	 Catch:{ all -> 0x00fa }
        r0 = r0.get();	 Catch:{ all -> 0x00fa }
        r1 = 0;
        if (r0 == 0) goto L_0x0013;
    L_0x000a:
        r11 = "trace started return ";
        r0 = new java.lang.Object[r1];	 Catch:{ all -> 0x00fa }
        com.tencent.bugly.proguard.an.c(r11, r0);	 Catch:{ all -> 0x00fa }
        monitor-exit(r10);	 Catch:{ all -> 0x00fa }
        return;
    L_0x0013:
        r0 = r10.a;	 Catch:{ all -> 0x00fa }
        r2 = 1;
        r0.set(r2);	 Catch:{ all -> 0x00fa }
        monitor-exit(r10);	 Catch:{ all -> 0x00fa }
        r0 = "read trace first dump for create time!";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.c(r0, r3);	 Catch:{ Throwable -> 0x00d8 }
        r0 = com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readFirstDumpInfo(r11, r1);	 Catch:{ Throwable -> 0x00d8 }
        r3 = -1;
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r5 = r0.c;	 Catch:{ Throwable -> 0x00d8 }
        goto L_0x002d;
    L_0x002c:
        r5 = r3;
    L_0x002d:
        r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1));
        if (r0 != 0) goto L_0x003c;
    L_0x0031:
        r0 = "trace dump fail could not get time!";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.d(r0, r3);	 Catch:{ Throwable -> 0x00d8 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x00d8 }
    L_0x003c:
        r7 = r5;
        r3 = r10.b;	 Catch:{ Throwable -> 0x00d8 }
        r5 = r7 - r3;
        r3 = java.lang.Math.abs(r5);	 Catch:{ Throwable -> 0x00d8 }
        r5 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r0 >= 0) goto L_0x0060;
    L_0x004b:
        r11 = "should not process ANR too Fre in %d";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00d8 }
        r3 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Throwable -> 0x00d8 }
        r0[r1] = r3;	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.d(r11, r0);	 Catch:{ Throwable -> 0x00d8 }
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x0060:
        r10.b = r7;	 Catch:{ Throwable -> 0x00d8 }
        r0 = r10.a;	 Catch:{ Throwable -> 0x00d8 }
        r0.set(r2);	 Catch:{ Throwable -> 0x00d8 }
        r0 = com.tencent.bugly.crashreport.crash.c.f;	 Catch:{ Throwable -> 0x00c5 }
        r9 = com.tencent.bugly.proguard.ap.a(r0, r1);	 Catch:{ Throwable -> 0x00c5 }
        if (r9 == 0) goto L_0x00b8;
    L_0x006f:
        r0 = r9.size();	 Catch:{ Throwable -> 0x00d8 }
        if (r0 > 0) goto L_0x0076;
    L_0x0075:
        goto L_0x00b8;
    L_0x0076:
        r0 = r10.c;	 Catch:{ Throwable -> 0x00d8 }
        r6 = r10.a(r0, r5);	 Catch:{ Throwable -> 0x00d8 }
        if (r6 != 0) goto L_0x008b;
    L_0x007e:
        r11 = "proc state is unvisiable!";
        r0 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.c(r11, r0);	 Catch:{ Throwable -> 0x00d8 }
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x008b:
        r0 = r6.pid;	 Catch:{ Throwable -> 0x00d8 }
        r3 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x00d8 }
        if (r0 == r3) goto L_0x00a4;
    L_0x0093:
        r11 = "not mind proc!";
        r0 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00d8 }
        r3 = r6.processName;	 Catch:{ Throwable -> 0x00d8 }
        r0[r1] = r3;	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.c(r11, r0);	 Catch:{ Throwable -> 0x00d8 }
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x00a4:
        r0 = "found visiable anr , start to process!";
        r3 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.a(r0, r3);	 Catch:{ Throwable -> 0x00d8 }
        r4 = r10.c;	 Catch:{ Throwable -> 0x00d8 }
        r3 = r10;
        r5 = r11;
        r3.a(r4, r5, r6, r7, r9);	 Catch:{ Throwable -> 0x00d8 }
    L_0x00b2:
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x00b8:
        r11 = "can't get all thread skip this anr";
        r0 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.d(r11, r0);	 Catch:{ Throwable -> 0x00d8 }
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x00c5:
        r11 = move-exception;
        com.tencent.bugly.proguard.an.a(r11);	 Catch:{ Throwable -> 0x00d8 }
        r11 = "get all thread stack fail!";
        r0 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00d8 }
        com.tencent.bugly.proguard.an.e(r11, r0);	 Catch:{ Throwable -> 0x00d8 }
        r11 = r10.a;
        r11.set(r1);
        return;
    L_0x00d6:
        r11 = move-exception;
        goto L_0x00f4;
    L_0x00d8:
        r11 = move-exception;
        r0 = com.tencent.bugly.proguard.an.a(r11);	 Catch:{ all -> 0x00d6 }
        if (r0 != 0) goto L_0x00e2;
    L_0x00df:
        r11.printStackTrace();	 Catch:{ all -> 0x00d6 }
    L_0x00e2:
        r0 = "handle anr error %s";
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00d6 }
        r11 = r11.getClass();	 Catch:{ all -> 0x00d6 }
        r11 = r11.toString();	 Catch:{ all -> 0x00d6 }
        r2[r1] = r11;	 Catch:{ all -> 0x00d6 }
        com.tencent.bugly.proguard.an.e(r0, r2);	 Catch:{ all -> 0x00d6 }
        goto L_0x00b2;
    L_0x00f4:
        r0 = r10.a;
        r0.set(r1);
        throw r11;
    L_0x00fa:
        r11 = move-exception;
        monitor-exit(r10);	 Catch:{ all -> 0x00fa }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(java.lang.String):void");
    }

    protected synchronized void b() {
        if (d()) {
            an.d("start when started!", new Object[0]);
            return;
        }
        this.i = new FileObserver(this, "/data/anr/", 8) {
            final /* synthetic */ b a;

            public void onEvent(int i, String str) {
                if (str != null) {
                    i = new StringBuilder("/data/anr/");
                    i.append(str);
                    String stringBuilder = i.toString();
                    if (stringBuilder.contains(AgooConstants.MESSAGE_TRACE) == null) {
                        an.d("not anr file %s", stringBuilder);
                        return;
                    }
                    this.a.a(stringBuilder);
                }
            }
        };
        try {
            this.i.startWatching();
            an.a("start anr monitor!", new Object[0]);
            this.e.a(new Runnable(this) {
                final /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.f();
                }
            });
        } catch (Throwable th) {
            this.i = null;
            an.d("start anr monitor failed!", new Object[0]);
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
    }

    protected synchronized void c() {
        if (d()) {
            try {
                this.i.stopWatching();
                this.i = null;
                an.d("close anr monitor!", new Object[0]);
                return;
            } catch (Throwable th) {
                an.d("stop anr monitor failed!", new Object[0]);
                if (!an.a(th)) {
                    th.printStackTrace();
                }
                return;
            }
        }
        an.d("close when closed!", new Object[0]);
    }

    protected synchronized boolean d() {
        return this.i != null;
    }

    protected synchronized void a(boolean z) {
        if (z) {
            b();
        } else {
            c();
        }
    }

    public synchronized boolean e() {
        return this.j;
    }

    private synchronized void c(boolean z) {
        if (this.j != z) {
            an.a("user change anr %b", Boolean.valueOf(z));
            this.j = z;
        }
    }

    public void b(boolean z) {
        c(z);
        z = e();
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null) {
            z = z && a.c().g;
        }
        if (z != d()) {
            an.a("anr changed to %b", Boolean.valueOf(z));
            a(z);
        }
    }

    protected void f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r15 = this;
        r0 = com.tencent.bugly.proguard.ap.b();
        r2 = com.tencent.bugly.crashreport.crash.c.g;
        r4 = r0 - r2;
        r0 = new java.io.File;
        r1 = r15.g;
        r0.<init>(r1);
        r1 = r0.exists();
        if (r1 == 0) goto L_0x0076;
    L_0x0015:
        r1 = r0.isDirectory();
        if (r1 == 0) goto L_0x0076;
    L_0x001b:
        r0 = r0.listFiles();
        if (r0 == 0) goto L_0x0075;
    L_0x0021:
        r1 = r0.length;
        if (r1 != 0) goto L_0x0025;
    L_0x0024:
        goto L_0x0075;
    L_0x0025:
        r1 = "bugly_trace_";
        r2 = ".txt";
        r3 = r1.length();
        r6 = 0;
        r7 = r0.length;
        r8 = r6;
        r9 = r8;
    L_0x0031:
        r10 = 1;
        if (r8 >= r7) goto L_0x0067;
    L_0x0034:
        r11 = r0[r8];
        r12 = r11.getName();
        r13 = r12.startsWith(r1);
        if (r13 == 0) goto L_0x0064;
    L_0x0040:
        r13 = r12.indexOf(r2);	 Catch:{ Throwable -> 0x0053 }
        if (r13 <= 0) goto L_0x005c;	 Catch:{ Throwable -> 0x0053 }
    L_0x0046:
        r13 = r12.substring(r3, r13);	 Catch:{ Throwable -> 0x0053 }
        r13 = java.lang.Long.parseLong(r13);	 Catch:{ Throwable -> 0x0053 }
        r10 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x005c;
    L_0x0052:
        goto L_0x0064;
    L_0x0053:
        r13 = "tomb format error delete %s";
        r10 = new java.lang.Object[r10];
        r10[r6] = r12;
        com.tencent.bugly.proguard.an.e(r13, r10);
    L_0x005c:
        r10 = r11.delete();
        if (r10 == 0) goto L_0x0064;
    L_0x0062:
        r9 = r9 + 1;
    L_0x0064:
        r8 = r8 + 1;
        goto L_0x0031;
    L_0x0067:
        r0 = "clean tombs %d";
        r1 = new java.lang.Object[r10];
        r2 = java.lang.Integer.valueOf(r9);
        r1[r6] = r2;
        com.tencent.bugly.proguard.an.c(r0, r1);
        goto L_0x0076;
    L_0x0075:
        return;
    L_0x0076:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.f():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.tencent.bugly.crashreport.common.strategy.StrategyBean r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        if (r6 != 0) goto L_0x0005;
    L_0x0003:
        monitor-exit(r5);
        return;
    L_0x0005:
        r0 = r6.j;	 Catch:{ all -> 0x0043 }
        r1 = r5.d();	 Catch:{ all -> 0x0043 }
        r2 = 0;
        r3 = 1;
        if (r0 == r1) goto L_0x001e;
    L_0x000f:
        r0 = "server anr changed to %b";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0043 }
        r4 = r6.j;	 Catch:{ all -> 0x0043 }
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ all -> 0x0043 }
        r1[r2] = r4;	 Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.an.d(r0, r1);	 Catch:{ all -> 0x0043 }
    L_0x001e:
        r6 = r6.j;	 Catch:{ all -> 0x0043 }
        if (r6 == 0) goto L_0x002a;
    L_0x0022:
        r6 = r5.e();	 Catch:{ all -> 0x0043 }
        if (r6 == 0) goto L_0x002a;
    L_0x0028:
        r6 = r3;
        goto L_0x002b;
    L_0x002a:
        r6 = r2;
    L_0x002b:
        r0 = r5.d();	 Catch:{ all -> 0x0043 }
        if (r6 == r0) goto L_0x0041;
    L_0x0031:
        r0 = "anr changed to %b";
        r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0043 }
        r3 = java.lang.Boolean.valueOf(r6);	 Catch:{ all -> 0x0043 }
        r1[r2] = r3;	 Catch:{ all -> 0x0043 }
        com.tencent.bugly.proguard.an.a(r0, r1);	 Catch:{ all -> 0x0043 }
        r5.a(r6);	 Catch:{ all -> 0x0043 }
    L_0x0041:
        monitor-exit(r5);
        return;
    L_0x0043:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(com.tencent.bugly.crashreport.common.strategy.StrategyBean):void");
    }

    public void g() {
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                try {
                    an.a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                    ap.b(5000);
                    i = i2;
                } catch (Throwable th) {
                    if (!an.a(th)) {
                        th.printStackTrace();
                    }
                    return;
                }
            }
            return;
        }
    }
}
