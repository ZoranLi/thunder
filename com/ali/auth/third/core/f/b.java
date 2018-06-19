package com.ali.auth.third.core.f;

import anet.channel.util.HttpConstant;
import com.igexin.sdk.PushConsts;

public final class b {
    public static final b a = new b(100, HttpConstant.SUCCESS);
    public static final b b = new b(-100, "IGNORE");
    public static final b c = new b(108, "CHECK");
    @Deprecated
    public static final b d = new b(101);
    @Deprecated
    public static final b e = new b(10000, "NO_SUCH_METHOD");
    @Deprecated
    public static final b f = new b(10001, "BRIDGE_EXCEPTION");
    @Deprecated
    public static final b g = new b(10002, "INIT_EXCEPTION");
    @Deprecated
    public static final b h = new b(10003, "USER_CANCEL");
    @Deprecated
    public static final b i = new b(PushConsts.CHECK_CLIENTID);
    @Deprecated
    public static final b j = new b(10006);
    @Deprecated
    public static final b k = new b(10010, "SYSTEM_EXCEPTION");
    @Deprecated
    public static final b l = new b(10013, "ILLEGAL_PARAM");
    @Deprecated
    public static final b m = new b(10014, "NETWORK_NOT_AVAILABLE");
    @Deprecated
    public static final b n = new b(10015, "USER_LOGOUT");
    @Deprecated
    public static final b o = new b(10016, "SECURITY_GUARD_INIT_EXCEPTION");
    public int p;
    public String q;

    private b(int i) {
        this(i, null);
    }

    private b(int i, String str) {
        this.p = i;
        this.q = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.p == ((b) obj).p;
    }

    public final int hashCode() {
        return 31 + this.p;
    }
}
