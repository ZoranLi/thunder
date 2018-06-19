package com.igexin.push.d.c;

import com.igexin.b.a.b.f;
import com.igexin.push.util.EncryptUtils;

public class b {
    public int a;
    public byte b;
    public byte c;
    public byte d;
    public byte[] e;
    public int f;
    public byte g;

    public void a(byte[] bArr) {
        int i;
        if (bArr == null) {
            i = 0;
        } else {
            this.e = bArr;
            i = bArr.length;
        }
        this.a = i;
    }

    public byte[] a() {
        if (this.e == null) {
            return null;
        }
        byte[] bArr = new byte[(this.a + 11)];
        int a = f.a(EncryptUtils.getPacketId(), bArr, 0);
        a += f.a((int) (System.currentTimeMillis() / 1000), bArr, a);
        a += f.b(this.a, bArr, a);
        f.a(this.e, 0, bArr, a + f.c(this.b, bArr, a), this.e.length);
        return bArr;
    }
}
