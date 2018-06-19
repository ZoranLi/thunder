package com.xunlei.common.new_ptl.member.task.i;

import android.os.Bundle;
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

/* compiled from: UserGetCityInfoTask */
public class b extends a {
    private String a = b.class.getSimpleName();
    private String b = "https://interface-account-ssl.xunlei.com/service/user_info?request=city";
    private JSONObject c = null;

    static /* synthetic */ int a(b bVar, int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 201 ? 13 : i == 202 ? 1 : XLErrorCode.UNKNOWN_ERROR;
    }

    public b(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        if (d().r()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("userid", e().getLongValue(USERINFOKEY.UserID));
                jSONObject.put("sessionid", e().getStringValue(USERINFOKEY.SessionID));
                jSONObject.put("businesstype", d().d());
                jSONObject.put("deviceid", XLDeviceGen.getInstance().getDeviceIdSign());
                jSONObject.put("protocolversion", 200);
                jSONObject.put("platform", "2");
                jSONObject.put("clientVersion", d().c());
                String jSONObject2 = jSONObject.toString();
                String str = this.a;
                StringBuilder stringBuilder = new StringBuilder("xl user get city info buffer = ");
                stringBuilder.append(jSONObject2);
                XLLog.v(str, stringBuilder.toString());
                d().l().post(d().h(), this.b, new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, jSONObject2.getBytes(), new 1(this));
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
                return xLOnUserListener.onUserGetCityInfo(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.c, f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }
}
