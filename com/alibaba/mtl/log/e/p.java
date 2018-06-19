package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: StringUtils */
public final class p {
    private static String a(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return ((String) obj).toString();
        }
        StringBuilder stringBuilder;
        if (obj instanceof Integer) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Integer) obj).intValue());
            return stringBuilder.toString();
        } else if (obj instanceof Long) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Long) obj).longValue());
            return stringBuilder.toString();
        } else if (obj instanceof Double) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Double) obj).doubleValue());
            return stringBuilder.toString();
        } else if (obj instanceof Float) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Float) obj).floatValue());
            return stringBuilder.toString();
        } else if (obj instanceof Short) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Short) obj).shortValue());
            return stringBuilder.toString();
        } else if (obj instanceof Byte) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(((Byte) obj).byteValue());
            return stringBuilder.toString();
        } else if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        } else {
            if (obj instanceof Character) {
                return ((Character) obj).toString();
            }
            return obj.toString();
        }
    }

    public static Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return map;
        }
        Map<String, String> hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (str instanceof String) {
                String str2 = (String) map.get(str);
                if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                    try {
                        hashMap.put(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(str2, "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return hashMap;
    }

    public static String b(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        Object obj = 1;
        for (Object obj2 : map.keySet()) {
            String a = a(map.get(obj2));
            String a2 = a(obj2);
            if (!(a == null || a2 == null)) {
                if (obj != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(a2);
                    stringBuilder.append("=");
                    stringBuilder.append(a);
                    stringBuffer.append(stringBuilder.toString());
                    obj = null;
                } else {
                    stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a2);
                    stringBuilder2.append("=");
                    stringBuilder2.append(a);
                    stringBuffer.append(stringBuilder2.toString());
                }
            }
        }
        return stringBuffer.toString();
    }
}
