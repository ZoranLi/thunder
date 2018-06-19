package com.igexin.push.core.a.a;

import com.igexin.push.f.b.h;
import java.util.Map;

class m extends h {
    final /* synthetic */ Map a;
    final /* synthetic */ l b;

    m(l lVar, long j, Map map) {
        this.b = lVar;
        this.a = map;
        super(j);
    }

    protected void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b3 }
        r0.<init>();	 Catch:{ Throwable -> 0x00b3 }
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.getPackageName();	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = "#";	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.b;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r3 = "pkgName";	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x00b3 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.d(r2);	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = "#";	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r2 = "pkgName";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00b3 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = "/";	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r2 = "serviceName";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00b3 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = "#";	 Catch:{ Throwable -> 0x00b3 }
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r2 = "pkgName";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00b3 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r3 = "serviceName";	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x00b3 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00b3 }
        r1 = com.igexin.push.core.a.a.l.a(r1, r2);	 Catch:{ Throwable -> 0x00b3 }
        if (r1 == 0) goto L_0x006f;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0069:
        r1 = "1";	 Catch:{ Throwable -> 0x00b3 }
    L_0x006b:
        r0.append(r1);	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x0072;	 Catch:{ Throwable -> 0x00b3 }
    L_0x006f:
        r1 = "0";	 Catch:{ Throwable -> 0x00b3 }
        goto L_0x006b;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0072:
        r2 = r8.b;	 Catch:{ Throwable -> 0x00b3 }
        r3 = "30026";	 Catch:{ Throwable -> 0x00b3 }
        r4 = r0.toString();	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r5 = "messageId";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00b3 }
        r5 = r1;	 Catch:{ Throwable -> 0x00b3 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r6 = "taskId";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r6);	 Catch:{ Throwable -> 0x00b3 }
        r6 = r1;	 Catch:{ Throwable -> 0x00b3 }
        r6 = (java.lang.String) r6;	 Catch:{ Throwable -> 0x00b3 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x00b3 }
        r7 = "id";	 Catch:{ Throwable -> 0x00b3 }
        r1 = r1.get(r7);	 Catch:{ Throwable -> 0x00b3 }
        r7 = r1;	 Catch:{ Throwable -> 0x00b3 }
        r7 = (java.lang.String) r7;	 Catch:{ Throwable -> 0x00b3 }
        r2.b(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x00b3 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b3 }
        r2 = "feedback actionId=30026 result=";	 Catch:{ Throwable -> 0x00b3 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00b3 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00b3 }
        r1.append(r0);	 Catch:{ Throwable -> 0x00b3 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x00b3 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Throwable -> 0x00b3 }
    L_0x00b3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.m.a():void");
    }

    public int b() {
        return 0;
    }
}
