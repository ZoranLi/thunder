package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.media.MediaPlayer.OnCompletionListener;
import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;

public class k extends a {
    private b d;
    private com.alibaba.sdk.android.feedback.util.a e;
    private OnCompletionListener f = new o(this);

    private void a(java.lang.String r4, java.lang.String r5, byte[] r6) {
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
        r0 = new java.io.File;
        r0.<init>(r4);
        r1 = r0.exists();
        if (r1 != 0) goto L_0x000e;
    L_0x000b:
        r0.mkdirs();
    L_0x000e:
        r0 = new java.io.File;
        r0.<init>(r4, r5);
        r4 = r0.exists();
        if (r4 == 0) goto L_0x001c;
    L_0x0019:
        r0.delete();
    L_0x001c:
        r4 = 0;
        r5 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x003c, all -> 0x0032 }
        r5.<init>(r0);	 Catch:{ FileNotFoundException -> 0x0042, IOException -> 0x003c, all -> 0x0032 }
        r5.write(r6);	 Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e, all -> 0x002c }
        r5.flush();	 Catch:{ FileNotFoundException -> 0x0030, IOException -> 0x002e, all -> 0x002c }
        r5.close();	 Catch:{ IOException -> 0x002b }
    L_0x002b:
        return;
    L_0x002c:
        r4 = move-exception;
        goto L_0x0036;
    L_0x002e:
        r4 = r5;
        goto L_0x003c;
    L_0x0030:
        r4 = r5;
        goto L_0x0042;
    L_0x0032:
        r5 = move-exception;
        r2 = r5;
        r5 = r4;
        r4 = r2;
    L_0x0036:
        if (r5 == 0) goto L_0x003b;
    L_0x0038:
        r5.close();	 Catch:{ IOException -> 0x003b }
    L_0x003b:
        throw r4;
    L_0x003c:
        if (r4 == 0) goto L_0x0047;
    L_0x003e:
        r4.close();	 Catch:{ IOException -> 0x0041 }
    L_0x0041:
        return;
    L_0x0042:
        if (r4 == 0) goto L_0x0047;
    L_0x0044:
        r4.close();	 Catch:{ IOException -> 0x0047 }
    L_0x0047:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.k.a(java.lang.String, java.lang.String, byte[]):void");
    }

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r4, java.lang.String r5) {
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
        monitor-enter(r3);
        r3.d = r4;	 Catch:{ all -> 0x0097 }
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0075 }
        r0.<init>(r5);	 Catch:{ JSONException -> 0x0075 }
        r1 = "url";	 Catch:{ JSONException -> 0x0075 }
        r0 = r0.optString(r1);	 Catch:{ JSONException -> 0x0075 }
        r4 = com.alibaba.sdk.android.feedback.xblink.i.b.a(r0);	 Catch:{ all -> 0x0097 }
        r5 = new java.io.File;	 Catch:{ all -> 0x0097 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r1.<init>();	 Catch:{ all -> 0x0097 }
        r2 = com.alibaba.sdk.android.feedback.util.j.b;	 Catch:{ all -> 0x0097 }
        r1.append(r2);	 Catch:{ all -> 0x0097 }
        r2 = java.io.File.separator;	 Catch:{ all -> 0x0097 }
        r1.append(r2);	 Catch:{ all -> 0x0097 }
        r1.append(r4);	 Catch:{ all -> 0x0097 }
        r1 = r1.toString();	 Catch:{ all -> 0x0097 }
        r5.<init>(r1);	 Catch:{ all -> 0x0097 }
        r1 = r5.exists();	 Catch:{ all -> 0x0097 }
        if (r1 == 0) goto L_0x0066;	 Catch:{ all -> 0x0097 }
    L_0x0033:
        r4 = r3.e;	 Catch:{ all -> 0x0097 }
        if (r4 != 0) goto L_0x003e;	 Catch:{ all -> 0x0097 }
    L_0x0037:
        r4 = new com.alibaba.sdk.android.feedback.util.a;	 Catch:{ all -> 0x0097 }
        r4.<init>();	 Catch:{ all -> 0x0097 }
        r3.e = r4;	 Catch:{ all -> 0x0097 }
    L_0x003e:
        r4 = r3.e;	 Catch:{ all -> 0x0097 }
        r4 = r4.b();	 Catch:{ all -> 0x0097 }
        if (r4 == 0) goto L_0x004b;	 Catch:{ all -> 0x0097 }
    L_0x0046:
        r4 = r3.e;	 Catch:{ all -> 0x0097 }
        r4.a();	 Catch:{ all -> 0x0097 }
    L_0x004b:
        r4 = r3.e;	 Catch:{ all -> 0x0097 }
        r5 = r5.getAbsolutePath();	 Catch:{ all -> 0x0097 }
        r0 = r3.f;	 Catch:{ all -> 0x0097 }
        r4.a(r5, r0);	 Catch:{ all -> 0x0097 }
        r4 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0097 }
        r4.<init>();	 Catch:{ all -> 0x0097 }
        r5 = r3.d;	 Catch:{ all -> 0x0097 }
        if (r5 == 0) goto L_0x0064;	 Catch:{ all -> 0x0097 }
    L_0x005f:
        r5 = r3.d;	 Catch:{ all -> 0x0097 }
        r5.a(r4);	 Catch:{ all -> 0x0097 }
    L_0x0064:
        monitor-exit(r3);
        return;
    L_0x0066:
        r5 = new java.lang.Thread;	 Catch:{ all -> 0x0097 }
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.a.l;	 Catch:{ all -> 0x0097 }
        r1.<init>(r3, r0, r4);	 Catch:{ all -> 0x0097 }
        r5.<init>(r1);	 Catch:{ all -> 0x0097 }
        r5.start();	 Catch:{ all -> 0x0097 }
        monitor-exit(r3);
        return;
    L_0x0075:
        r0 = "WXMediaPlayer";	 Catch:{ all -> 0x0097 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0097 }
        r2 = "takePhoto fail, params: ";	 Catch:{ all -> 0x0097 }
        r1.<init>(r2);	 Catch:{ all -> 0x0097 }
        r1.append(r5);	 Catch:{ all -> 0x0097 }
        r5 = r1.toString();	 Catch:{ all -> 0x0097 }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r0, r5);	 Catch:{ all -> 0x0097 }
        r5 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x0097 }
        r5.<init>();	 Catch:{ all -> 0x0097 }
        r0 = "HY_PARAM_ERR";	 Catch:{ all -> 0x0097 }
        r5.a(r0);	 Catch:{ all -> 0x0097 }
        r4.b(r5);	 Catch:{ all -> 0x0097 }
        monitor-exit(r3);
        return;
    L_0x0097:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.k.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public void a(com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView r5, java.lang.String r6) {
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
        r0 = "javascript:window.WindVane.fireEvent('%s', '%s');";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = "WXCommunication.onBroadcast";
        r3 = 0;
        r1[r3] = r2;
        r2 = 1;
        r1[r2] = r6;
        r6 = java.lang.String.format(r0, r1);
        if (r5 == 0) goto L_0x0016;
    L_0x0013:
        r5.loadUrl(r6);	 Catch:{ Exception -> 0x0016 }
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.k.a(com.alibaba.sdk.android.feedback.xblink.webview.XBHybridWebView, java.lang.String):void");
    }

    public boolean a(String str, String str2, b bVar) {
        if ("start".equals(str)) {
            a(bVar, str2);
            return true;
        } else if (!"stop".equals(str)) {
            return false;
        } else {
            b(bVar, str2);
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(com.alibaba.sdk.android.feedback.xblink.f.b r1, java.lang.String r2) {
        /*
        r0 = this;
        monitor-enter(r0);
        r0.d = r1;	 Catch:{ all -> 0x002c }
        r1 = r0.e;	 Catch:{ all -> 0x002c }
        if (r1 == 0) goto L_0x001c;
    L_0x0007:
        r1 = r0.e;	 Catch:{ all -> 0x002c }
        r1.a();	 Catch:{ all -> 0x002c }
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x002c }
        r1.<init>();	 Catch:{ all -> 0x002c }
        r2 = r0.d;	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x001a;
    L_0x0015:
        r2 = r0.d;	 Catch:{ all -> 0x002c }
        r2.a(r1);	 Catch:{ all -> 0x002c }
    L_0x001a:
        monitor-exit(r0);
        return;
    L_0x001c:
        r1 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x002c }
        r1.<init>();	 Catch:{ all -> 0x002c }
        r2 = r0.d;	 Catch:{ all -> 0x002c }
        if (r2 == 0) goto L_0x002a;
    L_0x0025:
        r2 = r0.d;	 Catch:{ all -> 0x002c }
        r2.b(r1);	 Catch:{ all -> 0x002c }
    L_0x002a:
        monitor-exit(r0);
        return;
    L_0x002c:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.k.b(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }
}
