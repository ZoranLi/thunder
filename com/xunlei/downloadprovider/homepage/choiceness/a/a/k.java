package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.inter.ITagManager;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessNetworkResponse */
public final class k {
    public List<e> a;
    public long b;
    public long c;
    public long d;
    public String e;
    public VolleyError f;
    public boolean g;
    public JSONObject h;
    private String i;

    public final boolean a() {
        if (TextUtils.isEmpty(this.i)) {
            return false;
        }
        return ITagManager.SUCCESS.endsWith(this.i);
    }

    public static k a(boolean z, JSONObject jSONObject) throws JSONException {
        k kVar = new k();
        kVar.h = jSONObject;
        kVar.i = jSONObject.getString("result");
        kVar.c = jSONObject.optLong("min_id");
        kVar.d = jSONObject.optLong("max_id");
        kVar.e = jSONObject.optString("cursor");
        kVar.b = jSONObject.optLong(MsgConstant.KEY_TS);
        kVar.a = b(z, jSONObject);
        return kVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.xunlei.downloadprovider.homepage.choiceness.a.a.e> b(boolean r8, org.json.JSONObject r9) {
        /*
        r0 = "card_list";
        r9 = r9.optJSONArray(r0);
        r0 = 0;
        if (r9 == 0) goto L_0x011e;
    L_0x0009:
        r1 = r9.length();
        if (r1 <= 0) goto L_0x011e;
    L_0x000f:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r2 = 0;
        r3 = r2;
    L_0x0016:
        r4 = r9.length();
        if (r3 >= r4) goto L_0x011d;
    L_0x001c:
        r4 = r9.getJSONObject(r3);	 Catch:{ JSONException -> 0x0115 }
        r5 = "res_type";
        r5 = r4.getString(r5);	 Catch:{ JSONException -> 0x0115 }
        r6 = com.xunlei.downloadprovider.homepage.choiceness.a.a.e$a.a(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 != 0) goto L_0x002e;
    L_0x002c:
        goto L_0x0119;
    L_0x002e:
        r6 = "short_video";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x003c;
    L_0x0036:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.m.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x003c:
        r6 = "advertisement";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x004a;
    L_0x0044:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.b.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x004a:
        r6 = "live";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x0058;
    L_0x0052:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.i.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x0058:
        r6 = "recommend_user";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x0065;
    L_0x0060:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x0065:
        r6 = "website";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x0072;
    L_0x006d:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.n.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x0072:
        r6 = "website_topic";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x007f;
    L_0x007a:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.o.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x007f:
        r6 = "photo_article";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x008c;
    L_0x0087:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.c.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x008c:
        r6 = "cinecism";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x0099;
    L_0x0094:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.d.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x0099:
        r6 = "live_pool";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x00a6;
    L_0x00a1:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.f.a(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x00bd;
    L_0x00a6:
        r6 = "live_box_left";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 != 0) goto L_0x00b9;
    L_0x00ae:
        r6 = "live_box_right";
        r6 = r6.equals(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r6 == 0) goto L_0x00b7;
    L_0x00b6:
        goto L_0x00b9;
    L_0x00b7:
        r4 = r0;
        goto L_0x00bd;
    L_0x00b9:
        r4 = com.xunlei.downloadprovider.homepage.choiceness.a.a.h.a(r4);	 Catch:{ JSONException -> 0x0115 }
    L_0x00bd:
        if (r4 == 0) goto L_0x0119;
    L_0x00bf:
        r6 = r4.k;	 Catch:{ JSONException -> 0x0115 }
        r6 = com.xunlei.downloadprovider.homepage.choiceness.a.a.e$a.a(r6);	 Catch:{ JSONException -> 0x0115 }
        if (r6 != 0) goto L_0x00d0;
    L_0x00c7:
        r5 = com.xunlei.downloadprovider.homepage.choiceness.a.a.e$a.b(r5);	 Catch:{ JSONException -> 0x0115 }
        if (r5 >= 0) goto L_0x00ce;
    L_0x00cd:
        goto L_0x0119;
    L_0x00ce:
        r4.k = r5;	 Catch:{ JSONException -> 0x0115 }
    L_0x00d0:
        if (r8 == 0) goto L_0x0111;
    L_0x00d2:
        r5 = r4.d();	 Catch:{ JSONException -> 0x0115 }
        r6 = 1;
        if (r5 != 0) goto L_0x010d;
    L_0x00d9:
        r5 = r4.g();	 Catch:{ JSONException -> 0x0115 }
        if (r5 != 0) goto L_0x010d;
    L_0x00df:
        r5 = "live_pool";
        r7 = r4.l;	 Catch:{ JSONException -> 0x0115 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0115 }
        if (r5 != 0) goto L_0x0100;
    L_0x00e9:
        r5 = "live_box_right";
        r7 = r4.l;	 Catch:{ JSONException -> 0x0115 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0115 }
        if (r5 != 0) goto L_0x0100;
    L_0x00f3:
        r5 = "live_box_left";
        r7 = r4.l;	 Catch:{ JSONException -> 0x0115 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0115 }
        if (r5 == 0) goto L_0x00fe;
    L_0x00fd:
        goto L_0x0100;
    L_0x00fe:
        r5 = r2;
        goto L_0x0101;
    L_0x0100:
        r5 = r6;
    L_0x0101:
        if (r5 != 0) goto L_0x010d;
    L_0x0103:
        r5 = "recommend_user";
        r7 = r4.l;	 Catch:{ JSONException -> 0x0115 }
        r5 = r5.equals(r7);	 Catch:{ JSONException -> 0x0115 }
        if (r5 == 0) goto L_0x010e;
    L_0x010d:
        r6 = r2;
    L_0x010e:
        if (r6 != 0) goto L_0x0111;
    L_0x0110:
        goto L_0x0119;
    L_0x0111:
        r1.add(r4);	 Catch:{ JSONException -> 0x0115 }
        goto L_0x0119;
    L_0x0115:
        r4 = move-exception;
        r4.printStackTrace();
    L_0x0119:
        r3 = r3 + 1;
        goto L_0x0016;
    L_0x011d:
        return r1;
    L_0x011e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.a.a.k.b(boolean, org.json.JSONObject):java.util.List<com.xunlei.downloadprovider.homepage.choiceness.a.a.e>");
    }
}
