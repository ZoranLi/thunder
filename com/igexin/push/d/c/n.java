package com.igexin.push.d.c;

import com.igexin.b.a.b.f;

public class n extends e {
    public long a;

    public n() {
        this.i = 36;
        this.j = (byte) 20;
    }

    public void a(byte[] bArr) {
        this.a = f.e(bArr, 0);
    }

    public byte[] d() {
        byte[] bArr = new byte[8];
        f.a(this.a, bArr, 0);
        return bArr;
    }
}
