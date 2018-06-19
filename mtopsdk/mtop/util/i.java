package mtopsdk.mtop.util;

public final class i implements Cloneable {
    public long a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public int h;
    final /* synthetic */ h i;

    private i(h hVar) {
        this.i = hVar;
        this.h = 0;
    }

    public final Object clone() {
        return super.clone();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("rbReqTime=");
        stringBuilder.append(this.d);
        stringBuilder.append(",mtopReqTime=");
        stringBuilder.append(this.a);
        stringBuilder.append(",mtopJsonParseTime=");
        stringBuilder.append(this.e);
        stringBuilder.append(",toMainThTime=");
        stringBuilder.append(this.g);
        stringBuilder.append(",isCache=");
        stringBuilder.append(this.h);
        stringBuilder.append(",beforeReqTime=");
        stringBuilder.append(this.b);
        stringBuilder.append(",afterReqTime=");
        stringBuilder.append(this.c);
        stringBuilder.append(",parseTime=");
        stringBuilder.append(this.f);
        return stringBuilder.toString();
    }
}
