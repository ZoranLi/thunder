package com.xunlei.downloadprovider.homepage.redpacket.a;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: RequestRedPacketProfit */
public final class k extends e {

    /* compiled from: RequestRedPacketProfit */
    private static class a {
        private static k a = new k();
    }

    private k() {
    }

    public static k a() {
        return a.a;
    }

    public final void a(int i, String str, String str2, c<c> cVar) {
        XLThreadPool.execute(new l(this, cVar, i, str, str2));
    }

    private static org.json.JSONObject b(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = android.text.TextUtils.isEmpty(r2);
        if (r1 == 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r1 = "video_id";	 Catch:{ JSONException -> 0x0011 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0011 }
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.redpacket.a.k.b(java.lang.String):org.json.JSONObject");
    }
}
