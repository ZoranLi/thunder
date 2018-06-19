package com.igexin.push.f.a;

import com.igexin.b.a.d.a;
import java.io.InputStream;

public abstract class b extends a {
    String b;
    byte[] c;
    InputStream d;
    long e;
    public boolean f;

    public b(String str) {
        this.b = str;
    }

    public void a(Exception exception) {
    }

    public void a(byte[] bArr) {
        this.f = false;
        if (bArr != null && bArr.length >= 7 && bArr[5] == (byte) 111 && bArr[6] == (byte) 107) {
            this.f = true;
        }
    }

    public void b(byte[] bArr) {
        this.c = bArr;
    }

    public String c() {
        return this.b;
    }

    public byte[] d() {
        return this.c;
    }

    public InputStream e() {
        return this.d;
    }

    public long f() {
        return this.e;
    }
}
