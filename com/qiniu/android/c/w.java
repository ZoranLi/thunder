package com.qiniu.android.c;

import com.qiniu.android.http.o;
import org.json.JSONObject;

/* compiled from: UploadManager */
final class w implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ o b;
    final /* synthetic */ JSONObject c;
    final /* synthetic */ a d;

    w(a aVar, String str, o oVar, JSONObject jSONObject) {
        this.d = aVar;
        this.a = str;
        this.b = oVar;
        this.c = jSONObject;
    }

    public final void run() {
        try {
            this.d.a.a(this.a, this.b, this.c);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
