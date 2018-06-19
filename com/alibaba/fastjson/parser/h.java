package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.a;

/* compiled from: SymbolTable */
public class h {
    private final String[] a = new String[4096];
    private final int b = 4095;

    public h() {
        a("$ref", 0, 4, "$ref".hashCode());
        a(a.DEFAULT_TYPE_KEY, 0, 5, a.DEFAULT_TYPE_KEY.hashCode());
    }

    public final String a(char[] cArr, int i, int i2) {
        int i3 = this.b & i2;
        String str = this.a[i3];
        if (str != null) {
            if (i2 == str.hashCode() && i == str.length()) {
                i2 = 0;
                while (i2 < i) {
                    if (cArr[0 + i2] == str.charAt(i2)) {
                        i2++;
                    }
                }
                i2 = 1;
                return i2 == 0 ? str : new String(cArr, 0, i);
            }
            i2 = 0;
            if (i2 == 0) {
            }
        }
        cArr = new String(cArr, 0, i).intern();
        this.a[i3] = cArr;
        return cArr;
    }

    public final String a(String str, int i, int i2, int i3) {
        int i4 = this.b & i3;
        String str2 = this.a[i4];
        if (str2 == null) {
            if (i2 != str.length()) {
                str = a(str, i, i2);
            }
            str = str.intern();
            this.a[i4] = str;
            return str;
        } else if (i3 == str2.hashCode() && i2 == str2.length() && str.startsWith(str2, i) != 0) {
            return str2;
        } else {
            return a(str, i, i2);
        }
    }

    private static String a(String str, int i, int i2) {
        char[] cArr = new char[i2];
        str.getChars(i, i2 + i, cArr, 0);
        return new String(cArr);
    }
}
