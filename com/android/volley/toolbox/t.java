package com.android.volley.toolbox;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import org.json.JSONArray;

/* compiled from: JsonArrayRequest */
public class t extends v<JSONArray> {
    public t(String str, b<JSONArray> bVar, a aVar) {
        super(0, str, null, bVar, aVar);
    }

    public t(int i, String str, JSONArray jSONArray, b<JSONArray> bVar, a aVar) {
        super(i, str, jSONArray == null ? null : jSONArray.toString(), bVar, aVar);
    }

    protected n<JSONArray> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONArray(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (Throwable e) {
            return n.a(new ParseError(e));
        } catch (Throwable e2) {
            return n.a(new ParseError(e2));
        }
    }
}
