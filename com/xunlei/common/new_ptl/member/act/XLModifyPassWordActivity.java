package com.xunlei.common.new_ptl.member.act;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.aq.UserAqModifyPassWordTask;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
public class XLModifyPassWordActivity extends Activity {
    private static String MODIFY_PASS_WORD_BASE_URL = "https://login.xunlei.com/jump/?jump_key=%s&u1=%s&v=100&business_type=%d";
    private static String MODIFY_PASS_WORD_URL = "http://aq.xunlei.com/wap/changePwd.html";
    public static final String XL_JS_PREFIX = "javascript:";
    private static final int XL_MP_BT = 115;
    private String TAG = XLModifyPassWordActivity.class.getSimpleName();
    private XLModifyPassWordJSInterface mJsInterface = null;
    private int mTaskId = 0;
    protected WebView mWebView = null;

    public class XLModifyPassWordJSInterface {
        private String mJsCallBack = "";

        @JavascriptInterface
        public int aqTriggerReport(String str) {
            return 0;
        }

        @JavascriptInterface
        public int aqSendUserDeviceInfo(String str) {
            StringBuilder stringBuilder = new StringBuilder("recieve aqSendUserDeviceInfo callback = ");
            stringBuilder.append(str);
            XLLog.v("XLModifyPassWordJSInterface", stringBuilder.toString());
            this.mJsCallBack = str;
            p.a().n().post(new Runnable() {
                public void run() {
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
                        stringBuffer.append(XLModifyPassWordActivity.this.getSignMD5Value(p.a().m()));
                        stringBuffer.append(p.a().c());
                        stringBuffer.append("0oZm8m0ECKT^Be%C");
                        jSONObject.put("signature", MD5.encrypt(stringBuffer.toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    XLModifyPassWordJSInterface.this.aqCallJSFunction(jSONObject.toString());
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
                    XLModifyPassWordActivity.this.sendModifyResult(0, XLErrorCode.getErrorDesc(0), jSONObject.getJSONObject("roData").getString("loginKey"));
                } else {
                    XLModifyPassWordActivity.this.sendModifyResult(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR), "");
                }
            } catch (String str2) {
                str2.printStackTrace();
                XLModifyPassWordActivity.this.sendModifyResult(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_MODIFY_WEB_DATA_ERROR), "");
            }
            XLModifyPassWordActivity.this.finish();
            return 0;
        }

        int aqCallJSFunction(String str) {
            return XLModifyPassWordActivity.this.javaCallBackToJS(this.mJsCallBack, str);
        }
    }

    final class XLWebChromeClient extends WebChromeClient {
        XLWebChromeClient() {
        }

        public final boolean onJsAlert(WebView webView, String str, String str2, final JsResult jsResult) {
            new Builder(XLModifyPassWordActivity.this).setTitle("来自网页的提示").setMessage(str2.toString()).setPositiveButton(17039370, new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    jsResult.confirm();
                }
            }).setCancelable(null).create().show();
            return true;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        XLLog.v(this.TAG, "onCreate");
        this.mTaskId = getIntent().getIntExtra("XL_MODIFY_TASK_ID", 0);
        if (this.mTaskId == null) {
            finish();
            return;
        }
        this.mWebView = new WebView(this);
        setContentView(this.mWebView);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.setWebChromeClient(new XLWebChromeClient());
        this.mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                webView.loadUrl(str);
                return true;
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }
        });
        CookieSyncManager.createInstance(getApplicationContext());
        CookieManager.getInstance().removeAllCookie();
        this.mJsInterface = new XLModifyPassWordJSInterface();
        this.mWebView.addJavascriptInterface(this.mJsInterface, "xlAQInstance");
        bundle = p.a().i();
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("user id = ");
        stringBuilder.append(bundle.getLongValue(USERINFOKEY.UserID));
        stringBuilder.append("# jumpkey = ");
        stringBuilder.append(bundle.getJumpKey(115));
        XLLog.v(str, stringBuilder.toString());
        bundle = String.format(MODIFY_PASS_WORD_BASE_URL, new Object[]{bundle.getJumpKey(115), URLCoder.encode(MODIFY_PASS_WORD_URL, "UTF-8"), Integer.valueOf(p.a().d())});
        String str2 = this.TAG;
        StringBuilder stringBuilder2 = new StringBuilder("modify password url = ");
        stringBuilder2.append(bundle);
        XLLog.v(str2, stringBuilder2.toString());
        this.mWebView.loadUrl(bundle);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private String getSignMD5Value(String str) {
        try {
            return MD5.getMessageDigest(getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (String str2) {
            str2.printStackTrace();
            return "";
        }
    }

    private int javaCallBackToJS(String str, String str2) {
        final StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("javascript:");
        stringBuffer.append(str);
        stringBuffer.append("('");
        stringBuffer.append(str2);
        stringBuffer.append("')");
        str = this.TAG;
        str2 = new StringBuilder("call back to JS url = ");
        str2.append(stringBuffer.toString());
        XLLog.v(str, str2.toString());
        p.a().n().post(new Runnable() {
            public void run() {
                XLModifyPassWordActivity.this.mWebView.loadUrl(stringBuffer.toString());
            }
        });
        return null;
    }

    public void onBackPressed() {
        sendModifyResult(XLErrorCode.AQ_USER_CANCLE_MODIFY_ERROR, XLErrorCode.getErrorDesc(XLErrorCode.AQ_USER_CANCLE_MODIFY_ERROR), "");
        finish();
    }

    public void sendModifyResult(int i, String str, String str2) {
        UserAqModifyPassWordTask userAqModifyPassWordTask = (UserAqModifyPassWordTask) p.a().a(this.mTaskId);
        if (userAqModifyPassWordTask != null) {
            userAqModifyPassWordTask.b(i, str, str2);
        }
    }
}
