package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAppInfo;
import java.util.List;

public class WeiboAppManager {
    private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
    private static final String TAG = "com.sina.weibo.sdk.WeiboAppManager";
    public static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
    private static WeiboAppManager sInstance;
    private Context mContext;
    private WbAppInfo wbAppInfo;

    private WeiboAppManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized WeiboAppManager getInstance(Context context) {
        synchronized (WeiboAppManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboAppManager(context);
            }
            context = sInstance;
        }
        return context;
    }

    public synchronized WbAppInfo getWbAppInfo() {
        if (this.wbAppInfo == null) {
            this.wbAppInfo = queryWbInfoInternal(this.mContext);
        }
        return this.wbAppInfo;
    }

    public static WbAppInfo queryWbInfoInternal(Context context) {
        context = queryWbInfoByAsset(context);
        return (context != null ? 1 : null) != null ? context : null;
    }

    @Deprecated
    public boolean hasWbInstall() {
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices != null) {
            if (!queryIntentServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static WbAppInfo queryWbInfoByAsset(Context context) {
        Intent intent = new Intent(WEIBO_IDENTITY_ACTION);
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        WbAppInfo wbAppInfo = null;
        if (queryIntentServices != null) {
            if (!queryIntentServices.isEmpty()) {
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.packageName))) {
                        WbAppInfo parseWbInfoByAsset = parseWbInfoByAsset(context, resolveInfo.serviceInfo.packageName);
                        if (parseWbInfoByAsset != null) {
                            wbAppInfo = parseWbInfoByAsset;
                        }
                    }
                }
                return wbAppInfo;
            }
        }
        return null;
    }

    private static com.sina.weibo.sdk.auth.WbAppInfo parseWbInfoByAsset(android.content.Context r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r9);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = 2;
        r0 = r8.createPackageContext(r9, r0);	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r3 = new byte[r2];	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r0 = r0.getAssets();	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r4 = "weibo_for_sdk.json";	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r0 = r0.open(r4);	 Catch:{ Exception -> 0x006e, all -> 0x006b }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0069 }
        r4.<init>();	 Catch:{ Exception -> 0x0069 }
    L_0x0020:
        r5 = 0;	 Catch:{ Exception -> 0x0069 }
        r6 = r0.read(r3, r5, r2);	 Catch:{ Exception -> 0x0069 }
        r7 = -1;	 Catch:{ Exception -> 0x0069 }
        if (r6 == r7) goto L_0x0031;	 Catch:{ Exception -> 0x0069 }
    L_0x0028:
        r7 = new java.lang.String;	 Catch:{ Exception -> 0x0069 }
        r7.<init>(r3, r5, r6);	 Catch:{ Exception -> 0x0069 }
        r4.append(r7);	 Catch:{ Exception -> 0x0069 }
        goto L_0x0020;	 Catch:{ Exception -> 0x0069 }
    L_0x0031:
        r2 = r4.toString();	 Catch:{ Exception -> 0x0069 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0069 }
        if (r2 != 0) goto L_0x003e;	 Catch:{ Exception -> 0x0069 }
    L_0x003b:
        com.sina.weibo.sdk.ApiUtils.validateWeiboSign(r8, r9);	 Catch:{ Exception -> 0x0069 }
    L_0x003e:
        r8 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0069 }
        r2 = r4.toString();	 Catch:{ Exception -> 0x0069 }
        r8.<init>(r2);	 Catch:{ Exception -> 0x0069 }
        r2 = "support_api";	 Catch:{ Exception -> 0x0069 }
        r2 = r8.optInt(r2, r7);	 Catch:{ Exception -> 0x0069 }
        r3 = new com.sina.weibo.sdk.auth.WbAppInfo;	 Catch:{ Exception -> 0x0069 }
        r3.<init>();	 Catch:{ Exception -> 0x0069 }
        r3.setPackageName(r9);	 Catch:{ Exception -> 0x0069 }
        r3.setSupportVersion(r2);	 Catch:{ Exception -> 0x0069 }
        r9 = "authActivityName";	 Catch:{ Exception -> 0x0069 }
        r2 = "com.sina.weibo.SSOActivity";	 Catch:{ Exception -> 0x0069 }
        r8 = r8.optString(r9, r2);	 Catch:{ Exception -> 0x0069 }
        r3.setAuthActivityName(r8);	 Catch:{ Exception -> 0x0069 }
        if (r0 == 0) goto L_0x0068;
    L_0x0065:
        r0.close();	 Catch:{ IOException -> 0x0068 }
    L_0x0068:
        return r3;
    L_0x0069:
        r8 = move-exception;
        goto L_0x0070;
    L_0x006b:
        r8 = move-exception;
        r0 = r1;
        goto L_0x0080;
    L_0x006e:
        r8 = move-exception;
        r0 = r1;
    L_0x0070:
        r9 = TAG;	 Catch:{ all -> 0x007f }
        r8 = r8.getMessage();	 Catch:{ all -> 0x007f }
        com.sina.weibo.sdk.utils.LogUtil.e(r9, r8);	 Catch:{ all -> 0x007f }
        if (r0 == 0) goto L_0x007e;
    L_0x007b:
        r0.close();	 Catch:{ IOException -> 0x007e }
    L_0x007e:
        return r1;
    L_0x007f:
        r8 = move-exception;
    L_0x0080:
        if (r0 == 0) goto L_0x0085;
    L_0x0082:
        r0.close();	 Catch:{ IOException -> 0x0085 }
    L_0x0085:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.WeiboAppManager.parseWbInfoByAsset(android.content.Context, java.lang.String):com.sina.weibo.sdk.auth.WbAppInfo");
    }
}
