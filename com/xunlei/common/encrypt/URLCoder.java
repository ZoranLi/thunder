package com.xunlei.common.encrypt;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLCoder {
    public static String decode(String str, String str2) {
        if (str2 == null) {
            try {
                str2 = "UTF-8";
            } catch (String str3) {
                throw new IllegalArgumentException(str3);
            }
        }
        return URLDecoder.decode(str3, str2);
    }

    public static String encode(String str, String str2) {
        if (str2 == null) {
            try {
                str2 = "UTF-8";
            } catch (String str3) {
                throw new IllegalArgumentException(str3);
            }
        }
        return URLEncoder.encode(str3, str2);
    }
}
