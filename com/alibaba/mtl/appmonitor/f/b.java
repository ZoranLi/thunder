package com.alibaba.mtl.appmonitor.f;

/* compiled from: StringUtils */
public final class b {
    public static boolean a(String str) {
        return b(str) == null ? true : null;
    }

    public static boolean b(String str) {
        if (str != null) {
            int length = str.length();
            if (length != 0) {
                for (int i = 0; i < length; i++) {
                    if (!Character.isWhitespace(str.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }
}
