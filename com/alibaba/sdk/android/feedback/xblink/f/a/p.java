package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.c;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;
import com.alibaba.sdk.android.feedback.xblink.f.m;

public class p extends a {
    IWxCallback d = new q(this);
    private long e = 0;
    private c f;
    private b g;
    private Handler h = new Handler(Looper.getMainLooper());
    private boolean i = false;

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r9, java.lang.String r10) {
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
        r8 = this;
        monitor-enter(r8);
        r0 = r8.c;	 Catch:{ all -> 0x0090 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r8);
        return;
    L_0x0007:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0090 }
        r2 = r8.e;	 Catch:{ all -> 0x0090 }
        r4 = r0 - r2;	 Catch:{ all -> 0x0090 }
        r8.e = r0;	 Catch:{ all -> 0x0090 }
        r0 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ all -> 0x0090 }
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ all -> 0x0090 }
        if (r2 >= 0) goto L_0x0026;	 Catch:{ all -> 0x0090 }
    L_0x0017:
        r10 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0090 }
        r10.<init>();	 Catch:{ all -> 0x0090 }
        r0 = "HY_FAILED";	 Catch:{ all -> 0x0090 }
        r10.a(r0);	 Catch:{ all -> 0x0090 }
        r9.b(r10);	 Catch:{ all -> 0x0090 }
        monitor-exit(r8);
        return;
    L_0x0026:
        r0 = r8.i;	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x0039;	 Catch:{ all -> 0x0090 }
    L_0x002a:
        r10 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0090 }
        r10.<init>();	 Catch:{ all -> 0x0090 }
        r0 = "HY_FAILED";	 Catch:{ all -> 0x0090 }
        r10.a(r0);	 Catch:{ all -> 0x0090 }
        r9.b(r10);	 Catch:{ all -> 0x0090 }
        monitor-exit(r8);
        return;
    L_0x0039:
        r8.g = r9;	 Catch:{ all -> 0x0090 }
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x006e }
        r0.<init>(r10);	 Catch:{ JSONException -> 0x006e }
        r1 = "maxTime";	 Catch:{ JSONException -> 0x006e }
        r4 = r0.optLong(r1);	 Catch:{ JSONException -> 0x006e }
        r1 = "miniTime";	 Catch:{ JSONException -> 0x006e }
        r6 = r0.optLong(r1);	 Catch:{ JSONException -> 0x006e }
        r9 = new com.alibaba.sdk.android.feedback.util.c;	 Catch:{ all -> 0x0090 }
        r3 = r8.d;	 Catch:{ all -> 0x0090 }
        r2 = r9;	 Catch:{ all -> 0x0090 }
        r2.<init>(r3, r4, r6);	 Catch:{ all -> 0x0090 }
        r8.f = r9;	 Catch:{ all -> 0x0090 }
        r9 = r8.f;	 Catch:{ all -> 0x0090 }
        r9.a();	 Catch:{ all -> 0x0090 }
        r9 = 1;	 Catch:{ all -> 0x0090 }
        r8.i = r9;	 Catch:{ all -> 0x0090 }
        r9 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0090 }
        r9.<init>();	 Catch:{ all -> 0x0090 }
        r10 = r8.g;	 Catch:{ all -> 0x0090 }
        if (r10 == 0) goto L_0x006c;	 Catch:{ all -> 0x0090 }
    L_0x0067:
        r10 = r8.g;	 Catch:{ all -> 0x0090 }
        r10.a(r9);	 Catch:{ all -> 0x0090 }
    L_0x006c:
        monitor-exit(r8);
        return;
    L_0x006e:
        r0 = "WXMediaRecorder";	 Catch:{ all -> 0x0090 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0090 }
        r2 = "takePhoto fail, params: ";	 Catch:{ all -> 0x0090 }
        r1.<init>(r2);	 Catch:{ all -> 0x0090 }
        r1.append(r10);	 Catch:{ all -> 0x0090 }
        r10 = r1.toString();	 Catch:{ all -> 0x0090 }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r10);	 Catch:{ all -> 0x0090 }
        r10 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0090 }
        r10.<init>();	 Catch:{ all -> 0x0090 }
        r0 = "HY_PARAM_ERR";	 Catch:{ all -> 0x0090 }
        r10.a(r0);	 Catch:{ all -> 0x0090 }
        r9.b(r10);	 Catch:{ all -> 0x0090 }
        monitor-exit(r8);
        return;
    L_0x0090:
        r9 = move-exception;
        monitor-exit(r8);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.p.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public boolean a(String str, String str2, b bVar) {
        if ("start".equals(str)) {
            a(bVar, str2);
            return true;
        } else if ("stop".equals(str)) {
            b(bVar, str2);
            return true;
        } else if (!"cancel".equals(str)) {
            return false;
        } else {
            c(bVar, str2);
            return true;
        }
    }

    public byte[] a(java.io.File r4) {
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
        r3 = this;
        r0 = r4.length();
        r0 = (int) r0;
        r0 = new byte[r0];
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x0022 }
        r2.<init>(r4);	 Catch:{ all -> 0x0022 }
        r4 = r2.read(r0);	 Catch:{ all -> 0x0020 }
        r1 = -1;	 Catch:{ all -> 0x0020 }
        if (r4 != r1) goto L_0x001c;	 Catch:{ all -> 0x0020 }
    L_0x0014:
        r4 = new java.io.IOException;	 Catch:{ all -> 0x0020 }
        r0 = "EOF reached while trying to read the whole file";	 Catch:{ all -> 0x0020 }
        r4.<init>(r0);	 Catch:{ all -> 0x0020 }
        throw r4;	 Catch:{ all -> 0x0020 }
    L_0x001c:
        r2.close();	 Catch:{ IOException -> 0x001f }
    L_0x001f:
        return r0;
    L_0x0020:
        r4 = move-exception;
        goto L_0x0024;
    L_0x0022:
        r4 = move-exception;
        r2 = r1;
    L_0x0024:
        if (r2 == 0) goto L_0x0029;
    L_0x0026:
        r2.close();	 Catch:{ IOException -> 0x0029 }
    L_0x0029:
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.p.a(java.io.File):byte[]");
    }

    public synchronized void b(b bVar, String str) {
        this.g = bVar;
        this.i = false;
        if (this.f != null) {
            this.f.b();
        }
    }

    public synchronized void c(b bVar, String str) {
        this.g = bVar;
        this.i = false;
        if (this.f != null) {
            this.f.c();
            m mVar = new m();
            if (this.g != null) {
                this.g.a(mVar);
            }
        }
    }
}
