package com.xunlei.downloadprovider.member.login.authphone;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.volley.Request;
import com.xunlei.common.net.volley.BaseJsonObjectRequest;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.downloadprovider.d.b.d;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.member.register.ui.AuthMobileActivity;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: PhoneAuthHelper */
public class r extends e {
    public static boolean b;
    public static boolean c;
    private static r g;
    public ArrayList<p> a = new ArrayList();
    public boolean d;
    private final String f = r.class.getSimpleName();

    private r() {
    }

    public static r a() {
        if (g == null) {
            synchronized (r.class) {
                if (g == null) {
                    g = new r();
                }
            }
        }
        return g;
    }

    public final void a(Context context, String str) {
        a().a(new s(this, context, str));
    }

    public static void b(Context context, String str) {
        d dVar = com.xunlei.downloadprovider.d.d.a().e;
        boolean z = true;
        if (!o.a(str)) {
            if (dVar.b() != 0) {
                if (dVar.b() == 1) {
                    h a = h.a();
                    int b = com.xunlei.downloadprovider.d.d.a().e.b();
                    SharedPreferences sharedPreferences = a.a;
                    StringBuilder stringBuilder = new StringBuilder("key_phone_auth_show_count");
                    stringBuilder.append(LoginHelper.a().g.c());
                    if (sharedPreferences.getInt(stringBuilder.toString(), 0) == 1 && LoginHelper.a().d) {
                        if (b != 2) {
                            z = false;
                        }
                    }
                    if (z) {
                        AuthMobileActivity.a(context, str);
                        return;
                    }
                }
                if (dVar.b() == 2) {
                    AuthMobileActivity.a(context, str);
                }
            }
        } else if (o.b(str) == 0) {
            a().a(false, false, true);
        } else {
            AuthDlgActivity.a(context, str, null);
        }
    }

    public final boolean a(Context context, LoginFrom loginFrom, p pVar) {
        LoginHelper.a();
        boolean c = l.c();
        String loginFrom2 = loginFrom.toString();
        int b = o.b(loginFrom2);
        boolean z = b != 0;
        StringBuilder stringBuilder = new StringBuilder("isNeedAuth--authFrom=");
        stringBuilder.append(loginFrom2);
        stringBuilder.append("|mIsUserNeedAuth=");
        stringBuilder.append(this.d);
        stringBuilder.append("|mobileAuthTypeConfig=");
        stringBuilder.append(b);
        boolean z2 = this.d && z;
        StringBuilder stringBuilder2 = new StringBuilder("checkAndAuth--isLogin=");
        stringBuilder2.append(c);
        stringBuilder2.append("|isNeedAuth=");
        stringBuilder2.append(z2);
        stringBuilder2.append("|authFrom=");
        stringBuilder2.append(loginFrom2);
        if (!c) {
            a(pVar);
            LoginHelper.a().a(context, null, loginFrom, null);
            return true;
        } else if (!z2) {
            return false;
        } else {
            AuthDlgActivity.a(context, loginFrom2, pVar);
            return true;
        }
    }

    public final void a(c<a> cVar, String str) {
        StringBuilder a = a("https://xluser-ssl.xunlei.com/certification/v1/sendcode");
        a.append("&phone=");
        a.append(str);
        new StringBuilder("sendCode--url=").append(a.toString());
        a((Request) new BaseJsonObjectRequest(a.toString(), (JSONObject) null, new v(this, cVar), new w(this, cVar)));
    }

    public final void a(c<a> cVar, String str, String str2, String str3) {
        StringBuilder a = a("https://xluser-ssl.xunlei.com/certification/v1/setphone");
        a.append("&phone=");
        a.append(str);
        a.append("&code=");
        a.append(str2);
        a.append("&key=");
        a.append(str3);
        new StringBuilder("authPhoneNumber--url=").append(a.toString());
        a((Request) new BaseJsonObjectRequest(a.toString(), (JSONObject) null, new x(this, cVar), new y(this, cVar)));
    }

    final void a(p pVar) {
        if (!this.a.contains(pVar)) {
            this.a.clear();
            if (pVar != null) {
                this.a.add(pVar);
            }
        }
    }

    final void a(boolean z, boolean z2, boolean z3) {
        StringBuilder stringBuilder = new StringBuilder("notifyAuthResultObservers--isAuthSuccess=");
        stringBuilder.append(z);
        stringBuilder.append("|isCancelAuth=");
        stringBuilder.append(z2);
        stringBuilder.append("|isGoOnNextStep=");
        stringBuilder.append(z3);
        stringBuilder.append("|mAuthResultListeners=");
        stringBuilder.append(this.a);
        q qVar = new q();
        qVar.a = z;
        qVar.b = z2;
        qVar.c = z3;
        z = new ArrayList(this.a);
        for (z2 = false; z2 < z.size(); z2++) {
            p pVar = (p) z.get(z2);
            if (pVar != null) {
                pVar.a(qVar);
            }
        }
    }

    private static StringBuilder a(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append('?');
        stringBuilder.append("auth.userid=");
        stringBuilder.append(LoginHelper.a().g.c());
        stringBuilder.append("&auth.usernewno=");
        str = LoginHelper.a().g;
        str.b();
        stringBuilder.append(str.e.getStringValue(USERINFOKEY.UserNewNo));
        stringBuilder.append("&auth.usrname=");
        stringBuilder.append(LoginHelper.a().d());
        stringBuilder.append("&auth.usernick=");
        stringBuilder.append(LoginHelper.a().g.d());
        stringBuilder.append("&auth.sessionid=");
        stringBuilder.append(LoginHelper.a().c());
        stringBuilder.append("&auth.deviceid=");
        stringBuilder.append(LoginHelper.q());
        stringBuilder.append("&auth.platformVersion=10&auth.appid=40&auth.appName=");
        stringBuilder.append(com.xunlei.downloadprovider.h.l.a());
        stringBuilder.append("&auth.clientVersion=11100");
        return stringBuilder;
    }

    public final void a(a aVar, String str) {
        if (aVar != null) {
            if ("ISAUTH".equals(aVar.a) != null) {
                if (o.a(str) != null) {
                }
            }
            aVar = o.b(str);
            if (aVar >= null) {
                if (aVar == 2) {
                    a(false, false, false);
                    return;
                }
            }
            return;
        }
        a(false, false, true);
    }

    public final void a(c<a> cVar) {
        a(new BaseJsonObjectRequest(a("https://xluser-ssl.xunlei.com/certification/v1/isauth").toString(), (JSONObject) null, new t(this, cVar), new u(this, cVar)));
    }
}
