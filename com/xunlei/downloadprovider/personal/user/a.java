package com.xunlei.downloadprovider.personal.user;

import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.b;
import com.android.volley.toolbox.aa;

/* compiled from: AvatarTypeRequest */
public final class a extends aa {
    public a a;

    /* compiled from: AvatarTypeRequest */
    public interface a {
        void a(String str);
    }

    public a(String str, b<String> bVar, com.android.volley.n.a aVar) {
        super(0, str, bVar, aVar);
    }

    protected final n<String> parseNetworkResponse(j jVar) {
        String str = (String) jVar.c.get("Avatar-Type");
        if (!(this.a == null || str == null)) {
            this.a.a(str);
        }
        return super.parseNetworkResponse(jVar);
    }
}
