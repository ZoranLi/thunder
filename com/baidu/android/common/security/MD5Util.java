package com.baidu.android.common.security;

import java.security.MessageDigest;

public final class MD5Util {
    private MD5Util() {
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (z) {
                toHexString = toHexString.toUpperCase();
            }
            if (toHexString.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(toHexString);
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static String toMd5(byte[] bArr, boolean z) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(bArr);
            return toHexString(instance.digest(), "", z);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
