package com.xunlei.downloadprovider.plugin.a;

import android.os.Bundle;
import android.os.RemoteException;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.xunlei.a.c.c.a;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;

/* compiled from: IThunderMemberFacadeImpl */
public class b$b extends a {
    public static b$b a = new b$b();

    public final boolean a() throws RemoteException {
        LoginHelper.a();
        return l.c();
    }

    public final Bundle b() throws RemoteException {
        Bundle bundle = new Bundle(9);
        bundle.putBoolean("isVip", LoginHelper.a().l());
        bundle.putLong("userId", LoginHelper.a().g.c());
        bundle.putString(INoCaptchaComponent.sessionId, LoginHelper.a().c());
        bundle.putInt("memberType", LoginHelper.a().g.f());
        bundle.putLong("flowRemained", LoginHelper.a().g.g);
        bundle.putString("nickName", LoginHelper.a().g.d());
        bundle.putString("portraitPath", LoginHelper.a().e());
        return bundle;
    }

    public final void a(String str, com.xunlei.a.c.a aVar, String str2) throws RemoteException {
        LoginFrom enumValueOf;
        c com_xunlei_downloadprovider_plugin_a_b_a = new b$a(aVar, str2);
        try {
            enumValueOf = LoginFrom.enumValueOf(str);
        } catch (String str3) {
            str3.printStackTrace();
            enumValueOf = null;
        }
        LoginHelper.a().a(BrothersApplication.getApplicationInstance(), com_xunlei_downloadprovider_plugin_a_b_a, enumValueOf, (Object) str2);
    }

    public final void a(String str, String str2) throws RemoteException {
        try {
            str = PayFrom.valueOf(str);
        } catch (String str3) {
            str3.printStackTrace();
            str3 = null;
        }
        PaymentEntryActivity.a(BrothersApplication.getApplicationInstance(), str3, str2);
    }

    public final boolean c() throws RemoteException {
        return r.a().d;
    }

    public final boolean a(String str) throws RemoteException {
        try {
            return r.a().a(BrothersApplication.getApplicationInstance(), LoginFrom.enumValueOf(str), new c(this));
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }
}
