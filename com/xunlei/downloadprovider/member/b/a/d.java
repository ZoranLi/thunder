package com.xunlei.downloadprovider.member.b.a;

import android.os.SystemClock;
import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.member.b.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: VipRenewal */
public final class d implements a, com.xunlei.downloadprovider.member.login.b.d {
    private static String c = "VipRenewal";
    @Nullable
    a.a a;
    String b = "";

    public d(@Nullable a.a aVar) {
        this.a = aVar;
    }

    public final void a(java.lang.String r15) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r14 = this;
        r0 = android.text.TextUtils.isEmpty(r15);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r0 = com.xunlei.downloadprovider.member.login.b.l.b();
        if (r0 != 0) goto L_0x0023;
    L_0x0010:
        com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r0 = com.xunlei.downloadprovider.member.login.b.l.b();
        if (r0 == 0) goto L_0x01c2;
    L_0x0019:
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r0.a(r14);
        r14.b = r15;
        return;
    L_0x0023:
        r0 = android.text.TextUtils.isEmpty(r15);
        r1 = 0;
        if (r0 != 0) goto L_0x0051;
    L_0x002a:
        r0 = ";";
        r0 = r15.split(r0);
        r2 = r0.length;
        r3 = r1;
    L_0x0032:
        if (r3 >= r2) goto L_0x0051;
    L_0x0034:
        r4 = r0[r3];
        r5 = com.xunlei.downloadprovider.member.b.a.a.b(r4);
        if (r5 == 0) goto L_0x004e;
    L_0x003c:
        r6 = android.os.SystemClock.elapsedRealtime();
        r8 = r5.a;
        r10 = r6 - r8;
        r5 = 43200000; // 0x2932e00 float:2.1626111E-37 double:2.1343636E-316;
        r7 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1));
        if (r7 <= 0) goto L_0x004e;
    L_0x004b:
        com.xunlei.downloadprovider.member.b.a.a.c(r4);
    L_0x004e:
        r3 = r3 + 1;
        goto L_0x0032;
    L_0x0051:
        r0 = new com.xunlei.downloadprovider.member.b.a.e;
        r2 = r14.a;
        r0.<init>(r2);
        r2 = 1;
        r3 = com.xunlei.downloadprovider.member.b.a.e.a;	 Catch:{ Exception -> 0x0143 }
        if (r3 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x0143 }
    L_0x005d:
        r15 = r0.c;	 Catch:{ Exception -> 0x0143 }
        if (r15 == 0) goto L_0x0146;	 Catch:{ Exception -> 0x0143 }
    L_0x0061:
        r15 = r0.c;	 Catch:{ Exception -> 0x0143 }
        r15.j();	 Catch:{ Exception -> 0x0143 }
        goto L_0x0146;	 Catch:{ Exception -> 0x0143 }
    L_0x0068:
        com.xunlei.downloadprovider.member.b.a.e.a = r2;	 Catch:{ Exception -> 0x0143 }
        r0.b = r15;	 Catch:{ Exception -> 0x0143 }
        r3 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0143 }
        r3.<init>();	 Catch:{ Exception -> 0x0143 }
        r4 = "userid";	 Catch:{ Exception -> 0x0143 }
        r5 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x0143 }
        r5 = r5.g;	 Catch:{ Exception -> 0x0143 }
        r5 = r5.c();	 Catch:{ Exception -> 0x0143 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x0143 }
        r4 = "expire";	 Catch:{ Exception -> 0x0143 }
        r5 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x0143 }
        r5 = r5.l();	 Catch:{ Exception -> 0x0143 }
        if (r5 == 0) goto L_0x0091;	 Catch:{ Exception -> 0x0143 }
    L_0x008c:
        r5 = com.xunlei.downloadprovider.member.b.a.b.a(r15);	 Catch:{ Exception -> 0x0143 }
        goto L_0x00d3;	 Catch:{ Exception -> 0x0143 }
    L_0x0091:
        r5 = com.xunlei.downloadprovider.member.b.a.b.a(r15);	 Catch:{ Exception -> 0x0143 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0143 }
        if (r6 != 0) goto L_0x00a4;	 Catch:{ Exception -> 0x0143 }
    L_0x009b:
        r6 = r5.length();	 Catch:{ Exception -> 0x0143 }
        r7 = 8;	 Catch:{ Exception -> 0x0143 }
        if (r6 != r7) goto L_0x00a4;	 Catch:{ Exception -> 0x0143 }
    L_0x00a3:
        goto L_0x00d3;	 Catch:{ Exception -> 0x0143 }
    L_0x00a4:
        r5 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x0143 }
        r6 = "vip_continue";	 Catch:{ Exception -> 0x0143 }
        r5 = r5.getSharedPreferences(r6, r1);	 Catch:{ Exception -> 0x0143 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0143 }
        r6.<init>();	 Catch:{ Exception -> 0x0143 }
        r7 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x0143 }
        r7 = r7.g;	 Catch:{ Exception -> 0x0143 }
        r7 = r7.c();	 Catch:{ Exception -> 0x0143 }
        r6.append(r7);	 Catch:{ Exception -> 0x0143 }
        r7 = "vip_expire_date";	 Catch:{ Exception -> 0x0143 }
        r6.append(r7);	 Catch:{ Exception -> 0x0143 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0143 }
        r7 = 0;	 Catch:{ Exception -> 0x0143 }
        r5 = r5.getString(r6, r7);	 Catch:{ Exception -> 0x0143 }
        if (r5 == 0) goto L_0x00d1;	 Catch:{ Exception -> 0x0143 }
    L_0x00d0:
        goto L_0x00d3;	 Catch:{ Exception -> 0x0143 }
    L_0x00d1:
        r5 = "";	 Catch:{ Exception -> 0x0143 }
    L_0x00d3:
        r3.put(r4, r5);	 Catch:{ Exception -> 0x0143 }
        r4 = "vas_type";	 Catch:{ Exception -> 0x0143 }
        r5 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x0143 }
        r5 = r5.g;	 Catch:{ Exception -> 0x0143 }
        r5 = r5.f();	 Catch:{ Exception -> 0x0143 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x0143 }
        r4 = "level";	 Catch:{ Exception -> 0x0143 }
        r5 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ Exception -> 0x0143 }
        r5 = r5.m();	 Catch:{ Exception -> 0x0143 }
        r3.put(r4, r5);	 Catch:{ Exception -> 0x0143 }
        r4 = "style";	 Catch:{ Exception -> 0x0143 }
        if (r15 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0143 }
    L_0x00f6:
        r5 = "_";	 Catch:{ Exception -> 0x0143 }
        r5 = r15.split(r5);	 Catch:{ Exception -> 0x0143 }
        if (r5 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0143 }
    L_0x00fe:
        r6 = r5.length;	 Catch:{ Exception -> 0x0143 }
        if (r6 <= r2) goto L_0x0103;	 Catch:{ Exception -> 0x0143 }
    L_0x0101:
        r15 = r5[r1];	 Catch:{ Exception -> 0x0143 }
    L_0x0103:
        r3.put(r4, r15);	 Catch:{ Exception -> 0x0143 }
        r15 = "version";	 Catch:{ Exception -> 0x0143 }
        r4 = "5.60.2.5510";	 Catch:{ Exception -> 0x0143 }
        r3.put(r15, r4);	 Catch:{ Exception -> 0x0143 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0143 }
        r4 = "reqUrl params:";	 Catch:{ Exception -> 0x0143 }
        r15.<init>(r4);	 Catch:{ Exception -> 0x0143 }
        r4 = r3.toString();	 Catch:{ Exception -> 0x0143 }
        r15.append(r4);	 Catch:{ Exception -> 0x0143 }
        r15 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0143 }
        r4 = "http://bubble.vip.xunlei.com/service/bubble?request=querybubble&protocol=101&querystr=";	 Catch:{ Exception -> 0x0143 }
        r15.<init>(r4);	 Catch:{ Exception -> 0x0143 }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0143 }
        r4 = "utf-8";	 Catch:{ Exception -> 0x0143 }
        r3 = java.net.URLEncoder.encode(r3, r4);	 Catch:{ Exception -> 0x0143 }
        r15.append(r3);	 Catch:{ Exception -> 0x0143 }
        r15 = r15.toString();	 Catch:{ Exception -> 0x0143 }
        r3 = new com.xunlei.common.net.volley.BaseStringRequest;	 Catch:{ Exception -> 0x0143 }
        r3.<init>(r15, r0, r0);	 Catch:{ Exception -> 0x0143 }
        r3.setShouldCache(r1);	 Catch:{ Exception -> 0x0143 }
        r15 = com.xunlei.common.net.volley.VolleyRequestManager.getMainThreadRequestQueue();	 Catch:{ Exception -> 0x0143 }
        r15.a(r3);	 Catch:{ Exception -> 0x0143 }
        goto L_0x0146;
    L_0x0143:
        r0.a();
    L_0x0146:
        r15 = new java.lang.StringBuilder;
        r0 = "update isSheduled:";
        r15.<init>(r0);
        r0 = com.xunlei.downloadprovider.member.b.a.g.a.a;
        r0 = r0.a;
        r15.append(r0);
        r15 = com.xunlei.downloadprovider.member.b.a.g.a.a;
        r15 = r15.a;
        if (r15 != 0) goto L_0x01c2;
    L_0x015a:
        r15 = com.xunlei.downloadprovider.member.b.a.g.a.a;
        r4 = new com.xunlei.downloadprovider.member.b.a.h;	 Catch:{ Exception -> 0x01c0 }
        r4.<init>(r15);	 Catch:{ Exception -> 0x01c0 }
        r0 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x01c0 }
        r3 = 11;	 Catch:{ Exception -> 0x01c0 }
        r0 = r0.get(r3);	 Catch:{ Exception -> 0x01c0 }
        r0 = 24 - r0;	 Catch:{ Exception -> 0x01c0 }
        r0 = r0 - r2;	 Catch:{ Exception -> 0x01c0 }
        r0 = r0 + 5;	 Catch:{ Exception -> 0x01c0 }
        r3 = java.util.Calendar.getInstance();	 Catch:{ Exception -> 0x01c0 }
        r5 = 12;	 Catch:{ Exception -> 0x01c0 }
        r3 = r3.get(r5);	 Catch:{ Exception -> 0x01c0 }
        r5 = r0 * 60;	 Catch:{ Exception -> 0x01c0 }
        r5 = r5 * 60;	 Catch:{ Exception -> 0x01c0 }
        r6 = 60 - r3;	 Catch:{ Exception -> 0x01c0 }
        r6 = r6 * 60;	 Catch:{ Exception -> 0x01c0 }
        r5 = r5 + r6;	 Catch:{ Exception -> 0x01c0 }
        r5 = (long) r5;	 Catch:{ Exception -> 0x01c0 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01c0 }
        r8 = "hours:";	 Catch:{ Exception -> 0x01c0 }
        r7.<init>(r8);	 Catch:{ Exception -> 0x01c0 }
        r7.append(r0);	 Catch:{ Exception -> 0x01c0 }
        r0 = " minute:";	 Catch:{ Exception -> 0x01c0 }
        r7.append(r0);	 Catch:{ Exception -> 0x01c0 }
        r7.append(r3);	 Catch:{ Exception -> 0x01c0 }
        r0 = " delay:";	 Catch:{ Exception -> 0x01c0 }
        r7.append(r0);	 Catch:{ Exception -> 0x01c0 }
        r7.append(r5);	 Catch:{ Exception -> 0x01c0 }
        r0 = " date:";	 Catch:{ Exception -> 0x01c0 }
        r7.append(r0);	 Catch:{ Exception -> 0x01c0 }
        r8 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x01c0 }
        r10 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x01c0 }
        r10 = r10 * r5;	 Catch:{ Exception -> 0x01c0 }
        r12 = r8 + r10;	 Catch:{ Exception -> 0x01c0 }
        r0 = com.xunlei.common.androidutil.DateTimeUtil.getDateTime(r12);	 Catch:{ Exception -> 0x01c0 }
        r7.append(r0);	 Catch:{ Exception -> 0x01c0 }
        r3 = r15.b;	 Catch:{ Exception -> 0x01c0 }
        r7 = 86400; // 0x15180 float:1.21072E-40 double:4.26873E-319;	 Catch:{ Exception -> 0x01c0 }
        r9 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x01c0 }
        r3.scheduleAtFixedRate(r4, r5, r7, r9);	 Catch:{ Exception -> 0x01c0 }
        r15.a = r2;	 Catch:{ Exception -> 0x01c0 }
        return;
    L_0x01c0:
        r15.a = r1;
    L_0x01c2:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.b.a.d.a(java.lang.String):void");
    }

    public final com.xunlei.downloadprovider.member.b.d b(String str) {
        LoginHelper.a();
        if (l.b()) {
            return a.b(str);
        }
        if (this.a != null) {
            this.a.j();
        }
        return null;
    }

    public final void c(String str) {
        LoginHelper.a();
        if (l.b()) {
            f b = a.b(str);
            if (b != null && SystemClock.elapsedRealtime() - b.a > 43200000) {
                a.c(str);
            }
            if (!a.d(str)) {
                a(str);
            } else if (this.a != null) {
                this.a.i();
                return;
            }
            return;
        }
        if (this.a != null) {
            this.a.j();
        }
    }

    public final void a() {
        a.a();
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        LoginHelper.a();
        if (l.b()) {
            LoginHelper.a().b(this);
            a(this.b);
            this.b = "";
        }
    }
}
