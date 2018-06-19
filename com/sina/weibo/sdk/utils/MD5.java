package com.sina.weibo.sdk.utils;

import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import java.security.MessageDigest;

public class MD5 {
    private static final char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String hexdigest(String str) {
        try {
            return hexdigest(str.getBytes());
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String hexdigest(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr = instance.digest();
            char[] cArr = new char[32];
            int i = 0;
            int i2 = 0;
            while (i < 16) {
                byte b = bArr[i];
                int i3 = i2 + 1;
                cArr[i2] = hexDigits[(b >>> 4) & 15];
                i2 = i3 + 1;
                cArr[i3] = hexDigits[b & 15];
                i++;
            }
            return new String(cArr);
        } catch (byte[] bArr2) {
            bArr2.printStackTrace();
            return null;
        }
    }

    public static void main(String[] strArr) {
        System.out.println(hexdigest(c.a));
    }
}
