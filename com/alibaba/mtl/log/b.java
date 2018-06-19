package com.alibaba.mtl.log;

import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import com.alibaba.mtl.log.e.i;
import com.ut.mini.core.appstatus.UTMCAppStatusRegHelper;
import com.ut.mini.core.sign.IUTRequestAuthentication;

/* compiled from: UTMCStatConfig */
public final class b {
    private static b h = new b();
    public Context a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public Application f = null;
    public String g = null;
    private IUTRequestAuthentication i = null;
    private boolean j = false;
    private boolean k = false;

    private b() {
    }

    public static b a() {
        return h;
    }

    public static void b() {
        i.a(true);
    }

    public final void c() {
        if (!this.j && VERSION.SDK_INT >= 14) {
            try {
                if (h.f != null) {
                    UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks(h.f);
                    this.j = true;
                    return;
                }
                UTMCAppStatusRegHelper.registeActivityLifecycleCallbacks((Application) h.a.getApplicationContext());
                this.j = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
