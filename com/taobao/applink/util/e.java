package com.taobao.applink.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Pattern;

public class e {
    public static String a(Map map) {
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    String str2 = (String) map.get(str);
                    if (str2 != null) {
                        try {
                            str2 = URLEncoder.encode(str2, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.toString();
                        }
                    }
                    String str3 = URLEncoder.encode(str3, "utf-8");
                    if (str2 != null) {
                        stringBuffer.append("&");
                        stringBuffer.append(str3);
                        stringBuffer.append("=");
                        stringBuffer.append(str2);
                    }
                }
                return stringBuffer.toString().substring(1);
            }
        }
        return "";
    }

    public static boolean a(String str) {
        if (str != null) {
            int length = str.length();
            if (length == 0) {
                return true;
            }
            for (int i = 0; i < length; i++) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean b(String str) {
        return a(str) ? false : Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean c(String str) {
        return a(str) ? false : Pattern.compile("^(http://|https://)?((?:[A-Za-z0-9]+-[A-Za-z0-9]+|[A-Za-z0-9]+)\\.)+([A-Za-z]+)[/\\?\\:]?.*$").matcher(str).matches();
    }
}
