package com.xunlei.downloadprovider.download.privatespace;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import java.util.Map;

/* compiled from: PrivateSpaceHelper */
final class ac extends v$b {
    final /* synthetic */ String a;

    ac(String str, b bVar, a aVar, String str2) {
        this.a = str2;
        super(str, bVar, aVar);
    }

    protected final Map<String, String> getParams() throws AuthFailureError {
        return v.a(this.a);
    }
}
