package com.igexin.push.c;

public final class e {
    public String a;
    public long b;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ServerAddress{address='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", outdateTime=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
