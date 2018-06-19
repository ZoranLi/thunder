package com.tencent.tinker.ziputils.ziputil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: BUGLY */
public class TinkerZipUtil {
    private static final int BUFFER_SIZE = 16384;

    public static void extractTinkerEntry(TinkerZipFile tinkerZipFile, TinkerZipEntry tinkerZipEntry, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        try {
            tinkerZipFile = tinkerZipFile.getInputStream(tinkerZipEntry);
            try {
                tinkerZipOutputStream.putNextEntry(new TinkerZipEntry(tinkerZipEntry));
                tinkerZipEntry = new byte[16384];
                while (true) {
                    int read = tinkerZipFile.read(tinkerZipEntry);
                    if (read == -1) {
                        break;
                    }
                    tinkerZipOutputStream.write(tinkerZipEntry, 0, read);
                }
                tinkerZipOutputStream.closeEntry();
                if (tinkerZipFile != null) {
                    tinkerZipFile.close();
                }
            } catch (Throwable th) {
                tinkerZipEntry = th;
                if (tinkerZipFile != null) {
                    tinkerZipFile.close();
                }
                throw tinkerZipEntry;
            }
        } catch (Throwable th2) {
            tinkerZipEntry = th2;
            tinkerZipFile = null;
            if (tinkerZipFile != null) {
                tinkerZipFile.close();
            }
            throw tinkerZipEntry;
        }
    }

    public static void extractTinkerEntry(TinkerZipEntry tinkerZipEntry, InputStream inputStream, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        tinkerZipOutputStream.putNextEntry(tinkerZipEntry);
        tinkerZipEntry = new byte[16384];
        while (true) {
            int read = inputStream.read(tinkerZipEntry);
            if (read != -1) {
                tinkerZipOutputStream.write(tinkerZipEntry, 0, read);
            } else {
                tinkerZipOutputStream.closeEntry();
                return;
            }
        }
    }

    public static void extractLargeModifyFile(TinkerZipEntry tinkerZipEntry, File file, long j, TinkerZipOutputStream tinkerZipOutputStream) throws IOException {
        TinkerZipEntry tinkerZipEntry2 = new TinkerZipEntry(tinkerZipEntry);
        tinkerZipEntry2.setMethod(0);
        tinkerZipEntry2.setSize(file.length());
        tinkerZipEntry2.setCompressedSize(file.length());
        tinkerZipEntry2.setCrc(j);
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                tinkerZipOutputStream.putNextEntry(new TinkerZipEntry(tinkerZipEntry2));
                file = new byte[16384];
                while (true) {
                    j = bufferedInputStream.read(file);
                    if (j != -1) {
                        tinkerZipOutputStream.write(file, 0, j);
                    } else {
                        tinkerZipOutputStream.closeEntry();
                        bufferedInputStream.close();
                        return;
                    }
                }
            } catch (Throwable th) {
                tinkerZipEntry = th;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw tinkerZipEntry;
            }
        } catch (Throwable th2) {
            tinkerZipEntry = th2;
            bufferedInputStream = 0;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            throw tinkerZipEntry;
        }
    }
}
