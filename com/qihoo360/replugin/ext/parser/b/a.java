package com.qihoo360.replugin.ext.parser.b;

/* compiled from: ChunkHeader */
public class a {
    public int a;
    public int b;
    private long c;

    public a(int i, int i2, long j) {
        this.a = i;
        this.b = i2;
        this.c = j;
    }

    public final int a() {
        return (int) (this.c - ((long) this.b));
    }
}
