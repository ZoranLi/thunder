package mtopsdk.mtop.common;

import mtopsdk.mtop.domain.b;

public final class a implements b {
    public volatile mtopsdk.a.a a;
    private mtopsdk.mtop.a b;

    public a(mtopsdk.a.a aVar, mtopsdk.mtop.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ApiID [");
        stringBuilder.append("call=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mtopProxy=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
