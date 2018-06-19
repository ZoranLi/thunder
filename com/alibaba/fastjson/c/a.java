package com.alibaba.fastjson.c;

import java.security.AccessController;
import java.security.ProtectionDomain;

/* compiled from: ASMClassLoader */
public class a extends ClassLoader {
    private static ProtectionDomain a = ((ProtectionDomain) AccessController.doPrivileged(new b()));

    public a() {
        super(a());
    }

    private static java.lang.ClassLoader a() {
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
        r0 = java.lang.Thread.currentThread();
        r0 = r0.getContextClassLoader();
        if (r0 == 0) goto L_0x0014;
    L_0x000a:
        r1 = com.alibaba.fastjson.a.class;	 Catch:{ ClassNotFoundException -> 0x0014 }
        r1 = r1.getName();	 Catch:{ ClassNotFoundException -> 0x0014 }
        r0.loadClass(r1);	 Catch:{ ClassNotFoundException -> 0x0014 }
        return r0;
    L_0x0014:
        r0 = com.alibaba.fastjson.a.class;
        r0 = r0.getClassLoader();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.c.a.a():java.lang.ClassLoader");
    }

    public final Class<?> a(String str, byte[] bArr, int i) throws ClassFormatError {
        return defineClass(str, bArr, 0, i, a);
    }

    public final boolean a(Class<?> cls) {
        Object classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (ClassLoader classLoader2 = this; classLoader2 != null; classLoader2 = classLoader2.getParent()) {
            if (classLoader2 == classLoader) {
                return false;
            }
        }
        return true;
    }
}
