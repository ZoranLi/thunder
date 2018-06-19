package com.xunlei.downloadprovider.download.giftdispatch.utils;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GiftDispatchingDataManager */
public class a {
    private static final String b = "a";
    private static a c;
    public a a;

    /* compiled from: GiftDispatchingDataManager */
    public interface a {
        void a();

        void a(List<com.xunlei.downloadprovider.download.giftdispatch.a.a> list);

        void b();
    }

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }

    public final void a(JSONArray jSONArray) {
        XLThreadPool.execute(new b(this, jSONArray));
    }

    private static JSONObject c(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uid", LoginHelper.a().g.c());
            LoginHelper.a();
            if (l.b()) {
                jSONObject.put("sessionid", LoginHelper.a().c());
            } else {
                jSONObject.remove("sessionid");
            }
            jSONObject.put("gifts", jSONArray);
        } catch (JSONArray jSONArray2) {
            jSONArray2.printStackTrace();
        }
        return jSONObject;
    }

    private void c() {
        if (this.a != null) {
            this.a.a();
        }
    }

    static /* synthetic */ void a(com.xunlei.downloadprovider.download.giftdispatch.utils.a r8, org.json.JSONObject r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r9 == 0) goto L_0x00dd;
    L_0x0002:
        r0 = "ok";
        r1 = "result";
        r1 = r9.opt(r1);
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x00dd;
    L_0x0012:
        r0 = "give_out";
        r0 = r9.optInt(r0);
        r1 = 1;
        if (r0 != r1) goto L_0x0025;
    L_0x001b:
        r9 = r8.a;
        if (r9 == 0) goto L_0x0024;
    L_0x001f:
        r8 = r8.a;
        r8.b();
    L_0x0024:
        return;
    L_0x0025:
        r0 = "gifts";
        r9 = r9.optJSONArray(r0);
        if (r9 == 0) goto L_0x00d9;
    L_0x002d:
        r0 = r9.length();
        if (r0 > 0) goto L_0x0035;
    L_0x0033:
        goto L_0x00d9;
    L_0x0035:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r2 = r9.length();
        r3 = 0;
        r4 = r3;
    L_0x0040:
        if (r4 >= r2) goto L_0x00cf;
    L_0x0042:
        r5 = r9.getJSONObject(r4);	 Catch:{ JSONException -> 0x00c8 }
        r6 = new com.xunlei.downloadprovider.download.giftdispatch.a.a;	 Catch:{ JSONException -> 0x00c8 }
        r6.<init>();	 Catch:{ JSONException -> 0x00c8 }
        r7 = "id";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.a = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_poster";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.b = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "jump_page";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.c = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "redpack_type";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.d = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "method";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.e = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "expir_time";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.f = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "code";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.g = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_content";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.h = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_title";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.i = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_dispatch_btn_text";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.j = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_dispatch_btn_usage";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.k = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "support_end";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.l = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "gift_type";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.m = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = r2 + -1;	 Catch:{ JSONException -> 0x00c8 }
        if (r4 == r7) goto L_0x00b9;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00b7:
        r7 = r1;	 Catch:{ JSONException -> 0x00c8 }
        goto L_0x00ba;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00b9:
        r7 = r3;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00ba:
        r6.n = r7;	 Catch:{ JSONException -> 0x00c8 }
        r7 = "kuainiao_extra";	 Catch:{ JSONException -> 0x00c8 }
        r5 = r5.optString(r7);	 Catch:{ JSONException -> 0x00c8 }
        r6.o = r5;	 Catch:{ JSONException -> 0x00c8 }
        r0.add(r6);	 Catch:{ JSONException -> 0x00c8 }
        goto L_0x00cb;
    L_0x00c8:
        r8.c();
    L_0x00cb:
        r4 = r4 + 1;
        goto L_0x0040;
    L_0x00cf:
        r9 = r8.a;
        if (r9 == 0) goto L_0x00d8;
    L_0x00d3:
        r8 = r8.a;
        r8.a(r0);
    L_0x00d8:
        return;
    L_0x00d9:
        r8.c();
        return;
    L_0x00dd:
        r8.c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.giftdispatch.utils.a.a(com.xunlei.downloadprovider.download.giftdispatch.utils.a, org.json.JSONObject):void");
    }
}
