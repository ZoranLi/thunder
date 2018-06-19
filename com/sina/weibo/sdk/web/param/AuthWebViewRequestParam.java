package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebRequestType;

public class AuthWebViewRequestParam extends BaseWebViewRequestParam {
    protected void childFillBundle(Bundle bundle) {
    }

    protected void transformChildBundle(Bundle bundle) {
    }

    public void updateRequestUrl(String str) {
    }

    public AuthWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        super(authInfo, webRequestType, str, str2, str3, context);
    }

    public boolean hasExtraTask() {
        return super.hasExtraTask();
    }

    public String getRequestUrl() {
        return getBaseData().getUrl();
    }
}
