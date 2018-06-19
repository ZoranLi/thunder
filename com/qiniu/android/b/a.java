package com.qiniu.android.b;

import android.util.Base64;
import com.qiniu.android.c.s;
import com.qiniu.android.http.h;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: AutoZone */
public final class a extends d {
    public static final a a = new a();
    private final String b;
    private Map<a, e> c;
    private com.qiniu.android.http.a d;

    /* compiled from: AutoZone */
    static class a {
        final String a;
        final String b;

        a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        static a a(String str) {
            str = str.split(Constants.COLON_SEPARATOR);
            try {
                return new a(str[0], new JSONObject(new String(Base64.decode(str[2], 10), "utf-8")).getString("scope").split(Constants.COLON_SEPARATOR)[0]);
            } catch (String str2) {
                str2.printStackTrace();
                return null;
            }
        }

        public final int hashCode() {
            return (this.a.hashCode() * 37) + this.b.hashCode();
        }

        public final boolean equals(Object obj) {
            if (obj != this) {
                if (obj != null && (obj instanceof a)) {
                    a aVar = (a) obj;
                    if (aVar.a.equals(this.a) && aVar.b.equals(this.b) != null) {
                    }
                }
                return null;
            }
            return true;
        }
    }

    private a() {
        this("https://uc.qbox.me");
    }

    private a(String str) {
        this.c = new ConcurrentHashMap();
        this.d = new com.qiniu.android.http.a();
        this.b = str;
    }

    private e b(String str) {
        try {
            str = str.split(Constants.COLON_SEPARATOR);
            return (e) this.c.get(new a(str[0], new JSONObject(new String(Base64.decode(str[2], 10), "utf-8")).getString("scope").split(Constants.COLON_SEPARATOR)[0]));
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public final synchronized String a(String str, boolean z, String str2) {
        e b = b(str);
        if (b == null) {
            return null;
        }
        return super.a(b, z, str2);
    }

    public final void a(String str, com.qiniu.android.b.d.a aVar) {
        str = a.a(str);
        if (str == null) {
            aVar.a(-5);
        } else if (((e) this.c.get(str)) != null) {
            aVar.a();
        } else {
            h bVar = new b(this, str, aVar);
            aVar = new StringBuilder();
            aVar.append(this.b);
            aVar.append("/v2/query?ak=");
            aVar.append(str.a);
            aVar.append("&bucket=");
            aVar.append(str.b);
            str = aVar.toString();
            this.d.a(new okhttp3.af.a().a("GET", null).a(str), null, s.a, 0, bVar);
        }
    }

    public final synchronized void a(String str) {
        if (str != null) {
            str = URI.create(str).getHost();
            e eVar = null;
            for (Entry value : this.c.entrySet()) {
                e eVar2 = (e) value.getValue();
                if (eVar2.a.contains(str)) {
                    eVar = eVar2;
                    break;
                }
            }
            if (eVar != null) {
                eVar.a(str);
            }
        }
    }
}
