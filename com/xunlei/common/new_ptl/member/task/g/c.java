package com.xunlei.common.new_ptl.member.task.g;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserQRCodeLoginTask */
public class c extends a {
    private static final int e = 1024;
    private static final int f = 1025;
    private static final int g = 1026;
    private XLOnUserListener a = new 1(this);
    private long b = 120000;
    private long c = 0;
    private String d = "";
    private int h = 0;
    private long i = 0;
    private String j = "";
    private boolean k = false;
    private final String l;
    private String m = c.class.getSimpleName();

    public c(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        String str = this.m;
        StringBuilder stringBuilder = new StringBuilder("execute step = ");
        stringBuilder.append(this.h);
        XLLog.v(str, stringBuilder.toString());
        if (1024 == this.h) {
            o();
        } else if (1025 == this.h) {
            o();
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserQRCodeLoginTask") {
                return xLOnUserListener.onUserQRCodeLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", e(), f(), g());
            }
        }
        return null;
    }

    public final void a(String str, int i) {
        this.d = str;
        if (i > 0) {
            this.b = ((long) (i * 60)) * 1000;
        }
        this.h = 1024;
        this.c = System.currentTimeMillis();
    }

    private String n() {
        return String.format("https://qrcode.xunlei.com/sub_message?ch=%s&business=%d", new Object[]{this.d, Integer.valueOf(d().d())});
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserQRCodeLoginTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
        d().B();
    }

    private void o() {
        if (this.k) {
            XLLog.v(this.m, "task is uninist,so go back!");
            d().B();
            return;
        }
        String format = String.format("https://qrcode.xunlei.com/sub_message?ch=%s&business=%d", new Object[]{this.d, Integer.valueOf(d().d())});
        String str = this.m;
        StringBuilder stringBuilder = new StringBuilder("sub message address = ");
        stringBuilder.append(format);
        XLLog.v(str, stringBuilder.toString());
        d().l().get(d().h(), format, null, new 2(this));
    }

    private void p() {
        d().a(this.a, true, (Object) "xl-inner-get-user-info", 2);
    }

    private void q() {
        d().a(this.i, this.j, d().d(), 1, this.a, (Object) "xl-inner-login-with-session", true);
    }

    public final void m() {
        this.k = true;
    }

    static /* synthetic */ void a(c cVar, int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserQRCodeLoginTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        cVar.d().a((a) cVar, bundle);
        cVar.d().B();
    }
}
