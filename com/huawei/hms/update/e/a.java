package com.huawei.hms.update.e;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.c.d;
import com.huawei.hms.c.g;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AbsUpdateWizard */
public abstract class a {
    abstract void a(b bVar);

    abstract void b(b bVar);

    abstract Activity c();

    protected void a(int i, int i2) {
        Context c = c();
        if (c != null) {
            if (!c.isFinishing()) {
                Map hashMap = new HashMap();
                hashMap.put("package", c.getPackageName());
                hashMap.put("sdk_ver", "20502300");
                hashMap.put(Constants.APP_ID, g.a(c));
                hashMap.put("trigger_api", com.huawei.hms.update.c.a.b());
                hashMap.put("hms_ver", String.valueOf(com.huawei.hms.update.c.a.a()));
                hashMap.put("update_type", String.valueOf(i2));
                hashMap.put("net_type", String.valueOf(d.a(c)));
                hashMap.put("result", String.valueOf(i));
                com.huawei.hms.support.b.a.a().a(c, "HMS_SDK_UPDATE", hashMap);
            }
        }
    }
}
