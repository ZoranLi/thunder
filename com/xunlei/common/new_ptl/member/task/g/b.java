package com.xunlei.common.new_ptl.member.task.g;

import android.content.Intent;
import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLQRCodeAuthHandler;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLQRCodeLoginAuthActivity;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserQRCodeLoginAuthTask */
public class b extends a {
    private static final int e = 1024;
    private static final int f = 1025;
    private static final int g = 1026;
    private String a = b.class.getSimpleName();
    private XLQRCodeAuthHandler b = null;
    private String c = "";
    private a d = null;
    private int h = null;
    private int i = 2;
    private long j = 0;

    public b(p pVar) {
        super(pVar);
    }

    public final void a(XLQRCodeAuthHandler xLQRCodeAuthHandler, String str) {
        this.b = xLQRCodeAuthHandler;
        this.c = str;
        xLQRCodeAuthHandler = this.b.handleLoginTimeOut();
        if (xLQRCodeAuthHandler != null) {
            this.i = xLQRCodeAuthHandler;
        }
        this.j = System.currentTimeMillis();
        this.h = 1024;
    }

    public final boolean h() {
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder("execute step = ");
        stringBuilder.append(this.h);
        XLLog.v(str, stringBuilder.toString());
        if (1024 == this.h) {
            if (d().r()) {
                this.h = 1025;
                d().n().postDelayed(new 1(this), 100);
            } else if (this.b.handleLoginWindow()) {
                this.d = new a(this, (byte) 0);
                d().a(this.d);
                this.h = g;
            } else {
                f(XLErrorCode.QR_LOGIN_AUTH_HANDLE_LOGIN_WIN_ERROR);
            }
        } else if (g == this.h) {
            n();
            this.h = 1025;
            d().n().postDelayed(new 2(this), 100);
        } else if (1025 == this.h) {
            str = this.a;
            stringBuilder = new StringBuilder("startAuthWebActivity url = ");
            stringBuilder.append(this.c);
            XLLog.v(str, stringBuilder.toString());
            Intent intent = new Intent(d().h(), XLQRCodeLoginAuthActivity.class);
            intent.addFlags(268435456);
            intent.putExtra("xl_task_id", g());
            intent.putExtra("xl_qr_auth_url", this.c);
            d().h().startActivity(intent);
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserQRCodeLoginAuthTask") {
                return xLOnUserListener.onUserQRCodeLoginAuth(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    public final void m() {
        n();
    }

    public final void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "UserQRCodeLoginAuthTask");
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
        d().b(g());
        d().A();
    }

    private void n() {
        if (this.d != null) {
            d().b(this.d);
            this.d = null;
        }
    }

    private void o() {
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder("startAuthWebActivity url = ");
        stringBuilder.append(this.c);
        XLLog.v(str, stringBuilder.toString());
        Intent intent = new Intent(d().h(), XLQRCodeLoginAuthActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("xl_task_id", g());
        intent.putExtra("xl_qr_auth_url", this.c);
        d().h().startActivity(intent);
    }

    private void g(int i) {
        if (i == 0) {
            if (System.currentTimeMillis() - this.j < ((long) (this.i * 60)) * 1000) {
                h();
                return;
            }
            f(XLErrorCode.QR_LOGIN_OP_TIMEOUT_ERROR);
        }
    }

    static /* synthetic */ void a(b bVar, int i) {
        if (i == 0) {
            if (System.currentTimeMillis() - bVar.j < ((long) (bVar.i * 60)) * 1000) {
                bVar.h();
                return;
            }
            bVar.f(XLErrorCode.QR_LOGIN_OP_TIMEOUT_ERROR);
        }
    }
}
