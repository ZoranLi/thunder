package com.igexin.push.c;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.igexin.b.a.b.c;
import com.igexin.b.a.b.f;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.e;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.b.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class m {
    private static final String e = "com.igexin.push.c.m";
    protected long a;
    protected final Map<String, p> b = new LinkedHashMap();
    protected final Map<String, j> c = new HashMap();
    protected a d = new a();
    private final Object f = new Object();
    private final Object g = new Object();
    private int h;
    private AtomicBoolean i = new AtomicBoolean(false);
    private final Comparator<Entry<String, j>> j = new n(this);
    private int k = s();

    public m(String str, String str2) {
        if (i.a) {
            a(false);
            return;
        }
        b(str);
        c(str2);
    }

    private j a(JSONObject jSONObject) {
        if (!jSONObject.has(DispatchConstants.DOMAIN)) {
            return null;
        }
        j jVar = new j();
        jVar.a(jSONObject.getString(DispatchConstants.DOMAIN));
        if (jSONObject.has("port")) {
            jVar.a(jSONObject.getInt("port"));
        }
        if (jSONObject.has("ip")) {
            jVar.b(jSONObject.getString("ip"));
        }
        if (jSONObject.has("consumeTime")) {
            jVar.a(jSONObject.getLong("consumeTime"));
        }
        if (jSONObject.has("detectSuccessTime")) {
            jVar.b(jSONObject.getLong("detectSuccessTime"));
        }
        if (jSONObject.has("isDomain")) {
            jVar.a(jSONObject.getBoolean("isDomain"));
        }
        if (jSONObject.has("connectTryCnt")) {
            jVar.b(jSONObject.getInt("connectTryCnt"));
        }
        return jVar;
    }

    private List<String> a() {
        String[] xfrAddress = SDKUrlConfig.getXfrAddress();
        List<String> arrayList = new ArrayList();
        for (Object obj : xfrAddress) {
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private java.util.List<java.lang.String> a(org.json.JSONArray r5) {
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
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
    L_0x0006:
        r2 = r5.length();	 Catch:{ Exception -> 0x001c }
        if (r1 >= r2) goto L_0x001c;	 Catch:{ Exception -> 0x001c }
    L_0x000c:
        r2 = r5.getJSONObject(r1);	 Catch:{ Exception -> 0x001c }
        r3 = "domain";	 Catch:{ Exception -> 0x001c }
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x001c }
        r0.add(r2);	 Catch:{ Exception -> 0x001c }
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.a(org.json.JSONArray):java.util.List<java.lang.String>");
    }

    private void a(j jVar) {
        e pVar = new p();
        pVar.a(c());
        pVar.a(jVar);
        synchronized (this.g) {
            this.b.put(jVar.a(), pVar);
        }
        c.b().a(pVar, true, true);
    }

    private void a(boolean z) {
        g a;
        String str;
        boolean z2;
        List<String> a2;
        List arrayList;
        this.a = 0;
        j jVar;
        if (t()) {
            if (com.igexin.push.core.g.ax != null) {
                a = g.a();
                str = "null";
                z2 = true;
            }
            a2 = a();
            arrayList = new ArrayList();
            for (String str2 : a2) {
                jVar = new j(str2, Integer.parseInt(f.a(str2)[2]));
                if (!z) {
                    a(jVar);
                }
                arrayList.add(jVar);
            }
            this.d.b(arrayList);
            a2.clear();
        }
        if (com.igexin.push.core.g.ay != null) {
            a = g.a();
            str = "null";
            z2 = false;
        }
        a2 = a();
        arrayList = new ArrayList();
        for (String str22 : a2) {
            jVar = new j(str22, Integer.parseInt(f.a(str22)[2]));
            if (!z) {
                a(jVar);
            }
            arrayList.add(jVar);
        }
        this.d.b(arrayList);
        a2.clear();
        a.b(str, z2);
        a2 = a();
        arrayList = new ArrayList();
        for (String str222 : a2) {
            jVar = new j(str222, Integer.parseInt(f.a(str222)[2]));
            if (!z) {
                a(jVar);
            }
            arrayList.add(jVar);
        }
        this.d.b(arrayList);
        a2.clear();
    }

    private void b(java.lang.String r10) {
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
        r9 = this;
        r0 = android.text.TextUtils.isEmpty(r10);
        r1 = 1;
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r9.a(r1);
        return;
    L_0x000b:
        r0 = 0;
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0012 }
        r2.<init>(r10);	 Catch:{ JSONException -> 0x0012 }
        goto L_0x0013;
    L_0x0012:
        r2 = r0;
    L_0x0013:
        if (r2 == 0) goto L_0x00c4;
    L_0x0015:
        r10 = r2.length();
        if (r10 != 0) goto L_0x001d;
    L_0x001b:
        goto L_0x00c4;
    L_0x001d:
        r10 = "lastDetectTime";
        r10 = r2.has(r10);
        if (r10 == 0) goto L_0x002d;
    L_0x0025:
        r10 = "lastDetectTime";	 Catch:{ JSONException -> 0x002d }
        r3 = r2.getLong(r10);	 Catch:{ JSONException -> 0x002d }
        r9.a = r3;	 Catch:{ JSONException -> 0x002d }
    L_0x002d:
        r3 = java.lang.System.currentTimeMillis();
        r5 = r9.a;
        r7 = r3 - r5;
        r3 = java.lang.Math.abs(r7);
        r5 = com.igexin.push.c.f.a;
        r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
        if (r10 < 0) goto L_0x0043;
    L_0x003f:
        r9.a(r1);
        return;
    L_0x0043:
        r10 = "list";
        r10 = r2.has(r10);
        if (r10 == 0) goto L_0x0052;
    L_0x004b:
        r10 = "list";	 Catch:{ JSONException -> 0x0052 }
        r10 = r2.getJSONArray(r10);	 Catch:{ JSONException -> 0x0052 }
        goto L_0x0053;
    L_0x0052:
        r10 = r0;
    L_0x0053:
        if (r10 == 0) goto L_0x00c0;
    L_0x0055:
        r0 = r10.length();
        if (r0 != 0) goto L_0x005c;
    L_0x005b:
        goto L_0x00c0;
    L_0x005c:
        r0 = r9.a(r10);
        if (r0 == 0) goto L_0x00bc;
    L_0x0062:
        r2 = r0.isEmpty();
        if (r2 == 0) goto L_0x0069;
    L_0x0068:
        goto L_0x00bc;
    L_0x0069:
        r2 = r9.a();
        r3 = new java.util.ArrayList;
        r3.<init>(r2);
        r3.retainAll(r0);
        r4 = r3.size();
        r5 = r0.size();
        if (r4 == r5) goto L_0x00a2;
    L_0x007f:
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r4 = e;
        r10.append(r4);
        r4 = " | db cache xfr != default, use default";
        r10.append(r4);
        r10 = r10.toString();
        com.igexin.b.a.c.a.b(r10);
        r3.clear();
        r2.clear();
        r0.clear();
        r9.a(r1);
        return;
    L_0x00a2:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = e;
        r0.append(r1);
        r1 = " | db cache xfr == default, use cache";
        r0.append(r1);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r9.b(r10);
        return;
    L_0x00bc:
        r9.a(r1);
        return;
    L_0x00c0:
        r9.a(r1);
        return;
    L_0x00c4:
        r9.a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.b(java.lang.String):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(org.json.JSONArray r6) {
        /*
        r5 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
    L_0x0006:
        r2 = r6.length();	 Catch:{ Exception -> 0x0063 }
        if (r1 >= r2) goto L_0x005d;
    L_0x000c:
        r2 = r6.getJSONObject(r1);	 Catch:{ Exception -> 0x0063 }
        r3 = r5.a(r2);	 Catch:{ Exception -> 0x0063 }
        if (r3 == 0) goto L_0x0020;
    L_0x0016:
        r2 = r5.c;	 Catch:{ Exception -> 0x0063 }
        r4 = r3.a();	 Catch:{ Exception -> 0x0063 }
        r2.put(r4, r3);	 Catch:{ Exception -> 0x0063 }
        goto L_0x002a;
    L_0x0020:
        r3 = "domain";
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x0035 }
        r3 = r5.d(r2);	 Catch:{ Exception -> 0x0035 }
    L_0x002a:
        if (r3 == 0) goto L_0x0032;
    L_0x002c:
        r5.a(r3);	 Catch:{ Exception -> 0x0063 }
        r0.add(r3);	 Catch:{ Exception -> 0x0063 }
    L_0x0032:
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x0035:
        r6 = move-exception;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0063 }
        r1 = e;	 Catch:{ Exception -> 0x0063 }
        r0.append(r1);	 Catch:{ Exception -> 0x0063 }
        r1 = "|initWithCacheData exception ";
        r0.append(r1);	 Catch:{ Exception -> 0x0063 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0063 }
        r0.append(r6);	 Catch:{ Exception -> 0x0063 }
        r6 = r0.toString();	 Catch:{ Exception -> 0x0063 }
        com.igexin.b.a.c.a.b(r6);	 Catch:{ Exception -> 0x0063 }
        r6 = r5.c;	 Catch:{ Exception -> 0x0063 }
        r6.clear();	 Catch:{ Exception -> 0x0063 }
        r6 = 1;
        r5.a(r6);	 Catch:{ Exception -> 0x0063 }
        return;
    L_0x005d:
        r6 = r5.d;	 Catch:{ Exception -> 0x0063 }
        r6.b(r0);	 Catch:{ Exception -> 0x0063 }
        return;
    L_0x0063:
        r6 = move-exception;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = e;
        r0.append(r1);
        r1 = "|initWithCacheData exception ";
        r0.append(r1);
        r6 = r6.toString();
        r0.append(r6);
        r6 = r0.toString();
        com.igexin.b.a.c.a.b(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.b(org.json.JSONArray):void");
    }

    private void c(java.lang.String r4) {
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
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x000e }
        r1.<init>(r4);	 Catch:{ JSONException -> 0x000e }
        r0 = r1;
    L_0x000e:
        if (r0 == 0) goto L_0x0083;
    L_0x0010:
        r4 = r0.length();
        if (r4 != 0) goto L_0x0017;
    L_0x0016:
        return;
    L_0x0017:
        r4 = "detectFailedCnt";
        r4 = r0.has(r4);
        if (r4 == 0) goto L_0x0027;
    L_0x001f:
        r4 = "detectFailedCnt";	 Catch:{ JSONException -> 0x0027 }
        r4 = r0.getInt(r4);	 Catch:{ JSONException -> 0x0027 }
        r3.h = r4;	 Catch:{ JSONException -> 0x0027 }
    L_0x0027:
        r4 = "loginFailedlCnt";
        r4 = r0.has(r4);
        if (r4 == 0) goto L_0x0039;
    L_0x002f:
        r4 = r3.d;	 Catch:{ JSONException -> 0x0039 }
        r1 = "loginFailedlCnt";	 Catch:{ JSONException -> 0x0039 }
        r1 = r0.getInt(r1);	 Catch:{ JSONException -> 0x0039 }
        r4.c = r1;	 Catch:{ JSONException -> 0x0039 }
    L_0x0039:
        r4 = "lastChange2BackupTime";
        r4 = r0.has(r4);
        if (r4 == 0) goto L_0x004b;
    L_0x0041:
        r4 = r3.d;	 Catch:{ JSONException -> 0x004b }
        r1 = "lastChange2BackupTime";	 Catch:{ JSONException -> 0x004b }
        r1 = r0.getLong(r1);	 Catch:{ JSONException -> 0x004b }
        r4.d = r1;	 Catch:{ JSONException -> 0x004b }
    L_0x004b:
        r4 = "lastOfflineTime";
        r4 = r0.has(r4);
        if (r4 == 0) goto L_0x005d;
    L_0x0053:
        r4 = r3.d;	 Catch:{ JSONException -> 0x005d }
        r1 = "lastOfflineTime";	 Catch:{ JSONException -> 0x005d }
        r1 = r0.getLong(r1);	 Catch:{ JSONException -> 0x005d }
        r4.e = r1;	 Catch:{ JSONException -> 0x005d }
    L_0x005d:
        r4 = "domainType";
        r4 = r0.has(r4);
        if (r4 == 0) goto L_0x0083;
    L_0x0065:
        r4 = r3.d;	 Catch:{ JSONException -> 0x0083 }
        r1 = "domainType";	 Catch:{ JSONException -> 0x0083 }
        r0 = r0.getInt(r1);	 Catch:{ JSONException -> 0x0083 }
        r0 = com.igexin.push.c.d.a(r0);	 Catch:{ JSONException -> 0x0083 }
        r4.a = r0;	 Catch:{ JSONException -> 0x0083 }
        r4 = r3.d;	 Catch:{ JSONException -> 0x0083 }
        r4 = r4.a;	 Catch:{ JSONException -> 0x0083 }
        r0 = com.igexin.push.c.d.BACKUP;	 Catch:{ JSONException -> 0x0083 }
        if (r4 != r0) goto L_0x0083;	 Catch:{ JSONException -> 0x0083 }
    L_0x007b:
        r4 = r3.d;	 Catch:{ JSONException -> 0x0083 }
        r4 = r4.b;	 Catch:{ JSONException -> 0x0083 }
        r0 = 1;	 Catch:{ JSONException -> 0x0083 }
        r4.set(r0);	 Catch:{ JSONException -> 0x0083 }
    L_0x0083:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.c(java.lang.String):void");
    }

    private j d(String str) {
        j jVar = new j();
        String[] a = f.a(str);
        jVar.a(str);
        jVar.a(Integer.parseInt(a[2]));
        return jVar;
    }

    private void r() {
        synchronized (this.f) {
            this.c.clear();
        }
    }

    private int s() {
        return a().size();
    }

    private boolean t() {
        return b() == h.MOBILE;
    }

    protected p a(String str) {
        synchronized (this.g) {
            for (Entry entry : this.b.entrySet()) {
                if (((String) entry.getKey()).equals(str)) {
                    p pVar = (p) entry.getValue();
                    return pVar;
                }
            }
            return null;
        }
    }

    public abstract h b();

    protected void b(j jVar) {
        synchronized (this.f) {
            this.c.put(jVar.a(), jVar);
        }
        this.d.d();
    }

    public abstract o c();

    protected String c(j jVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jVar.a());
        stringBuilder.append("[");
        stringBuilder.append(jVar.c());
        stringBuilder.append("] ");
        return stringBuilder.toString();
    }

    public void d() {
        if (m()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e);
            stringBuilder.append("|startDetect detect = true, start detect !!!");
            a.b(stringBuilder.toString());
            this.i.set(true);
            j();
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append("|startDetect detect = false, return !!!");
        a.b(stringBuilder.toString());
    }

    public void e() {
        synchronized (this.g) {
            for (Entry entry : this.b.entrySet()) {
                ((p) entry.getValue()).a(null);
                ((p) entry.getValue()).g();
            }
        }
    }

    public void f() {
        this.i.set(true);
        synchronized (this.g) {
            for (Entry entry : this.b.entrySet()) {
                ((p) entry.getValue()).a(c());
                ((p) entry.getValue()).a(true);
            }
        }
    }

    public j g() {
        synchronized (this.f) {
            if (this.c.isEmpty()) {
                return null;
            }
            Object arrayList = new ArrayList(this.c.entrySet());
            Collections.sort(arrayList, this.j);
            j jVar = (j) ((Entry) arrayList.get(0)).getValue();
            return jVar;
        }
    }

    public void h() {
        e();
        r();
        List a = a();
        synchronized (this.g) {
            int size = this.b.size();
            int i = 0;
            if (a.size() < size) {
                int size2 = size - a.size();
                Iterator it = this.b.entrySet().iterator();
                int i2 = 0;
                while (it.hasNext() && i2 < size2) {
                    ((p) ((Entry) it.next()).getValue()).h();
                    it.remove();
                    i2++;
                }
            }
            List arrayList = new ArrayList(this.b.values());
            this.b.clear();
            List arrayList2 = new ArrayList();
            while (i < a.size()) {
                j jVar = new j();
                String[] a2 = f.a((String) a.get(i));
                jVar.a((String) a.get(i));
                jVar.a(Integer.parseInt(a2[2]));
                if (i < size) {
                    p pVar = (p) arrayList.get(i);
                    pVar.a(jVar);
                    this.b.put(jVar.a(), pVar);
                } else {
                    a(jVar);
                }
                arrayList2.add(jVar);
                i++;
            }
            this.d.b(arrayList2);
        }
    }

    public void i() {
        e();
        r();
        List a = a();
        synchronized (this.g) {
            for (Entry value : this.b.entrySet()) {
                ((p) value.getValue()).h();
            }
            this.b.clear();
            List arrayList = new ArrayList();
            j jVar = new j();
            String[] a2 = f.a((String) a.get(0));
            jVar.a((String) a.get(0));
            jVar.a(Integer.parseInt(a2[2]));
            arrayList.add(jVar);
            this.d.b(arrayList);
            arrayList.clear();
        }
    }

    public void j() {
        this.a = System.currentTimeMillis();
        synchronized (this.g) {
            for (Entry entry : this.b.entrySet()) {
                ((p) entry.getValue()).a(c());
                if (((p) entry.getValue()).d_() != null) {
                    ((p) entry.getValue()).d_().b();
                }
                ((p) entry.getValue()).i();
            }
        }
    }

    public synchronized void k() {
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
        r6 = this;
        monitor-enter(r6);
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0077 }
        r6.a = r0;	 Catch:{ all -> 0x0077 }
        r0 = new org.json.JSONObject;	 Catch:{ all -> 0x0077 }
        r0.<init>();	 Catch:{ all -> 0x0077 }
        r1 = new org.json.JSONArray;	 Catch:{ all -> 0x0077 }
        r1.<init>();	 Catch:{ all -> 0x0077 }
        r2 = r6.g;	 Catch:{ all -> 0x0077 }
        monitor-enter(r2);	 Catch:{ all -> 0x0077 }
        r3 = "lastDetectTime";	 Catch:{ Exception -> 0x004c }
        r4 = r6.a;	 Catch:{ Exception -> 0x004c }
        r0.put(r3, r4);	 Catch:{ Exception -> 0x004c }
        r3 = "list";	 Catch:{ Exception -> 0x004c }
        r0.put(r3, r1);	 Catch:{ Exception -> 0x004c }
        r3 = r6.b;	 Catch:{ Exception -> 0x004c }
        r3 = r3.entrySet();	 Catch:{ Exception -> 0x004c }
        r3 = r3.iterator();	 Catch:{ Exception -> 0x004c }
    L_0x002a:
        r4 = r3.hasNext();	 Catch:{ Exception -> 0x004c }
        if (r4 == 0) goto L_0x004c;	 Catch:{ Exception -> 0x004c }
    L_0x0030:
        r4 = r3.next();	 Catch:{ Exception -> 0x004c }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ Exception -> 0x004c }
        r4 = r4.getValue();	 Catch:{ Exception -> 0x004c }
        r4 = (com.igexin.push.c.p) r4;	 Catch:{ Exception -> 0x004c }
        r4 = r4.d_();	 Catch:{ Exception -> 0x004c }
        r4 = r4.i();	 Catch:{ Exception -> 0x004c }
        if (r4 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x004c }
    L_0x0046:
        r1.put(r4);	 Catch:{ Exception -> 0x004c }
        goto L_0x002a;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0075;
    L_0x004c:
        monitor-exit(r2);	 Catch:{ all -> 0x004a }
        r1 = r0.length();	 Catch:{ all -> 0x0077 }
        if (r1 <= 0) goto L_0x0073;	 Catch:{ all -> 0x0077 }
    L_0x0053:
        r1 = r6.t();	 Catch:{ all -> 0x0077 }
        if (r1 == 0) goto L_0x0067;	 Catch:{ all -> 0x0077 }
    L_0x0059:
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ all -> 0x0077 }
        r0 = r0.toString();	 Catch:{ all -> 0x0077 }
        r2 = 1;	 Catch:{ all -> 0x0077 }
        r1.b(r0, r2);	 Catch:{ all -> 0x0077 }
        monitor-exit(r6);
        return;
    L_0x0067:
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ all -> 0x0077 }
        r0 = r0.toString();	 Catch:{ all -> 0x0077 }
        r2 = 0;	 Catch:{ all -> 0x0077 }
        r1.b(r0, r2);	 Catch:{ all -> 0x0077 }
    L_0x0073:
        monitor-exit(r6);
        return;
    L_0x0075:
        monitor-exit(r2);	 Catch:{ all -> 0x004a }
        throw r0;	 Catch:{ all -> 0x0077 }
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.k():void");
    }

    protected void l() {
        g.a().b("null", true);
        g.a().b("null", false);
    }

    protected boolean m() {
        long abs = Math.abs(System.currentTimeMillis() - this.a);
        if (abs >= f.a - 3600) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e);
            stringBuilder.append("|current time - last detect time > ");
            stringBuilder.append(f.a / 1000);
            stringBuilder.append(" s, detect = true");
            a.b(stringBuilder.toString());
            k.a.set(true);
            return true;
        }
        if (!k.a.getAndSet(true)) {
            abs = Math.abs(f.a - abs);
            k.c_().a(abs);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(e);
            stringBuilder2.append("|set next detect time = ");
            stringBuilder2.append(abs);
            a.b(stringBuilder2.toString());
        }
        return false;
    }

    protected synchronized void n() {
        if (!com.igexin.push.core.g.l && this.i.getAndSet(false)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(e);
            stringBuilder.append("|online = false, reconnect");
            a.b(stringBuilder.toString());
            com.igexin.push.core.a.f.a().d(true);
        }
        if (this.h != 0) {
            this.h = 0;
            p();
        }
        this.d.e();
    }

    protected synchronized void o() {
        this.h++;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append("|detect failed cnt = ");
        stringBuilder.append(this.h / this.k);
        a.b(stringBuilder.toString());
        int i = this.h / this.k;
        if (i <= com.igexin.push.config.m.A) {
            p();
        }
        if (i >= com.igexin.push.config.m.A && !this.d.b.get()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(e);
            stringBuilder.append("|detect failed cnt = ");
            stringBuilder.append(this.h / this.k);
            stringBuilder.append(", enter backup ++++++++");
            a.b(stringBuilder.toString());
            this.d.f();
        }
    }

    protected synchronized void p() {
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
        monitor-enter(r4);
        r0 = new org.json.JSONObject;	 Catch:{ all -> 0x005d }
        r0.<init>();	 Catch:{ all -> 0x005d }
        r1 = "detectFailedCnt";	 Catch:{ Exception -> 0x0035 }
        r2 = r4.h;	 Catch:{ Exception -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r1 = "loginFailedlCnt";	 Catch:{ Exception -> 0x0035 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.c;	 Catch:{ Exception -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r1 = "lastChange2BackupTime";	 Catch:{ Exception -> 0x0035 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.d;	 Catch:{ Exception -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r1 = "lastOfflineTime";	 Catch:{ Exception -> 0x0035 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.e;	 Catch:{ Exception -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r1 = "domainType";	 Catch:{ Exception -> 0x0035 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0035 }
        r2 = r2.b();	 Catch:{ Exception -> 0x0035 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0035 }
    L_0x0035:
        r1 = r0.length();	 Catch:{ all -> 0x005d }
        if (r1 <= 0) goto L_0x005b;	 Catch:{ all -> 0x005d }
    L_0x003b:
        r1 = r4.t();	 Catch:{ all -> 0x005d }
        if (r1 == 0) goto L_0x004f;	 Catch:{ all -> 0x005d }
    L_0x0041:
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ all -> 0x005d }
        r0 = r0.toString();	 Catch:{ all -> 0x005d }
        r2 = 1;	 Catch:{ all -> 0x005d }
        r1.a(r0, r2);	 Catch:{ all -> 0x005d }
        monitor-exit(r4);
        return;
    L_0x004f:
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ all -> 0x005d }
        r0 = r0.toString();	 Catch:{ all -> 0x005d }
        r2 = 0;	 Catch:{ all -> 0x005d }
        r1.a(r0, r2);	 Catch:{ all -> 0x005d }
    L_0x005b:
        monitor-exit(r4);
        return;
    L_0x005d:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.m.p():void");
    }

    protected boolean q() {
        synchronized (this.f) {
            for (Entry value : this.c.entrySet()) {
                if (((j) value.getValue()).e() != 2147483647L) {
                    return true;
                }
            }
            return false;
        }
    }
}
