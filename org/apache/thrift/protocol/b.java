package org.apache.thrift.protocol;

public class b {
    public final String a;
    public final byte b;
    public final short c;

    public b() {
        this("", (byte) 0, (short) 0);
    }

    public b(String str, byte b, short s) {
        this.a = str;
        this.b = b;
        this.c = s;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("<TField name:'");
        stringBuilder.append(this.a);
        stringBuilder.append("' type:");
        stringBuilder.append(this.b);
        stringBuilder.append(" field-id:");
        stringBuilder.append(this.c);
        stringBuilder.append(">");
        return stringBuilder.toString();
    }
}
