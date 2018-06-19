package com.igexin.push.core.b;

import android.content.Context;
import android.content.SharedPreferences;

public class c {
    private static final Object b = new Object();
    private static final Object c = new Object();
    private SharedPreferences a;

    public c(Context context) {
        if (context != null) {
            this.a = context.getSharedPreferences("gx_msg_sp", 0);
        }
    }

    private void a(org.json.JSONObject r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = r15.length();	 Catch:{ Throwable -> 0x0043 }
        r1 = 150; // 0x96 float:2.1E-43 double:7.4E-322;	 Catch:{ Throwable -> 0x0043 }
        if (r0 >= r1) goto L_0x0009;	 Catch:{ Throwable -> 0x0043 }
    L_0x0008:
        return;	 Catch:{ Throwable -> 0x0043 }
    L_0x0009:
        r0 = 0;	 Catch:{ Throwable -> 0x0043 }
        r1 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;	 Catch:{ Throwable -> 0x0043 }
        r3 = 0;	 Catch:{ Throwable -> 0x0043 }
        r4 = r15.keys();	 Catch:{ Throwable -> 0x0043 }
    L_0x0014:
        r5 = r4.hasNext();	 Catch:{ Throwable -> 0x0043 }
        if (r5 == 0) goto L_0x003c;	 Catch:{ Throwable -> 0x0043 }
    L_0x001a:
        r5 = r4.next();	 Catch:{ Throwable -> 0x0043 }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x0043 }
        r6 = r15.getLong(r5);	 Catch:{ Throwable -> 0x0043 }
        r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x0043 }
        if (r8 <= 0) goto L_0x002a;	 Catch:{ Throwable -> 0x0043 }
    L_0x0028:
        r3 = r5;	 Catch:{ Throwable -> 0x0043 }
        r1 = r6;	 Catch:{ Throwable -> 0x0043 }
    L_0x002a:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0043 }
        r10 = 432000000; // 0x19bfcc00 float:1.9831332E-23 double:2.13436359E-315;	 Catch:{ Throwable -> 0x0043 }
        r12 = r8 - r10;	 Catch:{ Throwable -> 0x0043 }
        r5 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x0043 }
        if (r5 >= 0) goto L_0x0014;	 Catch:{ Throwable -> 0x0043 }
    L_0x0037:
        r4.remove();	 Catch:{ Throwable -> 0x0043 }
        r0 = 1;	 Catch:{ Throwable -> 0x0043 }
        goto L_0x0014;	 Catch:{ Throwable -> 0x0043 }
    L_0x003c:
        if (r0 != 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0043 }
    L_0x003e:
        if (r3 == 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0043 }
    L_0x0040:
        r15.remove(r3);	 Catch:{ Throwable -> 0x0043 }
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.a(org.json.JSONObject):void");
    }

    private void b(org.json.JSONObject r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = r15.length();	 Catch:{ Throwable -> 0x004d }
        r1 = 20;	 Catch:{ Throwable -> 0x004d }
        if (r0 >= r1) goto L_0x0009;	 Catch:{ Throwable -> 0x004d }
    L_0x0008:
        return;	 Catch:{ Throwable -> 0x004d }
    L_0x0009:
        r0 = 0;	 Catch:{ Throwable -> 0x004d }
        r1 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;	 Catch:{ Throwable -> 0x004d }
        r3 = 0;	 Catch:{ Throwable -> 0x004d }
        r4 = r15.keys();	 Catch:{ Throwable -> 0x004d }
    L_0x0014:
        r5 = r4.hasNext();	 Catch:{ Throwable -> 0x004d }
        if (r5 == 0) goto L_0x0046;	 Catch:{ Throwable -> 0x004d }
    L_0x001a:
        r5 = r4.next();	 Catch:{ Throwable -> 0x004d }
        r5 = (java.lang.String) r5;	 Catch:{ Throwable -> 0x004d }
        r6 = r15.getJSONObject(r5);	 Catch:{ Throwable -> 0x004d }
        r7 = "timestamp";	 Catch:{ Throwable -> 0x004d }
        r6 = r6.getString(r7);	 Catch:{ Throwable -> 0x004d }
        r6 = java.lang.Long.parseLong(r6);	 Catch:{ Throwable -> 0x004d }
        r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x004d }
        if (r8 <= 0) goto L_0x0034;	 Catch:{ Throwable -> 0x004d }
    L_0x0032:
        r3 = r5;	 Catch:{ Throwable -> 0x004d }
        r1 = r6;	 Catch:{ Throwable -> 0x004d }
    L_0x0034:
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x004d }
        r10 = 432000000; // 0x19bfcc00 float:1.9831332E-23 double:2.13436359E-315;	 Catch:{ Throwable -> 0x004d }
        r12 = r8 - r10;	 Catch:{ Throwable -> 0x004d }
        r5 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1));	 Catch:{ Throwable -> 0x004d }
        if (r5 >= 0) goto L_0x0014;	 Catch:{ Throwable -> 0x004d }
    L_0x0041:
        r4.remove();	 Catch:{ Throwable -> 0x004d }
        r0 = 1;	 Catch:{ Throwable -> 0x004d }
        goto L_0x0014;	 Catch:{ Throwable -> 0x004d }
    L_0x0046:
        if (r0 != 0) goto L_0x004d;	 Catch:{ Throwable -> 0x004d }
    L_0x0048:
        if (r3 == 0) goto L_0x004d;	 Catch:{ Throwable -> 0x004d }
    L_0x004a:
        r15.remove(r3);	 Catch:{ Throwable -> 0x004d }
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.b(org.json.JSONObject):void");
    }

    public org.json.JSONObject a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;	 Catch:{ Throwable -> 0x0016 }
        r1 = "taskIdList";	 Catch:{ Throwable -> 0x0016 }
        r2 = "";	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.getString(r1, r2);	 Catch:{ Throwable -> 0x0016 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0016 }
        if (r1 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0016 }
    L_0x0010:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0016 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0016 }
        return r1;
    L_0x0016:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.a():org.json.JSONObject");
    }

    public void a(java.lang.String r4, org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 == 0) goto L_0x0040;
    L_0x0004:
        if (r5 == 0) goto L_0x0040;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = b;
        monitor-enter(r0);
        r1 = r3.b();	 Catch:{ Throwable -> 0x003c }
        if (r1 != 0) goto L_0x001b;	 Catch:{ Throwable -> 0x003c }
    L_0x0016:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x003c }
        r1.<init>();	 Catch:{ Throwable -> 0x003c }
    L_0x001b:
        r2 = r1.length();	 Catch:{ Throwable -> 0x003c }
        if (r2 <= 0) goto L_0x0024;	 Catch:{ Throwable -> 0x003c }
    L_0x0021:
        r3.b(r1);	 Catch:{ Throwable -> 0x003c }
    L_0x0024:
        r1.put(r4, r5);	 Catch:{ Throwable -> 0x003c }
        r4 = r3.a;	 Catch:{ Throwable -> 0x003c }
        r4 = r4.edit();	 Catch:{ Throwable -> 0x003c }
        r5 = "usfdl";	 Catch:{ Throwable -> 0x003c }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x003c }
        r4.putString(r5, r1);	 Catch:{ Throwable -> 0x003c }
        r4.apply();	 Catch:{ Throwable -> 0x003c }
        goto L_0x003c;
    L_0x003a:
        r4 = move-exception;
        goto L_0x003e;
    L_0x003c:
        monitor-exit(r0);	 Catch:{ all -> 0x003a }
        return;	 Catch:{ all -> 0x003a }
    L_0x003e:
        monitor-exit(r0);	 Catch:{ all -> 0x003a }
        throw r4;
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.a(java.lang.String, org.json.JSONObject):void");
    }

    public boolean a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;
        r1 = 0;
        if (r0 == 0) goto L_0x0030;
    L_0x0005:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r0 = r3.a();	 Catch:{ Throwable -> 0x0030 }
        if (r0 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0030 }
    L_0x0012:
        r0 = r0.has(r4);	 Catch:{ Throwable -> 0x0030 }
        if (r0 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0030 }
    L_0x0018:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0030 }
        r2 = "sp task ";	 Catch:{ Throwable -> 0x0030 }
        r0.<init>(r2);	 Catch:{ Throwable -> 0x0030 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0030 }
        r4 = " already exists";	 Catch:{ Throwable -> 0x0030 }
        r0.append(r4);	 Catch:{ Throwable -> 0x0030 }
        r4 = r0.toString();	 Catch:{ Throwable -> 0x0030 }
        com.igexin.b.a.c.a.b(r4);	 Catch:{ Throwable -> 0x0030 }
        r4 = 1;
        return r4;
    L_0x0030:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.a(java.lang.String):boolean");
    }

    public org.json.JSONObject b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;	 Catch:{ Throwable -> 0x0016 }
        r1 = "usfdl";	 Catch:{ Throwable -> 0x0016 }
        r2 = "";	 Catch:{ Throwable -> 0x0016 }
        r0 = r0.getString(r1, r2);	 Catch:{ Throwable -> 0x0016 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0016 }
        if (r1 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x0016 }
    L_0x0010:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0016 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0016 }
        return r1;
    L_0x0016:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.b():org.json.JSONObject");
    }

    public void b(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.a;
        if (r0 == 0) goto L_0x0042;
    L_0x0004:
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        r0 = c;
        monitor-enter(r0);
        r1 = r4.a();	 Catch:{ Throwable -> 0x003e }
        if (r1 != 0) goto L_0x0019;	 Catch:{ Throwable -> 0x003e }
    L_0x0014:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x003e }
        r1.<init>();	 Catch:{ Throwable -> 0x003e }
    L_0x0019:
        r2 = r1.length();	 Catch:{ Throwable -> 0x003e }
        if (r2 <= 0) goto L_0x0022;	 Catch:{ Throwable -> 0x003e }
    L_0x001f:
        r4.a(r1);	 Catch:{ Throwable -> 0x003e }
    L_0x0022:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x003e }
        r1.put(r5, r2);	 Catch:{ Throwable -> 0x003e }
        r5 = r4.a;	 Catch:{ Throwable -> 0x003e }
        r5 = r5.edit();	 Catch:{ Throwable -> 0x003e }
        r2 = "taskIdList";	 Catch:{ Throwable -> 0x003e }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x003e }
        r5.putString(r2, r1);	 Catch:{ Throwable -> 0x003e }
        r5.apply();	 Catch:{ Throwable -> 0x003e }
        goto L_0x003e;
    L_0x003c:
        r5 = move-exception;
        goto L_0x0040;
    L_0x003e:
        monitor-exit(r0);	 Catch:{ all -> 0x003c }
        return;	 Catch:{ all -> 0x003c }
    L_0x0040:
        monitor-exit(r0);	 Catch:{ all -> 0x003c }
        throw r5;
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.b(java.lang.String):void");
    }

    public org.json.JSONObject c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r12 = this;
        r0 = b;
        monitor-enter(r0);
        r1 = 0;
        r2 = r12.a;	 Catch:{ Throwable -> 0x0057 }
        r3 = "usfdl";	 Catch:{ Throwable -> 0x0057 }
        r4 = "";	 Catch:{ Throwable -> 0x0057 }
        r2 = r2.getString(r3, r4);	 Catch:{ Throwable -> 0x0057 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0057 }
        if (r3 == 0) goto L_0x0016;
    L_0x0014:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        return r1;
    L_0x0016:
        r3 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0057 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0057 }
        r2 = r3.keys();	 Catch:{ Throwable -> 0x0057 }
    L_0x001f:
        r4 = r2.hasNext();	 Catch:{ Throwable -> 0x0057 }
        if (r4 == 0) goto L_0x0053;	 Catch:{ Throwable -> 0x0057 }
    L_0x0025:
        r4 = r2.next();	 Catch:{ Throwable -> 0x0057 }
        r4 = (java.lang.String) r4;	 Catch:{ Throwable -> 0x0057 }
        r4 = r3.getJSONObject(r4);	 Catch:{ Throwable -> 0x0057 }
        r5 = "timestamp";	 Catch:{ Throwable -> 0x0057 }
        r5 = r4.has(r5);	 Catch:{ Throwable -> 0x0057 }
        if (r5 != 0) goto L_0x003b;	 Catch:{ Throwable -> 0x0057 }
    L_0x0037:
        r2.remove();	 Catch:{ Throwable -> 0x0057 }
        goto L_0x001f;	 Catch:{ Throwable -> 0x0057 }
    L_0x003b:
        r5 = "timestamp";	 Catch:{ Throwable -> 0x0057 }
        r4 = r4.getString(r5);	 Catch:{ Throwable -> 0x0057 }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ Throwable -> 0x0057 }
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0057 }
        r8 = 432000000; // 0x19bfcc00 float:1.9831332E-23 double:2.13436359E-315;
        r10 = r6 - r8;
        r6 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r6 >= 0) goto L_0x001f;
    L_0x0052:
        goto L_0x0037;
    L_0x0053:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        return r3;	 Catch:{ all -> 0x0055 }
    L_0x0055:
        r1 = move-exception;	 Catch:{ all -> 0x0055 }
        goto L_0x0059;	 Catch:{ all -> 0x0055 }
    L_0x0057:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        return r1;	 Catch:{ all -> 0x0055 }
    L_0x0059:
        monitor-exit(r0);	 Catch:{ all -> 0x0055 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.c():org.json.JSONObject");
    }

    public void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = b;
        monitor-enter(r0);
        r1 = r4.a;	 Catch:{ Throwable -> 0x001a }
        if (r1 == 0) goto L_0x001a;	 Catch:{ Throwable -> 0x001a }
    L_0x0007:
        r1 = r4.a;	 Catch:{ Throwable -> 0x001a }
        r1 = r1.edit();	 Catch:{ Throwable -> 0x001a }
        r2 = "usfdl";	 Catch:{ Throwable -> 0x001a }
        r3 = "";	 Catch:{ Throwable -> 0x001a }
        r1.putString(r2, r3);	 Catch:{ Throwable -> 0x001a }
        r1.apply();	 Catch:{ Throwable -> 0x001a }
        goto L_0x001a;
    L_0x0018:
        r1 = move-exception;
        goto L_0x001c;
    L_0x001a:
        monitor-exit(r0);	 Catch:{ all -> 0x0018 }
        return;	 Catch:{ all -> 0x0018 }
    L_0x001c:
        monitor-exit(r0);	 Catch:{ all -> 0x0018 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.b.c.d():void");
    }
}
