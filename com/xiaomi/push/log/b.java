package com.xiaomi.push.log;

import android.content.Context;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.smack.util.e;
import java.io.File;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b {
    private static volatile b c;
    private final ConcurrentLinkedQueue<b> a = new ConcurrentLinkedQueue();
    private Context b;

    class b extends com.xiaomi.channel.commonutils.misc.j.b {
        long i = System.currentTimeMillis();
        final /* synthetic */ b j;

        b(b bVar) {
            this.j = bVar;
        }

        public void b() {
        }

        public boolean d() {
            return true;
        }

        final boolean e() {
            return System.currentTimeMillis() - this.i > 172800000;
        }
    }

    class a extends b {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
            super(bVar);
        }

        public void b() {
            this.a.b();
        }
    }

    class c extends b {
        String a;
        String b;
        File c;
        int d;
        boolean e;
        boolean f;
        final /* synthetic */ b g;

        c(b bVar, String str, String str2, File file, boolean z) {
            this.g = bVar;
            super(bVar);
            this.a = str;
            this.b = str2;
            this.c = file;
            this.f = z;
        }

        private boolean f() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = r10.g;
            r0 = r0.b;
            r1 = "log.timestamp";
            r2 = 0;
            r0 = r0.getSharedPreferences(r1, r2);
            r1 = "log.requst";
            r3 = "";
            r1 = r0.getString(r1, r3);
            r3 = java.lang.System.currentTimeMillis();
            r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x002b }
            r5.<init>(r1);	 Catch:{ JSONException -> 0x002b }
            r1 = "time";	 Catch:{ JSONException -> 0x002b }
            r6 = r5.getLong(r1);	 Catch:{ JSONException -> 0x002b }
            r1 = "times";	 Catch:{ JSONException -> 0x002c }
            r1 = r5.getInt(r1);	 Catch:{ JSONException -> 0x002c }
            goto L_0x002d;
        L_0x002b:
            r6 = r3;
        L_0x002c:
            r1 = r2;
        L_0x002d:
            r3 = java.lang.System.currentTimeMillis();
            r8 = r3 - r6;
            r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1));
            if (r5 >= 0) goto L_0x003f;
        L_0x003a:
            r3 = 10;
            if (r1 <= r3) goto L_0x0044;
        L_0x003e:
            return r2;
        L_0x003f:
            r6 = java.lang.System.currentTimeMillis();
            r1 = r2;
        L_0x0044:
            r2 = new org.json.JSONObject;
            r2.<init>();
            r3 = 1;
            r4 = "time";	 Catch:{ JSONException -> 0x0067 }
            r2.put(r4, r6);	 Catch:{ JSONException -> 0x0067 }
            r4 = "times";	 Catch:{ JSONException -> 0x0067 }
            r1 = r1 + r3;	 Catch:{ JSONException -> 0x0067 }
            r2.put(r4, r1);	 Catch:{ JSONException -> 0x0067 }
            r0 = r0.edit();	 Catch:{ JSONException -> 0x0067 }
            r1 = "log.requst";	 Catch:{ JSONException -> 0x0067 }
            r2 = r2.toString();	 Catch:{ JSONException -> 0x0067 }
            r0 = r0.putString(r1, r2);	 Catch:{ JSONException -> 0x0067 }
            r0.commit();	 Catch:{ JSONException -> 0x0067 }
            return r3;
        L_0x0067:
            r0 = move-exception;
            r1 = new java.lang.StringBuilder;
            r2 = "JSONException on put ";
            r1.<init>(r2);
            r0 = r0.getMessage();
            r1.append(r0);
            r0 = r1.toString();
            com.xiaomi.channel.commonutils.logger.b.c(r0);
            return r3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.b.c.f():boolean");
        }

        public void b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = r4.f();	 Catch:{ IOException -> 0x0036 }
            if (r0 == 0) goto L_0x0033;	 Catch:{ IOException -> 0x0036 }
        L_0x0006:
            r0 = new java.util.HashMap;	 Catch:{ IOException -> 0x0036 }
            r0.<init>();	 Catch:{ IOException -> 0x0036 }
            r1 = "uid";	 Catch:{ IOException -> 0x0036 }
            r2 = com.xiaomi.push.service.az.e();	 Catch:{ IOException -> 0x0036 }
            r0.put(r1, r2);	 Catch:{ IOException -> 0x0036 }
            r1 = "token";	 Catch:{ IOException -> 0x0036 }
            r2 = r4.b;	 Catch:{ IOException -> 0x0036 }
            r0.put(r1, r2);	 Catch:{ IOException -> 0x0036 }
            r1 = "net";	 Catch:{ IOException -> 0x0036 }
            r2 = r4.g;	 Catch:{ IOException -> 0x0036 }
            r2 = r2.b;	 Catch:{ IOException -> 0x0036 }
            r2 = com.xiaomi.channel.commonutils.network.d.k(r2);	 Catch:{ IOException -> 0x0036 }
            r0.put(r1, r2);	 Catch:{ IOException -> 0x0036 }
            r1 = r4.a;	 Catch:{ IOException -> 0x0036 }
            r2 = r4.c;	 Catch:{ IOException -> 0x0036 }
            r3 = "file";	 Catch:{ IOException -> 0x0036 }
            com.xiaomi.channel.commonutils.network.d.a(r1, r0, r2, r3);	 Catch:{ IOException -> 0x0036 }
        L_0x0033:
            r0 = 1;	 Catch:{ IOException -> 0x0036 }
            r4.e = r0;	 Catch:{ IOException -> 0x0036 }
        L_0x0036:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.b.c.b():void");
        }

        public void c() {
            if (!this.e) {
                this.d++;
                if (this.d < 3) {
                    this.g.a.add(this);
                }
            }
            if (this.e || this.d >= 3) {
                this.c.delete();
            }
            this.g.a((long) ((1 << this.d) * 1000));
        }

        public boolean d() {
            if (!d.e(this.g.b)) {
                if (!this.f || !d.c(this.g.b)) {
                    return false;
                }
            }
            return true;
        }
    }

    private b(Context context) {
        this.b = context;
        this.a.add(new a(this));
        b(0);
    }

    public static b a(Context context) {
        if (c == null) {
            synchronized (b.class) {
                if (c == null) {
                    c = new b(context);
                }
            }
        }
        c.b = context;
        return c;
    }

    private void a(long j) {
        b bVar = (b) this.a.peek();
        if (bVar != null && bVar.d()) {
            b(j);
        }
    }

    private void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.xiaomi.channel.commonutils.file.c.b();
        if (r0 != 0) goto L_0x0046;
    L_0x0006:
        r0 = com.xiaomi.channel.commonutils.file.c.a();
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = new java.io.File;	 Catch:{ NullPointerException -> 0x0046 }
        r1 = new java.lang.StringBuilder;	 Catch:{ NullPointerException -> 0x0046 }
        r1.<init>();	 Catch:{ NullPointerException -> 0x0046 }
        r2 = r4.b;	 Catch:{ NullPointerException -> 0x0046 }
        r3 = 0;	 Catch:{ NullPointerException -> 0x0046 }
        r2 = r2.getExternalFilesDir(r3);	 Catch:{ NullPointerException -> 0x0046 }
        r1.append(r2);	 Catch:{ NullPointerException -> 0x0046 }
        r2 = "/.logcache";	 Catch:{ NullPointerException -> 0x0046 }
        r1.append(r2);	 Catch:{ NullPointerException -> 0x0046 }
        r1 = r1.toString();	 Catch:{ NullPointerException -> 0x0046 }
        r0.<init>(r1);	 Catch:{ NullPointerException -> 0x0046 }
        r1 = r0.exists();	 Catch:{ NullPointerException -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ NullPointerException -> 0x0046 }
    L_0x0030:
        r1 = r0.isDirectory();	 Catch:{ NullPointerException -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ NullPointerException -> 0x0046 }
    L_0x0036:
        r0 = r0.listFiles();	 Catch:{ NullPointerException -> 0x0046 }
        r1 = r0.length;	 Catch:{ NullPointerException -> 0x0046 }
        r2 = 0;	 Catch:{ NullPointerException -> 0x0046 }
    L_0x003c:
        if (r2 >= r1) goto L_0x0046;	 Catch:{ NullPointerException -> 0x0046 }
    L_0x003e:
        r3 = r0[r2];	 Catch:{ NullPointerException -> 0x0046 }
        r3.delete();	 Catch:{ NullPointerException -> 0x0046 }
        r2 = r2 + 1;
        goto L_0x003c;
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.log.b.b():void");
    }

    private void b(long j) {
        if (!this.a.isEmpty()) {
            e.a(new d(this), j);
        }
    }

    private void c() {
        while (!this.a.isEmpty()) {
            b bVar = (b) this.a.peek();
            if (bVar != null) {
                if (bVar.e() || this.a.size() > 6) {
                    com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                    this.a.remove();
                } else {
                    return;
                }
            }
        }
    }

    public void a() {
        c();
        a(0);
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.a.add(new c(this, i, date, date2, str, str2, z));
        b(0);
    }
}
