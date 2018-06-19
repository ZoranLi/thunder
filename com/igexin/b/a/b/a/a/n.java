package com.igexin.b.a.b.a.a;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

public class n {
    private BufferedOutputStream a;

    public n(OutputStream outputStream) {
        this.a = new BufferedOutputStream(outputStream);
    }

    public void a() {
        this.a.close();
    }

    public void a(byte[] bArr) {
        this.a.write(bArr, 0, bArr.length);
        this.a.flush();
    }
}
