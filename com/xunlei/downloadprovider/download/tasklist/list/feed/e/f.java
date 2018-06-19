package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import android.os.Handler;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.feed.d.d;
import org.json.JSONObject;

/* compiled from: TaskListFeedNetwork */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String str = c.a;
        if (jSONObject != null) {
            jSONObject.toString();
        }
        if (this.a.b.e != null) {
            try {
                new Handler(BrothersApplication.getApplicationInstance().getMainLooper()).post(new g(this, d.a(jSONObject)));
            } catch (Object obj2) {
                obj2.printStackTrace();
                this.a.b.e.a(-1, "");
            }
        }
    }
}
