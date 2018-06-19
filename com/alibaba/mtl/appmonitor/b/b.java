package com.alibaba.mtl.appmonitor.b;

import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.a.i;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.d;
import com.alibaba.mtl.appmonitor.t;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ExceptionEventBuilder */
public final class b {
    private static org.json.JSONObject b(java.lang.Throwable r6) throws java.io.IOException {
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
        r0 = com.alibaba.mtl.appmonitor.c.a.a();
        r1 = com.alibaba.mtl.appmonitor.c.e.class;
        r2 = 0;
        r3 = new java.lang.Object[r2];
        r0 = r0.a(r1, r3);
        r0 = (org.json.JSONObject) r0;
        r1 = "page";	 Catch:{ Exception -> 0x0060 }
        r3 = "APPMONITOR";	 Catch:{ Exception -> 0x0060 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0060 }
        r1 = "monitorPoint";	 Catch:{ Exception -> 0x0060 }
        r3 = "sdk-exception";	 Catch:{ Exception -> 0x0060 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0060 }
        r1 = "arg";	 Catch:{ Exception -> 0x0060 }
        r3 = r6.getClass();	 Catch:{ Exception -> 0x0060 }
        r3 = r3.getSimpleName();	 Catch:{ Exception -> 0x0060 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0060 }
        r1 = "successCount";	 Catch:{ Exception -> 0x0060 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0060 }
        r1 = "failCount";	 Catch:{ Exception -> 0x0060 }
        r3 = 1;	 Catch:{ Exception -> 0x0060 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0060 }
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0060 }
        r1.<init>();	 Catch:{ Exception -> 0x0060 }
        r6 = c(r6);	 Catch:{ Exception -> 0x0060 }
        if (r6 == 0) goto L_0x005b;	 Catch:{ Exception -> 0x0060 }
    L_0x0040:
        r4 = com.alibaba.mtl.appmonitor.c.a.a();	 Catch:{ Exception -> 0x0060 }
        r5 = com.alibaba.mtl.appmonitor.c.e.class;	 Catch:{ Exception -> 0x0060 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0060 }
        r2 = r4.a(r5, r2);	 Catch:{ Exception -> 0x0060 }
        r2 = (org.json.JSONObject) r2;	 Catch:{ Exception -> 0x0060 }
        r4 = "errorCode";	 Catch:{ Exception -> 0x0060 }
        r2.put(r4, r6);	 Catch:{ Exception -> 0x0060 }
        r6 = "errorCount";	 Catch:{ Exception -> 0x0060 }
        r2.put(r6, r3);	 Catch:{ Exception -> 0x0060 }
        r1.add(r2);	 Catch:{ Exception -> 0x0060 }
    L_0x005b:
        r6 = "errors";	 Catch:{ Exception -> 0x0060 }
        r0.put(r6, r1);	 Catch:{ Exception -> 0x0060 }
    L_0x0060:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.b.b.b(java.lang.Throwable):org.json.JSONObject");
    }

    private static String c(Throwable th) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(th.getClass().getName());
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuilder.append(stackTraceElement.toString());
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        return com.alibaba.mtl.appmonitor.f.b.b(stringBuilder2) ? th.toString() : stringBuilder2;
    }

    public static void a(Throwable th) {
        try {
            com.alibaba.mtl.appmonitor.c.b bVar = (i) a.a().a(i.class, new Object[0]);
            bVar.b = f.ALARM.a();
            Map hashMap = new HashMap();
            hashMap.put("meta", t.a());
            com.alibaba.mtl.appmonitor.c.b bVar2 = (d) a.a().a(d.class, new Object[0]);
            bVar2.put(b(th));
            hashMap.put("data", bVar2);
            bVar.f.put(f.ALARM.a(), new JSONObject(hashMap).toString());
            bVar.c = "APPMONITOR";
            bVar.d = "sdk-exception";
            if (bVar != null) {
                com.alibaba.mtl.log.a.a(bVar.a, String.valueOf(bVar.b), bVar.c, bVar.d, bVar.e, bVar.f);
                a.a().a(bVar);
            }
            a.a().a(bVar2);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
