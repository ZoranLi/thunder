package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class aa {
    private static File a;

    public static long a() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
    }

    @TargetApi(9)
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (a != null) {
            return true;
        }
        try {
            if (!context.getApplicationInfo().processName.contains("com.tencent.mm")) {
                return false;
            }
            File dir = context.getDir("tbs", 0);
            if (dir == null || !dir.isDirectory()) {
                return false;
            }
            File file = new File(dir, "share");
            if (!file.isDirectory() && !file.mkdir()) {
                return false;
            }
            a = file;
            file.setExecutable(true, false);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
