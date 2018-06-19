package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e.c;
import java.util.List;
import org.json.JSONArray;

/* compiled from: FollowNetworkHelper */
final class w implements Runnable {
    final /* synthetic */ JSONArray a;
    final /* synthetic */ c b;
    final /* synthetic */ List c;
    final /* synthetic */ a d;

    w(a aVar, JSONArray jSONArray, c cVar, List list) {
        this.d = aVar;
        this.a = jSONArray;
        this.b = cVar;
        this.c = list;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r3 = new org.json.JSONObject;
        r3.<init>();
        r0 = "uid_list";	 Catch:{ JSONException -> 0x002c }
        r1 = r8.a;	 Catch:{ JSONException -> 0x002c }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x002c }
        r0 = "model";	 Catch:{ JSONException -> 0x002c }
        r1 = android.os.Build.MODEL;	 Catch:{ JSONException -> 0x002c }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x002c }
        r6 = r8.d;	 Catch:{ JSONException -> 0x002c }
        r7 = new com.xunlei.downloadprovider.homepage.follow.c.ar;	 Catch:{ JSONException -> 0x002c }
        r1 = 1;	 Catch:{ JSONException -> 0x002c }
        r2 = "http://api-shoulei-ssl.xunlei.com/follow/follow_batch";	 Catch:{ JSONException -> 0x002c }
        r4 = new com.xunlei.downloadprovider.homepage.follow.c.x;	 Catch:{ JSONException -> 0x002c }
        r4.<init>(r8);	 Catch:{ JSONException -> 0x002c }
        r5 = new com.xunlei.downloadprovider.homepage.follow.c.y;	 Catch:{ JSONException -> 0x002c }
        r5.<init>(r8);	 Catch:{ JSONException -> 0x002c }
        r0 = r7;	 Catch:{ JSONException -> 0x002c }
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ JSONException -> 0x002c }
        r6.a(r7);	 Catch:{ JSONException -> 0x002c }
        return;
    L_0x002c:
        r0 = r8.b;
        r1 = "JSONException";
        r0.onFail(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.follow.c.w.run():void");
    }
}
