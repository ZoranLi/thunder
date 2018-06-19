package com.getui.gtc.a;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.getui.gtc.b.c;
import com.getui.gtc.c.b;
import com.getui.gtc.e.h;
import com.getui.gtc.e.j;
import com.getui.gtc.entity.d;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class e {
    private static e d;
    public Handler a;
    public Context b;
    private c c;
    private List e = new ArrayList();
    private AtomicBoolean f = new AtomicBoolean(false);
    private AtomicBoolean g = new AtomicBoolean(false);

    final class a extends Handler {
        final /* synthetic */ e a;

        a(e eVar, Looper looper) {
            this.a = eVar;
            super(looper);
        }

        public final void handleMessage(android.os.Message r9) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r8 = this;
            r0 = 0;
            r1 = 1;
            r2 = r9.what;	 Catch:{ Throwable -> 0x019b }
            switch(r2) {
                case 1: goto L_0x0147;
                case 2: goto L_0x006b;
                case 3: goto L_0x0061;
                case 4: goto L_0x0016;
                case 5: goto L_0x0012;
                case 6: goto L_0x0008;
                default: goto L_0x0007;
            };	 Catch:{ Throwable -> 0x019b }
        L_0x0007:
            return;	 Catch:{ Throwable -> 0x019b }
        L_0x0008:
            r2 = r8.a;	 Catch:{ Throwable -> 0x019b }
            r9 = r9.obj;	 Catch:{ Throwable -> 0x019b }
            r9 = (com.getui.gtc.entity.d) r9;	 Catch:{ Throwable -> 0x019b }
            r2.a(r9);	 Catch:{ Throwable -> 0x019b }
            return;	 Catch:{ Throwable -> 0x019b }
        L_0x0012:
            com.getui.gtc.a.e.d();	 Catch:{ Throwable -> 0x019b }
            return;
        L_0x0016:
            r9 = r9.getData();	 Catch:{ Throwable -> 0x0060 }
            r0 = "sif";	 Catch:{ Throwable -> 0x0060 }
            r0 = r9.getParcelable(r0);	 Catch:{ Throwable -> 0x0060 }
            r0 = (com.getui.gtc.entity.d) r0;	 Catch:{ Throwable -> 0x0060 }
            r1 = "let";	 Catch:{ Throwable -> 0x0060 }
            r9 = r9.getString(r1);	 Catch:{ Throwable -> 0x0060 }
            r1 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0060 }
            r2 = r0.a;	 Catch:{ Throwable -> 0x0060 }
            r1 = r1.a(r2);	 Catch:{ Throwable -> 0x0060 }
            r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0060 }
            if (r2 != 0) goto L_0x003e;	 Catch:{ Throwable -> 0x0060 }
        L_0x0038:
            r2 = r1.equals(r9);	 Catch:{ Throwable -> 0x0060 }
            if (r2 != 0) goto L_0x0060;	 Catch:{ Throwable -> 0x0060 }
        L_0x003e:
            r2 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0060 }
            r3 = r0.a;	 Catch:{ Throwable -> 0x0060 }
            r2 = r2.a;	 Catch:{ Throwable -> 0x0060 }
            r2 = r2.b;	 Catch:{ Throwable -> 0x0060 }
            r4 = r9.getBytes();	 Catch:{ Throwable -> 0x0060 }
            r5 = com.getui.gtc.a.h.b;	 Catch:{ Throwable -> 0x0060 }
            r4 = com.getui.gtc.e.i.a(r4, r5);	 Catch:{ Throwable -> 0x0060 }
            r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;	 Catch:{ Throwable -> 0x0060 }
            r2.a(r3, r5, r4);	 Catch:{ Throwable -> 0x0060 }
            r2 = r8.a;	 Catch:{ Throwable -> 0x0060 }
            r2 = r2.c;	 Catch:{ Throwable -> 0x0060 }
            r2.a(r0, r9, r1);	 Catch:{ Throwable -> 0x0060 }
        L_0x0060:
            return;
        L_0x0061:
            r2 = r8.a;	 Catch:{ Throwable -> 0x019b }
            r9 = r9.obj;	 Catch:{ Throwable -> 0x019b }
            r9 = (com.getui.gtc.entity.d) r9;	 Catch:{ Throwable -> 0x019b }
            com.getui.gtc.a.e.a(r2, r9);	 Catch:{ Throwable -> 0x019b }
            return;
        L_0x006b:
            r9 = r9.obj;	 Catch:{ Throwable -> 0x013d }
            r9 = (java.lang.String) r9;	 Catch:{ Throwable -> 0x013d }
            r2 = com.getui.gtc.e.l.c(r9);	 Catch:{ Throwable -> 0x013d }
            r3 = com.getui.gtc.e.l.b(r9);	 Catch:{ Throwable -> 0x013d }
            r4 = com.getui.gtc.e.l.d(r9);	 Catch:{ Throwable -> 0x013d }
            r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x013d }
            r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x013d }
            r7 = " init sdk id : ";	 Catch:{ Throwable -> 0x013d }
            r6.<init>(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r2);	 Catch:{ Throwable -> 0x013d }
            r7 = " version : ";	 Catch:{ Throwable -> 0x013d }
            r6.append(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r3);	 Catch:{ Throwable -> 0x013d }
            r7 = " appid : ";	 Catch:{ Throwable -> 0x013d }
            r6.append(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r4);	 Catch:{ Throwable -> 0x013d }
            r6 = r6.toString();	 Catch:{ Throwable -> 0x013d }
            r5[r0] = r6;	 Catch:{ Throwable -> 0x013d }
            r5 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x013d }
            r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x013d }
            r7 = "init sdk id : ";	 Catch:{ Throwable -> 0x013d }
            r6.<init>(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r2);	 Catch:{ Throwable -> 0x013d }
            r7 = " version : ";	 Catch:{ Throwable -> 0x013d }
            r6.append(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r3);	 Catch:{ Throwable -> 0x013d }
            r7 = " appid : ";	 Catch:{ Throwable -> 0x013d }
            r6.append(r7);	 Catch:{ Throwable -> 0x013d }
            r6.append(r4);	 Catch:{ Throwable -> 0x013d }
            r6 = r6.toString();	 Catch:{ Throwable -> 0x013d }
            r5[r0] = r6;	 Catch:{ Throwable -> 0x013d }
            if (r2 == 0) goto L_0x0136;	 Catch:{ Throwable -> 0x013d }
        L_0x00c1:
            r5 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x013d }
            if (r5 != 0) goto L_0x0136;	 Catch:{ Throwable -> 0x013d }
        L_0x00c7:
            r5 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x013d }
            if (r5 != 0) goto L_0x0136;	 Catch:{ Throwable -> 0x013d }
        L_0x00cd:
            r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x013d }
            if (r5 == 0) goto L_0x00d4;	 Catch:{ Throwable -> 0x013d }
        L_0x00d3:
            goto L_0x0136;	 Catch:{ Throwable -> 0x013d }
        L_0x00d4:
            r5 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x013d }
            r5 = r5.a;	 Catch:{ Throwable -> 0x013d }
            r5 = r5.c;	 Catch:{ Throwable -> 0x013d }
            r5 = r5.b;	 Catch:{ Throwable -> 0x013d }
            r5 = r5.get(r2);	 Catch:{ Throwable -> 0x013d }
            r5 = (com.getui.gtc.entity.d) r5;	 Catch:{ Throwable -> 0x013d }
            if (r5 == 0) goto L_0x010f;	 Catch:{ Throwable -> 0x013d }
        L_0x00e6:
            r3 = r5.b;	 Catch:{ Throwable -> 0x013d }
            r6 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x013d }
            if (r6 != 0) goto L_0x00f4;	 Catch:{ Throwable -> 0x013d }
        L_0x00ee:
            r3 = r3.equals(r9);	 Catch:{ Throwable -> 0x013d }
            if (r3 != 0) goto L_0x00fd;	 Catch:{ Throwable -> 0x013d }
        L_0x00f4:
            r5.b = r9;	 Catch:{ Throwable -> 0x013d }
            r9 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x013d }
            r9.a(r5);	 Catch:{ Throwable -> 0x013d }
        L_0x00fd:
            r9 = r5.e;	 Catch:{ Throwable -> 0x013d }
            r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x013d }
            if (r9 == 0) goto L_0x0130;	 Catch:{ Throwable -> 0x013d }
        L_0x0105:
            r5.e = r4;	 Catch:{ Throwable -> 0x013d }
            r9 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x013d }
            r9.a(r2, r4);	 Catch:{ Throwable -> 0x013d }
            goto L_0x0130;	 Catch:{ Throwable -> 0x013d }
        L_0x010f:
            r5 = new com.getui.gtc.entity.d;	 Catch:{ Throwable -> 0x013d }
            r5.<init>();	 Catch:{ Throwable -> 0x013d }
            r5.a = r2;	 Catch:{ Throwable -> 0x013d }
            r5.b = r9;	 Catch:{ Throwable -> 0x013d }
            r5.f = r3;	 Catch:{ Throwable -> 0x013d }
            r9 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x013d }
            if (r9 != 0) goto L_0x0129;	 Catch:{ Throwable -> 0x013d }
        L_0x0120:
            r5.e = r4;	 Catch:{ Throwable -> 0x013d }
            r9 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x013d }
            r9.a(r2, r4);	 Catch:{ Throwable -> 0x013d }
        L_0x0129:
            r9 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x013d }
            r9.a(r5);	 Catch:{ Throwable -> 0x013d }
        L_0x0130:
            r9 = r8.a;	 Catch:{ Throwable -> 0x013d }
            r9.a(r5);	 Catch:{ Throwable -> 0x013d }
            return;	 Catch:{ Throwable -> 0x013d }
        L_0x0136:
            r9 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x013d }
            r2 = "initSDK get sdk info fail";	 Catch:{ Throwable -> 0x013d }
            r9[r0] = r2;	 Catch:{ Throwable -> 0x013d }
            return;
        L_0x013d:
            r9 = move-exception;
            r2 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x019b }
            r9 = r9.toString();	 Catch:{ Throwable -> 0x019b }
            r2[r0] = r9;	 Catch:{ Throwable -> 0x019b }
            return;
        L_0x0147:
            r9 = r9.getData();	 Catch:{ Throwable -> 0x0191 }
            r2 = "sif";	 Catch:{ Throwable -> 0x0191 }
            r2 = r9.getParcelable(r2);	 Catch:{ Throwable -> 0x0191 }
            r2 = (com.getui.gtc.entity.d) r2;	 Catch:{ Throwable -> 0x0191 }
            r3 = "et";	 Catch:{ Throwable -> 0x0191 }
            r9 = r9.getParcelable(r3);	 Catch:{ Throwable -> 0x0191 }
            r9 = (com.getui.gtc.entity.a) r9;	 Catch:{ Throwable -> 0x0191 }
            r3 = r9.a;	 Catch:{ Throwable -> 0x0191 }
            r4 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0191 }
            r5 = r2.a;	 Catch:{ Throwable -> 0x0191 }
            r4 = r4.b(r5);	 Catch:{ Throwable -> 0x0191 }
            if (r4 != 0) goto L_0x016b;	 Catch:{ Throwable -> 0x0191 }
        L_0x0169:
            r5 = 0;	 Catch:{ Throwable -> 0x0191 }
            goto L_0x016d;	 Catch:{ Throwable -> 0x0191 }
        L_0x016b:
            r5 = r4.a;	 Catch:{ Throwable -> 0x0191 }
        L_0x016d:
            if (r3 == 0) goto L_0x0190;	 Catch:{ Throwable -> 0x0191 }
        L_0x016f:
            r3 = r3.equalsIgnoreCase(r5);	 Catch:{ Throwable -> 0x0191 }
            if (r3 != 0) goto L_0x0190;	 Catch:{ Throwable -> 0x0191 }
        L_0x0175:
            r3 = r8.a;	 Catch:{ Throwable -> 0x0191 }
            r3 = r3.c;	 Catch:{ Throwable -> 0x0191 }
            if (r3 == 0) goto L_0x0190;
        L_0x017d:
            r3 = r8.a;	 Catch:{ Throwable -> 0x0187 }
            r3 = r3.c;	 Catch:{ Throwable -> 0x0187 }
            r3.a(r2, r9, r4);	 Catch:{ Throwable -> 0x0187 }
            return;
        L_0x0187:
            r9 = move-exception;
            r2 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x0191 }
            r9 = r9.toString();	 Catch:{ Throwable -> 0x0191 }
            r2[r0] = r9;	 Catch:{ Throwable -> 0x0191 }
        L_0x0190:
            return;
        L_0x0191:
            r9 = move-exception;
            r2 = new java.lang.String[r1];	 Catch:{ Throwable -> 0x019b }
            r9 = r9.toString();	 Catch:{ Throwable -> 0x019b }
            r2[r0] = r9;	 Catch:{ Throwable -> 0x019b }
            return;
        L_0x019b:
            r9 = move-exception;
            r1 = new java.lang.String[r1];
            r9 = r9.toString();
            r1[r0] = r9;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.e.a.handleMessage(android.os.Message):void");
        }
    }

    private e() {
    }

    private static Method a(String str, Class... clsArr) {
        try {
            return Class.forName("com.igexin.dms.DMSManager").getMethod(str, clsArr);
        } catch (Exception e) {
            new String[1][0] = e.toString();
            return null;
        }
    }

    static /* synthetic */ void a(com.getui.gtc.a.e r9, com.getui.gtc.entity.d r10) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r10.h;	 Catch:{ Throwable -> 0x005d }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Throwable -> 0x005d }
    L_0x0004:
        r0 = 0;	 Catch:{ Throwable -> 0x005d }
        goto L_0x000d;	 Catch:{ Throwable -> 0x005d }
    L_0x0007:
        r0 = r10.h;	 Catch:{ Throwable -> 0x005d }
        r0 = r0.longValue();	 Catch:{ Throwable -> 0x005d }
    L_0x000d:
        r0 = java.lang.Long.valueOf(r0);	 Catch:{ Throwable -> 0x005d }
        r0 = r0.longValue();	 Catch:{ Throwable -> 0x005d }
        r2 = r10.a();	 Catch:{ Throwable -> 0x005d }
        r2 = r2.longValue();	 Catch:{ Throwable -> 0x005d }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x005d }
        r6 = r4 - r0;	 Catch:{ Throwable -> 0x005d }
        r0 = 7200000; // 0x6ddd00 float:1.0089349E-38 double:3.5572727E-317;	 Catch:{ Throwable -> 0x005d }
        r8 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));	 Catch:{ Throwable -> 0x005d }
        if (r8 <= 0) goto L_0x005d;	 Catch:{ Throwable -> 0x005d }
    L_0x002a:
        r0 = r4 - r2;	 Catch:{ Throwable -> 0x005d }
        r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;	 Catch:{ Throwable -> 0x005d }
        r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x005d }
        if (r6 <= 0) goto L_0x005d;	 Catch:{ Throwable -> 0x005d }
    L_0x0032:
        r0 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x005d }
        r1 = r10.a;	 Catch:{ Throwable -> 0x005d }
        r0 = r0.a;	 Catch:{ Throwable -> 0x005d }
        r0 = r0.c;	 Catch:{ Throwable -> 0x005d }
        r2 = r0.b;	 Catch:{ Throwable -> 0x005d }
        if (r2 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x005d }
    L_0x0040:
        r2 = r0.b;	 Catch:{ Throwable -> 0x005d }
        r2 = r2.get(r1);	 Catch:{ Throwable -> 0x005d }
        r2 = (com.getui.gtc.entity.d) r2;	 Catch:{ Throwable -> 0x005d }
        if (r2 == 0) goto L_0x0055;	 Catch:{ Throwable -> 0x005d }
    L_0x004a:
        r3 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x005d }
        r2.h = r3;	 Catch:{ Throwable -> 0x005d }
        r3 = r0.b;	 Catch:{ Throwable -> 0x005d }
        r3.put(r1, r2);	 Catch:{ Throwable -> 0x005d }
    L_0x0055:
        r2 = 13;	 Catch:{ Throwable -> 0x005d }
        r0.a(r1, r2, r4);	 Catch:{ Throwable -> 0x005d }
        r9.b(r10);	 Catch:{ Throwable -> 0x005d }
    L_0x005d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.e.a(com.getui.gtc.a.e, com.getui.gtc.entity.d):void");
    }

    private void a(d dVar) {
        try {
            if (System.currentTimeMillis() - dVar.a().longValue() > 43200000) {
                b(dVar);
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public static void b() {
        try {
            if (d != null) {
                synchronized (e.class) {
                    if (d != null) {
                        e eVar = d;
                        try {
                            if (eVar.c != null) {
                                eVar.c.a();
                            }
                            b.a();
                        } catch (Throwable th) {
                            new String[1][0] = th.toString();
                        }
                        d = null;
                    }
                }
            }
        } catch (Throwable th2) {
            new String[1][0] = th2.toString();
        }
    }

    private void b(d dVar) {
        try {
            if (h.b(this.b)) {
                String jSONObject;
                b bVar;
                com.getui.gtc.c.c a;
                b b = b.b();
                int i = dVar.a;
                long currentTimeMillis = System.currentTimeMillis();
                com.getui.gtc.d.a.d dVar2 = b.a.c;
                if (dVar2.b != null) {
                    d dVar3 = (d) dVar2.b.get(i);
                    if (dVar3 != null) {
                        dVar3.d = Long.valueOf(currentTimeMillis);
                        dVar2.b.put(i, dVar3);
                    }
                }
                dVar2.a(i, 9, currentTimeMillis);
                byte[] bArr = null;
                try {
                    CharSequence charSequence = dVar.e;
                    CharSequence charSequence2 = dVar.f;
                    if (!(TextUtils.isEmpty(charSequence) || TextUtils.isEmpty(charSequence2))) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("action", "sdkconfig");
                        jSONObject2.put("cid", b.b().c());
                        jSONObject2.put("appid", charSequence);
                        jSONObject2.put(com.umeng.message.common.a.h, charSequence2);
                        charSequence = dVar.c;
                        if (!TextUtils.isEmpty(charSequence)) {
                            jSONObject2.put("tag", charSequence);
                        }
                        jSONObject = jSONObject2.toString();
                        if (jSONObject == null) {
                            bVar = new com.getui.gtc.c.a.b(dVar);
                            a = com.getui.gtc.c.c.a();
                            if (jSONObject != null) {
                                try {
                                    bArr = j.a(jSONObject.getBytes());
                                } catch (Exception e) {
                                    new String[1][0] = e.toString();
                                }
                                try {
                                    bVar.e = a.a;
                                    bVar.f = bArr;
                                    com.getui.gtc.c.d.a.a.a(new com.getui.gtc.c.a(bVar));
                                    return;
                                } catch (Throwable th) {
                                    new String[1][0] = th.toString();
                                }
                            }
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    new String[1][0] = th2.toString();
                }
                jSONObject = null;
                if (jSONObject == null) {
                    bVar = new com.getui.gtc.c.a.b(dVar);
                    a = com.getui.gtc.c.c.a();
                    if (jSONObject != null) {
                        bArr = j.a(jSONObject.getBytes());
                        bVar.e = a.a;
                        bVar.f = bArr;
                        com.getui.gtc.c.d.a.a.a(new com.getui.gtc.c.a(bVar));
                        return;
                    }
                    return;
                }
                return;
            }
            new String[1][0] = " net work null,fetchConfig return...";
        } catch (Throwable th3) {
            new String[1][0] = th3.toString();
        }
    }

    public static e c() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new e();
                }
            }
        }
        return d;
    }

    static /* synthetic */ void d() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0132 }
        r2 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.a;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.c;	 Catch:{ Throwable -> 0x0132 }
        r2 = r2.f;	 Catch:{ Throwable -> 0x0132 }
        r4 = r0 - r2;	 Catch:{ Throwable -> 0x0132 }
        r2 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;	 Catch:{ Throwable -> 0x0132 }
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));	 Catch:{ Throwable -> 0x0132 }
        if (r6 <= 0) goto L_0x0132;	 Catch:{ Throwable -> 0x0132 }
    L_0x0017:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0132 }
        r2.<init>();	 Catch:{ Throwable -> 0x0132 }
        r3 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x0132 }
        r4 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Throwable -> 0x0132 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0132 }
        r4 = new java.util.Date;	 Catch:{ Throwable -> 0x0132 }
        r4.<init>();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.format(r4);	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c();	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.k;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.i;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.g;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "GTC-1.1.1";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "android";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.m;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.j;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0132 }
        r4 = "android";	 Catch:{ Throwable -> 0x0132 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x0132 }
        r4 = android.os.Build.VERSION.RELEASE;	 Catch:{ Throwable -> 0x0132 }
        r3.append(r4);	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.h;	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = "|";	 Catch:{ Throwable -> 0x0132 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r4 = r3.d;	 Catch:{ Throwable -> 0x0132 }
        r4 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0132 }
        if (r4 == 0) goto L_0x0101;	 Catch:{ Throwable -> 0x0132 }
    L_0x00fe:
        r3 = "";	 Catch:{ Throwable -> 0x0132 }
        goto L_0x0103;	 Catch:{ Throwable -> 0x0132 }
    L_0x0101:
        r3 = r3.d;	 Catch:{ Throwable -> 0x0132 }
    L_0x0103:
        r2.append(r3);	 Catch:{ Throwable -> 0x0132 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0132 }
        if (r3 != 0) goto L_0x0132;	 Catch:{ Throwable -> 0x0132 }
    L_0x010c:
        r3 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.a;	 Catch:{ Throwable -> 0x0132 }
        r3 = r3.c;	 Catch:{ Throwable -> 0x0132 }
        r4 = 1;	 Catch:{ Throwable -> 0x0132 }
        r5 = 5;	 Catch:{ Throwable -> 0x0132 }
        r3.a(r4, r5, r0);	 Catch:{ Throwable -> 0x0132 }
        r0 = new com.getui.gtc.c.a.a;	 Catch:{ Throwable -> 0x0132 }
        r1 = r2.toString();	 Catch:{ Throwable -> 0x0132 }
        r1 = r1.getBytes();	 Catch:{ Throwable -> 0x0132 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0132 }
        r1 = com.getui.gtc.c.d.a.a;	 Catch:{ Throwable -> 0x0132 }
        r2 = new com.getui.gtc.c.a;	 Catch:{ Throwable -> 0x0132 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0132 }
        r1.b(r2);	 Catch:{ Throwable -> 0x0132 }
    L_0x0132:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.e.d():void");
    }

    private void e() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = r4.c;	 Catch:{ Throwable -> 0x0034 }
        if (r0 != 0) goto L_0x000c;	 Catch:{ Throwable -> 0x0034 }
    L_0x0004:
        r0 = r4.b;	 Catch:{ Throwable -> 0x0034 }
        r0 = com.getui.gtc.b.c.a(r0);	 Catch:{ Throwable -> 0x0034 }
        r4.c = r0;	 Catch:{ Throwable -> 0x0034 }
    L_0x000c:
        r0 = com.getui.gtc.a.b.b();	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.a;	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.c;	 Catch:{ Throwable -> 0x0034 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x0034 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0034 }
    L_0x0018:
        r1 = 0;	 Catch:{ Throwable -> 0x0034 }
    L_0x0019:
        r2 = r0.size();	 Catch:{ Throwable -> 0x0034 }
        if (r1 >= r2) goto L_0x0034;	 Catch:{ Throwable -> 0x0034 }
    L_0x001f:
        r2 = r0.keyAt(r1);	 Catch:{ Throwable -> 0x0034 }
        r2 = r0.get(r2);	 Catch:{ Throwable -> 0x0034 }
        r2 = (com.getui.gtc.entity.d) r2;	 Catch:{ Throwable -> 0x0034 }
        r4.a(r2);	 Catch:{ Throwable -> 0x0034 }
        r3 = r4.c;	 Catch:{ Throwable -> 0x0034 }
        r3.a(r2);	 Catch:{ Throwable -> 0x0034 }
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x0034:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gtc.a.e.e():void");
    }

    public final synchronized void a() {
        try {
            if (!this.f.getAndSet(true)) {
                String[] strArr = new String[1];
                StringBuilder stringBuilder = new StringBuilder("thread id:");
                stringBuilder.append(Thread.currentThread().getId());
                strArr[0] = stringBuilder.toString();
                h.a = this.b;
                h.b = j.a(this.b.getPackageName());
                String path = this.b.getFilesDir().getPath();
                stringBuilder = new StringBuilder();
                stringBuilder.append(path);
                stringBuilder.append(File.separator);
                stringBuilder.append("libs");
                path = stringBuilder.toString();
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdir();
                }
                a.c = path;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(Environment.getExternalStorageDirectory().getPath());
                stringBuilder2.append("/system/tmp/local");
                file = new File(stringBuilder2.toString());
                if (file.exists() || file.mkdirs()) {
                    a.b = file.getAbsolutePath();
                }
                b b = b.b();
                Context context = this.b;
                com.getui.gtc.d.a.c cVar = new com.getui.gtc.d.a.c();
                cVar.a = new com.getui.gtc.d.a.c.a(cVar, context);
                cVar.b = new com.getui.gtc.d.a.b(cVar.a);
                cVar.c = new com.getui.gtc.d.a.d(cVar.a);
                cVar.c.a(context);
                com.getui.gtc.d.a.b bVar = cVar.b;
                bVar.b = new SparseArray();
                bVar.c = new SparseArray();
                bVar.b();
                b.a = cVar;
                b.a(context);
                d.a();
                d.a(this.b);
                try {
                    HandlerThread handlerThread = new HandlerThread("GTC-SDK-SERVICE");
                    handlerThread.start();
                    this.a = new a(this, handlerThread.getLooper());
                } catch (Throwable th) {
                    new String[1][0] = th.toString();
                }
                e();
                this.g.set(true);
                for (Message sendMessage : this.e) {
                    this.a.sendMessage(sendMessage);
                }
                a("com.getui.gtc.GtcManager$SdkInfo");
                Message obtain = Message.obtain();
                obtain.what = 5;
                this.a.sendMessageDelayed(obtain, 5000);
            }
        } catch (Throwable th2) {
            new String[1][0] = th2.toString();
        }
        try {
            Object invoke = a("getInstance", new Class[0]).invoke(null, new Object[0]);
            a("start", Context.class, String.class).invoke(invoke, new Object[]{this.b, b.b().c()});
        } catch (Throwable th22) {
            new String[1][0] = th22.toString();
            return;
        }
        return;
    }

    public final void a(int i) {
        try {
            com.getui.gtc.entity.a b = b.b().b(i);
            if (b != null && b.b.size() > 0) {
                b.a(new g(this, i));
                b.b().a.a(i);
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public final void a(Message message) {
        if (this.g.get()) {
            this.a.sendMessage(message);
        } else {
            this.e.add(message);
        }
    }

    public final void a(String str) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = str;
        a(obtain);
    }
}
