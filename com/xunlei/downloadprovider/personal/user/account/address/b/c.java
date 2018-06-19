package com.xunlei.downloadprovider.personal.user.account.address.b;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: UserRegionCreateDB */
public final class c implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ b b;

    public c(b bVar, JSONObject jSONObject) {
        this.b = bVar;
        this.a = jSONObject;
    }

    public final void run() {
        Map a = b.b(b.a(this.a));
        b.a(this.b, a);
        b.b(this.b, a);
    }
}
