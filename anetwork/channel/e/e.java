package anetwork.channel.e;

import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.request.Request;
import anet.channel.util.ALog;
import anet.channel.util.a;
import anet.channel.util.c;
import anetwork.channel.cache.d;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
final class e implements RequestCb {
    final /* synthetic */ Request a;
    final /* synthetic */ d b;

    e(d dVar, Request request) {
        this.b = dVar;
        this.a = request;
    }

    public final void onResponseCode(int i, Map<String, List<String>> map) {
        if (!this.b.h.get()) {
            if (ALog.isPrintLog(2)) {
                StringBuilder stringBuilder = new StringBuilder("[onResponseCode]");
                stringBuilder.append("responseCode:");
                stringBuilder.append(i);
                if (map != null) {
                    stringBuilder.append(", header:");
                    stringBuilder.append(map.toString());
                }
                ALog.i("anet.NetworkTask", stringBuilder.toString(), this.b.a.c, new Object[0]);
            }
            if (a.a(this.a, i)) {
                String b = a.b(map, "Location");
                if (b != null) {
                    c a = c.a(b);
                    if (a != null) {
                        if (this.b.h.compareAndSet(false, true) != 0) {
                            a.i();
                            this.b.a.a.a(a);
                            this.b.a.d.host = this.b.a.a.b.getHttpUrl().b();
                            this.b.a.e = new AtomicBoolean();
                            this.b.a.f = new d(this.b.a, null, null);
                            anet.channel.a.c.a(this.b.a.f, 0);
                        }
                        return;
                    }
                    ALog.e("anet.NetworkTask", "redirect url is invalid!", this.a.getSeq(), "redirect url", b);
                }
            }
            try {
                this.b.a.a();
                this.b.i = i;
                anetwork.channel.b.a.a(this.b.a.a.b.getUrlString(), (Map) map);
                this.b.j = a.c(map);
                if (i != 304 || this.b.c == null) {
                    if (this.b.b != null && "GET".equals(this.a.getMethod())) {
                        this.b.c = d.a((Map) map);
                        if (this.b.c != null) {
                            a.c(map, "Cache-Control");
                            map.put("Cache-Control", Arrays.asList(new String[]{"no-store"}));
                            this.b.d = new ByteArrayOutputStream(this.b.j != 0 ? this.b.j : 5120);
                        }
                    }
                    this.b.a.b.a(i, map);
                    return;
                }
                this.b.c.responseHeaders.putAll(map);
                this.b.a.b.a(200, this.b.c.responseHeaders);
                this.b.a.b.a(1, this.b.c.data.length, ByteArray.wrap(this.b.c.data));
            } catch (int i2) {
                ALog.w("anet.NetworkTask", "[onResponseCode] error.", this.b.a.c, i2, new Object[0]);
            }
        }
    }

