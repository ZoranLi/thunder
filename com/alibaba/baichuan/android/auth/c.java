package com.alibaba.baichuan.android.auth;

import android.text.TextUtils;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    static Map a = new ConcurrentHashMap();

    public static class a {
        public String a;
        public Set b;
        public g c;
    }

    static class b implements com.alibaba.baichuan.android.trade.adapter.mtop.b.a {
        private g a;
        private String b;
        private boolean c;

        public b(g gVar, String str, boolean z) {
            this.a = gVar;
            this.b = str;
            this.c = z;
        }

        public final void b(NetworkResponse networkResponse) {
            if (this.a != null) {
                this.a.a(networkResponse.errorCode, networkResponse.errorMsg);
            }
            c.a(networkResponse.errorCode);
        }

        public final void a(NetworkResponse networkResponse) {
            Map map = networkResponse.data;
            if (map != null) {
                if (networkResponse.isSuccess) {
                    com.alibaba.baichuan.android.trade.adapter.ut.a.a();
                    com.alibaba.baichuan.android.trade.adapter.ut.a.a("BCPCSDK", "Mtop_Auth");
                    if (this.c == null || TextUtils.equals(this.b, a.a.a) != null) {
                        a.a.a(map.get("token").toString(), com.alibaba.baichuan.android.trade.utils.b.b(map.get("expires")).longValue());
                        if (this.a != null) {
                            this.a.a();
                        }
                        return;
                    }
                    if (this.a != null) {
                        this.a.a();
                    }
                    return;
                }
            }
            if (this.a != null) {
                this.a.a(networkResponse.errorCode, networkResponse.errorMsg);
            }
            c.a(networkResponse.errorCode);
        }
    }

    static void a(String str, g gVar) {
        new e(str, gVar).execute(new String[0]);
    }

    static void a(Set set, g gVar, boolean z) {
        Object obj = a.a.a;
        if (set == null && TextUtils.isEmpty(obj)) {
            if (gVar != null) {
                gVar.a(a.HINTLIST_NULL.b, a.HINTLIST_NULL.c);
            }
            return;
        }
        com.alibaba.baichuan.android.trade.a.c aVar = new com.alibaba.baichuan.android.auth.a.a();
        com.alibaba.baichuan.android.trade.adapter.mtop.b.a bVar = new b(gVar, obj, z);
        gVar = new HashMap();
        gVar.put("hintArray", set == null ? "[]" : com.alibaba.baichuan.android.trade.utils.f.a.a(new ArrayList(set)));
        set = "oldToken";
        if (obj == null) {
            obj = "";
        }
        gVar.put(set, obj);
        a.a.a(bVar, aVar.b(gVar));
    }

    static /* synthetic */ void a(String str) {
        str = (String) a.d.get(str);
        if (str == null) {
            str = "00";
        }
        com.alibaba.baichuan.android.trade.adapter.ut.a.a();
        StringBuilder stringBuilder = new StringBuilder("2101");
        stringBuilder.append(str);
        com.alibaba.baichuan.android.trade.adapter.ut.a.a("BCPCSDK", "Mtop_Auth", stringBuilder.toString(), "授权失败");
    }
}
