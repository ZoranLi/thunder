package com.qihoo360.replugin.component.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.zip.GZIPInputStream;

/* compiled from: ApkCommentReader */
public final class a {
    private static final byte[] a = new byte[]{(byte) 40, (byte) 77, (byte) 83, (byte) 45, (byte) 80, (byte) 76, (byte) 71, (byte) 41};

    public static String a(String str) {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                str = a(a(randomAccessFile2));
                try {
                    randomAccessFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return str;
            } catch (IOException e2) {
                str = e2;
                randomAccessFile = randomAccessFile2;
                try {
                    str.printStackTrace();
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (String str2) {
                            str2.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    str2 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw str2;
                }
            } catch (Throwable th2) {
                str2 = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw str2;
            }
        } catch (IOException e4) {
            str2 = e4;
            str2.printStackTrace();
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return "";
        }
    }

    private static byte[] a(RandomAccessFile randomAccessFile) {
        try {
            long length = randomAccessFile.length() - ((long) a.length);
            randomAccessFile.seek(length);
            byte[] bArr = new byte[a.length];
            randomAccessFile.readFully(bArr);
            if (!Arrays.equals(bArr, a)) {
                return null;
            }
            long j = length - 2;
            randomAccessFile.seek(j);
            bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            int i = (bArr[0] & 255) | ((bArr[1] << 8) & 65280);
            if (i > 0) {
                randomAccessFile.seek(j - ((long) i));
                bArr = new byte[i];
                randomAccessFile.readFully(bArr);
                return bArr;
            }
            return null;
        } catch (RandomAccessFile randomAccessFile2) {
            randomAccessFile2.printStackTrace();
        }
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                bArr = new GZIPInputStream(new ByteArrayInputStream(bArr));
                byte[] bArr2 = new byte[256];
                while (true) {
                    int read = bArr.read(bArr2);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr2, 0, read);
                }
                bArr = byteArrayOutputStream2.toString("utf-8");
                try {
                    byteArrayOutputStream2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return bArr;
            } catch (IOException e2) {
                bArr = e2;
                byteArrayOutputStream = byteArrayOutputStream2;
                try {
                    bArr.printStackTrace();
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (byte[] bArr3) {
                            bArr3.printStackTrace();
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    bArr3 = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw bArr3;
                }
            } catch (Throwable th2) {
                bArr3 = th2;
                if (byteArrayOutputStream2 != null) {
                    byteArrayOutputStream2.close();
                }
                throw bArr3;
            }
        } catch (IOException e4) {
            bArr3 = e4;
            bArr3.printStackTrace();
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
            return "";
        }
    }
}
