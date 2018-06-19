package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail.a;

import com.android.volley.n.b;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: RedDetailManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        c cVar;
        if (jSONObject != null) {
            e eVar = null;
            if (jSONObject != null) {
                e eVar2 = new e();
                String optString = jSONObject.optString("result");
                jSONObject = jSONObject.optJSONObject("info");
                if (jSONObject != null) {
                    long optLong = jSONObject.optLong("gift_get_time");
                    String optString2 = jSONObject.optString("gift_poster");
                    String optString3 = jSONObject.optString("code");
                    String optString4 = jSONObject.optString("jump_page");
                    int optInt = jSONObject.optInt("redpack_type");
                    long optLong2 = jSONObject.optLong("start_time");
                    long optLong3 = jSONObject.optLong("expir_time");
                    String optString5 = jSONObject.optString("method");
                    String optString6 = jSONObject.optString("gift_content");
                    String optString7 = jSONObject.optString("gift_title");
                    long j = optLong3;
                    int optInt2 = jSONObject.optInt("support_end");
                    int optInt3 = jSONObject.optInt("gift_type");
                    long j2 = optLong2;
                    int optInt4 = jSONObject.optInt("gift_status");
                    int i = optInt2;
                    long optLong4 = jSONObject.optLong("server_time");
                    int optInt5 = jSONObject.optInt(AgooConstants.MESSAGE_ID);
                    String str = optString3;
                    String str2 = optString4;
                    long optLong5 = jSONObject.optLong("game_size");
                    String optString8 = jSONObject.optString("detail_page_pic");
                    String optString9 = jSONObject.optString("detail_page_button");
                    int optInt6 = jSONObject.optInt("gift_usage");
                    eVar2.a = optString;
                    eVar2.b = optInt5;
                    eVar2.c = optString7;
                    eVar2.d = optString2;
                    eVar2.e = optInt4;
                    eVar2.d = optString2;
                    eVar2.f = optLong;
                    eVar2.g = optInt3;
                    eVar2.h = optString6;
                    eVar2.i = optString5;
                    eVar2.j = optLong5;
                    eVar2.k = str2;
                    eVar2.l = str;
                    eVar2.m = optInt;
                    eVar2.n = i;
                    eVar2.o = optLong4;
                    eVar2.p = j2;
                    eVar2.q = j;
                    eVar2.r = optString8;
                    eVar2.s = optString9;
                    eVar2.t = optInt6;
                    cVar = this;
                    eVar = eVar2;
                    cVar.a.b.a(eVar);
                    return;
                }
            }
            cVar = this;
            cVar.a.b.a(eVar);
            return;
        }
        cVar = this;
    }
}
