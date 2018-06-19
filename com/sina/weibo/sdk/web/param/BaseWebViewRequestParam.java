package com.sina.weibo.sdk.web.param;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.web.BaseWebViewRequestData;
import com.sina.weibo.sdk.web.WebRequestType;

public abstract class BaseWebViewRequestParam {
    private BaseWebViewRequestData baseData;
    protected Context context;
    private String transaction;

    public interface ExtraTaskCallback {
        void onComplete(String str);

        void onException(String str);
    }

    protected abstract void childFillBundle(Bundle bundle);

    public void doExtraTask(ExtraTaskCallback extraTaskCallback) {
    }

    public abstract String getRequestUrl();

    public boolean hasExtraTask() {
        return false;
    }

    protected abstract void transformChildBundle(Bundle bundle);

    public abstract void updateRequestUrl(String str);

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, String str2, String str3, Context context) {
        this(authInfo, webRequestType, str, 0, str2, str3, context);
    }

    public BaseWebViewRequestParam(AuthInfo authInfo, WebRequestType webRequestType, String str, int i, String str2, String str3, Context context) {
        this.baseData = new BaseWebViewRequestData(authInfo, webRequestType, str, i, str2, str3);
        this.context = context;
        this.transaction = String.valueOf(System.currentTimeMillis());
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public Bundle fillBundle(Bundle bundle) {
        if (this.baseData == null) {
            throw new NullPointerException("构造方法错误，请使用全参数的构造方法构建");
        }
        bundle.putSerializable("base", this.baseData);
        switch (this.baseData.getType()) {
            case DEFAULT:
                bundle.putInt("type", 0);
                break;
            case SHARE:
                bundle.putInt("type", 1);
                break;
            case AUTH:
                bundle.putInt("type", 2);
                break;
            default:
                break;
        }
        bundle.putString(WBConstants.TRAN, this.transaction);
        childFillBundle(bundle);
        return bundle;
    }

    public void transformBundle(Bundle bundle) {
        this.baseData = (BaseWebViewRequestData) bundle.getSerializable("base");
        this.transaction = bundle.getString(WBConstants.TRAN);
        transformChildBundle(bundle);
    }

    public BaseWebViewRequestData getBaseData() {
        return this.baseData;
    }
}
