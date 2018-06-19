package com.igexin.assist.sdk;

import android.content.Context;

public class a {
    static com.igexin.assist.control.AbstractPushManager a(android.content.Context r5) {
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
        r0 = b(r5);	 Catch:{  }
        r1 = 0;	 Catch:{  }
        r2 = 1;	 Catch:{  }
        if (r0 == 0) goto L_0x002e;	 Catch:{  }
    L_0x0008:
        r0 = com.igexin.push.config.m.M;	 Catch:{  }
        if (r0 == 0) goto L_0x002e;	 Catch:{  }
    L_0x000c:
        r0 = "Assist_PushMangerFactory|MiuiPushManager checkDevice flag = true";	 Catch:{  }
        com.igexin.b.a.c.a.b(r0);	 Catch:{  }
        r0 = "com.igexin.assist.control.xiaomi.MiuiPushManager";	 Catch:{ Throwable -> 0x0094 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0094 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0094 }
        r4 = android.content.Context.class;	 Catch:{ Throwable -> 0x0094 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0094 }
        r0 = r0.getConstructor(r3);	 Catch:{ Throwable -> 0x0094 }
        if (r0 == 0) goto L_0x0094;	 Catch:{ Throwable -> 0x0094 }
    L_0x0023:
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0094 }
        r2[r1] = r5;	 Catch:{ Throwable -> 0x0094 }
        r5 = r0.newInstance(r2);	 Catch:{ Throwable -> 0x0094 }
        r5 = (com.igexin.assist.control.AbstractPushManager) r5;	 Catch:{ Throwable -> 0x0094 }
        return r5;
    L_0x002e:
        r0 = c(r5);	 Catch:{  }
        if (r0 == 0) goto L_0x005a;	 Catch:{  }
    L_0x0034:
        r0 = com.igexin.push.config.m.N;	 Catch:{  }
        if (r0 == 0) goto L_0x005a;	 Catch:{  }
    L_0x0038:
        r0 = "Assist_PushMangerFactory|FlymePushManager checkDevice flag = true";	 Catch:{  }
        com.igexin.b.a.c.a.b(r0);	 Catch:{  }
        r0 = "com.igexin.assist.control.meizu.FlymePushManager";	 Catch:{ Throwable -> 0x0094 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0094 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0094 }
        r4 = android.content.Context.class;	 Catch:{ Throwable -> 0x0094 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0094 }
        r0 = r0.getConstructor(r3);	 Catch:{ Throwable -> 0x0094 }
        if (r0 == 0) goto L_0x0094;	 Catch:{ Throwable -> 0x0094 }
    L_0x004f:
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0094 }
        r2[r1] = r5;	 Catch:{ Throwable -> 0x0094 }
        r5 = r0.newInstance(r2);	 Catch:{ Throwable -> 0x0094 }
        r5 = (com.igexin.assist.control.AbstractPushManager) r5;	 Catch:{ Throwable -> 0x0094 }
        return r5;
    L_0x005a:
        r0 = d(r5);	 Catch:{  }
        if (r0 == 0) goto L_0x0086;	 Catch:{  }
    L_0x0060:
        r0 = com.igexin.push.config.m.O;	 Catch:{  }
        if (r0 == 0) goto L_0x0086;	 Catch:{  }
    L_0x0064:
        r0 = "Assist_PushMangerFactory|HmsPushManager checkDevice flag = true";	 Catch:{  }
        com.igexin.b.a.c.a.b(r0);	 Catch:{  }
        r0 = "com.igexin.assist.control.huawei.HmsPushManager";	 Catch:{ Throwable -> 0x0094 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x0094 }
        r3 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x0094 }
        r4 = android.content.Context.class;	 Catch:{ Throwable -> 0x0094 }
        r3[r1] = r4;	 Catch:{ Throwable -> 0x0094 }
        r0 = r0.getConstructor(r3);	 Catch:{ Throwable -> 0x0094 }
        if (r0 == 0) goto L_0x0094;	 Catch:{ Throwable -> 0x0094 }
    L_0x007b:
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0094 }
        r2[r1] = r5;	 Catch:{ Throwable -> 0x0094 }
        r5 = r0.newInstance(r2);	 Catch:{ Throwable -> 0x0094 }
        r5 = (com.igexin.assist.control.AbstractPushManager) r5;	 Catch:{ Throwable -> 0x0094 }
        return r5;
    L_0x0086:
        r5 = "Assist_PushMangerFactory|getPushManager = null, setToken = false";	 Catch:{  }
        com.igexin.b.a.c.a.b(r5);	 Catch:{  }
        r5 = com.igexin.push.core.b.g.a();	 Catch:{  }
        r0 = "false";	 Catch:{  }
        r5.c(r0);	 Catch:{  }
    L_0x0094:
        r5 = "Assist_PushMangerFactory|OtherPushManager = null";
        com.igexin.b.a.c.a.b(r5);
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.sdk.a.a(android.content.Context):com.igexin.assist.control.AbstractPushManager");
    }

    public static boolean b(android.content.Context r6) {
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
        r1 = "com.igexin.assist.control.xiaomi.MiuiPushManager";	 Catch:{ Throwable -> 0x0024 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0024 }
        r2 = "checkXMDevice";	 Catch:{ Throwable -> 0x0024 }
        r3 = 1;	 Catch:{ Throwable -> 0x0024 }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0024 }
        r5 = android.content.Context.class;	 Catch:{ Throwable -> 0x0024 }
        r4[r0] = r5;	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0024 }
        r3[r0] = r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r1.invoke(r2, r3);	 Catch:{ Throwable -> 0x0024 }
        r6 = (java.lang.Boolean) r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r6.booleanValue();	 Catch:{ Throwable -> 0x0024 }
        return r6;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.sdk.a.b(android.content.Context):boolean");
    }

    public static boolean c(android.content.Context r6) {
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
        r1 = "com.igexin.assist.control.meizu.FlymePushManager";	 Catch:{ Throwable -> 0x0024 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0024 }
        r2 = "checkMZDevice";	 Catch:{ Throwable -> 0x0024 }
        r3 = 1;	 Catch:{ Throwable -> 0x0024 }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0024 }
        r5 = android.content.Context.class;	 Catch:{ Throwable -> 0x0024 }
        r4[r0] = r5;	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0024 }
        r3[r0] = r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r1.invoke(r2, r3);	 Catch:{ Throwable -> 0x0024 }
        r6 = (java.lang.Boolean) r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r6.booleanValue();	 Catch:{ Throwable -> 0x0024 }
        return r6;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.sdk.a.c(android.content.Context):boolean");
    }

    public static boolean d(android.content.Context r6) {
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
        r1 = "com.igexin.assist.control.huawei.HmsPushManager";	 Catch:{ Throwable -> 0x0024 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Throwable -> 0x0024 }
        r2 = "checkHWDevice";	 Catch:{ Throwable -> 0x0024 }
        r3 = 1;	 Catch:{ Throwable -> 0x0024 }
        r4 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x0024 }
        r5 = android.content.Context.class;	 Catch:{ Throwable -> 0x0024 }
        r4[r0] = r5;	 Catch:{ Throwable -> 0x0024 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Throwable -> 0x0024 }
        r2 = 0;	 Catch:{ Throwable -> 0x0024 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0024 }
        r3[r0] = r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r1.invoke(r2, r3);	 Catch:{ Throwable -> 0x0024 }
        r6 = (java.lang.Boolean) r6;	 Catch:{ Throwable -> 0x0024 }
        r6 = r6.booleanValue();	 Catch:{ Throwable -> 0x0024 }
        return r6;
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.sdk.a.d(android.content.Context):boolean");
    }

    public static boolean e(Context context) {
        if (!(c(context) || b(context))) {
            if (!d(context)) {
                return false;
            }
        }
        return true;
    }
}
