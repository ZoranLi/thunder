package com.xunlei.common.new_ptl.member.task.aq;

import android.webkit.JavascriptInterface;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import org.json.JSONException;
import org.json.JSONObject;

class UserAqModifyPassWordTask$XLModifyPassWordJSInterface {
    private String mJsCallBack;
    final /* synthetic */ UserAqModifyPassWordTask this$0;

    @JavascriptInterface
    public int aqTriggerReport(String str) {
        return 0;
    }

    private UserAqModifyPassWordTask$XLModifyPassWordJSInterface(UserAqModifyPassWordTask userAqModifyPassWordTask) {
        this.this$0 = userAqModifyPassWordTask;
        this.mJsCallBack = "";
    }

    @JavascriptInterface
    public int aqSendUserDeviceInfo(String str) {
        StringBuilder stringBuilder = new StringBuilder("recieve aqSendUserDeviceInfo callback = ");
        stringBuilder.append(str);
        XLLog.v("XLModifyPassWordJSInterface", stringBuilder.toString());
        this.mJsCallBack = str;
        p.a().n().post(new Runnable(this) {
            private /* synthetic */ UserAqModifyPassWordTask$XLModifyPassWordJSInterface a;

            {
                this.a = r1;
            }

            public final void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    XLUserInfo i = p.a().i();
                    jSONObject.put(Constants.KEY_BUSINESSID, String.valueOf(p.a().d()));
                    jSONObject.put(Constants.KEY_PACKAGE_NAME, p.a().m());
                    p.a();
                    jSONObject.put("deviceId", p.v());
                    jSONObject.put(Constants.KEY_SDK_VERSION, p.a().c());
                    jSONObject.put(INoCaptchaComponent.sessionId, i.getStringValue(USERINFOKEY.SessionID));
                    jSONObject.put("userId", String.valueOf(i.getLongValue(USERINFOKEY.UserID)));
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(p.a().d());
                    stringBuffer.append(p.a().m());
                    p.a();
                    stringBuffer.append(p.v());
                    stringBuffer.append(i.getStringValue(USERINFOKEY.SessionID));
                    stringBuffer.append(String.valueOf(i.getLongValue(USERINFOKEY.UserID)));
                    stringBuffer.append(UserAqModifyPassWordTask.a(this.a.this$0, p.a().m()));
                    stringBuffer.append(p.a().c());
                    stringBuffer.append("0oZm8m0ECKT^Be%C");
                    jSONObject.put("signature", MD5.encrypt(stringBuffer.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                this.a.aqCallJSFunction(jSONObject.toString());
            }
        });
        return null;
    }

    @JavascriptInterface
    public int aqRecvOperationResult(String str) {
        StringBuilder stringBuilder = new StringBuilder("recieve aqRecvOperationResult result = ");
        stringBuilder.append(str);
        XLLog.v("XLModifyPassWordJSInterface", stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("roErrorCode") == null) {
                UserAqModifyPassWordTask.a(this.this$0, 0, XLErrorCode.getErrorDesc(0), jSONObject.getJSONObject("roData").getString("loginKey"));
            } else {
                UserAqModifyPassWordTask.a(this.this$0, XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR), "");
            }
        } catch (String str2) {
            str2.printStackTrace();
            UserAqModifyPassWordTask.a(this.this$0, XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR), "");
        }
        return 0;
    }

    void aqCallJSFunction(String str) {
        UserAqModifyPassWordTask.a(this.this$0, this.mJsCallBack, str);
    }
}
