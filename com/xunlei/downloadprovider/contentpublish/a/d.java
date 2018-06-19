package com.xunlei.downloadprovider.contentpublish.a;

import com.qiniu.android.c.q;
import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: QiniuUploadEnginer */
public final class d implements q {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    public d(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final void a(String str, o oVar, JSONObject jSONObject) {
        if (oVar == null || oVar.b() == null) {
            if (this.a != null) {
                this.a.a(oVar);
            }
        } else if (this.a != null) {
            this.a.a(oVar);
        }
    }
}
