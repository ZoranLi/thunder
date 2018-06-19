package mtopsdk.mtop.common;

public final class n extends h {
    String a;
    int b;
    int c;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("MtopProgressEvent [");
        stringBuilder.append("desc=");
        stringBuilder.append(this.a);
        stringBuilder.append(", size=");
        stringBuilder.append(this.b);
        stringBuilder.append(", total=");
        stringBuilder.append(this.c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
