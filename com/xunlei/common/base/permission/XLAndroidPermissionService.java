package com.xunlei.common.base.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import com.xunlei.common.base.XLLog;

public class XLAndroidPermissionService {
    private static final String TAG = "AcpService";

    int checkSelfPermission(Context context, String str) {
        try {
            int i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
            if (VERSION.SDK_INT >= 23) {
                if (i < 23) {
                    return PermissionChecker.checkSelfPermission(context, str);
                }
                XLLog.i(TAG, "targetSdkVersion >= Build.VERSION_CODES.M");
                return ContextCompat.checkSelfPermission(context, str);
            }
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return ContextCompat.checkSelfPermission(context, str);
    }

    void requestPermissions(Activity activity, String[] strArr, int i) {
        ActivityCompat.requestPermissions(activity, strArr, i);
    }

    boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        activity = ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
        str = TAG;
        StringBuilder stringBuilder = new StringBuilder("shouldShowRational = ");
        stringBuilder.append(activity);
        XLLog.i(str, stringBuilder.toString());
        return activity;
    }
}
