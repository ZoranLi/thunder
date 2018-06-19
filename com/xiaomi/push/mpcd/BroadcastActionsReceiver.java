package com.xiaomi.push.mpcd;

import android.content.BroadcastReceiver;
import com.xiaomi.xmpush.thrift.d;

public class BroadcastActionsReceiver extends BroadcastReceiver {
    public static final String a = String.valueOf(d.o.a());
    public static final String b = String.valueOf(d.p.a());

    private void a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 != 0) goto L_0x0043;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 == 0) goto L_0x000d;
    L_0x000c:
        return;
    L_0x000d:
        r0 = "12";	 Catch:{ Throwable -> 0x0043 }
        r1 = 1;	 Catch:{ Throwable -> 0x0043 }
        r0 = com.xiaomi.channel.commonutils.misc.f.a(r4, r0, r1);	 Catch:{ Throwable -> 0x0043 }
        if (r0 != 0) goto L_0x0018;	 Catch:{ Throwable -> 0x0043 }
    L_0x0017:
        return;	 Catch:{ Throwable -> 0x0043 }
    L_0x0018:
        r0 = new com.xiaomi.xmpush.thrift.k;	 Catch:{ Throwable -> 0x0043 }
        r0.<init>();	 Catch:{ Throwable -> 0x0043 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0043 }
        r1.<init>();	 Catch:{ Throwable -> 0x0043 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0043 }
        r5 = ":";	 Catch:{ Throwable -> 0x0043 }
        r1.append(r5);	 Catch:{ Throwable -> 0x0043 }
        r1.append(r6);	 Catch:{ Throwable -> 0x0043 }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x0043 }
        r0.a(r5);	 Catch:{ Throwable -> 0x0043 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0043 }
        r0.a(r5);	 Catch:{ Throwable -> 0x0043 }
        r5 = com.xiaomi.xmpush.thrift.d.j;	 Catch:{ Throwable -> 0x0043 }
        r0.a(r5);	 Catch:{ Throwable -> 0x0043 }
        com.xiaomi.push.mpcd.job.f.a(r4, r0);	 Catch:{ Throwable -> 0x0043 }
    L_0x0043:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.BroadcastActionsReceiver.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public void onReceive(android.content.Context r9, android.content.Intent r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        if (r10 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = r10.getDataString();	 Catch:{ Throwable -> 0x0173 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0173 }
        if (r1 == 0) goto L_0x000e;	 Catch:{ Throwable -> 0x0173 }
    L_0x000d:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x000e:
        r1 = ":";	 Catch:{ Throwable -> 0x0173 }
        r0 = r0.split(r1);	 Catch:{ Throwable -> 0x0173 }
        r1 = r0.length;	 Catch:{ Throwable -> 0x0173 }
        r2 = 2;	 Catch:{ Throwable -> 0x0173 }
        if (r1 < r2) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0018:
        r1 = 1;	 Catch:{ Throwable -> 0x0173 }
        r2 = r0[r1];	 Catch:{ Throwable -> 0x0173 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0173 }
        if (r2 == 0) goto L_0x0022;	 Catch:{ Throwable -> 0x0173 }
    L_0x0021:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x0022:
        r0 = r0[r1];	 Catch:{ Throwable -> 0x0173 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0173 }
        r4 = com.xiaomi.push.service.am.a(r9);	 Catch:{ Throwable -> 0x0173 }
        r5 = com.xiaomi.xmpush.thrift.g.Q;	 Catch:{ Throwable -> 0x0173 }
        r5 = r5.a();	 Catch:{ Throwable -> 0x0173 }
        r1 = r4.a(r5, r1);	 Catch:{ Throwable -> 0x0173 }
        r4 = "android.intent.action.PACKAGE_RESTARTED";	 Catch:{ Throwable -> 0x0173 }
        r5 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r4 = android.text.TextUtils.equals(r4, r5);	 Catch:{ Throwable -> 0x0173 }
        r5 = 1;	 Catch:{ Throwable -> 0x0173 }
        if (r4 == 0) goto L_0x0092;	 Catch:{ Throwable -> 0x0173 }
    L_0x0044:
        r10 = "12";	 Catch:{ Throwable -> 0x0173 }
        r9 = com.xiaomi.channel.commonutils.misc.f.a(r9, r10, r5);	 Catch:{ Throwable -> 0x0173 }
        if (r9 == 0) goto L_0x0091;	 Catch:{ Throwable -> 0x0173 }
    L_0x004c:
        if (r1 != 0) goto L_0x004f;	 Catch:{ Throwable -> 0x0173 }
    L_0x004e:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x004f:
        r9 = com.xiaomi.push.mpcd.job.e.a;	 Catch:{ Throwable -> 0x0173 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x0173 }
        if (r9 == 0) goto L_0x0071;	 Catch:{ Throwable -> 0x0173 }
    L_0x0057:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0173 }
        r9.<init>();	 Catch:{ Throwable -> 0x0173 }
        r10 = com.xiaomi.push.mpcd.job.e.a;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r10 = a;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r10 = ":";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0173 }
        com.xiaomi.push.mpcd.job.e.a = r9;	 Catch:{ Throwable -> 0x0173 }
    L_0x0071:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0173 }
        r9.<init>();	 Catch:{ Throwable -> 0x0173 }
        r10 = com.xiaomi.push.mpcd.job.e.a;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9.append(r0);	 Catch:{ Throwable -> 0x0173 }
        r10 = "(";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9.append(r2);	 Catch:{ Throwable -> 0x0173 }
        r10 = "),";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0173 }
        com.xiaomi.push.mpcd.job.e.a = r9;	 Catch:{ Throwable -> 0x0173 }
    L_0x0091:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x0092:
        r4 = "android.intent.action.PACKAGE_CHANGED";	 Catch:{ Throwable -> 0x0173 }
        r7 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r4 = android.text.TextUtils.equals(r4, r7);	 Catch:{ Throwable -> 0x0173 }
        if (r4 == 0) goto L_0x00ec;	 Catch:{ Throwable -> 0x0173 }
    L_0x009e:
        r10 = "12";	 Catch:{ Throwable -> 0x0173 }
        r9 = com.xiaomi.channel.commonutils.misc.f.a(r9, r10, r5);	 Catch:{ Throwable -> 0x0173 }
        if (r9 == 0) goto L_0x00eb;	 Catch:{ Throwable -> 0x0173 }
    L_0x00a6:
        if (r1 != 0) goto L_0x00a9;	 Catch:{ Throwable -> 0x0173 }
    L_0x00a8:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x00a9:
        r9 = com.xiaomi.push.mpcd.job.e.b;	 Catch:{ Throwable -> 0x0173 }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Throwable -> 0x0173 }
        if (r9 == 0) goto L_0x00cb;	 Catch:{ Throwable -> 0x0173 }
    L_0x00b1:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0173 }
        r9.<init>();	 Catch:{ Throwable -> 0x0173 }
        r10 = com.xiaomi.push.mpcd.job.e.b;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r10 = b;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r10 = ":";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0173 }
        com.xiaomi.push.mpcd.job.e.b = r9;	 Catch:{ Throwable -> 0x0173 }
    L_0x00cb:
        r9 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0173 }
        r9.<init>();	 Catch:{ Throwable -> 0x0173 }
        r10 = com.xiaomi.push.mpcd.job.e.b;	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9.append(r0);	 Catch:{ Throwable -> 0x0173 }
        r10 = "(";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9.append(r2);	 Catch:{ Throwable -> 0x0173 }
        r10 = "),";	 Catch:{ Throwable -> 0x0173 }
        r9.append(r10);	 Catch:{ Throwable -> 0x0173 }
        r9 = r9.toString();	 Catch:{ Throwable -> 0x0173 }
        com.xiaomi.push.mpcd.job.e.b = r9;	 Catch:{ Throwable -> 0x0173 }
    L_0x00eb:
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x00ec:
        r2 = "android.intent.action.PACKAGE_ADDED";	 Catch:{ Throwable -> 0x0173 }
        r3 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r2 = android.text.TextUtils.equals(r2, r3);	 Catch:{ Throwable -> 0x0173 }
        if (r2 == 0) goto L_0x0114;	 Catch:{ Throwable -> 0x0173 }
    L_0x00f8:
        r10 = r10.getExtras();	 Catch:{ Throwable -> 0x0173 }
        r2 = "android.intent.extra.REPLACING";	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.getBoolean(r2);	 Catch:{ Throwable -> 0x0173 }
        if (r10 != 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0104:
        if (r1 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0106:
        r10 = com.xiaomi.xmpush.thrift.d.k;	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.a();	 Catch:{ Throwable -> 0x0173 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0173 }
        r8.a(r9, r10, r0);	 Catch:{ Throwable -> 0x0173 }
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x0114:
        r2 = "android.intent.action.PACKAGE_REMOVED";	 Catch:{ Throwable -> 0x0173 }
        r3 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r2 = android.text.TextUtils.equals(r2, r3);	 Catch:{ Throwable -> 0x0173 }
        if (r2 == 0) goto L_0x013c;	 Catch:{ Throwable -> 0x0173 }
    L_0x0120:
        r10 = r10.getExtras();	 Catch:{ Throwable -> 0x0173 }
        r2 = "android.intent.extra.REPLACING";	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.getBoolean(r2);	 Catch:{ Throwable -> 0x0173 }
        if (r10 != 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x012c:
        if (r1 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x012e:
        r10 = com.xiaomi.xmpush.thrift.d.l;	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.a();	 Catch:{ Throwable -> 0x0173 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0173 }
        r8.a(r9, r10, r0);	 Catch:{ Throwable -> 0x0173 }
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x013c:
        r2 = "android.intent.action.PACKAGE_REPLACED";	 Catch:{ Throwable -> 0x0173 }
        r3 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r2 = android.text.TextUtils.equals(r2, r3);	 Catch:{ Throwable -> 0x0173 }
        if (r2 == 0) goto L_0x0158;	 Catch:{ Throwable -> 0x0173 }
    L_0x0148:
        if (r1 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x014a:
        r10 = com.xiaomi.xmpush.thrift.d.m;	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.a();	 Catch:{ Throwable -> 0x0173 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0173 }
        r8.a(r9, r10, r0);	 Catch:{ Throwable -> 0x0173 }
        return;	 Catch:{ Throwable -> 0x0173 }
    L_0x0158:
        r2 = "android.intent.action.PACKAGE_DATA_CLEARED";	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.getAction();	 Catch:{ Throwable -> 0x0173 }
        r10 = android.text.TextUtils.equals(r2, r10);	 Catch:{ Throwable -> 0x0173 }
        if (r10 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0164:
        if (r1 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0166:
        r10 = com.xiaomi.xmpush.thrift.d.n;	 Catch:{ Throwable -> 0x0173 }
        r10 = r10.a();	 Catch:{ Throwable -> 0x0173 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ Throwable -> 0x0173 }
        r8.a(r9, r10, r0);	 Catch:{ Throwable -> 0x0173 }
    L_0x0173:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.BroadcastActionsReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
