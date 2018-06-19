package com.xunlei.downloadprovider.homepage.redpacket.a;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.android.volley.AuthFailureError;
import com.android.volley.n.b;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RedPacketBaseRequest */
public final class a extends ar {
    public a(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        super(i, str, jSONObject, bVar, aVar);
    }

    public a(int i, String str, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        super(i, str, bVar, aVar);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.put("Account-Id", "40");
        headers.put("App-Type", DispatchConstants.ANDROID);
        headers.put("Peer-Id", AndroidConfig.getHubbleDeviceGUID());
        headers.put("User-Id", String.valueOf(LoginHelper.a().g.c()));
        headers.put("Session-Id", LoginHelper.a().c());
        return headers;
    }
}
