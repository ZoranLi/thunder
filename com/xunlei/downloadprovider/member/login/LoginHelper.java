package com.xunlei.downloadprovider.member.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.common.new_ptl.member.XLBindedOtherAccountItem;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHspeedCapacity;
import com.xunlei.common.new_ptl.member.XLLixianCapacity;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.act.XLQQParam;
import com.xunlei.common.new_ptl.member.act.XLWxParam;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.broadcast.b;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.e$a;
import com.xunlei.downloadprovider.member.login.b.e$b;
import com.xunlei.downloadprovider.member.login.b.e$c;
import com.xunlei.downloadprovider.member.login.b.e$e;
import com.xunlei.downloadprovider.member.login.b.e$f;
import com.xunlei.downloadprovider.member.login.b.e$g;
import com.xunlei.downloadprovider.member.login.b.e$h;
import com.xunlei.downloadprovider.member.login.b.e$i;
import com.xunlei.downloadprovider.member.login.b.e$j;
import com.xunlei.downloadprovider.member.login.b.e$k;
import com.xunlei.downloadprovider.member.login.b.e$l;
import com.xunlei.downloadprovider.member.login.b.e$m;
import com.xunlei.downloadprovider.member.login.b.f;
import com.xunlei.downloadprovider.member.login.b.i;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.b.n;
import com.xunlei.downloadprovider.member.login.b.o;
import com.xunlei.downloadprovider.member.login.c.a;
import com.xunlei.downloadprovider.member.login.c.g;
import com.xunlei.downloadprovider.member.login.c.h;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginDlgActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.web.website.g.j;
import com.xunlei.downloadprovider.web.website.g.k;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LoginHelper {
    private static LoginHelper D = null;
    private static final String r = "LoginHelper";
    private e$i A;
    private e$c B;
    private e$b C;
    private b E = new f(this);
    public b a;
    public f b = new f();
    public String c;
    public boolean d;
    public String e;
    public l f = l.a();
    public i g = i.a();
    public a h = a.a();
    public h i = h.a();
    public com.xunlei.downloadprovider.member.login.c.i j = com.xunlei.downloadprovider.member.login.c.i.a();
    public c k;
    public e$h l;
    public e$m m;
    public e$k n;
    public e$l o;
    public e$g p;
    public XLOnUserListener q = new d(this);
    private Object s = null;
    private String t;
    private boolean u = false;
    private n v = n.a();
    private com.xunlei.downloadprovider.member.login.b.a w = com.xunlei.downloadprovider.member.login.b.a.a();
    private o x = a.a;
    private e$e y;
    private e$j z;

    public enum LoginPageType {
        LOGIN_PAGE,
        LOGIN_FLOAT
    }

    private LoginHelper() {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            new Handler(Looper.getMainLooper()).post(new c(this));
        } else {
            n.a("34a062aaa22f906fca4fefe9fb3a3021", this.q);
        }
    }

    public static LoginHelper a() {
        if (D == null) {
            synchronized (LoginHelper.class) {
                if (D == null) {
                    D = new LoginHelper();
                }
            }
        }
        return D;
    }

    public final void a(Context context, c cVar, LoginFrom loginFrom, Object obj) {
        a(LoginPageType.LOGIN_FLOAT, context, cVar, loginFrom, -1, obj);
    }

    public final void a(LoginPageType loginPageType, Context context, c cVar, LoginFrom loginFrom, int i, Object obj) {
        this.s = obj;
        this.k = cVar;
        obj = this.f;
        if (!(cVar == null || obj.c.contains(cVar))) {
            obj.c.add(cVar);
        }
        a(loginPageType, context, loginFrom.toString(), i);
    }

    public final void a(LoginPageType loginPageType, Context context, String str, int i) {
        Class cls;
        this.b.a = false;
        this.t = str;
        if (loginPageType == LoginPageType.LOGIN_PAGE) {
            cls = LoginActivity.class;
        } else {
            cls = LoginDlgActivity.class;
        }
        Intent xLIntent = new XLIntent(context, cls);
        xLIntent.putExtra("login_from", str);
        xLIntent.putExtra("is_from_login_dlg", context instanceof LoginDlgActivity);
        if (i != -1) {
            xLIntent.setFlags(i);
        }
        if ((context instanceof Activity) == null) {
            xLIntent.setFlags(268435456);
        }
        context.startActivity(xLIntent);
    }

    private void a(int i, XLUserInfo xLUserInfo, Object obj, String str) {
        i.a("Login", xLUserInfo, i, str);
        this.e = str;
        boolean z = false;
        this.b.b = false;
        this.d = obj == "auto_login" ? 1 : null;
        str = obj == "auto_login" ? 1 : null;
        if (i == 0) {
            this.u = false;
            this.g.e = xLUserInfo;
            xLUserInfo = this.i;
            str = this.c;
            if (!TextUtils.isEmpty(str)) {
                xLUserInfo.c(str);
            }
            xLUserInfo = this.h;
            b bVar = this.E;
            a.a(this.g.c());
            a.b();
            a.e();
            a.a(bVar);
            a.a(l.c());
            a.a(this);
            com.xunlei.downloadprovider.personal.a.e.b.a().a(new com.xunlei.downloadprovider.member.login.c.c(xLUserInfo));
            com.xunlei.downloadprovider.personal.a.e.b.a().a(new com.xunlei.downloadprovider.member.login.c.b(xLUserInfo));
            xLUserInfo = j.a();
            if (xLUserInfo.a == null) {
                a();
                if (l.c() != null) {
                    XLThreadPool.execute(new k(xLUserInfo));
                }
            }
            if (h.a().a.getBoolean(h.c(), false) == null) {
                xLUserInfo = new com.xunlei.downloadprovider.personal.message.chat.personalchat.b.c();
                str = d.a().t.a;
                com.xunlei.downloadprovider.personal.message.chat.c bVar2 = new com.xunlei.downloadprovider.personal.message.chat.personalchat.b.b();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(SocializeConstants.TENCENT_UID, a().g.c());
                    jSONObject.put("place", str);
                    XLThreadPool.execute(new com.xunlei.downloadprovider.personal.message.chat.personalchat.b.d(xLUserInfo, jSONObject, bVar2));
                } catch (XLUserInfo xLUserInfo2) {
                    xLUserInfo2.printStackTrace();
                    bVar2.a(com.xunlei.downloadprovider.personal.message.chat.b.a(-1000, "build body fail"));
                }
            }
        } else if (!(i == XLErrorCode.SOCKET_ERROR || str == null || com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) == null)) {
            this.j.a(1, 2);
        }
        boolean z2 = this.b.a;
        if (i == 0) {
            str = this.h;
            a.a eVar = new e(this, i, z2);
            xLUserInfo2 = com.xunlei.downloadprovider.publiser.common.guide.a.a();
            if (xLUserInfo2.c() && xLUserInfo2.d()) {
                int i2;
                boolean z3;
                com.xunlei.downloadprovider.publiser.common.guide.a.a.a gVar;
                if (xLUserInfo2.c()) {
                    if (((xLUserInfo2.a.b() & 4) > 0 ? 1 : false) != 0) {
                        i2 = 1;
                        if (i2 == 0) {
                            if (xLUserInfo2.c()) {
                                if (xLUserInfo2.a.b) {
                                    z3 = false;
                                    if (!z3) {
                                        if (xLUserInfo2.d() && xLUserInfo2.b.b()) {
                                            z = true;
                                        }
                                        if (z) {
                                            eVar.a();
                                        } else {
                                            gVar = new g(str, eVar);
                                            if (xLUserInfo2.d() == null) {
                                                xLUserInfo2.b.a(2, gVar);
                                            } else {
                                                gVar.a();
                                            }
                                        }
                                    }
                                }
                            }
                            z3 = true;
                            if (z3) {
                                z = true;
                                if (z) {
                                    eVar.a();
                                } else {
                                    gVar = new g(str, eVar);
                                    if (xLUserInfo2.d() == null) {
                                        gVar.a();
                                    } else {
                                        xLUserInfo2.b.a(2, gVar);
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = false;
                if (i2 == 0) {
                    if (xLUserInfo2.c()) {
                        if (xLUserInfo2.a.b) {
                            z3 = false;
                            if (z3) {
                                z = true;
                                if (z) {
                                    gVar = new g(str, eVar);
                                    if (xLUserInfo2.d() == null) {
                                        xLUserInfo2.b.a(2, gVar);
                                    } else {
                                        gVar.a();
                                    }
                                } else {
                                    eVar.a();
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (z3) {
                        z = true;
                        if (z) {
                            eVar.a();
                        } else {
                            gVar = new g(str, eVar);
                            if (xLUserInfo2.d() == null) {
                                gVar.a();
                            } else {
                                xLUserInfo2.b.a(2, gVar);
                            }
                        }
                    }
                }
            }
            eVar.a();
        } else {
            a(i, z2);
            b();
        }
        a.a(obj, i, this.t, this.g.f(), l());
        new f$a().sendEmptyMessage(1);
    }

    private void a(int i, boolean z) {
        l lVar = this.f;
        Object obj = this.s;
        for (int i2 = 0; i2 < lVar.b.size(); i2++) {
            c cVar = (c) lVar.b.get(i2);
            if (cVar.isCanceled()) {
                lVar.b.remove(i2);
            }
            if (i == 0) {
                cVar.onLoginCompleted(true, i, obj);
            } else {
                cVar.onLoginCompleted(false, i, obj);
            }
        }
        lVar.b.clear();
        ArrayList arrayList = new ArrayList(this.f.a);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            com.xunlei.downloadprovider.member.login.b.d dVar = (com.xunlei.downloadprovider.member.login.b.d) arrayList.get(i3);
            if (i == 0) {
                dVar.onLoginCompleted(true, i, z);
            } else {
                dVar.onLoginCompleted(false, i, z);
            }
        }
    }

    public final void a(com.xunlei.downloadprovider.member.login.b.d dVar) {
        l lVar = this.f;
        if (dVar != null && !lVar.a.contains(dVar)) {
            lVar.a.add(dVar);
        }
    }

    public final void b(com.xunlei.downloadprovider.member.login.b.d dVar) {
        this.f.a.remove(dVar);
    }

    public final void a(com.xunlei.downloadprovider.member.login.b.g gVar) {
        l lVar = this.f;
        if (gVar != null && !lVar.d.contains(gVar)) {
            lVar.d.add(gVar);
        }
    }

    public final void b(com.xunlei.downloadprovider.member.login.b.g gVar) {
        this.f.d.remove(gVar);
    }

    public final void a(com.xunlei.downloadprovider.member.login.b.h hVar) {
        i iVar = this.g;
        if (hVar != null && !iVar.a.contains(hVar)) {
            iVar.a.add(hVar);
        }
    }

    public final void b(com.xunlei.downloadprovider.member.login.b.h hVar) {
        this.g.a.remove(hVar);
    }

    public final void a(com.xunlei.downloadprovider.member.login.b.k kVar) {
        i iVar = this.g;
        if (kVar != null && !iVar.b.contains(kVar)) {
            iVar.b.add(kVar);
        }
    }

    public final void b(com.xunlei.downloadprovider.member.login.b.k kVar) {
        this.g.b.remove(kVar);
    }

    public final void b() {
        if (!this.u) {
            this.u = true;
            i.a(this.q);
        }
    }

    public final void a(boolean z) {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            if (l.a(this.q, z ? "manual_auto_login" : "auto_login")) {
                this.b.c = false;
                this.b.a = true;
            }
        }
    }

    public final void a(e$e com_xunlei_downloadprovider_member_login_b_e_e) {
        this.y = com_xunlei_downloadprovider_member_login_b_e_e;
        l.a(this.q);
        i.k();
    }

    public final void a(e$c com_xunlei_downloadprovider_member_login_b_e_c) {
        this.B = com_xunlei_downloadprovider_member_login_b_e_c;
        i.g(this.q);
    }

    public final void a(e$j com_xunlei_downloadprovider_member_login_b_e_j) {
        this.z = com_xunlei_downloadprovider_member_login_b_e_j;
        i.d(this.q);
    }

    public final void a(int i, e$i com_xunlei_downloadprovider_member_login_b_e_i) {
        this.A = com_xunlei_downloadprovider_member_login_b_e_i;
        com_xunlei_downloadprovider_member_login_b_e_i = this.q;
        if (i == 1) {
            com.xunlei.downloadprovider.member.login.b.a.a(i, "4286195229", "http://m.xunlei.com", com_xunlei_downloadprovider_member_login_b_e_i);
        } else if (i == 15) {
            com.xunlei.downloadprovider.member.login.b.a.a(i, "1101105049", "", com_xunlei_downloadprovider_member_login_b_e_i);
        } else if (i == 21) {
            com.xunlei.downloadprovider.member.login.b.a.a(i, "wx3e6556568beeebdd", "", com_xunlei_downloadprovider_member_login_b_e_i);
        }
    }

    public final String c() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.SessionID);
    }

    public final String a(int i) {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getJumpKey(i);
    }

    public final String d() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.UserName);
    }

    public final String e() {
        return this.g.a(300);
    }

    public final String f() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.Birthday);
    }

    public final XLSexType g() {
        i iVar = this.g;
        iVar.b();
        return XLSexType.getXLSexType(iVar.e.getStringValue(USERINFOKEY.Sex));
    }

    public final String h() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.PersonalSign);
    }

    public final String i() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.PhoneNumber);
    }

    public final String j() {
        i iVar = this.g;
        iVar.b();
        String stringValue = iVar.e.getStringValue(USERINFOKEY.Province);
        return "省份".equals(stringValue) ? "" : stringValue;
    }

    public final String k() {
        i iVar = this.g;
        iVar.b();
        String stringValue = iVar.e.getStringValue(USERINFOKEY.City);
        if ("城市".equals(stringValue)) {
            return "";
        }
        return stringValue.replace("市", "");
    }

    public final void a(e$b com_xunlei_downloadprovider_member_login_b_e_b) {
        if (com_xunlei_downloadprovider_member_login_b_e_b != null) {
            this.C = com_xunlei_downloadprovider_member_login_b_e_b;
            i.c(this.q);
        }
    }

    public final boolean l() {
        return this.g.e() == 1;
    }

    public final int m() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getIntValue(USERINFOKEY.vip_level);
    }

    public final String n() {
        i iVar = this.g;
        String d = iVar.d();
        return (d == null || d.equals("")) ? String.valueOf(iVar.c()) : d;
    }

    public final String o() {
        i iVar = this.g;
        if (iVar.g()) {
            return iVar.h().c;
        }
        iVar.b();
        return iVar.e.getStringValue(USERINFOKEY.ExpireDate);
    }

    public final int p() {
        i iVar = this.g;
        iVar.b();
        return iVar.e.getIntValue(USERINFOKEY.Account);
    }

    public static String q() {
        return n.c();
    }

    public final boolean r() {
        return 2 == this.g.f();
    }

    public final boolean s() {
        return 3 == this.g.f();
    }

    public final boolean t() {
        return 5 == this.g.f();
    }

    public final boolean u() {
        i iVar = this.g;
        int i;
        if (iVar.g()) {
            i = iVar.h().j;
            return i <= 200 && i % 5 == 0 && i % 10 != 0;
        } else {
            iVar.b();
            i = iVar.e.getIntValue(USERINFOKEY.PayId);
            return i <= 200 && i % 5 == 0 && i % 10 != 0;
        }
    }

    public final void a(Bitmap bitmap, String str) {
        i.a(this.q, bitmap, str);
    }

    public final void a(String str, String str2, String str3) {
        XLOnUserListener xLOnUserListener = this.q;
        Map hashMap = new HashMap();
        if (!(str == null || str.isEmpty())) {
            hashMap.put(USERINFOKEY.Province, str);
        }
        if (str2 != null && str2.isEmpty() == null) {
            hashMap.put(USERINFOKEY.City, str2);
        }
        i.a(xLOnUserListener, hashMap, (Object) str3);
    }

    public final void a(XLSexType xLSexType, String str) {
        XLOnUserListener xLOnUserListener = this.q;
        xLSexType = xLSexType.toString();
        Map hashMap = new HashMap();
        hashMap.put(USERINFOKEY.Sex, xLSexType);
        i.a(xLOnUserListener, hashMap, (Object) str);
    }

    public final void a(e$a com_xunlei_downloadprovider_member_login_b_e_a, String str, String str2) {
        if (ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance(), "com.tencent.mm")) {
            this.b.e = true;
            XLOnUserListener xLOnUserListener = this.q;
            XLWxParam xLWxParam = new XLWxParam();
            xLWxParam.mWxAppId = "wx3e6556568beeebdd";
            l.a(21, xLWxParam, xLOnUserListener, l.a(str, str2));
            this.f.a(this.k);
            if (com_xunlei_downloadprovider_member_login_b_e_a != null) {
                com_xunlei_downloadprovider_member_login_b_e_a.a();
                return;
            }
        }
        b((int) R.string.login_wx_noinstall);
        if (com_xunlei_downloadprovider_member_login_b_e_a != null) {
            com_xunlei_downloadprovider_member_login_b_e_a.b();
        }
    }

    public final void b(e$a com_xunlei_downloadprovider_member_login_b_e_a, String str, String str2) {
        if (ApkHelper.isApkPackageInstalled(BrothersApplication.getApplicationInstance(), "com.tencent.mobileqq")) {
            this.b.b = true;
            XLOnUserListener xLOnUserListener = this.q;
            XLQQParam xLQQParam = new XLQQParam();
            xLQQParam.mAppID = "1101105049";
            l.a(15, xLQQParam, xLOnUserListener, l.a(str, str2));
            this.f.a(this.k);
            if (com_xunlei_downloadprovider_member_login_b_e_a != null) {
                com_xunlei_downloadprovider_member_login_b_e_a.a();
                return;
            }
        }
        b((int) R.string.login_qq_noinstall);
        if (com_xunlei_downloadprovider_member_login_b_e_a != null) {
            com_xunlei_downloadprovider_member_login_b_e_a.b();
        }
    }

    private static void b(int i) {
        com.xunlei.downloadprovider.member.register.view.a.a(BrothersApplication.getApplicationInstance(), i).a();
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, int i2, int i3, Object obj) {
        loginHelper.b.c = true;
        f fVar = loginHelper.b;
        boolean z = false;
        i3 = (i == 0 && i3 == 1) ? 1 : 0;
        fVar.d = i3;
        i3 = loginHelper.b;
        if (i == 0 && i2 == 21) {
            z = true;
        }
        i3.e = z;
        loginHelper.i.a(true);
        a.a(loginHelper.b.d, i2, loginHelper.g.d());
        a.a(i, i2, obj, loginHelper.b.d);
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i) {
        if (i == 4) {
            loginHelper.j.a(2, 1);
        }
        loginHelper.d = false;
        i.j();
        loginHelper.i.a(false);
        a.b(loginHelper.E);
        ArrayList arrayList = new ArrayList(loginHelper.f.d);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((com.xunlei.downloadprovider.member.login.b.g) arrayList.get(i2)).onLogout();
        }
        loginHelper.g.f = 0;
        loginHelper.g.g = 0;
        loginHelper.b.d = false;
        loginHelper.b.c = false;
        loginHelper.b.e = false;
        a.a(i);
        a.d();
        a.c();
        a.h();
        a.g();
        a.f();
        com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.h.a();
        if (i == 1 || i == 5) {
            loginHelper.a(false);
        }
        if (loginHelper.y != 0) {
            loginHelper.y.a();
        }
        loginHelper.y = 0;
        LoginActivity.c = false;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, XLUserInfo xLUserInfo) {
        loginHelper.u = false;
        if (xLUserInfo != null) {
            if (i == 0) {
                loginHelper.g.e = xLUserInfo;
                loginHelper.g.i();
                a.a(loginHelper);
                loginHelper.a((e$b) null);
            }
            xLUserInfo = new ArrayList(loginHelper.g.a);
            for (loginHelper = null; loginHelper < xLUserInfo.size(); loginHelper++) {
                com.xunlei.downloadprovider.member.login.b.h hVar = (com.xunlei.downloadprovider.member.login.b.h) xLUserInfo.get(loginHelper);
                if (i == 0) {
                    hVar.onRefreshUserInfoCompleted(true, i);
                } else {
                    hVar.onRefreshUserInfoCompleted(false, i);
                }
            }
        }
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, Object obj) {
        a aVar = loginHelper.h;
        long c = loginHelper.g.c();
        if (i == 0) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.member.login.c.d(aVar, c, VolleyRequestManager.getMainThreadRequestQueue()));
        }
        String str = (String) obj;
        ArrayList arrayList = new ArrayList(loginHelper.g.b);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            com.xunlei.downloadprovider.member.login.b.k kVar = (com.xunlei.downloadprovider.member.login.b.k) arrayList.get(i2);
            if (i == 0) {
                kVar.a(true, i, str);
            } else {
                kVar.a(false, i, str);
            }
        }
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, XLUserInfo xLUserInfo, XLHspeedCapacity xLHspeedCapacity) {
        if (!(i != 0 || xLUserInfo == null || xLHspeedCapacity == null)) {
            long j = xLHspeedCapacity.total_capacity;
            long j2 = j - xLHspeedCapacity.used_capacity;
            loginHelper.g.f = j;
            loginHelper.g.g = j2;
            xLUserInfo = loginHelper.g;
            loginHelper.g.c();
            xLHspeedCapacity = new ArrayList(xLUserInfo.c);
            for (xLUserInfo = null; xLUserInfo < xLHspeedCapacity.size(); xLUserInfo++) {
                ((e$f) xLHspeedCapacity.get(xLUserInfo)).a(i, j, j2);
            }
        }
        xLUserInfo = new StringBuilder("onHighSpeedCatched() errorCode=");
        xLUserInfo.append(i);
        xLUserInfo.append(" errorDesc=");
        xLUserInfo.append(XLErrorCode.getErrorDesc(i));
        xLUserInfo.append(" capacity=");
        xLUserInfo.append(loginHelper.g.f);
        xLUserInfo.append(" remain=");
        xLUserInfo.append(loginHelper.g.g);
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, XLLixianCapacity xLLixianCapacity) {
        if (xLLixianCapacity != null) {
            b bVar = new b();
            bVar.a = i;
            if (i == 0) {
                bVar.d = ((((long) xLLixianCapacity.total_capacity) * 1024) * 1024) * 1024;
                bVar.c = ((((long) xLLixianCapacity.used_capacity) * 1024) * 1024) * 1024;
                loginHelper.a = bVar;
            }
            xLLixianCapacity = new StringBuilder("onLixianCatched() errorCode=");
            xLLixianCapacity.append(i);
            xLLixianCapacity.append(" errorDesc=");
            xLLixianCapacity.append(XLErrorCode.getErrorDesc(i));
            xLLixianCapacity.append(" capacity=");
            xLLixianCapacity.append(bVar.d);
            xLLixianCapacity.append(" remain=");
            xLLixianCapacity.append(bVar.c);
            loginHelper.g.a(i, bVar);
        }
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, byte[] bArr) {
        if (loginHelper.B != null) {
            loginHelper.B.a(i, str, bArr);
        }
        loginHelper.B = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str) {
        if (loginHelper.l != null) {
            loginHelper.l.a(i, str);
        }
        loginHelper.l = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, XLBindedOtherAccountItem[] xLBindedOtherAccountItemArr, int i) {
        if (loginHelper.z != null && i == 0) {
            loginHelper.z.a(xLBindedOtherAccountItemArr);
        }
        loginHelper.z = null;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, int i2, XLThirdUserInfo xLThirdUserInfo) {
        if (loginHelper.A != null) {
            if (i == 0) {
                loginHelper.A.a(i2, xLThirdUserInfo);
            } else {
                loginHelper.A.a(i2, i, str);
            }
        }
        loginHelper.A = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, int i2) {
        if (loginHelper.m != null) {
            if (i2 == 0) {
                loginHelper.m.a(i);
            } else {
                loginHelper.m.a();
            }
        }
        loginHelper.m = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, XLThirdUserInfo xLThirdUserInfo) {
        if (loginHelper.n != null && i == 0) {
            loginHelper.n.a(xLThirdUserInfo);
        }
        loginHelper.n = 0;
    }

    static /* synthetic */ void b(LoginHelper loginHelper, int i) {
        if (loginHelper.o != null) {
            loginHelper.o.a(i);
        }
        loginHelper.o = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, JSONObject jSONObject) {
        StringBuilder stringBuilder = new StringBuilder("errorCode, errorDesc, cityInfo = ");
        stringBuilder.append(i);
        stringBuilder.append(", ");
        stringBuilder.append(str);
        stringBuilder.append(", ");
        stringBuilder.append(jSONObject);
        if (i == 0 && jSONObject != null) {
            i = jSONObject.optString("province");
            str = jSONObject.optString("provincecode");
            String optString = jSONObject.optString("city");
            String optString2 = jSONObject.optString("citycode");
            if (TextUtils.isEmpty(loginHelper.k()) && TextUtils.isEmpty(loginHelper.j())) {
                loginHelper.a(str, optString2, "set_address_by_ip");
            }
            if (loginHelper.C != null) {
                loginHelper.C.a(i, optString);
            }
        } else if (loginHelper.C != 0) {
            loginHelper.C.a();
        }
        loginHelper.C = 0;
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, String str2) {
        if (loginHelper.p != null) {
            loginHelper.p.a(i, str, str2);
        }
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, XLUserInfo xLUserInfo, Object obj) {
        if (i == 0) {
            loginHelper.g.e = xLUserInfo;
            loginHelper.a(i, xLUserInfo, obj, str);
        }
        if (loginHelper.p != null) {
            loginHelper.p.a(i, str);
        }
    }

    static /* synthetic */ void a(LoginHelper loginHelper, int i, String str, boolean z, XLUserInfo xLUserInfo, Object obj) {
        if (i == 0) {
            loginHelper.g.e = xLUserInfo;
            if (z) {
                loginHelper.a(i, xLUserInfo, obj, str);
            }
        }
        if (loginHelper.p) {
            loginHelper.p.b(i, str);
        }
    }
}
