package okhttp3;

import javax.annotation.Nullable;
import okhttp3.internal.b.g;

/* compiled from: Request */
public final class af {
    public final HttpUrl a;
    public final String b;
    public final y c;
    @Nullable
    public final ag d;
    public final Object e;
    private volatile e f;

    /* compiled from: Request */
    public static class a {
        HttpUrl a;
        String b;
        public okhttp3.y.a c;
        ag d;
        public Object e;

        public a() {
            this.b = "GET";
            this.c = new okhttp3.y.a();
        }

        a(af afVar) {
            this.a = afVar.a;
            this.b = afVar.b;
            this.d = afVar.d;
            this.e = afVar.e;
            this.c = afVar.c.a();
        }

        public final a a(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.a = httpUrl;
            return this;
        }

        public final a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            StringBuilder stringBuilder;
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                stringBuilder = new StringBuilder("http:");
                stringBuilder.append(str.substring(3));
                str = stringBuilder.toString();
            } else {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    stringBuilder = new StringBuilder("https:");
                    stringBuilder.append(str.substring(4));
                    str = stringBuilder.toString();
                }
            }
            HttpUrl d = HttpUrl.d(str);
            if (d != null) {
                return a(d);
            }
            StringBuilder stringBuilder2 = new StringBuilder("unexpected url: ");
            stringBuilder2.append(str);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }

        public final a a(String str, String str2) {
            okhttp3.y.a aVar = this.c;
            okhttp3.y.a.c(str, str2);
            aVar.a(str);
            aVar.b(str, str2);
            return this;
        }

        public final a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public final a b(String str) {
            this.c.a(str);
            return this;
        }

        public final a a(String str, @Nullable ag agVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (agVar != null && !g.b(str)) {
                r0 = new StringBuilder("method ");
                r0.append(str);
                r0.append(" must not have a request body.");
                throw new IllegalArgumentException(r0.toString());
            } else if (agVar == null && g.a(str)) {
                r0 = new StringBuilder("method ");
                r0.append(str);
                r0.append(" must have a request body.");
                throw new IllegalArgumentException(r0.toString());
            } else {
                this.b = str;
                this.d = agVar;
                return this;
            }
        }

        public final af a() {
            if (this.a != null) {
                return new af(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    af(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public final String a(String str) {
        return this.c.a(str);
    }

    public final a a() {
        return new a(this);
    }

    public final e b() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        eVar = e.a(this.c);
        this.f = eVar;
        return eVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{method=");
        stringBuilder.append(this.b);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tag=");
        stringBuilder.append(this.e != this ? this.e : null);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
