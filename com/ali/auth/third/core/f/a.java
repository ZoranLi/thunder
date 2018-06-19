package com.ali.auth.third.core.f;

import java.util.Map;

public final class a {
    public String a;
    public long b;
    public long c;
    public String d;
    public String e;
    public String f;
    public f g;
    public Map<String, Object> h;
    public String[] i;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InternalSession [sid=");
        stringBuilder.append(this.a);
        stringBuilder.append(", expireIn=");
        stringBuilder.append(this.b);
        stringBuilder.append(", loginTime=");
        stringBuilder.append(this.c);
        stringBuilder.append(", autoLoginToken=");
        stringBuilder.append(this.f);
        stringBuilder.append(", user=");
        stringBuilder.append(this.g.toString());
        stringBuilder.append(", otherInfo=");
        stringBuilder.append(this.h);
        stringBuilder.append(", cookies=");
        if (this.i != null) {
            for (String append : this.i) {
                stringBuilder.append(append);
            }
        } else {
            stringBuilder.append("null");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
