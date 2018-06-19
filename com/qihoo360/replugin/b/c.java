package com.qihoo360.replugin.b;

import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.util.Log;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;

/* compiled from: LogDebug */
public final class c {
    public static final boolean a;
    public static final boolean b;

    static {
        boolean z = g.a;
        a = z;
        b = z;
    }

    public static int a(String str, String str2) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.d(stringBuilder.toString(), str2);
    }

    public static int a(String str, String str2, Throwable th) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.d(stringBuilder.toString(), str2, th);
    }

    public static int b(String str, String str2) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.i(stringBuilder.toString(), str2);
    }

    public static int c(String str, String str2) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.w(stringBuilder.toString(), str2);
    }

    public static int d(String str, String str2) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.e(stringBuilder.toString(), str2);
    }

    public static int b(String str, String str2, Throwable th) {
        if (!g.a) {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder("RePlugin.");
        stringBuilder.append(str);
        return Log.e(stringBuilder.toString(), str2, th);
    }

    public static int e(String str, String str2) {
        if (!g.a) {
            return -1;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        StringBuilder stringBuilder = new StringBuilder("desc=, memory_v_0_0_1, process=, ");
        stringBuilder.append(b.a);
        stringBuilder.append(", totalPss=, ");
        stringBuilder.append(memoryInfo.getTotalPss());
        stringBuilder.append(", dalvikPss=, ");
        stringBuilder.append(memoryInfo.dalvikPss);
        stringBuilder.append(", nativeSize=, ");
        stringBuilder.append(memoryInfo.nativePss);
        stringBuilder.append(", otherPss=, ");
        stringBuilder.append(memoryInfo.otherPss);
        stringBuilder.append(", ");
        String stringBuilder2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("-MEMORY");
        str = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(stringBuilder2);
        stringBuilder.append(str2);
        return Log.i(str, stringBuilder.toString());
    }

    public static int a(PluginInfo pluginInfo, int i) {
        long length = pluginInfo.getApkFile().length();
        long length2 = pluginInfo.getDexFile().length();
        StringBuilder stringBuilder = new StringBuilder("act=, loadLocked, flag=, Start, pn=, ");
        stringBuilder.append(pluginInfo.getName());
        stringBuilder.append(", type=, ");
        stringBuilder.append(i);
        stringBuilder.append(", apk=, ");
        stringBuilder.append(length);
        stringBuilder.append(", odex=, ");
        stringBuilder.append(length2);
        stringBuilder.append(", sys_api=, ");
        stringBuilder.append(VERSION.SDK_INT);
        return e("RePlugin", stringBuilder.toString());
    }
}
