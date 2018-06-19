package com.sina.weibo.sdk;

import android.content.pm.Signature;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.MD5;

public class ApiUtils {
    public static final int BUILD_INT = 10350;
    public static final int BUILD_INT_440 = 10355;
    public static final int BUILD_INT_VER_2_2 = 10351;
    public static final int BUILD_INT_VER_2_3 = 10352;
    public static final int BUILD_INT_VER_2_5 = 10353;
    public static final int STORY_INT_VER = 10772;
    private static final String TAG = "com.sina.weibo.sdk.ApiUtils";

    public static boolean validateWeiboSign(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x001b }
        r0 = 64;	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r2.getPackageInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x001b }
        r2 = r2.signatures;
        r3 = "18da2bf10352443a00a5e046d9fca6bd";
        r2 = containSign(r2, r3);
        return r2;
    L_0x001b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.ApiUtils.validateWeiboSign(android.content.Context, java.lang.String):boolean");
    }

    private static boolean containSign(Signature[] signatureArr, String str) {
        if (signatureArr != null) {
            if (str != null) {
                for (Signature toByteArray : signatureArr) {
                    if (str.equals(MD5.hexdigest(toByteArray.toByteArray()))) {
                        LogUtil.d(TAG, "check pass");
                        return 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
