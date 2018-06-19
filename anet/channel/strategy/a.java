package anet.channel.strategy;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
class a {
    final ConcurrentHashMap<String, List<IPConnStrategy>> a = new ConcurrentHashMap();
    final HashMap<String, Object> b = new HashMap();

    a() {
    }

    java.util.List a(java.lang.String r8) {
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
        r7 = this;
        r0 = android.text.TextUtils.isEmpty(r8);
        if (r0 != 0) goto L_0x007e;
    L_0x0006:
        r0 = anet.channel.strategy.utils.d.b(r8);
        if (r0 == 0) goto L_0x007e;
    L_0x000c:
        r0 = anet.channel.strategy.dispatch.DispatchConstants.getAmdcServerDomain();
        r0 = r0.equalsIgnoreCase(r8);
        if (r0 == 0) goto L_0x0017;
    L_0x0016:
        goto L_0x007e;
    L_0x0017:
        r0 = 1;
        r1 = anet.channel.util.ALog.isPrintLog(r0);
        if (r1 == 0) goto L_0x0030;
    L_0x001e:
        r1 = "awcn.LocalDnsStrategyTable";
        r2 = "try resolve ip with local dns";
        r3 = 0;
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = "host";
        r4[r5] = r6;
        r4[r0] = r8;
        anet.channel.util.ALog.d(r1, r2, r3, r4);
    L_0x0030:
        r0 = java.util.Collections.EMPTY_LIST;
        r1 = r7.a;
        r1 = r1.containsKey(r8);
        if (r1 != 0) goto L_0x006a;
    L_0x003a:
        r1 = r7.b;
        monitor-enter(r1);
        r2 = r7.b;	 Catch:{ all -> 0x0067 }
        r2 = r2.containsKey(r8);	 Catch:{ all -> 0x0067 }
        if (r2 != 0) goto L_0x0053;	 Catch:{ all -> 0x0067 }
    L_0x0045:
        r2 = new java.lang.Object;	 Catch:{ all -> 0x0067 }
        r2.<init>();	 Catch:{ all -> 0x0067 }
        r3 = r7.b;	 Catch:{ all -> 0x0067 }
        r3.put(r8, r2);	 Catch:{ all -> 0x0067 }
        r7.a(r8, r2);	 Catch:{ all -> 0x0067 }
        goto L_0x0059;	 Catch:{ all -> 0x0067 }
    L_0x0053:
        r2 = r7.b;	 Catch:{ all -> 0x0067 }
        r2 = r2.get(r8);	 Catch:{ all -> 0x0067 }
    L_0x0059:
        monitor-exit(r1);	 Catch:{ all -> 0x0067 }
        if (r2 == 0) goto L_0x006a;
    L_0x005c:
        monitor-enter(r2);	 Catch:{ InterruptedException -> 0x006a }
        r3 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        r2.wait(r3);	 Catch:{ all -> 0x0064 }
        monitor-exit(r2);	 Catch:{ all -> 0x0064 }
        goto L_0x006a;
    L_0x0064:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ InterruptedException -> 0x006a }
        throw r1;	 Catch:{ InterruptedException -> 0x006a }
    L_0x0067:
        r8 = move-exception;
        monitor-exit(r1);
        throw r8;
    L_0x006a:
        r1 = r7.a;
        r8 = r1.get(r8);
        r8 = (java.util.List) r8;
        if (r8 == 0) goto L_0x007d;
    L_0x0074:
        r1 = java.util.Collections.EMPTY_LIST;
        if (r8 == r1) goto L_0x007d;
    L_0x0078:
        r0 = new java.util.ArrayList;
        r0.<init>(r8);
    L_0x007d:
        return r0;
    L_0x007e:
        r8 = java.util.Collections.EMPTY_LIST;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.a.a(java.lang.String):java.util.List");
    }

    void a(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (connEvent.isSuccess == null) {
            if (TextUtils.isEmpty(str) == null) {
                List list = (List) this.a.get(str);
                if (!(list == null || list == Collections.EMPTY_LIST)) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == iConnStrategy) {
                            it.remove();
                        }
                    }
                    if (list.isEmpty() != null) {
                        this.a.put(str, Collections.EMPTY_LIST);
                    }
                }
            }
        }
    }

    private void a(String str, Object obj) {
        anet.channel.strategy.utils.a.a(new b(this, str, obj));
    }
}
