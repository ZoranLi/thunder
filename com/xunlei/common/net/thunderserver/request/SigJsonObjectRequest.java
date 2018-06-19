package com.xunlei.common.net.thunderserver.request;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import org.json.JSONArray;
import org.json.JSONObject;

public class SigJsonObjectRequest extends SigJsonRequest<JSONObject> {
    public SigJsonObjectRequest(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    public SigJsonObjectRequest(int i, String str, b<JSONObject> bVar, a aVar) {
        super(i, str, null, bVar, aVar);
    }

    public SigJsonObjectRequest(int i, String str, JSONArray jSONArray, b<JSONObject> bVar, a aVar) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), bVar, aVar);
    }

    public SigJsonObjectRequest(String str, b<JSONObject> bVar, a aVar) {
        this(0, str, bVar, aVar);
    }

    protected n<JSONObject> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONObject(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (Throwable e) {
            return n.a(new ParseError(e));
        } catch (Throwable e2) {
            return n.a(new ParseError(e2));
        }
    }
}
