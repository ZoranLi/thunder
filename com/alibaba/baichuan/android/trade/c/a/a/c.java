package com.alibaba.baichuan.android.trade.c.a.a;

import android.net.Uri;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class c {
    private String a;
    private Map b;
    public String e;
    protected Uri f;
    public int g;
    String h;
    public Map i;
    protected Map j = new LinkedHashMap();
    protected String k;

    public c(int i, String str, Map map) {
        this.e = str;
        this.g = i;
        if (map == null) {
            map = new HashMap();
        }
        this.b = map;
        Map map2 = (Map) this.b.get("ui_contextParams");
        this.i = map2 == null ? new HashMap() : new HashMap(map2);
        a();
    }

    public final String b() {
        if (this.a != null) {
            return this.a;
        }
        if (this.f == null) {
            this.f = Uri.parse(this.e);
        }
        String schemeSpecificPart = this.f.getSchemeSpecificPart();
        if (schemeSpecificPart == null || schemeSpecificPart.length() <= 2) {
            schemeSpecificPart = "";
        } else {
            this.a = schemeSpecificPart.substring(2);
            if (this.f.getFragment() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append("#");
                stringBuilder.append(this.f.getFragment());
                schemeSpecificPart = stringBuilder.toString();
            }
            return this.a;
        }
        this.a = schemeSpecificPart;
        return this.a;
    }

    public final String b(String str) {
        List list = (List) this.j.get(str);
        if (list != null) {
            if (list.size() != 0) {
                return (String) list.get(0);
            }
        }
        return null;
    }

    public final String c() {
        if (this.f == null) {
            this.f = Uri.parse(this.e);
        }
        return this.f.getScheme().trim();
    }

    public final String c(String str) {
        return (String) this.i.get(str);
    }

    public final void c(String str, String str2) {
        this.i.put(str, str2);
    }

    public final void d(String str) {
        this.e = str;
        this.f = null;
        this.k = null;
        this.a = null;
        a();
    }

    private void a() {
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
        r0 = r9.e;	 Catch:{ Exception -> 0x009c }
        r1 = "#";	 Catch:{ Exception -> 0x009c }
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x009c }
        r2 = -1;	 Catch:{ Exception -> 0x009c }
        if (r1 != r2) goto L_0x000f;	 Catch:{ Exception -> 0x009c }
    L_0x000b:
        r3 = 0;	 Catch:{ Exception -> 0x009c }
        r9.k = r3;	 Catch:{ Exception -> 0x009c }
        goto L_0x001f;	 Catch:{ Exception -> 0x009c }
    L_0x000f:
        r3 = r0.length();	 Catch:{ Exception -> 0x009c }
        r3 = r3 + -1;	 Catch:{ Exception -> 0x009c }
        if (r1 == r3) goto L_0x001f;	 Catch:{ Exception -> 0x009c }
    L_0x0017:
        r3 = r1 + 1;	 Catch:{ Exception -> 0x009c }
        r3 = r0.substring(r3);	 Catch:{ Exception -> 0x009c }
        r9.k = r3;	 Catch:{ Exception -> 0x009c }
    L_0x001f:
        r3 = "?";	 Catch:{ Exception -> 0x009c }
        r3 = r0.indexOf(r3);	 Catch:{ Exception -> 0x009c }
        r4 = r9.j;	 Catch:{ Exception -> 0x009c }
        r4.clear();	 Catch:{ Exception -> 0x009c }
        if (r3 == r2) goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x002c:
        r4 = r0.length();	 Catch:{ Exception -> 0x009c }
        r4 = r4 + -1;	 Catch:{ Exception -> 0x009c }
        if (r3 == r4) goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x0034:
        if (r1 == r2) goto L_0x0038;	 Catch:{ Exception -> 0x009c }
    L_0x0036:
        if (r3 >= r1) goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x0038:
        if (r1 != r2) goto L_0x0041;	 Catch:{ Exception -> 0x009c }
    L_0x003a:
        r3 = r3 + 1;	 Catch:{ Exception -> 0x009c }
        r0 = r0.substring(r3);	 Catch:{ Exception -> 0x009c }
        goto L_0x0047;	 Catch:{ Exception -> 0x009c }
    L_0x0041:
        r3 = r3 + 1;	 Catch:{ Exception -> 0x009c }
        r0 = r0.substring(r3, r1);	 Catch:{ Exception -> 0x009c }
    L_0x0047:
        r1 = "[\\&]";	 Catch:{ Exception -> 0x009c }
        r0 = r0.split(r1);	 Catch:{ Exception -> 0x009c }
        r1 = r0.length;	 Catch:{ Exception -> 0x009c }
        r3 = 0;	 Catch:{ Exception -> 0x009c }
        r4 = r3;	 Catch:{ Exception -> 0x009c }
    L_0x0050:
        if (r4 >= r1) goto L_0x009b;	 Catch:{ Exception -> 0x009c }
    L_0x0052:
        r5 = r0[r4];	 Catch:{ Exception -> 0x009c }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x009c }
        if (r6 != 0) goto L_0x0098;	 Catch:{ Exception -> 0x009c }
    L_0x005a:
        r6 = 61;	 Catch:{ Exception -> 0x009c }
        r6 = r5.indexOf(r6);	 Catch:{ Exception -> 0x009c }
        if (r6 == r2) goto L_0x0098;	 Catch:{ Exception -> 0x009c }
    L_0x0062:
        r7 = r5.length();	 Catch:{ Exception -> 0x009c }
        r7 = r7 + -1;	 Catch:{ Exception -> 0x009c }
        if (r6 == r7) goto L_0x0098;	 Catch:{ Exception -> 0x009c }
    L_0x006a:
        r7 = r5.substring(r3, r6);	 Catch:{ Exception -> 0x009c }
        r7 = android.net.Uri.decode(r7);	 Catch:{ Exception -> 0x009c }
        r6 = r6 + 1;	 Catch:{ Exception -> 0x009c }
        r5 = r5.substring(r6);	 Catch:{ Exception -> 0x009c }
        r5 = android.net.Uri.decode(r5);	 Catch:{ Exception -> 0x009c }
        r6 = r9.j;	 Catch:{ Exception -> 0x009c }
        r6 = r6.get(r7);	 Catch:{ Exception -> 0x009c }
        r6 = (java.util.List) r6;	 Catch:{ Exception -> 0x009c }
        if (r6 != 0) goto L_0x0095;	 Catch:{ Exception -> 0x009c }
    L_0x0086:
        r6 = new java.util.ArrayList;	 Catch:{ Exception -> 0x009c }
        r8 = 2;	 Catch:{ Exception -> 0x009c }
        r6.<init>(r8);	 Catch:{ Exception -> 0x009c }
        r6.add(r5);	 Catch:{ Exception -> 0x009c }
        r5 = r9.j;	 Catch:{ Exception -> 0x009c }
        r5.put(r7, r6);	 Catch:{ Exception -> 0x009c }
        goto L_0x0098;	 Catch:{ Exception -> 0x009c }
    L_0x0095:
        r6.add(r5);	 Catch:{ Exception -> 0x009c }
    L_0x0098:
        r4 = r4 + 1;
        goto L_0x0050;
    L_0x009b:
        return;
    L_0x009c:
        r0 = new java.lang.StringBuilder;
        r1 = "fail to parse the uri ";
        r0.<init>(r1);
        r1 = r9.e;
        r0.append(r1);
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.c.a():void");
    }
}
