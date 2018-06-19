package com.getui.gtc.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

public class j {
    static final /* synthetic */ boolean a = true;

    private static String a(long j, long j2) {
        String format = new SimpleDateFormat("yyyy MM dd HH mm").format(Long.valueOf(j));
        long parseLong = Long.parseLong(format.split(" ")[1]);
        long parseLong2 = Long.parseLong(format.split(" ")[2]);
        parseLong = (((j2 * parseLong) / parseLong2) + Long.parseLong(format.split(" ")[4])) * Long.parseLong(format.split(" ")[3]);
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random(parseLong);
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public static String a(String str) {
        return c(str);
    }

    private static String a(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < 0 + i; i2++) {
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        return stringBuilder.toString();
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        Object a = g.a(bArr);
        if (a != null) {
            String c = c(String.valueOf(System.currentTimeMillis()));
            int length = a.length;
            Object obj = new byte[(length + 16)];
            if (a || c != null) {
                Object bytes = c.substring(0, 8).getBytes();
                Object bytes2 = c.substring(24, 32).getBytes();
                System.arraycopy(bytes, 0, obj, 0, 8);
                System.arraycopy(a, 0, obj, 8, length);
                System.arraycopy(bytes2, 0, obj, length + 8, 8);
                bArr2 = obj;
            } else {
                throw new AssertionError();
            }
        }
        return bArr2;
    }

    public static String b(String str) {
        Exception exception;
        String str2 = "0";
        File file = new File(str);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (instance != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Object obj = new byte[10240];
                    while (true) {
                        int read = fileInputStream.read(obj);
                        if (read <= 0) {
                            byte[] digest = instance.digest();
                            String a = a(digest, digest.length);
                            try {
                                fileInputStream.close();
                                return a;
                            } catch (Exception e) {
                                String str3 = a;
                                exception = e;
                                str2 = str3;
                                new String[1][0] = exception.toString();
                                return str2;
                            }
                        } else if (read < 10240) {
                            Object obj2 = new byte[read];
                            System.arraycopy(obj, 0, obj2, 0, read);
                            instance.update(obj2);
                        } else {
                            instance.update(obj);
                        }
                    }
                } catch (Exception e2) {
                    exception = e2;
                    new String[1][0] = exception.toString();
                    return str2;
                }
            }
            return str2;
        } catch (NoSuchAlgorithmException e3) {
            new String[1][0] = e3.toString();
            return str2;
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length >= 16) {
                Object obj = new byte[(bArr.length - 16)];
                System.arraycopy(bArr, 8, obj, 0, bArr.length - 16);
                return g.b(obj);
            }
        }
        return null;
    }

    private static String c(String str) {
        MessageDigest instance;
        byte[] bytes = str.getBytes();
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int i = 0;
        try {
            instance = MessageDigest.getInstance("MD5");
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            instance = null;
        }
        if (instance == null) {
            return null;
        }
        instance.update(bytes);
        bytes = instance.digest();
        char[] cArr2 = new char[32];
        int i2 = 0;
        while (i < 16) {
            byte b = bytes[i];
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            i2 = i3 + 1;
            cArr2[i3] = cArr[b & 15];
            i++;
        }
        return new String(cArr2);
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Object bytes = String.valueOf(currentTimeMillis).getBytes();
        String format = new SimpleDateFormat("yyyy MM dd HH mm ss").format(Long.valueOf(currentTimeMillis));
        format = String.valueOf(((Long.parseLong(format.split(" ")[5]) + 1) * currentTimeMillis) * (Long.parseLong(format.split(" ")[4]) + 1));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format.substring(0, 4));
        stringBuilder.append(format.substring(9, 13));
        Object a = i.a(bArr, a(currentTimeMillis, Long.parseLong(stringBuilder.toString())));
        Object obj = new byte[(a.length + bytes.length)];
        System.arraycopy(bytes, 0, obj, 0, bytes.length);
        System.arraycopy(a, 0, obj, bytes.length, a.length);
        a = d(obj);
        if (a != null) {
            int length = a.length;
            obj = new byte[(length + 8)];
            Object bytes2 = format.substring(0, 4).getBytes();
            bytes = format.substring(9, 13).getBytes();
            System.arraycopy(bytes2, 0, obj, 0, 4);
            System.arraycopy(a, 0, obj, 4, length);
            System.arraycopy(bytes, 0, obj, length + 4, 4);
            bArr2 = obj;
        }
        return bArr2;
    }

    private static byte[] d(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        IOException e;
        Throwable th;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.finish();
                bArr = byteArrayOutputStream.toByteArray();
                try {
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    return bArr;
                } catch (IOException e2) {
                    new String[1][0] = e2.toString();
                    return bArr;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    new String[1][0] = e.toString();
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e4) {
                            new String[1][0] = e4.toString();
                            return null;
                        }
                    }
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e22) {
                            new String[1][0] = e22.toString();
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            }
        } catch (IOException e5) {
            e4 = e5;
            gZIPOutputStream = null;
            new String[1][0] = e4.toString();
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            return null;
        } catch (Throwable th3) {
            th = th3;
            gZIPOutputStream = null;
            if (gZIPOutputStream != null) {
                gZIPOutputStream.close();
            }
            byteArrayOutputStream.close();
            throw th;
        }
    }
}
