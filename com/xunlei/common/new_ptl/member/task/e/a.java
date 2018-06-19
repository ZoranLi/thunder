package com.xunlei.common.new_ptl.member.task.e;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserMobileLoginTask */
public class a extends com.xunlei.common.new_ptl.member.task.a {
    private static final String a = "a";
    private int b = 0;
    private String c;
    private String d;
    private String e;
    private String f;
    private boolean g = false;
    private String h;
    private String i;

    static /* synthetic */ int a(a aVar, int i) {
        return i == 1001 ? 36 : i;
    }

    private static int h(int i) {
        return i == 1001 ? 36 : i;
    }

    public final void a(String str, String str2, String str3) {
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    public final void a(String str, boolean z) {
        this.g = z;
        this.f = str;
    }

    public final void f(int i) {
        this.b = i;
    }

    public a(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        XLLog.v("UserMobileLoginTask", "mobile login/register call");
        JSONObject i = i();
        try {
            i.put("mobile", this.c);
            i.put("smsCode", this.d);
            i.put("token", this.e);
            i.put("register", String.valueOf(this.b));
            if (this.b == 1) {
                i.put("password", this.f);
                i.put("isMd5Pwd", "0");
                if (this.g) {
                    i.put("nologin", "0");
                } else {
                    i.put("nologin", "1");
                }
            }
            String jSONObject = i.toString();
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("mobile login request package = ");
            stringBuilder.append(jSONObject);
            XLLog.v(str, stringBuilder.toString());
            d().k().a(jSONObject.getBytes(), 10, new 1(this), g());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            g(XLErrorCode.PACKAGE_ERROR);
            a(com.xunlei.common.new_ptl.member.task.a.a.c);
            return false;
        }
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userMobileLoginTask") {
                if (this.b == 0) {
                    return xLOnUserListener.onUserMobileLogin(bundle.getInt("errorCode"), this.h, this.i, e(), f(), g());
                }
                return xLOnUserListener.onUserMobileRegister(bundle.getInt("errorCode"), this.h, this.i, this.g, e(), f(), g());
            }
        }
        return null;
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userMobileLoginTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.h)) {
            this.h = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.h);
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
    }
}
