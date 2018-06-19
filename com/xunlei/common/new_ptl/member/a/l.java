package com.xunlei.common.new_ptl.member.a;

import android.text.TextUtils;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.act.XLQQLoginActivity;
import org.json.JSONObject;

/* compiled from: XLQQAuthListener */
public class l implements IUiListener {
    private String a = l.class.getSimpleName();
    private XLQQLoginActivity b = null;

    public l(XLQQLoginActivity xLQQLoginActivity) {
        this.b = xLQQLoginActivity;
    }

    public void onComplete(Object obj) {
        int i;
        XLLog.v(this.a, "XLQQAuthListener onComplete");
        if (obj != null) {
            obj = (JSONObject) obj;
            i = 0;
            try {
                CharSequence string = obj.getString("access_token");
                CharSequence string2 = obj.getString("expires_in");
                Object string3 = obj.getString("openid");
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3))) {
                    String str = this.a;
                    StringBuilder stringBuilder = new StringBuilder("getOpenidAndToken succeed opeid = ");
                    stringBuilder.append(string3);
                    XLLog.v(str, stringBuilder.toString());
                }
            } catch (Exception e) {
                String str2 = this.a;
                StringBuilder stringBuilder2 = new StringBuilder("getOpenidAndToken error ");
                stringBuilder2.append(e.getMessage());
                XLLog.v(str2, stringBuilder2.toString());
            }
        } else {
            obj = null;
            i = XLErrorCode.AUTH_USER_ERROR;
        }
        this.b.acceptQQAuthResult(i, obj);
    }

    public void onError(UiError uiError) {
        String str = this.a;
        StringBuilder stringBuilder = new StringBuilder("XLQQAuthListener onError = ");
        stringBuilder.append(uiError.errorMessage);
        XLLog.v(str, stringBuilder.toString());
        this.b.acceptQQAuthResult(XLErrorCode.AUTH_USER_ERROR, null);
    }

    public void onCancel() {
        XLLog.v(this.a, "XLQQAuthListener onCancel");
        this.b.acceptQQAuthResult(XLErrorCode.AUTH_USER_CANCLE, null);
    }

    private void a(JSONObject jSONObject) {
        String str;
        StringBuilder stringBuilder;
        try {
            CharSequence string = jSONObject.getString("access_token");
            CharSequence string2 = jSONObject.getString("expires_in");
            jSONObject = jSONObject.getString("openid");
            if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(jSONObject))) {
                str = this.a;
                stringBuilder = new StringBuilder("getOpenidAndToken succeed opeid = ");
                stringBuilder.append(jSONObject);
                XLLog.v(str, stringBuilder.toString());
            }
        } catch (JSONObject jSONObject2) {
            str = this.a;
            stringBuilder = new StringBuilder("getOpenidAndToken error ");
            stringBuilder.append(jSONObject2.getMessage());
            XLLog.v(str, stringBuilder.toString());
        }
    }
}
