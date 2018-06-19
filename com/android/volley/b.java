package com.android.volley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: CacheDispatcher */
public final class b extends Thread {
    private static final boolean a = q.b;
    private final BlockingQueue<Request<?>> b;
    private final BlockingQueue<Request<?>> c;
    private final a d;
    private final o e;
    private volatile boolean f = false;
    private final a g;

    /* compiled from: CacheDispatcher */
    private static class a implements a {
        private final Map<String, List<Request<?>>> a = new HashMap();
        private final b b;

        a(b bVar) {
            this.b = bVar;
        }

        public final void a(Request<?> request, n<?> nVar) {
            if (nVar.b != null) {
                if (!nVar.b.a()) {
                    List<Request> list;
                    request = request.getCacheKey();
                    synchronized (this) {
                        list = (List) this.a.remove(request);
                    }
                    if (list != null) {
                        if (q.b) {
                            q.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), request);
                        }
                        for (Request a : list) {
                            this.b.e.a(a, (n) nVar);
                        }
                    }
                    return;
                }
            }
            a(request);
        }

        public final synchronized void a(Request<?> request) {
            request = request.getCacheKey();
            List list = (List) this.a.remove(request);
            if (!(list == null || list.isEmpty())) {
                if (q.b) {
                    q.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), request);
                }
                Request request2 = (Request) list.remove(0);
                this.a.put(request, list);
                request2.setNetworkRequestCompleteListener(this);
                try {
                    this.b.c.put(request2);
                } catch (Request<?> request3) {
                    q.c("Couldn't add request to queue. %s", request3.toString());
                    Thread.currentThread().interrupt();
                    this.b.a();
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        final synchronized boolean b(com.android.volley.Request<?> r6) {
            /*
            r5 = this;
            monitor-enter(r5);
            r0 = r6.getCacheKey();	 Catch:{ all -> 0x0052 }
            r1 = r5.a;	 Catch:{ all -> 0x0052 }
            r1 = r1.containsKey(r0);	 Catch:{ all -> 0x0052 }
            r2 = 0;
            r3 = 1;
            if (r1 == 0) goto L_0x003a;
        L_0x000f:
            r1 = r5.a;	 Catch:{ all -> 0x0052 }
            r1 = r1.get(r0);	 Catch:{ all -> 0x0052 }
            r1 = (java.util.List) r1;	 Catch:{ all -> 0x0052 }
            if (r1 != 0) goto L_0x001e;
        L_0x0019:
            r1 = new java.util.ArrayList;	 Catch:{ all -> 0x0052 }
            r1.<init>();	 Catch:{ all -> 0x0052 }
        L_0x001e:
            r4 = "waiting-for-response";
            r6.addMarker(r4);	 Catch:{ all -> 0x0052 }
            r1.add(r6);	 Catch:{ all -> 0x0052 }
            r6 = r5.a;	 Catch:{ all -> 0x0052 }
            r6.put(r0, r1);	 Catch:{ all -> 0x0052 }
            r6 = com.android.volley.q.b;	 Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038;
        L_0x002f:
            r6 = "Request for cacheKey=%s is in flight, putting on hold.";
            r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0052 }
            r1[r2] = r0;	 Catch:{ all -> 0x0052 }
            com.android.volley.q.b(r6, r1);	 Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5);
            return r3;
        L_0x003a:
            r1 = r5.a;	 Catch:{ all -> 0x0052 }
            r4 = 0;
            r1.put(r0, r4);	 Catch:{ all -> 0x0052 }
            r6.setNetworkRequestCompleteListener(r5);	 Catch:{ all -> 0x0052 }
            r6 = com.android.volley.q.b;	 Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050;
        L_0x0047:
            r6 = "new request, sending to network %s";
            r1 = new java.lang.Object[r3];	 Catch:{ all -> 0x0052 }
            r1[r2] = r0;	 Catch:{ all -> 0x0052 }
            com.android.volley.q.b(r6, r1);	 Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5);
            return r2;
        L_0x0052:
            r6 = move-exception;
            monitor-exit(r5);
            throw r6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.volley.b.a.b(com.android.volley.Request):boolean");
        }
    }

    public b(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, a aVar, o oVar) {
        this.b = blockingQueue;
        this.c = blockingQueue2;
        this.d = aVar;
        this.e = oVar;
        this.g = new a(this);
    }

    public final void a() {
        this.f = true;
        interrupt();
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
        r2 = this;
        r0 = a;
        if (r0 == 0) goto L_0x000c;
    L_0x0004:
        r0 = "start new dispatcher";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        com.android.volley.q.a(r0, r1);
    L_0x000c:
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = r2.d;
        r0.a();
    L_0x0016:
        r2.b();	 Catch:{ InterruptedException -> 0x001a }
        goto L_0x0016;
    L_0x001a:
        r0 = r2.f;
        if (r0 == 0) goto L_0x0016;
    L_0x001e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.b.run():void");
    }

    private void b() throws InterruptedException {
        Request request = (Request) this.b.take();
        request.addMarker("cache-queue-take");
        if (request.isCanceled()) {
            request.finish("cache-discard-canceled");
            return;
        }
        com.android.volley.a.a a = this.d.a(request.getCacheKey());
        if (a == null) {
            request.addMarker("cache-miss");
            if (!this.g.b(request)) {
                this.c.put(request);
            }
        } else if (a.a()) {
            request.addMarker("cache-hit-expired");
            request.setCacheEntry(a);
            if (!this.g.b(request)) {
                this.c.put(request);
            }
        } else {
            request.addMarker("cache-hit");
            byte b = (byte) 0;
            n parseNetworkResponse = request.parseNetworkResponse(new j(a.a, a.g, (byte) 0));
            request.addMarker("cache-hit-parsed");
            if (a.f < System.currentTimeMillis()) {
                b = (byte) 1;
            }
            if (b != (byte) 0) {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(a);
                parseNetworkResponse.d = true;
                if (!this.g.b(request)) {
                    this.e.a(request, parseNetworkResponse, new c(this, request));
                    return;
                }
            }
            this.e.a(request, parseNetworkResponse);
        }
    }
}
