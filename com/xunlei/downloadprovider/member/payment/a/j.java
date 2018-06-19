package com.xunlei.downloadprovider.member.payment.a;

import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.b;
import com.xunlei.downloadprovider.member.payment.i;

/* compiled from: UserInfoManager */
public class j {
    private static j c;
    public LoginHelper a = LoginHelper.a();
    public boolean b = false;

    private j() {
    }

    public static j a() {
        if (c == null) {
            synchronized (j.class) {
                if (c == null) {
                    c = new j();
                }
            }
        }
        return c;
    }

    private b h() {
        return this.a.g.h();
    }

    public final boolean b() {
        boolean b = i.b(this.a.g.f());
        boolean l = this.a.l();
        if (b && l) {
            return false;
        }
        int i = h().a;
        b = i != 0 && i == 1;
        if (this.b) {
            return b;
        }
        if (l || !b) {
            return false;
        }
        return true;
    }

    public final boolean c() {
        if (b()) {
            return true;
        }
        return this.a.l();
    }

    public final int d() {
        if (b()) {
            return 204;
        }
        return this.a.g.f();
    }

    public final boolean e() {
        if (!b()) {
            return this.a.u();
        }
        int i = h().k;
        return i != 0 && i == 1;
    }

    public final String f() {
        if (b()) {
            return h().c;
        }
        return this.a.o();
    }

    public final int g() {
        com.xunlei.downloadprovider.member.login.b.i iVar = this.a.g;
        iVar.b();
        return iVar.e.getIntValue(USERINFOKEY.VipGrow);
    }
}
