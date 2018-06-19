package com.xunlei.common.net.thunderserver.request;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import org.json.JSONArray;
import org.json.JSONObject;

public class SigJsonArrayRequest extends SigJsonRequest<JSONArray> {
    public SigJsonArrayRequest(int i, String str, JSONObject jSONObject, b<JSONArray> bVar, a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    public SigJsonArrayRequest(int i, String str, JSONArray jSONArray, b<JSONArray> bVar, a aVar) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), bVar, aVar);
    }

    protected n<JSONArray> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONArray(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (j jVar2) {
            return n.a(new ParseError(jVar2));
        } catch (j jVar22) {
            return n.a(new ParseError(jVar22));
        }
    }
}
