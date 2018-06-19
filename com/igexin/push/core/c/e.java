package com.igexin.push.core.c;

import com.igexin.b.a.c.a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.o;
import com.igexin.push.core.a.t;
import com.igexin.push.core.b.g;
import com.igexin.push.f.a.b;
import com.igexin.push.util.h;
import org.json.JSONArray;

public class e extends b {
    public static JSONArray a;

    public e(String str, JSONArray jSONArray) {
        super(str);
        a(jSONArray);
    }

    public void a(Exception exception) {
        g.a().d(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder("-> get idc config ");
        stringBuilder.append(exception.toString());
        a.b(stringBuilder.toString());
    }

    public void a(JSONArray jSONArray) {
        a = jSONArray;
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(com.igexin.b.b.a.c(h.a(bArr, 0)));
                StringBuilder stringBuilder = new StringBuilder("->get idc config server resp data : ");
                stringBuilder.append(str);
                a.b(stringBuilder.toString());
                com.igexin.push.config.a.a().b(str);
                o.a(str, true);
                g.a().d(0);
                com.igexin.push.config.a.a().a(a.toString());
                SDKUrlConfig.setIdcConfigUrl(t.a(a));
            } catch (Exception e) {
                g.a().d(System.currentTimeMillis());
                throw e;
            }
        }
    }

    public int b() {
        return 0;
    }
}
