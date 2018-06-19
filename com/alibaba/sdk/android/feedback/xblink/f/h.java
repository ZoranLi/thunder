package com.alibaba.sdk.android.feedback.xblink.f;

import java.util.HashMap;
import java.util.Map;

public class h {
    private static h a;
    private Map b = new HashMap();
    private boolean c = false;

    private h() {
    }

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                a = new h();
            }
            hVar = a;
        }
        return hVar;
    }

    public synchronized void a(android.webkit.WebView r7, java.lang.String r8) {
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
        r6 = this;
        monitor-enter(r6);
        r0 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ all -> 0x00eb }
        if (r0 == 0) goto L_0x001a;	 Catch:{ all -> 0x00eb }
    L_0x0007:
        r0 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r2 = "start execute jspatch, url: ";	 Catch:{ all -> 0x00eb }
        r1.<init>(r2);	 Catch:{ all -> 0x00eb }
        r1.append(r8);	 Catch:{ all -> 0x00eb }
        r1 = r1.toString();	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r0, r1);	 Catch:{ all -> 0x00eb }
    L_0x001a:
        r0 = r6.c;	 Catch:{ all -> 0x00eb }
        if (r0 == 0) goto L_0x00e2;	 Catch:{ all -> 0x00eb }
    L_0x001e:
        if (r7 == 0) goto L_0x00e2;	 Catch:{ all -> 0x00eb }
    L_0x0020:
        r0 = android.text.TextUtils.isEmpty(r8);	 Catch:{ all -> 0x00eb }
        if (r0 == 0) goto L_0x0028;	 Catch:{ all -> 0x00eb }
    L_0x0026:
        goto L_0x00e2;	 Catch:{ all -> 0x00eb }
    L_0x0028:
        r0 = r6.b;	 Catch:{ all -> 0x00eb }
        r0 = r0.entrySet();	 Catch:{ all -> 0x00eb }
        r0 = r0.iterator();	 Catch:{ all -> 0x00eb }
    L_0x0032:
        r1 = r0.hasNext();	 Catch:{ all -> 0x00eb }
        if (r1 == 0) goto L_0x00e0;	 Catch:{ all -> 0x00eb }
    L_0x0038:
        r1 = r0.next();	 Catch:{ all -> 0x00eb }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x00eb }
        r2 = r1.getKey();	 Catch:{ all -> 0x00eb }
        r2 = (java.lang.String) r2;	 Catch:{ all -> 0x00eb }
        r1 = r1.getValue();	 Catch:{ all -> 0x00eb }
        r1 = (com.alibaba.sdk.android.feedback.xblink.f.i) r1;	 Catch:{ all -> 0x00eb }
        if (r1 != 0) goto L_0x0054;	 Catch:{ all -> 0x00eb }
    L_0x004c:
        r1 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r2 = "config is null";	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r1, r2);	 Catch:{ all -> 0x00eb }
        goto L_0x0032;	 Catch:{ all -> 0x00eb }
    L_0x0054:
        r3 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ all -> 0x00eb }
        if (r3 == 0) goto L_0x006d;	 Catch:{ all -> 0x00eb }
    L_0x005a:
        r3 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r5 = "start match rules, rule: ";	 Catch:{ all -> 0x00eb }
        r4.<init>(r5);	 Catch:{ all -> 0x00eb }
        r4.append(r2);	 Catch:{ all -> 0x00eb }
        r4 = r4.toString();	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r3, r4);	 Catch:{ all -> 0x00eb }
    L_0x006d:
        r3 = com.alibaba.sdk.android.feedback.xblink.f.i.a(r1);	 Catch:{ all -> 0x00eb }
        if (r3 != 0) goto L_0x008e;
    L_0x0073:
        r3 = java.util.regex.Pattern.compile(r2);	 Catch:{ PatternSyntaxException -> 0x007b }
        com.alibaba.sdk.android.feedback.xblink.f.i.a(r1, r3);	 Catch:{ PatternSyntaxException -> 0x007b }
        goto L_0x008e;
    L_0x007b:
        r3 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r5 = "compile rule error, pattern: ";	 Catch:{ all -> 0x00eb }
        r4.<init>(r5);	 Catch:{ all -> 0x00eb }
        r4.append(r2);	 Catch:{ all -> 0x00eb }
        r2 = r4.toString();	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r3, r2);	 Catch:{ all -> 0x00eb }
    L_0x008e:
        r2 = com.alibaba.sdk.android.feedback.xblink.f.i.a(r1);	 Catch:{ all -> 0x00eb }
        if (r2 == 0) goto L_0x0032;	 Catch:{ all -> 0x00eb }
    L_0x0094:
        r2 = com.alibaba.sdk.android.feedback.xblink.f.i.a(r1);	 Catch:{ all -> 0x00eb }
        r2 = r2.matcher(r8);	 Catch:{ all -> 0x00eb }
        r2 = r2.matches();	 Catch:{ all -> 0x00eb }
        if (r2 == 0) goto L_0x0032;	 Catch:{ all -> 0x00eb }
    L_0x00a2:
        r2 = r1.a;	 Catch:{ all -> 0x00eb }
        r3 = "javascript:";	 Catch:{ all -> 0x00eb }
        r2 = r2.startsWith(r3);	 Catch:{ all -> 0x00eb }
        if (r2 != 0) goto L_0x00be;	 Catch:{ all -> 0x00eb }
    L_0x00ac:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r3 = "javascript:";	 Catch:{ all -> 0x00eb }
        r2.<init>(r3);	 Catch:{ all -> 0x00eb }
        r3 = r1.a;	 Catch:{ all -> 0x00eb }
        r2.append(r3);	 Catch:{ all -> 0x00eb }
        r2 = r2.toString();	 Catch:{ all -> 0x00eb }
        r1.a = r2;	 Catch:{ all -> 0x00eb }
    L_0x00be:
        r2 = r1.a;	 Catch:{ all -> 0x00eb }
        r7.loadUrl(r2);	 Catch:{ all -> 0x00eb }
        r2 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ all -> 0x00eb }
        if (r2 == 0) goto L_0x0032;	 Catch:{ all -> 0x00eb }
    L_0x00c9:
        r2 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00eb }
        r4 = "url matched, start execute jspatch, jsString: ";	 Catch:{ all -> 0x00eb }
        r3.<init>(r4);	 Catch:{ all -> 0x00eb }
        r1 = r1.a;	 Catch:{ all -> 0x00eb }
        r3.append(r1);	 Catch:{ all -> 0x00eb }
        r1 = r3.toString();	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r2, r1);	 Catch:{ all -> 0x00eb }
        goto L_0x0032;
    L_0x00e0:
        monitor-exit(r6);
        return;
    L_0x00e2:
        r7 = "WVJsPatch";	 Catch:{ all -> 0x00eb }
        r8 = "jspatch is not init, or parameter is empty.";	 Catch:{ all -> 0x00eb }
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r7, r8);	 Catch:{ all -> 0x00eb }
        monitor-exit(r6);
        return;
    L_0x00eb:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.h.a(android.webkit.WebView, java.lang.String):void");
    }
}
