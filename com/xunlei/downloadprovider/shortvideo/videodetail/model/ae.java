package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.d.d;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ShortMovieDetailDataLoader */
final class ae implements b<JSONObject> {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            try {
                CharSequence optString = jSONObject.optString("result");
                String str = "";
                String str2 = "";
                JSONObject optJSONObject = jSONObject.optJSONObject("params");
                String str3 = "";
                if (optJSONObject != null) {
                    str = optJSONObject.optString("s_ab", "");
                    str2 = optJSONObject.optString("sversion", "");
                    str3 = optJSONObject.toString();
                }
                if (ITagManager.SUCCESS.contentEquals(optString)) {
                    obj = jSONObject.optJSONArray("list");
                    if (obj != null && obj.length() > 0) {
                        int length = obj.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject2 = obj.optJSONObject(i);
                            new StringBuilder("load recommend movies item response =>").append(optJSONObject2);
                            e a = e.a(optJSONObject2);
                            if (a != null) {
                                if (TextUtils.equals("video", a.a)) {
                                    b bVar = (b) a.b;
                                    if (!TextUtils.equals(this.a.a, bVar.a().getVideoId())) {
                                        bVar.a = str;
                                        bVar.c = str3;
                                        if (bVar.e != null) {
                                            bVar.e.setServerExtData(str3);
                                        }
                                        bVar.b = str2;
                                    }
                                } else if (TextUtils.equals("ads", a.a)) {
                                    if (!(a.b instanceof l)) {
                                    }
                                } else if ("site".equals(a.a)) {
                                    if (d.a().b.u()) {
                                        ((f) a.b).a = this.a.a;
                                    }
                                }
                                arrayList.add(a);
                            }
                        }
                    }
                }
            } catch (Object obj2) {
                this.a.d.p.post(new ag(this, obj2));
                return;
            }
        }
        this.a.d.p.post(new af(this, arrayList));
    }
}
