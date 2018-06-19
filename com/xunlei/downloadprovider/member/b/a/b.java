package com.xunlei.downloadprovider.member.b.a;

import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: RenewalUtils */
public final class b {
    static String a(String str) {
        if (str != null) {
            str = str.split("_");
            if (str != null && str.length > 1) {
                return str[1];
            }
        }
        return LoginHelper.a().o();
    }
}
