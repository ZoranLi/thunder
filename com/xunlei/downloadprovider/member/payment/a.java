package com.xunlei.downloadprovider.member.payment;

import android.text.TextUtils;

/* compiled from: BizNoHelper */
public final class a {
    public static String a(int i) {
        return i == 3 ? "1001" : i == 5 ? "1006" : "";
    }

    public static String a(int i, int i2) {
        if (i2 == 0) {
            if (i == 2) {
                return "openvip";
            }
            if (i == 3) {
                return "baijin";
            }
            if (i == 5) {
                return "supervip";
            }
            if (i == 204) {
                return "quickbird";
            }
        } else if (i2 == 1) {
            if (i == 3) {
                return "upgradevip";
            }
            if (i == 5) {
                return "upsupervip";
            }
            if (i == 209) {
                return "upquickbird";
            }
        }
        return "";
    }

    public static h a(String str) {
        if (TextUtils.equals("openvip", str)) {
            return new h(2, 0);
        }
        if (TextUtils.equals("baijin", str)) {
            return new h(3, 0);
        }
        if (TextUtils.equals("supervip", str)) {
            return new h(5, 0);
        }
        if (TextUtils.equals("quickbird", str)) {
            return new h(204, 0);
        }
        if (TextUtils.equals("upgradevip", str)) {
            return new h(3, 1);
        }
        if (TextUtils.equals("upsupervip", str)) {
            return new h(5, 1);
        }
        if (TextUtils.equals("upquickbird", str)) {
            return new h(209, 1);
        }
        if (TextUtils.equals("1001", str)) {
            return new h(3, 0);
        }
        return TextUtils.equals("1006", str) != null ? new h(5, 0) : null;
    }
}
