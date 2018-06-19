package com.android.volley;

import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: NetworkDispatcher */
public final class i extends Thread {
    volatile boolean a = false;
    private final BlockingQueue<Request<?>> b;
    private final h c;
    private final a d;
    private final o e;

    public i(BlockingQueue<Request<?>> blockingQueue, h hVar, a aVar, o oVar) {
        this.b = blockingQueue;
        this.c = hVar;
        this.d = aVar;
        this.e = oVar;
    }

    public final void run() {
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
        r1 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
    L_0x0005:
        r1.a();	 Catch:{ InterruptedException -> 0x0009 }
        goto L_0x0005;
    L_0x0009:
        r0 = r1.a;
        if (r0 == 0) goto L_0x0005;
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.i.run():void");
    }

    private void a() throws InterruptedException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Request request = (Request) this.b.take();
        try {
            request.addMarker("network-queue-take");
            if (request.isCanceled()) {
                request.finish("network-discard-cancelled");
                request.notifyListenerResponseNotUsable();
                return;
            }
            if (VERSION.SDK_INT >= 14) {
                TrafficStats.setThreadStatsTag(request.getTrafficStatsTag());
            }
            j a = this.c.a(request);
            request.addMarker("network-http-complete");
            if (a.e && request.hasHadResponseDelivered()) {
                request.finish("not-modified");
                request.notifyListenerResponseNotUsable();
                return;
            }
            n parseNetworkResponse = request.parseNetworkResponse(a);
            request.addMarker("network-parse-complete");
            if (request.shouldCache() && parseNetworkResponse.b != null) {
                this.d.a(request.getCacheKey(), parseNetworkResponse.b);
                request.addMarker("network-cache-written");
            }
            request.markDelivered();
            this.e.a(request, parseNetworkResponse);
            request.notifyListenerResponseReceived(parseNetworkResponse);
        } catch (VolleyError e) {
            e.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.e.a(request, request.parseNetworkError(e));
            request.notifyListenerResponseNotUsable();
        } catch (Throwable e2) {
            q.d("Unhandled exception %s", e2.toString());
            VolleyError volleyError = new VolleyError(e2);
            volleyError.setNetworkTimeMs(SystemClock.elapsedRealtime() - elapsedRealtime);
            this.e.a(request, volleyError);
            request.notifyListenerResponseNotUsable();
        }
    }
}
