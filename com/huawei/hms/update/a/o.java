package com.huawei.hms.update.a;

import android.content.Context;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.c.e;
import com.huawei.hms.c.e.a;

/* compiled from: UpdatePolicy */
class o {
    private final Context a;
    private int b;
    private String c;

    public o(Context context) {
        if (context == null) {
            throw new NullPointerException("context must not be null.");
        }
        this.a = context;
        c();
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    private void c() {
        e eVar = new e(this.a);
        int b = eVar.b(HuaweiApiAvailability.SERVICES_PACKAGE);
        String c = eVar.c(HuaweiApiAvailability.SERVICES_PACKAGE);
        if (!(b == 0 || c.isEmpty())) {
            if (eVar.a(HuaweiApiAvailability.SERVICES_PACKAGE) != a.NOT_INSTALLED) {
                this.b = b;
                if (!c.endsWith("OVE")) {
                    if (c.endsWith("EU")) {
                        this.c = "2.1.1.0_OVE";
                        return;
                    } else if (b < 20101302) {
                        d();
                        return;
                    }
                }
                this.c = c;
                return;
            }
        }
        this.b = 20101000;
        d();
    }

    private void d() {
        if (com.huawei.hms.update.f.a.c(this.a)) {
            this.c = "2.1.1.0";
        } else {
            this.c = "2.1.1.0_OVE";
        }
    }
}
