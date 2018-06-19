package com.ali.auth.third.core.f;

public final class e {
    public String a;
    public String b;
    public String c;
    public String d;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("nick = ");
        stringBuilder.append(this.a);
        stringBuilder.append(", ava = ");
        stringBuilder.append(this.b);
        stringBuilder.append(" , openId=");
        stringBuilder.append(this.c);
        stringBuilder.append(", openSid=");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }
}
