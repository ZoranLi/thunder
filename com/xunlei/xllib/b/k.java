package com.xunlei.xllib.b;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: UriUtil */
public abstract class k {
    public static java.lang.String a(java.lang.String r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0 = java.net.URLEncoder.encode(r0, r1);	 Catch:{ Exception -> 0x0007 }
        goto L_0x0008;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static java.lang.String b(java.lang.String r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r0 == 0) goto L_0x0007;
    L_0x0002:
        r0 = java.net.URLDecoder.decode(r0, r1);	 Catch:{ Exception -> 0x0007 }
        goto L_0x0008;
    L_0x0007:
        r0 = 0;
    L_0x0008:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.b(java.lang.String, java.lang.String):java.lang.String");
    }

    public static String c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return h.b(str, str2);
        } catch (String str3) {
            str3.printStackTrace();
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return h.a(str);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("thunder://") == null) ? null : true;
    }

    public static java.lang.String c(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        r3 = 0;
        return r3;
    L_0x0008:
        r0 = new java.lang.StringBuilder;
        r1 = "thunder://";
        r0.<init>(r1);
        r1 = new java.lang.StringBuilder;
        r2 = "AA";
        r1.<init>(r2);
        r3 = r3.trim();
        r1.append(r3);
        r3 = "ZZ";
        r1.append(r3);
        r3 = r1.toString();
        r1 = 2;
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0032 }
        r2 = r3.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0032 }
        r2 = android.util.Base64.encodeToString(r2, r1);	 Catch:{ UnsupportedEncodingException -> 0x0032 }
        goto L_0x003a;
    L_0x0032:
        r3 = r3.getBytes();
        r2 = android.util.Base64.encodeToString(r3, r1);
    L_0x003a:
        r0.append(r2);
        r3 = r0.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.c(java.lang.String):java.lang.String");
    }

    public static java.lang.String d(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r4);
        r1 = 0;
        if (r0 != 0) goto L_0x0092;
    L_0x0007:
        r0 = "thunder://";
        r2 = r4.indexOf(r0);
        if (r2 >= 0) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r0.length();
        r2 = r2 + r0;
        r4 = r4.substring(r2);
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x003a;
    L_0x001f:
        r0 = "pa/";
        r0 = r4.endsWith(r0);
        if (r0 != 0) goto L_0x002f;
    L_0x0027:
        r0 = "=/";
        r0 = r4.endsWith(r0);
        if (r0 == 0) goto L_0x003a;
    L_0x002f:
        r0 = 0;
        r2 = r4.length();
        r2 = r2 + -1;
        r4 = r4.substring(r0, r2);
    L_0x003a:
        r0 = 2;
        r2 = "ISO-8859-1";	 Catch:{ IllegalArgumentException -> 0x0091, UnsupportedEncodingException -> 0x0046 }
        r2 = r4.getBytes(r2);	 Catch:{ IllegalArgumentException -> 0x0091, UnsupportedEncodingException -> 0x0046 }
        r2 = android.util.Base64.decode(r2, r0);	 Catch:{ IllegalArgumentException -> 0x0091, UnsupportedEncodingException -> 0x0046 }
        goto L_0x004e;
    L_0x0046:
        r4 = r4.getBytes();
        r2 = android.util.Base64.decode(r4, r0);
    L_0x004e:
        if (r2 == 0) goto L_0x0092;
    L_0x0050:
        r4 = 4;
        r3 = r2.length;
        if (r3 <= r4) goto L_0x0092;
    L_0x0054:
        r1 = r2.length;
        r1 = r1 - r4;
        r4 = com.xunlei.xllib.b.j.a(r2, r0, r1);
        r4 = r4.trim();
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x0090;
    L_0x0064:
        r0 = "http%3A%2F%2F";
        r0 = r4.startsWith(r0);
        if (r0 != 0) goto L_0x008c;
    L_0x006c:
        r0 = "https%3A%2F%2F";
        r0 = r4.startsWith(r0);
        if (r0 != 0) goto L_0x008c;
    L_0x0074:
        r0 = "ftp%3A%2F%2F";
        r0 = r4.startsWith(r0);
        if (r0 != 0) goto L_0x008c;
    L_0x007c:
        r0 = "magnet%3A%3F";
        r0 = r4.startsWith(r0);
        if (r0 != 0) goto L_0x008c;
    L_0x0084:
        r0 = "ed2k%3A%2F%2F";
        r0 = r4.startsWith(r0);
        if (r0 == 0) goto L_0x0090;
    L_0x008c:
        r4 = f(r4);
    L_0x0090:
        return r4;
    L_0x0091:
        return r1;
    L_0x0092:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.d(java.lang.String):java.lang.String");
    }

    public static java.lang.String e(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r5);
        if (r0 != 0) goto L_0x0094;
    L_0x0006:
        r0 = d(r5);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0094;
    L_0x0010:
        r1 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x001f, all -> 0x001d }
        r1 = com.xunlei.xllib.b.h.c(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x001f, all -> 0x001d }
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0039;
    L_0x001c:
        goto L_0x0038;
    L_0x001d:
        r5 = move-exception;
        goto L_0x002d;
    L_0x001f:
        r1 = "GBK";	 Catch:{ UnsupportedEncodingException -> 0x0026, all -> 0x001d }
        r1 = com.xunlei.xllib.b.h.c(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x0026, all -> 0x001d }
        goto L_0x0032;
    L_0x0026:
        r1 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x0031, all -> 0x001d }
        r1 = com.xunlei.xllib.b.h.c(r0, r1);	 Catch:{ UnsupportedEncodingException -> 0x0031, all -> 0x001d }
        goto L_0x0032;
    L_0x002d:
        android.text.TextUtils.isEmpty(r0);
        throw r5;
    L_0x0031:
        r1 = r0;
    L_0x0032:
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 == 0) goto L_0x0039;
    L_0x0038:
        r1 = r0;
    L_0x0039:
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 != 0) goto L_0x0094;
    L_0x003f:
        r0 = 0;
        r2 = r0;
    L_0x0041:
        r3 = r1.length();
        if (r2 >= r3) goto L_0x0064;
    L_0x0047:
        r3 = r1.charAt(r2);
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r3 < r4) goto L_0x0061;
    L_0x004f:
        r3 = r1.charAt(r2);
        r4 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        if (r3 > r4) goto L_0x0061;
    L_0x0057:
        r3 = r1.charAt(r2);
        r4 = 183; // 0xb7 float:2.56E-43 double:9.04E-322;
        if (r3 == r4) goto L_0x0061;
    L_0x005f:
        r2 = 1;
        goto L_0x0065;
    L_0x0061:
        r2 = r2 + 1;
        goto L_0x0041;
    L_0x0064:
        r2 = r0;
    L_0x0065:
        if (r2 == 0) goto L_0x0094;
    L_0x0067:
        r2 = "ISO-8859-1";	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r1 = r1.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r2 = r1.length;	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r0 = com.xunlei.xllib.b.j.a(r1, r0, r2);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        if (r1 != 0) goto L_0x0094;	 Catch:{ UnsupportedEncodingException -> 0x0090 }
    L_0x0078:
        r0 = r0.trim();	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r1 = " ";	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r2 = "%20";	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r0 = r0.replaceAll(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r0 = c(r0);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ UnsupportedEncodingException -> 0x0090 }
        if (r1 != 0) goto L_0x0094;
    L_0x008e:
        r5 = r0;
        goto L_0x0094;
    L_0x0090:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0094:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.e(java.lang.String):java.lang.String");
    }

    public static java.lang.String f(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r0 = "%";
        r0 = r1.contains(r0);
        if (r0 == 0) goto L_0x002d;
    L_0x000f:
        r0 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0016 }
        r0 = com.xunlei.xllib.b.h.a(r1, r0);	 Catch:{ UnsupportedEncodingException -> 0x0016 }
        goto L_0x002c;
    L_0x0016:
        r0 = "GBK";	 Catch:{ UnsupportedEncodingException -> 0x001d }
        r0 = com.xunlei.xllib.b.h.a(r1, r0);	 Catch:{ UnsupportedEncodingException -> 0x001d }
        goto L_0x002c;
    L_0x001d:
        r0 = "UTF-16";	 Catch:{ UnsupportedEncodingException -> 0x0024 }
        r0 = com.xunlei.xllib.b.h.a(r1, r0);	 Catch:{ UnsupportedEncodingException -> 0x0024 }
        goto L_0x002c;
    L_0x0024:
        r0 = "ISO-8859-1";	 Catch:{ Exception -> 0x002b, Exception -> 0x002b }
        r0 = com.xunlei.xllib.b.h.a(r1, r0);	 Catch:{ Exception -> 0x002b, Exception -> 0x002b }
        goto L_0x002c;
    L_0x002b:
        r0 = r1;
    L_0x002c:
        return r0;
    L_0x002d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.b.k.f(java.lang.String):java.lang.String");
    }

    public static List<String[]> g(String str) {
        int indexOf;
        List<String[]> arrayList;
        int i;
        int indexOf2;
        int i2;
        int indexOf3;
        String str2;
        if (str != null) {
            indexOf = str.indexOf("#");
            if (indexOf != -1) {
                str = str.substring(0, indexOf);
            }
            indexOf = str.indexOf("?");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                arrayList = new ArrayList();
                indexOf = str.length();
                i = 0;
                while (true) {
                    indexOf2 = str.indexOf(38, i);
                    i2 = indexOf2 == -1 ? indexOf2 : indexOf;
                    indexOf3 = str.indexOf(61, i);
                    if (indexOf3 > i2 || indexOf3 == -1) {
                        indexOf3 = i2;
                    }
                    if (indexOf3 > i) {
                        String substring = str.substring(i, indexOf3);
                        if (indexOf3 != i2) {
                            str2 = "";
                        } else {
                            str2 = str.substring(indexOf3 + 1, i2);
                        }
                        arrayList.add(new String[]{substring, str2});
                    }
                    if (indexOf2 != -1) {
                        return arrayList;
                    }
                    i = indexOf2 + 1;
                }
            }
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        arrayList = new ArrayList();
        indexOf = str.length();
        i = 0;
        while (true) {
            indexOf2 = str.indexOf(38, i);
            if (indexOf2 == -1) {
            }
            indexOf3 = str.indexOf(61, i);
            indexOf3 = i2;
            if (indexOf3 > i) {
                String substring2 = str.substring(i, indexOf3);
                if (indexOf3 != i2) {
                    str2 = str.substring(indexOf3 + 1, i2);
                } else {
                    str2 = "";
                }
                arrayList.add(new String[]{substring2, str2});
            }
            if (indexOf2 != -1) {
                return arrayList;
            }
            i = indexOf2 + 1;
        }
    }
}
