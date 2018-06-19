package mtopsdk.a.b;

import java.util.Map;

public final class b {
    public final String a;
    public final String b;
    public final Map c;
    public final d d;
    public final int e;
    public final int f;
    public final int g;
    private final String h;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Request{body=");
        stringBuilder.append(this.d);
        stringBuilder.append(", url='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", method='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", headers=");
        stringBuilder.append(this.c);
        stringBuilder.append(", seqNo='");
        stringBuilder.append(this.h);
        stringBuilder.append('\'');
        stringBuilder.append(", connectTimeoutMills=");
        stringBuilder.append(this.e);
        stringBuilder.append(", readTimeoutMills=");
        stringBuilder.append(this.f);
        stringBuilder.append(", retryTimes=");
        stringBuilder.append(this.g);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private b(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
        this.d = cVar.d;
        this.h = cVar.e;
        this.e = cVar.f;
        this.f = cVar.g;
        this.g = cVar.h;
    }
}
