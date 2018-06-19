package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: ProGuard */
public final class a {
    private static final j a = new j(ZipConstants.ENDSIG);
    private static final k b = new k(38651);

    /* compiled from: ProGuard */
    private static class a {
        Properties a;
        byte[] b;

        private a() {
            this.a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int length = a.b.a().length;
                byte[] bArr2 = new byte[length];
                wrap.get(bArr2);
                if (!a.b.equals(new k(bArr2))) {
                    StringBuilder stringBuilder = new StringBuilder("unknow protocl [");
                    stringBuilder.append(Arrays.toString(bArr));
                    stringBuilder.append("]");
                    throw new ProtocolException(stringBuilder.toString());
                } else if (bArr.length - length > 2) {
                    byte[] bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int b = new k(bArr3).b();
                    if ((bArr.length - length) - 2 >= b) {
                        byte[] bArr4 = new byte[b];
                        wrap.get(bArr4);
                        this.a.load(new ByteArrayInputStream(bArr4));
                        bArr = ((bArr.length - length) - b) - 2;
                        if (bArr > null) {
                            this.b = new byte[bArr];
                            wrap.get(this.b);
                        }
                    }
                }
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("ApkExternalInfo [p=");
            stringBuilder.append(this.a);
            stringBuilder.append(", otherData=");
            stringBuilder.append(Arrays.toString(this.b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                file = a(randomAccessFile);
                if (file == null) {
                    randomAccessFile.close();
                    return null;
                }
                a aVar = new a();
                aVar.a(file);
                file = aVar.a.getProperty(str);
                randomAccessFile.close();
                return file;
            } catch (Throwable th) {
                file = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw file;
            }
        } catch (Throwable th2) {
            file = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw file;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        int i;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a = a.a();
        byte read = randomAccessFile.read();
        while (true) {
            i = 1;
            if (read != (byte) -1) {
                if (read == a[0] && randomAccessFile.read() == a[1] && randomAccessFile.read() == a[2] && randomAccessFile.read() == a[3]) {
                    break;
                }
                long j = length - 1;
                randomAccessFile.seek(j);
                read = randomAccessFile.read();
                length = j;
            } else {
                break;
            }
            if (i != 0) {
                throw new ZipException("archive is not a ZIP archive");
            }
            randomAccessFile.seek((length + 16) + 4);
            a = new byte[2];
            randomAccessFile.readFully(a);
            int b = new k(a).b();
            if (b == 0) {
                return null;
            }
            a = new byte[b];
            randomAccessFile.read(a);
            return a;
        }
        i = 0;
        if (i != 0) {
            randomAccessFile.seek((length + 16) + 4);
            a = new byte[2];
            randomAccessFile.readFully(a);
            int b2 = new k(a).b();
            if (b2 == 0) {
                return null;
            }
            a = new byte[b2];
            randomAccessFile.read(a);
            return a;
        }
        throw new ZipException("archive is not a ZIP archive");
    }
}
