package com.xunlei.downloadprovider.homepage.youliao.data;

import com.xunlei.downloadprovider.d.a.f;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: DataCache */
final class b implements Runnable {
    final /* synthetic */ JSONObject a;
    final /* synthetic */ a b;

    b(a aVar, JSONObject jSONObject) {
        this.b = aVar;
        this.a = jSONObject;
    }

    public final void run() {
        try {
            f.a(a.a(), this.a.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
