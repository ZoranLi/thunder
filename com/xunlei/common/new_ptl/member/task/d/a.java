package com.xunlei.common.new_ptl.member.task.d;

import android.os.Bundle;
import android.text.TextUtils;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserKeyLoginTask */
public final class a extends com.xunlei.common.new_ptl.member.task.a {
    private String a = "";
    private String b;
    private String c = "";
    private String d = "";
    private String e = "";

    public a(p pVar) {
        super(pVar);
    }

    public final void a() {
        super.a();
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (!(xLOnUserListener == null || bundle == null)) {
            if (bundle.getString("action") == "userKeyLoginTask") {
                return xLOnUserListener.onUserLogin(bundle.getInt("errorCode"), bundle.getString("errorDesc"), this.d, e(), f(), g());
            }
        }
        return null;
    }

    public final void a(String str, String str2, String str3) {
        this.a = str;
        this.e = str3;
    }

    public final boolean h() {
        if (com.xunlei.common.new_ptl.member.task.a.a.d == c()) {
            return false;
        }
        a(com.xunlei.common.new_ptl.member.task.a.a.b);
        JSONObject i = i();
        try {
            i.put("userName", this.a);
            i.put("loginKey", this.e);
            String jSONObject = i.toString();
            XLLog.v("UserKeyLoginTask", jSONObject);
            d().k().a(jSONObject.getBytes(), 7, new 1(this), g());
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            f(XLErrorCode.PACKAGE_ERROR);
            a(com.xunlei.common.new_ptl.member.task.a.a.c);
            return false;
        }
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "userKeyLoginTask");
        bundle.putInt("errorCode", i);
        if (TextUtils.isEmpty(this.c)) {
            this.c = XLErrorCode.getErrorDesc(i);
        }
        bundle.putString("errorDesc", this.c);
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
    }
}
