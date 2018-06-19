package com.xunlei.downloadprovider.ad.c.b;

/* compiled from: LocationInfo */
public class a {
    public double a = -1.0d;
    public double b = -1.0d;
    public int c;
    public String d = "";
    public String e = "";
    public String f = "";

    public a(double d, double d2, String str, String str2, String str3) {
        this.a = d;
        this.b = d2;
        this.c = Double.MIN_VALUE;
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ADLocation{lat=");
        stringBuilder.append(this.a);
        stringBuilder.append(", lon=");
        stringBuilder.append(this.b);
        stringBuilder.append(", geotype=");
        stringBuilder.append(this.c);
        stringBuilder.append(", country='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", prov='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", city='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
