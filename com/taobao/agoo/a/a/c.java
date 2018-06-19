package com.taobao.agoo.a.a;

import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.e$a;

/* compiled from: Taobao */
public class c extends b {
    public static final String JSON_CMD_REGISTER = "register";
    public String a;
    public String b;
    public String c;
    public String d = "221";
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;

    public byte[] a() {
        try {
            ALog.i("RegisterDO", "buildData", "data", new e$a().a(b.JSON_CMD, this.e).a("appKey", this.a).a("utdid", this.b).a("appVersion", this.c).a(Constants.KEY_SDK_VERSION, this.d).a(Constants.KEY_TTID, this.f).a(Constants.KEY_PACKAGE_NAME, this.g).a("notifyEnable", this.h).a("romInfo", this.i).a("c0", this.j).a("c1", this.k).a("c2", this.l).a("c3", this.m).a("c4", this.n).a("c5", this.o).a("c6", this.p).a().toString());
            return new e$a().a(b.JSON_CMD, this.e).a("appKey", this.a).a("utdid", this.b).a("appVersion", this.c).a(Constants.KEY_SDK_VERSION, this.d).a(Constants.KEY_TTID, this.f).a(Constants.KEY_PACKAGE_NAME, this.g).a("notifyEnable", this.h).a("romInfo", this.i).a("c0", this.j).a("c1", this.k).a("c2", this.l).a("c3", this.m).a("c4", this.n).a("c5", this.o).a("c6", this.p).a().toString().getBytes("utf-8");
        } catch (Throwable th) {
            ALog.e("RegisterDO", "buildData", th, new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(android.content.Context r7, java.lang.String r8, java.lang.String r9) {
        /*
        r0 = 0;
        r1 = 0;
        r2 = com.taobao.accs.utl.UtilityImpl.getDeviceId(r7);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r3 = r7.getPackageName();	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r4 = com.taobao.accs.client.GlobalClientInfo.getInstance(r7);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r4 = r4.getPackageInfo();	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r4 = r4.versionName;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r5 = android.text.TextUtils.isEmpty(r8);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        if (r5 != 0) goto L_0x0072;
    L_0x001a:
        r5 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        if (r5 != 0) goto L_0x0072;
    L_0x0020:
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        if (r5 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0072;
    L_0x0027:
        r5 = new com.taobao.agoo.a.a.c;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r5.<init>();	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r6 = "register";
        r5.e = r6;	 Catch:{ Throwable -> 0x0070 }
        r5.a = r8;	 Catch:{ Throwable -> 0x0070 }
        r5.b = r2;	 Catch:{ Throwable -> 0x0070 }
        r5.c = r4;	 Catch:{ Throwable -> 0x0070 }
        r5.f = r9;	 Catch:{ Throwable -> 0x0070 }
        r5.g = r3;	 Catch:{ Throwable -> 0x0070 }
        r8 = android.os.Build.BRAND;	 Catch:{ Throwable -> 0x0070 }
        r5.j = r8;	 Catch:{ Throwable -> 0x0070 }
        r8 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x0070 }
        r5.k = r8;	 Catch:{ Throwable -> 0x0070 }
        r8 = com.taobao.accs.utl.a.d(r7);	 Catch:{ Throwable -> 0x0070 }
        r5.h = r8;	 Catch:{ Throwable -> 0x0070 }
        r8 = new com.taobao.accs.utl.d;	 Catch:{ Throwable -> 0x0070 }
        r8.<init>();	 Catch:{ Throwable -> 0x0070 }
        r8 = r8.a();	 Catch:{ Throwable -> 0x0070 }
        r5.i = r8;	 Catch:{ Throwable -> 0x0070 }
        r8 = "phone";
        r7 = r7.getSystemService(r8);	 Catch:{ Throwable -> 0x0070 }
        r7 = (android.telephony.TelephonyManager) r7;	 Catch:{ Throwable -> 0x0070 }
        if (r7 == 0) goto L_0x0062;
    L_0x005d:
        r8 = r7.getDeviceId();	 Catch:{ Throwable -> 0x0070 }
        goto L_0x0063;
    L_0x0062:
        r8 = r1;
    L_0x0063:
        r5.l = r8;	 Catch:{ Throwable -> 0x0070 }
        if (r7 == 0) goto L_0x006c;
    L_0x0067:
        r7 = r7.getSubscriberId();	 Catch:{ Throwable -> 0x0070 }
        goto L_0x006d;
    L_0x006c:
        r7 = r1;
    L_0x006d:
        r5.m = r7;	 Catch:{ Throwable -> 0x0070 }
        goto L_0x00a4;
    L_0x0070:
        r7 = move-exception;
        goto L_0x0099;
    L_0x0072:
        r7 = "RegisterDO";
        r9 = "buildRegister param null";
        r3 = 6;
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r5 = "appKey";
        r3[r0] = r5;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r5 = 1;
        r3[r5] = r8;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r8 = 2;
        r5 = "utdid";
        r3[r8] = r5;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r8 = 3;
        r3[r8] = r2;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r8 = 4;
        r2 = "appVersion";
        r3[r8] = r2;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        r8 = 5;
        r3[r8] = r4;	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        com.taobao.accs.utl.ALog.e(r7, r9, r3);	 Catch:{ Throwable -> 0x0097, all -> 0x0094 }
        return r1;
    L_0x0094:
        r7 = move-exception;
        r5 = r1;
        goto L_0x00aa;
    L_0x0097:
        r7 = move-exception;
        r5 = r1;
    L_0x0099:
        r8 = "RegisterDO";
        r9 = "buildRegister";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x00a9 }
        com.taobao.accs.utl.ALog.e(r8, r9, r7, r0);	 Catch:{ all -> 0x00a9 }
        if (r5 == 0) goto L_0x00a8;
    L_0x00a4:
        r1 = r5.a();
    L_0x00a8:
        return r1;
    L_0x00a9:
        r7 = move-exception;
    L_0x00aa:
        if (r5 == 0) goto L_0x00af;
    L_0x00ac:
        r5.a();
    L_0x00af:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.agoo.a.a.c.a(android.content.Context, java.lang.String, java.lang.String):byte[]");
    }
}
