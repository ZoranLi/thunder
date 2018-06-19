package com.xiaomi.push.log;

import java.io.File;
import java.util.Date;

class c extends b {
    File a;
    final /* synthetic */ int b;
    final /* synthetic */ Date c;
    final /* synthetic */ Date d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ boolean g;
    final /* synthetic */ b h;

    c(b bVar, int i, Date date, Date date2, String str, String str2, boolean z) {
        this.h = bVar;
        this.b = i;
        this.c = date;
        this.d = date2;
        this.e = str;
        this.f = str2;
        this.g = z;
        super(bVar);
    }

    public void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.xiaomi.channel.commonutils.file.c.d();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new java.io.File;	 Catch:{ NullPointerException -> 0x004b }
        r1 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x004b }
        r1.<init>();	 Catch:{ NullPointerException -> 0x004b }
        r2 = r5.h;	 Catch:{ NullPointerException -> 0x004b }
        r2 = r2.b;	 Catch:{ NullPointerException -> 0x004b }
        r3 = 0;	 Catch:{ NullPointerException -> 0x004b }
        r2 = r2.getExternalFilesDir(r3);	 Catch:{ NullPointerException -> 0x004b }
        r1.append(r2);	 Catch:{ NullPointerException -> 0x004b }
        r2 = "/.logcache";	 Catch:{ NullPointerException -> 0x004b }
        r1.append(r2);	 Catch:{ NullPointerException -> 0x004b }
        r1 = r1.toString();	 Catch:{ NullPointerException -> 0x004b }
        r0.<init>(r1);	 Catch:{ NullPointerException -> 0x004b }
        r0.mkdirs();	 Catch:{ NullPointerException -> 0x004b }
        r1 = r0.isDirectory();	 Catch:{ NullPointerException -> 0x004b }
        if (r1 == 0) goto L_0x004b;	 Catch:{ NullPointerException -> 0x004b }
    L_0x0031:
        r1 = new com.xiaomi.push.log.a;	 Catch:{ NullPointerException -> 0x004b }
        r1.<init>();	 Catch:{ NullPointerException -> 0x004b }
        r2 = r5.b;	 Catch:{ NullPointerException -> 0x004b }
        r1.a(r2);	 Catch:{ NullPointerException -> 0x004b }
        r2 = r5.h;	 Catch:{ NullPointerException -> 0x004b }
        r2 = r2.b;	 Catch:{ NullPointerException -> 0x004b }
        r3 = r5.c;	 Catch:{ NullPointerException -> 0x004b }
        r4 = r5.d;	 Catch:{ NullPointerException -> 0x004b }
        r0 = r1.a(r2, r3, r4, r0);	 Catch:{ NullPointerException -> 0x004b }
        r5.a = r0;	 Catch:{ NullPointerException -> 0x004b }
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.c.b():void");
    }

    public void c() {
        if (this.a != null && this.a.exists()) {
            this.h.a.add(new c(this.h, this.e, this.f, this.a, this.g));
        }
        this.h.a(0);
    }
}
