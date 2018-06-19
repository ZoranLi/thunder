package com.xunlei.downloadprovider.app.b;

/* compiled from: TimeTrace */
public final class d {
    public String a;
    public long b;
    public long c;
    private String d;
    private int e = 0;

    public d(String str) {
        this.d = str;
    }

    public final d a(String str) {
        StringBuilder stringBuilder;
        this.e++;
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        long currentTimeMillis2 = System.currentTimeMillis() - this.c;
        this.c = System.currentTimeMillis();
        if (str == null) {
            str = "";
        } else {
            stringBuilder = new StringBuilder(" ");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder("Step");
        stringBuilder.append(this.e);
        stringBuilder.append(" ");
        stringBuilder.append(this.a);
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(currentTimeMillis);
        stringBuilder.append("ms(");
        stringBuilder.append(currentTimeMillis2);
        stringBuilder.append("ms)");
        return this;
    }
}
