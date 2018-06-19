package com.xunlei.xllib.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel.MapMode;
import java.security.MessageDigest;

/* compiled from: MD5 */
public abstract class g {
    public static String a(byte[] bArr) {
        String str = "";
        try {
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest instance = MessageDigest.getInstance("MD5");
            int i = 0;
            if (bArr != null) {
                instance.update(bArr, 0, bArr.length);
            }
            bArr = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(32);
            int length = bArr.length;
            while (i < length) {
                byte b = bArr[i];
                stringBuilder.append(cArr[(b >> 4) & 15]);
                stringBuilder.append(cArr[b & 15]);
                i++;
            }
            return stringBuilder.toString();
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return str;
        }
    }

    public static String a(File file) {
        String str = "";
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                file = fileInputStream2.getChannel().map(MapMode.READ_ONLY, 0, file.length());
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(file);
                file = instance.digest();
                char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
                StringBuilder stringBuilder = new StringBuilder(32);
                for (byte b : file) {
                    stringBuilder.append(cArr[(b >> 4) & 15]);
                    stringBuilder.append(cArr[b & 15]);
                }
                file = stringBuilder.toString();
                try {
                    fileInputStream2.close();
                    return file;
                } catch (IOException e) {
                    e.printStackTrace();
                    return file;
                }
            } catch (Exception e2) {
                file = e2;
                fileInputStream = fileInputStream2;
                try {
                    file.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (File file2) {
                            file2.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th) {
                    file2 = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw file2;
                }
            } catch (Throwable th2) {
                file2 = th2;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                throw file2;
            }
        } catch (Exception e4) {
            file2 = e4;
            file2.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str;
        }
    }
}
