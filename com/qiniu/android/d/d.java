package com.qiniu.android.d;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;

/* compiled from: Crc32 */
public final class d {
    public static long a(byte[] bArr, int i) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, 0, i);
        return crc32.getValue();
    }

    public static long a(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        file = new byte[65536];
        CRC32 crc32 = new CRC32();
        while (true) {
            try {
                int read = fileInputStream.read(file);
                if (read == -1) {
                    break;
                }
                crc32.update(file, 0, read);
            } catch (File file2) {
                file2.printStackTrace();
            } catch (Throwable th) {
                fileInputStream.close();
            }
        }
        fileInputStream.close();
        return crc32.getValue();
    }
}