    public final void onDataReceive(ByteArray byteArray, boolean z) {
        if (!this.b.h.get()) {
            if (this.b.k == 0) {
                ALog.i("anet.NetworkTask", "[onDataReceive] receive first data chunk!", this.b.a.c, new Object[0]);
            }
            if (z) {
                ALog.i("anet.NetworkTask", "[onDataReceive] receive last data chunk!", this.b.a.c, new Object[0]);
            }
            try {
                d dVar = this.b;
                dVar.k++;
                this.b.a.b.a(this.b.k, this.b.j, byteArray);
                if (this.b.d != null) {
                    this.b.d.write(byteArray.getBuffer(), 0, byteArray.getDataLength());
                    if (z) {
                        byteArray = this.b.a.a.b.getUrlString();
                        this.b.c.data = this.b.d.toByteArray();
                        long currentTimeMillis = System.currentTimeMillis();
                        this.b.b.a(byteArray, this.b.c);
                        ALog.i("anet.NetworkTask", "write cache", this.b.a.c, "cost", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), "size", Integer.valueOf(this.b.c.data.length), "key", byteArray);
                    }
                }
            } catch (ByteArray byteArray2) {
                ALog.w("anet.NetworkTask", "[onDataReceive] error.", this.b.a.c, byteArray2, new Object[0]);
            }
        }
    }

    public final void onFinish(int r12, java.lang.String r13, anet.channel.statist.RequestStatistic r14) {
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
        r11 = this;
        r0 = r11.b;
        r0 = r0.h;
        r1 = 1;
        r0 = r0.getAndSet(r1);
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r0 = r11.b;
        r0 = r0.a;
        r0.a();
        r0 = 2;
        r2 = anet.channel.util.ALog.isPrintLog(r0);
        r3 = 0;
        if (r2 == 0) goto L_0x003c;
    L_0x001b:
        r2 = "anet.NetworkTask";
        r4 = "[onFinish]";
        r5 = r11.b;
        r5 = r5.a;
        r5 = r5.c;
        r6 = 4;
        r6 = new java.lang.Object[r6];
        r7 = "code";
        r6[r3] = r7;
        r7 = java.lang.Integer.valueOf(r12);
        r6[r1] = r7;
        r7 = "msg";
        r6[r0] = r7;
        r7 = 3;
        r6[r7] = r13;
        anet.channel.util.ALog.i(r2, r4, r5, r6);
    L_0x003c:
        if (r12 >= 0) goto L_0x0098;
    L_0x003e:
        r2 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r2 = r2.a;	 Catch:{ Exception -> 0x01a0 }
        r2 = r2.a;	 Catch:{ Exception -> 0x01a0 }
        r4 = r2.c;	 Catch:{ Exception -> 0x01a0 }
        r2 = r2.d;	 Catch:{ Exception -> 0x01a0 }
        if (r4 >= r2) goto L_0x004c;	 Catch:{ Exception -> 0x01a0 }
    L_0x004a:
        r2 = r1;	 Catch:{ Exception -> 0x01a0 }
        goto L_0x004d;	 Catch:{ Exception -> 0x01a0 }
    L_0x004c:
        r2 = r3;	 Catch:{ Exception -> 0x01a0 }
    L_0x004d:
        if (r2 == 0) goto L_0x0098;	 Catch:{ Exception -> 0x01a0 }
    L_0x004f:
        r12 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.a;	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r12.c;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13 + r1;	 Catch:{ Exception -> 0x01a0 }
        r12.c = r13;	 Catch:{ Exception -> 0x01a0 }
        r13 = r12.f;	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.c;	 Catch:{ Exception -> 0x01a0 }
        r13.retryTimes = r12;	 Catch:{ Exception -> 0x01a0 }
        r12 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = new java.util.concurrent.atomic.AtomicBoolean;	 Catch:{ Exception -> 0x01a0 }
        r13.<init>();	 Catch:{ Exception -> 0x01a0 }
        r12.e = r13;	 Catch:{ Exception -> 0x01a0 }
        r12 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r12 = r12.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = new anetwork.channel.e.d;	 Catch:{ Exception -> 0x01a0 }
        r14 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r14 = r14.a;	 Catch:{ Exception -> 0x01a0 }
        r0 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r0 = r0.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.c;	 Catch:{ Exception -> 0x01a0 }
        r13.<init>(r14, r0, r1);	 Catch:{ Exception -> 0x01a0 }
        r12.f = r13;	 Catch:{ Exception -> 0x01a0 }
        r12 = new anetwork.channel.e.f;	 Catch:{ Exception -> 0x01a0 }
        r12.<init>(r11);	 Catch:{ Exception -> 0x01a0 }
        r13 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.c;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13 * 2000;	 Catch:{ Exception -> 0x01a0 }
        r13 = (long) r13;	 Catch:{ Exception -> 0x01a0 }
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x01a0 }
        anet.channel.a.c.a(r12, r13, r0);	 Catch:{ Exception -> 0x01a0 }
        return;	 Catch:{ Exception -> 0x01a0 }
    L_0x0098:
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.i;	 Catch:{ Exception -> 0x01a0 }
        if (r1 != 0) goto L_0x00a2;	 Catch:{ Exception -> 0x01a0 }
    L_0x009e:
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1.i = r12;	 Catch:{ Exception -> 0x01a0 }
    L_0x00a2:
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.i;	 Catch:{ Exception -> 0x01a0 }
        r14.statusCode = r1;	 Catch:{ Exception -> 0x01a0 }
        r14.msg = r13;	 Catch:{ Exception -> 0x01a0 }
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.a;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.d;	 Catch:{ Exception -> 0x01a0 }
        r1.filledBy(r14);	 Catch:{ Exception -> 0x01a0 }
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.i;	 Catch:{ Exception -> 0x01a0 }
        r2 = 304; // 0x130 float:4.26E-43 double:1.5E-321;	 Catch:{ Exception -> 0x01a0 }
        if (r1 != r2) goto L_0x00d3;	 Catch:{ Exception -> 0x01a0 }
    L_0x00bb:
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.c;	 Catch:{ Exception -> 0x01a0 }
        if (r1 == 0) goto L_0x00d3;	 Catch:{ Exception -> 0x01a0 }
    L_0x00c1:
        r1 = "cache";	 Catch:{ Exception -> 0x01a0 }
        r14.protocolType = r1;	 Catch:{ Exception -> 0x01a0 }
        r1 = new anetwork.channel.aidl.DefaultFinishEvent;	 Catch:{ Exception -> 0x01a0 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x01a0 }
        r4 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r4 = r4.a;	 Catch:{ Exception -> 0x01a0 }
        r4 = r4.d;	 Catch:{ Exception -> 0x01a0 }
        r1.<init>(r2, r13, r4);	 Catch:{ Exception -> 0x01a0 }
        goto L_0x00e2;	 Catch:{ Exception -> 0x01a0 }
    L_0x00d3:
        r1 = new anetwork.channel.aidl.DefaultFinishEvent;	 Catch:{ Exception -> 0x01a0 }
        r2 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r2 = r2.i;	 Catch:{ Exception -> 0x01a0 }
        r4 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r4 = r4.a;	 Catch:{ Exception -> 0x01a0 }
        r4 = r4.d;	 Catch:{ Exception -> 0x01a0 }
        r1.<init>(r2, r13, r4);	 Catch:{ Exception -> 0x01a0 }
    L_0x00e2:
        r13 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.b;	 Catch:{ Exception -> 0x01a0 }
        r13.a(r1);	 Catch:{ Exception -> 0x01a0 }
        r13 = anet.channel.util.ALog.isPrintLog(r0);	 Catch:{ Exception -> 0x01a0 }
        if (r13 == 0) goto L_0x0108;	 Catch:{ Exception -> 0x01a0 }
    L_0x00f1:
        r13 = "anet.NetworkTask";	 Catch:{ Exception -> 0x01a0 }
        r0 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r0 = r0.a;	 Catch:{ Exception -> 0x01a0 }
        r0 = r0.d;	 Catch:{ Exception -> 0x01a0 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x01a0 }
        r1 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.a;	 Catch:{ Exception -> 0x01a0 }
        r1 = r1.c;	 Catch:{ Exception -> 0x01a0 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01a0 }
        anet.channel.util.ALog.i(r13, r0, r1, r2);	 Catch:{ Exception -> 0x01a0 }
    L_0x0108:
        r13 = -200; // 0xffffffffffffff38 float:NaN double:NaN;	 Catch:{ Exception -> 0x01a0 }
        if (r12 == r13) goto L_0x0113;	 Catch:{ Exception -> 0x01a0 }
    L_0x010c:
        r13 = anet.channel.appmonitor.AppMonitor.getInstance();	 Catch:{ Exception -> 0x01a0 }
        r13.commitStat(r14);	 Catch:{ Exception -> 0x01a0 }
    L_0x0113:
        if (r12 < 0) goto L_0x0126;	 Catch:{ Exception -> 0x01a0 }
    L_0x0115:
        r4 = anet.channel.monitor.b.a();	 Catch:{ Exception -> 0x01a0 }
        r5 = r14.start;	 Catch:{ Exception -> 0x01a0 }
        r12 = r14.start;	 Catch:{ Exception -> 0x01a0 }
        r0 = r14.oneWayTime;	 Catch:{ Exception -> 0x01a0 }
        r7 = r12 + r0;	 Catch:{ Exception -> 0x01a0 }
        r9 = r14.recDataSize;	 Catch:{ Exception -> 0x01a0 }
        r4.a(r5, r7, r9);	 Catch:{ Exception -> 0x01a0 }
    L_0x0126:
        r12 = anet.channel.flow.c.a();	 Catch:{ Exception -> 0x01a0 }
        r13 = new anet.channel.flow.b;	 Catch:{ Exception -> 0x01a0 }
        r0 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r0 = r0.e;	 Catch:{ Exception -> 0x01a0 }
        r13.<init>(r0, r14);	 Catch:{ Exception -> 0x01a0 }
        r12.commitFlow(r13);	 Catch:{ Exception -> 0x01a0 }
        r12 = anetwork.channel.stat.b.a.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.b;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.getUrlString();	 Catch:{ Exception -> 0x01a0 }
        r14 = r11.b;	 Catch:{ Exception -> 0x01a0 }
        r14 = r14.a;	 Catch:{ Exception -> 0x01a0 }
        r14 = r14.d;	 Catch:{ Exception -> 0x01a0 }
        r12.a(r13, r14);	 Catch:{ Exception -> 0x01a0 }
        r12 = anetwork.channel.statist.a.a();	 Catch:{ Exception -> 0x01a0 }
        r13 = r11.a;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.getHttpUrl();	 Catch:{ Exception -> 0x01a0 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01a0 }
        r14 = r12.a;	 Catch:{ Exception -> 0x01a0 }
        if (r14 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a0 }
    L_0x015f:
        r4 = 0;	 Catch:{ Exception -> 0x01a0 }
        r14 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1));	 Catch:{ Exception -> 0x01a0 }
        if (r14 <= 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a0 }
    L_0x0165:
        if (r13 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a0 }
    L_0x0167:
        r13 = r13.c();	 Catch:{ Exception -> 0x01a0 }
        r14 = r12.c;	 Catch:{ Exception -> 0x01a0 }
        r13 = r14.remove(r13);	 Catch:{ Exception -> 0x01a0 }
        if (r13 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a0 }
    L_0x0173:
        r13 = r12.c;	 Catch:{ Exception -> 0x01a0 }
        r13 = r13.isEmpty();	 Catch:{ Exception -> 0x01a0 }
        if (r13 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a0 }
    L_0x017b:
        r13 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01a0 }
        r0 = r12.b;	 Catch:{ Exception -> 0x01a0 }
        r4 = r13 - r0;	 Catch:{ Exception -> 0x01a0 }
        r13 = "awcn.StatisticReqTimes";	 Catch:{ Exception -> 0x01a0 }
        r14 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01a0 }
        r0 = "this req spend times: ";	 Catch:{ Exception -> 0x01a0 }
        r14.<init>(r0);	 Catch:{ Exception -> 0x01a0 }
        r14.append(r4);	 Catch:{ Exception -> 0x01a0 }
        r14 = r14.toString();	 Catch:{ Exception -> 0x01a0 }
        r0 = 0;	 Catch:{ Exception -> 0x01a0 }
        r1 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x01a0 }
        anet.channel.util.ALog.i(r13, r14, r0, r1);	 Catch:{ Exception -> 0x01a0 }
        r13 = r12.e;	 Catch:{ Exception -> 0x01a0 }
        r0 = r13 + r4;	 Catch:{ Exception -> 0x01a0 }
        r12.e = r0;	 Catch:{ Exception -> 0x01a0 }
    L_0x019f:
        return;
    L_0x01a0:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.e.e.onFinish(int, java.lang.String, anet.channel.statist.RequestStatistic):void");
    }
}
