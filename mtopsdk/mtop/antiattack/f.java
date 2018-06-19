package mtopsdk.mtop.antiattack;

final class f {
    public String a;
    public long b;
    public long c;

    public f(String str, long j, long j2) {
        this.a = str;
        this.b = j;
        this.c = j2;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LockedEntity [");
        stringBuilder.append("key=");
        stringBuilder.append(this.a);
        stringBuilder.append(", lockStartTime=");
        stringBuilder.append(this.b);
        stringBuilder.append(", lockInterval=");
        stringBuilder.append(this.c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
