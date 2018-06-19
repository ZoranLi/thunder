package com.alibaba.baichuan.android.trade.c.a.a;

import android.os.Looper;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.c.a.a.a.c;
import com.alibaba.baichuan.android.trade.c.a.a.b.d;
import com.alibaba.baichuan.android.trade.c.a.a.b.f;
import com.alibaba.baichuan.android.trade.c.a.b.h;
import com.alibaba.baichuan.android.trade.c.a.b.i;
import com.alibaba.baichuan.android.trade.c.a.b.k;
import com.alibaba.baichuan.android.trade.f.b;
import com.alibaba.baichuan.android.trade.utils.j;
import com.taobao.accs.common.Constants;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class e {
    private static final e a = new e();
    private volatile Map b = new LinkedHashMap();
    private volatile Map c = new LinkedHashMap();
    private d d;
    private volatile boolean e;
    private LinkedHashMap f = new LinkedHashMap();
    private LinkedHashMap g = new LinkedHashMap();

    private static class a {
        public Boolean a;

        private a() {
        }
    }

    public static e a() {
        return a;
    }

    private void a(d dVar) {
        this.f.put(dVar.a, dVar);
    }

    private static boolean a(int i, int[] iArr) {
        if (iArr == null) {
            return true;
        }
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return true;
        }
        if (str == null) {
            return false;
        }
        for (Object equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    private void b() {
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
        r4 = this;
        r0 = new java.util.LinkedHashMap;	 Catch:{ Exception -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0063 }
        r1 = r4.d;	 Catch:{ Exception -> 0x0063 }
        r1 = r1.c;	 Catch:{ Exception -> 0x0063 }
        r1 = r1.entrySet();	 Catch:{ Exception -> 0x0063 }
        r1 = r1.iterator();	 Catch:{ Exception -> 0x0063 }
    L_0x0011:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x0063 }
        if (r2 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x0063 }
    L_0x0017:
        r2 = r1.next();	 Catch:{ Exception -> 0x0063 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ Exception -> 0x0063 }
        r3 = r2.getKey();	 Catch:{ Exception -> 0x0063 }
        r2 = r2.getValue();	 Catch:{ Exception -> 0x0063 }
        r2 = (com.alibaba.baichuan.android.trade.c.a.a.a.d) r2;	 Catch:{ Exception -> 0x0063 }
        r2 = r2.a();	 Catch:{ Exception -> 0x0063 }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x0063 }
        goto L_0x0011;	 Catch:{ Exception -> 0x0063 }
    L_0x002f:
        r4.c = r0;	 Catch:{ Exception -> 0x0063 }
        r0 = new java.util.LinkedHashMap;	 Catch:{ Exception -> 0x0063 }
        r0.<init>();	 Catch:{ Exception -> 0x0063 }
        r1 = r4.d;	 Catch:{ Exception -> 0x0063 }
        r1 = r1.b;	 Catch:{ Exception -> 0x0063 }
        r1 = r1.entrySet();	 Catch:{ Exception -> 0x0063 }
        r1 = r1.iterator();	 Catch:{ Exception -> 0x0063 }
    L_0x0042:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x0063 }
        if (r2 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x0063 }
    L_0x0048:
        r2 = r1.next();	 Catch:{ Exception -> 0x0063 }
        r2 = (java.util.Map.Entry) r2;	 Catch:{ Exception -> 0x0063 }
        r3 = r2.getKey();	 Catch:{ Exception -> 0x0063 }
        r2 = r2.getValue();	 Catch:{ Exception -> 0x0063 }
        r2 = (com.alibaba.baichuan.android.trade.c.a.a.b.d) r2;	 Catch:{ Exception -> 0x0063 }
        r2 = r2.a();	 Catch:{ Exception -> 0x0063 }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x0063 }
        goto L_0x0042;	 Catch:{ Exception -> 0x0063 }
    L_0x0060:
        r4.b = r0;	 Catch:{ Exception -> 0x0063 }
        return;
    L_0x0063:
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.e.b():void");
    }

    private d c() {
        int i = 0;
        com.alibaba.baichuan.android.trade.c.a.a.a.d[] dVarArr = (com.alibaba.baichuan.android.trade.c.a.a.a.d[]) this.g.values().toArray(new com.alibaba.baichuan.android.trade.c.a.a.a.d[0]);
        j.a(dVarArr);
        d[] dVarArr2 = (d[]) this.f.values().toArray(new d[0]);
        j.a(dVarArr2);
        d dVar = new d();
        dVar.a = 0;
        dVar.c = new LinkedHashMap();
        dVar.b = new LinkedHashMap();
        for (com.alibaba.baichuan.android.trade.c.a.a.a.d dVar2 : dVarArr) {
            dVar.c.put(dVar2.a, dVar2);
        }
        int length = dVarArr2.length;
        while (i < length) {
            d dVar3 = dVarArr2[i];
            dVar.b.put(dVar3.a, dVar3);
            i++;
        }
        return dVar;
    }

    public final String a(com.alibaba.baichuan.android.trade.c.a.a.c.a aVar) {
        if (aVar.d == null) {
            return null;
        }
        c cVar = new c(aVar.e, aVar.d, aVar.i);
        cVar.h = aVar.f;
        if (aVar.j != null) {
            for (String str : aVar.j) {
                StringBuilder stringBuilder = new StringBuilder("skip_");
                stringBuilder.append(str);
                cVar.c(stringBuilder.toString(), "true");
            }
        }
        a(cVar);
        return cVar.e;
    }

    public final b b(com.alibaba.baichuan.android.trade.c.a.a.c.a aVar) {
        int i = 0;
        if (aVar.d == null) {
            return new b(false, aVar.d);
        }
        boolean z;
        int length;
        com.alibaba.baichuan.android.trade.c.a.a.b.a aVar2;
        StringBuilder stringBuilder;
        if (!(this.e || this.e)) {
            synchronized (this) {
                if (!this.e) {
                    com.alibaba.baichuan.android.trade.c.a.a.a.e eVar = new com.alibaba.baichuan.android.trade.c.a.a.a.e();
                    eVar.a.a = "addAllParamsFilter";
                    String[] strArr = f.a;
                    String[] strArr2 = b.e;
                    f fVar = new f();
                    fVar.c = "addAllParamsUrlsStartMatches";
                    fVar.d = "pattern";
                    fVar.e = strArr;
                    fVar.f = strArr2;
                    eVar.a.m.put(fVar.c, fVar);
                    eVar.a.g = new int[]{2, 1};
                    Map hashMap = new HashMap();
                    hashMap.put("key", "addAllParams");
                    hashMap.put(RequestHeaders.COLUMN_VALUE, "${ddAllParams}");
                    hashMap.put(Constants.KEY_MODE, "addIfAbsent");
                    com.alibaba.baichuan.android.trade.c.a.a.a.d.a aVar3 = new com.alibaba.baichuan.android.trade.c.a.a.a.d.a();
                    aVar3.a = "addAllParams";
                    aVar3.b = "updateParameter";
                    aVar3.c = hashMap;
                    eVar.a.j.put(aVar3.a, aVar3);
                    e eVar2 = a;
                    com.alibaba.baichuan.android.trade.c.a.a.a.d dVar = eVar.a;
                    eVar2.g.put(dVar.a, dVar);
                    a.a(com.alibaba.baichuan.android.trade.c.a.a.b.e.a("loginHandler").a("login", "pattern", f.a, b.a).a(new com.alibaba.baichuan.android.trade.c.a.b.d()).a(new int[]{2}).a);
                    a.a(com.alibaba.baichuan.android.trade.c.a.a.b.e.a("logoutHandler").a("logout", "pattern", f.a, b.b).a(new com.alibaba.baichuan.android.trade.c.a.b.f()).a(new int[]{2}).a);
                    a.a(com.alibaba.baichuan.android.trade.c.a.a.b.e.a("alipayHandlerInfo").a("alipay", "pattern", f.a, b.c).a(new com.alibaba.baichuan.android.trade.c.a.b.c()).a(new int[]{2}).a);
                    a.a(com.alibaba.baichuan.android.trade.c.a.a.b.e.a("tbopenHandlerInfo").a("tbopen", "pattern", f.b, b.d).a(new k()).a(new int[]{2}).a);
                    com.alibaba.baichuan.android.trade.c.a.a.b.e a = com.alibaba.baichuan.android.trade.c.a.a.b.e.a("addCartHandler");
                    a.a("addCartUrlMatches", "pattern", f.a, b.f);
                    a.a(new com.alibaba.baichuan.android.trade.c.a.b.a());
                    a.a.l = true;
                    a.a(a.a);
                    a = com.alibaba.baichuan.android.trade.c.a.a.b.e.a("nativeTaobaoShopHandlerInfoBuilder");
                    a.a("showShopNativeMatches", "pattern", f.a, b.g);
                    a.a(new String[]{"noForceH5"});
                    a.a(new i());
                    a.a(new int[]{2});
                    a.a(a.a);
                    a = com.alibaba.baichuan.android.trade.c.a.a.b.e.a("nativeTaobaoDetailHandlerInfoBuilder");
                    a.a(new String[]{"noForceH5"});
                    a.a("showDetailNativeMatches", "pattern", f.a, b.h);
                    a.a(new h());
                    a.a(new int[]{2});
                    a.a(a.a);
                    AlibcContext.b();
                    this.d = c();
                    b();
                    this.e = true;
                }
            }
        }
        c cVar = new c(aVar.e, aVar.d, aVar.i);
        cVar.h = aVar.f;
        a(cVar);
        com.alibaba.baichuan.android.trade.c.a.a.b.c cVar2 = new com.alibaba.baichuan.android.trade.c.a.a.b.c(aVar.e, cVar.e, aVar.i);
        cVar2.h = aVar.f;
        if (aVar.e != 1) {
            if (aVar.e != 2) {
                if (aVar.e == 3) {
                    cVar2.d = aVar.g;
                    cVar2.j.putAll(cVar.j);
                    if (aVar.h != null) {
                        z = Looper.getMainLooper() == Looper.myLooper();
                        aVar = aVar.h;
                        length = aVar.length;
                        while (i < length) {
                            aVar2 = (com.alibaba.baichuan.android.trade.c.a.a.b.a) this.b.get(aVar[i]);
                            if (aVar2 != null) {
                                if (!a(cVar2.h, aVar2.a.h) && a(cVar2.g, aVar2.a.g) && a(aVar2, cVar2, z)) {
                                    return new b(true, cVar2.e);
                                }
                                stringBuilder = new StringBuilder("skip_");
                                stringBuilder.append(aVar2.a.a);
                                cVar2.c(stringBuilder.toString(), "true");
                            }
                            i++;
                        }
                    }
                    return new b(a(cVar2), cVar2.e);
                }
                if (aVar.e == 4) {
                    cVar2.c = aVar.c;
                }
                cVar2.j.putAll(cVar.j);
                if (aVar.h != null) {
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                    }
                    aVar = aVar.h;
                    length = aVar.length;
                    while (i < length) {
                        aVar2 = (com.alibaba.baichuan.android.trade.c.a.a.b.a) this.b.get(aVar[i]);
                        if (aVar2 != null) {
                            if (!a(cVar2.h, aVar2.a.h)) {
                            }
                            stringBuilder = new StringBuilder("skip_");
                            stringBuilder.append(aVar2.a.a);
                            cVar2.c(stringBuilder.toString(), "true");
                        }
                        i++;
                    }
                }
                return new b(a(cVar2), cVar2.e);
            }
        }
        cVar2.a = aVar.a;
        cVar2.b = aVar.b;
        cVar2.d = aVar.g;
        cVar2.j.putAll(cVar.j);
        if (aVar.h != null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
            }
            aVar = aVar.h;
            length = aVar.length;
            while (i < length) {
                aVar2 = (com.alibaba.baichuan.android.trade.c.a.a.b.a) this.b.get(aVar[i]);
                if (aVar2 != null) {
                    if (!a(cVar2.h, aVar2.a.h)) {
                    }
                    stringBuilder = new StringBuilder("skip_");
                    stringBuilder.append(aVar2.a.a);
                    cVar2.c(stringBuilder.toString(), "true");
                }
                i++;
            }
        }
        return new b(a(cVar2), cVar2.e);
    }

    private boolean a(com.alibaba.baichuan.android.trade.c.a.a.b.a r11, com.alibaba.baichuan.android.trade.c.a.a.b.c r12, boolean r13) {
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
        r10 = this;
        r0 = r11.a;
        r0 = r0.l;
        r1 = 0;
        if (r0 == 0) goto L_0x0037;
    L_0x0007:
        if (r13 != 0) goto L_0x0037;
    L_0x0009:
        r13 = new java.util.concurrent.CountDownLatch;
        r0 = 1;
        r13.<init>(r0);
        r0 = new com.alibaba.baichuan.android.trade.c.a.a.e$a;
        r0.<init>();
        r8 = com.alibaba.baichuan.android.trade.AlibcContext.b;
        r9 = new com.alibaba.baichuan.android.trade.c.a.a.f;
        r2 = r9;
        r3 = r10;
        r4 = r0;
        r5 = r11;
        r6 = r12;
        r7 = r13;
        r2.<init>(r3, r4, r5, r6, r7);
        r8.b(r9);
        r11 = 3;
        r2 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x002b }
        r13.await(r11, r2);	 Catch:{ Exception -> 0x002b }
    L_0x002b:
        r11 = r0.a;
        if (r11 != 0) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r11 = r0.a;
        r11 = r11.booleanValue();
        return r11;
    L_0x0037:
        r12 = r11.a(r12);	 Catch:{ Throwable -> 0x003c }
        return r12;
    L_0x003c:
        r12 = new java.lang.StringBuilder;
        r13 = "fail to execute the Handler ";
        r12.<init>(r13);
        if (r11 == 0) goto L_0x004e;
    L_0x0045:
        r13 = r11.a;
        if (r13 == 0) goto L_0x004e;
    L_0x0049:
        r11 = r11.a;
        r11 = r11.a;
        goto L_0x004f;
    L_0x004e:
        r11 = 0;
    L_0x004f:
        r12.append(r11);
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.e.a(com.alibaba.baichuan.android.trade.c.a.a.b.a, com.alibaba.baichuan.android.trade.c.a.a.b.c, boolean):boolean");
    }

    private void a(com.alibaba.baichuan.android.trade.c.a.a.a.c r6) {
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
        r5 = this;
        r0 = r5.c;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x000a:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x007c;
    L_0x0010:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r1 = r1.getValue();
        r1 = (com.alibaba.baichuan.android.trade.c.a.a.a.a) r1;
        r2 = r6.g;
        r3 = r1.a;
        r3 = r3.g;
        r2 = a(r2, r3);
        if (r2 == 0) goto L_0x000a;
    L_0x0028:
        r2 = "true";
        r3 = new java.lang.StringBuilder;
        r4 = "skip_";
        r3.<init>(r4);
        r4 = r1.a;
        r4 = r4.a;
        r3.append(r4);
        r3 = r3.toString();
        r3 = r6.c(r3);
        r2 = r2.equals(r3);
        if (r2 != 0) goto L_0x000a;
    L_0x0046:
        r2 = r6.h;
        r3 = r1.a;
        r3 = r3.h;
        r2 = a(r2, r3);
        if (r2 == 0) goto L_0x000a;
    L_0x0052:
        r2 = r1.a(r6);	 Catch:{ Exception -> 0x0062 }
        if (r2 == 0) goto L_0x000a;	 Catch:{ Exception -> 0x0062 }
    L_0x0058:
        r6.a();	 Catch:{ Exception -> 0x0062 }
        r2 = r1.a;	 Catch:{ Exception -> 0x0062 }
        r2 = r2.i;	 Catch:{ Exception -> 0x0062 }
        if (r2 != 0) goto L_0x000a;
    L_0x0061:
        return;
    L_0x0062:
        r2 = new java.lang.StringBuilder;
        r3 = "Fail to execute the Filter ";
        r2.<init>(r3);
        if (r1 == 0) goto L_0x0074;
    L_0x006b:
        r3 = r1.a;
        if (r3 == 0) goto L_0x0074;
    L_0x006f:
        r1 = r1.a;
        r1 = r1.a;
        goto L_0x0075;
    L_0x0074:
        r1 = 0;
    L_0x0075:
        r2.append(r1);
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        goto L_0x000a;
    L_0x007c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.e.a(com.alibaba.baichuan.android.trade.c.a.a.a.c):void");
    }

    private boolean a(com.alibaba.baichuan.android.trade.c.a.a.b.c cVar) {
        boolean z = Looper.myLooper() == Looper.getMainLooper();
        for (Entry value : this.b.entrySet()) {
            com.alibaba.baichuan.android.trade.c.a.a.b.a aVar = (com.alibaba.baichuan.android.trade.c.a.a.b.a) value.getValue();
            if (a(cVar.g, aVar.a.g)) {
                StringBuilder stringBuilder = new StringBuilder("skip_");
                stringBuilder.append(aVar.a.a);
                if (!"true".equals(cVar.c(stringBuilder.toString())) && a(cVar.h, aVar.a.h) && a(aVar, cVar, z)) {
                    return true;
                }
            }
        }
        return false;
    }
}
