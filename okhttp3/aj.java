package okhttp3;

import java.io.Closeable;
import javax.annotation.Nullable;

/* compiled from: Response */
public final class aj implements Closeable {
    public final af a;
    final Protocol b;
    public final int c;
    final String d;
    @Nullable
    public final x e;
    public final y f;
    @Nullable
    public final ak g;
    @Nullable
    final aj h;
    @Nullable
    final aj i;
    @Nullable
    final aj j;
    public final long k;
    public final long l;
    private volatile e m;

    /* compiled from: Response */
    public static class a {
        public af a;
        public Protocol b;
        public int c;
        public String d;
        @Nullable
        public x e;
        okhttp3.y.a f;
        public ak g;
        aj h;
        aj i;
        public aj j;
        public long k;
        public long l;

        public a() {
            this.c = -1;
            this.f = new okhttp3.y.a();
        }

        a(aj ajVar) {
            this.c = -1;
            this.a = ajVar.a;
            this.b = ajVar.b;
            this.c = ajVar.c;
            this.d = ajVar.d;
            this.e = ajVar.e;
            this.f = ajVar.f.a();
            this.g = ajVar.g;
            this.h = ajVar.h;
            this.i = ajVar.i;
            this.j = ajVar.j;
            this.k = ajVar.k;
            this.l = ajVar.l;
        }

        public final a a(String str, String str2) {
            this.f.a(str, str2);
            return this;
        }

        public final a a(y yVar) {
            this.f = yVar.a();
            return this;
        }

        public final a a(@Nullable aj ajVar) {
            if (ajVar != null) {
                a("networkResponse", ajVar);
            }
            this.h = ajVar;
            return this;
        }

        public final a b(@Nullable aj ajVar) {
            if (ajVar != null) {
                a("cacheResponse", ajVar);
            }
            this.i = ajVar;
            return this;
        }

        private static void a(String str, aj ajVar) {
            StringBuilder stringBuilder;
            if (ajVar.g != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".body != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (ajVar.h != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".networkResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (ajVar.i != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".cacheResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (ajVar.j != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(".priorResponse != null");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        public final aj a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.c < 0) {
                StringBuilder stringBuilder = new StringBuilder("code < 0: ");
                stringBuilder.append(this.c);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (this.d != null) {
                return new aj(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }
    }

    aj(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f.a();
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.k;
        this.l = aVar.l;
    }

    @Nullable
    public final String a(String str) {
        return a(str, null);
    }

    @Nullable
    public final String a(String str, @Nullable String str2) {
        str = this.f.a(str);
        return str != null ? str : str2;
    }

    public final a a() {
        return new a(this);
    }

    public final e b() {
        e eVar = this.m;
        if (eVar != null) {
            return eVar;
        }
        eVar = e.a(this.f);
        this.m = eVar;
        return eVar;
    }

    public final void close() {
        this.g.close();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Response{protocol=");
        stringBuilder.append(this.b);
        stringBuilder.append(", code=");
        stringBuilder.append(this.c);
        stringBuilder.append(", message=");
        stringBuilder.append(this.d);
        stringBuilder.append(", url=");
        stringBuilder.append(this.a.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
