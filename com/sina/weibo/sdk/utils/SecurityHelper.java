package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import com.sina.weibo.sdk.ApiUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import com.sina.weibo.sdk.constant.WBConstants;
import com.sina.weibo.sdk.constant.WBConstants.Base;

public class SecurityHelper {
    public static boolean validateAppSignatureForIntent(Context context, Intent intent) {
        context = context.getPackageManager();
        if (context == null) {
            return false;
        }
        intent = context.resolveActivity(intent, 0);
        if (intent == null) {
            return false;
        }
        try {
            return containSign(context.getPackageInfo(intent.activityInfo.packageName, 64).signatures, WBConstants.WEIBO_SIGN);
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        } catch (Context context22) {
            context22.printStackTrace();
            return false;
        }
    }

    public static boolean checkResponseAppLegal(Context context, WbAppInfo wbAppInfo, Intent intent) {
        if ((wbAppInfo != null && wbAppInfo.getSupportVersion() <= ApiUtils.BUILD_INT_VER_2_3) || wbAppInfo == null) {
            return true;
        }
        wbAppInfo = intent != null ? intent.getStringExtra(Base.APP_PKG) : null;
        if (!(wbAppInfo == null || intent.getStringExtra(WBConstants.TRAN) == null)) {
            if (ApiUtils.validateWeiboSign(context, wbAppInfo) != null) {
                return true;
            }
        }
        return null;
    }

    public static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr != null) {
            if (str != null) {
                for (Signature toByteArray : signatureArr) {
                    if (str.equals(MD5.hexdigest(toByteArray.toByteArray()))) {
                        return 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
