package com.qihoo360.mobilesafe.api;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.replugin.a.a;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.g;
import java.util.List;

public final class IPC {
    public static final int getUIProcessPID(Context context) {
        return getRunningProcessPID(context, context.getApplicationInfo().packageName);
    }

    public static final int getRunningProcessPID(Context context, String str) {
        Context<RunningAppProcessInfo> a = a.a(context);
        if (a != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : a) {
                if (TextUtils.equals(runningAppProcessInfo.processName, str)) {
                    return runningAppProcessInfo.pid;
                }
            }
        }
        return null;
    }

    public static final boolean isRunningProcess(String str) {
        List<RunningAppProcessInfo> a = a.a(g.a());
        if (a != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : a) {
                if (TextUtils.equals(runningAppProcessInfo.processName, str)) {
                    return true;
                }
            }
        }
        return null;
    }

    public static final void sendLocalBroadcast2Process(Context context, String str, Intent intent) {
        b.b(str, intent);
    }

    public static final void sendLocalBroadcast2Plugin(Context context, String str, Intent intent) {
        b.a(str, intent);
    }

    public static final void sendLocalBroadcast2All(Context context, Intent intent) {
        b.a(intent);
    }

    public static final String getCurrentProcessName() {
        return b.a;
    }

    public static final boolean isPersistentProcess() {
        return b.e;
    }

    public static final boolean isUIProcess() {
        return b.f;
    }
}
