package com.xunlei.downloadprovider.search.b;

import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import java.util.List;
import org.json.JSONObject;

/* compiled from: SearchNetworkHelper */
public class c extends e {
    private static final String b = "c";
    private static c c;
    public List<com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.c> a;
    private j d = j.a();

    /* compiled from: SearchNetworkHelper */
    public interface a {
        void a(String str, List<com.xunlei.downloadprovider.search.a.a> list);
    }

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public final void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new d(this, str, aVar));
        }
    }

    private static java.util.List<com.xunlei.downloadprovider.search.a.a> a(java.lang.String r11, org.json.JSONObject r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r12 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = "list";	 Catch:{ JSONException -> 0x00b6 }
        r12 = r12.getJSONArray(r2);	 Catch:{ JSONException -> 0x00b6 }
        r2 = r12.length();	 Catch:{ JSONException -> 0x00b6 }
        if (r12 == 0) goto L_0x00b5;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0015:
        if (r2 > 0) goto L_0x0019;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0017:
        goto L_0x00b5;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0019:
        r3 = 0;	 Catch:{ JSONException -> 0x00b6 }
        r6 = r0;	 Catch:{ JSONException -> 0x00b6 }
        r4 = r3;	 Catch:{ JSONException -> 0x00b6 }
        r5 = r4;	 Catch:{ JSONException -> 0x00b6 }
    L_0x001d:
        if (r4 >= r2) goto L_0x00a1;	 Catch:{ JSONException -> 0x00b6 }
    L_0x001f:
        r7 = r12.getJSONObject(r4);	 Catch:{ JSONException -> 0x00b6 }
        if (r7 == 0) goto L_0x008b;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0025:
        r8 = new com.xunlei.downloadprovider.search.a.a;	 Catch:{ JSONException -> 0x00b6 }
        r8.<init>();	 Catch:{ JSONException -> 0x00b6 }
        r9 = "movieid";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.a = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "title";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.b = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "cover_url";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.c = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "director";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.d = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "year";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optLong(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.e = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "score";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optDouble(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.f = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "area";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.g = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "description";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.h = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "actor";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.i = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "genres";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optString(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.j = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "type";	 Catch:{ JSONException -> 0x00b6 }
        r9 = r7.optInt(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.k = r9;	 Catch:{ JSONException -> 0x00b6 }
        r9 = "source";	 Catch:{ JSONException -> 0x00b6 }
        r7 = r7.optInt(r9);	 Catch:{ JSONException -> 0x00b6 }
        r8.l = r7;	 Catch:{ JSONException -> 0x00b6 }
        goto L_0x008c;	 Catch:{ JSONException -> 0x00b6 }
    L_0x008b:
        r8 = r0;	 Catch:{ JSONException -> 0x00b6 }
    L_0x008c:
        r7 = r8.b;	 Catch:{ JSONException -> 0x00b6 }
        if (r7 == 0) goto L_0x009a;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0090:
        r7 = r8.b;	 Catch:{ JSONException -> 0x00b6 }
        r7 = r7.equals(r11);	 Catch:{ JSONException -> 0x00b6 }
        if (r7 == 0) goto L_0x009a;	 Catch:{ JSONException -> 0x00b6 }
    L_0x0098:
        r5 = 1;	 Catch:{ JSONException -> 0x00b6 }
        r6 = r8;	 Catch:{ JSONException -> 0x00b6 }
    L_0x009a:
        r1.add(r8);	 Catch:{ JSONException -> 0x00b6 }
        r4 = r4 + 1;	 Catch:{ JSONException -> 0x00b6 }
        goto L_0x001d;	 Catch:{ JSONException -> 0x00b6 }
    L_0x00a1:
        if (r5 != 0) goto L_0x00ae;	 Catch:{ JSONException -> 0x00b6 }
    L_0x00a3:
        r12 = new com.xunlei.downloadprovider.search.a.a;	 Catch:{ JSONException -> 0x00b6 }
        r12.<init>();	 Catch:{ JSONException -> 0x00b6 }
        r12.b = r11;	 Catch:{ JSONException -> 0x00b6 }
        r1.add(r3, r12);	 Catch:{ JSONException -> 0x00b6 }
        goto L_0x00b4;	 Catch:{ JSONException -> 0x00b6 }
    L_0x00ae:
        r1.remove(r6);	 Catch:{ JSONException -> 0x00b6 }
        r1.add(r3, r6);	 Catch:{ JSONException -> 0x00b6 }
    L_0x00b4:
        return r1;
    L_0x00b5:
        return r0;
    L_0x00b6:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.search.b.c.a(java.lang.String, org.json.JSONObject):java.util.List<com.xunlei.downloadprovider.search.a.a>");
    }

    static /* synthetic */ void a(c cVar, String str, JSONObject jSONObject, a aVar) {
        if (jSONObject != null && aVar != null) {
            j(new h(cVar, aVar, str, a(str, jSONObject.optJSONObject("data"))));
        }
    }
}
