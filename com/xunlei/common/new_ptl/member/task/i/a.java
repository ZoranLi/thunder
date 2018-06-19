package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserGetCityCodeByIpTask */
public class a extends com.xunlei.common.new_ptl.member.task.a {
    private String a = a.class.getSimpleName();
    private String b = "https://interface-account-ssl.xunlei.com/service/user_info?request=getcodebyip";
    private JSONObject c = null;
    private JSONObject d = null;

    static /* synthetic */ int a(a aVar, int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : i == 203 ? XLErrorCode.UNKNOWN_ERROR : i == 204 ? 6 : i == 205 ? XLErrorCode.NICK_NAME_SW : i == 206 ? XLErrorCode.PERSONAL_SIGN_SW : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : i == 203 ? XLErrorCode.UNKNOWN_ERROR : i == 204 ? 6 : i == 205 ? XLErrorCode.NICK_NAME_SW : i == 206 ? XLErrorCode.PERSONAL_SIGN_SW : XLErrorCode.UNKNOWN_ERROR;
    }

    public a(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            this.c = new JSONObject();
            try {
                this.c.put("userid", e().getLongValue(USERINFOKEY.UserID));
                this.c.put("sessionid", e().getStringValue(USERINFOKEY.SessionID));
                this.c.put("businesstype", d().d());
                this.c.put("deviceid", XLDeviceGen.getInstance().getDeviceIdSign());
                this.c.put("protocolversion", 200);
                this.c.put("platform", "2");
                this.c.put("clientVersion", d().c());
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
        f(XLErrorCode.OPERATION_INVALID);
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserGetCityCodeByIp(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.d, f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((com.xunlei.common.new_ptl.member.task.a) this, bundle);
    }
}
