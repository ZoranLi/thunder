package com.xunlei.downloadprovider.member.login;

/* compiled from: GetUserInfoResp */
public final class b {
    public int a;
    public int b;
    public long c;
    public long d;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("mResult:");
        stringBuilder.append(this.a);
        stringBuilder.append(",maxTaskNum:");
        stringBuilder.append(this.b);
        stringBuilder.append(",maxSpace");
        stringBuilder.append(this.d);
        stringBuilder.append(",availableSpace:");
        stringBuilder.append(this.c);
        return stringBuilder.toString();
    }
}
