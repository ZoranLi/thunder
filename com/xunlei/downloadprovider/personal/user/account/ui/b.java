package com.xunlei.downloadprovider.personal.user.account.ui;

import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.a.f.a;
import com.xunlei.downloadprovider.web.base.core.MethodName;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.xllib.b.g;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UserAccountBindMobileActivity */
final class b extends ag {
    final /* synthetic */ UserAccountBindMobileActivity a;

    b(UserAccountBindMobileActivity userAccountBindMobileActivity) {
        this.a = userAccountBindMobileActivity;
    }

    protected final boolean a(MethodName methodName, JSONObject jSONObject, String str) throws JSONException {
        switch (c.a[methodName.ordinal()]) {
            case 1:
                methodName = new HashMap();
                jSONObject = BrothersApplication.getApplicationInstance().getPackageName();
                String hubbleDeviceGUID = AndroidConfig.getHubbleDeviceGUID();
                String c = LoginHelper.a().c();
                long c2 = LoginHelper.a().g.c();
                String version = XLUserUtil.getInstance().getVersion();
                String a = a.a(this.a);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(40);
                stringBuilder.append(jSONObject);
                stringBuilder.append(c);
                stringBuilder.append(c2);
                stringBuilder.append(a);
                stringBuilder.append(version);
                stringBuilder.append("0oZm8m0ECKT^Be%C");
                a = g.a(stringBuilder.toString().getBytes());
                methodName.put(Constants.KEY_BUSINESSID, Integer.valueOf(40));
                methodName.put(Constants.KEY_PACKAGE_NAME, jSONObject);
                methodName.put("deviceId", hubbleDeviceGUID);
                methodName.put(INoCaptchaComponent.sessionId, c);
                methodName.put("userId", Long.valueOf(c2));
                methodName.put("appKey", "34a062aaa22f906fca4fefe9fb3a3021");
                methodName.put(Constants.KEY_SDK_VERSION, version);
                methodName.put("signature", a);
                a(str, methodName);
                return true;
            case 2:
                new StringBuilder("aqRecvOperationResult() params=").append(jSONObject.toString());
                methodName = jSONObject.optString("roCommand");
                int optInt = jSONObject.optInt("roErrorCode");
                String optString = jSONObject.optString("roErrorDesc");
                if (methodName.equals("bind_mobile") != null) {
                    UserAccountBindMobileActivity.a(this.a, optInt, optString);
                }
                return true;
            default:
                return null;
        }
    }
}
