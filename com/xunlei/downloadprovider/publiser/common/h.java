package com.xunlei.downloadprovider.publiser.common;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.g.a.a;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* compiled from: PublisherDataNetworkHelper */
public final class h extends e {
    private a a = a.a();

    public final void a(long j, c<PublisherInfo> cVar) {
        StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/user_info/info?uid=");
        stringBuilder.append(j);
        stringBuilder.append("&timestamp=");
        stringBuilder.append(System.currentTimeMillis());
        XLThreadPool.execute(new i(this, stringBuilder.toString(), j, cVar));
    }

    public final void a(String str, String str2, c<Boolean> cVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AgooConstants.MESSAGE_ID, str);
            jSONObject.put("gcid", str2);
        } catch (String str22) {
            str22.printStackTrace();
        }
        new StringBuilder("deleteVideo body=>").append(jSONObject);
        XLThreadPool.execute(new l(this, jSONObject, cVar, str));
    }
}
