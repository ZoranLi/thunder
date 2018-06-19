package com.taobao.accs.utl;

import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
public class g extends ByteArrayOutputStream {
    public g(int i) {
        super(i);
    }

    public g a(byte b) {
        write(b);
        return this;
    }

    public g a(short s) {
        write(s >> 8);
        write(s);
        return this;
    }
}
