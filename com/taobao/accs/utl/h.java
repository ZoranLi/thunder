package com.taobao.accs.utl;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/* compiled from: Taobao */
public class h extends ByteArrayInputStream {
    public h(byte[] bArr) {
        super(bArr);
    }

    public int a() {
        return read() & 255;
    }

    public int b() {
        return (a() << 8) | a();
    }

    public String a(int i) throws IOException {
        byte[] bArr = new byte[i];
        int read = read(bArr);
        if (read == i) {
            return new String(bArr, "utf-8");
        }
        StringBuilder stringBuilder = new StringBuilder("read len not match. ask for ");
        stringBuilder.append(i);
        stringBuilder.append(" but read for ");
        stringBuilder.append(read);
        throw new IOException(stringBuilder.toString());
    }

    public byte[] c() throws IOException {
        byte[] bArr = new byte[available()];
        read(bArr);
        return bArr;
    }
}
