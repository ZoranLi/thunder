package com.xunlei.common.new_ptl.member.task.g;

import android.os.Bundle;
import com.xunlei.common.new_ptl.member.XLDeviceType;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;

/* compiled from: UserGetAuthQRCodeTask */
public final class a extends com.xunlei.common.new_ptl.member.task.a {
    private static final int a = 1024;
    private static final int b = 1025;
    private static final int c = 1026;
    private static final String d = "https://qrcode.xunlei.com/uuid?business=%d&term=%s";
    private static final String e = "https://qrcode.xunlei.com/qrlogin.png?tbusiness=%d&term=%s&ch=%s&tversion=%s";
    private int f = null;
    private String g = "";
    private byte[] h = null;
    private int i = XLDeviceType.DT_PHONE;

    private static String h(int i) {
        return "client";
    }

    public a(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (this.f == 1024) {
            d().l().get(d().h(), String.format(d, new Object[]{Integer.valueOf(d().d()), "client"}), null, new 1(this));
        } else if (this.f == 1025) {
            d().l().get(d().h(), String.format(e, new Object[]{Integer.valueOf(d().d()), "client", this.g, d().c()}), null, new 2(this));
        }
        return false;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserGetAuthQRCodeTask") {
                return xLOnUserListener.onUserGetQRCode(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.g, this.h, f(), g());
            }
        }
        return null;
    }

    public final void f(int i) {
        this.i = i;
        this.f = 1024;
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserGetAuthQRCodeTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
    }

    private String m() {
        return String.format(d, new Object[]{Integer.valueOf(d().d()), "client"});
    }

    private String n() {
        return String.format(e, new Object[]{Integer.valueOf(d().d()), "client", this.g, d().c()});
    }

    private void o() {
        d().l().get(d().h(), String.format(d, new Object[]{Integer.valueOf(d().d()), "client"}), null, new 1(this));
    }

    private void p() {
        d().l().get(d().h(), String.format(e, new Object[]{Integer.valueOf(d().d()), "client", this.g, d().c()}), null, new 2(this));
    }

    static /* synthetic */ void b(a aVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserGetAuthQRCodeTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        aVar.d().a((com.xunlei.common.new_ptl.member.task.a) aVar, bundle);
    }
}
