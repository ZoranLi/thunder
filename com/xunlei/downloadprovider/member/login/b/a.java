package com.xunlei.downloadprovider.member.login.b;

import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserUtil;

/* compiled from: AccountSecurityImpl */
public class a {
    private static a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public static void a(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userRegAqModifyPassWordJSInterface(null, xLOnUserListener, null);
    }

    public static void a(int i, String str, String str2, XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userBindOtherAccount(i, str, str2, xLOnUserListener, null);
    }

    public static void a(int i, XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userUnBindOtherAccount(i, xLOnUserListener, null);
    }
}
