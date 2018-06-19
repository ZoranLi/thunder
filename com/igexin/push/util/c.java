package com.igexin.push.util;

import android.content.Context;
import com.igexin.b.a.b.f;
import com.igexin.b.b.a;
import com.igexin.push.config.SDKUrlConfig;
import org.json.JSONObject;

final class c implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ d b;

    c(Context context, d dVar) {
        this.a = context;
        this.b = dVar;
    }

    public final void run() {
        boolean z = false;
        try {
            if (b.a(this.a)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.getFilesDir().getPath());
                stringBuilder.append("/init_er.pid");
                e.a(String.valueOf(System.currentTimeMillis()).getBytes(), stringBuilder.toString(), false);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", "upload_BI");
                jSONObject.put("BIType", "25");
                jSONObject.put("cid", "0");
                jSONObject.put("BIData", new String(f.f(b.b(this.a).getBytes(), 0), "UTF-8"));
                byte[] a = r.a(SDKUrlConfig.getBiUploadServiceUrl(), a.b(jSONObject.toString().getBytes()), 10000, 10000);
                if (a != null) {
                    String str = new String(a);
                }
                z = true;
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("ErrorReport|report 25 ex = ");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
        if (this.b != null) {
            this.b.a(z);
        }
    }
}
