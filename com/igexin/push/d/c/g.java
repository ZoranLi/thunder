package com.igexin.push.d.c;

public class g {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte g;
    public byte h;
    public byte i;
    public byte j;
    public byte k;
    public byte l;
    public byte m;
    public byte[] n;
    public int o;
    public int p;
    public int q;

    public int a() {
        this.d |= this.g;
        this.d |= this.h;
        this.d |= this.i;
        return this.d;
    }

    public void a(byte b) {
        this.d = b & 255;
        this.g = (byte) (b & 192);
        this.h = (byte) (b & 48);
        this.i = (byte) (b & 15);
    }

    public int b() {
        this.f |= this.j;
        this.f |= this.k;
        this.f |= this.l;
        this.f |= this.m;
        return this.f;
    }
}
