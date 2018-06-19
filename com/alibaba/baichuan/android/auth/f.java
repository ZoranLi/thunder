package com.alibaba.baichuan.android.auth;

import android.text.TextUtils;
import org.json.JSONObject;

public final class f {
    String a;
    private long b;
    private long c;

    private static class a {
        public static f a = new f();
    }

    private String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("AuthToken", this.a);
            jSONObject.put("TokenExpires", this.b);
            jSONObject.put("RefreshTime", this.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private f() {
        this.a = "";
        this.b = -1;
        this.c = -1;
        Object a = com.alibaba.baichuan.android.trade.utils.d.a.a("BC_AuthToken");
        String str = null;
        JSONObject a2 = com.alibaba.baichuan.android.trade.utils.f.a.a(!TextUtils.isEmpty(a) ? com.alibaba.baichuan.android.trade.adapter.d.a.a().b(a) : null);
        if (a2 != null) {
            String str2 = "AuthToken";
            if (a2.has(str2)) {
                str = a2.optString(str2);
            }
            this.a = str;
            this.b = com.alibaba.baichuan.android.trade.utils.f.a.a(a2, "TokenExpires").longValue();
            this.c = com.alibaba.baichuan.android.trade.utils.f.a.a(a2, "RefreshTime").longValue();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r5, long r6) {
        /*
        r4 = this;
        monitor-enter(r4);
        com.alibaba.baichuan.android.trade.utils.g.a.b();	 Catch:{ all -> 0x0044 }
        r4.a = r5;	 Catch:{ all -> 0x0044 }
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0044 }
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 * r2;
        r2 = r0 + r6;
        r4.b = r2;	 Catch:{ all -> 0x0044 }
        r5 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0044 }
        r4.c = r5;	 Catch:{ all -> 0x0044 }
        r5 = "BC_AuthToken";
        r6 = com.alibaba.baichuan.android.auth.f.a.a;	 Catch:{ all -> 0x0044 }
        r6 = r6.a();	 Catch:{ all -> 0x0044 }
        r7 = com.alibaba.baichuan.android.trade.adapter.d.a.a();	 Catch:{ all -> 0x0044 }
        r6 = r7.a(r6);	 Catch:{ all -> 0x0044 }
        r7 = android.text.TextUtils.isEmpty(r5);	 Catch:{ all -> 0x0044 }
        if (r7 != 0) goto L_0x0042;
    L_0x002d:
        if (r6 != 0) goto L_0x0030;
    L_0x002f:
        goto L_0x0042;
    L_0x0030:
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x0044 }
        r7.<init>();	 Catch:{ all -> 0x0044 }
        r0 = new com.alibaba.baichuan.android.trade.utils.d.a$a;	 Catch:{ all -> 0x0044 }
        r0.<init>(r5, r6);	 Catch:{ all -> 0x0044 }
        r7.add(r0);	 Catch:{ all -> 0x0044 }
        com.alibaba.baichuan.android.trade.utils.d.a.a(r7);	 Catch:{ all -> 0x0044 }
        monitor-exit(r4);
        return;
    L_0x0042:
        monitor-exit(r4);
        return;
    L_0x0044:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.auth.f.a(java.lang.String, long):void");
    }
}
