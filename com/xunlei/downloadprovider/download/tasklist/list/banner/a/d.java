package com.xunlei.downloadprovider.download.tasklist.list.banner.a;

import android.support.v4.media.session.PlaybackStateCompat;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: GiftQualificationHttpClient */
public final class d implements a, b<String> {
    c a;

    public final /* synthetic */ void onResponse(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            obj = jSONObject.optInt("result");
            if (this.a != null) {
                this.a.a(obj);
            }
            if (obj == null) {
                jSONObject = jSONObject.optJSONObject("data");
                if (jSONObject != null) {
                    f.a(jSONObject.optLong("speed", PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED));
                }
            }
            if (obj != null) {
                if (this.a != null) {
                    this.a.b();
                }
                return;
            }
            if (this.a != null) {
                this.a.a();
            }
        } catch (Object obj2) {
            obj2.printStackTrace();
            if (this.a != null) {
                this.a.b();
            }
        }
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            c cVar = this.a;
            volleyError.getMessage();
            cVar.b();
        }
    }
}
