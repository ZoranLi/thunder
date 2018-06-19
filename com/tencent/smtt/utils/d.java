package com.tencent.smtt.utils;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class d implements Closeable {
    private final RandomAccessFile a;
    private final File b;
    private final byte[] c;
    private boolean d;

    public d(File file) {
        this.c = new byte[8];
        this.b = file;
        this.a = new RandomAccessFile(this.b, "r");
    }

    public d(String str) {
        this(new File(str));
    }

    public final int a() {
        int readInt = this.a.readInt();
        if (!this.d) {
            return readInt;
        }
        return ((readInt & -16777216) >>> 24) | ((((readInt & 255) << 24) | ((65280 & readInt) << 8)) | ((16711680 & readInt) >>> 8));
    }

    public final int a(char[] cArr) {
        byte[] bArr = new byte[cArr.length];
        int read = this.a.read(bArr);
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char) bArr[i];
        }
        return read;
    }

    public void a(long j) {
        this.a.seek(j);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void close() {
        try {
            this.a.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
