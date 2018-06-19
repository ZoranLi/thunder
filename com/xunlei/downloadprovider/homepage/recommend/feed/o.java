package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeedNetworkResponse */
public final class o {
    public List<y> a = new ArrayList();
    private String b;
    private boolean c;
    private String d;

    public final boolean a() {
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        return ITagManager.SUCCESS.endsWith(this.b);
    }

    public static com.xunlei.downloadprovider.homepage.recommend.feed.o a(boolean r5, org.json.JSONObject r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xunlei.downloadprovider.homepage.recommend.feed.o;
        r0.<init>();
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r5 = "fail";
        r0.b = r5;
        return r0;
    L_0x000c:
        r1 = "result";	 Catch:{ JSONException -> 0x006c }
        r1 = r6.getString(r1);	 Catch:{ JSONException -> 0x006c }
        r0.b = r1;	 Catch:{ JSONException -> 0x006c }
        r1 = "params";	 Catch:{ JSONException -> 0x006c }
        r1 = r6.optString(r1);	 Catch:{ JSONException -> 0x006c }
        r0.d = r1;	 Catch:{ JSONException -> 0x006c }
        r1 = "is_more";	 Catch:{ JSONException -> 0x006c }
        r1 = r6.optBoolean(r1);	 Catch:{ JSONException -> 0x006c }
        r0.c = r1;	 Catch:{ JSONException -> 0x006c }
        r1 = "list";	 Catch:{ JSONException -> 0x006c }
        r6 = r6.optJSONArray(r1);	 Catch:{ JSONException -> 0x006c }
        if (r6 == 0) goto L_0x006b;	 Catch:{ JSONException -> 0x006c }
    L_0x002c:
        r1 = r6.length();	 Catch:{ JSONException -> 0x006c }
        if (r1 <= 0) goto L_0x006b;	 Catch:{ JSONException -> 0x006c }
    L_0x0032:
        r1 = 0;	 Catch:{ JSONException -> 0x006c }
        r2 = r1;	 Catch:{ JSONException -> 0x006c }
    L_0x0034:
        r3 = r6.length();	 Catch:{ JSONException -> 0x006c }
        if (r2 >= r3) goto L_0x006b;	 Catch:{ JSONException -> 0x006c }
    L_0x003a:
        r3 = r6.getJSONObject(r2);	 Catch:{ JSONException -> 0x006c }
        r3 = com.xunlei.downloadprovider.homepage.recommend.feed.y.a(r3);	 Catch:{ JSONException -> 0x006c }
        if (r3 == 0) goto L_0x0068;	 Catch:{ JSONException -> 0x006c }
    L_0x0044:
        if (r5 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x006c }
    L_0x0046:
        r4 = r3.c();	 Catch:{ JSONException -> 0x006c }
        if (r4 == 0) goto L_0x0053;	 Catch:{ JSONException -> 0x006c }
    L_0x004c:
        r3 = com.xunlei.downloadprovider.ad.feedvideo.a.b();	 Catch:{ JSONException -> 0x006c }
        r3.j = r1;	 Catch:{ JSONException -> 0x006c }
        goto L_0x0068;	 Catch:{ JSONException -> 0x006c }
    L_0x0053:
        r4 = r3.c();	 Catch:{ JSONException -> 0x006c }
        if (r4 == 0) goto L_0x0063;	 Catch:{ JSONException -> 0x006c }
    L_0x0059:
        r4 = com.xunlei.downloadprovider.ad.feedvideo.a.b();	 Catch:{ JSONException -> 0x006c }
        r4 = r4.a(r3);	 Catch:{ JSONException -> 0x006c }
        if (r4 == 0) goto L_0x0068;	 Catch:{ JSONException -> 0x006c }
    L_0x0063:
        r4 = r0.a;	 Catch:{ JSONException -> 0x006c }
        r4.add(r3);	 Catch:{ JSONException -> 0x006c }
    L_0x0068:
        r2 = r2 + 1;
        goto L_0x0034;
    L_0x006b:
        return r0;
    L_0x006c:
        r5 = "fail";
        r0.b = r5;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.feed.o.a(boolean, org.json.JSONObject):com.xunlei.downloadprovider.homepage.recommend.feed.o");
    }
}
