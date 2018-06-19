package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b;

import com.android.volley.VolleyError;
import com.android.volley.l;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import java.util.ArrayList;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RedEnvelopesManager */
public final class a {
    private static a c;
    final l a = VolleyRequestManager.getMainThreadRequestQueue();
    String b;

    /* compiled from: RedEnvelopesManager */
    public interface a {
        void a(VolleyError volleyError);

        void a(List<e> list, String str, int i);
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            c = new a();
        }
        return c;
    }

    public final void a(a aVar, int i) {
        XLThreadPool.execute(new b(this, i, aVar));
    }

    public static List<e> a(JSONArray jSONArray) {
        JSONArray jSONArray2 = jSONArray;
        e eVar = null;
        if (jSONArray2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        new StringBuilder("jsonArray.length() == ").append(jSONArray.length());
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                List list;
                int i2;
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (jSONObject == null) {
                    list = arrayList;
                    i2 = i;
                } else {
                    e eVar2 = new e();
                    int optInt = jSONObject.optInt(AgooConstants.MESSAGE_ID);
                    String optString = jSONObject.optString("gift_title");
                    int optInt2 = jSONObject.optInt("gift_get_time");
                    String optString2 = jSONObject.optString("gift_poster");
                    int optInt3 = jSONObject.optInt("gift_status");
                    int optInt4 = jSONObject.optInt("redpack_type");
                    int optInt5 = jSONObject.optInt("gift_type");
                    long optLong = jSONObject.optLong("server_time");
                    long optLong2 = jSONObject.optLong("expir_time");
                    i2 = i;
                    String optString3 = jSONObject.optString("code");
                    ArrayList arrayList2 = arrayList;
                    String optString4 = jSONObject.optString("jump_page");
                    String str = optString3;
                    long optLong3 = jSONObject.optLong("game_size");
                    String optString5 = jSONObject.optString("gift_content");
                    String optString6 = jSONObject.optString("detail_page_button");
                    i = jSONObject.optInt("gift_usage");
                    eVar2.a = optInt;
                    eVar2.b = optString;
                    eVar2.c = optInt2;
                    eVar2.d = optString2;
                    eVar2.e = optInt3;
                    eVar2.h = optLong;
                    eVar2.i = optLong2;
                    eVar2.f = optInt4;
                    eVar2.g = optInt5;
                    eVar2.j = str;
                    eVar2.k = optString4;
                    eVar2.l = optLong3;
                    eVar2.m = optString5;
                    eVar2.n = optString6;
                    eVar2.o = i;
                    eVar = eVar2;
                    list = arrayList2;
                }
                list.add(eVar);
                new StringBuilder("redEnvelopesModel == ").append(eVar.toString());
                i = i2 + 1;
                List list2 = list;
                jSONArray2 = jSONArray;
                eVar = null;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return arrayList;
    }
}
