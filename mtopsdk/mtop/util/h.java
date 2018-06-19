package mtopsdk.mtop.util;

import com.xiaomi.mipush.sdk.Constants;
import mtopsdk.a.b.a;
import mtopsdk.common.util.f;
import mtopsdk.common.util.i;

public final class h implements Cloneable {
    public boolean a = true;
    public long b;
    public long c;
    public long d;
    public int e;
    public String f;
    public String g;
    protected long h;
    protected long i;
    protected long j;
    protected long k;
    protected long l;
    protected long m;
    protected String n = "";
    protected a o;
    public String p = "";
    public String q;
    public int r = f.a();
    private i s;

    public h() {
        StringBuilder stringBuilder = new StringBuilder("MTOP");
        stringBuilder.append(this.r);
        this.q = stringBuilder.toString();
    }

    public final void a(a aVar) {
        this.o = aVar;
    }

    public final Object clone() {
        return super.clone();
    }

    public final void g() {
        this.b = this.i - this.h;
        this.c = this.k - this.j;
        this.d = this.m - this.l;
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("mtopOneWayTime=");
        stringBuilder.append(this.b);
        stringBuilder.append(",oneWayTime=");
        stringBuilder.append(this.c);
        stringBuilder.append(",mtopResponseParseTime=");
        stringBuilder.append(this.d);
        stringBuilder.append(",httpResponseStatus=");
        stringBuilder.append(this.e);
        stringBuilder.append(",ret=");
        stringBuilder.append(this.f);
        if (this.o != null) {
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append(i.b(this.o.a) ? this.o.a() : this.o.a);
        }
        this.n = stringBuilder.toString();
    }

    public final synchronized i h() {
        if (this.s == null) {
            this.s = new i();
        }
        return this.s;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopStatistics [Detail]:");
        StringBuilder stringBuilder2 = new StringBuilder("startTime=");
        stringBuilder2.append(this.h);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder(",mtopResponseParseStartTime=");
        stringBuilder2.append(this.l);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder(",mtopResponseParseEndTime=");
        stringBuilder2.append(this.m);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder(",endTime=");
        stringBuilder2.append(this.i);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder("\nMtopStatistics[sumstat(ms)]:");
        stringBuilder2.append(this.n);
        stringBuilder.append(stringBuilder2.toString());
        if (this.s != null) {
            stringBuilder2 = new StringBuilder("\nrbStatData=");
            stringBuilder2.append(this.s);
            stringBuilder.append(stringBuilder2.toString());
        }
        return stringBuilder.toString();
    }

    public final void a() {
        this.h = System.nanoTime() / 1000000;
    }

    public final void b() {
        this.i = System.nanoTime() / 1000000;
    }

    public final void c() {
        this.l = System.nanoTime() / 1000000;
    }

    public final void d() {
        this.m = System.nanoTime() / 1000000;
    }

    public final void e() {
        this.j = System.nanoTime() / 1000000;
    }

    public final void f() {
        this.k = System.nanoTime() / 1000000;
    }
}
