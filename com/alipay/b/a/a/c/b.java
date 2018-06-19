package com.alipay.b.a.a.c;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.vkeydfp.DeviceDataReportService;
import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public final class b implements a {
    private static b d;
    private static DeviceDataReportResult e;
    private w a = null;
    private BugTrackMessageService b = null;
    private DeviceDataReportService c = null;

    private b(Context context, String str) {
        aa aaVar = new aa();
        aaVar.a(str);
        this.a = new h(context);
        this.b = (BugTrackMessageService) this.a.a(BugTrackMessageService.class, aaVar);
        this.c = (DeviceDataReportService) this.a.a(DeviceDataReportService.class, aaVar);
    }

    public static synchronized b a(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            if (d == null) {
                d = new b(context, str);
            }
            bVar = d;
        }
        return bVar;
    }

    public final DeviceDataReportResult a(DeviceDataReportRequest deviceDataReportRequest) {
        if (this.c != null) {
            e = null;
            new Thread(new c(this, deviceDataReportRequest)).start();
            int i = 300000;
            while (e == null && i >= 0) {
                Thread.sleep(50);
                i -= 50;
            }
        }
        return e;
    }

    public final boolean a(java.lang.String r4) {
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
        r0 = com.alipay.b.a.a.a.a.a(r4);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r3.b;
        if (r0 == 0) goto L_0x0030;
    L_0x000c:
        r0 = 0;
        r2 = r3.b;	 Catch:{ Exception -> 0x0018 }
        r4 = com.alipay.b.a.a.a.a.e(r4);	 Catch:{ Exception -> 0x0018 }
        r4 = r2.logCollect(r4);	 Catch:{ Exception -> 0x0018 }
        goto L_0x0019;
    L_0x0018:
        r4 = r0;
    L_0x0019:
        r0 = com.alipay.b.a.a.a.a.a(r4);
        if (r0 != 0) goto L_0x0030;
    L_0x001f:
        r0 = new org.json.JSONObject;
        r0.<init>(r4);
        r4 = "success";
        r4 = r0.get(r4);
        r4 = (java.lang.Boolean) r4;
        r1 = r4.booleanValue();
    L_0x0030:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.c.b.a(java.lang.String):boolean");
    }
}
