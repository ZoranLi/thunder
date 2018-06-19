package com.qiniu.android.d;

/* compiled from: StringUtils */
public final class f {
    public static String a(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        int i = 0;
        int length = strArr.length;
        int length2 = !str.equals("") ? str.length() : 0;
        if (length == 0) {
            length2 = 0;
        } else {
            length2 = ((strArr[0] == null ? 16 : strArr[0].length()) + length2) * length;
        }
        StringBuilder stringBuilder = new StringBuilder(length2);
        while (i < length) {
            if (i > 0) {
                stringBuilder.append(str);
            }
            if (strArr[i] != null) {
                stringBuilder.append(strArr[i]);
            }
            i++;
        }
        return stringBuilder.toString();
    }

    public static String a(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt > '\u001f' && charAt < '') {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }
}
