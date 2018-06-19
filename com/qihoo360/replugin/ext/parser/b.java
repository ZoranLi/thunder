package com.qihoo360.replugin.ext.parser;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

/* compiled from: ApkParser */
public final class b extends a implements Closeable {
    private final ZipFile a;

    private b(File file) throws IOException {
        this.a = new ZipFile(file);
    }

    public b(String str) throws IOException {
        this(new File(str));
    }

    public final byte[] a(String str) throws IOException {
        str = this.a.getEntry(str);
        if (str == null) {
            return null;
        }
        return a(this.a.getInputStream(str));
    }

    public final void close() throws IOException {
        super.close();
        this.a.close();
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        Throwable th;
        try {
            byte[] bArr = new byte[8192];
            ByteArrayOutputStream byteArrayOutputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return bArr;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
