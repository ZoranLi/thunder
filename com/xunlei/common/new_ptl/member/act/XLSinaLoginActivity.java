package com.xunlei.common.new_ptl.member.act;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.WbConnectErrorMessage;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;

public class XLSinaLoginActivity extends Activity {
    public static final String REDIRECT_URL = "http://www.xunlei.com";
    public static final String SCOPE = null;
    private Oauth2AccessToken mAccessToken = null;
    private AuthInfo mAuthInfo = null;
    protected Handler mHandler = new Handler();
    private String mSinaAppId = "";
    private String mSinaAppRedirectUrl = REDIRECT_URL;
    private SsoHandler mSsoHandler = null;
    private int mTaskId = 0;

    public class AuthListener implements WbAuthListener {
        private XLSinaLoginActivity mLoginHost = null;

        public AuthListener(XLSinaLoginActivity xLSinaLoginActivity) {
            this.mLoginHost = xLSinaLoginActivity;
        }

        public void onSuccess(Oauth2AccessToken oauth2AccessToken) {
            StringBuilder stringBuilder = new StringBuilder("onSuccess sina sdk to auth value = ");
            stringBuilder.append(oauth2AccessToken.toString());
            XLLog.v("XLSinaLoginActivity", stringBuilder.toString());
            XLSinaLoginActivity.this.mAccessToken = oauth2AccessToken;
            if (XLSinaLoginActivity.this.mAccessToken.isSessionValid() != null) {
                XLLog.v("XLSinaLoginActivity", "recall sina sdk valid.");
                this.mLoginHost.acceptSianOauthToken(0, XLSinaLoginActivity.this.mAccessToken.getUid(), XLSinaLoginActivity.this.mAccessToken.getToken(), XLSinaLoginActivity.this.mAccessToken.getRefreshToken(), String.valueOf(XLSinaLoginActivity.this.mAccessToken.getExpiresTime()));
                return;
            }
            XLLog.v("XLSinaLoginActivity", "recall sina sdk invalid.");
            this.mLoginHost.acceptSianOauthToken(XLErrorCode.AUTH_USER_ERROR, null, null, null, null);
        }

        public void cancel() {
            this.mLoginHost.acceptSianOauthToken(XLErrorCode.AUTH_USER_CANCLE, null, null, null, null);
        }

        public void onFailure(WbConnectErrorMessage wbConnectErrorMessage) {
            StringBuilder stringBuilder = new StringBuilder("recall sina sdk error = ");
            stringBuilder.append(wbConnectErrorMessage.getErrorMessage());
            XLLog.v("XLSinaLoginActivity", stringBuilder.toString());
            this.mLoginHost.acceptSianOauthToken(XLErrorCode.AUTH_USER_ERROR, null, null, null, null);
        }
    }

    public void acceptSianOauthToken(int i, String str, String str2, String str3, String str4) {
        a a = p.a().a(this.mTaskId);
        if (a != null) {
            a.a(i, str, str2, str3, str4);
        }
        finish();
        XLLog.v("XLSinaLoginActivity", "finish XLSinaLoginActivity");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mTaskId = getIntent().getIntExtra("sina_task", 0);
        this.mSinaAppId = getIntent().getStringExtra("sina_app_id");
        bundle = getIntent().getStringExtra("sina_app_redirect");
        if (!TextUtils.isEmpty(bundle)) {
            this.mSinaAppRedirectUrl = bundle;
        }
        this.mAuthInfo = new AuthInfo(this, this.mSinaAppId, this.mSinaAppRedirectUrl, SCOPE);
        WbSdk.install(this, this.mAuthInfo);
        this.mSsoHandler = new SsoHandler(this);
        XLLog.v("XLSinaLoginActivity", "call sina sdk to auth.");
        this.mSsoHandler.authorize(new AuthListener(this));
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mSsoHandler != null) {
            this.mSsoHandler.authorizeCallBack(i, i2, intent);
        }
    }
}
