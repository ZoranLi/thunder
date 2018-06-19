package com.huawei.hms.update.f.a;

import java.lang.reflect.InvocationTargetException;

/* compiled from: MultiCard */
public abstract class a {
    public String a(int i) {
        return "";
    }

    public abstract int b();

    abstract Object c() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public abstract boolean d();

    public static a a() {
        a bVar = new b();
        if (bVar.d()) {
            com.huawei.hms.support.log.a.b("MultiCard", "Return HW instance.");
            return bVar;
        }
        bVar = new c();
        if (!bVar.d()) {
            return null;
        }
        com.huawei.hms.support.log.a.b("MultiCard", "Return MTK instance.");
        return bVar;
    }

    public int b(int r8) {
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
        r7 = this;
        r0 = 0;
        r1 = r7.c();	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r2 = r1.getClass();	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r3 = "getSimState";	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r4 = 1;	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r5 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r5[r0] = r6;	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r2 = r2.getDeclaredMethod(r3, r5);	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r3 = new java.lang.Object[r4];	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r3[r0] = r8;	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r8 = r2.invoke(r1, r3);	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r8 = (java.lang.Integer) r8;	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        r8 = r8.intValue();	 Catch:{ ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029, ClassNotFoundException -> 0x0029 }
        return r8;
    L_0x0029:
        r8 = "MultiCard";
        r1 = "Failed to call [TelephonyManager].getSimState()";
        com.huawei.hms.support.log.a.c(r8, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.f.a.a.b(int):int");
    }

    public java.lang.String c(int r8) {
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
        r7 = this;
        r0 = r7.c();	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r1 = r0.getClass();	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r2 = "getSubscriberId";	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r3 = 1;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r4 = new java.lang.Class[r3];	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r5 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r6 = 0;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r4[r6] = r5;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r2 = new java.lang.Object[r3];	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r2[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r8 = r1.invoke(r0, r2);	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        r8 = (java.lang.String) r8;	 Catch:{ ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025, ClassNotFoundException -> 0x0025 }
        return r8;
    L_0x0025:
        r8 = "MultiCard";
        r0 = "Failed to call [TelephonyManager].getSubscriberId()";
        com.huawei.hms.support.log.a.c(r8, r0);
        r8 = "";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.f.a.a.c(int):java.lang.String");
    }
}
