package com.baidu.android.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.common.security.MD5Util;

public final class Util {
    private Util() {
    }

    public static boolean hasOtherServiceRuninMyPid(Context context, String str) {
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningServices(100)) {
            if (runningServiceInfo.pid == Process.myPid() && !TextUtils.equals(runningServiceInfo.service.getClassName(), str)) {
                return true;
            }
        }
        return false;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        return MD5Util.toHexString(bArr, str, z);
    }

    public static String toMd5(byte[] bArr, boolean z) {
        return MD5Util.toMd5(bArr, z);
    }
}
