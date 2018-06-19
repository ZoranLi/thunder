package com.xunlei.common.new_ptl.member.task.helpertask;

import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.device.XLDeviceGen;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.g;
import com.xunlei.common.new_ptl.member.a.p;
import org.json.JSONException;
import org.json.JSONObject;

final class UserAqWebViewTask$2 implements Runnable {
    private /* synthetic */ String a;
    private /* synthetic */ UserAqWebViewTask b;

    UserAqWebViewTask$2(UserAqWebViewTask userAqWebViewTask, String str) {
        this.b = userAqWebViewTask;
        this.a = str;
    }

    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            XLUserInfo i = p.a().i();
            jSONObject.put(DispatchConstants.PLATFORM_VERSION, UserAqWebViewTask.a(this.b, 10));
            jSONObject.put("protocolVersion", UserAqWebViewTask.b(this.b, 203));
            jSONObject.put("deviceModel", g.b());
            jSONObject.put("deviceName", g.c());
            jSONObject.put("OSVersion", VERSION.RELEASE);
            jSONObject.put("devicesign", XLDeviceGen.getInstance().getDeviceIdSign());
            jSONObject.put("netWorkType", this.b.d().C());
            jSONObject.put("providerName", this.b.d().D());
            jSONObject.put("appid", UserAqWebViewTask.c(this.b, this.b.d().d()));
            StringBuilder stringBuilder = new StringBuilder("ANDROID-");
            stringBuilder.append(this.b.d().m());
            jSONObject.put("appName", stringBuilder.toString());
            jSONObject.put("clientVersion", this.b.d().e());
            jSONObject.put(Constants.KEY_SDK_VERSION, UserAqWebViewTask.d(this.b, this.b.d().f()));
            jSONObject.put("thirdAppid", this.b.o());
            long longValue = i.getLongValue(USERINFOKEY.UserID);
            if (longValue == 0) {
                longValue = this.b.n();
            }
            jSONObject.put("session", i.getStringValue(USERINFOKEY.SessionID));
            jSONObject.put("userid", longValue);
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
            stringBuffer.append(UserAqWebViewTask.e(this.b, this.b.d().f()));
            stringBuffer.append("0oZm8m0ECKT^Be%C");
            String a = UserAqWebViewTask.a(this.b);
            StringBuilder stringBuilder2 = new StringBuilder("get signature data = ");
            stringBuilder2.append(stringBuffer.toString());
            XLLog.v(a, stringBuilder2.toString());
            jSONObject.put("signature", MD5.encrypt(stringBuffer.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.b.a(this.a, jSONObject.toString());
    }
}
