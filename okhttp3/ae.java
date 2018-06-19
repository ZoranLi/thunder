package okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl.Builder;
import okhttp3.internal.b;
import okhttp3.internal.b.h;
import okhttp3.internal.b.k;
import okhttp3.internal.e.e;

/* compiled from: RealCall */
final class ae implements f {
    final ac a;
    final k b;
    final u c;
    final af d;
    final boolean e;
    private boolean f;

    /* compiled from: RealCall */
    final class a extends b {
        final /* synthetic */ ae a;
        private final g c;

        a(ae aeVar, g gVar) {
            this.a = aeVar;
            super("OkHttp %s", aeVar.c());
            this.c = gVar;
        }

        final String a() {
            return this.a.d.a.b;
        }

        protected final void b() {
            Throwable e;
            e b;
            StringBuilder stringBuilder;
            ae aeVar;
            StringBuilder stringBuilder2;
            r rVar;
            Object obj = 1;
            try {
                aj d = this.a.d();
                if (this.a.b.b) {
                    try {
                        this.c.a(this.a, new IOException("Canceled"));
                    } catch (IOException e2) {
                        e = e2;
                        if (obj == null) {
                            this.c.a(this.a, e);
                        } else {
                            try {
                                b = e.b();
                                stringBuilder = new StringBuilder("Callback failure for ");
                                aeVar = this.a;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(aeVar.b.b ? "" : "canceled ");
                                stringBuilder2.append(aeVar.e ? "call" : "web socket");
                                stringBuilder2.append(" to ");
                                stringBuilder2.append(aeVar.c());
                                stringBuilder.append(stringBuilder2.toString());
                                b.a(4, stringBuilder.toString(), e);
                            } catch (Throwable th) {
                                this.a.a.c.b(this);
                            }
                        }
                        rVar = this.a.a.c;
                        rVar.b(this);
                    }
                }
                this.c.a(d);
                rVar = this.a.a.c;
            } catch (Throwable e3) {
                e = e3;
                obj = null;
                if (obj == null) {
                    b = e.b();
                    stringBuilder = new StringBuilder("Callback failure for ");
                    aeVar = this.a;
                    stringBuilder2 = new StringBuilder();
                    if (aeVar.b.b) {
                    }
                    stringBuilder2.append(aeVar.b.b ? "" : "canceled ");
                    if (aeVar.e) {
                    }
                    stringBuilder2.append(aeVar.e ? "call" : "web socket");
                    stringBuilder2.append(" to ");
                    stringBuilder2.append(aeVar.c());
                    stringBuilder.append(stringBuilder2.toString());
                    b.a(4, stringBuilder.toString(), e);
                } else {
                    this.c.a(this.a, e);
                }
                rVar = this.a.a.c;
                rVar.b(this);
            }
            rVar.b(this);
        }
    }

    ae(ac acVar, af afVar, boolean z) {
        okhttp3.u.a aVar = acVar.i;
        this.a = acVar;
        this.d = afVar;
        this.e = z;
        this.b = new k(acVar, z);
        this.c = aVar.a();
    }

    public final af a() {
        return this.d;
    }

    public final aj b() throws IOException {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        e();
        try {
            this.a.c.a(this);
            aj d = d();
            if (d != null) {
                return d;
            }
            throw new IOException("Canceled");
        } finally {
            this.a.c.b(this);
        }
    }

    private void e() {
        this.b.a = e.b().a("response.body().close()");
    }

    public final void a(g gVar) {
        synchronized (this) {
            if (this.f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f = true;
        }
        e();
        this.a.c.a(new a(this, gVar));
    }

    final String c() {
        Builder c = this.d.a.c("/...");
        c.b = HttpUrl.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        c.c = HttpUrl.a("", " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
        return c.b().toString();
    }

    final aj d() throws IOException {
        List arrayList = new ArrayList();
        arrayList.addAll(this.a.g);
        arrayList.add(this.b);
        arrayList.add(new okhttp3.internal.b.a(this.a.k));
        ac acVar = this.a;
        arrayList.add(new okhttp3.internal.a.a(acVar.l != null ? acVar.l.a : acVar.m));
        arrayList.add(new okhttp3.internal.connection.a(this.a));
        if (!this.e) {
            arrayList.addAll(this.a.h);
        }
        arrayList.add(new okhttp3.internal.b.b(this.e));
        return new h(arrayList, null, null, null, 0, this.d).a(this.d);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new ae(this.a, this.d, this.e);
    }
}
