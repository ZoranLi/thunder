package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.b;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import com.umeng.message.proguard.k;
import com.xunlei.common.base.permission.XLAndroidPermissionMiuiOs;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class a implements NativeExceptionHandler {
    private final Context a;
    private final b b;
    private final com.tencent.bugly.crashreport.common.info.a c;
    private final com.tencent.bugly.crashreport.common.strategy.a d;

    public a(Context context, com.tencent.bugly.crashreport.common.info.a aVar, b bVar, com.tencent.bugly.crashreport.common.strategy.a aVar2) {
        this.a = context;
        this.b = bVar;
        this.c = aVar;
        this.d = aVar2;
    }

    public CrashDetailBean packageCrashDatas(String str, String str2, long j, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, byte[] bArr, Map<String, String> map, boolean z) {
        a aVar = this;
        String str11 = str;
        String str12 = str8;
        byte[] bArr2 = bArr;
        boolean m = c.a().m();
        if (m) {
            an.e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.b = 1;
        crashDetailBean.e = aVar.c.h();
        crashDetailBean.f = aVar.c.o;
        crashDetailBean.g = aVar.c.w();
        crashDetailBean.m = aVar.c.g();
        crashDetailBean.n = str3;
        crashDetailBean.o = m ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        crashDetailBean.p = str4;
        crashDetailBean.q = str5 == null ? "" : str5;
        crashDetailBean.r = j;
        crashDetailBean.u = ap.b(crashDetailBean.q.getBytes());
        crashDetailBean.z = str11;
        crashDetailBean.A = str2;
        crashDetailBean.H = aVar.c.y();
        crashDetailBean.h = aVar.c.v();
        crashDetailBean.i = aVar.c.K();
        crashDetailBean.v = str12;
        NativeCrashHandler instance = NativeCrashHandler.getInstance();
        String dumpFilePath = instance != null ? instance.getDumpFilePath() : null;
        str12 = b.a(dumpFilePath, str12);
        if (!ap.a(str12)) {
            crashDetailBean.U = str12;
        }
        crashDetailBean.V = b.c(dumpFilePath);
        crashDetailBean.w = b.a(str9, c.e, c.h);
        crashDetailBean.J = str7;
        crashDetailBean.K = str6;
        crashDetailBean.L = str10;
        crashDetailBean.E = aVar.c.p();
        crashDetailBean.F = aVar.c.o();
        crashDetailBean.G = aVar.c.q();
        if (z) {
            crashDetailBean.B = com.tencent.bugly.crashreport.common.info.b.i();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.k();
            if (crashDetailBean.w == null) {
                crashDetailBean.w = ap.a(aVar.a, c.e, c.h);
            }
            crashDetailBean.x = ao.a();
            crashDetailBean.M = aVar.c.a;
            crashDetailBean.N = aVar.c.a();
            crashDetailBean.P = aVar.c.H();
            crashDetailBean.Q = aVar.c.I();
            crashDetailBean.R = aVar.c.B();
            crashDetailBean.S = aVar.c.G();
            crashDetailBean.y = ap.a(c.f, false);
            str12 = "java:\n";
            int indexOf = crashDetailBean.q.indexOf(str12);
            if (indexOf > 0) {
                indexOf += str12.length();
                if (indexOf < crashDetailBean.q.length()) {
                    str12 = crashDetailBean.q.substring(indexOf, crashDetailBean.q.length() - 1);
                    if (str12.length() > 0 && crashDetailBean.y.containsKey(crashDetailBean.A)) {
                        dumpFilePath = (String) crashDetailBean.y.get(crashDetailBean.A);
                        int indexOf2 = dumpFilePath.indexOf(str12);
                        if (indexOf2 > 0) {
                            str12 = dumpFilePath.substring(indexOf2);
                            crashDetailBean.y.put(crashDetailBean.A, str12);
                            crashDetailBean.q = crashDetailBean.q.substring(0, indexOf);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(crashDetailBean.q);
                            stringBuilder.append(str12);
                            crashDetailBean.q = stringBuilder.toString();
                        }
                    }
                }
            }
            if (str11 == null) {
                crashDetailBean.z = aVar.c.e;
            }
            aVar.b.c(crashDetailBean);
        } else {
            crashDetailBean.B = -1;
            crashDetailBean.C = -1;
            crashDetailBean.D = -1;
            if (crashDetailBean.w == null) {
                crashDetailBean.w = "this crash is occurred at last process! Log is miss, when get an terrible ABRT Native Exception etc.";
            }
            crashDetailBean.M = -1;
            crashDetailBean.P = -1;
            crashDetailBean.Q = -1;
            crashDetailBean.R = map;
            crashDetailBean.S = aVar.c.G();
            crashDetailBean.y = null;
            if (str11 == null) {
                crashDetailBean.z = "unknown(record)";
            }
            if (bArr2 != null) {
                crashDetailBean.x = bArr2;
            }
        }
        return crashDetailBean;
    }

    public void handleNativeException(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7) {
        an.a("Native Crash Happen v1", new Object[0]);
        handleNativeException2(i, i2, j, j2, str, str2, str3, str4, i3, str5, i4, i5, i6, str6, str7, null);
    }

    public void handleNativeException2(int i, int i2, long j, long j2, String str, String str2, String str3, String str4, int i3, String str5, int i4, int i5, int i6, String str6, String str7, String[] strArr) {
        int i7;
        Throwable th;
        Throwable th2;
        a aVar;
        a aVar2 = this;
        String str8 = str2;
        int i8 = i3;
        int i9 = i4;
        String[] strArr2 = strArr;
        an.a("Native Crash Happen v2", new Object[0]);
        if (!aVar2.d.b()) {
            try {
                an.e("waiting for remote sync", new Object[0]);
                i7 = 0;
                while (!aVar2.d.b()) {
                    ap.b(500);
                    i7 += 500;
                    if (i7 >= 3000) {
                        break;
                    }
                }
            } catch (Throwable th22) {
                th = th22;
                aVar = aVar2;
                if (!an.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        try {
            StringBuilder stringBuilder;
            String stringBuilder2;
            String str9;
            String str10;
            String str11;
            String str12;
            StringBuilder stringBuilder3;
            String str13;
            String str14;
            CrashDetailBean packageCrashDatas;
            String str15;
            Thread currentThread;
            boolean z;
            String str16;
            NativeCrashHandler instance;
            Thread currentThread2;
            String b = b.b(str3);
            String str17 = XLAndroidPermissionMiuiOs.UNKNOWN;
            if (i8 > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(k.s);
                stringBuilder.append(str5);
                stringBuilder.append(k.t);
                stringBuilder2 = stringBuilder.toString();
                str9 = str17;
                str10 = "KERNEL";
            } else {
                str11 = str;
                str12 = str5;
                if (i9 > 0) {
                    str17 = AppInfo.a(aVar2.a, i9);
                }
                if (str17.equals(String.valueOf(i4))) {
                    str9 = str17;
                } else {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(str17);
                    stringBuilder4.append(k.s);
                    stringBuilder4.append(i9);
                    stringBuilder4.append(k.t);
                    str9 = stringBuilder4.toString();
                }
                stringBuilder2 = str11;
                str10 = str12;
            }
            if (!aVar2.d.b()) {
                an.d("no remote but still store!", new Object[0]);
            }
            if (!aVar2.d.c().g) {
                if (aVar2.d.b()) {
                    an.e("crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                    str11 = ap.a();
                    str12 = aVar2.c.e;
                    Thread currentThread3 = Thread.currentThread();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder2);
                    stringBuilder.append("\n");
                    stringBuilder.append(str8);
                    stringBuilder.append("\n");
                    stringBuilder.append(b);
                    b.a("NATIVE_CRASH", str11, str12, currentThread3, stringBuilder.toString(), null);
                    ap.b(str4);
                    return;
                }
            }
            Map hashMap = new HashMap();
            if (strArr2 != null) {
                for (String str122 : strArr2) {
                    String[] split = str122.split("=");
                    if (split.length == 2) {
                        hashMap.put(split[0], split[1]);
                    } else {
                        an.d("bad extraMsg %s", str122);
                    }
                }
            } else {
                an.c("not found extraMsg", new Object[0]);
            }
            String str18 = (String) hashMap.get("ExceptionProcessName");
            if (str18 != null) {
                if (str18.length() != 0) {
                    an.c("crash process name change to %s", str18);
                    str17 = (String) hashMap.get("ExceptionThreadName");
                    if (str17 != null) {
                        if (str17.length() == 0) {
                            an.c("crash thread name change to %s", str17);
                            for (Thread thread : Thread.getAllStackTraces().keySet()) {
                                if (thread.getName().equals(str17)) {
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(str17);
                                    stringBuilder3.append(k.s);
                                    stringBuilder3.append(thread.getId());
                                    stringBuilder3.append(k.t);
                                    str17 = stringBuilder3.toString();
                                    break;
                                }
                            }
                            str13 = stringBuilder2;
                            str14 = b;
                            packageCrashDatas = packageCrashDatas(str18, str17, (j * 1000) + (j2 / 1000), stringBuilder2, str8, b, str10, str9, str4, (String) hashMap.get("SysLogPath"), str7, null, null, true);
                            if (packageCrashDatas != null) {
                                try {
                                    an.e("pkg crash datas fail!", new Object[0]);
                                } catch (Throwable th222) {
                                    th = th222;
                                    aVar = this;
                                    if (an.a(th)) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                            str15 = "NATIVE_CRASH";
                            str9 = ap.a();
                            try {
                                str17 = this.c.e;
                                currentThread = Thread.currentThread();
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(str13);
                                stringBuilder3.append("\n");
                                stringBuilder3.append(str2);
                                stringBuilder3.append("\n");
                                stringBuilder3.append(str14);
                                b.a(str15, str9, str17, currentThread, stringBuilder3.toString(), packageCrashDatas);
                                if (aVar.b.a(packageCrashDatas, i3)) {
                                    z = true;
                                    aVar.b.a(packageCrashDatas, 3000, true);
                                } else {
                                    z = true;
                                }
                                aVar.b.b(packageCrashDatas);
                                str16 = null;
                                instance = NativeCrashHandler.getInstance();
                                if (instance != null) {
                                    str16 = instance.getDumpFilePath();
                                }
                                b.a(z, str16);
                                return;
                            } catch (Throwable th3) {
                                th222 = th3;
                                th = th222;
                                if (an.a(th)) {
                                    th.printStackTrace();
                                }
                            }
                        }
                    }
                    currentThread2 = Thread.currentThread();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(currentThread2.getName());
                    stringBuilder3.append(k.s);
                    stringBuilder3.append(currentThread2.getId());
                    stringBuilder3.append(k.t);
                    str17 = stringBuilder3.toString();
                    str13 = stringBuilder2;
                    str14 = b;
                    packageCrashDatas = packageCrashDatas(str18, str17, (j * 1000) + (j2 / 1000), stringBuilder2, str8, b, str10, str9, str4, (String) hashMap.get("SysLogPath"), str7, null, null, true);
                    if (packageCrashDatas != null) {
                        str15 = "NATIVE_CRASH";
                        str9 = ap.a();
                        str17 = this.c.e;
                        currentThread = Thread.currentThread();
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str13);
                        stringBuilder3.append("\n");
                        stringBuilder3.append(str2);
                        stringBuilder3.append("\n");
                        stringBuilder3.append(str14);
                        b.a(str15, str9, str17, currentThread, stringBuilder3.toString(), packageCrashDatas);
                        if (aVar.b.a(packageCrashDatas, i3)) {
                            z = true;
                        } else {
                            z = true;
                            aVar.b.a(packageCrashDatas, 3000, true);
                        }
                        aVar.b.b(packageCrashDatas);
                        str16 = null;
                        instance = NativeCrashHandler.getInstance();
                        if (instance != null) {
                            str16 = instance.getDumpFilePath();
                        }
                        b.a(z, str16);
                        return;
                    }
                    an.e("pkg crash datas fail!", new Object[0]);
                }
            }
            str18 = aVar2.c.e;
            str17 = (String) hashMap.get("ExceptionThreadName");
            if (str17 != null) {
                if (str17.length() == 0) {
                    an.c("crash thread name change to %s", str17);
                    for (Thread thread2 : Thread.getAllStackTraces().keySet()) {
                        if (thread2.getName().equals(str17)) {
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str17);
                            stringBuilder3.append(k.s);
                            stringBuilder3.append(thread2.getId());
                            stringBuilder3.append(k.t);
                            str17 = stringBuilder3.toString();
                            break;
                        }
                    }
                    str13 = stringBuilder2;
                    str14 = b;
                    packageCrashDatas = packageCrashDatas(str18, str17, (j * 1000) + (j2 / 1000), stringBuilder2, str8, b, str10, str9, str4, (String) hashMap.get("SysLogPath"), str7, null, null, true);
                    if (packageCrashDatas != null) {
                        an.e("pkg crash datas fail!", new Object[0]);
                    }
                    str15 = "NATIVE_CRASH";
                    str9 = ap.a();
                    str17 = this.c.e;
                    currentThread = Thread.currentThread();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str13);
                    stringBuilder3.append("\n");
                    stringBuilder3.append(str2);
                    stringBuilder3.append("\n");
                    stringBuilder3.append(str14);
                    b.a(str15, str9, str17, currentThread, stringBuilder3.toString(), packageCrashDatas);
                    if (aVar.b.a(packageCrashDatas, i3)) {
                        z = true;
                        aVar.b.a(packageCrashDatas, 3000, true);
                    } else {
                        z = true;
                    }
                    aVar.b.b(packageCrashDatas);
                    str16 = null;
                    instance = NativeCrashHandler.getInstance();
                    if (instance != null) {
                        str16 = instance.getDumpFilePath();
                    }
                    b.a(z, str16);
                    return;
                }
            }
            currentThread2 = Thread.currentThread();
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(currentThread2.getName());
            stringBuilder3.append(k.s);
            stringBuilder3.append(currentThread2.getId());
            stringBuilder3.append(k.t);
            str17 = stringBuilder3.toString();
            str13 = stringBuilder2;
            str14 = b;
            try {
                packageCrashDatas = packageCrashDatas(str18, str17, (j * 1000) + (j2 / 1000), stringBuilder2, str8, b, str10, str9, str4, (String) hashMap.get("SysLogPath"), str7, null, null, true);
                if (packageCrashDatas != null) {
                    str15 = "NATIVE_CRASH";
                    str9 = ap.a();
                    str17 = this.c.e;
                    currentThread = Thread.currentThread();
                    stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str13);
                    stringBuilder3.append("\n");
                    stringBuilder3.append(str2);
                    stringBuilder3.append("\n");
                    stringBuilder3.append(str14);
                    b.a(str15, str9, str17, currentThread, stringBuilder3.toString(), packageCrashDatas);
                    if (aVar.b.a(packageCrashDatas, i3)) {
                        z = true;
                    } else {
                        z = true;
                        aVar.b.a(packageCrashDatas, 3000, true);
                    }
                    aVar.b.b(packageCrashDatas);
                    str16 = null;
                    instance = NativeCrashHandler.getInstance();
                    if (instance != null) {
                        str16 = instance.getDumpFilePath();
                    }
                    b.a(z, str16);
                    return;
                }
                an.e("pkg crash datas fail!", new Object[0]);
            } catch (Throwable th4) {
                th222 = th4;
                aVar = this;
                th = th222;
                if (an.a(th)) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th5) {
            th222 = th5;
            aVar = aVar2;
            th = th222;
            if (an.a(th)) {
                th.printStackTrace();
            }
        }
    }
}
