package com.xiaomi.push.mpcd.job;

import android.content.Context;

public class d extends f {
    public d(Context context, int i) {
        super(context, i);
    }

    public int a() {
        return 6;
    }

    public java.lang.String b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();	 Catch:{ Throwable -> 0x005b }
        r1 = r1.getBondedDevices();	 Catch:{ Throwable -> 0x005b }
        r2 = com.xiaomi.channel.commonutils.misc.c.a(r1);	 Catch:{ Throwable -> 0x005b }
        if (r2 != 0) goto L_0x005b;	 Catch:{ Throwable -> 0x005b }
    L_0x0013:
        r2 = 0;	 Catch:{ Throwable -> 0x005b }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x005b }
    L_0x0018:
        r3 = r1.hasNext();	 Catch:{ Throwable -> 0x005b }
        if (r3 == 0) goto L_0x005b;	 Catch:{ Throwable -> 0x005b }
    L_0x001e:
        r3 = r1.next();	 Catch:{ Throwable -> 0x005b }
        r3 = (android.bluetooth.BluetoothDevice) r3;	 Catch:{ Throwable -> 0x005b }
        r4 = 10;	 Catch:{ Throwable -> 0x005b }
        if (r2 > r4) goto L_0x005b;	 Catch:{ Throwable -> 0x005b }
    L_0x0028:
        r4 = r0.length();	 Catch:{ Throwable -> 0x005b }
        if (r4 <= 0) goto L_0x0033;	 Catch:{ Throwable -> 0x005b }
    L_0x002e:
        r4 = ";";	 Catch:{ Throwable -> 0x005b }
        r0.append(r4);	 Catch:{ Throwable -> 0x005b }
    L_0x0033:
        r4 = r3.getName();	 Catch:{ Throwable -> 0x005b }
        r0.append(r4);	 Catch:{ Throwable -> 0x005b }
        r4 = ",";	 Catch:{ Throwable -> 0x005b }
        r0.append(r4);	 Catch:{ Throwable -> 0x005b }
        r4 = r3.getAddress();	 Catch:{ Throwable -> 0x005b }
        r0.append(r4);	 Catch:{ Throwable -> 0x005b }
        r4 = ",";	 Catch:{ Throwable -> 0x005b }
        r0.append(r4);	 Catch:{ Throwable -> 0x005b }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x005b }
        r5 = 18;	 Catch:{ Throwable -> 0x005b }
        if (r4 < r5) goto L_0x0058;	 Catch:{ Throwable -> 0x005b }
    L_0x0051:
        r3 = r3.getType();	 Catch:{ Throwable -> 0x005b }
        r0.append(r3);	 Catch:{ Throwable -> 0x005b }
    L_0x0058:
        r2 = r2 + 1;
        goto L_0x0018;
    L_0x005b:
        r0 = r0.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.d.b():java.lang.String");
    }

    protected boolean c() {
        return this.d.getPackageManager().checkPermission("android.permission.BLUETOOTH", this.d.getPackageName()) == 0;
    }

    public com.xiaomi.xmpush.thrift.d d() {
        return com.xiaomi.xmpush.thrift.d.Bluetooth;
    }
}
