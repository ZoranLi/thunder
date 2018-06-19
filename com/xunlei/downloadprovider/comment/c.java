package com.xunlei.downloadprovider.comment;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.comment.entity.f;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CommentManager */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a.a;
        new StringBuilder("loadCommentList response categoryType=").append(this.a.a);
        try {
            f a = f.a(jSONObject);
            this.a.d.a((Object) a);
            if (TextUtils.equals(this.a.a, "new")) {
                if (this.a.e.f != null) {
                    if (!TextUtils.equals(this.a.b, "refresh")) {
                        if (TextUtils.equals(this.a.b, "loadmore")) {
                            f c = this.a.e.f;
                            if (a != null && (TextUtils.isEmpty(c.a) || TextUtils.equals(a.a, c.a))) {
                                c.a = a.a;
                                if (a.e != null) {
                                    if (!a.e.isEmpty()) {
                                        if (c.e == null) {
                                            c.e = new ArrayList();
                                            c.c = a.c;
                                            c.b = a.b;
                                        }
                                        c.e.addAll(a.e);
                                    }
                                }
                                return;
                            }
                        }
                    }
                }
                this.a.e.f = a;
            }
        } catch (JSONException e) {
            a.a;
            e.getMessage();
            a.b bVar = new a.b();
            bVar.a = jSONObject.optInt("result", -1001);
            bVar.b = e.getMessage();
            this.a.d.a(bVar);
            e.printStackTrace();
        }
    }
}
