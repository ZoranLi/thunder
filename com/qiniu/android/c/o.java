package com.qiniu.android.c;

import com.qiniu.android.d.a;
import com.qiniu.android.http.h;
import com.xunlei.download.DownloadManager;
import org.json.JSONObject;

/* compiled from: ResumeUploader */
final class o implements h {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ long c;
    final /* synthetic */ int d;
    final /* synthetic */ k e;

    o(k kVar, String str, int i, long j, int i2) {
        this.e = kVar;
        this.a = str;
        this.b = i;
        this.c = j;
        this.d = i2;
    }

    public final void a(com.qiniu.android.http.o oVar, JSONObject jSONObject) {
        String a;
        if (oVar.c() && !a.a()) {
            this.e.d.f.a();
            if (!a.a()) {
                this.e.c.a(this.e.b, oVar, jSONObject);
                return;
            }
        }
        if (oVar.a()) {
            this.e.c.a(this.e.b, oVar, jSONObject);
        } else if (!k.a(oVar, jSONObject)) {
            a = this.e.f.k.a(this.e.o.b, this.e.f.l, this.a);
            if (oVar.a == 701 && this.b < this.e.f.h) {
                this.e.a((this.c / DownloadManager.MAX_BYTES_OVER_MOBILE) * DownloadManager.MAX_BYTES_OVER_MOBILE, this.b + 1, this.a);
            } else if (a == null || (!(k.b(oVar, jSONObject) || oVar.d()) || this.b >= this.e.f.h)) {
                this.e.c.a(this.e.b, oVar, jSONObject);
            } else {
                this.e.a(this.c, this.b + 1, a);
            }
        } else if (jSONObject != null || this.b >= this.e.f.h) {
            try {
                a = jSONObject.getString("ctx");
                try {
                    oVar = jSONObject.getLong("crc32");
                } catch (Exception e) {
                    oVar = e;
                    oVar.printStackTrace();
                    oVar = 0;
                    if (a == null) {
                    }
                    this.e.a(this.c, this.b + 1, this.e.f.k.a(this.e.o.b, this.e.f.l, this.a));
                    return;
                }
            } catch (JSONObject jSONObject2) {
                a = null;
                oVar = jSONObject2;
                oVar.printStackTrace();
                oVar = 0;
                if (a == null) {
                }
                this.e.a(this.c, this.b + 1, this.e.f.k.a(this.e.o.b, this.e.f.l, this.a));
                return;
            }
            if (!(a == null && r7 == this.e.n) && this.b < this.e.f.h) {
                this.e.a(this.c, this.b + 1, this.e.f.k.a(this.e.o.b, this.e.f.l, this.a));
                return;
            }
            this.e.h[(int) (this.c / DownloadManager.MAX_BYTES_OVER_MOBILE)] = a;
            k.a(this.e, this.c + ((long) this.d));
            this.e.a(this.c + ((long) this.d), this.b, this.a);
        } else {
            this.e.a(this.c, this.b + 1, this.e.f.k.a(this.e.o.b, this.e.f.l, this.a));
        }
    }
}
