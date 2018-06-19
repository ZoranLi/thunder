package com.ta.utdid2.android.utils;

public class StringUtils {
    public static boolean isEmpty(String str) {
        return (str == null || str.length() <= null) ? true : null;
    }

    public static String convertObjectToString(Object obj) {
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

    public static int hashCode(String str) {
        int i = 0;
        if (str.length() <= 0) {
            return 0;
        }
        str = str.toCharArray();
        int i2 = 0;
        while (i < str.length) {
            i2 = str[i] + (31 * i2);
            i++;
        }
        return i2;
    }
}
