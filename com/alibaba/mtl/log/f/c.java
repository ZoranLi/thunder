package com.alibaba.mtl.log.f;

import com.alibaba.mtl.log.e.i;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/* compiled from: SecurityRequestAuth */
public final class c implements b {
    private String a = null;
    private String b;
    private Object c = null;
    private Object d = null;
    private Class e = null;
    private Field f = null;
    private Field g = null;
    private Field h = null;
    private Method i = null;
    private int j = 1;
    private boolean k = false;

    public final String a() {
        return this.a;
    }

    public c(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private synchronized void b() {
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
        monitor-enter(r7);
        r0 = r7.k;	 Catch:{ all -> 0x00d0 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r7);
        return;
    L_0x0007:
        r0 = 0;
        r1 = 1;
        r2 = 0;
        r3 = "com.alibaba.wireless.security.open.SecurityGuardManager";	 Catch:{ Throwable -> 0x003d }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x003d }
        r4 = "getInstance";	 Catch:{ Throwable -> 0x003e }
        r5 = new java.lang.Class[r1];	 Catch:{ Throwable -> 0x003e }
        r6 = android.content.Context.class;	 Catch:{ Throwable -> 0x003e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x003e }
        r4 = r3.getMethod(r4, r5);	 Catch:{ Throwable -> 0x003e }
        r5 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x003e }
        r6 = com.alibaba.mtl.log.a.c();	 Catch:{ Throwable -> 0x003e }
        r5[r2] = r6;	 Catch:{ Throwable -> 0x003e }
        r4 = r4.invoke(r0, r5);	 Catch:{ Throwable -> 0x003e }
        r7.c = r4;	 Catch:{ Throwable -> 0x003e }
        r4 = "getSecureSignatureComp";	 Catch:{ Throwable -> 0x003e }
        r5 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x003e }
        r4 = r3.getMethod(r4, r5);	 Catch:{ Throwable -> 0x003e }
        r5 = r7.c;	 Catch:{ Throwable -> 0x003e }
        r6 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x003e }
        r4 = r4.invoke(r5, r6);	 Catch:{ Throwable -> 0x003e }
        r7.d = r4;	 Catch:{ Throwable -> 0x003e }
        goto L_0x0045;
    L_0x003d:
        r3 = r0;
    L_0x003e:
        r4 = "SecurityRequestAuth";	 Catch:{ all -> 0x00d0 }
        r5 = "initSecurityCheck";	 Catch:{ all -> 0x00d0 }
        com.alibaba.mtl.log.e.i.a(r4, r5);	 Catch:{ all -> 0x00d0 }
    L_0x0045:
        if (r3 == 0) goto L_0x00cc;
    L_0x0047:
        r4 = "com.alibaba.wireless.security.open.SecurityGuardParamContext";	 Catch:{ Throwable -> 0x00c5 }
        r4 = java.lang.Class.forName(r4);	 Catch:{ Throwable -> 0x00c5 }
        r7.e = r4;	 Catch:{ Throwable -> 0x00c5 }
        r4 = r7.e;	 Catch:{ Throwable -> 0x00c5 }
        r5 = "appKey";	 Catch:{ Throwable -> 0x00c5 }
        r4 = r4.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00c5 }
        r7.f = r4;	 Catch:{ Throwable -> 0x00c5 }
        r4 = r7.e;	 Catch:{ Throwable -> 0x00c5 }
        r5 = "paramMap";	 Catch:{ Throwable -> 0x00c5 }
        r4 = r4.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00c5 }
        r7.g = r4;	 Catch:{ Throwable -> 0x00c5 }
        r4 = r7.e;	 Catch:{ Throwable -> 0x00c5 }
        r5 = "requestType";	 Catch:{ Throwable -> 0x00c5 }
        r4 = r4.getDeclaredField(r5);	 Catch:{ Throwable -> 0x00c5 }
        r7.h = r4;	 Catch:{ Throwable -> 0x00c5 }
        r4 = "isOpen";	 Catch:{ Throwable -> 0x0076 }
        r5 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0076 }
        r3 = r3.getMethod(r4, r5);	 Catch:{ Throwable -> 0x0076 }
        goto L_0x007e;
    L_0x0076:
        r3 = "SecurityRequestAuth";	 Catch:{ Throwable -> 0x00c5 }
        r4 = "initSecurityCheck";	 Catch:{ Throwable -> 0x00c5 }
        com.alibaba.mtl.log.e.i.a(r3, r4);	 Catch:{ Throwable -> 0x00c5 }
        r3 = r0;	 Catch:{ Throwable -> 0x00c5 }
    L_0x007e:
        if (r3 == 0) goto L_0x008f;	 Catch:{ Throwable -> 0x00c5 }
    L_0x0080:
        r0 = r7.c;	 Catch:{ Throwable -> 0x00c5 }
        r4 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00c5 }
        r0 = r3.invoke(r0, r4);	 Catch:{ Throwable -> 0x00c5 }
        r0 = (java.lang.Boolean) r0;	 Catch:{ Throwable -> 0x00c5 }
        r0 = r0.booleanValue();	 Catch:{ Throwable -> 0x00c5 }
        goto L_0x00a3;
    L_0x008f:
        r3 = "com.taobao.wireless.security.sdk.securitybody.ISecurityBodyComponent";	 Catch:{ Throwable -> 0x0097 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ Throwable -> 0x0097 }
        r0 = r3;
        goto L_0x009e;
    L_0x0097:
        r3 = "SecurityRequestAuth";	 Catch:{ Throwable -> 0x00c5 }
        r4 = "initSecurityCheck";	 Catch:{ Throwable -> 0x00c5 }
        com.alibaba.mtl.log.e.i.a(r3, r4);	 Catch:{ Throwable -> 0x00c5 }
    L_0x009e:
        if (r0 != 0) goto L_0x00a2;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a0:
        r0 = r1;	 Catch:{ Throwable -> 0x00c5 }
        goto L_0x00a3;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a2:
        r0 = r2;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a3:
        if (r0 == 0) goto L_0x00a7;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a5:
        r0 = r1;	 Catch:{ Throwable -> 0x00c5 }
        goto L_0x00a9;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a7:
        r0 = 12;	 Catch:{ Throwable -> 0x00c5 }
    L_0x00a9:
        r7.j = r0;	 Catch:{ Throwable -> 0x00c5 }
        r0 = "com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent";	 Catch:{ Throwable -> 0x00c5 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x00c5 }
        r3 = "signRequest";	 Catch:{ Throwable -> 0x00c5 }
        r4 = 2;	 Catch:{ Throwable -> 0x00c5 }
        r4 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x00c5 }
        r5 = r7.e;	 Catch:{ Throwable -> 0x00c5 }
        r4[r2] = r5;	 Catch:{ Throwable -> 0x00c5 }
        r2 = java.lang.String.class;	 Catch:{ Throwable -> 0x00c5 }
        r4[r1] = r2;	 Catch:{ Throwable -> 0x00c5 }
        r0 = r0.getMethod(r3, r4);	 Catch:{ Throwable -> 0x00c5 }
        r7.i = r0;	 Catch:{ Throwable -> 0x00c5 }
        goto L_0x00cc;
    L_0x00c5:
        r0 = "SecurityRequestAuth";	 Catch:{ all -> 0x00d0 }
        r2 = "initSecurityCheck";	 Catch:{ all -> 0x00d0 }
        com.alibaba.mtl.log.e.i.a(r0, r2);	 Catch:{ all -> 0x00d0 }
    L_0x00cc:
        r7.k = r1;	 Catch:{ all -> 0x00d0 }
        monitor-exit(r7);
        return;
    L_0x00d0:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.f.c.b():void");
    }

    public final String a(String str) {
        if (!this.k) {
            b();
        }
        if (this.a == null) {
            i.a("SecurityRequestAuth", "There is no appkey,please check it!");
            return null;
        } else if (str == null) {
            return null;
        } else {
            if (!(this.c == null || this.e == null || this.f == null || this.g == null || this.h == null || this.i == null || this.d == null)) {
                try {
                    Object newInstance = this.e.newInstance();
                    this.f.set(newInstance, this.a);
                    ((Map) this.g.get(newInstance)).put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
                    this.h.set(newInstance, Integer.valueOf(this.j));
                    str = (String) this.i.invoke(this.d, new Object[]{newInstance, this.b});
                } catch (String str2) {
                    str2.printStackTrace();
                }
                return str2;
            }
            str2 = null;
            return str2;
        }
    }
}
