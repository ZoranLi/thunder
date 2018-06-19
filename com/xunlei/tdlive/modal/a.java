package com.xunlei.tdlive.modal;

import android.os.SystemClock;
import com.xunlei.tdlive.protocol.XLLiveGetFollowListRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest;
import com.xunlei.tdlive.protocol.XLLiveRequest.JsonCallBack;
import com.xunlei.tdlive.util.j;
import com.xunlei.tdlive.util.k;
import java.util.HashMap;

/* compiled from: FocusLiveRemindState */
public class a implements JsonCallBack, Runnable {
    private static a a;
    private XLLiveRequest b;
    private j c;
    private HashMap<String, b> d = new HashMap();
    private k<a> e = new k();

    /* compiled from: FocusLiveRemindState */
    public interface a {
        void onFocusLiveRemindStateChanged();
    }

    /* compiled from: FocusLiveRemindState */
    class b {
        JsonWrapper a;
        long b;
        boolean c;
        final /* synthetic */ a d;

        b(a aVar) {
            this.d = aVar;
        }
    }

    public static a a() {
        if (a == null) {
            a = new a();
        }
        return a;
    }

    a() {
    }

    public void a(a aVar) {
        this.e.a(aVar);
    }

    public void b(a aVar) {
        this.e.b(aVar);
    }

    public void b() {
        if (this.c == null) {
            this.c = new j(10000, this);
        }
        this.c.c();
        this.c.d();
    }

    public void c() {
        if (this.c != null) {
            this.c.b();
        }
    }

    public void d() {
        this.d.clear();
        k();
    }

    public void e() {
        if (this.b == null || this.b.tryLock()) {
            this.b = new XLLiveGetFollowListRequest(com.xunlei.tdlive.sdk.b.a().e(), XLLiveGetFollowListRequest.TP_FOLLOW, 0, 100).send((JsonCallBack) this);
        }
    }

    public int f() {
        return this.d.size();
    }

    public JsonWrapper g() {
        JsonWrapper jsonWrapper = new JsonWrapper("[]");
        for (b bVar : this.d.values()) {
            jsonWrapper.add(bVar.a);
        }
        return jsonWrapper;
    }

    public int h() {
        int i = 0;
        for (b bVar : this.d.values()) {
            if (bVar.c) {
                i++;
            }
        }
        return i;
    }

    public JsonWrapper i() {
        JsonWrapper jsonWrapper = null;
        long j = 0;
        for (b bVar : this.d.values()) {
            if (bVar.c && bVar.b > r2) {
                jsonWrapper = bVar.a;
                j = bVar.b;
            }
        }
        return jsonWrapper;
    }

    public void j() {
        for (b bVar : this.d.values()) {
            bVar.c = false;
        }
        k();
    }

    public void a(JsonWrapper jsonWrapper, boolean z, boolean z2) {
        b bVar = new b(this);
        bVar.a = jsonWrapper;
        bVar.c = z;
        bVar.b = SystemClock.elapsedRealtime();
        this.d.put(jsonWrapper.getString("userid", ""), bVar);
        if (z2) {
            k();
        }
    }

    public void run() {
        e();
    }

    public void onResponse(int r6, java.lang.String r7, com.xunlei.tdlive.modal.JsonWrapper r8) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        if (r6 != 0) goto L_0x0067;
    L_0x0002:
        r6 = new java.util.HashSet;
        r7 = r5.d;
        r7 = r7.keySet();
        r6.<init>(r7);
        r7 = "data";
        r0 = "[]";
        r7 = r8.getArray(r7, r0);
        r8 = 0;
        r0 = r8;
    L_0x0017:
        r1 = r7.getLength();
        if (r0 >= r1) goto L_0x004e;
    L_0x001d:
        r1 = "{}";
        r1 = r7.getObject(r0, r1);
        r2 = "is_playering";
        r2 = r1.getInt(r2, r8);
        r3 = 1;
        if (r2 != r3) goto L_0x004b;
    L_0x002c:
        r2 = "userid";
        r4 = "";
        r2 = r1.getString(r2, r4);
        r4 = r6.contains(r2);
        if (r4 == 0) goto L_0x0048;
    L_0x003a:
        r6.remove(r2);
        r3 = r5.d;
        r2 = r3.get(r2);
        r2 = (com.xunlei.tdlive.modal.a.b) r2;
        r2.a = r1;
        goto L_0x004b;
    L_0x0048:
        r5.a(r1, r3, r8);
    L_0x004b:
        r0 = r0 + 1;
        goto L_0x0017;
    L_0x004e:
        r6 = r6.iterator();
    L_0x0052:
        r7 = r6.hasNext();
        if (r7 == 0) goto L_0x0064;
    L_0x0058:
        r7 = r6.next();
        r7 = (java.lang.String) r7;
        r8 = r5.d;
        r8.remove(r7);
        goto L_0x0052;
    L_0x0064:
        r5.k();
    L_0x0067:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.modal.a.onResponse(int, java.lang.String, com.xunlei.tdlive.modal.JsonWrapper):void");
    }

    private void k() {
        this.e.a(new com.xunlei.tdlive.util.k.a<a>(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public void a(a aVar, Object... objArr) {
                aVar.onFocusLiveRemindStateChanged();
            }
        }, new Object[0]);
    }
}
