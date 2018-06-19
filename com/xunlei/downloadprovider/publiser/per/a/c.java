package com.xunlei.downloadprovider.publiser.per.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: PublishNetworkHelper */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r11 = (org.json.JSONObject) r11;
        com.xunlei.downloadprovider.publiser.per.a.a.a;
        r0 = new java.lang.StringBuilder;
        r1 = "getPublishList response =>";
        r0.<init>(r1);
        r0.append(r11);
        r0 = "result";
        r0 = r11.optString(r0);
        r1 = "ok";
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 == 0) goto L_0x009e;
    L_0x001d:
        r0 = "pub_video_count";
        r1 = 0;
        r0 = r11.optInt(r0, r1);
        r2 = "publish_list";
        r11 = r11.optJSONArray(r2);
        r2 = 0;
        if (r11 == 0) goto L_0x0092;
    L_0x002d:
        r2 = r11.length();
        r3 = new java.util.ArrayList;
        r3.<init>(r2);
        r4 = r10.a;
        r4 = r4.a;
        r6 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r6 = r6.g;
        r6 = r6.c();
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        r4 = 1;
        if (r8 != 0) goto L_0x004b;
    L_0x0049:
        r5 = r4;
        goto L_0x004c;
    L_0x004b:
        r5 = r1;
    L_0x004c:
        r6 = r1;
    L_0x004d:
        if (r6 >= r2) goto L_0x0091;
    L_0x004f:
        r7 = r11.optJSONObject(r6);	 Catch:{ JSONException -> 0x008b }
        r7 = com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo.parsePublishInfoFrom(r7);	 Catch:{ JSONException -> 0x008b }
        r8 = "pub_video";	 Catch:{ JSONException -> 0x008b }
        r9 = r7.getType();	 Catch:{ JSONException -> 0x008b }
        r8 = r8.equals(r9);	 Catch:{ JSONException -> 0x008b }
        if (r8 == 0) goto L_0x007e;	 Catch:{ JSONException -> 0x008b }
    L_0x0063:
        r8 = r7.getData();	 Catch:{ JSONException -> 0x008b }
        r8 = (com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo) r8;	 Catch:{ JSONException -> 0x008b }
        r8 = r8.getRelatedVideoInfo();	 Catch:{ JSONException -> 0x008b }
        r8 = r8.getStatus();	 Catch:{ JSONException -> 0x008b }
        if (r5 != 0) goto L_0x0076;	 Catch:{ JSONException -> 0x008b }
    L_0x0073:
        if (r8 == r4) goto L_0x007e;	 Catch:{ JSONException -> 0x008b }
    L_0x0075:
        goto L_0x007c;	 Catch:{ JSONException -> 0x008b }
    L_0x0076:
        r9 = 2;	 Catch:{ JSONException -> 0x008b }
        if (r8 == r9) goto L_0x007c;	 Catch:{ JSONException -> 0x008b }
    L_0x0079:
        r9 = -2;	 Catch:{ JSONException -> 0x008b }
        if (r8 != r9) goto L_0x007e;	 Catch:{ JSONException -> 0x008b }
    L_0x007c:
        r8 = r1;	 Catch:{ JSONException -> 0x008b }
        goto L_0x007f;	 Catch:{ JSONException -> 0x008b }
    L_0x007e:
        r8 = r4;	 Catch:{ JSONException -> 0x008b }
    L_0x007f:
        r9 = r7.getData();	 Catch:{ JSONException -> 0x008b }
        if (r9 == 0) goto L_0x008e;	 Catch:{ JSONException -> 0x008b }
    L_0x0085:
        if (r8 == 0) goto L_0x008e;	 Catch:{ JSONException -> 0x008b }
    L_0x0087:
        r3.add(r7);	 Catch:{ JSONException -> 0x008b }
        goto L_0x008e;
    L_0x008b:
        com.xunlei.downloadprovider.publiser.per.a.a.a;
    L_0x008e:
        r6 = r6 + 1;
        goto L_0x004d;
    L_0x0091:
        r2 = r3;
    L_0x0092:
        r11 = r10.a;
        r11 = r11.d;
        r0 = java.lang.Integer.valueOf(r0);
        r11.a(r0, r2);
        return;
    L_0x009e:
        r11 = r10.a;
        r11 = r11.d;
        r11.a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.per.a.c.onResponse(java.lang.Object):void");
    }
}
