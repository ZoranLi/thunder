package mtopsdk.common.util;

import android.content.ServiceConnection;
import android.os.IInterface;

public abstract class a {
    protected volatile IInterface a = null;
    Class b;
    Object c = new Object();
    private Class d;
    private ServiceConnection e = new b(this);

    public a(Class cls, Class cls2) {
        this.b = cls;
        this.d = cls2;
    }

    public abstract void a();

    public final IInterface b() {
        return this.a;
    }

    final java.lang.String c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.b;	 Catch:{ Throwable -> 0x0007 }
        r0 = r0.getSimpleName();	 Catch:{ Throwable -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = new java.lang.StringBuilder;
        r1 = "[getInterfaceName]getInterfaceName error.interfaceName =";
        r0.<init>(r1);
        r1 = r2.b;
        r0.append(r1);
        r0 = r0.toString();
        mtopsdk.common.util.j.f(r0);
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.a.c():java.lang.String");
    }

    public final void a(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.a;
        if (r0 != 0) goto L_0x011d;
    L_0x0004:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x0021;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r1 = "[asyncBind]try to bind service for ";
        r0.<init>(r1);
        r1 = r6.c();
        r0.append(r1);
        r0 = r0.toString();
        mtopsdk.common.util.j.a(r0);
    L_0x0021:
        r0 = 3;
        r1 = 1;
        r2 = new java.lang.Class[r0];	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = android.content.Context.class;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r4 = 0;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r2[r4] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = java.lang.Class.class;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r2[r1] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = android.content.ServiceConnection.class;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r5 = 2;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r2[r5] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r0 = new java.lang.Object[r0];	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = r7.getApplicationContext();	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r0[r4] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = r6.b;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r0[r1] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = r6.e;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r0[r5] = r3;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = "com.taobao.android.service.Services";	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r4 = "bind";	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r3 = java.lang.Class.forName(r3);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r2 = r3.getDeclaredMethod(r4, r2);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        if (r2 == 0) goto L_0x0057;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
    L_0x0051:
        r2.setAccessible(r1);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r2.invoke(r3, r0);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
    L_0x0057:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        r0 = mtopsdk.common.util.j.a(r0);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        if (r0 == 0) goto L_0x0064;	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
    L_0x005f:
        r0 = "[asyncBind]bind service by service framework";	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
        mtopsdk.common.util.j.a(r0);	 Catch:{ ClassNotFoundException -> 0x00d1, NoSuchMethodException -> 0x0084, Throwable -> 0x0065 }
    L_0x0064:
        return;
    L_0x0065:
        r7 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;
        r7 = mtopsdk.common.util.j.a(r7);
        if (r7 == 0) goto L_0x011d;
    L_0x006d:
        r7 = new java.lang.StringBuilder;
        r0 = "[asyncBind]Service bind failed. interfaceName =";
        r7.<init>(r0);
        r0 = r6.c();
        r7.append(r0);
        r7 = r7.toString();
        mtopsdk.common.util.j.c(r7);
        goto L_0x011d;
    L_0x0084:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x0091;
    L_0x008c:
        r0 = "[asyncBind]service framework not exist. use intent to bind service.";
        mtopsdk.common.util.j.a(r0);
    L_0x0091:
        r0 = new android.content.Intent;
        r2 = r7.getApplicationContext();
        r3 = r6.d;
        r0.<init>(r2, r3);
        r2 = r6.b;
        r2 = r2.getName();
        r0.setAction(r2);
        r2 = r7.getPackageName();
        r0.setPackage(r2);
        r2 = "android.intent.category.DEFAULT";
        r0.addCategory(r2);
        r2 = r6.e;
        r7 = r7.bindService(r0, r2, r1);
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x00d0;
    L_0x00bf:
        r0 = new java.lang.StringBuilder;
        r1 = "[asyncBind]bindService ret=";
        r0.<init>(r1);
        r0.append(r7);
        r7 = r0.toString();
        mtopsdk.common.util.j.a(r7);
    L_0x00d0:
        return;
    L_0x00d1:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.WarnEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x00de;
    L_0x00d9:
        r0 = "[asyncBind]service framework not exist. use intent to bind service.";
        mtopsdk.common.util.j.c(r0);
    L_0x00de:
        r0 = new android.content.Intent;
        r2 = r7.getApplicationContext();
        r3 = r6.d;
        r0.<init>(r2, r3);
        r2 = r6.b;
        r2 = r2.getName();
        r0.setAction(r2);
        r2 = r7.getPackageName();
        r0.setPackage(r2);
        r2 = "android.intent.category.DEFAULT";
        r0.addCategory(r2);
        r2 = r6.e;
        r7 = r7.bindService(r0, r2, r1);
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.DebugEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x011d;
    L_0x010c:
        r0 = new java.lang.StringBuilder;
        r1 = "[asyncBind]bindService ret=";
        r0.<init>(r1);
        r0.append(r7);
        r7 = r0.toString();
        mtopsdk.common.util.j.a(r7);
    L_0x011d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.common.util.a.a(android.content.Context):void");
    }
}
