package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.os.Environment;
import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.net.volley.BaseStringRequest;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.r;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.a;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FreeTrialRedPacketHelper */
public class f extends e {
    private static f c;
    public HashSet<a> a = null;
    private String b;
    private String d = "";
    private r f;

    public static f a() {
        if (c == null) {
            synchronized (f.class) {
                if (c == null) {
                    c = new f();
                }
            }
        }
        return c;
    }

    private f() {
        LoginHelper.a().a(new g(this));
        LoginHelper.a().a(new h(this));
        XLThreadPool.execute(new i(this));
    }

    private static boolean k() {
        if (c.a().a("vip2017sl99")) {
            if (c.a().a("vip2017sl9901")) {
                return true;
            }
        }
        return false;
    }

    private boolean l() {
        boolean z = false;
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.b.toString());
            if (jSONObject.optInt("result") == 0) {
                jSONObject = jSONObject.optJSONObject("data");
                if (jSONObject != null && jSONObject.optInt("isGet") == 1) {
                    z = true;
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return z;
    }

    private boolean m() {
        try {
            if (TextUtils.isEmpty(this.d)) {
                return false;
            }
            String[] split = this.d.split(Constants.COLON_SEPARATOR);
            if (split == null || split.length < 2 || !RePlugin.PROCESS_PERSIST.equals(split[1])) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean n() {
        boolean z = false;
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        try {
            if (new JSONObject(this.b).optInt("result") == -3) {
                z = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return z;
    }

    private boolean o() {
        boolean z = false;
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        try {
            if (new JSONObject(this.b).optInt("result") == -99) {
                z = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return z;
    }

    private boolean p() {
        boolean z = false;
        if (TextUtils.isEmpty(this.b)) {
            return false;
        }
        try {
            if (new JSONObject(this.b).optInt("result") == -4) {
                z = true;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return z;
    }

    public final boolean b() {
        LoginHelper.a();
        return (!l.b() || k() || m() || o() || n() || !l()) ? false : true;
    }

    public final boolean c() {
        LoginHelper.a();
        return (!l.b() || k() || m() || o() || !p()) ? false : true;
    }

    public final void d() {
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
    }

    public final int e() {
        if (!b()) {
            if (!c()) {
                return 0;
            }
        }
        return 101;
    }

    public final r f() {
        if (this.f == null) {
            this.f = c.a().b(com.xunlei.downloadprovider.member.payment.f.a(PayFrom.DOWNLOAD_TASK_FREE_TRIAL));
        }
        return this.f;
    }

    public final boolean g() {
        return !LoginHelper.a().l() && b();
    }

    private static File q() {
        String stringBuilder;
        StringBuilder stringBuilder2;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            stringBuilder2.append("/xunlei/.freetrial/");
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(BrothersApplication.getApplicationInstance().getCacheDir());
            stringBuilder2.append("/xunlei/.freetrial/");
            stringBuilder = stringBuilder2.toString();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(LoginHelper.a().g.c());
        stringBuilder3.append("_freetrial6");
        return new File(stringBuilder, stringBuilder3.toString());
    }

    static /* synthetic */ void b(f fVar) {
        StringBuilder stringBuilder = new StringBuilder("http://dypay.vip.xunlei.com/lxtry/valid");
        LoginHelper.a();
        if (l.b()) {
            stringBuilder.append("?userid=");
            stringBuilder.append(LoginHelper.a().g.c());
            stringBuilder.append("&sessionid=");
            stringBuilder.append(LoginHelper.a().c());
        }
        fVar.a(new BaseStringRequest(stringBuilder.toString(), new j(fVar), new k(fVar)));
    }

    static /* synthetic */ String i() throws Exception {
        File q = q();
        if (q.exists()) {
            StringBuilder a = com.xunlei.downloadprovider.h.e.a(q.getPath(), "UTF-8");
            if (a != null && a.length() > 0) {
                return a.b("FreeTrial6", a.toString());
            }
        }
        return null;
    }

    static /* synthetic */ void c(f fVar) {
        if (!d.a(fVar.a)) {
            new StringBuilder("set size=").append(fVar.a.size());
            fVar = fVar.a.iterator();
            while (fVar.hasNext()) {
                ((a) fVar.next()).a();
            }
        }
    }

    static /* synthetic */ void c(f fVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            fVar.d = str;
            XLThreadPool.execute(new n(fVar, str));
        }
    }
}
