package com.xunlei.analytics.dbstore;

public class b {
    public String a;
    public String b;
    public String c;
    public int d;

    public b(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("_ID=");
        stringBuilder.append(this.d);
        stringBuilder.append(", mAppId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", mInterId=");
        stringBuilder.append(this.b);
        stringBuilder.append(", mEventData=");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
