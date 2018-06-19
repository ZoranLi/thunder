package com.xunlei.downloadprovider.web.website.b;

/* compiled from: CollectWebsiteInfo */
public class c extends e {
    public Long a;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "0";

    public c(Long l, String str, String str2, String str3, String str4) {
        this.a = l;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.d;
    }

    public final long d() {
        if (this.e == null) {
            return 0;
        }
        return Long.parseLong(this.e);
    }

    public final void a(long j) {
        this.e = String.valueOf(j);
    }
}
