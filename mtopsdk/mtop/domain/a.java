package mtopsdk.mtop.domain;

import java.util.Arrays;

public abstract class a implements b {
    private String a;
    private String b;
    private String[] c;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("BaseOutDo [api=");
        stringBuilder.append(this.a);
        stringBuilder.append(", v=");
        stringBuilder.append(this.b);
        stringBuilder.append(", ret=");
        stringBuilder.append(Arrays.toString(this.c));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
