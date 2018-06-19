package com.igexin.push.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.core.c.i;
import com.igexin.push.f.a;

class e extends a {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    protected void a() {
        try {
            Object h = com.igexin.push.util.e.h();
            if (!TextUtils.isEmpty(h)) {
                c.b().a(new com.igexin.push.f.a.c(new i(SDKUrlConfig.getBiUploadServiceUrl(), h.getBytes(), 10, false)), false, true);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("UploadBITask|");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }
}
