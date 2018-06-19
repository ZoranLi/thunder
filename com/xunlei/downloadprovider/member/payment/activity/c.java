package com.xunlei.downloadprovider.member.payment.activity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.SparseArray;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.c.f;
import com.xunlei.xllib.b.d;
import java.util.HashMap;

/* compiled from: ActivityModel */
public class c {
    private static c d;
    public SharedPreferences a = BrothersApplication.getApplicationInstance().getSharedPreferences("pay:activity_record", 0);
    public Editor b = this.a.edit();
    public HashMap<String, Integer> c = new HashMap();
    private f e;

    public static c a() {
        if (d == null) {
            synchronized (c.class) {
                if (d == null) {
                    d = new c();
                }
            }
        }
        return d;
    }

    private c() {
        f.a();
        XLThreadPool.execute(new d(this));
    }

    public final f b() {
        if (this.e == null) {
            this.e = new g();
        }
        return this.e;
    }

    public final e a(String str, int i) {
        String<a> b = b().b(str);
        if (!d.a(b)) {
            for (a aVar : b) {
                if (aVar != null) {
                    Object obj = 1;
                    if (i >= 0) {
                        SparseArray a = aVar.a(i);
                        if (a == null || a.size() <= 0) {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        e a2 = m.a(aVar);
                        if (a2 != null) {
                            return a2;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    public final void a(boolean z) {
        b().a(z);
    }

    public final boolean a(String str) {
        str = b().a(str);
        if (str == null) {
            return true;
        }
        e nVar = new n();
        nVar.a(str);
        if (nVar.a() != null) {
            return null;
        }
        return true;
    }

    public final r b(String str) {
        return b().c(str);
    }
}
