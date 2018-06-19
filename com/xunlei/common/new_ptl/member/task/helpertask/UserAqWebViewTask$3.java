package com.xunlei.common.new_ptl.member.task.helpertask;

import android.text.TextUtils;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import org.json.JSONException;
import org.json.JSONObject;

final class UserAqWebViewTask$3 implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ UserAqWebViewTask b;

    UserAqWebViewTask$3(UserAqWebViewTask userAqWebViewTask, String str) {
        this.b = userAqWebViewTask;
        this.a = str;
    }

    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            XLUserInfo i = p.a().i();
            jSONObject.put("appid", String.valueOf(p.a().d()));
            jSONObject.put(Constants.KEY_PACKAGE_NAME, p.a().m());
            p.a();
            jSONObject.put("deviceId", p.v());
            jSONObject.put(Constants.KEY_SDK_VERSION, p.a().c());
            long longValue = i.getLongValue(USERINFOKEY.UserID);
            if (longValue == 0) {
                longValue = this.b.n();
            }
            jSONObject.put(INoCaptchaComponent.sessionId, i.getStringValue(USERINFOKEY.SessionID));
            jSONObject.put("userId", longValue);
            String c = this.b.c(p.a().m());
            jSONObject.put("appKey", c);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(p.a().d());
            stringBuffer.append(p.a().m());
            Object stringValue = i.getStringValue(USERINFOKEY.SessionID);
            if (!TextUtils.isEmpty(stringValue)) {
                stringBuffer.append(stringValue);
            }
            stringBuffer.append(String.valueOf(longValue));
            stringBuffer.append(c);
            stringBuffer.append(p.a().c());
            stringBuffer.append("0oZm8m0ECKT^Be%C");
            String b = UserAqWebViewTask.b(this.b);
            StringBuilder stringBuilder = new StringBuilder("get signature data = ");
            stringBuilder.append(stringBuffer.toString());
            XLLog.v(b, stringBuilder.toString());
            jSONObject.put("signature", MD5.encrypt(stringBuffer.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.b.a(this.a, jSONObject.toString());
    }
}
