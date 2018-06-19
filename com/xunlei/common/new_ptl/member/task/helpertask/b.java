package com.xunlei.common.new_ptl.member.task.helpertask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.WebView;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.downloadprovider.web.base.core.BaseJsInterface;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserThirdLoginBindMobileTask */
public final class b extends UserAqWebViewTask {
    private String d;
    private a e;

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        return false;
    }

    protected final String o() {
        return this.e != null ? this.e.getThirdAppId() : "";
    }

    public b(p pVar) {
        super(pVar);
    }

    public final void b(String str) {
        this.d = str;
    }

    public final void a(a aVar) {
        this.e = aVar;
    }

    public final void a(@NonNull WebView webView) {
        this.b = BaseJsInterface.NAME;
        this.c = (WebView) new WeakReference(webView).get();
        if (this.c != null) {
            this.c.addJavascriptInterface(new UserAqWebViewTask$XLJSWebViewBridge(this), this.b);
        }
    }

    protected final String m() {
        return this.d;
    }

    protected final void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("recieve aqRecvOperationResult result = ");
        stringBuilder.append(str);
        XLLog.v("UserThirdLoginBindMobileTask", stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.getInt("roErrorCode");
            if (str == null) {
                a(0, XLErrorCode.getErrorDesc(0), "", jSONObject.getJSONObject("roData").toString());
                return;
            }
            a(str, "", "", "");
        } catch (String str2) {
            str2.printStackTrace();
            a(XLErrorCode.TUSER_BIND_MOBILE_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.TUSER_BIND_MOBILE_ERROR), "", "");
        }
    }

    protected final void f(final String str) {
        p.a().n().post(new Runnable(this) {
            private /* synthetic */ b b;

            public final void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    XLUserInfo i = this.b.d().i();
                    jSONObject.put(Constants.KEY_BUSINESSID, String.valueOf(this.b.d().d()));
                    jSONObject.put(Constants.KEY_PACKAGE_NAME, this.b.d().m());
                    jSONObject.put("deviceId", p.v());
                    jSONObject.put(Constants.KEY_SDK_VERSION, String.valueOf(this.b.d().f()));
                    long longValue = i.getLongValue(USERINFOKEY.UserID);
                    if (longValue == 0) {
                        longValue = this.b.n();
                    }
                    jSONObject.put(INoCaptchaComponent.sessionId, i.getStringValue(USERINFOKEY.SessionID));
                    jSONObject.put("userId", longValue);
                    String c = this.b.c(this.b.d().m());
                    jSONObject.put("appKey", c);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(this.b.d().d());
                    stringBuffer.append(this.b.d().m());
                    Object stringValue = i.getStringValue(USERINFOKEY.SessionID);
                    if (!TextUtils.isEmpty(stringValue)) {
                        stringBuffer.append(stringValue);
                    }
                    stringBuffer.append(String.valueOf(longValue));
                    stringBuffer.append(c);
                    stringBuffer.append(String.valueOf(this.b.d().f()));
                    stringBuffer.append("0oZm8m0ECKT^Be%C");
                    String a = this.b.getClass().getSimpleName();
                    StringBuilder stringBuilder = new StringBuilder("get signature data = ");
                    stringBuilder.append(stringBuffer.toString());
                    XLLog.v(a, stringBuilder.toString());
                    jSONObject.put("signature", MD5.encrypt(stringBuffer.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.b.a(str, jSONObject.toString());
            }
        });
    }

    private void a(int i, String str, String str2, String str3) {
        if (this.e != null) {
            this.e.onThirdLoginBindMobile(i, str, str2, str3, g());
        }
    }
}
