package com.xunlei.common.new_ptl.member.task.j;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.h;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

/* compiled from: UserVerifyCodeTask */
public final class b extends a {
    private static int e;
    private static final String[] g = new String[]{"http://verify2.xunlei.com", "http://verify.xunlei.com", "http://verify3.xunlei.com", "http://verify1.xunlei.com"};
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private String f = "";
    private String h = "MEA";

    private static void q() {
    }

    private static String p() {
        if (e >= 4) {
            return null;
        }
        String[] strArr = g;
        int i = e;
        e = i + 1;
        return strArr[i];
    }

    public b(p pVar) {
        super(pVar);
    }

    private void a(String str) {
        h hVar = new h();
        hVar.a = XLUtilTools.getServerDomain(str);
        hVar.b = null;
        d().a(g(), hVar);
    }

    public final boolean h() {
        if (a.a.d == c()) {
            return false;
        }
        String str;
        a(a.a.b);
        StringBuilder stringBuilder = new StringBuilder();
        if (e < 4) {
            String[] strArr = g;
            int i = e;
            e = i + 1;
            str = strArr[i];
        } else {
            str = null;
        }
        stringBuilder.append(str);
        stringBuilder.append("/image?t=%s");
        this.f = stringBuilder.toString();
        if (this.f == null) {
            return false;
        }
        String format = String.format(this.f, new Object[]{this.h});
        d().l().get(d().h(), format, null, new 1(this, format));
        a(a.a.c);
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "UserVerifyCodeTask") {
                return xLOnUserListener.onUserVerifyCodeUpdated(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", bundle.getString("verifyKey"), bundle.getInt("imageType"), bundle.getByteArray("imageContent"), f(), g());
            }
        }
        return null;
    }

    public final void a() {
        super.a();
        this.h = d().y();
        StringBuilder stringBuilder = new StringBuilder("get verify code verify type = ");
        stringBuilder.append(this.h);
        XLLog.v("UserVerifyCodeTask", stringBuilder.toString());
        e = 0;
    }

    public static String m() {
        int i = e - 1;
        if (i < 0) {
            i = 0;
        }
        return g[i];
    }

    static /* synthetic */ void a(b bVar, String str) {
        h hVar = new h();
        hVar.a = XLUtilTools.getServerDomain(str);
        hVar.b = null;
        bVar.d().a(bVar.g(), hVar);
    }
}
