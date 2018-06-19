package com.xunlei.common.androidutil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PreferenceHelper {
    private final SharedPreferences mPreferences;

    public PreferenceHelper(Context context, String str) {
        this.mPreferences = context.getSharedPreferences(str, 0);
    }

    public PreferenceHelper(Context context, String str, int i) {
        this.mPreferences = context.getSharedPreferences(str, i);
    }

    @Deprecated
    public void setLong(String str, long j) {
        putLong(str, j);
    }

    public void putLong(String str, long j) {
        Editor edit = this.mPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    public long getLong(String str, long j) {
        return this.mPreferences.getLong(str, j);
    }

    public void putInt(String str, int i) {
        Editor edit = this.mPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public int getInt(String str, int i) {
        return this.mPreferences.getInt(str, i);
    }

    @Deprecated
    public void setBoolean(String str, boolean z) {
        putBoolean(str, z);
    }

    public void putBoolean(String str, boolean z) {
        Editor edit = this.mPreferences.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean getBoolean(String str, boolean z) {
        return this.mPreferences.getBoolean(str, z);
    }

    @Deprecated
    public void setString(String str, String str2) {
        putString(str, str2);
    }

    public void putString(String str, String str2) {
        Editor edit = this.mPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String getString(String str, String str2) {
        return this.mPreferences.getString(str, str2);
    }

    public void remove(String str) {
        Editor edit = this.mPreferences.edit();
        edit.remove(str);
        edit.apply();
    }

    public static void writeIntToPref(Context context, String str, String str2, int i) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putInt(str2, i);
        context.apply();
    }

    public static int readIntFromPref(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getInt(str2, 0);
    }

    public static void writeLongToPref(Context context, String str, String str2, long j) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putLong(str2, j);
        context.apply();
    }

    public static void writeLongToPrefAndCommit(Context context, String str, String str2, long j) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putLong(str2, j);
        context.commit();
    }

    public static long readLongFromPref(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getLong(str2, 0);
    }

    public static void removeKeyFromPref(Context context, String str, String str2) {
        context = context.getSharedPreferences(str, 0).edit();
        context.remove(str2);
        context.apply();
    }

    public static void writeStringToPref(Context context, String str, String str2, String str3) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putString(str2, str3);
        context.apply();
    }

    public static String readStringFromPref(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, null);
    }
}
