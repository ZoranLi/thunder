package com.xunlei.download;

import android.content.Context;

public class UpdateLibsSettingManager {
    public static final int LOAD_LIB_STAT_INIT = 0;
    public static final int LOAD_LIB_STAT_LOADED = 2;
    public static final int LOAD_LIB_STAT_NEED_RELOAD = 1;
    private static final String a = "downloadlib_update_setting";
    private static final String b = "update_stat";

    private UpdateLibsSettingManager() {
    }

    public static void setLoadLibStat(Context context, int i) {
        context.getSharedPreferences(a, 0).edit().putInt(b, i).apply();
    }

    public static int getLoadLibStat(Context context) {
        return context.getSharedPreferences(a, 0).getInt(b, 0);
    }
}
