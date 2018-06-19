package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import com.android.volley.AuthFailureError;
import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TouTiaoJSONObjectRequest */
final class a extends k<JSONObject> {
    public a(String str, Map<String, String> map, b<JSONObject> bVar, com.android.volley.n.a aVar) {
        super(str, map, bVar, aVar);
    }

    public final byte[] getBody() throws AuthFailureError {
        return super.getBody();
    }

    protected final n<JSONObject> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONObject(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (j jVar2) {
            return n.a(new ParseError(jVar2));
        } catch (j jVar22) {
            return n.a(new ParseError(jVar22));
        }
    }
}
