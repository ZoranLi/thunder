package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenKeeper;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;
import com.sina.weibo.sdk.constant.WBConstants.Msg;
import com.sina.weibo.sdk.constant.WBConstants.Response;
import com.sina.weibo.sdk.constant.WBConstants.SDK;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;
import com.sina.weibo.sdk.utils.Utility;
import com.sina.weibo.sdk.utils.WbSdkVersion;
import com.sina.weibo.sdk.web.WebRequestType;
import com.sina.weibo.sdk.web.param.ShareWebViewRequestParam;

public class WbShareHandler {
    private Activity context;
    private boolean hasRegister = false;
    private int progressColor = -1;
    private int progressId = -1;

    public boolean supportMulti() {
        return false;
    }

    public WbShareHandler(Activity activity) {
        this.context = activity;
    }

    public boolean registerApp() {
        sendBroadcast(this.context, WBConstants.ACTION_WEIBO_REGISTER, WbSdk.getAuthInfo().getAppKey(), null, null);
        this.hasRegister = true;
        return true;
    }

    private void sendBroadcast(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent(str);
        str = context.getPackageName();
        intent.putExtra(Base.SDK_VER, WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        intent.putExtra(Base.APP_PKG, str);
        intent.putExtra(Base.APP_KEY, str2);
        intent.putExtra(SDK.FLAG, WBConstants.WEIBO_FLAG_SDK);
        intent.putExtra(WBConstants.SIGN, MD5.hexdigest(Utility.getSign(context, str)));
        if (TextUtils.isEmpty(str3) == null) {
            intent.setPackage(str3);
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.sendBroadcast(intent, WBConstants.ACTION_WEIBO_SDK_PERMISSION);
    }

    public void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z) {
        if (!this.hasRegister) {
            throw new RuntimeException("please call WbShareHandler.registerApp(),before use share function");
        } else if (WbSdk.isWbInstall(this.context) || !z) {
            if (!z) {
                if (!WbSdk.isWbInstall(this.context)) {
                    startWebShare(weiboMultiMessage);
                    return;
                }
            }
            startClientShare(weiboMultiMessage);
        }
    }

    public void shareToStory(StoryMessage storyMessage) {
        Intent intent = new Intent();
        intent.putExtra(Msg.STORY, storyMessage);
        intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        intent.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
        intent.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
        intent.setClass(this.context, WbShareToStoryActivity.class);
        this.context.startActivity(intent);
    }

    private void startClientShare(WeiboMultiMessage weiboMultiMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(WBConstants.COMMAND_TYPE_KEY, 1);
        bundle.putString(WBConstants.TRAN, String.valueOf(System.currentTimeMillis()));
        bundle.putLong(WBConstants.SHARE_CALLBACK_ID, 0);
        bundle.putAll(weiboMultiMessage.toBundle(bundle));
        weiboMultiMessage = new Intent();
        weiboMultiMessage.setClass(this.context, WbShareTransActivity.class);
        weiboMultiMessage.putExtra(WBConstants.SHARE_START_PACKAGE, WeiboAppManager.getInstance(this.context).getWbAppInfo().getPackageName());
        weiboMultiMessage.putExtra(WBConstants.SHARE_START_ACTION, WBConstants.ACTIVITY_WEIBO);
        weiboMultiMessage.putExtra(WBConstants.SHARE_START_FLAG, 0);
        weiboMultiMessage.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        weiboMultiMessage.putExtra(WBConstants.TRANS_PROGRESS_COLOR, this.progressColor);
        weiboMultiMessage.putExtra(WBConstants.TRANS_PROGRESS_ID, this.progressId);
        weiboMultiMessage.putExtras(bundle);
        try {
            this.context.startActivity(weiboMultiMessage);
        } catch (WeiboMultiMessage weiboMultiMessage2) {
            LogUtil.v("weibo sdk error ", weiboMultiMessage2.toString());
        }
    }

    private void startWebShare(WeiboMultiMessage weiboMultiMessage) {
        Intent intent = new Intent(this.context, WbShareTransActivity.class);
        String packageName = this.context.getPackageName();
        ShareWebViewRequestParam shareWebViewRequestParam = new ShareWebViewRequestParam(WbSdk.getAuthInfo(), WebRequestType.SHARE, "", 1, "微博分享", null, this.context);
        shareWebViewRequestParam.setContext(this.context);
        shareWebViewRequestParam.setHashKey("");
        shareWebViewRequestParam.setPackageName(packageName);
        Oauth2AccessToken readAccessToken = AccessTokenKeeper.readAccessToken(this.context);
        if (!(readAccessToken == null || TextUtils.isEmpty(readAccessToken.getToken()))) {
            shareWebViewRequestParam.setToken(readAccessToken.getToken());
        }
        shareWebViewRequestParam.setMultiMessage(weiboMultiMessage);
        weiboMultiMessage = new Bundle();
        shareWebViewRequestParam.fillBundle(weiboMultiMessage);
        intent.putExtras(weiboMultiMessage);
        intent.putExtra(WBConstants.SHARE_START_FLAG, 0);
        intent.putExtra(WBConstants.SHARE_START_ACTIVITY, this.context.getClass().getName());
        intent.putExtra(WBConstants.SHARE_START_ACTION, WBConstants.ACTIVITY_WEIBO);
        intent.putExtra(WBConstants.SHARE_START_GOTO_ACTIVITY, "com.sina.weibo.sdk.web.WeiboSdkWebActivity");
        this.context.startActivity(intent);
    }

    @Deprecated
    public boolean isWbAppInstalled() {
        return WbSdk.isWbInstall(this.context);
    }

    public void doResultIntent(Intent intent, WbShareCallback wbShareCallback) {
        if (wbShareCallback != null) {
            intent = intent.getExtras();
            if (intent != null) {
                switch (intent.getInt(Response.ERRCODE, -1)) {
                    case null:
                        wbShareCallback.onWbShareSuccess();
                        return;
                    case 1:
                        wbShareCallback.onWbShareCancel();
                        return;
                    case 2:
                        wbShareCallback.onWbShareFail();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
    }

    public void setProgressId(int i) {
        this.progressId = i;
    }
}
