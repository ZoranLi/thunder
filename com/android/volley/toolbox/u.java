package com.android.volley.toolbox;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: JsonObjectRequest */
public class u extends v<JSONObject> {
    public u(int i, String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    public u(String str, JSONObject jSONObject, b<JSONObject> bVar, a aVar) {
        this(jSONObject == null ? 0 : 1, str, jSONObject, bVar, aVar);
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
