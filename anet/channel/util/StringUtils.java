package anet.channel.util;

import android.text.TextUtils;

/* compiled from: Taobao */
public class StringUtils {
    private static final char[] DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String stringNull2Empty(String str) {
        return str == null ? "" : str;
    }

    public static String[] parseURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("//")) {
            StringBuilder stringBuilder = new StringBuilder("http:");
            stringBuilder.append(str);
            str = stringBuilder.toString();
        }
        int indexOf = str.indexOf(HttpConstant.SCHEME_SPLIT);
        if (indexOf == -1) {
            return null;
        }
        String[] strArr = new String[2];
        String substring = str.substring(0, indexOf);
        if (!HttpConstant.HTTP.equalsIgnoreCase(substring) && !"https".equalsIgnoreCase(substring)) {
            return null;
        }
        strArr[0] = substring;
        int length = str.length();
        indexOf += 3;
        int i = indexOf;
        while (i < length) {
            char charAt = str.charAt(i);
            if (!(charAt == '/' || charAt == ':' || charAt == '?')) {
                if (charAt != '#') {
                    i++;
                }
            }
            strArr[1] = str.substring(indexOf, i);
            return strArr;
        }
        if (i != length) {
            return null;
        }
        strArr[1] = str.substring(indexOf);
        return strArr;
    }

    public static String concatString(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder(str.length() + str2.length());
        stringBuilder.append(str);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public static String concatString(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder((str.length() + str2.length()) + str3.length());
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }

    public static String buildKey(String str, String str2) {
        return concatString(str, HttpConstant.SCHEME_SPLIT, str2);
    }

    public static String simplifyString(String str, int i) {
        if (str.length() <= i) {
            return str;
        }
        return concatString(str.substring(0, i), "......");
    }

    public static java.lang.String md5ToHex(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "MD5";	 Catch:{ Exception -> 0x0019 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0019 }
        r2 = "utf-8";	 Catch:{ Exception -> 0x0019 }
        r3 = r3.getBytes(r2);	 Catch:{ Exception -> 0x0019 }
        r3 = r1.digest(r3);	 Catch:{ Exception -> 0x0019 }
        r3 = bytesToHexString(r3);	 Catch:{ Exception -> 0x0019 }
        return r3;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.StringUtils.md5ToHex(java.lang.String):java.lang.String");
    }

    private static String bytesToHexString(byte[] bArr, char[] cArr) {
        int i = 0;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            cArr2[i2] = cArr[(240 & bArr[i]) >>> 4];
            i2 = i3 + 1;
            cArr2[i3] = cArr[15 & bArr[i]];
            i++;
        }
        return new String(cArr2);
    }

    public static String bytesToHexString(byte[] bArr) {
        return bArr == null ? "" : bytesToHexString(bArr, DIGITS_LOWER);
    }

    public static String longToIP(long j) {
        StringBuilder stringBuilder = new StringBuilder(16);
        long j2 = 1000000000;
        do {
            stringBuilder.append(j / j2);
            stringBuilder.append('.');
            j %= j2;
            j2 /= 1000;
        } while (j2 > 0);
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static boolean isNotBlank(String str) {
        return isBlank(str) == null ? true : null;
    }

    public static boolean isBlank(String str) {
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
