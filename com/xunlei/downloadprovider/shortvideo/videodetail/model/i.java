package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ShortMovieDetailDataLoader */
final class i implements b<JSONObject> {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        String optString;
        JSONException e;
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("loadBaseInfo response=>").append(jSONObject.toString());
        if (jSONObject != null) {
            optString = jSONObject.optString("result");
            if (ITagManager.SUCCESS.contentEquals(optString)) {
                try {
                    obj = b.a(jSONObject);
                    try {
                        if (TextUtils.equals("null", obj.a().getGcid())) {
                            obj.a().setGcid(null);
                        }
                    } catch (JSONException e2) {
                        e = e2;
                        this.a.c.p.post(new j(this, e));
                        this.a.c.p.post(new k(this, optString, obj));
                    }
                } catch (JSONException e3) {
                    e = e3;
                    obj = null;
                    this.a.c.p.post(new j(this, e));
                    this.a.c.p.post(new k(this, optString, obj));
                }
            }
            obj = null;
        } else {
            obj = null;
            optString = obj;
        }
        this.a.c.p.post(new k(this, optString, obj));
    }
}
