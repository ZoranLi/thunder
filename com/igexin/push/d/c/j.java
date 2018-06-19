package com.igexin.push.d.c;

public class j extends e {
    public byte a;
    public byte b;

    public j() {
        this.i = 97;
    }

    public void a(byte[] bArr) {
        this.a = bArr[0];
        this.b = bArr[1];
    }

    public byte[] d() {
        return new byte[]{this.a, this.b};
    }
}
