package com.alibaba.baichuan.android.trade.adapter.d;

import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;

public class a {
    private static a b = null;
    private static final String d = "a";
    public String a;
    private SecurityGuardManager c;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public static java.lang.Long a(java.lang.String r8, byte[] r9) {
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
        r0 = 0;
        r1 = com.alibaba.baichuan.android.trade.AlibcContext.a;	 Catch:{ SecException -> 0x001f }
        r1 = com.alibaba.wireless.security.open.SecurityGuardManager.getInstance(r1);	 Catch:{ SecException -> 0x001f }
        r2 = r1.getOpenSDKComp();	 Catch:{ SecException -> 0x001f }
        if (r2 == 0) goto L_0x001d;
    L_0x000d:
        r4 = "AppIDKey";	 Catch:{ SecException -> 0x0019 }
        r5 = "OpenIDSaltKey";	 Catch:{ SecException -> 0x0019 }
        r7 = 0;	 Catch:{ SecException -> 0x0019 }
        r3 = r8;	 Catch:{ SecException -> 0x0019 }
        r6 = r9;	 Catch:{ SecException -> 0x0019 }
        r8 = r2.analyzeOpenId(r3, r4, r5, r6, r7);	 Catch:{ SecException -> 0x0019 }
        return r8;
    L_0x0019:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x001d:
        r8 = r0;
        return r8;
    L_0x001f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.adapter.d.a.a(java.lang.String, byte[]):java.lang.Long");
    }

    public final String a(String str) {
        if (this.c != null) {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = this.c.getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                try {
                    return dynamicDataEncryptComp.dynamicEncrypt(str);
                } catch (SecException e) {
                    e.toString();
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                }
            }
        }
        return str;
    }

    public final String b(String str) {
        if (this.c != null) {
            IDynamicDataEncryptComponent dynamicDataEncryptComp = this.c.getDynamicDataEncryptComp();
            if (dynamicDataEncryptComp != null) {
                try {
                    return dynamicDataEncryptComp.dynamicDecrypt(str);
                } catch (SecException e) {
                    e.toString();
                    com.alibaba.baichuan.android.trade.utils.g.a.b();
                }
            }
        }
        return str;
    }
}
