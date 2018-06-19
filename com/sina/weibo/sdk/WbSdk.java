package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.utils.AidTask;

public class WbSdk {
    private static AuthInfo authInfo = null;
    private static boolean init = false;

    public static void install(Context context, AuthInfo authInfo) {
        if (!init) {
            if (!(authInfo == null || TextUtils.isEmpty(authInfo.getAppKey()))) {
                if (!TextUtils.isEmpty(authInfo.getRedirectUrl())) {
                    authInfo = authInfo;
                    AidTask.getInstance(context).aidTaskInit(authInfo.getAppKey());
                    init = true;
                    return;
                }
            }
            throw new RuntimeException("please set right app info (appKey,redirect");
        }
    }

    public static void checkInit() {
        if (!init) {
            throw new RuntimeException("weibo sdk was not initall! please use: WbSdk.install() in your app Application or your main Activity. when you want to use weibo sdk function, make sure call WbSdk.install() before this function");
        }
    }

    public static AuthInfo getAuthInfo() {
        checkInit();
        return authInfo;
    }

    public static boolean isWbInstall(Context context) {
        Intent intent = new Intent(WeiboAppManager.WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        context = context.getPackageManager().queryIntentServices(intent, 0);
        if (context != null) {
            if (context.isEmpty() == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean supportMultiImage(Context context) {
        if (!isWbInstall(context)) {
            return false;
        }
        context = WeiboAppManager.getInstance(context).getWbAppInfo();
        if (context == null || context.getSupportVersion() < 10772) {
            return false;
        }
        return true;
    }
}
