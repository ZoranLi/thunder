package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: VisitorNetworkHelper */
final class x implements b<JSONObject> {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r12 = (org.json.JSONObject) r12;
        r0 = new java.lang.StringBuilder;
        r1 = "getVisitorList response=>";
        r0.<init>(r1);
        r0.append(r12);
        r0 = "result";
        r0 = r12.optString(r0);
        r1 = "ok";
        r0 = r1.equals(r0);
        if (r0 != 0) goto L_0x0032;
    L_0x001a:
        r0 = new java.lang.StringBuilder;
        r1 = "getVisitorList failed,error=>";
        r0.<init>(r1);
        r1 = "info";
        r12 = r12.optString(r1);
        r0.append(r12);
        r12 = r11.a;
        r12 = r12.d;
        r12.a();
        return;
    L_0x0032:
        r0 = "data";
        r12 = r12.optJSONObject(r0);
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        r3 = 0;
        if (r12 == 0) goto L_0x00d0;
    L_0x0042:
        r1 = "cursor";
        r1 = r12.optLong(r1);
        r4 = "lists";
        r12 = r12.optJSONArray(r4);
        if (r12 == 0) goto L_0x00d0;
    L_0x0050:
        r4 = r12.length();
    L_0x0054:
        if (r3 >= r4) goto L_0x00cf;
    L_0x0056:
        r5 = r12.optJSONObject(r3);	 Catch:{ JSONException -> 0x00cc }
        r6 = new com.xunlei.downloadprovider.publiser.visitors.model.b;	 Catch:{ JSONException -> 0x00cc }
        r6.<init>();	 Catch:{ JSONException -> 0x00cc }
        r7 = "gcid";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.a = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "entrance";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optInt(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.b = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "m_id";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.c = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "src_id";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.d = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "video_id";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.e = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "visit_time";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optLong(r7);	 Catch:{ JSONException -> 0x00cc }
        r9 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x00cc }
        r7 = r7 * r9;	 Catch:{ JSONException -> 0x00cc }
        r6.f = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "visitor_uid";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.getLong(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.g = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "content";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optString(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.h = r7;	 Catch:{ JSONException -> 0x00cc }
        r7 = "urls";	 Catch:{ JSONException -> 0x00cc }
        r7 = r5.optJSONObject(r7);	 Catch:{ JSONException -> 0x00cc }
        if (r7 == 0) goto L_0x00b0;	 Catch:{ JSONException -> 0x00cc }
    L_0x00aa:
        r7 = com.xunlei.downloadprovider.publiser.visitors.model.b.a.a(r7);	 Catch:{ JSONException -> 0x00cc }
        r6.i = r7;	 Catch:{ JSONException -> 0x00cc }
    L_0x00b0:
        r7 = "visitor_info";	 Catch:{ JSONException -> 0x00cc }
        r5 = r5.getJSONObject(r7);	 Catch:{ JSONException -> 0x00cc }
        if (r5 == 0) goto L_0x00be;	 Catch:{ JSONException -> 0x00cc }
    L_0x00b8:
        r5 = com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo.parseFrom(r5);	 Catch:{ JSONException -> 0x00cc }
        r6.j = r5;	 Catch:{ JSONException -> 0x00cc }
    L_0x00be:
        r7 = r6.g;	 Catch:{ JSONException -> 0x00cc }
        r5 = r11.a;	 Catch:{ JSONException -> 0x00cc }
        r9 = r5.a;	 Catch:{ JSONException -> 0x00cc }
        r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1));	 Catch:{ JSONException -> 0x00cc }
        if (r5 != 0) goto L_0x00c9;	 Catch:{ JSONException -> 0x00cc }
    L_0x00c8:
        goto L_0x00cc;	 Catch:{ JSONException -> 0x00cc }
    L_0x00c9:
        r0.add(r6);	 Catch:{ JSONException -> 0x00cc }
    L_0x00cc:
        r3 = r3 + 1;
        goto L_0x0054;
    L_0x00cf:
        r3 = r4;
    L_0x00d0:
        r12 = com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.j.b();
        r4 = com.xunlei.downloadprovider.personal.message.MessageActivty.MessageType.VISIT;
        r12.a(r4);
        r12 = r11.a;
        r12 = r12.d;
        r3 = java.lang.Integer.valueOf(r3);
        r1 = java.lang.Long.valueOf(r1);
        r12.a(r0, r3, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.common.x.onResponse(java.lang.Object):void");
    }
}
