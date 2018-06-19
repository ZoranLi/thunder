package com.xunlei.downloadprovider.homepage.choiceness.a;

import org.json.JSONObject;

/* compiled from: ChoicenessDataHelper */
final class d implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    d(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.a = jSONObject;
    }

    public final void run() {
        this.b.h.a.edit().putString("last_page", this.a == null ? "" : this.a.toString()).apply();
    }
}
