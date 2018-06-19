package com.xunlei.common.new_ptl.member.task.j;

import android.os.Bundle;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.h;
import com.xunlei.common.new_ptl.member.a.p;

/* compiled from: UserPreVerifyCodeTask */
public final class a extends com.xunlei.common.new_ptl.member.task.a {
    private static String a = "/verify/%s/%s?t=%s&p=true&header=true";
    private String b = "";
    private String c = "";
    private String d = "";

    public final void a(String str, String str2) {
        this.b = p.a().y();
        this.c = str;
        this.d = str2;
    }

    public a(p pVar) {
        super(pVar);
    }

    private void a(String str) {
        h hVar = new h();
        hVar.a = XLUtilTools.getServerDomain(str);
        hVar.b = null;
        d().a(g(), hVar);
    }

    public final boolean h() {
        a(com.xunlei.common.new_ptl.member.task.a.a.b);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b.m());
        stringBuilder.append(a);
        d().l().get(d().h(), String.format(stringBuilder.toString(), new Object[]{this.d, this.c, this.b}), null, new 1(this));
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserPreVerifyedCode(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    static /* synthetic */ void a(a aVar, String str) {
        h hVar = new h();
        hVar.a = XLUtilTools.getServerDomain(str);
        hVar.b = null;
        aVar.d().a(aVar.g(), hVar);
    }
}
