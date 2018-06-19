package com.alibaba.sdk.android.feedback.xblink.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import com.alipay.sdk.util.h;

public class a {
    private static final String a = "a";

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("charset");
            if (!(indexOf == -1 || str.indexOf("=", indexOf) == -1)) {
                str = str.substring(str.indexOf("=", indexOf) + 1);
                indexOf = str.indexOf(h.b);
                if (indexOf != -1) {
                    str = str.substring(0, indexOf).trim();
                }
                return str.trim();
            }
        }
        return "";
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || packageManager.getPackageInfo(str, 0) == null) ? false : true;
        } catch (NameNotFoundException e) {
            g.b(a, String.valueOf(e));
        }
        return false;
    }
}
