package com.qihoo360.replugin.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import java.util.List;

/* compiled from: AMSUtils */
public final class a {
    public static List<RunningAppProcessInfo> a(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }
}
