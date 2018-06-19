package mtopsdk.common.util;

public final class i {
    public static String a(String str, String str2) {
        if (!b(str)) {
            if (!b(str2)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str.trim());
                stringBuilder.append("$");
                stringBuilder.append(str2.trim());
                return stringBuilder.toString().toLowerCase();
            }
        }
        return null;
    }

    public static boolean a(String str) {
        return !b(str);
    }

    public static boolean b(String str) {
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
}
