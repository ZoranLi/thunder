package com.xunlei.common.new_ptl.member.a;

import android.text.TextUtils;

/* compiled from: XLSecureKey */
public class m {
    private static String c = "3.0";
    private static String d = "ali_task";
    private static String e = "ali_auth_param";
    private static String f = "http://login.i.xunlei.com/thirdlogin4/entrance.php";
    private int a;
    private String b;

    public m(String str) {
        this.a = 0;
        this.b = "";
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(".");
            if (indexOf != -1) {
                this.b = str.substring(indexOf + 1);
                this.a = Integer.valueOf(str.substring(0, indexOf).substring(2)).intValue();
            }
        }
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }
}
