package com.alibaba.sdk.android.httpdns;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Pattern;

class g {
    private static Pattern a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");

    static String a(String str) {
        return new BigInteger(1, MessageDigest.getInstance("md5").digest(str.getBytes())).toString(16);
    }

    static String b(String str) {
        return new BigInteger(1, MessageDigest.getInstance("SHA1").digest(str.getBytes())).toString(16);
    }

    static boolean m11b(String str) {
        if (str != null) {
            char[] toCharArray = str.toCharArray();
            if (toCharArray.length <= 0 || toCharArray.length > 255) {
                return false;
            }
            for (char c : toCharArray) {
                if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && ((c < '0' || c > '9') && c != '.' && c != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    static boolean c(String str) {
        return str != null && str.length() >= 7 && str.length() <= 15 && !str.equals("") && a.matcher(str).matches();
    }
}
