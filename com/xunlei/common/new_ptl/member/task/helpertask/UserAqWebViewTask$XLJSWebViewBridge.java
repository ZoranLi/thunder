package com.xunlei.common.new_ptl.member.task.helpertask;

import android.webkit.JavascriptInterface;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.downloadprovider.web.base.core.BaseJsInterface;

public class UserAqWebViewTask$XLJSWebViewBridge {
    private static final String JS_METHOD_AQRECVOPERATIONRESULT = "aqRecvOperationResult";
    private static final String JS_METHOD_AQSENDUSERDEVICEINFO = "aqSendUserDeviceInfo";
    private static final String JS_METHOD_NATIVEGETUSERDEVICEINFO = "nativeGetUserDeviceInfo";
    final /* synthetic */ UserAqWebViewTask this$0;

    public UserAqWebViewTask$XLJSWebViewBridge(UserAqWebViewTask userAqWebViewTask) {
        this.this$0 = userAqWebViewTask;
    }

    @JavascriptInterface
    public void sendMessage(String str, String str2, String str3) {
        String str4 = BaseJsInterface.NAME;
        StringBuilder stringBuilder = new StringBuilder("sendMessage method = ");
        stringBuilder.append(str);
        stringBuilder.append(" ;callback = ");
        stringBuilder.append(str3);
        XLLog.v(str4, stringBuilder.toString());
        if (JS_METHOD_AQSENDUSERDEVICEINFO.equals(str)) {
            this.this$0.f(str3);
        } else if (JS_METHOD_AQRECVOPERATIONRESULT.equals(str)) {
            this.this$0.a(str2);
        } else if (JS_METHOD_NATIVEGETUSERDEVICEINFO.equals(str)) {
            p.a().n().post(new UserAqWebViewTask$2(this.this$0, str3));
        } else {
            UserAqWebViewTask.a(this.this$0, str, str2, str3);
        }
    }
}
