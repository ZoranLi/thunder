package com.xunlei.common.new_ptl.member.task.aq;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask$XLJSWebViewBridge;
import com.xunlei.downloadprovider.web.base.core.BaseJsInterface;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: UserAqLoginVerifyMobileTask */
public final class c extends UserAqWebViewTask {
    private com.xunlei.common.new_ptl.member.task.helpertask.c d;
    private String e;
    private long f;

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        return false;
    }

    public c(p pVar) {
        super(pVar);
    }

    public final void a(@NonNull WebView webView) {
        this.b = BaseJsInterface.NAME;
        this.c = (WebView) new WeakReference(webView).get();
        if (this.c != null) {
            this.c.addJavascriptInterface(new UserAqWebViewTask$XLJSWebViewBridge(this), this.b);
        }
    }

    public final long n() {
        return this.f;
    }

    protected final String m() {
        return this.e;
    }

    protected final void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("recieve aqRecvOperationResult result = ");
        stringBuilder.append(str);
        XLLog.v("UserAqLoginVerifyMobileTask", stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("roErrorCode") == null) {
                a(0, XLErrorCode.getErrorDesc(null), "", 0, jSONObject.getJSONObject("roData").getString("loginKey"));
                return;
            }
            a(XLErrorCode.AQ_USER_VERIFY_MOBILE_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_VERIFY_MOBILE_DATA_ERROR), null, 0, null);
        } catch (String str2) {
            str2.printStackTrace();
            a(XLErrorCode.AQ_USER_VERIFY_MOBILE_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_VERIFY_MOBILE_DATA_ERROR), null, 0, null);
        }
    }

    public final void a(com.xunlei.common.new_ptl.member.task.helpertask.c cVar) {
        this.d = cVar;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void b(long j) {
        this.f = j;
    }

    private void a(int i, String str, String str2, long j, String str3) {
        if (this.d != null) {
            this.d.onUserVerifyMobileCallBack(i, str, str2, 0, str3, f(), g());
        }
    }
}
