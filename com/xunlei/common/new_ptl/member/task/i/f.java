package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserSetUserInfoTask */
public class f extends a {
    private String a = f.class.getSimpleName();
    private String b = "https://interface-account-ssl.xunlei.com/service/user_info?request=set";
    private JSONObject c = null;
    private String d = "";
    private String e = "";

    static /* synthetic */ int a(f fVar, int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : i == 203 ? XLErrorCode.UNKNOWN_ERROR : i == 204 ? 6 : i == 205 ? XLErrorCode.NICK_NAME_SW : i == 206 ? XLErrorCode.PERSONAL_SIGN_SW : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : i == 203 ? XLErrorCode.UNKNOWN_ERROR : i == 204 ? 6 : i == 205 ? XLErrorCode.NICK_NAME_SW : i == 206 ? XLErrorCode.PERSONAL_SIGN_SW : XLErrorCode.UNKNOWN_ERROR;
    }

    public f(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (!d().r()) {
            f(XLErrorCode.OPERATION_INVALID);
            return true;
        } else if (this.c == null) {
            f(XLErrorCode.PACKAGE_ERROR);
            return true;
        } else {
            try {
                this.c.put("userid", e().getLongValue(USERINFOKEY.UserID));
                this.c.put("sessionid", e().getStringValue(USERINFOKEY.SessionID));
                this.c.put("businesstype", d().d());
                this.c.put("deviceid", XLDeviceGen.getInstance().getDeviceIdSign());
                this.c.put("protocolversion", 200);
                this.c.put("platform", "2");
                this.c.put("clientVersion", d().c());
                if (!(TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.e))) {
                    this.c.put("verifykey", this.d);
                    this.c.put("verifycode", this.e);
                }
                String jSONObject = this.c.toString();
                String str = this.a;
                StringBuilder stringBuilder = new StringBuilder("xl user set info buffer = ");
                stringBuilder.append(jSONObject);
                XLLog.v(str, stringBuilder.toString());
                d().l().post(d().h(), this.b, new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, jSONObject.getBytes(), new 1(this));
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                f(1);
                return true;
            }
        }
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserSetInfo(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    public final void a(JSONObject jSONObject, String str, String str2) {
        this.c = jSONObject;
        this.d = str;
        this.e = str2;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }
}
