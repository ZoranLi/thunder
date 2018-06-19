package mtopsdk.mtop.common;

import java.util.Map;

public final class j extends h {
    private int a;
    private Map b;

    public j(int i, Map map) {
        this.a = i;
        this.b = map;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopHeaderEvent [");
        stringBuilder.append("code=");
        stringBuilder.append(this.a);
        stringBuilder.append(", header=");
        stringBuilder.append(this.b);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
