package com.xunlei.common.new_ptl.member.task.aq;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask;
import com.xunlei.common.new_ptl.member.task.helpertask.UserAqWebViewTask.XLJSWebViewBridge;
import com.xunlei.downloadprovider.web.base.core.BaseJsInterface;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: UserAqBindMobileWebTask */
public final class b extends UserAqWebViewTask {
    private static final String d = "bind_mobile";
    private static final String e = "https://aq.xunlei.com/wap/account_check.html";

    protected final String m() {
        return e;
    }

    public b(p pVar) {
        super(pVar);
    }

    public final void a(@NonNull WebView webView) {
        this.b = BaseJsInterface.NAME;
        this.c = (WebView) new WeakReference(webView).get();
        if (this.c != null) {
            this.c.addJavascriptInterface(new XLJSWebViewBridge(this), this.b);
        }
    }

    protected final void a(String str) {
        String str2 = this.a;
        StringBuilder stringBuilder = new StringBuilder("recieve aqRecvOperationResult result = ");
        stringBuilder.append(str);
        XLLog.v(str2, stringBuilder.toString());
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.optString("roCommand");
            int optInt = jSONObject.optInt("roErrorCode");
            jSONObject.optString("roErrorDesc");
            jSONObject.optString("roData");
            if (d.equals(str) != null) {
                if (optInt == 0) {
                    f(null);
                } else if (optInt == SecExceptionCode.SEC_ERROE_OPENSDK_DECODE_FAILED) {
                    f(XLErrorCode.AQ_MOBILE_FORMAT_ERROR);
                } else if (optInt == SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION) {
                    f(XLErrorCode.AQ_MOBILE_ERROR);
                } else if (optInt == 3003) {
                    f(XLErrorCode.AQ_USER_SEND_MSG_LIMIT_ERROR);
                } else if (optInt == 3005) {
                    f(XLErrorCode.AQ_USER_SEND_MSG_ERROR);
                } else if (optInt == 3009) {
                    f(XLErrorCode.AQ_USER_VERIFY_CODE_ERROR);
                } else if (optInt == 6002) {
                    f(XLErrorCode.AQ_BINDED_MOBILE_ERROR);
                } else if (optInt == 6004) {
                    f(XLErrorCode.AQ_HAD_MOBILE_ERROR);
                } else {
                    f(XLErrorCode.AQ_BIND_MOBILE_ERROR);
                }
            }
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    private void a(String str, int i) {
        if (d.equals(str) != null) {
            if (i == 0) {
                f(null);
            } else if (i == SecExceptionCode.SEC_ERROE_OPENSDK_DECODE_FAILED) {
                f(XLErrorCode.AQ_MOBILE_FORMAT_ERROR);
            } else if (i == SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION) {
                f(XLErrorCode.AQ_MOBILE_ERROR);
            } else if (i == 3003) {
                f(XLErrorCode.AQ_USER_SEND_MSG_LIMIT_ERROR);
            } else if (i == 3005) {
                f(XLErrorCode.AQ_USER_SEND_MSG_ERROR);
            } else if (i == 3009) {
                f(XLErrorCode.AQ_USER_VERIFY_CODE_ERROR);
            } else if (i == 6002) {
                f(XLErrorCode.AQ_BINDED_MOBILE_ERROR);
            } else if (i == 6004) {
                f(XLErrorCode.AQ_HAD_MOBILE_ERROR);
            } else {
                f(XLErrorCode.AQ_BIND_MOBILE_ERROR);
            }
        }
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserAqBindMobile(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
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
