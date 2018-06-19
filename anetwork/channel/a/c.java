package anetwork.channel.a;

import anet.channel.util.ALog;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
final class c implements a {
    private static boolean a = false;

    c() {
    }

    static {
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
        r0 = "com.taobao.orange.OrangeConfig";	 Catch:{ Exception -> 0x0009 }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0009 }
        r0 = 1;	 Catch:{ Exception -> 0x0009 }
        a = r0;	 Catch:{ Exception -> 0x0009 }
        return;
    L_0x0009:
        r0 = 0;
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.a.c.<clinit>():void");
    }

    public final void a() {
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
        r7 = this;
        r0 = a;
        r1 = 0;
        r2 = 0;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "awcn.OrangeConfigImpl";
        r3 = "no orange sdk";
        r2 = new java.lang.Object[r2];
        anet.channel.util.ALog.w(r0, r3, r1, r2);
        return;
    L_0x0010:
        r0 = com.taobao.orange.OrangeConfig.getInstance();	 Catch:{ Exception -> 0x00a2 }
        r3 = 1;	 Catch:{ Exception -> 0x00a2 }
        r4 = new java.lang.String[r3];	 Catch:{ Exception -> 0x00a2 }
        r5 = "networkSdk";	 Catch:{ Exception -> 0x00a2 }
        r4[r2] = r5;	 Catch:{ Exception -> 0x00a2 }
        r5 = new anetwork.channel.a.d;	 Catch:{ Exception -> 0x00a2 }
        r5.<init>(r7);	 Catch:{ Exception -> 0x00a2 }
        r0.registerListener(r4, r5);	 Catch:{ Exception -> 0x00a2 }
        r0 = 3;	 Catch:{ Exception -> 0x00a2 }
        r4 = new java.lang.String[r0];	 Catch:{ Exception -> 0x00a2 }
        r5 = "networkSdk";	 Catch:{ Exception -> 0x00a2 }
        r4[r2] = r5;	 Catch:{ Exception -> 0x00a2 }
        r5 = "network_empty_scheme_https_switch";	 Catch:{ Exception -> 0x00a2 }
        r4[r3] = r5;	 Catch:{ Exception -> 0x00a2 }
        r5 = "true";	 Catch:{ Exception -> 0x00a2 }
        r6 = 2;	 Catch:{ Exception -> 0x00a2 }
        r4[r6] = r5;	 Catch:{ Exception -> 0x00a2 }
        a(r4);	 Catch:{ Exception -> 0x00a2 }
        r4 = anetwork.channel.statist.a.a();	 Catch:{ Exception -> 0x00a2 }
        r0 = new java.lang.String[r0];	 Catch:{ Exception -> 0x00a2 }
        r5 = "networkSdk";	 Catch:{ Exception -> 0x00a2 }
        r0[r2] = r5;	 Catch:{ Exception -> 0x00a2 }
        r5 = "network_monitor_whitelist_url";	 Catch:{ Exception -> 0x00a2 }
        r0[r3] = r5;	 Catch:{ Exception -> 0x00a2 }
        r0[r6] = r1;	 Catch:{ Exception -> 0x00a2 }
        r0 = a(r0);	 Catch:{ Exception -> 0x00a2 }
        r3 = r4.d;	 Catch:{ Exception -> 0x00a2 }
        if (r3 != 0) goto L_0x0056;	 Catch:{ Exception -> 0x00a2 }
    L_0x004e:
        r3 = new java.util.HashSet;	 Catch:{ Exception -> 0x00a2 }
        r3.<init>();	 Catch:{ Exception -> 0x00a2 }
        r4.d = r3;	 Catch:{ Exception -> 0x00a2 }
        goto L_0x005b;	 Catch:{ Exception -> 0x00a2 }
    L_0x0056:
        r3 = r4.d;	 Catch:{ Exception -> 0x00a2 }
        r3.clear();	 Catch:{ Exception -> 0x00a2 }
    L_0x005b:
        r3 = anet.channel.util.ALog.isPrintLog(r6);	 Catch:{ Exception -> 0x00a2 }
        if (r3 == 0) goto L_0x0076;	 Catch:{ Exception -> 0x00a2 }
    L_0x0061:
        r3 = "awcn.StatisticReqTimes";	 Catch:{ Exception -> 0x00a2 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a2 }
        r6 = "urlsFromOrange: ";	 Catch:{ Exception -> 0x00a2 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00a2 }
        r5.append(r0);	 Catch:{ Exception -> 0x00a2 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00a2 }
        r6 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00a2 }
        anet.channel.util.ALog.i(r3, r5, r1, r6);	 Catch:{ Exception -> 0x00a2 }
    L_0x0076:
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x00a2 }
        if (r3 != 0) goto L_0x00a1;
    L_0x007c:
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0098 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0098 }
        r0 = r3.keys();	 Catch:{ Exception -> 0x0098 }
    L_0x0085:
        r3 = r0.hasNext();	 Catch:{ Exception -> 0x0098 }
        if (r3 == 0) goto L_0x0097;	 Catch:{ Exception -> 0x0098 }
    L_0x008b:
        r3 = r4.d;	 Catch:{ Exception -> 0x0098 }
        r5 = r0.next();	 Catch:{ Exception -> 0x0098 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0098 }
        r3.add(r5);	 Catch:{ Exception -> 0x0098 }
        goto L_0x0085;
    L_0x0097:
        return;
    L_0x0098:
        r0 = "awcn.StatisticReqTimes";	 Catch:{ Exception -> 0x00a2 }
        r3 = "whiteReqUrls from orange isnot json format";	 Catch:{ Exception -> 0x00a2 }
        r4 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x00a2 }
        anet.channel.util.ALog.e(r0, r3, r1, r4);	 Catch:{ Exception -> 0x00a2 }
    L_0x00a1:
        return;
    L_0x00a2:
        r0 = move-exception;
        r3 = "awcn.OrangeConfigImpl";
        r4 = "register fail";
        r2 = new java.lang.Object[r2];
        anet.channel.util.ALog.e(r3, r4, r1, r0, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.a.c.a():void");
    }

    private static String a(String... strArr) {
        if (a) {
            try {
                return OrangeConfig.getInstance().getConfig(strArr[0], strArr[1], strArr[2]);
            } catch (String[] strArr2) {
                ALog.e("awcn.OrangeConfigImpl", "get config failed!", null, strArr2, new Object[0]);
                return null;
            }
        }
        ALog.w("awcn.OrangeConfigImpl", "no orange sdk", null, new Object[0]);
        return null;
    }
}
