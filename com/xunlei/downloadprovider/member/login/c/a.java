package com.xunlei.downloadprovider.member.login.c;

import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI.Token;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.b.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.m;
import com.xunlei.downloadprovider.member.login.ui.ai;
import com.xunlei.downloadprovider.member.register.ui.AuthMobileActivity;
import com.xunlei.downloadprovider.personal.user.account.l;
import com.xunlei.downloadprovider.pushmessage.b.b;
import com.xunlei.downloadprovider.pushmessage.e;
import com.xunlei.xllib.android.XLIntent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: LoginBusinessHelper */
public class a {
    private static a c;
    public List<m> a = new ArrayList();
    private final String b = a.class.getName();

    /* compiled from: LoginBusinessHelper */
    public interface a {
        void a();
    }

    private a() {
    }

    public static a a() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public static void b() {
        b a = b.a();
        String str = "user_login_status";
        boolean z = false;
        if (a.a != null) {
            z = a.a.getBoolean(str, false);
        }
        if (!z) {
            e.c().a(true);
            b.a().a(true);
        }
    }

    public static void c() {
        e.c().a(false);
        b.a().a(false);
    }

    public static void d() {
        n.a().a(new a(0, null, null, false), true);
    }

    public static void e() {
        LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance()).sendBroadcast(new XLIntent("new_user_login_success"));
    }

    public static int a(boolean z, boolean z2, String str, String str2, boolean z3, String str3) {
        int i = 0;
        z = !z ? true : false;
        z2 = !z2 ? true : false;
        str = (TextUtils.isEmpty(str) || str.equals("u") != null) ? null : 2;
        str2 = TextUtils.isEmpty(str2) == null ? 2 : null;
        if (z3) {
            i = 2;
        }
        return ((((((z + z2) + str) + str2) + i) + (TextUtils.isEmpty(str3) ^ 1)) * 100) / 14;
    }

    public static void a(long j) {
        ThunderReport.setShouleiUserId(j);
    }

    public static void a(LoginHelper loginHelper) {
        n.a();
        n.a(loginHelper.l(), loginHelper.g.g());
        n.a().a(loginHelper);
        if ((loginHelper.l() || loginHelper.g.g > 0) && SettingStateController.getInstance().getAutoHighSpeedChannel() != null) {
            n.a();
            n.g();
        }
    }

    public static void f() {
        r.b = false;
        AuthMobileActivity.a = false;
        r.c = false;
        r.a().d = false;
        r.a().a.clear();
    }

    public static void g() {
        c.a(null).a();
    }

    public static void h() {
        LocalBroadcastManager.getInstance(BrothersApplication.getApplicationInstance()).sendBroadcast(new XLIntent("user_logout"));
    }

    public static void a(JSONObject jSONObject) {
        com.xunlei.downloadprovider.personal.user.account.address.b.b a = com.xunlei.downloadprovider.personal.user.account.address.b.b.a();
        if (jSONObject != null) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.personal.user.account.address.b.c(a, jSONObject));
        }
    }

    public static void a(boolean z, int i, String str) {
        if (z) {
            l.a().b(i, str);
        }
    }

    public static void a(com.xunlei.downloadprovider.broadcast.b bVar) {
        com.xunlei.downloadprovider.broadcast.a.a().a(bVar);
    }

    public static void b(com.xunlei.downloadprovider.broadcast.b bVar) {
        com.xunlei.downloadprovider.broadcast.a.a().b(bVar);
    }

    public static void a(boolean z) {
        if (z) {
            c.a(false).a("2;3;4;5;6;9;13");
        }
    }

    public static void a(int i) {
        if (i == 0) {
            ai.a("active_exit", 0);
        } else {
            ai.a("passive_exit", i);
        }
    }

    public static void a(Object obj, int i, String str, int i2, boolean z) {
        if (obj != null && (obj instanceof String)) {
            String str2 = (String) obj;
            if (str != null) {
                if (str2.equals("user_login_has_verify_code")) {
                    ai.a(i, str, i2, z, true);
                } else if (str2.equals("user_login_page")) {
                    ai.a(i, str, i2, z, false);
                } else if (str2.equals("user_login_mms")) {
                    ai.a(i, str, i2, z, false);
                }
            }
            if (str2.equals("auto_login") != null) {
                if (i == 0) {
                    obj = HubbleEventBuilder.build("android_auto_login_success", "auto_login_success");
                    obj.add("is_vip", (int) z);
                    obj.add("vip_type", i2);
                    com.xunlei.downloadprovider.member.login.a.a(obj);
                    return;
                }
                obj = HubbleEventBuilder.build("android_auto_login_fail", "auto_login_fail");
                obj.add("failtype", i);
                com.xunlei.downloadprovider.member.login.a.a(obj);
            } else if (str2.equals("manual_auto_login") != null) {
                if (i == 0) {
                    obj = HubbleEventBuilder.build("android_auto_login_success", "manual_auto_login_success");
                    obj.add("is_vip", (int) z);
                    obj.add("vip_type", i2);
                    com.xunlei.downloadprovider.member.login.a.a(obj);
                    return;
                }
                obj = HubbleEventBuilder.build("android_auto_login_fail", "manual_auto_login_fail");
                obj.add("failtype", i);
                com.xunlei.downloadprovider.member.login.a.a(obj);
            }
        }
    }

    public static void a(int i, int i2, Object obj, boolean z) {
        String str = "";
        String str2 = "";
        if (obj instanceof Map) {
            Map map = (Map) obj;
            str = (String) map.get("loginFrom");
            str2 = (String) map.get("from");
        }
        String str3 = "";
        if (i2 == 1) {
            str3 = "weibo";
        } else if (i2 == 8) {
            str3 = "xiaomi";
        } else if (i2 == 15) {
            str3 = Constants.SOURCE_QQ;
        } else if (i2 == 21) {
            str3 = Token.WX_TOKEN_PLATFORMID_VALUE;
        }
        if (i == 0) {
            String str4 = z ? "register" : "login";
            i2 = HubbleEventBuilder.build("android_login_third", "login_third_success");
            i2.add("from_src", str);
            i2.add("from", str2);
            i2.add("login_account", str3);
            i2.add("result_type", str4);
            com.xunlei.downloadprovider.member.register.a.a(i2);
            return;
        }
        i2 = HubbleEventBuilder.build("android_login_third", "login_third_fail");
        i2.add("from", str2);
        i2.add("login_account", str3);
        i2.add("failtype", i);
        com.xunlei.downloadprovider.member.register.a.a(i2);
    }
}
