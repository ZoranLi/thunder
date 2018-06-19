package anet.channel.strategy.utils;

import android.text.TextUtils;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Taobao */
public class d {
    public static String c(String str) {
        return str == null ? "" : str;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = str.toCharArray();
        if (str.length >= 7) {
            if (str.length <= 15) {
                int i = 0;
                int i2 = i;
                while (i < str.length) {
                    char c = str[i];
                    if (c >= '0' && c <= '9') {
                        i2 = ((i2 * 10) + c) - 48;
                        if (i2 > 255) {
                            return false;
                        }
                    } else if (c != '.') {
                        return false;
                    } else {
                        i2 = 0;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str = str.toCharArray();
        if (str.length > 0) {
            if (str.length <= 255) {
                int i = 0;
                boolean z = i;
                while (i < str.length) {
                    if ((str[i] >= 'A' && str[i] <= 'Z') || ((str[i] >= 'a' && str[i] <= 'z') || str[i] == '*')) {
                        z = true;
                    } else if (!((str[i] >= '0' && str[i] <= '9') || str[i] == '.' || str[i] == '-')) {
                        return false;
                    }
                    i++;
                }
                return z;
            }
        }
        return false;
    }

    public static String a(Map<String, List<String>> map, String str) {
        if (!(map == null || map.isEmpty())) {
            if (!TextUtils.isEmpty(str)) {
                map = map.entrySet().iterator();
                List list = null;
                while (map.hasNext()) {
                    Entry entry = (Entry) map.next();
                    if (str.equalsIgnoreCase((String) entry.getKey())) {
                        list = (List) entry.getValue();
                    }
                }
                if (list == null) {
                    return null;
                }
                return (String) list.get(null);
            }
        }
        return null;
    }

    public static String b(Map<String, String> map, String str) {
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(64);
                try {
                    map = map.entrySet().iterator();
                    while (map.hasNext()) {
                        Entry entry = (Entry) map.next();
                        if (entry.getKey() != null) {
                            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                            stringBuilder.append("=");
                            stringBuilder.append(URLEncoder.encode(StringUtils.stringNull2Empty((String) entry.getValue()), str).replace("+", "%20"));
                            stringBuilder.append("&");
                        }
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } catch (Map<String, String> map2) {
                    ALog.e("Request", "format params failed", null, map2, new Object[0]);
                }
                return stringBuilder.toString();
            }
        }
        return "";
    }
}
