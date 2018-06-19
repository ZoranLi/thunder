package com.ali.auth.third.core.f;

public final class f {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User [userId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", openId=");
        stringBuilder.append(this.f);
        stringBuilder.append(", openSid= ");
        stringBuilder.append(this.g);
        stringBuilder.append(", nick=");
        stringBuilder.append(this.b);
        stringBuilder.append(",deviceTokenKey=");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.d);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append(",deviceTokenSalt=");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.e);
        stringBuilder.append(stringBuilder2.toString());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
