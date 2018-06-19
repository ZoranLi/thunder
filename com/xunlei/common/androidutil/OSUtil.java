package com.xunlei.common.androidutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.os.Process;
import com.qq.e.comm.constants.Constants.KEYS;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.IOException;
import java.util.Scanner;

public class OSUtil {
    public static String getCurProcessName(Context context) {
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (!(runningAppProcesses == null || runningAppProcesses.isEmpty())) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static String getProcessNameByCommand() {
        String str = null;
        try {
            int myPid = Process.myPid();
            Scanner scanner = new Scanner(Runtime.getRuntime().exec(KEYS.PLACEMENTS).getInputStream());
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                if (nextLine.contains(String.valueOf(myPid))) {
                    int lastIndexOf = nextLine.lastIndexOf(BrothersApplication.COM_XUNLEI_DOWNLOADPROVIDER);
                    if (lastIndexOf > 0) {
                        str = nextLine.substring(lastIndexOf);
                        break;
                    }
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean isMainProcess(String str, Context context) {
        if (str != null) {
            if (context != null) {
                return str.equals(getCurProcessName(context));
            }
        }
        return null;
    }

    public static boolean isAppRunning(Context context, String str) {
        Context<RunningTaskInfo> runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(100);
        if (runningTasks.size() <= 0) {
            return false;
        }
        for (RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo.baseActivity.getPackageName().equals(str)) {
                return true;
            }
        }
        return false;
    }
}
