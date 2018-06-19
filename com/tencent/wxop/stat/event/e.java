package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.au;
import com.tencent.wxop.stat.common.a;
import com.tencent.wxop.stat.common.l;
import org.json.JSONObject;

public abstract class e {
    protected static String j;
    private StatSpecifyReportedInfo a = null;
    protected String b = null;
    protected long c;
    protected int d;
    protected a e = null;
    protected int f;
    protected String g = null;
    protected String h = null;
    protected String i = null;
    protected boolean k = false;
    protected Context l;

    e(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.l = context;
        this.c = System.currentTimeMillis() / 1000;
        this.d = i;
        this.h = StatConfig.getInstallChannel(context);
        this.i = l.h(context);
        this.b = StatConfig.getAppKey(context);
        if (statSpecifyReportedInfo != null) {
            this.a = statSpecifyReportedInfo;
            if (l.c(statSpecifyReportedInfo.getAppKey())) {
                this.b = statSpecifyReportedInfo.getAppKey();
            }
            if (l.c(statSpecifyReportedInfo.getInstallChannel())) {
                this.h = statSpecifyReportedInfo.getInstallChannel();
            }
            if (l.c(statSpecifyReportedInfo.getVersion())) {
                this.i = statSpecifyReportedInfo.getVersion();
            }
            this.k = statSpecifyReportedInfo.isImportant();
        }
        this.g = StatConfig.getCustomUserId(context);
        this.e = au.a(context).b(context);
        this.f = a() != EventType.NETWORK_DETECTOR ? l.q(context).intValue() : -EventType.NETWORK_DETECTOR.a();
        if (!h.c(j)) {
            String localMidOnly = StatConfig.getLocalMidOnly(context);
            j = localMidOnly;
            if (!l.c(localMidOnly)) {
                j = "0";
            }
        }
    }

    public abstract EventType a();

    public abstract boolean a(JSONObject jSONObject);

    public boolean b(org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = "ky";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.b;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "et";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.a();	 Catch:{ Throwable -> 0x00a3 }
        r2 = r2.a();	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = r4.e;	 Catch:{ Throwable -> 0x00a3 }
        r2 = 1;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == 0) goto L_0x004a;	 Catch:{ Throwable -> 0x00a3 }
    L_0x001a:
        r1 = "ui";	 Catch:{ Throwable -> 0x00a3 }
        r3 = r4.e;	 Catch:{ Throwable -> 0x00a3 }
        r3 = r3.b();	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r3);	 Catch:{ Throwable -> 0x00a3 }
        r1 = r4.e;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r1.c();	 Catch:{ Throwable -> 0x00a3 }
        r3 = "mc";	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r3, r1);	 Catch:{ Throwable -> 0x00a3 }
        r1 = r4.e;	 Catch:{ Throwable -> 0x00a3 }
        r1 = r1.d();	 Catch:{ Throwable -> 0x00a3 }
        r3 = "ut";	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r3, r1);	 Catch:{ Throwable -> 0x00a3 }
        if (r1 != 0) goto L_0x004a;	 Catch:{ Throwable -> 0x00a3 }
    L_0x003d:
        r1 = r4.l;	 Catch:{ Throwable -> 0x00a3 }
        r1 = com.tencent.wxop.stat.common.l.u(r1);	 Catch:{ Throwable -> 0x00a3 }
        if (r1 != r2) goto L_0x004a;	 Catch:{ Throwable -> 0x00a3 }
    L_0x0045:
        r1 = "ia";	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
    L_0x004a:
        r1 = "cui";	 Catch:{ Throwable -> 0x00a3 }
        r3 = r4.g;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r1, r3);	 Catch:{ Throwable -> 0x00a3 }
        r1 = r4.a();	 Catch:{ Throwable -> 0x00a3 }
        r3 = com.tencent.wxop.stat.event.EventType.SESSION_ENV;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == r3) goto L_0x0067;	 Catch:{ Throwable -> 0x00a3 }
    L_0x0059:
        r1 = "av";	 Catch:{ Throwable -> 0x00a3 }
        r3 = r4.i;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r1, r3);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "ch";	 Catch:{ Throwable -> 0x00a3 }
        r3 = r4.h;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r1, r3);	 Catch:{ Throwable -> 0x00a3 }
    L_0x0067:
        r1 = r4.k;	 Catch:{ Throwable -> 0x00a3 }
        if (r1 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x00a3 }
    L_0x006b:
        r1 = "impt";	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
    L_0x0070:
        r1 = "mid";	 Catch:{ Throwable -> 0x00a3 }
        r2 = j;	 Catch:{ Throwable -> 0x00a3 }
        com.tencent.wxop.stat.common.r.a(r5, r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "cch";	 Catch:{ Throwable -> 0x00a3 }
        r2 = "wxop";	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "idx";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.f;	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "si";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.d;	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "ts";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.c;	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r1 = "dts";	 Catch:{ Throwable -> 0x00a3 }
        r2 = r4.l;	 Catch:{ Throwable -> 0x00a3 }
        r2 = com.tencent.wxop.stat.common.l.a(r2, r0);	 Catch:{ Throwable -> 0x00a3 }
        r5.put(r1, r2);	 Catch:{ Throwable -> 0x00a3 }
        r5 = r4.a(r5);	 Catch:{ Throwable -> 0x00a3 }
        return r5;
    L_0x00a3:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.event.e.b(org.json.JSONObject):boolean");
    }

    public long c() {
        return this.c;
    }

    public StatSpecifyReportedInfo d() {
        return this.a;
    }

    public Context e() {
        return this.l;
    }

    public boolean f() {
        return this.k;
    }

    public java.lang.String g() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x000d }
        r0.<init>();	 Catch:{ Throwable -> 0x000d }
        r1.b(r0);	 Catch:{ Throwable -> 0x000d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x000d }
        return r0;
    L_0x000d:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.event.e.g():java.lang.String");
    }
}
