package com.umeng.message.proguard;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;

/* compiled from: NetUtil */
public class i {
    public static String a(Map<String, Object> map, String str) {
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(str);
                Set<String> keySet = map.keySet();
                if (str.endsWith("?") == null) {
                    stringBuilder.append("?");
                }
                for (String str2 : keySet) {
                    String str22;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(str22));
                    stringBuilder2.append("=");
                    if (map.get(str22) == null) {
                        str22 = "";
                    } else {
                        str22 = map.get(str22).toString();
                    }
                    stringBuilder2.append(URLEncoder.encode(str22));
                    stringBuilder2.append("&");
                    stringBuilder.append(stringBuilder2.toString());
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                return stringBuilder.toString();
            }
        }
        return str;
    }
}
