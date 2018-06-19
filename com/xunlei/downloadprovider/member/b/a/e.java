package com.xunlei.downloadprovider.member.b.a;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.android.volley.n.b;

/* compiled from: VipRenewalConfigClient */
public final class e implements a, b<String> {
    static boolean a = false;
    private static String d = "VipRenewalConfigClient";
    String b = "";
    @Nullable
    com.xunlei.downloadprovider.member.b.a.a c;

    public final /* synthetic */ void onResponse(Object obj) {
        String str = (String) obj;
        a();
        try {
            if (!TextUtils.isEmpty(str)) {
                obj = a.a(new String(str.getBytes("ISO-8859-1"), "UTF-8"));
                if (this.c != null) {
                    if (a.d(obj) != null) {
                        this.c.i();
                        return;
                    }
                    this.c.j();
                }
            } else if (this.c != null) {
                this.c.j();
            }
        } catch (Object obj2) {
            obj2.printStackTrace();
            if (this.c != null) {
                this.c.j();
            }
        }
    }

    public e(@Nullable com.xunlei.downloadprovider.member.b.a.a aVar) {
        this.c = aVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        new StringBuilder("getVipRenewalConfig--error=").append(volleyError);
        a.c(this.b);
        a();
        if (this.c != null) {
            this.c.j();
        }
    }

    final void a() {
        a = false;
        this.b = "";
    }
}
