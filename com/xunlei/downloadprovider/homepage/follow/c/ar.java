package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UserSigJsonRequest */
public class ar extends SigJsonObjectRequest {
    public ar(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        super(i, str, jSONObject, (b) bVar, aVar);
    }

    public ar(int i, String str, b<JSONObject> bVar, a aVar) {
        super(i, str, bVar, aVar);
    }

    public ar(String str, b<JSONObject> bVar, a aVar) {
        super(str, bVar, aVar);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        LoginHelper.a();
        if (l.c()) {
            headers.put("User-Id", String.valueOf(LoginHelper.a().g.c()));
            StringBuilder stringBuilder = new StringBuilder("40:");
            stringBuilder.append(LoginHelper.a().c());
            headers.put("Session-Id", stringBuilder.toString());
        }
        return headers;
    }
}
