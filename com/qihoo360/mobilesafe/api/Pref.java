package com.qihoo360.mobilesafe.api;

import android.content.SharedPreferences;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.g;
import java.util.Map;

public final class Pref {
    public static final String PREF_TEMP_FILE_PACM = "plugins_PACM";

    public static SharedPreferences getSharedPreferences(String str) {
        RePlugin.getConfig();
        return g.a().getSharedPreferences(str, 0);
    }

    public static SharedPreferences getDefaultSharedPreferences() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g.a().getPackageName());
        stringBuilder.append("_preferences");
        return getSharedPreferences(stringBuilder.toString());
    }

    public static SharedPreferences getTempSharedPreferences(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(".temp");
        return getSharedPreferences(stringBuilder.toString());
    }

    public static String ipcGet(String str, String str2) {
        return getTempSharedPreferences(PREF_TEMP_FILE_PACM).getString(str, str2);
    }

    public static void ipcSet(String str, String str2) {
        getTempSharedPreferences(PREF_TEMP_FILE_PACM).edit().putString(str, str2).commit();
    }

    public static Map<String, ?> ipcGetAll() {
        return getTempSharedPreferences(PREF_TEMP_FILE_PACM).getAll();
    }
}
