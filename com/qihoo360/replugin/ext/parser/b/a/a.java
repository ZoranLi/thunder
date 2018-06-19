package com.qihoo360.replugin.ext.parser.b.a;

/* compiled from: Attribute */
public final class a {
    public String a;
    public String b;
    public String c;
    public String d;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Attribute{name='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", namespace='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
