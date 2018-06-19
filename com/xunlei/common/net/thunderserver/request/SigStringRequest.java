package com.xunlei.common.net.thunderserver.request;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;

public class SigStringRequest extends SigRequest<String> {
    public SigStringRequest(int i, String str, String str2, b<String> bVar, a aVar) {
        super(i, str, str2, bVar, aVar);
    }

    protected n<String> parseNetworkResponse(j jVar) {
        try {
            return n.a(new String(jVar.b, k.a(jVar.c, "utf-8")), k.a(jVar));
        } catch (Throwable e) {
            return n.a(new ParseError(e));
        }
    }
}
