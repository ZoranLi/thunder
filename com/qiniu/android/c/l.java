package com.qiniu.android.c;

import com.qiniu.android.http.o;
import java.io.IOException;
import org.json.JSONObject;

/* compiled from: ResumeUploader */
final class l implements q {
    final /* synthetic */ q a;
    final /* synthetic */ k b;

    l(k kVar, q qVar) {
        this.b = kVar;
        this.a = qVar;
    }

    public final void a(String str, o oVar, JSONObject jSONObject) {
        if (this.b.l != null) {
            try {
                this.b.l.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.a.a(str, oVar, jSONObject);
    }
}
