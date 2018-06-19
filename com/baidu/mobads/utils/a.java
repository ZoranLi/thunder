package com.baidu.mobads.utils;

import android.text.TextUtils;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.tencent.bugly.beta.tinker.TinkerReport;

public class a implements IBase64 {
    private static final byte[] a = new byte[]{(byte) 48, (byte) 75, (byte) 97, (byte) 106, (byte) 68, (byte) 55, (byte) 65, (byte) 90, (byte) 99, (byte) 70, (byte) 50, (byte) 81, (byte) 110, (byte) 80, (byte) 114, (byte) 53, (byte) 102, (byte) 119, (byte) 105, (byte) 72, (byte) 82, (byte) 78, (byte) 121, (byte) 103, (byte) 109, (byte) 117, (byte) 112, (byte) 85, (byte) 84, (byte) 73, (byte) 88, (byte) 120, (byte) 54, (byte) 57, (byte) 66, (byte) 87, (byte) 98, (byte) 45, (byte) 104, (byte) 77, (byte) 67, (byte) 71, (byte) 74, (byte) 111, (byte) 95, (byte) 86, (byte) 56, (byte) 69, (byte) 115, (byte) 107, (byte) 122, (byte) 49, (byte) 89, (byte) 100, (byte) 118, (byte) 76, (byte) 51, (byte) 52, (byte) 108, (byte) 101, (byte) 116, (byte) 113, (byte) 83, (byte) 79};
    private static final byte[] b = new byte[128];

    static {
        for (int i = 0; i < a.length; i++) {
            b[a[i]] = (byte) i;
        }
    }

    public String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.getBytes().length % 3;
        while (length > 0 && length < 3) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("$");
            str = stringBuilder.toString();
            length++;
        }
        str = str.getBytes();
        length = 0;
        byte[] bArr = new byte[((str.length / 3) * 4)];
        int i = 0;
        while (length < str.length) {
            bArr[i] = a[(str[length] & TinkerReport.KEY_LOADED_EXCEPTION_DEX) >> 2];
            int i2 = length + 1;
            bArr[i + 1] = a[((str[length] & 3) << 4) + ((str[i2] & 240) >> 4)];
            i2 = length + 2;
            bArr[i + 2] = a[((str[i2] & 15) << 2) + ((str[i2] & 192) >> 6)];
            bArr[i + 3] = a[str[i2] & 63];
            length += 3;
            i += 4;
        }
        return new String(bArr);
    }

    private byte[] a(String str) {
        if (!(b(str) || str == null)) {
            if (str.length() >= 4) {
                byte[] bArr;
                if (str.charAt(str.length() - 2) == '$') {
                    bArr = new byte[((((str.length() / 4) - 1) * 3) + 1)];
                } else if (str.charAt(str.length() - 1) == '$') {
                    bArr = new byte[((((str.length() / 4) - 1) * 3) + 2)];
                } else {
                    bArr = new byte[((str.length() / 4) * 3)];
                }
                int i = 0;
                int i2 = 0;
                while (i < str.length() - 4) {
                    byte b = b[str.charAt(i)];
                    byte b2 = b[str.charAt(i + 1)];
                    byte b3 = b[str.charAt(i + 2)];
                    byte b4 = b[str.charAt(i + 3)];
                    bArr[i2] = (byte) ((b << 2) | (b2 >> 4));
                    bArr[i2 + 1] = (byte) ((b2 << 4) | (b3 >> 2));
                    bArr[i2 + 2] = (byte) ((b3 << 6) | b4);
                    i += 4;
                    i2 += 3;
                }
                byte b5;
                if (str.charAt(str.length() - 2) == '$') {
                    b5 = b[str.charAt(str.length() - 4)];
                    bArr[bArr.length - 1] = (byte) ((b[str.charAt(str.length() - 3)] >> 4) | (b5 << 2));
                } else if (str.charAt(str.length() - 1) == '$') {
                    b5 = b[str.charAt(str.length() - 4)];
                    r3 = b[str.charAt(str.length() - 3)];
                    str = b[str.charAt(str.length() - 2)];
                    bArr[bArr.length - 2] = (byte) ((b5 << 2) | (r3 >> 4));
                    bArr[bArr.length - 1] = (byte) ((str >> 2) | (r3 << 4));
                } else {
                    b5 = b[str.charAt(str.length() - 4)];
                    r3 = b[str.charAt(str.length() - 3)];
                    byte b6 = b[str.charAt(str.length() - 2)];
                    str = b[str.charAt(str.length() - 1)];
                    bArr[bArr.length - 3] = (byte) ((b5 << 2) | (r3 >> 4));
                    bArr[bArr.length - 2] = (byte) ((r3 << 4) | (b6 >> 2));
                    bArr[bArr.length - 1] = (byte) (str | (b6 << 6));
                }
                return bArr;
            }
        }
        return null;
    }

    public java.lang.String decodeStr(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        if (r3 == 0) goto L_0x002b;
    L_0x0002:
        r0 = r3.length();
        r1 = 4;
        if (r0 >= r1) goto L_0x000a;
    L_0x0009:
        goto L_0x002b;
    L_0x000a:
        r0 = new java.lang.String;	 Catch:{ Exception -> 0x0028 }
        r3 = r2.a(r3);	 Catch:{ Exception -> 0x0028 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x0028 }
    L_0x0013:
        r3 = "$";	 Catch:{ Exception -> 0x0028 }
        r3 = r0.endsWith(r3);	 Catch:{ Exception -> 0x0028 }
        if (r3 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0028 }
    L_0x001b:
        r3 = 0;	 Catch:{ Exception -> 0x0028 }
        r1 = r0.length();	 Catch:{ Exception -> 0x0028 }
        r1 = r1 + -1;	 Catch:{ Exception -> 0x0028 }
        r0 = r0.substring(r3, r1);	 Catch:{ Exception -> 0x0028 }
        goto L_0x0013;
    L_0x0027:
        return r0;
    L_0x0028:
        r3 = "";
        return r3;
    L_0x002b:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.a.decodeStr(java.lang.String):java.lang.String");
    }

    private boolean b(String str) {
        if (str == null) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!a((byte) str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean a(byte b) {
        if (b == (byte) 36) {
            return true;
        }
        if (b >= (byte) 0) {
            if (b < Byte.MIN_VALUE) {
                return b[b] != (byte) -1;
            }
        }
        return false;
    }
}
