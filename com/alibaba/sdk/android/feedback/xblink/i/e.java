package com.alibaba.sdk.android.feedback.xblink.i;

public enum e {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");
    
    private String j;
    private String k;

    private e(String str, String str2) {
        this.j = str;
        this.k = str2;
    }

    public static e[] a() {
        return (e[]) l.clone();
    }

    public final String b() {
        return this.j;
    }

    public final String c() {
        return this.k;
    }
}
