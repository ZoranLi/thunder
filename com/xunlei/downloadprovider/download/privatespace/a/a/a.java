package com.xunlei.downloadprovider.download.privatespace.a.a;

import android.text.TextUtils;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: BindVerifyBusiness */
public final class a {
    public static final Object a = "verify:tag";
    public g b;
    public g c;

    public static boolean a() {
        return !TextUtils.isEmpty(LoginHelper.a().i());
    }

    public static void b() {
        VolleyRequestManager.getRequestQueue().a(a);
    }
}
