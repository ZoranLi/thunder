package com.xunlei.analytics.b;

public class b {
    public static final String a = "1";
    public static final String b = "2";
    public static final String c = "3";
    public static final String d = "4";
    public static final String e = "2";
    public static final String f = "1";
    private String g;
    private String h;
    private String i;
    private long j;
    private d k;

    public b(String str, String str2, String str3, long j, d dVar) {
        this.g = str;
        this.h = str2;
        this.i = str3;
        this.j = j;
        this.k = dVar;
    }

    public String a() {
        return this.g;
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(d dVar) {
        this.k = dVar;
    }

    public void a(String str) {
        this.g = str;
    }

    public String b() {
        return this.h;
    }

    public void b(String str) {
        this.h = str;
    }

    public String c() {
        return this.i;
    }

    public void c(String str) {
        this.i = str;
    }

    public long d() {
        return this.j;
    }

    public d e() {
        return this.k;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Event{appId='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", interId='");
        stringBuilder.append(this.h);
        stringBuilder.append('\'');
        stringBuilder.append(", eventId='");
        stringBuilder.append(this.i);
        stringBuilder.append('\'');
        stringBuilder.append(", oprTime=");
        stringBuilder.append(this.j);
        stringBuilder.append(", extData=");
        stringBuilder.append(this.k);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
