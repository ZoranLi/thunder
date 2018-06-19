package com.qiniu.android.d;

import android.util.Base64;

/* compiled from: UrlSafeBase64 */
public final class g {
    public static String a(String str) {
        try {
            return Base64.encodeToString(str.getBytes("utf-8"), 10);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }
}
