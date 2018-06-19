package com.xunlei.downloadprovider.member.payment.network;

import com.android.volley.AuthFailureError;
import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import com.android.volley.toolbox.v;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: BaseJsonRequest */
final class a extends v<JSONObject> {
    final /* synthetic */ BaseJsonRequest a;

    a(BaseJsonRequest baseJsonRequest, int i, String str, String str2, b bVar, com.android.volley.n.a aVar) {
        this.a = baseJsonRequest;
        super(i, str, str2, bVar, aVar);
    }

    protected final n<JSONObject> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONObject(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (Throwable e) {
            return n.a(new ParseError(e));
        } catch (Throwable e2) {
            return n.a(new ParseError(e2));
        }
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        if (this.a.b.isEmpty()) {
            return super.getHeaders();
        }
        return this.a.b;
    }
}
