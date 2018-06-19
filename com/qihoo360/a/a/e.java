package com.qihoo360.a.a;

import com.qihoo360.replugin.utils.b;
import java.io.Closeable;
import java.io.FileInputStream;

/* compiled from: SysUtils */
public final class e {
    public static String a() {
        Closeable fileInputStream;
        Throwable th;
        Throwable th2;
        try {
            fileInputStream = new FileInputStream("/proc/self/cmdline");
            try {
                String str;
                byte[] bArr = new byte[256];
                int i = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read > 0 && i < 256) {
                        int i2 = i + 1;
                        bArr[i] = (byte) read;
                        i = i2;
                    } else if (i > 0) {
                        str = new String(bArr, 0, i, "UTF-8");
                        b.a(fileInputStream);
                        return str;
                    }
                }
                if (i > 0) {
                    str = new String(bArr, 0, i, "UTF-8");
                    b.a(fileInputStream);
                    return str;
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.getMessage();
                    b.a(fileInputStream);
                    return null;
                } catch (Throwable th4) {
                    th2 = th4;
                    b.a(fileInputStream);
                    throw th2;
                }
            }
        } catch (Throwable th5) {
            fileInputStream = null;
            th2 = th5;
            b.a(fileInputStream);
            throw th2;
        }
        b.a(fileInputStream);
        return null;
    }
}
