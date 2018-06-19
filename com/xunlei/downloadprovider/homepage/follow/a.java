package com.xunlei.downloadprovider.homepage.follow;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: FollowErrorMsg */
public final class a {
    public static String a(String str) {
        if (!b.a(BrothersApplication.getApplicationInstance())) {
            return "网络异常，请重试";
        }
        if (str == null) {
            return "关注失败";
        }
        Object obj = -1;
        if (str.hashCode() == 1599680) {
            if (str.equals("4301") != null) {
                obj = null;
            }
        }
        return obj != null ? "关注失败" : "今天关注次数已达上限";
    }
}
